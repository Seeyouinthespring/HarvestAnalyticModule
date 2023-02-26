package com.example.HarvestAnalyticModule.controllers;

import com.example.HarvestAnalyticModule.models.view.Statistic;
import com.example.HarvestAnalyticModule.services.AnalyseService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AnalyticController {

    @RequestMapping(value = "/analytics/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Statistic getCityById(@PathVariable String id){
        AnalyseService service = new AnalyseService();
        return service.getAnalytic(id);
    }
}
