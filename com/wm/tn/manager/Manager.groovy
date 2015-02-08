/*
* Copyright (c) 2013-2014 Software AG, Darmstadt, Germany 
* and/or Software AG USA Inc., Reston, VA, USA, and/or 
* its subsidiaries and or/its affiliates and/or their 
* licensors.
* Use, reproduction, transfer, publication or disclosure 
* is prohibited except as specifically provided for in your 
* License Agreement with Software AG.
*/

package com.wm.tn.manager

import com.wm.tn.manager.parser.ManagerXMLParser
import com.wm.tn.manager.run.RunFactory
import java.util.concurrent.*

/*
 * Amazon CloudFormation
 */
class Manager {
	
	static init() {
		//some init
	}
	
	static main(args) {
		init()

		//get xml representation
		def xmlRep = ManagerXMLParser.instance.invokeMethod("parse", "src/config.xml")
		
		//make a runList
		def runList = []
		
		//store each run object in the run list
		xmlRep.run.each {
			runList.add(RunFactory.instance.invokeMethod("create", it))
		}
		
		//start a pool of threads
		def runExecutionPool = Executors.newCachedThreadPool()
		def defer = { c -> runExecutionPool.submit(c as Runnable) }

		runList.each {
			defer(it)
		}
		
		//shut it down
		runExecutionPool.shutdown()
	}
}

/*
	- send params to jenkins job in tnfunctest strat
	- xsd
	- jenkins client
	- cfs api integ
	- logging
	- making groovy jar and execution
	


*/
