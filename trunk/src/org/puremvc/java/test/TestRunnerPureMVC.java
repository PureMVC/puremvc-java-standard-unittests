/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.test;

import junit.framework.TestResult;
import junit.framework.TestSuite;

import org.puremvc.java.core.controller.ControllerTest;
import org.puremvc.java.core.model.ModelTest;
import org.puremvc.java.core.view.ViewTest;
import org.puremvc.java.patterns.command.MacroCommandTest;
import org.puremvc.java.patterns.command.SimpleCommandTest;
import org.puremvc.java.patterns.facade.FacadeTest;
import org.puremvc.java.patterns.mediator.MediatorTest;
import org.puremvc.java.patterns.observer.NotificationTest;
import org.puremvc.java.patterns.observer.ObserverTest;
import org.puremvc.java.patterns.proxy.ProxyTest;

/**
 * @author Michael Watzek
 */
public class TestRunnerPureMVC extends junit.textui.TestRunner
{

	/**
	 * @param args
	 */
	public static void main( String[] args )
	{

		TestSuite suite = new TestSuite();
		suite.addTestSuite( ControllerTest.class );

		suite.addTestSuite( ModelTest.class );

		suite.addTestSuite( ViewTest.class );

		suite.addTestSuite( MacroCommandTest.class );
		suite.addTestSuite( SimpleCommandTest.class );

		suite.addTestSuite( FacadeTest.class );

		suite.addTestSuite( MediatorTest.class );

		suite.addTestSuite( NotificationTest.class );
		suite.addTestSuite( ObserverTest.class );

		suite.addTestSuite( ProxyTest.class );

		TestResult result = run( suite );
		if (result.errorCount() > 0 || result.failureCount() > 0) {
			System.exit( -1 );
		}
	}
}
