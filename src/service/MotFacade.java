/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Mot;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author farah
 */
public class MotFacade  extends AbstractFacade<Mot>{

    public MotFacade() {
        super(Mot.class);
    }

    
    public void save(Mot mot){
    
        if(mot!=null)
            edit(mot);
    
    }
    
    public void findMot(String word,String categorie){
    
       
        
      List<Mot> mots =getEntityManager().createQuery("select m from Mot m where m.mot like '"+word+"' and m.categorie like '"+categorie+"'").getResultList();
        
     
     
       if(mots.isEmpty()){
            Mot mot=new Mot();
         mot.setMot(word);
         mot.setCategorie(categorie);
         mot.setCount(1);
         save(mot);
            System.out.println("n exte pas ");
        }
       else{
       mots.get(0).setCount( mots.get(0).getCount()+1);
       save( mots.get(0));
 }
       
        
     }
    
    
}
