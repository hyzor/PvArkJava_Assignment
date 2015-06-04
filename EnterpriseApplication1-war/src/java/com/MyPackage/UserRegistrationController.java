/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage;

import com.MyPackage.Beans.UserRegistrationInputBean;
import com.MyPackage.Entities.service.UserFacade;
import com.MyPackage.Entities.User;
import com.MyPackage.Entities.UsersGroups;
import com.MyPackage.Entities.service.UsersGroupsFacade;
import static com.sun.faces.facelets.util.Path.context;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
@Named
@SessionScoped
public class UserRegistrationController implements Serializable {
    
    @Inject
    UserRegistrationInputBean inputData;
    
    @EJB
    private UserFacade usersService;
    
    @EJB
    private UsersGroupsFacade usersGroupsService;
    
    private User user;

    /**
     * Creates a new instance of UserRegistrationBean
     */
    public UserRegistrationController() {
    }
    
    public String doRegister() {      
        String result = "fail";
        
        String username = inputData.getUsername();
        String password = inputData.getPassword();
        String password_conf = inputData.getPassword_confirmation();
        String email = inputData.getEmail();
        
        if (!password_conf.equals(password)) {
            // Error!
            // Password confirmation does not equal password
        } else {
            //user = userDatabase.find(Users.class, inputData.getUsername());
            
            if (user != null)
            {
                // Error!
                // User already exists
            } else {
                user = new User();
                
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                
                String pw_encoded = hashAndEncode(password);
                
                if (pw_encoded != null) {
                    user.setPassword(pw_encoded);
                    usersService.create(user);
                    
                    UsersGroups userGroup = new UsersGroups();
                    userGroup.setGroupname("user");
                    userGroup.setUsername(username);
                    usersGroupsService.create(userGroup);
                    result = "success";
                }
            }
        }
        
        return result;
    }
    
    public static final String hashAndEncode(String string) {
        String encode_result = null;
        byte[] digestResult = null;
                
                try {
                    MessageDigest md = MessageDigest.getInstance("SHA-256");
                    digestResult = md.digest(string.getBytes("UTF-8"));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                
                if (digestResult != null)
                {
                    encode_result = Base64.encode(digestResult).toString();
                }
        return encode_result;
    }
}
