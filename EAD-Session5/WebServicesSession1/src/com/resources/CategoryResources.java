package com.resources;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
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

import org.json.simple.JSONObject;

import com.dao.CategoryDao;
import com.model.Category;

@Path("/categories")
public class CategoryResources {

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertCategory(@HeaderParam("authKey") String key,
			Category category) {
		if (getAuthorizationKey().equals(key)) {
			CategoryDao obj = new CategoryDao();
			obj.addCategory(category);
			return Response.ok("created", MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"invalid key\"}").build();
		}
	}

	@GET
	@Path("/getAll")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCategories(@HeaderParam("authKey") String key)
			throws IOException {
		if (getAuthorizationKey().equals(key)) {
			CategoryDao obj = new CategoryDao();
			List<Category> listOfCategory = obj.getAllCategory();
			return Response.ok(ConvertingObjectToJson.toJSON(listOfCategory),
					MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"invalid key\"}").build();
		}

	}

	@PUT
	@Path("/update/{id}/{name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateCategory(@HeaderParam("authKey") String key,
			@PathParam("id") int id, @PathParam("name") String name) {
		if (getAuthorizationKey().equals(key)) {
			CategoryDao obj = new CategoryDao();

			if (obj.updateCategory(name, id)) {
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

	public String getAuthorizationKey() {
		return "get-2018";
	}

}
