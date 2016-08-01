package com.yevgenoliinykov.HelloGWTHibernate.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class GreetingPlace extends Place {

    public final static String PLACE_NAME = "greeting";

    public GreetingPlace() {

    }

    public String getPlaceName() {
	return PLACE_NAME;
    }

    public static class Tokenizer implements PlaceTokenizer<GreetingPlace> {

	@Override
	public GreetingPlace getPlace(String token) {
	    return new GreetingPlace();
	}

	@Override
	public String getToken(GreetingPlace place) {
	    return place.getPlaceName();
	}
    }
}
