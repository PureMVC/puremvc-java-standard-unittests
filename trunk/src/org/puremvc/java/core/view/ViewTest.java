/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */

package org.puremvc.java.core.view;

import junit.framework.TestCase;

import org.puremvc.java.core.view.View;
import org.puremvc.java.interfaces.*;
import org.puremvc.java.patterns.observer.*;

/**
 * Test the PureMVC View class.
 */
public class ViewTest extends TestCase
{

	/**
	 * Constructor.
	 * 
	 * @param methodName
	 *            the name of the test method an instance to run
	 */
	public ViewTest( String methodName )
	{
		super( methodName );
	}

	/**
	 * Tests the View Singleton Factory Method
	 */
	public void testGetInstance( )
	{

		// Test Factory Method
		IView view = View.getInstance();

		// test assertions
		assertTrue( "Expecting instance not null", view != null );

//		does not apply to Java		
//		assertTrue( "Expecting instance implements IView",
//				view instanceof IView );

	}

	/**
	 * Tests registration and notification of Observers.
	 * 
	 * <P>
	 * An Observer is created to callback the viewTestMethod of this ViewTest
	 * instance. This Observer is registered with the View to be notified of
	 * 'ViewTestEvent' events. Such an event is created, and a value set on its
	 * payload. Then the View is told to notify interested observers of this
	 * Event.
	 * 
	 * <P>
	 * The View calls the Observer's notifyObserver method which calls the
	 * viewTestMethod on this instance of the ViewTest class. The viewTestMethod
	 * method will set an instance variable to the value passed in on the Event
	 * payload. We evaluate the instance variable to be sure it is the same as
	 * that passed out as the payload of the original 'ViewTestEvent'.
	 * 
	 */
	public void testRegisterAndNotifyObserver( )
	{

		// Get the Singleton View instance
		IView view = View.getInstance();

		// Create observer, passing in notification method and context
		Observer observer = new Observer( new IFunction()
		{

			public void onNotification( INotification notification )
			{
				viewTestMethod( notification );
			}

		}, this );

		// Register Observer's interest in a particulat Notification with the
		// View
		view.registerObserver( ViewTestNote.NAME, observer );

		// Create a ViewTestNote, setting
		// a body value, and tell the View to notify
		// Observers. Since the Observer is this class
		// and the notification method is viewTestMethod,
		// successful notification will result in our local
		// viewTestVar being set to the value we pass in
		// on the note body.
		INotification note = ViewTestNote.create( new String( "10" ) );
		view.notifyObservers( note );

		// test assertions
		assertTrue( "Expecting viewTestVar = 10", this.viewTestVar.equals( "10" ) );
	}

	/**
	 * A test variable that proves the viewTestMethod was invoked by the View.
	 */
	private String viewTestVar;

	/**
	 * A utility method to test the notification of Observers by the view
	 */
	private void viewTestMethod( INotification note )
	{
		// set the local viewTestVar to the number on the event payload
		this.viewTestVar = (String) note.getBody();
	}

	/**
	 * Tests registering and retrieving a mediator with the View.
	 */
	public void testRegisterAndRetrieveMediator( )
	{

		// Get the Singleton View instance
		IView view = View.getInstance();

		// Create and register the test mediator
		ViewTestMediator viewTestMediator = new ViewTestMediator( this );
		view.registerMediator( viewTestMediator );

		// Retrieve the component
		IMediator mediator = view.retrieveMediator( ViewTestMediator.NAME );

		// test assertions
		assertTrue( "Expecting comp is ViewTestMediator",
				mediator instanceof ViewTestMediator );

		cleanup();

	}

	/**
	 * Tests registering and removing a mediator
	 */
	public void testRegisterAndRemoveMediator( )
	{

		// Get the Singleton View instance
		IView view = View.getInstance();

		// Create and register the test mediator,
		// but not so we have a reference to it
		view.registerMediator( new ViewTestMediator( this ) );

		// Remove the component
		view.removeMediator( ViewTestMediator.NAME );

		// test assertions
		assertTrue(
				"Expecting view.retrieveMediator( ViewTestMediator.NAME ) == null )",
				view.retrieveMediator( ViewTestMediator.NAME ) == null );

	}

	/**
	 * Tests successive regster and remove of same mediator.
	 */
	public void testSuccessiveRegisterAndRemoveMediator( )
	{

		// Get the Singleton View instance
		IView view = View.getInstance();

		// Create and register the test mediator,
		// but not so we have a reference to it
		view.registerMediator( new ViewTestMediator( this ) );

		// test that we can retrieve it
		assertTrue(
				"Expecting view.retrieveMediator( ViewTestMediator.NAME ) is ViewTestMediator",
				view.retrieveMediator( ViewTestMediator.NAME ) instanceof ViewTestMediator );

		// Remove the Mediator
		view.removeMediator( ViewTestMediator.NAME );

		// test that retrieving it now returns null
		assertTrue(
				"Expecting view.retrieveMediator( ViewTestMediator.NAME ) == null",
				view.retrieveMediator( ViewTestMediator.NAME ) == null );

		// test that removing the mediator again once its gone doesn't cause
		// crash
		view.removeMediator( ViewTestMediator.NAME );

		// Create and register another instance of the test mediator,
		view.registerMediator( new ViewTestMediator( this ) );

		assertTrue(
				"Expecting view.retrieveMediator( ViewTestMediator.NAME ) is ViewTestMediator",
				view.retrieveMediator( ViewTestMediator.NAME ) instanceof ViewTestMediator );

		// Remove the Mediator
		view.removeMediator( ViewTestMediator.NAME );

		// test that retrieving it now returns null
		assertTrue(
				"Expecting view.retrieveMediator( ViewTestMediator.NAME ) == null",
				view.retrieveMediator( ViewTestMediator.NAME ) == null );

		cleanup();
	}

	private void cleanup( )
	{
		View.getInstance().removeMediator( ViewTestMediator.NAME );
	}
}