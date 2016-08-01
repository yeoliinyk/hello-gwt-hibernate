package com.yevgenoliinykov.HelloGWTHibernate.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.inject.Inject;
import com.yevgenoliinykov.HelloGWTHibernate.client.views.AppLayout;

/**
 * This class is responsible for ActivityManager instantiations through GIN
 *
 * @author Yevgen Oliinykov
 *
 */
public class ActivityInitializer {

    @Inject
    public ActivityInitializer(AppLayout appPanelView, ActivityManager activityManager) {
	activityManager.setDisplay(appPanelView.getMainConteiner());
    }
}
