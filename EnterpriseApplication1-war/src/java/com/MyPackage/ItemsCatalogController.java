/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage;

import com.MyPackage.Beans.ItemsBasketBean;
import com.MyPackage.Entities.Item;
import com.MyPackage.Entities.OrderItem;
import com.MyPackage.Entities.Orders;
import com.MyPackage.Entities.User;
import com.MyPackage.Entities.service.ItemFacade;
import com.MyPackage.Entities.service.OrderItemFacade;
import com.MyPackage.Entities.service.OrdersFacade;
import com.MyPackage.Entities.service.UserFacade;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.inject.Inject;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jesper
 */
@Named(value = "itemsCatalogController")
@SessionScoped
public class ItemsCatalogController implements Serializable {
    
    @EJB
    private OrdersFacade ordersFacade;
    
    @EJB
    private OrderItemFacade orderItemFacade;
    
    @Inject
    @LoggedIn
    User currentUser;
    
    @Inject
    ItemsBasketBean itemsBasketBean;
    
    @EJB
    private ItemFacade itemFacade;
    
    private Item selectedItem;
    private Item selectedBasketItem;
    
    private Integer quantityInput;
    private int basketSum;
    
    public void setBasketSum(int sum) {
        basketSum = sum;
    }

    public Integer getQuantityInput() {
        return quantityInput;
    }

    public void setQuantityInput(Integer quantityInput) {
        this.quantityInput = quantityInput;
    }

    public Item getSelectedBasketItem() {
        return selectedBasketItem;
    }

    public void setSelectedBasketItem(Item selectedBasketItem) {
        this.selectedBasketItem = selectedBasketItem;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }
    
    public List<Item> getItems() {
        return itemFacade.findAll();
    }
    
    public void addToBasket() {
        itemsBasketBean.addItem(selectedItem, quantityInput);
        basketSum += selectedItem.getPrice() * quantityInput;
    }
    
    public void clearBasket() {
        itemsBasketBean.clear();
        basketSum = 0;
    }
    
    public int getBasketSum() {
        return basketSum;
    }
    
    public void checkout() {
        Orders order = new Orders();
        order.setUsername(currentUser);
        order.setOrdertime(new Date());
        order.setPricesum(basketSum);
        
        ordersFacade.create(order);
        
        for (Map.Entry pair : itemsBasketBean.getItemsHashMap().entrySet()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItemname((Item)pair.getKey());
            orderItem.setOrderid(order);
            orderItem.setQty((Integer)pair.getValue());
            orderItemFacade.create(orderItem);
        }
        
        itemsBasketBean.clear();
        basketSum = 0;
        
        /*
        for (int i = 0; i < itemsBasketBean.getItems().size(); ++i) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItemname(itemsBasketBean.getItems().get(i));
            orderItem.setOrderid(order);
            orderItem.setQty(quantityInput);
            orderItemFacade.create(orderItem);
        }
        */
    }
    
    /**
     * Creates a new instance of ItemsCatalogController
     */
    public ItemsCatalogController() {
        basketSum = 0;
    }
    
}
