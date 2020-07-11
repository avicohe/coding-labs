package com.avi.cohen.greeting.card.rests.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avi.cohen.greeting.card.rests.controllers.interfaces.GreetingCardRestOperations;
import com.avi.cohen.greeting.card.rests.model.io.CreateGreetingCardRequest;
import com.avi.cohen.greeting.card.rests.model.io.CreateGreetingCardResponse;
import com.avi.cohen.greeting.card.rests.model.io.CreateGreetingTemplateRequest;
import com.avi.cohen.greeting.card.rests.model.io.CreateGreetingTemplateResponse;
import com.avi.cohen.greeting.card.rests.model.io.RetrieveGreetingCardCatalogResponse;
import com.avi.cohen.greeting.card.rests.services.CreateGreetingCardService;
import com.avi.cohen.greeting.card.rests.services.CreateGreetingTemplateService;
import com.avi.cohen.greeting.card.rests.services.RetrieveGreetingCardCatalogService;

@RestController
@RequestMapping(value = "/services")
public class GreetingCardController implements GreetingCardRestOperations {
	@Autowired
	private RetrieveGreetingCardCatalogService retrieveGreetingCardCatalogService;
	@Autowired
	private CreateGreetingCardService createGreetingCardService;
	@Autowired
	private CreateGreetingTemplateService createGreetingTemplateService;

	@GetMapping("/greeting-cards")
	public RetrieveGreetingCardCatalogResponse getGreetingCardsCatalog() {
		return retrieveGreetingCardCatalogService.executeOperation();
	}

	@PostMapping("/greeting-cards")
	public CreateGreetingCardResponse createGreetingCard(
			@RequestBody CreateGreetingCardRequest createGreetingCardRequest) {
		createGreetingCardService
				.setCreateGreetingCardRequest(createGreetingCardRequest);
		return createGreetingCardService.executeOperation();
	}

	@PutMapping("/greeting-cards")
	public CreateGreetingTemplateResponse createGreetingTemplate(
			@RequestBody CreateGreetingTemplateRequest createGreetingTemplateRequest) {
		createGreetingTemplateService
				.setCreateGreetingTemplateRequest(createGreetingTemplateRequest);
		return createGreetingTemplateService.executeOperation();
	}
}
