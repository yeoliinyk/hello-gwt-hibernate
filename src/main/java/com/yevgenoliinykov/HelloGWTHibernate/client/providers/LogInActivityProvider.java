package com.yevgenoliinykov.HelloGWTHibernate.client.providers;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.yevgenoliinykov.HelloGWTHibernate.client.activities.LogInActivity;
import com.yevgenoliinykov.HelloGWTHibernate.client.resources.messages.Messages;
import com.yevgenoliinykov.HelloGWTHibernate.client.services.LogInServiceAsync;
import com.yevgenoliinykov.HelloGWTHibernate.client.util.AppUtil;
import com.yevgenoliinykov.HelloGWTHibernate.client.views.LogInView;

public class LogInActivityProvider implements Provider<LogInActivity> {

    private final LogInView logInView;
    private final LogInServiceAsync logInServiceAsync;
    private final PlaceController placeController;
    private final Messages messages;
    private final AppUtil appUtil;
    private final Logger logger = Logger.getLogger("");

    @Inject
    public LogInActivityProvider(LogInView logInView, LogInServiceAsync logInServiceAsync,
	    PlaceController placeController, EventBus eventBus, Messages messages, AppUtil appUtil) {
	this.logInView = logInView;
	this.logInServiceAsync = logInServiceAsync;
	this.placeController = placeController;
	this.messages = messages;
	this.appUtil = appUtil;
    }

    @Override
    public LogInActivity get() {
	logger.log(Level.INFO, "Starting new 'log in' activity");
	return new LogInActivity(logInView, logInServiceAsync, placeController, messages, appUtil);
    }

}
