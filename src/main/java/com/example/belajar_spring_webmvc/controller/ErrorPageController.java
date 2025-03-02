package com.example.belajar_spring_webmvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<String> error(HttpServletRequest request) {
        Integer status = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        String html = """
                <html>
                <body>
                <h1>Error $status</h1>
                <p>$message</p>
                </body>
                </html>
                """.replace("$status", status.toString()).replace("$message", message);

        return ResponseEntity.status(status).body(html);
    }
}
