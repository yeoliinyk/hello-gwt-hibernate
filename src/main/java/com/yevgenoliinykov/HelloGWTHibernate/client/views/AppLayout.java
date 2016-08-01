package com.yevgenoliinykov.HelloGWTHibernate.client.views;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockLayoutPanel;

public interface AppLayout {

    DockLayoutPanel getMainLayoutPanel();

    AcceptsOneWidget getMainConteiner();

}