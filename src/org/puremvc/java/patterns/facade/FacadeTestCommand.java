/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.patterns.facade;

import org.puremvc.java.interfaces.*;
import org.puremvc.java.patterns.command.*;

/**
 * A SimpleCommand subclass used by FacadeTest.
 * 
 * @see org.puremvc.java.patterns.facade.FacadeTest FacadeTest
 * @see org.puremvc.java.patterns.facade.FacadeTestVO FacadeTestVO
 */
public class FacadeTestCommand extends SimpleCommand
{

	/**
	 * Constructor.
	 */
	public FacadeTestCommand( )
	{
		super();
	}

	/**
	 * Fabricate a result by multiplying the input by 2
	 * 
	 * @param note
	 *            the Notification carrying the FacadeTestVO
	 */
	public void execute( INotification note )
	{

		FacadeTestVO vo = (FacadeTestVO) note.getBody();

		// Fabricate a result
		vo.result = 2 * vo.input;

	}

}