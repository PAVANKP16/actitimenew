package Utiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

		Properties pro;
		
		public ReadConfig() {
			pro = new Properties();
			File f= new File("./actitimeconfiguration/config.properties");
			try {
				FileInputStream fis= new FileInputStream(f);
				pro.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public String setBrowser()
		{
			String browser = pro.getProperty("browser");
			return browser;
		}
		
		public String setURL()
		{
			String url = pro.getProperty("URL");
			return url;
		}
}
