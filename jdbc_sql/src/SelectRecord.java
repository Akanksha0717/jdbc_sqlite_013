package jdbc_sql.src;

import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
   
public class SelectRecord {  
   
    Connection conn;
    public SelectRecord(Connection conn){
        conn = this.conn;
    }
   
  
    public void selectAll(){  
        String sql = "SELECT * FROM movies";  
          
        try {  
             
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getString("name") +  "\t" +   
                                   rs.getString("actor") + "\t" +
                                   rs.getString("actress") + "\t" +
                                   rs.getString("director") + "\t" +  
                                   rs.getInt("yearOfRelease"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
      
     
   
}  