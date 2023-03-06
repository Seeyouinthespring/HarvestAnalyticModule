package com.example.HarvestAnalyticModule.controllers;

import com.example.HarvestAnalyticModule.models.view.Statistic;
import com.example.HarvestAnalyticModule.services.AnalyseService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AnalyticController {

    @RequestMapping(value = "/analytics/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Statistic getCityById(@PathVariable String id, @RequestHeader("user-token") String token){
        AnalyseService service = new AnalyseService();
        return service.getAnalytic(id, token);
    }
}
