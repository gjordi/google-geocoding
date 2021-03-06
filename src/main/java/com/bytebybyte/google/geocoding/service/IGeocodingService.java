package com.bytebybyte.google.geocoding.service;

public interface IGeocodingService {

	IResponse geocode(IGeocodeRequest request);

	IResponse reverseGeocode(IReverseGeocodeRequest request);
}
