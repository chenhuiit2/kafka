package com.cookie.kafka_demo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String aaa= "53580  96968";
    	byte[] bytes = aaa.getBytes();
    	
    	for(byte k : bytes) {
    		System.out.println(k + "");
    	}


        
    }
}
