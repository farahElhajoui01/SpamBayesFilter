/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.MailText;


   

/**
 *
 * @author fatima
 */
public class MailTextService extends AbstractFacade<MailText>{
    public MailTextService() {
        super(MailText.class);
}
   
     
     public void create(MailText mailText){
         
         super.create(mailText);
     }
    
      
    
      
}

