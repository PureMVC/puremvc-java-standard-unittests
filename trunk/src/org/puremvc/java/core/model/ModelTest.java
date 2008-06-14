/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.core.model;

import junit.framework.TestCase;

import org.puremvc.java.core.model.Model;
import org.puremvc.java.interfaces.*;
import org.puremvc.java.patterns.proxy.*;

/**
 * Test the PureMVC Model class.
 */
public class ModelTest extends TestCase
{

	/**
	 * Constructor.
	 * 
	 * @param methodName
	 *            the name of the test method an instance to run
	 */
	public ModelTest( String methodName )
	{
		super( methodName );
	}

	/**
	 * Tests the Model Singleton Factory Method
	 */
	public void testGetInstance( )
	{
		// Test Factory Method
		IModel model = Model.getInstance();

		// test assertions
		assertNotNull( "Expecting instance not null", model );
		
		// does not apply to Java
//		assertTrue( "Expecting instance implements IModel",
//				model instanceof IModel );
	}

	/**
	 * Tests the proxy registration and retrieval methods.
	 * 
	 * <P>
	 * Tests <code>registerProxy</code> and <code>retrieveProxy</code> in
	 * the same test. These methods cannot currently be tested separately in any
	 * meaningful way other than to show that the methods do not throw exception
	 * when called.
	 * </P>
	 */
	public void testRegisterAndRetrieveProxy( )
	{

		// register a proxy and retrieve it.
		IModel model = Model.getInstance();
		model.registerProxy( new Proxy( "colors", new String[] { "red",
				"green", "blue" } ) );
		Proxy proxy = (Proxy) model.retrieveProxy( "colors" );
		String[] data = (String[]) proxy.getData();

		// test assertions
		assertNotNull( "Expecting data not null", data );
		
		// does not apply to Java
//		assertTrue( "Expecting data type is Array", data instanceof String[] );
		
		assertTrue( "Expecting data.length == 3", data.length == 3 );
		assertTrue( "Expecting data[0] == 'red'", data[0].equals( "red" ) );
		assertTrue( "Expecting data[1] == 'green'", data[1].equals( "green" ) );
		assertTrue( "Expecting data[2] == 'blue'", data[2].equals( "blue" ) );
	}

	/**
	 * Tests the proxy removal method.
	 */
	public void testRegisterAndRemoveProxy( )
	{

		// register a proxy, remove it, then try to retrieve it
		IModel model = Model.getInstance();
		model.registerProxy( new Proxy( "sizes",
				new String[] { "7", "13", "21" } ) );
		model.removeProxy( "sizes" );
		Proxy proxy = (Proxy) model.retrieveProxy( "sizes" );

		// test assertions
		assertNull( "Expecting proxy is null", proxy );
	}

}