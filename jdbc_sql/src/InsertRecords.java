package jdbc_sql.src;

import java.sql.Connection;  
// import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
   
public class InsertRecords {  
    
    Connection conn;
    public InsertRecords(Connection conn){
        conn = this.conn;
    }
  
    public void insert(String name, String actor, String actress, String director, int yearOfRelease) {  
        String sql = "INSERT INTO movies(name, actor, actress, director, yearOfrelease) VALUES(?,?,?,?,?)";  
   
        try{  
            
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, name);  
            pstmt.setString(2, actor);
            pstmt.setString(3, actress);
            pstmt.setString(4, director);
            pstmt.setInt(5, yearOfRelease);  
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
    
   
}  