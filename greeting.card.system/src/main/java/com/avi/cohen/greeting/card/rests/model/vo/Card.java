package com.avi.cohen.greeting.card.rests.model.vo;

import java.io.Serializable;

public class Card implements Serializable {
	private static final long serialVersionUID = 1L;
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
