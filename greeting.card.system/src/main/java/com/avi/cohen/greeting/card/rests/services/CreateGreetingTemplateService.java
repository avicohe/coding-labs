package com.avi.cohen.greeting.card.rests.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avi.cohen.greeting.card.rests.model.io.CreateGreetingTemplateRequest;
import com.avi.cohen.greeting.card.rests.model.io.CreateGreetingTemplateResponse;
import com.avi.cohen.greeting.card.rests.model.vo.Template;
import com.avi.cohen.greeting.card.rests.services.base.GreetingCardServiceBase;
import com.avi.cohen.greeting.card.rests.services.error.GreetingCardErrorMessages;
import com.avi.cohen.greeting.card.rests.services.repo.GreetingCardRepository;

@Service
public class CreateGreetingTemplateService extends
		GreetingCardServiceBase<CreateGreetingTemplateResponse> {
	private CreateGreetingTemplateRequest createGreetingTemplateRequest;
	@Autowired
	private GreetingCardRepository greetingCardRepository;
	private Template updatedTemplate;

	@Override
	protected void preExecutionHook() {
		validateNullOrEmpty(createGreetingTemplateRequest.getTemplate(),
				GreetingCardErrorMessages.INVALID_TEMPLATE_CONTENT);
		validateNullOrEmpty(createGreetingTemplateRequest.getTemplate()
				.getContent(),
				GreetingCardErrorMessages.INVALID_TEMPLATE_CONTENT);
	}

	@Override
	protected void executeOperationImpl() {
		updatedTemplate = greetingCardRepository
				.save(createGreetingTemplateRequest.getTemplate());
	}

	@Override
	protected CreateGreetingTemplateResponse postExecutionHook() {
		CreateGreetingTemplateResponse createGreetingTemplateResponse = new CreateGreetingTemplateResponse();
		createGreetingTemplateResponse.setTemplate(updatedTemplate);
		return createGreetingTemplateResponse;
	}

	public void setCreateGreetingTemplateRequest(
			CreateGreetingTemplateRequest createGreetingTemplateRequest) {
		this.createGreetingTemplateRequest = createGreetingTemplateRequest;
	}
}
