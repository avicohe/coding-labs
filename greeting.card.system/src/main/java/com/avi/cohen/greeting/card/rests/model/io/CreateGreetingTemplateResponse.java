package com.avi.cohen.greeting.card.rests.model.io;

import java.io.Serializable;

import com.avi.cohen.greeting.card.rests.model.vo.Template;

public class CreateGreetingTemplateResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private Template template;

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}
}
