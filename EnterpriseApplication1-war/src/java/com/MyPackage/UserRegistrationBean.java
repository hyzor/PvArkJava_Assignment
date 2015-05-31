/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage;

import com.MyPackage.Entities.EJB.UsersEJB;
import com.MyPackage.Entities.Users;
import static com.sun.faces.facelets.util.Path.context;
import java.io.Serializable;
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
public class UserRegistrationBean implements Serializable {
    
    @Inject
    UserRegistrationInputBean inputData;
    
    @PersistenceContext(unitName = "EnterpriseApplication1-warPU") 
    private EntityManager userDatabase;
    
    private Users user;

    /**
     * Creates a new instance of UserRegistrationBean
     */
    public UserRegistrationBean() {
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
                final Context context = EJBContainer.createEJBContainer(p).getContext();
                UsersEJB usersEJB = (UsersEJB)context.lookup("java:global/injection-of-entitymanager/UsersEJB");
                user = new Users();
                user.setUsername(inputData.getUsername());
                user.setPassword(inputData.getPassword());
                user.setEmail(inputData.getEmail());
                
                usersEJB.addUser(user);
                
                //userDatabase.getTransaction().begin();
                //userDatabase.persist(user);
                //userDatabase.getTransaction().commit();
                //userDatabase.close();
            }
        }
    }
    
}
