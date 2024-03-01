package de.mmbbs.cwmeteor.db;

import de.mmbbs.cwmeteor.db.entities.Solution;
import de.mmbbs.cwmeteor.db.repositories.SolutionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@AllArgsConstructor
public class DBCleanupTask implements InitializingBean {
    private final SolutionRepository solutionRepository;

    /**
     * Scans for duplicated entries in the solution table and removes them.
     * They are not really a problem, but they bloat responses send by the REST api.
     * This is a temporary fix and shouldn't be needed when the program becomes more stable.
     */
    @Override
    public void afterPropertiesSet() {
        Set<String> seenSolutions = new HashSet<>();

        // find duplicated solutions in the database.
        List<Solution> duplicates = StreamSupport.stream(solutionRepository.findAll().spliterator(), true)
                .filter(s -> !seenSolutions.add(String.format("%s/%s%s", s.getQuestion(), s.getAnagram(), s.getAnagram())))
                .toList();
        log.info("Cleanup found {} duplicated solution entries.", duplicates.size());

        solutionRepository.deleteAll(duplicates);
    }
}
