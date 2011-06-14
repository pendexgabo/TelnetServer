package com.sosagabriel.telnet.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import com.sosagabriel.telnet.commands.Command;

public class Job implements Runnable {

	private Server server = null;

	public Server getServer() {
		return server;
	}

	public Socket getSocket() {
		return socket;
	}

	private Socket socket = null;

	public Job(final Socket socket, final Server server) {
		this.socket = socket;
		this.server = server;
	}

	@Override
	public void run() {

		PrintWriter out = null;
		BufferedReader in = null;
		String line = null;

		try {
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			in = new BufferedReader(new InputStreamReader(socket
					.getInputStream()));
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Response response = new Response();

		while (line != null) {

			if (line == null || line.length() == 0) {
				response.set(Command.ERROR);
			} else {


				StringTokenizer st = new StringTokenizer(line);
				String command = st.nextToken();

				String[] arguments = null;
				

				if (this.getServer().getCommands().containsKey(command)) {

					if (st.countTokens() >= 1) {
						arguments = new String[st.countTokens()];
						int argc = 0;
						while (st.hasMoreTokens()) {
							arguments[argc++] = st.nextToken();
						}
					}
					Command commandHandler = this.getServer().getCommands()
					.get(command);
					
					response = commandHandler.handle(arguments);
				}
				else {
					response.set(Command.ERROR);
				}

			}

			out.print(response);
			out.print(Command.END);
			out.flush();			

			if (response.keepalive() == false) {
				break;
			}

			try {
				line = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		try {
			out.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
