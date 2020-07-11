package com.avi.cohen.greeting.card.rests.controllers.interfaces;

import com.avi.cohen.greeting.card.rests.model.io.CreateGreetingCardRequest;
import com.avi.cohen.greeting.card.rests.model.io.CreateGreetingCardResponse;
import com.avi.cohen.greeting.card.rests.model.io.CreateGreetingTemplateRequest;
import com.avi.cohen.greeting.card.rests.model.io.CreateGreetingTemplateResponse;
import com.avi.cohen.greeting.card.rests.model.io.RetrieveGreetingCardCatalogResponse;

public interface GreetingCardRestOperations {
	RetrieveGreetingCardCatalogResponse getGreetingCardsCatalog();

	CreateGreetingCardResponse createGreetingCard(
			CreateGreetingCardRequest greetingSystemCardRequest);

	CreateGreetingTemplateResponse createGreetingTemplate(
			CreateGreetingTemplateRequest createGreetingTemplateRequest);
}
