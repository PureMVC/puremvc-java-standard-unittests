/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.patterns.command;
/**
 * A utility class used by MacroCommandTest.
 * 
 * @see org.puremvc.java.patterns.command.MacroCommandTest MacroCommandTest
 * @see org.puremvc.java.patterns.command.MacroCommandTestCommand
 *      MacroCommandTestCommand
 * @see org.puremvc.java.patterns.command.MacroCommandTestSub1Command
 *      MacroCommandTestSub1Command
 * @see org.puremvc.java.patterns.command.MacroCommandTestSub2Command
 *      MacroCommandTestSub2Command
 */
public class MacroCommandTestVO
{

	/**
	 * Constructor.
	 * 
	 * @param input
	 *            the number to be fed to the MacroCommandTestCommand
	 */
	public MacroCommandTestVO( int input )
	{
		this.input = input;
	}

	/**
	 * The input
	 */
	public int input;

	/**
	 * The first result
	 */
	public int result1;

	/**
	 * The second result
	 */
	public int result2;

}