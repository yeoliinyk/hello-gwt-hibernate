package com.yevgenoliinykov.HelloGWTHibernate.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class LogInPlace extends Place {

    public final static String PLACE_NAME = "login";

    public LogInPlace() {
    }

    public String getPlaceName() {
	return PLACE_NAME;
    }

    public static class Tokenizer implements PlaceTokenizer<LogInPlace> {

	@Override
	public LogInPlace getPlace(String token) {
	    return new LogInPlace();
	}

	@Override
	public String getToken(LogInPlace place) {
	    return place.getPlaceName();
	}

    }

}
