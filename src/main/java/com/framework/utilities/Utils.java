package com.framework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
    public static Properties getAppPropertiesFile() {
        Properties props = null;
        try {
            File fileConfig = new File("src/main/resources/app.properties");
            FileInputStream stream = new FileInputStream(fileConfig);
            props = new Properties();
            props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }
}
