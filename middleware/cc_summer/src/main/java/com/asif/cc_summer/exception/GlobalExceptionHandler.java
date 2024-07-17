package com.asif.cc_summer.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@Primary
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> defaultErrorHandler(Exception e, HttpServletRequest request) {
        String message = e.getMessage();
        String requestURI = request.getRequestURI();
//        if (StringUtils.contains(requestURI, "/admin/")) {
//            log.error("Error: clientId: {}, URL: {}, Method:{}, Message: {}", request.getHeader(BaseService.CF_CLIENT_ID), requestURI, request.getMethod(), message);
//
//        } else {
//            log.error("Error: sessionId: {}, URL: {}, Method:{}, Message: {}", request.getHeader(BaseService.CF_SESSION_ID), requestURI, request.getMethod(), message);
//        }
//
//        var response = Response.builder();
//        response.status(ResponseStatus.ERROR);
//        response.message("Internal server error. Please contract CloudFrame support team.");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Occrued");
    }
}