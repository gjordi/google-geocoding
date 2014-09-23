package com.bytebybyte.google.geocoding.service.response;

import com.bytebybyte.google.geocoding.service.IResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response implements IResponse {

	protected Result[] results;
	protected Status status;

	public Response() {
	}

	public Result[] getResults() {
		return results;
	}

	public void setResults(Result[] results) {
		this.results = results;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
