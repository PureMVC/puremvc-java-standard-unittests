/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.patterns.command;

import org.puremvc.java.interfaces.*;
import org.puremvc.java.patterns.command.SimpleCommand;

/**
 * A SimpleCommand subclass used by SimpleCommandTest.
 * 
 * @see org.puremvc.java.patterns.command.SimpleCommandTest SimpleCommandTest
 * @see org.puremvc.java.patterns.command.SimpleCommandTestVO
 *      SimpleCommandTestVO
 */
public class SimpleCommandTestCommand extends SimpleCommand
{

	/**
	 * Constructor.
	 */
	public SimpleCommandTestCommand( )
	{
		super();
	}

	/**
	 * Fabricate a result by multiplying the input by 2
	 * 
	 * @param note
	 *            the <code>INotification</code> carrying the
	 *            <code>SimpleCommandTestVO</code>
	 */
	public void execute( INotification note )
	{

		SimpleCommandTestVO vo = (SimpleCommandTestVO) note.getBody();

		// Fabricate a result
		vo.result = 2 * vo.input;

	}

}