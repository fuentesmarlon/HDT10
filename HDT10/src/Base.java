

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
              
              graph.addEdge("anexo", per1, per2);
          graph.addEdge("anexo1", per1, per3);
          graph.addEdge("anexo2", per1, per9);
          graph.addEdge("anexo3", per1, per14);
          graph.addEdge("anexo5", per2, per3);
          graph.addEdge("anexo6", per2, per4);
          graph.addEdge("anexo7", per2, per12);
          graph.addEdge("anexo9", per3, per4);
          graph.addEdge("anexo10", per4, per5);
          graph.addEdge("anexo11", per4, per6);
          graph.addEdge("anexo12", per4, per11);
          graph.addEdge("anexo13", per4, per13);
          graph.addEdge("anexo14", per4, per14);
          graph.addEdge("anexo16", per5, per6);
          graph.addEdge("anexo17", per5, per11);
          graph.addEdge("anexo18", per5, per12);
          graph.addEdge("anexo19", per5, per13);
          graph.addEdge("anexo20", per5, per14);
          
          graph.addEdge("anexo21", per6, per2);

          graph.addEdge("anexo23", per6, per12);
          graph.addEdge("anexo24", per6, per13);
          
          graph.addEdge("anexo25", per7, per8);
          graph.addEdge("anexo26", per7, per9);
          graph.addEdge("anexo27", per7, per11);
          
          graph.addEdge("anexo28", per8, per6);

          graph.addEdge("anexo30", per8, per9);
          graph.addEdge("anexo31", per8, per10);
          
          graph.addEdge("anexo32", per9, per5);

          graph.addEdge("anexo34", per9, per10);
          
          graph.addEdge("anexo35", per10, per4);
          graph.addEdge("anexo36", per10, per5);
          graph.addEdge("anexo37", per10, per6);
          graph.addEdge("anexo38", per10, per7);
          graph.addEdge("anexo39", per10, per11);
          graph.addEdge("anexo40", per10, per12);
          graph.addEdge("anexo41", per10, per13);
          graph.addEdge("anexo42", per10, per14);
          

          graph.addEdge("anexo44", per11, per6);

          graph.addEdge("anexo46", per11, per13);
          graph.addEdge("anexo47", per11, per14);
          
          graph.addEdge("anexo48", per12, per4);

          graph.addEdge("anexo52", per12, per11);
          graph.addEdge("anexo53", per12, per13);
          graph.addEdge("anexo54", per12, per14);
          
          
              
              
              
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
