/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.services;

import com.mysql.jdbc.Connection;
import edu.devapps.entity.Utilisateur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilities.MaConnexion;

/**
 *
 * @author THEOLDISBACK
 */
public class UtilisateurService {
    
    
    
    
      Connection cnx =MaConnexion.getInstance().getCnx();
   

  
    public void ajoutersponsor(Utilisateur r) {
        String req ="INSERT INTO `utilisateur`( `nom`, `prenom`, `password`,  `email`,  `adresse`,  `role`,  `age`,  `username`,  `photo`) VALUES"+ " ('"+r.getNom()+"','"+r.getPrenom()+"','"+r.getPassword()+"','"+r.getEmail()+"','"+r.getAdresse()+"','"+r.getRole()+"','"+r.getAge()+"','"+r.getUsername()+"','"+r.getPhoto()+"'"+")";

          try {
              Statement st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("utilisateur ajouté");
              
            
              
              
          } catch (SQLException ex) {
              
              System.out.println(ex.getMessage());
          }
              
          }
   
    public List<Utilisateur> afficherutilisateur() {
        //var
        
       
        List<Utilisateur> utilisateurs =new ArrayList<>();
        //requette
        String req ="SELECT * FROM utilisateur";
          try {
              Statement st = cnx.createStatement();
              ResultSet rs = st.executeQuery(req);
              while (rs.next()){
                  utilisateurs.add(new Utilisateur(rs.getInt(1), rs.getString(2),rs.getString(3) ,rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getString(10),0,0));
              }
          } catch (SQLException ex) {
              }
    
        return utilisateurs;

    
       
    }
    

    public void supprimerUtilisateur( Utilisateur r  ) {
 String req="DELETE FROM `utilisateur` WHERE id="+r.getId();
 
           try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("utilisateur supprimer avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }  
             
          
    }
    
    

 
    public void modifierutilisateur( Utilisateur r ) {
        
        String req=null;
        if(r.getId()!=0)
        {   
            
            req="UPDATE `utilisateur` SET nom='"+r.getNom()+"',prenom='"+r.getPrenom()+"',email='"+r.getEmail()+"',adresse='"+r.getAdresse()+"',username='"+r.getUsername()+"' where id ="+r.getId();
       
            try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("utilisateur modifier avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
            
        }
       
}
    
    
}
