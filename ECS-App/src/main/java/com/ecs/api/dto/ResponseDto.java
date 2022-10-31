package com.ecs.api.dto;

import org.springframework.stereotype.Component;

@Component //this registers the class as Bean with spring, so can be auto wired.
public class ResponseDto {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
//{}