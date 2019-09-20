package com.sasken.website.career.model;

import org.springframework.stereotype.Component;

@Component
public class ResponseDataBo extends ResponseBo {
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseDataBo [data=" + data + "]";
	}

}
