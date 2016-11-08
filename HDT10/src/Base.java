

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marlon
 */
public class Base {
      ArrayList<String[]>matriz = new ArrayList<>();
    Graph graph = new SingleGraph("Correos");
  

   
    
   /*1. hacer conexion*/
    public void conector(){
        try {
            Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost/?user=neo4j,password=1234,debug=true,noSsl,flatten=[-1,100,1000]");
            try (Statement stmt = con.createStatement()){
                ResultSet rs = stmt.executeQuery("MATCH (n:User) RETURN n.name");
                while(rs.next()){
                    System.out.println(rs.getString("n.name"));
                }
            }
            con.close();
        } catch(Exception ex){
            System.out.println("Error1");
        }
    
    }
    
    public void lector(){
        String archivo= "C:/Usuarios/Marlon/Documentos/universidad/datos/HDT10/utilidades/datos.csv";
        BufferedReader br =null;
       try{
           String linea; 
           br = new BufferedReader(new FileReader(archivo));
           
           while((linea = br.readLine())!=null){
               matriz.add(linea.split(";"));
           }
       }
       catch(Exception ex){
           System.out.println("Error2");
       }
      
    }
    public void crearNodos(){
         
           String per1 = "per1";
           String per2 = "per2";
           String per3 = "per3";
           String per4 = "per4";
           String per5 = "per5";
           String per6 = "per6";
           String per7 = "per7";
           String per8 = "per8";
           String per9 = "per9";
           String per10 = "per10";
           String per11 = "per11";
           String per12 = "per12";
           String per13 = "per13";
           String per14 = "per14";
              graph.addNode(per1);
              graph.addNode(per2);
              graph.addNode(per3);
              graph.addNode(per4);
              graph.addNode(per5);
              graph.addNode(per6);
              graph.addNode(per7);
              graph.addNode(per8);
              graph.addNode(per9);
              graph.addNode(per10);
              graph.addNode(per11);
              graph.addNode(per12);
              graph.addNode(per13);
              graph.addNode(per14);
              
         graph.display();
      
    
    }

   public void agregarNodo(String nodo){
       graph.addNode(nodo);
   } 
   public void agregarRelacion(String arista,String nodo1, String nodo2){
       graph.addEdge(arista,nodo1,nodo2,true);
   }
   public void generarGrafo(){
       graph.display();
   }
}
