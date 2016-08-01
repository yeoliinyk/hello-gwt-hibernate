package com.yevgenoliinykov.HelloGWTHibernate.client.providers;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.yevgenoliinykov.HelloGWTHibernate.client.activities.GreetingActivity;
import com.yevgenoliinykov.HelloGWTHibernate.client.resources.messages.Messages;
import com.yevgenoliinykov.HelloGWTHibernate.client.services.LogInServiceAsync;
import com.yevgenoliinykov.HelloGWTHibernate.client.util.AppUtil;
import com.yevgenoliinykov.HelloGWTHibernate.client.views.GreetingView;

public class GreetingActivityProvider implements Provider<GreetingActivity> {

    private final GreetingView greetingView;
    private final PlaceController placeController;
    private final Messages messages;
    private final LogInServiceAsync logInServiceAsync;
    private final AppUtil appUtil;
    private final Logger logger = Logger.getLogger("");

    @Inject
    public GreetingActivityProvider(GreetingView greetingView, PlaceController placeController, Messages messages,
	    LogInServiceAsync logInServiceAsync, AppUtil appUtil) {
	this.greetingView = greetingView;
	this.placeController = placeController;
	this.messages = messages;
	this.logInServiceAsync = logInServiceAsync;
	this.appUtil = appUtil;
    }

    @Override
    public GreetingActivity get() {
	logger.log(Level.INFO, "Startng new 'greeting' activity.");
	return new GreetingActivity(greetingView, placeController, messages, logInServiceAsync, appUtil);
    }
}
