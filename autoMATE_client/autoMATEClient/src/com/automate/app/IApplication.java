package com.automate.app;

import com.automate.app.route.Route;

/**
 * Interface for central application singleton.
 */
public interface IApplication {

	/**
	 * Called when the application starts.  Performs system-wide 
	 * Initialisation.
	 */
	public void initialize();
	
	/**
	 * Called by application route delegates to handle application routes.
	 * @param route the route to handle.
	 */
	public void handleRoute(Route<?> route);
	
}
