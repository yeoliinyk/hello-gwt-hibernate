package com.yevgenoliinykov.HelloGWTHibernate.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.inject.Inject;
import com.yevgenoliinykov.HelloGWTHibernate.client.places.LogInPlace;
import com.yevgenoliinykov.HelloGWTHibernate.client.views.AppLayout;

public class AppControllerImpl implements AppController {

    private final AppLayout appPanelView;
    private final PlaceController placeController;
    private final EventBus eventBus;
    private final PlaceHistoryHandler placeHistoryHandler;
    private final Logger logger = Logger.getLogger("");

    /**
     * All parameters are injected by GIN
     *
     * @param appPanelView
     *            this is the application's main panel
     * @param placeController
     *            the application's PlaceController
     * @param eventBus
     *            the application's EventBus
     * @param placeHistoryHandler
     *            the application's PlaceHistoryHandler
     * @param activityInitializer
     *            unused parameter, it's here just to force GIN's initialization
     *            of ActivityManagers
     */
    @Inject
    public AppControllerImpl(AppLayout appPanelView, PlaceController placeController, EventBus eventBus,
	    PlaceHistoryHandler placeHistoryHandler, ActivityInitializer activityInitializer) {
	this.appPanelView = appPanelView;
	this.placeController = placeController;
	this.eventBus = eventBus;
	this.placeHistoryHandler = placeHistoryHandler;

    }

    @SuppressWarnings("deprecation")
    @Override
    public void launchApp() {
	logger.log(Level.INFO, "Starting application.");
	placeHistoryHandler.register(placeController, eventBus, new LogInPlace());
	RootLayoutPanel.get().add(appPanelView.getMainLayoutPanel());
	placeHistoryHandler.handleCurrentHistory();
    }
}