package com.ecommerce.inditex.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class InvalidRequestException.
 */
@AllArgsConstructor
@Getter
@Setter
public class InvalidRequestException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	private String message;

}

