/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage.Converters;

import java.lang.reflect.Field;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jesper
 */
/*
@Named
@FacesConverter
public class EntityConverter implements Converter {
    
    @PersistenceContext(unitName = "EnterpriseApplication1-warPU")
    private EntityManager em;
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {    
        Class<? extends Object> myClass = value.getClass();
            
            for (Field f : myClass.getDeclaredFields()) {
                if (f.isAnnotationPresent(Id.class)) {
                    f.setAccessible(true);
                    Long id = (Long) f.get(value);
                    return myClass.getCanonicalName() + ":" + id.toString();
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
        }
        return null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            String[] split = value.split(":");
            return em.find(Class.forName(split[0]), Long.valueOf(split[0]));
        } catch (NumberFormatException | ClassNotFoundException e) {
            return null;
        }
    }
}
*/