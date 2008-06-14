/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */

package org.puremvc.java.core.controller;

/**
 * A utility class used by ControllerTest.
 * 
 * @see org.puremvc.java.core.controller.ControllerTest ControllerTest
 * @see org.puremvc.java.core.controller.ControllerTestCommand
 *      ControllerTestCommand
 */
public class ControllerTestVO
{

	/**
	 * Constructor.
	 * 
	 * @param input
	 *            the number to be fed to the ControllerTestCommand
	 */
	public ControllerTestVO( int input )
	{
		this.input = input;
	}

	/**
	 * 
	 */
	public int input;

	/**
	 * 
	 */
	public int result;
}