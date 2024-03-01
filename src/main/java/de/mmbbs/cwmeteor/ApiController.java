package de.mmbbs.cwmeteor;

import de.mmbbs.cwmeteor.api.KWDBClient;
import de.mmbbs.cwmeteor.api.kwdb.QuestionSolution;
import de.mmbbs.cwmeteor.db.entities.Solution;
import de.mmbbs.cwmeteor.db.repositories.SolutionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping(path = "/api")
public class ApiController {
    private final SolutionRepository solutionRepository;
    private final KWDBClient kwdbClient;

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<Solution> getAllSolutions() {
        return solutionRepository.findAll();
    }

    @GetMapping(path = "/search")
    @ResponseBody
    public Iterable<Solution> getSpecificSolutions(final String query, final Integer characters) {
        List<Solution> solutions = (characters == null || characters <= 0 ) ?
                solutionRepository.findByQuestion(query) :
                solutionRepository.findByQuestionAndCharacterCount(query, characters);

        // get solutions from KWDB if nothing has been found in the cache
        if (solutions.isEmpty()) {
            log.info("Searching local cache for '{}' resulted in zero results. Searching KWDB...", query);

            // query KWDB
            List<QuestionSolution> questionSolutions = (characters == null || characters <= 0 ) ?
                    kwdbClient.getSolutions(query) :
                    kwdbClient.getSolutions(query, characters);

            // translate type QuestionSolution to Solution
            questionSolutions.stream()
                    .map(questionSolution -> new Solution(
                            questionSolution.getId(), // FIXME: KWDB UUID are not consistent
                            questionSolution.getQuestion(),
                            questionSolution.getAnswer(),
                            questionSolution.getAnagram()
                    ))
                    .forEach(solutions::add);

            // update db
            solutionRepository.saveAll(solutions);
        }

        return solutions;
    }
}
