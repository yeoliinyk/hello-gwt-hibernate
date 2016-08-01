package com.yevgenoliinykov.HelloGWTHibernate.server.services;

import java.util.logging.Level;
import java.util.logging.LogRecord;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;

import com.google.gwt.logging.shared.RemoteLoggingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GwtRemoteLogging extends RemoteServiceServlet implements RemoteLoggingService {

    private static final long serialVersionUID = -3813305219164122053L;

    /** The Constant logger. */
    private final static Logger logger = Logger.getLogger("gwtRemoteLogging");

    @Override
    public void init(ServletConfig config) throws ServletException {
	super.init(config);
    }

    /**
     * Logs a Log Record which has been serialized using GWT RPC on the server.
     *
     * @return either an error message, or null if logging is successful.
     */
    @Override
    public final String logOnServer(LogRecord lr) {
	try {
	    if (lr.getLevel().equals(Level.SEVERE)) {
		logger.error(lr.getMessage(), lr.getThrown());
	    } else if (lr.getLevel().equals(Level.INFO)) {
		logger.info(lr.getMessage(), lr.getThrown());
	    } else if (lr.getLevel().equals(Level.WARNING)) {
		logger.warn(lr.getMessage(), lr.getThrown());
	    } else if (lr.getLevel().equals(Level.FINE)) {
		logger.debug(lr.getMessage(), lr.getThrown());
	    } else {
		logger.trace(lr.getMessage(), lr.getThrown());
	    }
	} catch (Exception e) {
	    logger.error("Remote logging failed", e);
	    return "Remote logging failed, check stack trace for details.";
	}
	return null;
    }
}