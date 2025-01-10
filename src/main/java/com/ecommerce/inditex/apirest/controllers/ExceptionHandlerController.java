package com.ecommerce.inditex.apirest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.ecommerce.inditex.domain.exceptions.InvalidRequestException;
import com.ecommerce.model.ErrorResponseDTO;

/**
 * The Class ExceptionHandlerController.
 */
@ControllerAdvice
public class ExceptionHandlerController {

	/**
	 * Handle invalid request.
	 *
	 * @param ex the ex
	 * @return the response entity
	 */
	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<ErrorResponseDTO> handleInvalidRequest(InvalidRequestException ex) {
		
		ErrorResponseDTO ErrorResponseDTO = com.ecommerce.model.ErrorResponseDTO.builder()
				.code( HttpStatus.BAD_REQUEST.value())
				.title("Invalid Request")
				.detail(ex.getMessage())
				.build();
				
		return new ResponseEntity<>(ErrorResponseDTO, HttpStatus.BAD_REQUEST);
	}

	/**
     * Handle type mismatch.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponseDTO> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        
    	String detail = String.format("Parameter '%s' should be of type %s", ex.getName(), ex.getRequiredType().getSimpleName());
       
    	new ErrorResponseDTO();
		ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
        		.code( HttpStatus.BAD_REQUEST.value())
        		.title("Type Mismatch")
        		.detail(detail)
				.build();

        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }

	/**
	 * Handle unexpected error.
	 *
	 * @param ex the ex
	 * @return the response entity
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDTO> handleUnexpectedError(Exception ex) {
		
		new ErrorResponseDTO();
		ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
        		.code( HttpStatus.INTERNAL_SERVER_ERROR.value())
        		.title("Internal server error")
        		.detail(ex.getMessage())
				.build();
		
		return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
