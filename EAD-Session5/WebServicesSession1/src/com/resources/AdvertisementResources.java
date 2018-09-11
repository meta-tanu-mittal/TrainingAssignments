package com.resources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dao.AdvertisementDao;
import com.dao.AdvertisementQueries;
import com.dao.CategoryDao;
import com.dao.CategoryQueries;
import com.model.Advertisement;
import com.model.Category;
import com.util.DBConnection;

@Path("/advertisement")
public class AdvertisementResources {

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertAdvertisement(@HeaderParam("authKey") String key,
			Advertisement adv) {
		if (getAuthorizationKey().equals(key)) {
			AdvertisementDao obj = new AdvertisementDao();
			obj.addAdvertisement(adv);
			return Response.ok("created", MediaType.APPLICATION_JSON).build();
		} else
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"invalid key\"}").build();
	}

	@GET
	@Path("/getAll")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCategorie(@HeaderParam("authKey") String key)
			throws IOException {
		if ("get-2018".equals(key)) {
			AdvertisementDao obj = new AdvertisementDao();
			List<Advertisement> listOfAdvertisement = obj.getAllAdvertisement();
			return Response.ok(
					ConvertingObjectToJson.toJSON(listOfAdvertisement),
					MediaType.APPLICATION_JSON).build();
		} else
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"invalid key\"}").build();
	}

	@PUT
	@Path("/update/{id}/{title}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateAdvertisement(@HeaderParam("authKey") String key,
			@PathParam("id") int id, @PathParam("title") String title) {
		AdvertisementDao obj = new AdvertisementDao();
		if (getAuthorizationKey().equals(key)) {
			if (obj.updateAdvertisement(title, id)) {
				return Response.ok("updated", MediaType.APPLICATION_JSON)
						.build();
			} else {
				return Response.ok("not updated", MediaType.APPLICATION_JSON)
						.build();
			}
		} else {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"invalid key\"}").build();
		}

	}

	@DELETE
	@Path("/delete/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteAdvertisement(@HeaderParam("authKey") String key,
			@PathParam("id") int id) {
		AdvertisementDao obj = new AdvertisementDao();
		if (getAuthorizationKey().equals(key)) {
			if (obj.deleteAdvertisement(id)) {
				return Response.ok("deleted", MediaType.APPLICATION_JSON)
						.build();
			} else {
				return Response.ok("not deleted", MediaType.APPLICATION_JSON)
						.build();
			}
		} else {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"invalid key\"}").build();
		}

	}

	@GET
	@Path("/getAllByCategoryId/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCategorie(@HeaderParam("authKey") String key,
			@PathParam("id") int id) throws IOException {
		if (getAuthorizationKey().equals(key)) {
			AdvertisementDao obj = new AdvertisementDao();
			List<Advertisement> listOfAdvertisement = obj
					.getAllAdvertisementByCategoryId(id);
			return Response.ok(
					ConvertingObjectToJson.toJSON(listOfAdvertisement),
					MediaType.APPLICATION_JSON).build();
		} else
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"Attribute is not defined\"}").build();
	}

	public String getAuthorizationKey() {
		return "get-2018";
	}

}
