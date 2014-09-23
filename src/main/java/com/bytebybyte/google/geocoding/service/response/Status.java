package com.bytebybyte.google.geocoding.service.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum Status {

	// indicates that no errors occurred; the address was successfully parsed
	// and at least one geocode was returned.
	OK,

	// indicates that the geocode was successful but returned no results. This
	// may occur if the geocoder was passed a non-existent address.
	ZERO_RESULTS,

	// indicates that you are over your quota.
	OVER_QUERY_LIMIT,

	// indicates that your request was denied.
	REQUEST_DENIED,

	// generally indicates that the query (address, components or latlng) is
	// missing.
	INVALID_REQUEST,

	// indicates that the request could not be processed due to a server error.
	// The request may succeed if you try again.
	UNKNOWN_ERROR

}
