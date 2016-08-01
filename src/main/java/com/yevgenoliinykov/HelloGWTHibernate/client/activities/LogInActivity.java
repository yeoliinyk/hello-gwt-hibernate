package com.yevgenoliinykov.HelloGWTHibernate.client.activities;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.yevgenoliinykov.HelloGWTHibernate.client.places.GreetingPlace;
import com.yevgenoliinykov.HelloGWTHibernate.client.resources.AppConstants;
import com.yevgenoliinykov.HelloGWTHibernate.client.resources.messages.Messages;
import com.yevgenoliinykov.HelloGWTHibernate.client.services.LogInServiceAsync;
import com.yevgenoliinykov.HelloGWTHibernate.client.util.AppUtil;
import com.yevgenoliinykov.HelloGWTHibernate.client.views.LogInView;
import com.yevgenoliinykov.HelloGWTHibernate.shared.LogInInfo;

public class LogInActivity extends AbstractActivity implements LogInView.Presenter {

    private final Logger logger = Logger.getLogger("");
    private final LogInView logInView;
    private final PlaceController placeController;
    private final LogInServiceAsync logInServiceAsync;
    private final Messages messages;
    private final AppUtil appUtil;

    public LogInActivity(LogInView logInView, LogInServiceAsync logInServiceAsync, PlaceController placeController,
	    Messages messages, AppUtil appUtil) {
	this.logInView = logInView;
	this.placeController = placeController;
	this.logInServiceAsync = logInServiceAsync;
	this.messages = messages;
	this.appUtil = appUtil;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
	String sessionID = Cookies.getCookie("sid");
	if (sessionID != null) {
	    logInServiceAsync.logInFromSession(sessionID, new AsyncCallback<LogInInfo>() {

		@Override
		public void onSuccess(LogInInfo result) {
		    if (result != null) {
			if (result.getIsLoggedIn()) {
			    logger.info("log in from session success");
			    appUtil.setAppLogInInfo(result);
			    placeController.goTo(new GreetingPlace());
			} else {
			    logger.info("user is not logged in");
			}
		    } else {
			logger.info("There is no session for this user");
		    }
		}

		@Override
		public void onFailure(Throwable caught) {
		    logger.log(Level.INFO, AppConstants.SERVER_ERROR);
		}
	    });

	}
	initLogInViewLabels();
	panel.setWidget(logInView.asWidget());
	logInView.setPresenter(LogInActivity.this);

    }

    @Override
    public void logIn() {
	String login = logInView.getLoginValue().getText();
	String password = logInView.getPasswordValue().getText();
	logInServiceAsync.logIn(login, password, new AsyncCallback<LogInInfo>() {

	    @Override
	    public void onSuccess(LogInInfo result) {
		if (result != null) {
		    if (result.getIsLoggedIn()) {
			logInView.clearInputFields();
			appUtil.setAppLogInInfo(result);
			String sessionID = result.getSessionId();
			Date expires = new Date(System.currentTimeMillis() + AppConstants.DURATION);
			Cookies.setCookie("sid", sessionID, expires, null, "/", false);
			placeController.goTo(new GreetingPlace());
		    } else {
			logInView.getLogInErrorLabel().setText(messages.invalidLoginOrPass());
		    }
		} else {
		    logInView.getLogInErrorLabel().setText(messages.invalidLoginOrPass());
		}
	    }

	    @Override
	    public void onFailure(Throwable caught) {
		logger.log(Level.INFO, AppConstants.SERVER_ERROR);
	    }
	});
    }

    private void initLogInViewLabels() {
	logInView.getLoginLabel().setText(messages.login() + ":");
	logInView.getPasswordLabel().setText(messages.password() + ":");
	logInView.getLogInButton().setText(messages.logIn());
    }

}