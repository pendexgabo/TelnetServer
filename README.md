# TelnetServer

A simple telnet server where you provide the commands

## Requirements:

 1. Java 1.5



## Example

This is a basic example

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

				server.registerCommand(new Command("exit") {

					@Override
					public Response handle(String[] arguments) {
						return new Response("see you...", false /* halt */);
					}

				});


				server.start();


			}

		}
		




## License

Copyright (c) 2011 Gabriel Sosa

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
