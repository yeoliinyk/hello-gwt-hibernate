package com.yevgenoliinykov.HelloGWTHibernate.server.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mindrot.jbcrypt.BCrypt;

import com.yevgenoliinykov.HelloGWTHibernate.server.integration.UserDAO;
import com.yevgenoliinykov.HelloGWTHibernate.server.model.User;
import com.yevgenoliinykov.HelloGWTHibernate.server.util.HibernateUtil;

/**
 * This service class add default users into database before the web application
 * is started.
 *
 * @author Yevgen Oliinykov
 *
 */
public class DbStartUpInitService implements ServletContextListener {

    private UserDAO userDAO = new UserDAO();

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
	HibernateUtil.closeEntityManager();
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
	List<User> defaultUsers = new ArrayList<>();
	defaultUsers.add(new User("ivan", "secret", "Иван"));
	defaultUsers.add(new User("john", "smith", "John"));
	for (User user : defaultUsers) {
	    userDAO.createUser(new User(user.getLogin(), BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()), user
		    .getFirstName()));
	}
    }
}