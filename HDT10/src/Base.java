

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private String archivo="C:\\Users\\Marlon\\Documents\\universidad\\datos\\HDT10\\datos.csv";
    Graph graph = new SingleGraph("Correos");
    private String[][] matriz;

    public Base() {
       matriz = new String[15][15];
    }
   
    
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
            System.out.println("Error");
        }
    
    }
    
    public void lector(){
        BufferedReader br =null;
       try{
           String linea; 
           br = new BufferedReader(new FileReader(archivo));
           while((linea = br.readLine())!=null){
               for(int i = 0;i<matriz.length;i++){
                   for(int j = 0;j<matriz[i].length;j++){
                       String [] datos = linea.split(";");
                       matriz[i][j] = datos[i];
                   }
               }           
           }
       }
       catch(IOException e){
           System.out.println("Error");
       }
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
