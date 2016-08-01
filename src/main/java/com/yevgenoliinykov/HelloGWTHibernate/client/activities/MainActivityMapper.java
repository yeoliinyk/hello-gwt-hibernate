package com.yevgenoliinykov.HelloGWTHibernate.client.activities;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.yevgenoliinykov.HelloGWTHibernate.client.places.GreetingPlace;
import com.yevgenoliinykov.HelloGWTHibernate.client.places.LogInPlace;

public class MainActivityMapper implements ActivityMapper {

    private final Provider<LogInActivity> logInActivityProvider;
    private final Provider<GreetingActivity> greetingActivityProvider;
    private final Logger logger = Logger.getLogger("");

    @Inject
    public MainActivityMapper(Provider<LogInActivity> logInActivityProvider,
	    Provider<GreetingActivity> greetingActivityProvider) {
	this.logInActivityProvider = logInActivityProvider;
	this.greetingActivityProvider = greetingActivityProvider;
    }

    @Override
    public Activity getActivity(Place place) {
	if (place instanceof LogInPlace) {
	    logger.log(Level.INFO, "Getting 'logIn activity' provider");
	    return logInActivityProvider.get();
	} else if (place instanceof GreetingPlace) {
	    logger.log(Level.INFO, "Getting 'greeting activity' provider");
	    return greetingActivityProvider.get();
	}
	return null;
    }

}
