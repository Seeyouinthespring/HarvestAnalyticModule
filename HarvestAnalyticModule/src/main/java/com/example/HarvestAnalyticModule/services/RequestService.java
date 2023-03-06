package com.example.HarvestAnalyticModule.services;

import com.example.HarvestAnalyticModule.models.server.Component;
import com.example.HarvestAnalyticModule.models.server.Type;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;


public class RequestService {
    public Component getComponent(String id, String token) {
        Component response = RestService.getWebClient().get()
                .uri("api/components/" + id + "?fullHierarchy=true")
                .headers(httpHeaders -> {httpHeaders.set("user-token", token);})
                .retrieve()
                .bodyToMono(Component.class)
                .block();

        return response;
    }

    public List<Type> getTypes(String token) {
        List<Type> response = RestService.getWebClient().get()
                .uri("api/components/types/" )
                .headers(httpHeaders -> {httpHeaders.set("user-token", token);})
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Type>>() {})
                .block();
        return response;
    }
}
