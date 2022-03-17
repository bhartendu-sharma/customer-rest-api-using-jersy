package com.nucleus.webServices;


import com.nucleus.dao.CustomerDao;
import com.nucleus.dao.CustomerDaoImpl;
import com.nucleus.model.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("/customer")
public class CustomerResource {


    CustomerDao customerDao=new CustomerDaoImpl();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomerFun() {
        return customerDao.getAllCustomer();
    }
    @GET
    @Path("{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerByIdFun(@PathParam("customerId") int customerId) {
        Customer customer = customerDao.getCustomerById(customerId);
        if (customer != null) {
            return Response.ok(customer, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addCustomerFun(Customer customer){
        if(customerDao.addCustomer(customer)!=null)
            return "add customer success!";
        else
            return "something went wrong!";
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateCustomerFun( Customer customer) {
        if (customerDao.updateCustomer(customer)!=null) {
            return "customer updated!";
        } else {
            return "something went wrong!";
        }
    }
    @DELETE
    @Path("{customerId}")
    public String deleteCustomerFun(@PathParam("customerId") int customerId) {
        if (customerDao.deleteCustomer(customerId)) {
            return "customer deleted";
        } else {
            return "something went wrong!";
        }
    }
}

