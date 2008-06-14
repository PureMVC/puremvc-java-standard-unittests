/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.patterns.observer;

import junit.framework.TestCase;

import org.puremvc.java.interfaces.*;
import org.puremvc.java.patterns.observer.Notification;
import org.puremvc.java.patterns.observer.Observer;

/**
 *
 */
public class ObserverTest extends TestCase implements IFunction
{

	/**
	 * Constructor.
	 * 
	 * @param methodName
	 *            the name of the test method an instance to run
	 */
	public ObserverTest( String methodName )
	{
		super( methodName );
	}

	/**
	 * Tests observer class when initialized by accessor methods.
	 * 
	 */
	public void testObserverAccessors( )
	{

		// Create observer with null args, then
		// use accessors to set notification method and context
		Observer observer = new Observer( null, null );
		observer.setNotifyContext( this );
		observer.setNotifyMethod( this );

		// create a test event, setting a payload value and notify
		// the observer with it. since the observer is this class
		// and the notification method is observerTestMethod,
		// successful notification will result in our local
		// observerTestVar being set to the value we pass in
		// on the note body.
		Notification note = new Notification( "ObserverTestNote", "10", null );
		observer.notifyObserver( note );

		// test assertions
		assertTrue( "Expecting observerTestVar = 10",
				this.observerTestVar.equals( "10" ) );
	}

	/**
	 * Tests observer class when initialized by constructor.
	 * 
	 */
	public void testObserverConstructor( )
	{

		// Create observer passing in notification method and context
		Observer observer = new Observer( this, this );

		// create a test note, setting a body value and notify
		// the observer with it. since the observer is this class
		// and the notification method is observerTestMethod,
		// successful notification will result in our local
		// observerTestVar being set to the value we pass in
		// on the note body.
		Notification note = new Notification( "ObserverTestNote", "5", null );
		observer.notifyObserver( note );

		// test assertions
		assertTrue( "Expecting observerTestVar = 5",
				this.observerTestVar.equals( "5" ) );
	}

	/**
	 * Tests the compareNotifyContext method of the Observer class
	 * 
	 */
	public void testCompareNotifyContext( )
	{

		// Create observer passing in notification method and context
		Observer observer = new Observer( this, this );

		Object negTestObj = new Object();

		// test assertions
		assertTrue(
				"Expecting observer.compareNotifyContext(negTestObj) == false",
				observer.compareNotifyContext( negTestObj ) == false );
		assertTrue( "Expecting observer.compareNotifyContext(this) == true",
				observer.compareNotifyContext( this ) == true );
	}

	/**
	 * A test variable that proves the notify method was executed with 'this' as
	 * its exectution context
	 */
	private String observerTestVar;

	/**
	 * A function that is used as the observer notification method. It
	 * multiplies the input number by the observerTestVar value
	 * @param note 
	 */

	public void onNotification( INotification note )
	{
		this.observerTestVar = (String) note.getBody();
	}

	// never used
//	private void observerTestMethod( )
//	{
//
//	}
}
