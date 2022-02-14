package dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigFileReader.
 */

public class ConfigFileReader {

  private Properties properties;
  private final String propertyFilePath = "configs//config.properties";

  /**
   * ConfigFileReader.
   */
  
  public ConfigFileReader() {

    try {
      BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
      properties = new Properties();
      try {
        properties.load(reader);
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
    }
  }

  
  /**
   * ConfigFileReader.
   */

  public long getImplicitlyWait() {
    String implicitlyWait = properties.getProperty("implicitlyWait");
    if (implicitlyWait != null) {
      return Long.parseLong(implicitlyWait);
    } else {
      throw new RuntimeException("implicitlyWait not " 
    + "specified in the Configuration.properties file.");
    }
  }

  
  
  /**
   * ConfigFileReader.
   */
  
  public String getApplicationUrl() {
    String url = properties.getProperty("url");
    if (url != null) {
      return url;
    } else {
      throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
  }

  /**
   * ConfigFileReader.
   */
  
  public String getBrowserName() {
    String browserName = properties.getProperty("browser");
    if (browserName != null) {
      return browserName;
    } else {
      throw new RuntimeException("Browser name not specified in "
    + "the Configuration.properties file.");
    }
  }
  
  /**
   * ConfigFileReader.
   */
  
  public long getPageLoadTime() {
    String pageLoadtime = properties.getProperty("pageLoadTime");
    if (pageLoadtime != null) {
      return Long.parseLong(pageLoadtime);
    } else {
      throw new RuntimeException("Browser name not specified in "
              + "the Configuration.properties file.");
    }

  }
  
  
}