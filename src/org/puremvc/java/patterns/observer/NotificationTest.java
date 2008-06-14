/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.patterns.observer;

import org.puremvc.java.interfaces.*;
import org.puremvc.java.patterns.observer.Notification;

import junit.framework.TestCase;

/**
 * Test the PureMVC Notification class.
 * 
 * @see org.puremvc.java.patterns.observer.Notification Notification
 */
public class NotificationTest extends TestCase
{

	/**
	 * Constructor.
	 * 
	 * @param methodName
	 *            the name of the test method an instance to run
	 */
	public NotificationTest( String methodName )
	{
		super( methodName );
	}

	/**
	 * Tests setting and getting the name using Notification class accessor
	 * methods.
	 */
	public void testNameAccessors( )
	{

		// Create a new Notification and use accessors to set the note name
		INotification note = new Notification( "TestNote", null, null );

		// test assertions
		assertTrue( "Expecting note.getName() == 'TestNote'",
				note.getName().equals( "TestNote" ) );
	}

	/**
	 * Tests setting and getting the body using Notification class accessor
	 * methods.
	 */
	public void testBodyAccessors( )
	{

		// Create a new Notification and use accessors to set the body
		INotification note = new Notification( null, null, null );
		note.setBody( "5" );

		// test assertions
		assertTrue( "Expecting note.getBody() as Number == 5",
				note.getBody().equals( "5" ) );
	}

	/**
	 * Tests setting the name and body using the Notification class Constructor.
	 */
	public void testConstructor( )
	{

		// Create a new Notification using the Constructor to set the note
		// name and body
		INotification note = new Notification( "TestNote", "5", "TestNoteType" );

		// test assertions
		assertTrue( "Expecting note.getName() == 'TestNote'",
				note.getName().equals( "TestNote" ) );
		assertTrue( "Expecting note.getBody() as Number == 5",
				note.getBody().equals( "5" ) );
		assertTrue( "Expecting note.getType() == 'TestNoteType'",
				note.getType().equals( "TestNoteType" ) );
	}

}
