package de.mmbbs.CrossSolve.kwdb;

import static org.junit.jupiter.api.Assertions.assertFalse;

import de.mmbbs.CrossSolve.kwdb.meta.QuestionSolution;
import org.junit.jupiter.api.Test;

import java.util.List;

class KWDBClientTest {

    @Test
    public void TestKWDB() {
        KWDBClient client = new KWDBClient();

        // ask kwdb
        List<QuestionSolution> solutions = client.getSolutions("Früchte zum Auflesen", 0);

        assertFalse(solutions.isEmpty());
    }
}
