package com.bytebybyte.google.geocoding.service.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Type {

	//
	// The following types are supported and returned by the geocoder in both
	// the address type and address component type arrays:
	//

	// street_address indicates a precise street address.
	STREET_ADDRESS,

	// route indicates a named route (such as "US 101").
	ROUTE,

	// intersection indicates a major intersection, usually of two major roads.
	INTERSECTION,

	// political indicates a political entity. Usually, this type indicates a
	// polygon of some civil administration.
	POLITICAL,

	// country indicates the national political entity, and is typically the
	// highest order type returned by the Geocoder.
	COUNTRY,

	// administrative_area_level_1 indicates a first-order civil entity below
	// the country level. Within the United States, these administrative levels
	// are states. Not all nations exhibit these administrative levels.
	ADMINISTRATIVE_AREA_LEVEL_1,

	// administrative_area_level_2 indicates a second-order civil entity below
	// the country level. Within the United States, these administrative levels
	// are counties. Not all nations exhibit these administrative levels.
	ADMINISTRATIVE_AREA_LEVEL_2,

	// administrative_area_level_3 indicates a third-order civil entity below
	// the country level. This type indicates a minor civil division. Not all
	// nations exhibit these administrative levels.
	ADMINISTRATIVE_AREA_LEVEL_3,

	// administrative_area_level_4 indicates a fourth-order civil entity below
	// the country level. This type indicates a minor civil division. Not all
	// nations exhibit these administrative levels.
	ADMINISTRATIVE_AREA_LEVEL_4,

	// administrative_area_level_5 indicates a fifth-order civil entity below
	// the country level. This type indicates a minor civil division. Not all
	// nations exhibit these administrative levels.
	ADMINISTRATIVE_AREA_LEVEL_5,

	// colloquial_area indicates a commonly-used alternative name for the
	// entity.
	COLLOQUIAL_AREA,

	// locality indicates an incorporated city or town political entity.
	LOCALITY,

	// ward indicates a specific type of Japanese locality, to facilitate
	// distinction between multiple locality components within a Japanese
	// address.
	WARD,

	// sublocality indicates a first-order civil entity below a locality. For
	// some locations may receive one of the additional types:
	// sublocality_level_1 to sublocality_level_5. Each sublocality level is a
	// civil entity. Larger numbers indicate a smaller geographic area.
	SUBLOCALITY,

	// neighborhood indicates a named neighborhood
	NEIGHBORHOOD,

	// premise indicates a named location, usually a building or collection of
	// buildings with a common name
	PREMISE,

	// subpremise indicates a first-order entity below a named location, usually
	// a singular building within a collection of buildings with a common name
	SUBPREMISE,

	// postal_code indicates a postal code as used to address postal mail within
	// the country.
	POSTAL_CODE, POSTAL_CODE_PREFIX,

	// natural_feature indicates a prominent natural feature.
	NATURAL_FEATURE,

	// airport indicates an airport.
	AIRPORT,

	// park indicates a named park.
	PARK,

	// point_of_interest indicates a named point of interest. Typically, these
	// "POI"s are prominent local entities that don't easily fit in another
	// category, such as "Empire State Building" or "Statue of Liberty."
	POINT_OF_INTEREST,

	//
	// In addition to the above, address components may include the types below.
	//
	// Note: This list is not exhaustive, and is subject to change.
	//

	// floor indicates the floor of a building address.
	FLOOR,

	// establishment typically indicates a place that has not yet been
	// categorized.
	ESTABLISHMENT,

	// parking indicates a parking lot or parking structure.
	PARKING,

	// post_box indicates a specific postal box.
	POST_BOX,

	// postal_town indicates a grouping of geographic areas, such as locality
	// and sublocality, used for mailing addresses in some countries.
	POSTAL_TOWN,

	// room indicates the room of a building address.
	ROOM,

	// street_number indicates the precise street number.
	STREET_NUMBER,

	// bus_station, train_station and transit_station indicate the location of a
	// bus, train or public transit stop.
	BUS_STATION, TRAIN_STATION, TRANSIT_STATION,

	// a catch all for cases where the enum could not be identified.
	UNKNOWN;

	@JsonValue
	public String getValue() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static Type newInstance(String value) {
		try {
			return Type.valueOf(value.toUpperCase());
		} catch (IllegalArgumentException e) {
			return Type.UNKNOWN;
		}
	}
}
