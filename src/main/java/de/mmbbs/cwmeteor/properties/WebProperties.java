package de.mmbbs.cwmeteor.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@Setter @Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "meteor.web")
public class WebProperties {

    /**
     * A User-Agent sent along the requests. Some APIs may require this.
     */
    private String userAgent = "crossword-solver / 1.0.0 (https://github.com/parzival-space/crosswords-solver)";

    /**
     * The base URL of the https://kwdb.ch API.
     */
    private URI kwdbBaseUrl = URI.create("https://api.kwdb.ch/api");
}
