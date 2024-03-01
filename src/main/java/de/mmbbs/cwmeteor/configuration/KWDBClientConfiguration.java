package de.mmbbs.cwmeteor.configuration;

import de.mmbbs.cwmeteor.api.KWDBClient;
import de.mmbbs.cwmeteor.properties.WebProperties;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class KWDBClientConfiguration {
    private final WebProperties webProperties;

    @Bean
    public KWDBClient kwdbClient() {
        return new KWDBClient(
                webProperties.getKwdbBaseUrl().toString(),
                webProperties.getUserAgent()
        );
    }
}
