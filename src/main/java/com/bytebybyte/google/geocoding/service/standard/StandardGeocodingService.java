package com.bytebybyte.google.geocoding.service.standard;

import java.net.URI;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bytebybyte.google.geocoding.service.IGeocodeRequest;
import com.bytebybyte.google.geocoding.service.IGeocodingService;
import com.bytebybyte.google.geocoding.service.IResponse;
import com.bytebybyte.google.geocoding.service.IReverseGeocodeRequest;
import com.bytebybyte.google.geocoding.service.response.Response;

public class StandardGeocodingService implements IGeocodingService {

	protected static final Logger logger = LoggerFactory.getLogger(StandardGeocodingService.class);

	protected static final String URL = "https://maps.googleapis.com/maps/api/geocode/{output}";

	protected RestTemplate restTemplate;

	public StandardGeocodingService() {
		this(new RestTemplate());
	}

	public StandardGeocodingService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public IResponse geocode(IGeocodeRequest request) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL);

		for (Map.Entry<String, String> entry : request.getParameters().entrySet())
			builder.queryParam(entry.getKey(), entry.getValue());

		URI uri = builder.buildAndExpand(request.getParameters()).toUri();

		return restTemplate.getForObject(uri, Response.class);
	}

	@Override
	public IResponse reverseGeocode(IReverseGeocodeRequest request) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL);

		for (Map.Entry<String, String> entry : request.getParameters().entrySet())
			builder.queryParam(entry.getKey(), entry.getValue());

		URI uri = builder.buildAndExpand(request.getParameters()).toUri();

		return restTemplate.getForObject(uri, Response.class);
	}
}
