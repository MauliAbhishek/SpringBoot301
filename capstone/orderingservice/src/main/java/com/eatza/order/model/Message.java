package com.eatza.order.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Message {

	
	private int id;
	private String context;
	
	public Message(int id , String context) {
		this.id =id;
		this.context=context;
	}
}
