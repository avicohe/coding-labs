package com.avi.cohen.greeting.card.rests.model.io;

import java.io.Serializable;

public class CreateGreetingCardRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer templateId;
	private Object[] blanksValues;

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public Object[] getBlanksValues() {
		return blanksValues;
	}

	public void setBlanksValues(Object[] blanksValues) {
		this.blanksValues = blanksValues;
	}
}
