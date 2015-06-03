/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage.Services;

import com.MyPackage.Entities.Orders;
import com.MyPackage.Entities.OrderItem;
import com.MyPackage.Entities.OrderInfo;

import static java.util.Collections.list;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author patrikeh
 */
@WebService(serviceName = "OrderTrackingWebservice")
@Stateless
@Path("OrderTracking/{OrderID}")
@RolesAllowed({"user"})
public class OrderTrackingWebservice {
    @PersistenceContext(unitName = "EnterpriseApplication1-warPU")
    private EntityManager em;
    
 
    @GET
    @Produces({"application/json"})
    public List<OrderInfo> findAll(@PathParam("OrderID") int OrderID) {
        Query query = em.createNativeQuery("SELECT o.itemname as itemname, o.qty as qty FROM Orderitems o WHERE o.OrderID = " + OrderID, 
        OrderInfo.class);

        return query.getResultList();
    } 
}
