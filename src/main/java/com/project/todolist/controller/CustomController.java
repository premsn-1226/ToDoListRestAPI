package com.project.todolist.controller;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomController extends BasicErrorController {

    public CustomController(ServerProperties serverproperties) {
        super(new DefaultErrorAttributes(), serverproperties.getError());
    }

    @Override
    public ResponseEntity error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        if (status.equals(HttpStatus.INTERNAL_SERVER_ERROR)){
            return ResponseEntity.status(status).body("Api");
        }else if (status.equals(HttpStatus.BAD_REQUEST)){
            return ResponseEntity.status(status).body("Api");
        }
        return super.error(request);
    }
}