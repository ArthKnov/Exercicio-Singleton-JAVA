package com.exemplos.configuracoes.problema2Singleton;
/**
 * @author ArthurLima
 * @version 2.0
 * @since fev/2025
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** Classe que acessa as configuraçoes */
public class ConfigManager {
	/** instância única do Singleton */
	private static ConfigManager instance;
	/**Objeto para armazenar as configurações */
	private Properties properties;
	/** Construtor privado- busca dados de configuração no arquivo
config.properties */
	private ConfigManager() {
		properties=new Properties();
		//buscar as configurações no arquivo
		loadConfigurations();
	}


	/** Método responsável por carregar as configurações do arquivo */
	private void loadConfigurations() {

		InputStream file =
				this.getClass().getResourceAsStream("config.properties" );
		try{
			properties.load(file);
			System.out.println("Configurações carregadas com sucesso.");
			file.close();
		}
		catch(IOException e){
			System.out.println("Arquivo de configuração não encontrado!");

			e.printStackTrace();
		}

	}
	/** Método público para obter a instância única */
	public static ConfigManager getInstance() {
		if (instance == null) {
			instance = new ConfigManager();
		}
		return instance;
	}
	/** Método para obter um valor da configuração
	 * @return String- dado da configuração
	 * @param chave do properties
	 * */
	public String getConfig(String key) {
		return properties.getProperty(key);
	}
}
