package com.yevgenoliinykov.HelloGWTHibernate.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.yevgenoliinykov.HelloGWTHibernate.client.resources.AppResources;

public class AppLayoutImpl implements AppLayout {

    interface AppLayoutUiBinder extends UiBinder<DockLayoutPanel, AppLayoutImpl> {

    }

    private static AppLayoutUiBinder uiBider = GWT.create(AppLayoutUiBinder.class);

    private final DockLayoutPanel mainLayoutPanel;

    @UiField
    SimplePanel mainPanel;

    @UiField
    AppResources res;

    public AppLayoutImpl() {
	mainLayoutPanel = uiBider.createAndBindUi(this);
    }

    @Override
    public DockLayoutPanel getMainLayoutPanel() {
	return mainLayoutPanel;
    }

    @Override
    public AcceptsOneWidget getMainConteiner() {
	return new AcceptsOneWidget() {

	    @Override
	    public void setWidget(IsWidget w) {
		Widget widget = Widget.asWidgetOrNull(w);
		mainPanel.setWidget(widget);
	    }
	};
    }
}
