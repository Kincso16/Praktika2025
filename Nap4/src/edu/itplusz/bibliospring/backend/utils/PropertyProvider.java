package edu.itplusz.bibliospring.backend.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyProvider {
    public static Properties props;

    static{
        props = new Properties();
        try(InputStream inputStream=PropertyProvider.class.getResourceAsStream("/bibliospring.properties")){
            props.load(inputStream);
        }catch(IOException e){
            throw new RuntimeException();
        }
    }
    public static String getProperty(String key){
        return props.getProperty(key);
    }
}
