package com.resources;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import com.dao.CategoryDao;
import com.model.Category;


@Path("/categories")
public class CategoryResources {
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertCategory(Category category)
	{	//System.out.println("fghgj");
	   // String name=category.getName();
		CategoryDao obj=new CategoryDao();
		obj.addCategory(category);
		return Response.ok("created",MediaType.APPLICATION_JSON).build();
	}
	
@GET
@Path("/getAll")
@Produces({MediaType.APPLICATION_JSON})
 public Response getCategorie() throws IOException
 {  
	CategoryDao obj=new CategoryDao();
	List<Category> listOfCategory=obj.getAllCategory();
	return Response.ok(ConvertingObjectToJson.toJSON(listOfCategory),MediaType.APPLICATION_JSON).build(); 
 }
}
