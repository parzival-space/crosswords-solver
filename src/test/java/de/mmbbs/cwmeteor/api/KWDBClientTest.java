package de.mmbbs.cwmeteor.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.mmbbs.cwmeteor.api.kwdb.PageInformation;
import de.mmbbs.cwmeteor.api.kwdb.QuestionSolution;
import de.mmbbs.cwmeteor.api.kwdb.SearchResultPage;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import java.lang.reflect.Field;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

@Slf4j
public class KWDBClientTest {

    @SneakyThrows
    @Test
    public void getSolutionsTest() {
        final String mockBaseUrl = "https://mock.kwdb.ch/api";
        final String mockQuery = "Mock Query";;

        KWDBClient client = new KWDBClient(mockBaseUrl, "Mock KWDB Client");

        // make private field accessible for testing
        Field restTemplateField = KWDBClient.class.getDeclaredField("client");
        restTemplateField.setAccessible(true);
        RestTemplate clientRestTemplate = (RestTemplate) restTemplateField.get(client);

        // create fake response data
        QuestionSolution fakeSolution = new QuestionSolution();
        fakeSolution.setId(UUID.randomUUID());
        fakeSolution.setAnswer("Mock Answer");
        PageInformation fakeInformation = new PageInformation();
        fakeInformation.setCurrentPage(1);
        fakeInformation.setLastPage(1);
        SearchResultPage fakeResultPage = new SearchResultPage();
        fakeResultPage.setData(List.of(fakeSolution));
        fakeResultPage.setPage(fakeInformation);

        // create fake KWDB server
        final String finalApiRequest = mockBaseUrl + String.format("/search?q=%s&page=1", URLEncoder.encode(mockQuery, StandardCharsets.UTF_8));
        MockRestServiceServer server = MockRestServiceServer.createServer(clientRestTemplate);
        server.expect(ExpectedCount.once(), requestTo(new URI(finalApiRequest)))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(new ObjectMapper().writeValueAsString(fakeResultPage))
        );

        // try sending the request
        List<QuestionSolution> respSolutions = client.getSolutions(mockQuery);
        server.verify();
        assertEquals(respSolutions.get(0).getAnswer(), fakeSolution.getAnswer());

        log.info("Success! Mocked request responded answer ('{}') was the same as expected '{}'", respSolutions.get(0).getAnswer(), fakeSolution.getAnswer());
    }
}
