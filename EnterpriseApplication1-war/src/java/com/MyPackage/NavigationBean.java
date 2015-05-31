/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Hyzor
 */
@Named("nagivationBean")
@SessionScoped
public class NavigationBean implements Serializable {

    /**
     * Creates a new instance of NavigationBean
     */
    public NavigationBean() {
    }
    
    public String RedirectToRegistrationPage() {
        return "/userRegistration.xhtml?faces-redirect=true";
    }
    
}
