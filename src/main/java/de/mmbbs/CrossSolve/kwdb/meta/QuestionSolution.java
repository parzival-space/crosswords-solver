package de.mmbbs.CrossSolve.kwdb.meta;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class QuestionSolution {
    private UUID id;
    private long authorID;
    private String question;
    private String answer;
    private String anagram;
    private long verified;
    private Object verifiedBy;
    private long delete;
}
