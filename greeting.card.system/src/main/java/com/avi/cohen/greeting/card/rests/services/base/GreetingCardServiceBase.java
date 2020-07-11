package com.avi.cohen.greeting.card.rests.services.base;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class GreetingCardServiceBase<O> {
	protected abstract void preExecutionHook();

	protected abstract void executeOperationImpl();

	protected abstract O postExecutionHook();

	public O executeOperation() {
		preExecutionHook();
		executeOperationImpl();
		return postExecutionHook();
	}

	protected void validateNullOrEmpty(Object value, String message) {
		if (null == value) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
		}
	}

	protected void validateNullOrEmpty(Object[] values, String message) {
		if (null == values || values.length == 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
		}
	}
}
