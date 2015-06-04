package com.MyPackage;

import com.MyPackage.Entities.Orders;
import com.MyPackage.Entities.User;
import com.MyPackage.Entities.service.OrdersFacade;
import com.MyPackage.LoggedIn;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *  
 * @author patrikeh
 */
@Named(value = "orderHistoryBean")
@RequestScoped
public class OrderHistoryBean implements Serializable {
    @Inject
    @LoggedIn
    User currentUser;
    Orders orders;
    
    @PersistenceContext(unitName = "EnterpriseApplication1-warPU")
    private EntityManager em;

    public OrderHistoryBean() {
    }
    
    
    public void setOrders(Orders orders) {
        this.orders = orders;
    }
     
    public List<Orders> getOrders(){ 
        //Query query = em.createNativeQuery("SELECT * FROM Orders o WHERE o.Username = '" + currentUser.getUsername() + "'", Orders.class);
        //ordersFacade.find(currentUser);
        Query query = em.createQuery("SELECT o FROM Orders o WHERE o.username.username = '" + currentUser.getUsername() + "'", Orders.class);
        List<Orders> l = query.getResultList();
        return l;
    }
    
}
