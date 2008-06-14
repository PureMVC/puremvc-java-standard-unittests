/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.patterns.facade;

import junit.framework.TestCase;

import org.puremvc.java.interfaces.IFacade;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.observer.Notification;
import org.puremvc.java.patterns.proxy.Proxy;

/**
 * Test the PureMVC Facade class.
 * 
 * @see org.puremvc.java.patterns.facade.FacadeTestVO FacadeTestVO
 * @see org.puremvc.java.patterns.facade.FacadeTestCommand FacadeTestCommand
 */
public class FacadeTest extends TestCase
{

	/**
	 * Constructor.
	 * 
	 * @param methodName
	 *            the name of the test method an instance to run
	 */
	public FacadeTest( String methodName )
	{
		super( methodName );
	}

	/**
	 * Tests the Facade Singleton Factory Method
	 */
	public void testGetInstance( )
	{

		// Test Factory Method
		IFacade facade = Facade.getInstance();

		// test assertions
		assertTrue( "Expecting instance not null", facade != null );

		// does not apply to Java
//		assertTrue( "Expecting instance implements IFacade",
//				facade instanceof IFacade );

	}

	/**
	 * Tests Command registration and execution via the Facade.
	 * 
	 * <P>
	 * This test gets the Singleton Facade instance and registers the
	 * FacadeTestCommand class to handle 'FacadeTest' Notifcations.
	 * <P>
	 * 
	 * <P>
	 * It then constructs such a Notification and notifies Observers via the
	 * Facade. Success is determined by evaluating a property on an object
	 * placed in the body of the Notification, which will be modified by the
	 * Command.
	 * </P>
	 * 
	 */
	public void testRegisterCommandAndNotifyObservers( )
	{

		// Create the Facade, register the FacadeTestCommand to
		// handle 'FacadeTest' events
		IFacade facade = Facade.getInstance();
		facade.registerCommand( "FacadeTestNote",
				org.puremvc.java.patterns.facade.FacadeTestCommand.class );

		// Create a 'FacadeTest' event
		FacadeTestVO vo = new FacadeTestVO( 32 );
		INotification note = new Notification( "FacadeTestNote", vo, null );

		// Notify Observers. The Command associated with the event
		// (FacadeTestCommand) will be invoked, and will multiply
		// the vo.input value by 2 and set the result on vo.result
		facade.notifyObservers( note );

		// test assertions
		assertTrue( "Expecting vo.result == 64", vo.result == 64 );
	}

	/**
	 * Tests the regsitering and retrieving Model proxys via the Facade.
	 * 
	 * <P>
	 * Tests <code>registerModelProxy</code> and
	 * <code>retrieveModelProxy</code> in the same test. These methods cannot
	 * currently be tested separately in any meaningful way other than to show
	 * that the methods do not throw exception when called.
	 * </P>
	 */
	public void testRegisterAndRetrieveProxy( )
	{

		// register a proxy and retrieve it.
		IFacade facade = Facade.getInstance();
		facade.registerProxy( new Proxy( "colors", new String[] { "red",
				"green", "blue" } ) );
		Proxy proxy = (Proxy) facade.retrieveProxy( "colors" );

		// test assertions
		// does not apply to Java
//		assertTrue( "Expecting proxy is IProxy", proxy instanceof IProxy );

		// retrieve data from proxy
		Object[] data = (Object[]) proxy.getData();

		// test assertions
		assertNotNull( "Expecting data not null", data );
		
		// does not apply to Java
//		assertTrue( "Expecting data is Array", data instanceof Object[] );
		assertTrue( "Expecting data.length == 3", data.length == 3 );
		assertTrue( "Expecting data[0] == 'red'", data[0].equals( "red" ) );
		assertTrue( "Expecting data[1] == 'green'", data[1].equals( "green" ) );
		assertTrue( "Expecting data[2] == 'blue'", data[2].equals( "blue" ) );
	}

	/**
	 * Tests the removing Model proxys via the Facade.
	 */
	public void testRegisterAndRemoveProxy( )
	{

		// register a proxy, remove it, then try to retrieve it
		IFacade facade = Facade.getInstance();
		facade.registerProxy( new Proxy( "sizes", new String[] { "7", "13",
				"21" } ) );
		facade.removeProxy( "sizes" );
		IProxy proxy = facade.retrieveProxy( "sizes" );

		// test assertions
		assertNull( "Expecting proxy is null", proxy );
	}

}