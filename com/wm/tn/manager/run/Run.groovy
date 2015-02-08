/*
* Copyright (c) 2013-2014 Software AG, Darmstadt, Germany 
* and/or Software AG USA Inc., Reston, VA, USA, and/or 
* its subsidiaries and or/its affiliates and/or their 
* licensors.
* Use, reproduction, transfer, publication or disclosure 
* is prohibited except as specifically provided for in your 
* License Agreement with Software AG.
*/

package com.wm.tn.manager.run

import groovy.transform.ToString
import com.wm.tn.manager.Logger

/*
 * Different runs are executed concurrently by Manager
 * A run is submitted to a thread pool to be executed
 */
@ToString(includeNames=true)
class Run {

	def strategies = []	as List		//list of strategies
	def machines = [:]	as Map		//map of machine name to image name
	def name						//name of the Run
	def log							//output goes here
	
	def run() {
		Logger.log(log, "Run: ${name} - start")
		strategies.each {
			Logger.log(log, "Run: ${name}, Strategy: ${it.name} - start")
			it.execute()
			Logger.log(log, "Run: ${name}, Strategy: ${it.name} - end")
		}
		Logger.log(log, "Run: ${name} - end")
		log.close()
	}
}
