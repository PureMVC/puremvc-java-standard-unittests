/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.patterns.proxy;

import org.puremvc.java.patterns.proxy.Proxy;

import junit.framework.TestCase;

/**
 *
 */
public class ProxyTest extends TestCase
{

	/**
	 * Constructor.
	 * 
	 * @param methodName
	 *            the name of the test method an instance to run
	 */
	public ProxyTest( String methodName )
	{
		super( methodName );
	}

	/**
	 * Tests getting the name using Proxy class accessor method. Setting can
	 * only be done in constructor.
	 */
	public void testNameAccessor( )
	{

		// Create a new Proxy and use accessors to set the proxy name
		Proxy proxy = new Proxy( "TestProxy", null );

		// test assertions
		assertTrue( "Expecting proxy.getProxyName() == 'TestProxy'",
				proxy.getProxyName().equals( "TestProxy" ) );
	}

	/**
	 * Tests setting and getting the data using Proxy class accessor methods.
	 */
	public void testDataAccessors( )
	{

		// Create a new Proxy and use accessors to set the data
		Proxy proxy = new Proxy( "colors", null );
		String[] myArray = { "red", "green", "blue" };
		proxy.setData( myArray );
		String[] data = (String[]) proxy.getData();

		// test assertions
		assertTrue( "Expecting data.length == 3", data.length == 3 );
		assertTrue( "Expecting data[0] == 'red'", data[0] == "red" );
		assertTrue( "Expecting data[1] == 'green'", data[1] == "green" );
		assertTrue( "Expecting data[2] == 'blue'", data[2] == "blue" );
	}

	/**
	 * Tests setting the name and body using the Notification class Constructor.
	 */
	public void testConstructor( )
	{

		// Create a new Proxy using the Constructor to set the name and data
		String[] myArray = { "red", "green", "blue" };
		Proxy proxy = new Proxy( "colors", myArray );
		String[] data = (String[]) proxy.getData();

		// test assertions
		assertNotNull( "Expecting proxy not null", proxy );
		assertTrue( "Expecting proxy.getProxyName() == 'colors'",
				proxy.getProxyName() == "colors" );
		assertTrue( "Expecting data.length == 3", data.length == 3 );
		assertTrue( "Expecting data[0] == 'red'", data[0] == "red" );
		assertTrue( "Expecting data[1] == 'green'", data[1] == "green" );
		assertTrue( "Expecting data[2] == 'blue'", data[2] == "blue" );
	}
}
