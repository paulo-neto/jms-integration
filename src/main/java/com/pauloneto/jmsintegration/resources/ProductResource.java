package com.pauloneto.jmsintegration.resources;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pauloneto.jmsintegration.models.Product;
import com.pauloneto.jmsintegration.producers.ProductMessageProducer;

@Path("/products")
public class ProductResource {

	@Inject
	private ProductMessageProducer messageProducer;

	@Path("/")
	@POST
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response create(Product product) throws URISyntaxException {
		messageProducer.sendMessage(product);
		return Response.created(new URI("products")).build();
	}
}
