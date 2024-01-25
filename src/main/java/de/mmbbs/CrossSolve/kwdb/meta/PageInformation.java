package de.mmbbs.CrossSolve.kwdb.meta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageInformation {
    public int currentPage;
    public long from;
    public int lastPage;
    public int perPage;
    public long to;
    public long total;
}
