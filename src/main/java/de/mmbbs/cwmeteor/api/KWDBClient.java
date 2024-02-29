package de.mmbbs.cwmeteor.api;

import de.mmbbs.cwmeteor.api.kwdb.QuestionSolution;
import de.mmbbs.cwmeteor.api.kwdb.SearchResultPage;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class KWDBClient {

    private final RestTemplate client;

    /**
     * API Client for the KWDB
     * <a href="https://www.kwdb.ch/">https://www.kwdb.ch/</a>
     * @param rootURI The API root URI
     * @param userAgent The User Agent sent with every API request
     */
    public KWDBClient(final String rootURI, final String userAgent) {
        this.client = new RestTemplateBuilder()
                .rootUri(rootURI)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.USER_AGENT, userAgent)
                .build();
    }

    /**
     * API Client for the KWDB
     * <a href="https://www.kwdb.ch/">https://www.kwdb.ch/</a>
     */
    public KWDBClient() {
        this("https://api.kwdb.ch/api", "KWDB Api Client");
    }

    /**
     * Searches for all possible results of the given query.
     */
    private SearchResultPage searchForResults(final String query, final int characters, final int page) {
        // create the request url string
        StringBuilder pathBuilder = new StringBuilder("/search?q=").append(URLEncoder.encode(query, StandardCharsets.UTF_8));

        // set character count and page number if set
        if (characters > 0) pathBuilder.append("&lc=").append(characters);
        if (page > 0) pathBuilder.append("&page=").append(page);

        // send request
        ResponseEntity<SearchResultPage> resultPageResponseEntity = this.client.getForEntity(pathBuilder.toString(), SearchResultPage.class);
        if (!resultPageResponseEntity.hasBody()) {
            throw new RuntimeException("Failed to fetch all results for the query '" + query + "'!");
        }

        return resultPageResponseEntity.getBody();
    }

    /**
     * Trys to fetch all possible solutions for a specific query.
     * You can optionally provide a character length for the answer.
     * @param query The question you want an answer for.
     * @param characters (optional) Limits the amount of the characters for the possible solutions.
     */
    public List<QuestionSolution> getSolutions(final String query, final int characters) {
        int currentPage = 1;
        int lastPage;

        // store all solutions
        List<QuestionSolution> solutions = new ArrayList<>();

        // fetch all pages
        do {
            SearchResultPage currentResults = this.searchForResults(query, characters, currentPage);

            // get next page number
            currentPage = currentResults.getPage().getCurrentPage();
            lastPage = currentResults.getPage().getLastPage();

            solutions.addAll(currentResults.getData());
        }
        while (currentPage < lastPage);

        return solutions;
    }

    /**
     * Trys to fetch all possible solutions for a specific query.
     * You can optionally provide a character length for the answer.
     * @param query The question you want an answer for.
     */
    public List<QuestionSolution> getSolutions(final String query) {
        return this.getSolutions(query, 0);
    }
}
