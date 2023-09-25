package de.mmbbs.CrossSolve.Extern;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class CWDB {

    public static String URL = "https://api.kwdb.ch/api";

    public List<String> getSoluation(String question, int charcterLength){
        List<String> resultList = new ArrayList<>();
        String url_extend = String.format("/search?q=%s&lc=%d", question, charcterLength) ;
        String resourceUrl = CWDB.URL + url_extend;

        // Make the GET request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl + "/1", String.class);

        // Check if the response is successful (status code 200 OK)
        if (response.getStatusCode().value() == 200) {
            try {
                // Parse the JSON response using Jackson
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(response.getBody());

                // Get the "data" field from the JSON
                JsonNode dataArray = rootNode.get("data");
                if (dataArray != null && dataArray.isArray() && dataArray.size() > 0) {
                    // Get the all object in the "data" array
                    for (int i = 0; i < dataArray.size(); i++) {
                        JsonNode firstObject = dataArray.get(i);
                        resultList.add(firstObject.get("answer").asText());
                    }
                    return resultList;
                } else {
                    System.out.println("No data found or empty data array.");
                    return resultList;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Handle the case where the request was not successful
            System.out.println("Request failed with status code: " + response.getStatusCode().value());
            return resultList;
        }
        return resultList;
    }

    
}
