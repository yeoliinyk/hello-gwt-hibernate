package com.yevgenoliinykov.HelloGWTHibernate.shared;

import java.io.Serializable;

public class LogInInfo implements Serializable {

    private static final long serialVersionUID = 8645085525139698182L;

    private String firstName;
    private Boolean isLoggedIn;
    private String sessionId;

    public LogInInfo() {

    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public Boolean getIsLoggedIn() {
	return isLoggedIn;
    }

    public void setIsLoggedIn(Boolean isLoggedIn) {
	this.isLoggedIn = isLoggedIn;
    }

    public String getSessionId() {
	return sessionId;
    }

    public void setSessionId(String sessionId) {
	this.sessionId = sessionId;
    }

}
