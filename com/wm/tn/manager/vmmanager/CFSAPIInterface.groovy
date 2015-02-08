/*
* Copyright (c) 2013-2014 Software AG, Darmstadt, Germany 
* and/or Software AG USA Inc., Reston, VA, USA, and/or 
* its subsidiaries and or/its affiliates and/or their 
* licensors.
* Use, reproduction, transfer, publication or disclosure 
* is prohibited except as specifically provided for in your 
* License Agreement with Software AG.
*/

package com.wm.tn.manager.vmmanager

@Singleton
class CFSAPIInterface {
	
	/**
	 * Does not start the VM
	 * @param imageName		image identifier for the VM to be created
	 * @return				VM details map
	 */
	def createVM(imageName) {
		/*
		 * call CFS API here and retuen the details
		 * this map is just for example, actual it will be made from output from CFS API
		 */
		[
			arg:				imageName,
			hostname: 			imageName + "vmtest01",
			ip:					"1.1.1.1",
			machineId:			"700630600101",
		]
	}
}
