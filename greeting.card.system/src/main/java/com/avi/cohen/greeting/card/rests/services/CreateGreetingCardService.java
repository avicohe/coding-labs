package com.avi.cohen.greeting.card.rests.services;

import java.util.IllegalFormatException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.avi.cohen.greeting.card.rests.model.io.CreateGreetingCardRequest;
import com.avi.cohen.greeting.card.rests.model.io.CreateGreetingCardResponse;
import com.avi.cohen.greeting.card.rests.model.vo.Card;
import com.avi.cohen.greeting.card.rests.model.vo.Template;
import com.avi.cohen.greeting.card.rests.services.base.GreetingCardServiceBase;
import com.avi.cohen.greeting.card.rests.services.error.GreetingCardErrorMessages;
import com.avi.cohen.greeting.card.rests.services.repo.GreetingCardRepository;

@Service
public class CreateGreetingCardService extends
		GreetingCardServiceBase<CreateGreetingCardResponse> {
	private CreateGreetingCardRequest createGreetingCardRequest;
	@Autowired
	private GreetingCardRepository greetingCardRepository;
	private String content;

	@Override
	protected void preExecutionHook() {
		validateNullOrEmpty(createGreetingCardRequest.getTemplateId(),
				GreetingCardErrorMessages.INVALID_TEMPLATE_ID);
		validateNullOrEmpty(createGreetingCardRequest.getBlanksValues(),
				GreetingCardErrorMessages.INVALID_TEMPLATE_VALUES);
	}

	@Override
	protected void executeOperationImpl() {
		Template requestedTemplate = fetchTemplateContentById();
		validateNullOrEmpty(requestedTemplate.getContent(),
				GreetingCardErrorMessages.INVALID_TEMPLATE_CONTENT);
		content = formatTemplateContent(requestedTemplate.getContent(),
				createGreetingCardRequest.getBlanksValues());
	}

	private Template fetchTemplateContentById() {
		try {
			return greetingCardRepository.findById(
					createGreetingCardRequest.getTemplateId()).get();
		} catch (NoSuchElementException nsee) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					GreetingCardErrorMessages.INVALID_TEMPLATE_ID);
		}
	}

	private String formatTemplateContent(String templateContent,
			Object[] templateValues) {
		try {
			return String.format(templateContent, templateValues);
		} catch (IllegalFormatException ife) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					GreetingCardErrorMessages.MISMATCHED_TEMPLATE_BLANKS, ife);
		}
	}

	@Override
	protected CreateGreetingCardResponse postExecutionHook() {
		CreateGreetingCardResponse greetingSystemCardResponse = new CreateGreetingCardResponse();
		Card card = new Card();
		card.setContent(content);
		greetingSystemCardResponse.setCard(card);
		return greetingSystemCardResponse;
	}

	public void setCreateGreetingCardRequest(
			CreateGreetingCardRequest createGreetingCardRequest) {
		this.createGreetingCardRequest = createGreetingCardRequest;
	}
}
