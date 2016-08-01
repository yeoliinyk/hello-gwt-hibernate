package com.yevgenoliinykov.HelloGWTHibernate.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.yevgenoliinykov.HelloGWTHibernate.shared.LogInInfo;

public interface LogInServiceAsync {

    void logIn(String login, String password, AsyncCallback<LogInInfo> callback);

    void logInFromSession(String sessionID, AsyncCallback<LogInInfo> callback);

    void logOut(AsyncCallback<Void> callback);

}
