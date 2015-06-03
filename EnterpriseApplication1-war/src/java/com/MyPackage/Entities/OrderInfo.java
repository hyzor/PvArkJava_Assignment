/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage.Entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author patrikeh
 */

@Entity
@XmlRootElement
public class OrderInfo implements Serializable {

    @Id private String itemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    private int qty;

    public void setItemname(String name) {
        this.itemName = name;
    }
    
    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }
}
