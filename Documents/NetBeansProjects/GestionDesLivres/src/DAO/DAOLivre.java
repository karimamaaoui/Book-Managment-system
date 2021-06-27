/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class DAOLivre {
 
    
       public static boolean ajouter(int id,String title,String author, String year, int pages)
    {
        Connection cn=LaConnexion.seConnecter();

        String requete = "INSERT INTO `livre`(`id`, `title`, `author`, `year`, `pages`) VALUES  (?,?,?,?,?)";
        
        try{
            PreparedStatement pst=cn.prepareStatement(requete);
            pst.setInt(1, id);
            pst.setString(2,title);
            pst.setString(3,author);
            pst.setString(4,year);
            pst.setInt(5, pages);
            int n=pst.executeUpdate();
            if (n>=1)
            System.out.println("ajout Livre reussi");
            return true;

            
            }
        catch(SQLException ex)
        {
            System.out.println("probleme de requete"+ex.getMessage());
        }
        return false;
    }
       
       
       
    public static void Modifier(int id,String title,String author, String year, int pages)
    {
        Connection cn=LaConnexion.seConnecter();
        String requete = "UPDATE `livre` SET `title`=?,`author`=?,`year`=?, `pages`=? WHERE `id`=?;";
 
    
    try{
        PreparedStatement pst=cn.prepareStatement(requete);
        pst.setString(1, title);
        pst.setString(2,author);
        pst.setString(3,year);
        pst.setInt(4,pages);
        pst.setInt(5,id);

        int n=pst.executeUpdate();
        if (n>=1)
        System.out.println("Modification réussi");
        }
    catch(SQLException ex)
        {
            System.out.println("problème de requête Modif"+ex.getMessage());
        }
    
        
    }
    
  public static void delete(int id)
    {
        Connection cn=LaConnexion.seConnecter();
        String requete = "delete from livre where`livre`.`id`=?;";
        try{
            PreparedStatement pst=cn.prepareStatement(requete);
            pst.setInt(1,id);
            int n=pst.executeUpdate();
            if (n>=1)
            System.out.println("suppression rÃ©ussie");
        }
        catch(SQLException ex)
            {
                System.out.println("problÃ¨me de requÃªte de suppression"+ex.getMessage());
            }
        }
    
}
