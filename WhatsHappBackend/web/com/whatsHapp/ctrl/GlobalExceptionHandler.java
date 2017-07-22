package com.whatsHapp.ctrl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.whatsHapp.util.exception.CustomGenericException;
import com.whatsHapp.util.validation.FieldErrorDTO;
import com.whatsHapp.util.validation.FieldErrorDTOList;

@ControllerAdvice
@RestController

public class GlobalExceptionHandler {

	private static final String GENERIC_EXCEPTION_OCCURED = "generic exception occured";

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private FieldErrorDTOList fieldErrorDTOList;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void setFieldErrorDTOList(FieldErrorDTOList fieldErrorDTOList) {
		this.fieldErrorDTOList = fieldErrorDTOList;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	@ExceptionHandler
	public ResponseEntity<FieldErrorDTOList> handle(MethodArgumentNotValidException exception) {
		BindingResult result = exception.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		FieldErrorDTOList dto = processFieldErrors(fieldErrors);
		return new ResponseEntity<FieldErrorDTOList>(dto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public Map handle(ConstraintViolationException exception) {

		return error(exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.toList()));
	}

	private Map error(Object message) {
		return Collections.singletonMap("error", message);
	}

	private FieldErrorDTOList processFieldErrors(List<FieldError> fieldErrors) {
		List<FieldErrorDTO> fieldErrorsLst = new ArrayList<>();
		for (FieldError fieldError : fieldErrors) {
			String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
			FieldErrorDTO error = new FieldErrorDTO(fieldError.getField(), localizedErrorMessage);
			fieldErrorsLst.add(error);
		}
		fieldErrorDTOList.setFieldErrors(fieldErrorsLst);

		return fieldErrorDTOList;
	}

	private String resolveLocalizedErrorMessage(FieldError fieldError) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);

		if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
			String[] fieldErrorCodes = fieldError.getCodes();
			localizedErrorMessage = fieldErrorCodes[0];
		}

		return localizedErrorMessage;
	}

	// @ExceptionHandler
	// public ResponseEntity<FieldErrorDTOList> handle(MediaNotValidException
	// exception) {
	// BindingResult result = exception.getBindingResult();
	// List<FieldError> fieldErrors = result.getFieldErrors();
	// FieldErrorDTOList dto= processFieldErrors(fieldErrors);
	// return new ResponseEntity<FieldErrorDTOList>(dto,
	// HttpStatus.BAD_REQUEST);
	// }

//	@ExceptionHandler(CustomGenericException.class)
//	public ResponseEntity<FieldErrorDTOList> handleCustomException(CustomGenericException ex) {
//		List<FieldErrorDTO> fieldErrors = new ArrayList<>();
//		FieldErrorDTO fieldError = new FieldErrorDTO(ex.getErrCode(), ex.getErrMsg());
//		fieldErrors.add(fieldError);
//		fieldErrorDTOList.setFieldErrors(fieldErrors);
//		return new ResponseEntity<FieldErrorDTOList>(fieldErrorDTOList, HttpStatus.BAD_REQUEST);
//
//	}
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<FieldErrorDTOList> handleAllException(Exception ex) {
//		List<FieldErrorDTO> fieldErrors = new ArrayList<>();
//		FieldErrorDTO fieldError = new FieldErrorDTO(GENERIC_EXCEPTION_OCCURED, ex.getMessage());
//		fieldErrors.add(fieldError);
//		fieldErrorDTOList.setFieldErrors(fieldErrors);
//		return new ResponseEntity<FieldErrorDTOList>(fieldErrorDTOList, HttpStatus.BAD_REQUEST);
//
//	}

}