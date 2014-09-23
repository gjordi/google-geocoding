package com.bytebybyte.google.geocoding.service.request;

import java.util.Map;

import com.bytebybyte.google.geocoding.service.IGeocodeRequest;

public class GeocodeRequest implements IGeocodeRequest {

	protected Map<String, String> parameters;

	protected GeocodeRequest() {
	}

	public GeocodeRequest(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	@Override
	public Map<String, String> getParameters() {
		return parameters;
	}

}
