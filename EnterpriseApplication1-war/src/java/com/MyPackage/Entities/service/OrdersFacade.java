/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage.Entities.service;

import com.MyPackage.Entities.Orders;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

/**
 *
 * @author Jesper
 */
@Stateless
public class OrdersFacade extends AbstractFacade<Orders> {
    @PersistenceContext(unitName = "EnterpriseApplication1-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List getOrdersFromUsername(Object id) {
        CriteriaQuery<Orders> cq = em.getCriteriaBuilder().createQuery(Orders.class);
        Metamodel m = em.getMetamodel();
        EntityType<Orders> order_ = m.entity(Orders.class);
        Root<Orders> order = cq.from(Orders.class);
        //cq.where(order.get(order_.))
        return getEntityManager().createQuery(cq).getResultList();
    }

    public OrdersFacade() {
        super(Orders.class);
    }
    
}
