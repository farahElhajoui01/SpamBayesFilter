/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.MailText;
import bean.Mot;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author farah
 */
public class MailTextFacade extends AbstractFacade<MailText>{

    
    private MotFacade motfacade=new MotFacade();
    public MailTextFacade() {
        super(MailText.class);
    }
    
    
    public void Insérermot() {
    
        List<MailText> mailtexts =new ArrayList();
     
        mailtexts=findAll();
        
       for (MailText mailtext : mailtexts) {
            
            System.out.println(mailtext.getText());
            
           String text =mailtext.getText().toLowerCase();
           text=text.replaceAll("[-+.^:,]","");
           String mots[] = text.split(" ");
 
        for (int i = 0; i < mots.length; i++) {
          
           if(!mots[i].equals(""))
         motfacade.findMot(mots[i], mailtext.getCategorie());
         
            System.out.println(i+": " +mots[i]);
        }
        }
          
    }
    
 /*   public double  Probaeeeee(String categorie){
        
         Query query1 = getEntityManager().createQuery("select count(mt) from  MailText mt WHERE mt.categorie like '"+categorie+"'");
         Query query2 = getEntityManager().createQuery("select count(mt) from  MailText mt  ");

    Long countcat = (Long) query1.getSingleResult();
    Long counttotal=(Long) query2.getSingleResult();
    
    System.out.println(countcat);
    System.out.println(counttotal);
    double proba=((double)countcat/(double)counttotal);
        System.out.println(proba);
    return proba;
     }*/
    
    
     public double  Probamot(String word,String categorie){
        
         Query query1 = getEntityManager().createQuery("select mt from  Mot mt where mt.mot like '"+word+"'"
                 + " and mt.categorie like '"+categorie+"'");
         Query query2 = getEntityManager().createQuery("select mt from  Mot mt where mt.mot like '"+word+"'");

         List<Mot> mots = query1.getResultList();
         List<Mot> mots2= query2.getResultList();
         int total=0;
         for (Mot mot : mots2) {
            total+=mot.getCount();
         }
         
    if(mots.size()!=0 && mots2.size()!=0) {   
    int count = mots.get(0).getCount();
    Long countcat= new Long(count);
    Long counttotal= new Long(total);
    
    double proba=((double)countcat/(double)counttotal);
    return proba;
    }
    return 0;
     }

    
      public double  PseudoProbaEmail(String text,String categorie){
           double proba=0;
            double res = 0;
          
           text =text.toLowerCase();
           text=text.replaceAll("[-+.^:,]","");
           String mots[] = text.split(" ");
           double count =mots.length ;

        for (int i = 0; i < mots.length; i++) {
          
             Query query = getEntityManager().createQuery("select mt from  Mot mt where mt.mot like '"+mots[i]+"'");

         List<Mot> motts = query.getResultList();
          if (motts.size()==0) {
                count--;
            }
            System.out.println(count+" count");
            System.out.println(mots.length+" nbre de mots");
            res = count / mots.length;
            System.out.println(res+" reeeees");
            if (res >= 0.5) {

                if (!mots[i].equals("") || motts.size() != 0) {

                    proba = proba + Probamot(mots[i], categorie);

                    System.out.println(mots[i] + "-->" + Probamot(mots[i], categorie));
                    System.out.println("proba= " + proba);

                }
            } else {
                System.out.println("impossible de classifier <50%");
               proba=-2;
            }
        
        
      }
        return proba;
      }
     
      public String ClassifieurBayes(String text){
          
       String decision="";
       
       if(PseudoProbaEmail(text, "spam")>=0 && PseudoProbaEmail(text, "ham")>=0){
       
       if(PseudoProbaEmail(text, "spam")>PseudoProbaEmail(text, "ham"))
           decision="spam";
        
          else if(PseudoProbaEmail(text, "spam")<PseudoProbaEmail(text, "ham"))
                  decision= "ham";
          
          else 
              decision= "pas de décision";}
      
       else
       decision= "ne peux pas décider cas <50%";
          System.out.println(decision+"-----------------");
          return decision;
      
      }
      
    
    
}
