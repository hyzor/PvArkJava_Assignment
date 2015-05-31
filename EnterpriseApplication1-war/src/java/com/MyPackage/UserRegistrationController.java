/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage;

import com.MyPackage.Beans.UserRegistrationInputBean;
import com.MyPackage.Entities.service.UsersService;
import com.MyPackage.Entities.Users;
import static com.sun.faces.facelets.util.Path.context;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

/**
 *
 * @author Hyzor
 */
@Named(value = "userRegistrationBean")
@SessionScoped
public class UserRegistrationController implements Serializable {
    
    @Inject
    UserRegistrationInputBean inputData;
    
    @EJB
    private UsersService usersService;
    
    private Users user;

    /**
     * Creates a new instance of UserRegistrationBean
     */
    public UserRegistrationController() {
    }
    
    public void DoRegister() {
        if (!inputData.getPassword_confirmation().equals(inputData.getPassword())) {
            // Error!
            // Password confirmation does not equal password
        } else {
            //user = userDatabase.find(Users.class, inputData.getUsername());
            
            if (user != null)
            {
                // Error!
                // User already exists
            } else {
                user = new Users();
                user.setUsername(inputData.getUsername());
                user.setPassword(inputData.getPassword());
                user.setEmail(inputData.getEmail());
                usersService.addUser(user);
                
                // Redirect to login
            }
        }
    }
    
}
