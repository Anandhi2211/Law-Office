package com.solvd.lawoffice.util;

import com.solvd.lawoffice.Main;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class ConfigUtil {
    private static final String CONFIGFile = "config.properties";


    public static <T> Object getDaoByInterface(Class className){

        String path = getPathToDaoImplFolder();
        System.out.println("this"+className.getClass().getSimpleName());
        try{
            return Class.forName(path+className.getClass().getName())
                    .getConstructor().newInstance();
        } catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException | InstantiationException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPathToDaoImplFolder(){
        try(InputStream inputStream = Main.class.getClassLoader()
                .getResourceAsStream(CONFIGFile)){
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty("Impl");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
