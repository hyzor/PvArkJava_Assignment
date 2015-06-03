/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage.Converters;

import com.MyPackage.Entities.Item;
import com.MyPackage.Entities.service.ItemFacade;
import java.lang.annotation.Annotation;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jesper
 */
@Named
@RequestScoped
public class ItemsConverter implements Converter {
    
    @EJB
    ItemFacade itemFacade;
    
    @PersistenceContext(unitName = "EnterpriseApplication1-warPU")
    private EntityManager em;
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Item item;
        item = (Item) value;
        return String.valueOf(item.getItemname());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return itemFacade.findItemByName(value);
    }
    
}
