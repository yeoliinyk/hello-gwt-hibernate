package com.yevgenoliinykov.HelloGWTHibernate.server.integration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.apache.log4j.Logger;

import com.yevgenoliinykov.HelloGWTHibernate.server.model.User;
import com.yevgenoliinykov.HelloGWTHibernate.server.util.HibernateUtil;

public class UserDAO {

    private static Logger logger = Logger.getLogger(UserDAO.class);

    private EntityManager em = HibernateUtil.getEntityManager();

    /**
     * Save user to database if there is no user with such login.
     *
     * @param user
     *            user entity
     */
    public void createUser(User user) {
	if (findUserByLogin(user.getLogin()) == null) {
	    EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    em.persist(user);
	    transaction.commit();
	    logger.info("User '" + user.getLogin() + "' successfully added to DB");
	} else {
	    logger.info("User '" + user.getLogin() + "' is already exist in DB");
	}
    }

    /**
     * Returns user with specified 'login' if user exits in database and 'null'
     * if not.
     *
     * @param login
     *            user login
     * @return target user if exist or null.
     */
    public User findUserByLogin(String login) {
	try {
	    User user = em.createNamedQuery("User.findUserByLogin", User.class).setParameter("login", login)
		    .getSingleResult();
	    return user;
	} catch (NoResultException e) {
	    return null;
	}
    }

}
