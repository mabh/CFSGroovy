/*
* Copyright (c) 2013-2014 Software AG, Darmstadt, Germany 
* and/or Software AG USA Inc., Reston, VA, USA, and/or 
* its subsidiaries and or/its affiliates and/or their 
* licensors.
* Use, reproduction, transfer, publication or disclosure 
* is prohibited except as specifically provided for in your 
* License Agreement with Software AG.
*/

package com.wm.tn.manager.jenkinscli

import hudson.cli.CLI
import hudson.cli.CLIConnectionFactory

class JenkinsCLIWrapper {
	
	/**
	 * runs a cLI command with args
	 * @param url	jenkins server url
	 * @param args	list of args
	 * @param ins	Input stream
	 * @param outs	Output stream
	 * @param errs	Error stream
	 * @return
	 */
	static def executeCLI(String url, List args, ins, outs, errs) {
		try {
			CLI cli = (new CLIConnectionFactory())
							.url(url)
							.connect()
			cli.execute(args, ins, outs, errs)
			cli.close()
		} catch(Exception e) {
			throw e					
		}
	}
}
