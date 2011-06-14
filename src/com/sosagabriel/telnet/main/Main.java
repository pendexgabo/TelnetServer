package com.sosagabriel.telnet.main;

import com.sosagabriel.telnet.commands.Command;
import com.sosagabriel.telnet.server.Response;
import com.sosagabriel.telnet.server.Server;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server(3307);
		
		server.registerCommand(new Command("hi") {

			@Override
			public Response handle(String[] arguments) {
				if (arguments.length > 0)
					return new Response("hi " + arguments[0] + " really nice to meet you!");
				else
					return new Response("this is the " + this.getName() + " command");
			}
			
		});
		
		server.registerCommand(new Command("die_after_respond") {

			@Override
			public Response handle(String[] arguments) {
				return new Response("this is the " + this.getName() + " command and I'm to die");
			}
			
		});
		
		server.registerCommand(new Command("exit") {

			@Override
			public Response handle(String[] arguments) {
				return new Response("see you...", false /* halt */);
			}
			
		});
		
		
		server.start();
		System.out.println("async");
		
		
	}

}
