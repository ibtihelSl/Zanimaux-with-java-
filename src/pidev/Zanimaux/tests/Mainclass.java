/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidev.Zanimaux.tests;

import java.util.List;
import java.util.Scanner;
import pidev.Zanimaux.Services.AccessoiresServices;
import pidev.Zanimaux.Services.AvisServices;
import pidev.Zanimaux.Services.MagasinServices;
import pidev.Zanimaux.entities.Accessoires;
import pidev.Zanimaux.entities.Avis;
import pidev.Zanimaux.entities.Magasin;

/**
 *
 * @author Touha
 */
public class Mainclass {
    
    
     public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
    MagasinServices ms = new MagasinServices();
/*       Magasin m1=new Magasin(); 
        System.out.println("Donner nom de magasin \n");
        m1.setNom(sc.nextLine());
        System.out.println("Donner l'address \n");
        m1.setaddress(sc.nextLine());
        System.out.println("Donner ville \n");
        m1.setVille(sc.nextLine());
        System.out.println("Donner numero telephone \n");
        m1.setPhone(sc.nextLine());
        ms.ajouterMagasin(m1);
        
        Magasin m2=new Magasin();
        System.out.println("donner id \n");
         m2.setId(sc.nextInt());
          sc.nextLine();
         System.out.println("Donner nom de magasin \n");
        m2.setNom(sc.nextLine());
         System.out.println("Donner l'address \n");
        m2.setaddress(sc.nextLine());
        System.out.println("Donner ville \n");
        m2.setVille(sc.nextLine());
        System.out.println("Donner numero telephone \n");
        m2.setPhone(sc.nextLine());
        ms.ModifierMagasin(m2);
        
        
        
         ms.SupprimerMagasin(m2);*/
       AccessoiresServices as=new AccessoiresServices();
          List<Accessoires> m= as.ListerAccessoires(2);
         System.out.println(m.toString());
         
     /*   List<Magasin> m= ms.ListerMagasin();
         System.out.println(m.toString());
       /*  
         System.out.println("donner id \n");
         int id2=sc.nextInt(); 
        Magasin m3=ms.findByID(id2);
        System.out.println(m3.toString());
         
       AccessoiresServices as=new AccessoiresServices();
     
      Accessoires a=new Accessoires();
        
        System.out.println("Donner nom de Accessoires \n");
        a.setNom(sc.nextLine());
        System.out.println("Donner Prix \n");
        a.setPrix(sc.nextFloat());
       as.ajouterAccessoires(a);
      
        
        Accessoires a1=new Accessoires();
        System.out.println("donner id \n");
        a1.setId(sc.nextInt());
        sc.nextLine();
        System.out.println("Donner nom de Accessoires \n");
        a1.setNom(sc.nextLine());
        System.out.println("Donner Prix \n");
        a1.setPrix(sc.nextFloat());
        as.ModifierAccessoires(a1);
       
         System.out.println("donner id \n");
         int id3=sc.nextInt();
         as.SupprimerAccessoires(id3);
        List<Accessoires> lista= as.ListerAccessoires();
         System.out.println(lista.toString());
        
          System.out.println("donner id \n");
         int id4=sc.nextInt(); 
        Accessoires a3=as.findByID(id4);
        System.out.println(a3.toString());*/
    }
    
}
