/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.core.view;

import org.puremvc.java.interfaces.*;
import org.puremvc.java.patterns.observer.*;

/**
 * A Notification class used by ViewTest.
 * 
 * @see org.puremvc.java.core.view.ViewTest ViewTest
 */
public class ViewTestNote extends Notification implements INotification
{

	/**
	 * The name of this Notification.
	 */
	public static final String NAME = "ViewTestNote";

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            Ignored and forced to NAME.
	 * @param body
	 *            the body of the Notification to be constructed.
	 */
	public ViewTestNote( String name, Object body )
	{
		super( NAME, body, null );
	}

	/**
	 * Factory method.
	 * 
	 * <P>
	 * This method creates new instances of the ViewTestNote class,
	 * automatically setting the note name so you don't have to. Use this as an
	 * alternative to the constructor.
	 * </P>
	 * 
	 * @param body
	 *            the body of the Notification to be constructed.
	 * @return the created INotification
	 */
	public static INotification create( Object body )
	{
		return new ViewTestNote( NAME, body );
	}

}