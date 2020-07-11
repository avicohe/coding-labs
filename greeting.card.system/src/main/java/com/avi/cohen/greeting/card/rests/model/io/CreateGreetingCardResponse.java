package com.avi.cohen.greeting.card.rests.model.io;

import java.io.Serializable;

import com.avi.cohen.greeting.card.rests.model.vo.Card;

public class CreateGreetingCardResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Card card;

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
}
