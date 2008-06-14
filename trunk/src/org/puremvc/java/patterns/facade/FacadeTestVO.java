/*
 * PureMVC - Copyright(c) 2006, 2007 FutureScale, Inc., Some rights reserved.
 * Your reuse is governed by Creative Commons Attribution 2.5 License
 */
package org.puremvc.java.patterns.facade;
/**
 * A utility class used by FacadeTest.
 * 
 * @see org.puremvc.java.patterns.facade.FacadeTest FacadeTest
 * @see org.puremvc.java.patterns.facade.FacadeTestCommand FacadeTestCommand
 */
public class FacadeTestVO
{

	/**
	 * Constructor.
	 * 
	 * @param input
	 *            the number to be fed to the FacadeTestCommand
	 */
	public FacadeTestVO( int input )
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