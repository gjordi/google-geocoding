package com.bytebybyte.google.geocoding.service.request;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class GeocodeRequestBuilder {

	protected Map<String, String> parameters = new LinkedHashMap<String, String>();

	public GeocodeRequestBuilder() {
	}

	/**
	 * Your 'free' application's API key. This key identifies your application
	 * for purposes of quota management.
	 * 
	 * @param key
	 * @return GeocodeRequestBuilder
	 */
	public GeocodeRequestBuilder key(String key) {
		parameters.put("key", key);
		return this;
	}

	/**
	 * Your 'business' application's API key. This key identifies your
	 * application for purposes of quota management.
	 * 
	 * @param client
	 * @param signature
	 * @return GeocodeRequestBuilder
	 */
	public GeocodeRequestBuilder key(String client, String signature) {
		parameters.put("client", client);
		parameters.put("signature", signature);
		return this;
	}

	/**
	 * Output format.
	 * 
	 * - json (recommended) indicates output in JavaScript Object Notation.
	 * 
	 * - xml indicates output as XML
	 * 
	 * @param output
	 * @return GeocodeRequestBuilder
	 */
	public GeocodeRequestBuilder output(String output) {
		parameters.put("output", output);
		return this;
	}

	/**
	 * The address that you want to geocode.
	 * 
	 * @param address
	 * @return GeocodeRequestBuilder
	 */
	public GeocodeRequestBuilder address(String address) {
		parameters.put("address", address != null ? address.replace(' ', '+')
				: address);
		return this;
	}

	/**
	 * In a geocoding response, the Google Geocoding API can return address
	 * results restricted to a specific area.
	 * 
	 * The restriction is specified using the components filter.
	 * 
	 * A filter consists of a list of component:value pairs separated by a pipe
	 * (|). Only the results that match all the filters will be returned.
	 * 
	 * Filter values support the same methods of spelling correction and partial
	 * matching as other geocoding requests. If a geocoding result is a partial
	 * match for a component filter it will contain a partial_match field in the
	 * response.
	 * 
	 * The components that can be filtered include:
	 * 
	 * route: matches long or short name of a route.
	 * 
	 * locality: matches against both locality and sublocality types.
	 * 
	 * administrative_area: matches all the administrative_area levels.
	 * 
	 * postal_code: matches postal_code and postal_code_prefix.
	 * 
	 * country: matches a country name or a two letter ISO 3166-1 country code.
	 * 
	 * Note: Each address component can only be specified either in the address
	 * parameter or as a component filter, but not both. Doing so may result in
	 * ZERO_RESULTS.
	 * 
	 * Countries and administrative areas of level 1 are exempted from this.
	 * 
	 * @param components
	 * @return GeocodeRequestBuilder
	 */
	public GeocodeRequestBuilder componenets(Map<String, String> components) {
		StringBuffer filters = new StringBuffer();
		for (Iterator<Map.Entry<String, String>> iterator = components
				.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<String, String> entry = iterator.next();
			filters.append(entry.getKey() + ":" + entry.getValue() != null ? entry
					.getValue().replace(' ', '+') : entry.getValue());
			if (iterator.hasNext())
				filters.append("|");
		}
		parameters.put("components", filters.toString());
		return this;
	}

	/**
	 * The bounding box of the viewport within which to bias geocode results
	 * more prominently. This parameter will only influence, not fully restrict,
	 * results from the geocoder.
	 * 
	 * @param bounds
	 * @return GeocodeRequestBuilder
	 */
	public GeocodeRequestBuilder bounds(String bounds) {
		parameters.put("bounds", bounds);
		return this;
	}

	/**
	 * The language in which to return results. If language is not supplied, the
	 * geocoder will attempt to use the native language of the domain from which
	 * the request is sent wherever possible.
	 * 
	 * @param language
	 * @return GeocodeRequestBuilder
	 */
	public GeocodeRequestBuilder language(String language) {
		parameters.put("language", language);
		return this;
	}

	/**
	 * TThe region code, specified as a ccTLD ("top-level domain") two-character
	 * value. This parameter will only influence, not fully restrict, results
	 * from the geocoder.
	 * 
	 * @param region
	 * @return GeocodeRequestBuilder
	 */
	public GeocodeRequestBuilder region(String region) {
		parameters.put("region", region);
		return this;
	}

	/**
	 * Build the request object.
	 * 
	 * @return GeocodeRequest
	 */
	public GeocodeRequest build() {
		return new GeocodeRequest(parameters);
	}
}
