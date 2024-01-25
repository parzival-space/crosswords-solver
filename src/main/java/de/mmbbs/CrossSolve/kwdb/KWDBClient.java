package de.mmbbs.CrossSolve.kwdb;

import de.mmbbs.CrossSolve.kwdb.meta.QuestionSolution;
import de.mmbbs.CrossSolve.kwdb.meta.SearchResultPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class KWDBClient {

    private final RestTemplate client;

    /**
     * API Client for the KWDB
     * <a href="https://www.kwdb.ch/">https://www.kwdb.ch/</a>
     */
    public KWDBClient() {
        this.client = new RestTemplateBuilder()
                .rootUri("https://api.kwdb.ch/api")
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.USER_AGENT, "Crosswords Solver (https://github.com/parzival-space/crosswords-solver)")
                .build();
    }

    /**
     * Searches for all possible results of the given query.
     */
    private SearchResultPage searchForResults(String query, int characters, int page) {
        String path = "/search" + "?q=" + query + (characters > 0 ? "&lc=" + characters : "") + (page > 0 ? "&page=" + page : "");

        ResponseEntity<SearchResultPage> result = this.client.getForEntity(path, SearchResultPage.class);
        if (result.getBody() == null) {
            throw new RuntimeException("Failed to fetch all results for the query '" + query + "'!");
        }

        return result.getBody();
    }

    /**
     * Trys to fetch all possible solutions for a specific query.
     * You can optionally provide a character length for the answer.
     * @param query The question you want an answer for.
     * @param characters (optional) Limits the length of the possible solutions. Use 0 if not given.
     */
    public List<QuestionSolution> getSolutions(String query, int characters) {
        int currentPage = 1;
        int lastPage;

        // store all solutions
        List<QuestionSolution> solutions = new ArrayList<>();

        // fetch all pages
        do {
            SearchResultPage currentResults = this.searchForResults(query, characters, currentPage);

            // update page info
            currentPage = currentResults.getPage().getCurrentPage();
            lastPage = currentResults.getPage().getLastPage();

            // append results
            solutions.addAll(currentResults.getData());
        }
        while (currentPage < lastPage);

        return solutions;
    }
}
