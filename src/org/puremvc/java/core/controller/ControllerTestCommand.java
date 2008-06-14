/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.core.controller;

import org.puremvc.java.interfaces.*;
import org.puremvc.java.patterns.command.*;

/**
 * A SimpleCommand subclass used by ControllerTest.
 * 
 */
public class ControllerTestCommand extends SimpleCommand
{

	/**
	 * Constructor.
	 */
	public ControllerTestCommand( )
	{
		super();
	}

	/**
	 * Fabricate a result by multiplying the input by 2
	 * 
	 * @param note
	 *            the note carrying the ControllerTestVO
	 */
	public void execute( INotification note )
	{

		ControllerTestVO vo = (ControllerTestVO) note.getBody();

		// Fabricate a result
		vo.result = 2 * vo.input;

	}

}