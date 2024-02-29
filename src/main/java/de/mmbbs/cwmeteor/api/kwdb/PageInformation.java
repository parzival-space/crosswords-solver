package de.mmbbs.cwmeteor.api.kwdb;

import lombok.Getter;
import lombok.Setter;

/**
 * Information about the current solution page.
 * Since a query can have many solutions, they are split into multiple pages.
 */
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
