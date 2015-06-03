/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage.Beans;

import com.MyPackage.Entities.Item;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author Jesper
 */
@Named
@SessionScoped
public class ItemsBasketBean implements Serializable {

    public void setItemsHashMap(HashMap<Item, Integer> itemsHashMap) {
        this.itemsHashMap = itemsHashMap;
    }
    
    private HashMap<Item, Integer> itemsHashMap;
    
    public void clear() {
        itemsHashMap.clear();
    }
    
    public List getItemList() {
        return new ArrayList<Entry<Item, Integer>>(itemsHashMap.entrySet());
    }
    
    public HashMap<Item, Integer> getItemsHashMap() {
        return itemsHashMap;
    }
    
    public void addItem(Item item, Integer quantity) {
        //items.add(item);
        
        if (itemsHashMap.containsKey(item)) {
            itemsHashMap.put(item, itemsHashMap.get(item) + quantity);
        } else {
            itemsHashMap.put(item, quantity);
        }
    }
    
    public void removeItem(Item item) {
        //items.remove(item);
        itemsHashMap.remove(item);
    }

    /**
     * Creates a new instance of ItemsBasketBean
     */
    public ItemsBasketBean() {
        itemsHashMap = new HashMap<>();
    }
    
}
