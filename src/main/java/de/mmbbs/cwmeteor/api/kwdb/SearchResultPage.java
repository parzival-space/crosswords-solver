package de.mmbbs.cwmeteor.api.kwdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * A single page containing solutions for a given crossword query.
 */
@Getter
@Setter
public class SearchResultPage {
    private List<QuestionSolution> data;

    @JsonProperty("meta")
    private PageInformation page;
}
