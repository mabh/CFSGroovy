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

import groovy.transform.ToString

/*
 * Perform scalability testing
 * strategy contained in a run which are executed sequentially
 */
@ToString(includeNames=true)
class TNScalabilityTestingStrategy implements IStrategy {

	def name
	def parameters = [:]
	def log
	
	def execute() {
		println Thread.currentThread().getName() + " " + name
		parameters.each {
			k, v -> println Thread.currentThread().getName() + " $k, $v"
		}
		println this.hashCode()
	}

}
