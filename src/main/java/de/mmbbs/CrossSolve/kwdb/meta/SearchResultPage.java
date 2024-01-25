package de.mmbbs.CrossSolve.kwdb.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchResultPage {
    private List<QuestionSolution> data;

    @JsonProperty("meta")
    private PageInformation page;
}
