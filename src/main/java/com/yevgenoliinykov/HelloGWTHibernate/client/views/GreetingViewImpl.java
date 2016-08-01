package com.yevgenoliinykov.HelloGWTHibernate.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class GreetingViewImpl extends Composite implements GreetingView {

    interface GreetingViewImplUiBinder extends UiBinder<Widget, GreetingViewImpl> {
    }

    private static GreetingViewImplUiBinder uiBinder = GWT.create(GreetingViewImplUiBinder.class);

    private Presenter presenter;

    @UiField
    Label lblGreeting;

    @UiField
    Anchor ancLogOut;

    public GreetingViewImpl() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("ancLogOut")
    void onAncLogOutClicked(ClickEvent e) {
	presenter.logOut();
    }

    @Override
    public Label getGreetingLabel() {
	return lblGreeting;
    }

    @Override
    public Anchor getLogOutAncor() {
	return ancLogOut;
    }

    @Override
    public void setPresenter(Presenter presenter) {
	this.presenter = presenter;
    }

    @Override
    public void clearView() {
	lblGreeting.setText("");
	ancLogOut.setText("");
    }

}
