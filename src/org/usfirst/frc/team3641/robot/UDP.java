package org.usfirst.frc.team3641.robot;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP
{
	static int port;
	static InetAddress address;
	static DatagramSocket socket;
	static DatagramPacket packet;
	static byte[] buf;

	public UDP(String IP, int Port)	//Sets the vars and opens a connection to the pi
	{
		try 
		{
			port = Port;
			address = InetAddress.getByName(IP);
			socket = new DatagramSocket(3641);
			buf = new byte[256];
			socket.setSoTimeout(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String flush(String oldResponse)
	{
		String response = getData();
		if(response!=null)
		{
			return flush(response);
		}
		else return oldResponse;
	}

	public void sendData(String data) //Sends the request to the pi
	{
		try
		{
			
			buf = data.getBytes();	//Converts the String to a byte array
			packet = new DatagramPacket(buf, buf.length, address, port); //Makes a packet from the byte array, address, and port
			socket.send(packet);	//Send the packet :D
		}
		catch (Exception e)
		{
			//e.printStackTrace();
		}
	}
	public String getData()
	{
		try
		{
			byte[] buf = null;
			buf = new byte[256];	//Creates the byte array for the response
			packet = new DatagramPacket(buf, buf.length); //Prepares to receive the packet
			socket.receive(packet);	//Receives the packet from the pi
			String response = new String(buf, 0, packet.getLength()); //Converts the byte array to a string
			return response;
		}
		catch (Exception e)
		{
			//System.out.println(e.getMessage());
			return null;
		}	
	}

}