import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Consumer {
    public static void main(String[] args) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "Test name");
        jsonToSend.put("job", "Test job");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend);

        //Rest запросы
        String url = "https://reqres.in/api/users";
        String response = restTemplate.postForObject(url, request, String.class);
        System.out.println(response);

        url = "https://reqres.in/api/users?page=2";
        response = restTemplate.getForObject(url, String.class);
        System.out.println(response);

        PersonResponse response2 = restTemplate.getForObject(url, PersonResponse.class);
        assert response2 != null;
        System.out.println(response2.getData().get(0).getFirst_name());
        System.out.println(response2.getSupport());
        System.out.println(response2.getTotal_pages());

        //Парсим полученный JSON с помощью Jackson
        //ObjectMapper mapper = new ObjectMapper();
        //JsonNode obj = mapper.readTree(response);

        //System.out.println(obj.get("data"));
        //System.out.println(obj.get("data").get("email"));


    }
}
