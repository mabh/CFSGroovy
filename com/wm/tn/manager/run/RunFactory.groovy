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

import com.wm.tn.manager.strategies.IStrategy

@Singleton
class RunFactory {
	
	/**
	 * @param runBlock	xml representation of run block
	 * @return run Object
	 */
	def create(runBlock) {
		def run = new Run();
		
		run.name = runBlock.@name.text()
		
		runBlock.machine.each {
			run.machines[it.@name.text()] = it.@image.text()
		}
		
		//log file
		run.log = new FileOutputStream(runBlock.log[0].@file.text(), true)
		
		runBlock.strategy.each {
			IStrategy strategy = Class.forName(it.@class.text()).newInstance()
			strategy.name = it.@name.text()
			it.parameter.each {
				if("" == it.@type.text()) {
					//if type is not there param value is simply the value in XML
					strategy.parameters[it.@name.text()] = it.@value.text()
				} else {
					//else it is the result of some computation depending on type
					strategy.parameters[it.@name.text()] = 
							TypeMap.instance.typeMap[it.@type.text()](run.machines[it.@value.text()])[it.@property.text()]
				}
			}
			strategy.log = run.log
			run.strategies.add(strategy)
		}
		
		//eval and return
		run
	}
}
