package com.example.HarvestAnalyticModule.services;

import com.example.HarvestAnalyticModule.models.RestError;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
public class RestService {

    private static WebClient webClient;

    public static WebClient getWebClient() {
        return webClient;
    }

    public RestService(@Value("${URL}") String uri, @Value("${TOKEN}") String token){
        webClient = WebClient
                .builder()
                //.filter(ExchangeFilterFunction.ofResponseProcessor(this::handler))
                .baseUrl(uri)
                .defaultHeader("user-token", token)
                .build();
    }
    
    private Mono<ClientResponse> handler(ClientResponse clientResponse) {
        if(clientResponse.statusCode().isError()){
            return clientResponse.bodyToMono(RestError.class)
                    .flatMap(apiErrorResponse -> Mono.error(new ResponseStatusException(
                            clientResponse.statusCode(),
                            apiErrorResponse.getCode()
                    )));
        }
        return Mono.just(clientResponse);
    }
    
}
