package report;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.everis.Utils;
import com.hp.lft.report.ReportException;

/**
 * Classe responsável por gerenciar tratativas na evidencia. 
 * 
 * @author Leonardo Costa
 * @since 26/04/2018
 *
 */
public class EvidenceManager {
	
	static final Logger logger = Logger.getLogger(EvidenceManager.class);
		
	private static HashMap <String, List<Path>> pathMap;
	private static HashMap <String, List<String>> reportMap;
	private static Path pathToSave;
		
	/**
	 * Construtor privado.
	 */
	private EvidenceManager () {
	}
	
	/**
	 * Recebe um objeto Path referente ao arquivo, 
	 * move ele para o diretorio do teste e mantem o novo Path relaciado ao teste executado.
	 * Caso ja exista um arquivo com o mesmo nome no diretorio de destino, entao ele sera sobescrito.
	 * 
	 * @param path
	 * @throws Exception 
	 * @throws ReportException 
	 */
	public static void addEvidence (Path path) throws Exception {
		addEvidence(path, false);
	}
	
	/**
	 * Recebe um objeto Path referente ao arquivo,
	 * copy / move ele para o diretorio do teste e mantem o novo Path relaciado ao teste executado.
	 * Caso ja exista um arquivo com o mesmo nome no diretorio de destino, entao ele sera sbrescrito.
	 * @param path - caminho do arquivo para adicionar a pasta de evidencia.
	 * @param copyFile <b>True</b> : copia o arquivo para a pasta de evidencia.
	 * <b>False</b> :  move o arquivo para a pasta de evidencia. 
	 * @throws Exception 
	 * @throws ReportException 
	 */
	public static void addEvidence (Path path, boolean copyFile) throws Exception {
		String testName = getTestName ();
		Path fullPath = Paths.get(pathToSave + "/" + "/" + testName + "/" + testName + "/" + path.getFileName() );
		
		if (!pathMap.containsKey(testName)) {
			pathMap.put(testName, new ArrayList <Path> ());
		}
		try {	
			if (!Files.exists(fullPath)) {
				Files.createDirectories(fullPath.getParent());
			}
			if(copyFile){
				Files.copy(path,fullPath, StandardCopyOption.REPLACE_EXISTING);
			}
			else{
				Files.move(path,fullPath, StandardCopyOption.REPLACE_EXISTING);
			}
			pathMap.get(testName).add(fullPath);
		}
		catch (IOException e ) {
			logger.error("Falha ao mover o arquivo de " + path.toString() + " para " + fullPath + " -----\n" + e.getMessage());
			throw new Exception("Falha ao mover o arquivo de " + path.toString() + " para " + fullPath + " -----\n" + e.getMessage());
		}		
	}
	
	/**
	 * Recebe um objeto Path referente ao arquivo,
	 * copy / move ele para o diretorio do teste e mantem o novo Path relaciado ao teste executado.
	 * Caso ja exista um arquivo com o mesmo nome no diretorio de destino, entao ele sera sobrescrito.
	 * @param path - caminho do arquivo para adicionar a pasta de evidencia.
	 * @param copyFile <b>True</b> : copia o arquivo para a pasta de evidencia.
	 * <b>False</b> :  move o arquivo para a pasta de evidencia. 
	 * @throws Exception 
	 */
	public static void addEvidence (Path path, String file, String testName) throws Exception {
		
		Path fullPath = Paths.get(pathToSave + "/" + testName + "/"+ file + ".pdf" );
		
		if (!pathMap.containsKey(testName)) {
			pathMap.put(testName, new ArrayList <Path> ());
		}
		try {	
			if (!Files.exists(fullPath)) {
				Files.createDirectories(fullPath.getParent());
			}
			
			Files.move(path,fullPath, StandardCopyOption.REPLACE_EXISTING);
			
			pathMap.get(testName).add(fullPath);
			
			Utils.copyFiles(fullPath.toString());
		}
		catch (IOException e ) {
			logger.error("Falha ao mover o arquivo de " + path.toString() + " para " + fullPath + " -----\n" + e.getMessage());
			throw new Exception("Falha ao mover o arquivo de " + path.toString() + " para " + fullPath + " -----\n" + e.getMessage());
		}		
	}
		
	/**
	 * Retorna uma lista de Path que contem os enderecos 
	 * para as evidencias relacionadas ao caso de teste que esta sendo executado.
	 * 
	 * @return List<Path>  Lista de Path contendo endereco das evidencias
	 */
	public static List <Path> getEvidences () {
		String testName = getTestName();
		return pathMap.get(testName);
	}
		
	/**
	 * Retorna uma lista de Path que contem os enderecos 
	 * para as evidencias relacionadas ao caso de teste recebido por parametro
	 * 
	 * @return List<Path>  Lista de Path contendo endereco das evidencias
	 */
	public static List <Path> getEvidences (String testName) {
		return pathMap.get(testName);
	}
			
	/**
	 * Obtem o nome teste que esta sendo executado
	 * 
	 * @return Retorno o nome do metodo de teste que esta sendo executado.
	 */
	private static String getTestName () {
		return Thread.currentThread().getName();
	}
	
	/**
	 * Adiciona a lista de texto padrao do Report para ser utilizado no metodo getTextReport.
	 * @param text
	 */
	public static void addTextReport(String text){
		String testName = getTestName ();	
		if (!reportMap.containsKey(testName)) {
			reportMap.put(testName, new ArrayList <String> ());
		}
		reportMap.get(testName).add(text);
	}
	
	/**
	 * Retorna a lista de textos padroes adicionando pelo metodo addTextReport e limpa a lista referente ao testName Informado. 
	 * @param testName
	 * @return
	 */
	public static List<String> getTextReport(String testName){
		List<String> listTextReport = new ArrayList <String> ();
		try{
			if (reportMap.containsKey(testName)) {
				int i = 0;
				for(String text : reportMap.get(testName)){
					listTextReport.add((i==0)?text:"\n"+text);
					i++;
				}
			}
			reportMap.get(testName).clear();
			return listTextReport;
		}
		catch(Exception e){
			return listTextReport;
		}
	}

	/**
	 * Metodo para limpar a Lista que contem os textos padroes adicionados pelo addTextReport.
	 * @param testName
	 */
	public static void clearTextReport(String testName){
		if(reportMap.containsKey(testName)){
			reportMap.get(testName).clear();
		}
	}
	
	static {
		pathMap = new HashMap <String, List<Path>>();
		reportMap = new HashMap <String, List<String>>(); 
		pathToSave = Paths.get("./Evidences/");
		try {
			Files.createDirectories(pathToSave);
		} catch (IOException e) {
			logger.error("Falha ao criar o diretorio para salvar a evidencia: " + e.getMessage());
		}
	}
	
}
