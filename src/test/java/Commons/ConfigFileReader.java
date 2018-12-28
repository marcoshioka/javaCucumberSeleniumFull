package Commons;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import javax.management.RuntimeErrorException;

public class ConfigFileReader extends Drivers {
	
	private static final Path currentRelativePath = Paths.get("");
	private static final String currentPath = currentRelativePath.toAbsolutePath().toString();
	private static final String propertyFilePath = currentPath+"Configuration.properties";
	
	private static Properties properties;
	
	protected ConfigFileReader(){
		try {
			BufferedReader readerProperties = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(readerProperties);
				readerProperties.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("ARQUIVO (Configuration.properties) NÃO ENCONTRADO NO CAMINHO ESPECIFICADO: " + propertyFilePath);
		}
	}
	

	//USU�RIO V�LIDO
	protected static String readUser(String profile) {
		new ConfigFileReader();
		String attribute = properties.getProperty(profile);
		if (attribute!= null) { 
			return attribute;
		} else {
			Drivers.closeWindow();
			RuntimeErrorException attributeNotFound = new RuntimeErrorException(null, "ATRIBUTO ("+profile+") NÃO DEFINIDO NO ARQUIVO Configuration.properties");
			log.error(attributeNotFound);
			throw attributeNotFound;
		}
	}
	
	//SENHA
	protected static String readPassword(String password) {
		new ConfigFileReader();
		String attribute = properties.getProperty("senha_"+password);
		if (attribute!= null) { 
			return attribute;
		} else {
			Drivers.closeWindow();
			RuntimeErrorException attributeNotFound = new RuntimeErrorException(null, "ATRIBUTO (senha_"+password+") NÃO DEFINIDO NO ARQUIVO Configuration.properties");
			log.error(attributeNotFound);
			throw attributeNotFound;
		}
	}
	
	//DRIVER e AMBIENTE
	protected static void readAccess(String driver, String environment) {
		new ConfigFileReader();
		String driverReaded = properties.getProperty(driver);
		String urlReaded = properties.getProperty(environment);
		if ((driverReaded).equals(null) || (urlReaded).equals(null) ) {
			Drivers.closeWindow();
			RuntimeErrorException attributeNotFound = new RuntimeErrorException(null, "ATRIBUTO ("+ driver +" ou "+ environment +") NÃO DEFINIDO NO ARQUIVO Configuration.properties");
			log.error(attributeNotFound);
			throw attributeNotFound;
		}
		Drivers.accessDefined(driverReaded, urlReaded);
	}
	
	//NOME USU�RIO
	protected static String readUserName(String userName) {
		new ConfigFileReader();
		String attribute = properties.getProperty("nome_"+userName);
		if (attribute!= null) { 
			return attribute;
		} else {
			Drivers.closeWindow();
			RuntimeErrorException attributeNotFound = new RuntimeErrorException(null, "ATRIBUTO (nome_"+userName+") NÃO DEFINIDO NO ARQUIVO Configuration.properties");
			log.error(attributeNotFound);
			throw attributeNotFound;
		}
	}
	
	//SCRIPT
	protected static String readScript(String script) {
		new ConfigFileReader();
		String attribute = properties.getProperty(script);
		if (attribute!= null) { 
			return attribute;
		} else {
			Drivers.closeWindow();
			RuntimeErrorException attributeNotFound = new RuntimeErrorException(null, "ATRIBUTO ("+script+") NÃO DEFINIDO NO ARQUIVO Configuration.properties");
			log.error(attributeNotFound);
			throw attributeNotFound;
		}
	}
	
	//URL
	protected static String readUrl(String url) {
		new ConfigFileReader();
		String attribute = properties.getProperty(url);
		if (attribute!= null) { 
			return attribute;
		} else {
			Drivers.closeWindow();
			RuntimeErrorException attributeNotFound = new RuntimeErrorException(null, "ATRIBUTO ("+url+") NÃO DEFINIDO NO ARQUIVO Configuration.properties");
			log.error(attributeNotFound);
			throw attributeNotFound;
		}
	}

}