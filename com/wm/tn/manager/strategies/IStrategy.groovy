/*
* Copyright (c) 2013-2014 Software AG, Darmstadt, Germany 
* and/or Software AG USA Inc., Reston, VA, USA, and/or 
* its subsidiaries and or/its affiliates and/or their 
* licensors.
* Use, reproduction, transfer, publication or disclosure 
* is prohibited except as specifically provided for in your 
* License Agreement with Software AG.
*/

package com.wm.tn.manager.strategies

interface IStrategy {
	
	/*
	 * needed properties in a strategy
	 */
	def name			//name of the strategy
	def parameters		//parameters which it uses
	def log				//where output goes
	
	def execute()
}
