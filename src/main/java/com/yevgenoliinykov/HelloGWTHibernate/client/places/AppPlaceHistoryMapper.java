package com.yevgenoliinykov.HelloGWTHibernate.client.places;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;

public class AppPlaceHistoryMapper implements PlaceHistoryMapper {

    private final Logger logger = Logger.getLogger("");

    @Override
    public Place getPlace(String token) {
	if (token.equals(LogInPlace.PLACE_NAME)) {
	    logger.log(Level.INFO, "Getting new #login place");
	    return new LogInPlace();
	} else if (token.equals(GreetingPlace.PLACE_NAME)) {
	    logger.log(Level.INFO, "Getting new #greeting place");
	    return new GreetingPlace();
	}
	return Place.NOWHERE;
    }

    @Override
    public String getToken(Place place) {
	if (place instanceof LogInPlace) {
	    return LogInPlace.PLACE_NAME;
	} else if (place instanceof GreetingPlace) {
	    return GreetingPlace.PLACE_NAME;
	}
	return Place.NOWHERE.toString();
    }

}
