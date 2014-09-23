package com.bytebybyte.google.geocoding.service;

import com.bytebybyte.google.geocoding.service.response.Result;
import com.bytebybyte.google.geocoding.service.response.Status;

public interface IResponse {

	/**
	 * An array of geocoded address information and geometry information.
	 * 
	 * @return Result[]
	 */
	Result[] getResults();

	/**
	 * Metadata on the request.
	 * 
	 * @return Status
	 */
	Status getStatus();
}
