/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.patterns.mediator;

import junit.framework.TestCase;

/**
 * Test the PureMVC Mediator class.
 * 
 * @see org.puremvc.java.interfaces.IMediator IMediator
 * @see org.puremvc.java.patterns.mediator.Mediator Mediator
 */
public class MediatorTest extends TestCase
{

	/**
	 * Constructor.
	 * 
	 * @param methodName
	 *            the name of the test method an instance to run
	 */
	public MediatorTest( String methodName )
	{
		super( methodName );
	}

	/**
	 * Tests getting the name using Mediator class accessor method.
	 */
	public void testNameAccessor( )
	{

		// Create a new Mediator and use accessors to set the mediator name
		Mediator mediator = new Mediator( null,  null );

		// test assertions
		assertTrue( "Expecting mediator.getMediatorName() == Mediator.NAME",
				mediator.getMediatorName() == Mediator.NAME );
	}

	/**
	 * Tests getting the name using Mediator class accessor method.
	 */
	public void testViewAccessor( )
	{

		// Create a view object
		Object view = new Object();

		// Create a new Proxy and use accessors to set the proxy name
		Mediator mediator = new Mediator( null, view );

		// test assertions
		assertNotNull( "Expecting mediator.getViewComponent() not null",
				mediator.getViewComponent() );
	}

}