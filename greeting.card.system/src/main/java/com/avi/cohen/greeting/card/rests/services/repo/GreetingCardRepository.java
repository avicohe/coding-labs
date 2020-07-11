package com.avi.cohen.greeting.card.rests.services.repo;

import org.springframework.data.repository.CrudRepository;

import com.avi.cohen.greeting.card.rests.model.vo.Template;

public interface GreetingCardRepository extends
		CrudRepository<Template, Integer> {
}
