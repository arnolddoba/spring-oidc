package co.saltpay.springoidc.controller;

import co.saltpay.springoidc.config.TokenManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class TestClientController {

    TokenManager tokenManager;
    @Value("${resource-url}")
    private String resourceUrl;
    RestTemplate restTemplate = new RestTemplate();

    public TestClientController(TokenManager tokenManager, RestTemplate restTemplate) {
        this.tokenManager = tokenManager;
        this.restTemplate = restTemplate;
    }

    @GetMapping("test-client")
    public String test() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + tokenManager.getAccessToken());
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                resourceUrl,
                HttpMethod.GET,
                request,
                String.class
        );
        return response.getBody();
    }




}
