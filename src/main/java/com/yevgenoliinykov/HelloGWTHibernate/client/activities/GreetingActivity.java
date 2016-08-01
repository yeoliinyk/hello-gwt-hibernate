package com.yevgenoliinykov.HelloGWTHibernate.client.activities;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.yevgenoliinykov.HelloGWTHibernate.client.places.LogInPlace;
import com.yevgenoliinykov.HelloGWTHibernate.client.resources.AppConstants;
import com.yevgenoliinykov.HelloGWTHibernate.client.resources.messages.Messages;
import com.yevgenoliinykov.HelloGWTHibernate.client.services.LogInServiceAsync;
import com.yevgenoliinykov.HelloGWTHibernate.client.util.AppUtil;
import com.yevgenoliinykov.HelloGWTHibernate.client.views.GreetingView;
import com.yevgenoliinykov.HelloGWTHibernate.shared.LogInInfo;

public class GreetingActivity extends AbstractActivity implements GreetingView.Presenter {

    private final Logger logger = Logger.getLogger("");

    private final GreetingView greetingView;
    private final PlaceController placeController;
    private final Messages messages;
    private final LogInServiceAsync logInServiceAsync;
    private final AppUtil appUtil;

    public GreetingActivity(GreetingView greetingView, PlaceController placeController, Messages messages,
	    LogInServiceAsync logInServiceAsync, AppUtil appUtil) {
	this.greetingView = greetingView;
	this.placeController = placeController;
	this.messages = messages;
	this.logInServiceAsync = logInServiceAsync;
	this.appUtil = appUtil;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
	LogInInfo appLogInInfo = appUtil.getAppLogInInfo();
	if (appLogInInfo != null) {
	    if (appLogInInfo.getIsLoggedIn()) {
		logger.info("User is logged in");
		byte currentHour = AppUtil.getCurrentTime();
		logger.log(Level.INFO, "Current time on user machine - " + currentHour + "h");
		String greetingMessage = AppUtil.getGreetingMessage(currentHour, messages) + ", "
			+ appLogInInfo.getFirstName() + ".";
		greetingView.getGreetingLabel().setText(greetingMessage);
		greetingView.getLogOutAncor().setText(messages.logOut());
		greetingView.setPresenter(GreetingActivity.this);
		panel.setWidget(greetingView.asWidget());
	    } else {
		logger.info("User is not logged in");
		placeController.goTo(new LogInPlace());
	    }
	} else {
	    logger.info("appLogInInfo is null ");
	    placeController.goTo(new LogInPlace());
	}
    }

    @Override
    public void logOut() {
	appUtil.setAppLogInInfo(null);
	logInServiceAsync.logOut(new AsyncCallback<Void>() {

	    @Override
	    public void onFailure(Throwable caught) {
		logger.log(Level.INFO, AppConstants.SERVER_ERROR);
	    }

	    @Override
	    public void onSuccess(Void result) {
		greetingView.clearView();
		placeController.goTo(new LogInPlace());
	    }
	});

    }
}
