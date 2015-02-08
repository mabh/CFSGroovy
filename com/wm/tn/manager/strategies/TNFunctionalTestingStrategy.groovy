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
import com.wm.tn.manager.Logger
import com.wm.tn.manager.jenkinscli.JenkinsCLIWrapper

/*
 * strategy contained in a run which are executed sequentially
 * Runs functionals tests (junits) for TN
 * Uses Jenkins jobs on build server to invoke the build/deploy/junit process
 * Params required:
 * 		jenkinsServer
 * 		jenkinsJob0
 */
@ToString(includeNames=true)
class TNFunctionalTestingStrategy implements IStrategy {
	
	def name
	def parameters = [:]
	def log
		
	def execute() {
		/*
		 * TN functional testing is intended to be done via allready written
		 * jenkins jobs.
		 * we need to start build on the right job with proper paramters required
		 * for that job 
		 * call jenkins api here
		 */
		try {
			
			JenkinsCLIWrapper.executeCLI(
								parameters["jenkinsServer"],
								["build", parameters["jenkinsJob0"], "-s", "-v"],
								System.in,
								log,
								System.err)

			/*
			JenkinsCLIWrapper.executeCLI(
				parameters["jenkinsServer"],
				["list-jobs"],
				System.in,
				log,
				System.err)
			*/
		} catch(Exception e) {
			Logger.log(log, "Class: TNFunctionalTestingStrategy, Thread: ${Thread.currentThread().getName()}, Exception: ${e}")
		}
	}
}
