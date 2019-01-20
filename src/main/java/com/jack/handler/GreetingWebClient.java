package com.jack.handler;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Description
 * <p>
 * </p>
 * DATE 2018/3/9.
 *
 * @author liweijian.
 */
public class GreetingWebClient {

//    private WebClient webClient = WebClient.create("http://localhost:8080");
//
//    private Mono<ClientResponse> result = webClient.get()
//            .uri("/hello")
//            .accept(MediaType.TEXT_PLAIN)
//            .exchange();
//
//    public String getResult() {
//        return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
//    }
}
