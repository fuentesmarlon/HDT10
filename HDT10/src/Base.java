
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



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
   /*1. hacer conexion*/
    public void crearBase(){
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
            System.out.println("ASS");
        }
    
    }
    

}
