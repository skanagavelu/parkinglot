package com.example.parking.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("version")
public class VersionController {

    private static final String outputFormat = "{  \"version\" : \"1.0.0\" }";

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getVersion() {

        return new ResponseEntity(outputFormat, null, HttpStatus.OK);
    }
}