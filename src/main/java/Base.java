package main.java;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {


    public static Properties CONFIGFILE=new Properties();

    @BeforeTest
    public static void loadConfig() {

            try {
                CONFIGFILE.load(new FileInputStream(("src/main/resources/config.properties")));
                Config.BASEURL=CONFIGFILE.getProperty("base");
                Config.CBASEURL=CONFIGFILE.getProperty("cbase");
                Config.IDS= CONFIGFILE.getProperty("id");
                Config.STUDENTNAME=CONFIGFILE.getProperty("name");
                Config.Roll=CONFIGFILE.getProperty("roll");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

