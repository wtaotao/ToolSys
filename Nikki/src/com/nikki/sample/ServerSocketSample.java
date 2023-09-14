package com.nikki.sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketSample {
	
	  public static void main(String[] args) throws IOException {

		    ServerSocket socket = new ServerSocket(80);

		      while (true) {

		      final Socket connection = socket.accept();

		      Runnable r = new Runnable() {

		        public void run() {

//		          handleRequest(connection);

		        }

		      };

		      // Don't do this!

		      new Thread(r).start();

		    }

		  }
}
