/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.capp.exception;

/**
 *
 * C
 */
public class UserBlockedException extends Exception{
    /**
      
 *
 * Creates User object without error description
 */
    public UserBlockedException(){
        
    }
    /**
 *
 * Creates User object with error description
 */
  public UserBlockedException(String errDesc){
      super(errDesc);
  }  
}
