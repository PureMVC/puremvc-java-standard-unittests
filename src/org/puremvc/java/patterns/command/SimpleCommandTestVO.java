/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.patterns.command;
/**
 * A utility class used by SimpleCommandTest.
 * 
 * @see org.puremvc.java.patterns.command.SimpleCommandTest SimpleCommandTest
 * @see org.puremvc.java.patterns.command.SimpleCommandTestCommand
 *      SimpleCommandTestCommand
 */
public class SimpleCommandTestVO
{

	/**
	 * Constructor.
	 * 
	 * @param input
	 *            the number to be fed to the SimpleCommandTestCommand
	 */
	public SimpleCommandTestVO( int input )
	{
		this.input = input;
	}

	/**
	 * The input
	 */
	public int input;

	/**
	 * The result
	 */
	public int result;
}