package jdbc_sql.src;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
   
public class Connect {  
     /** 
     * Connect to a sample database 
     */  
    public static Connection connect() {  
        Connection conn = null;  
        try {  
            // db parameters  
            String url = "jdbc:sqlite:C:/sqlite/Akanksha.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  
              
            System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            try {  
                if (conn != null) {  
                    conn.close();  
                }  
            } catch (SQLException ex) {  
                System.out.println(ex.getMessage());  
            }  
        }
        return conn;  
    }  
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
        Connection conn = connect();  
        CreateDatabase db = new CreateDatabase();
        db.createNewDatabase("SSSIT.db"); 
        CreateTable ct = new CreateTable();
        ct.createNewTable();
        InsertRecords app = new InsertRecords(conn);  
        // insert three new rows  
        app.insert("brahmastra", "ranbir","alia","ayan",2022);  
        app.insert("darlings", "vijay","alia","jasmeet",2022);    
        app.insert("braha", "gbir","sdfssia","assan",2010);  
        app.insert("vndjdev", "ranbir","alia","ayan",2011);  
        app.insert("brdsnra", "bdnjsncr","acsasa","ayvd",2024);  

        SelectRecord ap = new SelectRecord(conn);  
        ap.selectAll();
    }  
}  