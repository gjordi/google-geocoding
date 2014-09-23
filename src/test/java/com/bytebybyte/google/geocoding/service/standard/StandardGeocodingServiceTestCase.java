package com.bytebybyte.google.geocoding.service.standard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bytebybyte.google.geocoding.service.IResponse;
import com.bytebybyte.google.geocoding.service.request.GeocodeRequest;
import com.bytebybyte.google.geocoding.service.request.GeocodeRequestBuilder;
import com.bytebybyte.google.geocoding.service.response.Status;

public class StandardGeocodingServiceTestCase {

	protected StandardGeocodingService service;

	@Before
	public void setUp() throws Exception {
		service = new StandardGeocodingService();
	}

	@Test
	public void testGeocode_CalgaryAddress() throws Exception {
		// setup
		GeocodeRequestBuilder builder = new GeocodeRequestBuilder();
		GeocodeRequest request = builder.output("json")
				.address("1015 120 Ave SE, Calgary, AB T2J 2L1").build();

		// execute
		IResponse response = service.geocode(request);

		// verify
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getStatus());
		Assert.assertEquals(Status.OK, response.getStatus());
		Assert.assertNotNull(response.getResults());
		Assert.assertEquals(1, response.getResults().length);
	}

}
