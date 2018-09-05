package com.resources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	public Response insertAdvertisement(Advertisement adv)
	{	System.out.println("hi");
		AdvertisementDao obj=new AdvertisementDao();
		obj.addAdvertisement(adv);
		return Response.ok("created",MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/getAll")
	@Produces({MediaType.APPLICATION_JSON})
	 public Response getCategorie() throws IOException
	 {  
		AdvertisementDao obj=new AdvertisementDao();
		List<Advertisement> listOfAdvertisement=obj.getAllAdvertisement();
		return Response.ok(ConvertingObjectToJson.toJSON(listOfAdvertisement),MediaType.APPLICATION_JSON).build(); 
	 }


}
