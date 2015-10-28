/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class ReadQuery {
    
    
    private Connection conn;
    private ResultSet results;

    public ReadQuery() {

        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String pass = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, pass);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doRead() {
        try {
            String query = "Select * from cars";
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getHTMLtable() {
        String table = "";
        table += "<table border=2>";

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
                table += "<a href=delete?VinID=" + car.getVinID()+ "> Delete </a>";
                table += "</td>";
                
                
                table += "</tr>";
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        table += "</table>";

        return table;

    }
}