/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author aladhari
 */


public class JerseyClient {

  public static void main(String[] args) {
	try {

		Client client = Client.create();

		WebResource webResource = client
		   .resource("http://localhost:8080/jersey-quik-start/webapi/myresource/artikel").queryParam("art_nummer", "1701000");
             
		ClientResponse response = webResource.accept("application/json")
                   .get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}
		String output = response.getEntity(String.class);

		System.out.println("Output from Server .... \n");
		System.out.println(output);

	  } catch (Exception e) {
	  }

	}
}
