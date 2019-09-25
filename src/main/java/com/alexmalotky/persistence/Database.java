package com.alexmalotky.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Provides access the database
 * Created on 8/31/16.
 *
 * @author pwaite
 */

public class Database {

    private final Logger logger = LogManager.getLogger(this.getClass());

    // create an object of the class Database
    private static Database instance = new Database();

    private Properties properties;

    private Connection connection;

    // private constructor prevents instantiating this class anywhere else
    private Database() {
        loadProperties();

    }

    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/database.properties"));
        } catch (IOException ioe) {
            logger.error("Database.loadProperties()...Cannot load the properties file");
            logger.error(ioe.getStackTrace());
        } catch (Exception e) {
            logger.error("Database.loadProperties()..." + e);
            logger.error(e.getStackTrace());
        }

    }

    // get the only Database object available
    public static Database getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void connect() throws Exception {
        if (connection != null)
            return;

        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            throw new Exception("Database.connect()... Error: MySQL Driver not found");
        }

        String url = properties.getProperty("url");
        connection = DriverManager.getConnection(url, properties.getProperty("username"),  properties.getProperty("password"));
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Cannot close connection" + e);
            }
        }

        connection = null;
    }

}