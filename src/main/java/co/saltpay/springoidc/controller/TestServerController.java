package co.saltpay.springoidc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestServerController {

    @GetMapping("test-server")
    public String test(@RequestHeader("Authorization") String authorizationHeader) {
        log.info("Auth header received: {}", authorizationHeader);
        return "Auth header forwarded - " + authorizationHeader;
    }




}
