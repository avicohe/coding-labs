package com.avi.cohen.greeting.card.rests.model.io;

import java.io.Serializable;
import java.util.List;

import com.avi.cohen.greeting.card.rests.model.vo.Template;

public class RetrieveGreetingCardCatalogResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Template> templates;

	public List<Template> getTemplates() {
		return templates;
	}

	public void setTemplates(List<Template> templates) {
		this.templates = templates;
	}
}
