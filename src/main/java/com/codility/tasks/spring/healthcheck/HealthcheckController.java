package com.codility.tasks.spring.healthcheck;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

@RestController
public class HealthcheckController {

    @GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> healthcheck(@RequestParam String format) throws ParseException {
        if (format.equals("short")) {
            SingleStatus status = new SingleStatus(HttpStatus.OK.getReasonPhrase());
            return new ResponseEntity<>(status, HttpStatus.OK);
        } else if (format.equals("full")) {
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            String formattedDate = outputFormat.format(new Date());
            Status status = new Status(formattedDate, HttpStatus.OK.getReasonPhrase());
            return new ResponseEntity<>(status, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(value = "/healthcheck")
    public ResponseEntity<?> healthcheckPut() {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @PostMapping(value = "/healthcheck")
    public ResponseEntity<?> healthcheckPost() {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }


    @DeleteMapping(value = "/healthcheck")
    public ResponseEntity<?> healthcheckDelete() {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }
}