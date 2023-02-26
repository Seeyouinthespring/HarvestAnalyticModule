package com.example.HarvestAnalyticModule.services;

import com.example.HarvestAnalyticModule.models.server.Component;
import com.example.HarvestAnalyticModule.models.server.Type;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;


public class RequestService {

    public Component getComponent(String id) {
        Component response = RestService.getWebClient().get()
                .uri("api/components/" + id + "?fullHierarchy=true")
                .retrieve()
                .bodyToMono(Component.class)
                .block();

        return response;
    }

//    public static List<Type> getTypes() {
//        Type[] response = RestService.getWebClient().get()
//                .uri("api/types/" )
//                .retrieve()
//                .bodyToMono(Type[].class)
//                .block();
//        return Arrays.stream(response)
//                .map(Type:getFavouriteBook).collect(Collectors.toList());
//        //return response;
//    }

    public List<Type> getTypes() {
        List<Type> response = RestService.getWebClient().get()
                .uri("api/components/types/" )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Type>>() {})
                .block();
        return response;
    }
}
