/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.core.view;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.patterns.mediator.Mediator;

/**
 * A Mediator class used by ViewTest.
 * 
 * @see org.puremvc.java.core.view.ViewTest ViewTest
 */
public class ViewTestMediator extends Mediator implements IMediator
{

	/**
	 * The Mediator name
	 */
	public static final String NAME = "ViewTestMediator";

	/**
	 * Constructor
	 * @param view 
	 */
	public ViewTestMediator( Object view )
	{
		super( NAME, view );
	}

	/**
	 * @see org.puremvc.java.patterns.mediator.Mediator#listNotificationInterests()
	 */
	public String[] listNotificationInterests( )
	{
		// be sure that the mediator has some Observers created
		// in order to test removeMediator
		return new String[] { "ABC", "DEF", "GHI" };
	}



}