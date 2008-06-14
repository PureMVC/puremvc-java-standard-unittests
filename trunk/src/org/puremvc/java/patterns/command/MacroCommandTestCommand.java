/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.patterns.command;


/**
 * A MacroCommand subclass used by MacroCommandTest.
 * 
 * @see org.puremvc.java.patterns.command.MacroCommandTest MacroCommandTest
 * @see org.puremvc.java.patterns.command.MacroCommandTestSub1Command
 *      MacroCommandTestSub1Command
 * @see org.puremvc.java.patterns.command.MacroCommandTestSub2Command
 *      MacroCommandTestSub2Command
 * @see org.puremvc.java.patterns.command.MacroCommandTestVO MacroCommandTestVO
 */
public class MacroCommandTestCommand extends MacroCommand
{

	/**
	 * Constructor.
	 */
	public MacroCommandTestCommand( )
	{
		super();
	}

	/**
	 * Initialize the MacroCommandTestCommand by adding its 2 SubCommands.
	 */
	protected void initializeMacroCommand( )
	{
		addSubCommand( org.puremvc.java.patterns.command.MacroCommandTestSub1Command.class );
		addSubCommand( org.puremvc.java.patterns.command.MacroCommandTestSub2Command.class );
	}

}