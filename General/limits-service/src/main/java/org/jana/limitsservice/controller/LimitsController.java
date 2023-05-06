package org.jana.limitsservice.controller;

import org.jana.limitsservice.bean.Limits;
import org.jana.limitsservice.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private AppConfig appConfig;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
//        return new Limits(1, 100);
        return new Limits(
                appConfig.getMinimum(),
                appConfig.getMaximum()
        );
    }

}
