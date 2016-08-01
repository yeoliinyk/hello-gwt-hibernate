package com.yevgenoliinykov.HelloGWTHibernate.client.views;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;

public interface LogInView extends IsWidget {

    Label getLogInErrorLabel();

    Label getLoginLabel();

    Label getPasswordLabel();

    Button getLogInButton();

    HasText getLoginValue();

    HasText getPasswordValue();

    void clearInputFields();

    void setPresenter(Presenter presenter);

    public interface Presenter {
	void logIn();
    }
}
