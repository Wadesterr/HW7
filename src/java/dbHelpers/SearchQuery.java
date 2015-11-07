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


public class SearchQuery {
    
    private Connection conn;
    private ResultSet results;
    
    
    public SearchQuery(){
        
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String pass = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, pass);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void doSearch (String Make){
        
        
        try {
            String query = "SELECT * FROM cars WHERE UPPER(make) Like ? ORDER BY vinID ASC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,"%" + Make.toUpperCase() + "%");
            
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
    public String getHTMLtable() {
        String table = "";
        table += "<table>";
        
        
         table += "<tr>";
         
            table += "<th>";
            table += "VinID";
            table += "</th>";
            
            table += "<th>";
            table += "Make";
            table += "</th>";
            
            table += "<th>";
            table += "Model";
            table += "</th>";
            
            table += "<th>";
            table += "Year";
            table += "</th>";
            
            table += "<th>";
            table += "Color";
            table += "</th>";
            
            table += "<th>";
            table += "";
            table += "</th>";
            
            table += "</tr>";
               
        try {
            while (this.results.next()) {
                Cars car = new Cars();
                car.setVinID(this.results.getInt("vinID"));
                car.setMake(this.results.getString("make"));
                car.setModel(this.results.getString("model"));
                car.setYear(this.results.getInt("year"));
                car.setColor(this.results.getString("color"));
                
               
             
                table += "<tr>";
               
                             
                table += "<td>";
                table += car.getVinID();
                table += "</td>";
                
                table += "<td>";
                table += car.getMake();
                table += "</td>";
                
                table += "<td>";
                table += car.getModel();
                table += "</td>";
                
                table += "<td>";
                table += car.getYear();
                table += "</td>";
                
                table += "<td>";
                table += car.getColor();
                table += "</td>";
                
                table += "<td>";
                table += "<a href=update?vinID=" + car.getVinID()+ "> Update </a>"+"<a href=delete?VinID=" + car.getVinID()+ "> Delete </a>";
                table += "</td>";
                
                
                table += "</tr>";
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        table += "</table>";

        return table;

    }
}
    
