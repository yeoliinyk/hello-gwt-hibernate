package com.yevgenoliinykov.HelloGWTHibernate.client.gin;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.yevgenoliinykov.HelloGWTHibernate.client.AppController;
import com.yevgenoliinykov.HelloGWTHibernate.client.AppControllerImpl;
import com.yevgenoliinykov.HelloGWTHibernate.client.activities.GreetingActivity;
import com.yevgenoliinykov.HelloGWTHibernate.client.activities.LogInActivity;
import com.yevgenoliinykov.HelloGWTHibernate.client.activities.MainActivityMapper;
import com.yevgenoliinykov.HelloGWTHibernate.client.places.AppPlaceHistoryMapper;
import com.yevgenoliinykov.HelloGWTHibernate.client.providers.GreetingActivityProvider;
import com.yevgenoliinykov.HelloGWTHibernate.client.providers.LogInActivityProvider;
import com.yevgenoliinykov.HelloGWTHibernate.client.resources.messages.Messages;
import com.yevgenoliinykov.HelloGWTHibernate.client.util.AppUtil;
import com.yevgenoliinykov.HelloGWTHibernate.client.views.AppLayout;
import com.yevgenoliinykov.HelloGWTHibernate.client.views.AppLayoutImpl;
import com.yevgenoliinykov.HelloGWTHibernate.client.views.GreetingView;
import com.yevgenoliinykov.HelloGWTHibernate.client.views.GreetingViewImpl;
import com.yevgenoliinykov.HelloGWTHibernate.client.views.LogInView;
import com.yevgenoliinykov.HelloGWTHibernate.client.views.LogInViewImpl;

public class GinModule extends AbstractGinModule {

    @Override
    protected void configure() {

	// Views
	bind(AppLayout.class).to(AppLayoutImpl.class).in(Singleton.class);
	bind(LogInView.class).to(LogInViewImpl.class).in(Singleton.class);
	bind(GreetingView.class).to(GreetingViewImpl.class).in(Singleton.class);

	// Activities
	bind(LogInActivity.class).toProvider(LogInActivityProvider.class).in(Singleton.class);
	bind(GreetingActivity.class).toProvider(GreetingActivityProvider.class).in(Singleton.class);

	// Places
	bind(PlaceHistoryMapper.class).to(AppPlaceHistoryMapper.class).in(Singleton.class);

	// Application event bus
	bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

	// Application controller
	bind(AppController.class).to(AppControllerImpl.class).in(Singleton.class);

	// Internationalization
	bind(Messages.class).in(Singleton.class);

	bind(AppUtil.class).in(Singleton.class);

    }

    @Provides
    @Singleton
    public ActivityManager getActivityManager(MainActivityMapper activityMapper, EventBus eventBus) {
	return new ActivityManager(activityMapper, eventBus);
    }

    @SuppressWarnings("deprecation")
    @Provides
    @Singleton
    public PlaceController getPlaceController(EventBus eventBus) {
	return new PlaceController(eventBus);
    }

    @Provides
    @Singleton
    public PlaceHistoryHandler getHistoryHandler(PlaceController placeController, PlaceHistoryMapper historyMapper,
	    EventBus eventBus) {
	PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
	return historyHandler;
    }

}
