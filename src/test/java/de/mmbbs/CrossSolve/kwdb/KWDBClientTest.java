package de.mmbbs.CrossSolve.kwdb;

import static org.junit.jupiter.api.Assertions.assertFalse;

import de.mmbbs.CrossSolve.kwdb.meta.QuestionSolution;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
class KWDBClientTest {

    @Test
    public void TestKWDB() {
        KWDBClient client = new KWDBClient();

        // Question
        final String query = "Früchte zum Auflesen";

        // ask kwdb
        List<QuestionSolution> solutions = client.getSolutions(query, 0);

        log.info("Found {} solution(s) for the query '{}'", solutions.size(), query);
        assertFalse(solutions.isEmpty());
    }
}
