package com.ecommerce.inditex.apirest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ecommerce.inditex.apirest.controllers.ExceptionHandlerController;
import com.ecommerce.inditex.domain.exceptions.InvalidRequestException;
import com.ecommerce.model.ErrorResponseDTO;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.lang.reflect.Method;

/**
 * Unit tests for ExceptionHandlerController.
 */
class ExceptionHandlerControllerTest {

    /** The exception handler controller. */
    private final ExceptionHandlerController exceptionHandlerController = new ExceptionHandlerController();

    /**
     * Test handle invalid request.
     */
    @Test
    void testHandleInvalidRequest() {
        // GIVEN
        String errorMessage = "Invalid input data.";
        InvalidRequestException exception = new InvalidRequestException(errorMessage);

        // WHEN
        ResponseEntity<ErrorResponseDTO> response = exceptionHandlerController.handleInvalidRequest(exception);

        // THEN
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Invalid Request", response.getBody().getTitle());
        assertEquals(errorMessage, response.getBody().getDetail());
    }

    /**
     * Test handle type mismatch.
     *
     * @throws NoSuchMethodException the no such method exception
     */
    @Test
    void testHandleTypeMismatch() throws NoSuchMethodException {
        // GIVEN
        String parameterName = "productId";
        Class<?> requiredType = Integer.class;

        Method method = this.getClass().getMethod("dummyMethod", String.class);
        MethodArgumentTypeMismatchException exception = 
            new MethodArgumentTypeMismatchException(null, requiredType, parameterName, null, new IllegalArgumentException());

        // WHEN
        ResponseEntity<ErrorResponseDTO> response = exceptionHandlerController.handleTypeMismatch(exception);

        // THEN
        String expectedDetail = "Parameter 'productId' should be of type Integer";
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Type Mismatch", response.getBody().getTitle());
        assertEquals(expectedDetail, response.getBody().getDetail());
    }

    /**
     * Test handle unexpected error.
     */
    @Test
    void testHandleUnexpectedError() {
        // GIVEN
        String errorMessage = "Something went wrong.";
        Exception exception = new Exception(errorMessage);

        // WHEN
        ResponseEntity<ErrorResponseDTO> response = exceptionHandlerController.handleUnexpectedError(exception);

        // THEN
        assertEquals(500, response.getStatusCodeValue());
        assertEquals("Internal server error", response.getBody().getTitle());
        assertEquals(errorMessage, response.getBody().getDetail());
    }

    /**
     * Dummy method.
     *
     * @param arg the arg
     */
    public void dummyMethod(String arg) {}
}