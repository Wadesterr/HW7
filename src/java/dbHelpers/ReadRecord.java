
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cars;

public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Cars car = new Cars();
    private int vinID;
    
    
    
    public ReadRecord (int vinID) {
            
    Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String pass = props.getProperty("user.password");
        
        this.vinID = vinID;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, pass);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doRead() {
       
        try {
            String query = "SELECT * FROM cars WHERE vinID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, vinID);
            
            this.results = ps.executeQuery();
            
            this.results.next();
            
            
            car.setVinID(this.results.getInt("vinID"));
            car.setMake(this.results.getString("make"));
            car.setModel(this.results.getString("model"));
            car.setYear(this.results.getInt("year"));
            car.setColor(this.results.getString("color"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            
            
}
    
    public Cars getCar(){
        
        return this.car;
        
    }
    
    
}