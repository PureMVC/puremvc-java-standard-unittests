/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.patterns.command;

import org.puremvc.java.interfaces.*;
import org.puremvc.java.patterns.command.SimpleCommand;

/**
 * A SimpleCommand subclass used by MacroCommandTestCommand.
 * 
 * @see org.puremvc.java.patterns.command.MacroCommandTest MacroCommandTest
 * @see org.puremvc.java.patterns.command.MacroCommandTestCommand
 *      MacroCommandTestCommand
 * @see org.puremvc.java.patterns.command.MacroCommandTestVO MacroCommandTestVO
 */
public class MacroCommandTestSub1Command extends SimpleCommand
{

	/**
	 * Constructor for <code>MacroCommandTestSub1Command</code>
	 */
	public MacroCommandTestSub1Command( )
	{
		super();
	}

	/**
	 * Fabricate a result by multiplying the input by 2
	 * 
	 * @param note
	 *            the <code>INotification</code> carrying the
	 *            <code>MacroCommandTestVO</code>
	 */
	public void execute( INotification note )
	{

		MacroCommandTestVO vo = (MacroCommandTestVO) note.getBody();

		// Fabricate a result
		vo.result1 = 2 * vo.input;

	}

}