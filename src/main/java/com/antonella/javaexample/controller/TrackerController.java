package com.antonella.javaexample.controller;

import java.io.*;
import static java.util.stream.Collectors.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class TrackerController {
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
		File f = new File("/tmp/ok");
        if(f.exists() && !f.isDirectory()) { 
            return ResponseEntity.ok("OK");
        }

        return ResponseEntity
            .status(HttpStatus.SERVICE_UNAVAILABLE)
            .body("Service unavailable");
	}

	@GetMapping("/img")
	public ResponseEntity<String> img(HttpServletRequest request) {
        String logInfo = String.format(
            "URL: %s | Requester: %s | HTTP Method: %s | QueryStringParams: %s",
            request.getRequestURL(), 
            request.getRemoteAddr(),
            request.getMethod(),
            request.getQueryString()
        );

        log.info(logInfo);
        return ResponseEntity.ok("OK");
	}
}