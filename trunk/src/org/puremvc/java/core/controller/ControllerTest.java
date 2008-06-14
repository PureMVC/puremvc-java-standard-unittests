/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */

package org.puremvc.java.core.controller;

import junit.framework.TestCase;

import org.puremvc.java.interfaces.IController;
import org.puremvc.java.patterns.observer.Notification;

/**
 * Test the PureMVC Controller class.
 * 
 */
public class ControllerTest extends TestCase
{

	/**
	 * Constructor.
	 * 
	 * @param methodName
	 *            the name of the test method an instance to run
	 */
	public ControllerTest( String methodName )
	{
		super( methodName );
	}

	/**
	 * Tests the Controller Singleton Factory Method
	 */
	public void testGetInstance( )
	{

		// Test Factory Method
		IController controller = Controller.getInstance();

		// test assertions
		assertTrue( "Expecting instance not null", controller != null );
		
		// does not apply to Java
//		assertTrue( "Expecting instance implements IController",
//				controller instanceof IController );
	}

	/**
	 * Tests Command registration and execution.
	 * 
	 * <P>
	 * This test gets the Singleton Controller instance and registers the
	 * ControllerTestCommand class to handle 'ControllerTest' Notifications.
	 * <P>
	 * 
	 * <P>
	 * It then constructs such a Notification and tells the Controller to
	 * execute the associated Command. Success is determined by evaluating a
	 * property on an object passed to the Command, which will be modified when
	 * the Command executes.
	 * </P>
	 * 
	 */
	public void testRegisterAndExecuteCommand( )
	{

		// Create the controller, register the ControllerTestCommand to
		// handle 'ControllerTest' notes
		IController controller = Controller.getInstance();
		controller.registerCommand( "ControllerTest",
				org.puremvc.java.core.controller.ControllerTestCommand.class );

		// Create a 'ControllerTest' note
		ControllerTestVO vo = new ControllerTestVO( 12 );
		Notification note = new Notification( "ControllerTest", vo, null );

		// Tell the controller to execute the Command associated with the
		// note
		// the ControllerTestCommand invoked will multiply the vo.input
		// value
		// by 2 and set the result on vo.result
		controller.executeCommand( note );

		// test assertions
		assertTrue( "Expecting vo.result == 24", vo.result == 24 );
	}

	/**
	 * Tests Command registration and removal.
	 * 
	 * <P>
	 * Tests that once a Command is registered and verified working, it can be
	 * removed from the Controller.
	 * </P>
	 */
	public void testRegisterAndRemoveCommand( )
	{

		// Create the controller, register the ControllerTestCommand to
		// handle 'ControllerTest' notes
		IController controller = Controller.getInstance();
		controller.registerCommand( "ControllerRemoveTest",
				org.puremvc.java.core.controller.ControllerTestCommand.class );

		// Create a 'ControllerTest' note
		ControllerTestVO vo = new ControllerTestVO( 12 );
		Notification note = new Notification( "ControllerRemoveTest", vo, null );

		// Tell the controller to execute the Command associated with the
		// note
		// the ControllerTestCommand invoked will multiply the vo.input
		// value
		// by 2 and set the result on vo.result
		controller.executeCommand( note );

		// test assertions
		assertTrue( "Expecting vo.result == 24", vo.result == 24 );

		// Reset result
		vo.result = 0;

		// Remove the Command from the Controller
		controller.removeCommand( "ControllerRemoveTest" );

		// Tell the controller to execute the Command associated with the
		// note. This time, it should not be registered, and our vo result
		// will not change
		controller.executeCommand( note );

		// test assertions
		assertTrue( "Expecting vo.result == 0", vo.result == 0 );

	}
}
