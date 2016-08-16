package datamanagement;

import java.util.*;
import java.io.*;

/**
 * Singleton class allowing access to externally stored property file.
 *
 */
public class AppProperties
{
    private static AppProperties self = null;
    private Properties properties;

    public static AppProperties getInstance()
    {
        if (self == null)
        {
            self = new AppProperties();
        }
        
        return self;
    }

    private AppProperties()
    {
        properties = new Properties();

        try
        {
            properties.load(new FileInputStream(Constants.PROPERTY_FILE_PATH));
        }
        catch (IOException e)
        {
            throw new RuntimeException("Could not read property file");
        }
    }

    public Properties getProperties()
    {
        return properties;
    }
}
