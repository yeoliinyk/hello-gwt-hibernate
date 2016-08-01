package com.yevgenoliinykov.HelloGWTHibernate.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LogInViewImpl extends Composite implements LogInView {

    interface LogInViewImplUiBinder extends UiBinder<Widget, LogInViewImpl> {
    }

    private static LogInViewImplUiBinder uiBinder = GWT.create(LogInViewImplUiBinder.class);

    private Presenter presenter;

    @UiField
    TextBox boxLogin;

    @UiField
    TextBox boxPassword;

    @UiField
    Label lblLogInError;

    @UiField
    Label lblLogin;

    @UiField
    Label lblPassword;

    @UiField
    Button btnLogIn;

    public LogInViewImpl() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("btnLogIn")
    void onBtnLogInClicked(ClickEvent e) {
	presenter.logIn();
    }

    @Override
    public void setPresenter(Presenter presenter) {
	this.presenter = presenter;
    }

    @Override
    public Label getLogInErrorLabel() {
	return lblLogInError;
    }

    @Override
    public Label getLoginLabel() {
	return lblLogin;
    }

    @Override
    public Label getPasswordLabel() {
	return lblPassword;
    }

    @Override
    public Button getLogInButton() {
	return btnLogIn;
    }

    @Override
    public HasText getLoginValue() {
	return boxLogin;
    }

    @Override
    public HasText getPasswordValue() {
	return boxPassword;
    }

    @Override
    public void clearInputFields() {
	boxLogin.setText("");
	boxPassword.setText("");
	lblLogInError.setText("");
    }

}
