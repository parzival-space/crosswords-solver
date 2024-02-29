package de.mmbbs.cwmeteor;

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

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<Solution> getAllSolutions() {
        return solutionRepository.findAll();
    }

    @GetMapping(path = "/search")
    @ResponseBody
    public Iterable<Solution> getSpecificSolutions(final String query) {
        return solutionRepository.findByQuestion(query);
    }
}
