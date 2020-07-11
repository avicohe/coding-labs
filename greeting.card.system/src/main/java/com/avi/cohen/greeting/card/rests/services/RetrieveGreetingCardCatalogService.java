package com.avi.cohen.greeting.card.rests.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avi.cohen.greeting.card.rests.model.io.RetrieveGreetingCardCatalogResponse;
import com.avi.cohen.greeting.card.rests.model.vo.Template;
import com.avi.cohen.greeting.card.rests.services.base.GreetingCardServiceBase;
import com.avi.cohen.greeting.card.rests.services.repo.GreetingCardRepository;

@Service
public class RetrieveGreetingCardCatalogService extends
		GreetingCardServiceBase<RetrieveGreetingCardCatalogResponse> {
	private List<Template> templates;
	@Autowired
	private GreetingCardRepository greetingCardRepository;

	@Override
	protected void preExecutionHook() {
	}

	@Override
	protected void executeOperationImpl() {
		templates = new ArrayList<Template>();
		Iterable<Template> templateIterable = greetingCardRepository.findAll();
		for (Template template : templateIterable) {
			templates.add(template);
		}
	}

	@Override
	protected RetrieveGreetingCardCatalogResponse postExecutionHook() {
		RetrieveGreetingCardCatalogResponse greetingSystemCatalogResponse = new RetrieveGreetingCardCatalogResponse();
		greetingSystemCatalogResponse.setTemplates(templates);
		return greetingSystemCatalogResponse;
	}
}
