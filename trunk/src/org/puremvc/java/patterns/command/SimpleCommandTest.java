/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.patterns.command;

import junit.framework.TestCase;

import org.puremvc.java.patterns.observer.Notification;

/**
 * Test the PureMVC SimpleCommand class.
 * 
 * @see org.puremvc.java.patterns.command.SimpleCommandTestVO
 *      SimpleCommandTestVO
 * @see org.puremvc.java.patterns.command.SimpleCommandTestCommand
 *      SimpleCommandTestCommand
 */
public class SimpleCommandTest extends TestCase
{

	/**
	 * Constructor.
	 * 
	 * @param methodName
	 *            the name of the test method an instance to run
	 */
	public SimpleCommandTest( String methodName )
	{
		super( methodName );
	}

	/**
	 * Tests the <code>execute</code> method of a <code>SimpleCommand</code>.
	 * 
	 * <P>
	 * This test creates a new <code>Notification</code>, adding a
	 * <code>SimpleCommandTestVO</code> as the body. It then creates a
	 * <code>SimpleCommandTestCommand</code> and invokes its
	 * <code>execute</code> method, passing in the note.
	 * </P>
	 * 
	 * <P>
	 * Success is determined by evaluating a property on the object that was
	 * passed on the Notification body, which will be modified by the
	 * SimpleCommand
	 * </P>.
	 * 
	 */
	public void testSimpleCommandExecute( )
	{

		// Create the VO
		SimpleCommandTestVO vo = new SimpleCommandTestVO( 5 );

		// Create the Notification (note)
		Notification note = new Notification( "SimpleCommandTestNote", vo, null );

		// Create the SimpleCommand
		SimpleCommandTestCommand command = new SimpleCommandTestCommand();

		// Execute the SimpleCommand
		command.execute( note );

		// test assertions
		assertTrue( "Expecting vo.result == 10", vo.result == 10 );

	}

}