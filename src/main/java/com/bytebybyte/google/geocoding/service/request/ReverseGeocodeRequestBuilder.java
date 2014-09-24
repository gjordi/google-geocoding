package com.bytebybyte.google.geocoding.service.request;

import java.util.LinkedHashMap;
import java.util.Map;

import com.bytebybyte.google.geocoding.service.response.LocationType;
import com.bytebybyte.google.geocoding.service.response.Type;

public class ReverseGeocodeRequestBuilder {

	protected Map<String, String> parameters = new LinkedHashMap<String, String>();

	public ReverseGeocodeRequestBuilder() {
	}

	/**
	 * Your 'free' application's API key. This key identifies your application
	 * for purposes of quota management.
	 * 
	 * @param key
	 * @return ReverseGeocodeRequestBuilder
	 */
	public ReverseGeocodeRequestBuilder key(String key) {
		parameters.put("key", key);
		return this;
	}

	/**
	 * Your 'business' application's API key. This key identifies your
	 * application for purposes of quota management.
	 * 
	 * @param client
	 * @param signature
	 * @return ReverseGeocodeRequestBuilder
	 */
	public ReverseGeocodeRequestBuilder key(String client, String signature) {
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
	 * @return ReverseGeocodeRequestBuilder
	 */
	public ReverseGeocodeRequestBuilder output(String output) {
		parameters.put("output", output);
		return this;
	}

	/**
	 * The location latitude and longitude.
	 * 
	 * This parameter is required.
	 * 
	 * @param lat
	 * @param lng
	 * @return ReverseGeocodeRequestBuilder
	 */
	public ReverseGeocodeRequestBuilder latlng(Double lat, Double lng) {
		parameters.put("latlng", lat + "," + lng);
		return this;
	}

	/**
	 * The language in which to return results. If language is not supplied, the
	 * geocoder will attempt to use the native language of the domain from which
	 * the request is sent wherever possible.
	 * 
	 * @param language
	 * @return ReverseGeocodeRequestBuilder
	 */
	public ReverseGeocodeRequestBuilder language(String language) {
		parameters.put("language", language);
		return this;
	}

	/**
	 * One or more address types, separated by a pipe (|). 
	 * 
	 * Examples of address types: country, street_address, postal_code. 
	 * 
	 * For a full list of allowable values, see the address types on this page. 
	 * Specifying a type will restrict the results to this type. If multiple 
	 * types are specified, the API will return all addresses that match any 
	 * of the types. Note: This parameter is available only for requests that 
	 * include an API key or a client ID.
	 * 
	 * @param types
	 * @return ReverseGeocodeRequestBuilder
	 */
	public ReverseGeocodeRequestBuilder resultType(Type[] types) {
		if (types == null || types.length == 0)
			return this;

		StringBuffer resultType = new StringBuffer();
		for (int i = 0; i < types.length - 1; i++)
			resultType.append(types[i] + "|");
		resultType.append(types[types.length - 1]);

		parameters.put("result_type", resultType.toString());
		return this;
	}

	/**
	 * One or more location types, separated by a pipe (|). 
	 * 
	 * Specifying a type will restrict the results to this type. If multiple 
	 * types are specified, the API will return all addresses that match any 
	 * of the types. 
	 * 
	 * Note: This parameter is available only for requests that include an API 
	 * key or a client ID. 
	 * 
	 * The following values are supported:
	 * 
	 *   "ROOFTOP" restricts the results to addresses for which we have 
	 *   location information accurate down to street address precision.
	 *   
	 *   "RANGE_INTERPOLATED" restricts the results to those that reflect 
	 *   an approximation (usually on a road) interpolated between two precise
	 *   points (such as intersections). An interpolated range generally 
	 *   indicates that rooftop geocodes are unavailable for a street address.
	 *   
	 *   "GEOMETRIC_CENTER" restricts the results to geometric centers of a 
	 *   location such as a polyline (for example, a street) or polygon (region).
	 *   
	 *   "APPROXIMATE" restricts the results to those that are characterized 
	 *   as approximate.
	 *   
	 * @param types
	 * @return ReverseGeocodeRequestBuilder
	 */
	public ReverseGeocodeRequestBuilder locationType(LocationType[] types) {
		if (types == null || types.length == 0)
			return this;

		StringBuffer resultType = new StringBuffer();
		for (int i = 0; i < types.length - 1; i++)
			resultType.append(types[i] + "|");
		resultType.append(types[types.length - 1]);

		parameters.put("location_type", resultType.toString());
		return this;
	}

	/**
	 * Build the request object.
	 * 
	 * @return AddressRequest
	 */
	public ReverseGeocodeRequest build() {
		return new ReverseGeocodeRequest(parameters);
	}

}
