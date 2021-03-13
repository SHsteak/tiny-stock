package com.ts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	static final String ERROR_MESSAGE_CUSTOM = "Error code ===> ";

	// 400
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleLineException(
			final RuntimeException error) {
		log.warn("error", error);
		return ResponseEntity.badRequest().body(ERROR_MESSAGE_CUSTOM + "400");

	}

	// 401
	@ExceptionHandler({AccessDeniedException.class})
	public ResponseEntity<Object> handleAccessDeniedException(
			final AccessDeniedException ex) {
		log.warn("error", ex);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
				.body(ex.getMessage());
	}

	// 500
	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleAll(final Exception ex) {
		log.info(ex.getClass().getName());
		log.error("error", ex);
		return new ResponseEntity<>(ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
