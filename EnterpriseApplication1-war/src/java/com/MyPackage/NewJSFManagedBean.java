/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Hyzor
 */
@SessionScoped
@ManagedBean(name="NewJSFManagedBean")
public class NewJSFManagedBean implements Serializable {
    
    private static final int myMagicNumber = 42;
    
    private int inputNum;
    private int result;

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public NewJSFManagedBean() {
        inputNum = 0;
        result = 0;
        System.out.println("Bean initialized");
    }
    
    public final int getInputNum() {
        return inputNum;
    }
    
    public void setInputNum(int inputNum) {
        this.inputNum = inputNum;
    }
    
    public final int getResult() {
        return result;
    }
    
    public void setResult(int result) {
        this.result = result;
    }
    
        public static int getMyMagicNumber() {
        return myMagicNumber;
    }
    
    public void calculate() {
        if (inputNum == myMagicNumber)
            result = 1;
        else
            result = 0;
    }
}
