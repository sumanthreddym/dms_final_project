package com.sumanth.healthinsurance.web.controllers;

import com.sumanth.healthinsurance.model.QuoteRequest;
import com.sumanth.healthinsurance.service.QuoteRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Slf4j
public class HomeController {
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/support_dashboard")
    public String supportDashboard() {
        return "support_dashboard";
    }
}
