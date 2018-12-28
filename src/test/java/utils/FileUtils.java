package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;


/**
 * Classe utilitária para qualquer ação envolvendo arquivos, sejam
 * tratativas ou manipulações de arquivos.
 * 
 * @since 26/04/2018
 * @author Leonardo Costa
 *
 */
public class FileUtils {
	
	static final Logger logger = Logger.getLogger(FileUtils.class);
	static final String path = Paths.get("").toAbsolutePath().toString() + "\\output";
	static StringBuffer bufferComDirDosPrints = new StringBuffer();
	static StringBuffer bufferComPngsEvidencia = new StringBuffer();
	static StringUtils stringUtils;
	
	public static void gravarDadoArquivo(String dado) throws Exception {
		String pathDadosTemporarios = Paths.get("").toAbsolutePath().toString() + "\\resource\\files\\dadosTemporarios.txt";
		logger.info("Iniciando gravação do dado: " + dado + " no arquivo: " + pathDadosTemporarios);
		verificarExistenciaArquivoTemp();
		adicionarDadoTemporarioArquivo(dado);		

	}

	/**
	 * Adiciona dados temporários no arquivo, no caso
	 * o email temporário.
	 * @param dado - email temporário.
	 */
	private static void adicionarDadoTemporarioArquivo(String dado) {
		try {
			String pathDadosTemporarios = Paths.get("").toAbsolutePath().toString() + "\\resource\\files\\dadosTemporarios.txt";
			File fileTemp = new File(pathDadosTemporarios);
			fileTemp.delete();
			PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileTemp.getAbsoluteFile(), true)));
			printWriter.println(dado);
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	/**
	 * Verifica a existência do arquivo temporário,
	 * caso não existe é criado.
	 * @throws IOException
	 */
	private static void verificarExistenciaArquivoTemp() throws IOException {
		
		String pathDadosTemporarios = Paths.get("").toAbsolutePath().toString() + "\\resource\\files\\dadosTemporarios.txt";
		File fileTemp = new File(pathDadosTemporarios);
		if (!fileTemp.exists()) {
			fileTemp.createNewFile();
			logger.info("Arquivo de dados temporários de e-mail criado com sucesso: " + pathDadosTemporarios);
		}
	}

	/**
	 * Retorna o nome da evidência com data e hora.
	 * @param name Nome da evidência
	 * @param extension extensão do arquivo
	 * @return Nome formatado exemplo: "NomeDoTeste-26-04-2018-1508.pdf"
	 * @author Leonardo Costa
	 */
	public static String retornarArquivoComData(String name, String extension) {
		GregorianCalendar calendar = new GregorianCalendar();

		int dia = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		int mes = calendar.get(GregorianCalendar.MONTH) + 1;
		int ano = calendar.get(GregorianCalendar.YEAR);
		int hora = calendar.get(GregorianCalendar.HOUR_OF_DAY);
		int min = calendar.get(GregorianCalendar.MINUTE);

		StringBuffer fileName = new StringBuffer(name);
		fileName.append("-");
		fileName.append(dia < 10 ? "0" + dia : dia).append("-").append(mes < 10 ? "0" + mes : mes).append("-")
				.append(ano).append("-").append(hora < 10 ? "0" + hora : hora).append(min < 10 ? "0" + min : min)
				.append(!extension.isEmpty() ? "." + extension : "");

		String generatedFileName = fileName.toString();
		logger.info("Nome da evidência formatada com data e hora: " + generatedFileName);
		return generatedFileName;
	}
	
	/**
	 * Retorna o nome da evidência sem data e hora
	 * @param name Nome da evidência
	 * @param extension extensão do arquivo
	 * @return Nome formatado exemplo: "NomeDoTeste.pdf"
	 * @author Leonardo Costa
	 */
	public static String retornarArquivoSemData(String name, String extension) {
		StringBuffer fileName = new StringBuffer(name);
		fileName.append(!extension.isEmpty() ? "." + extension : "");
		String generatedFileName = fileName.toString();
		logger.info("Nome da evidência formatada sem data e hora: " + generatedFileName);
		return generatedFileName;
	}
	
	/**
	 * Coleta os diretorios com prints da evidência default do EFA3
	 * @param node Diretorios a varrer
	 * @return bufferComDirDosPrints Diretorios com caminho dos prints concatenados
	 */
	public static String coletarDiretorioEvidenciasEfa(File node){
		
		bufferComDirDosPrints.append(node.getAbsoluteFile()+";");
		
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				coletarDiretorioEvidenciasEfa(new File(node, filename));
			}
		}
		return bufferComDirDosPrints.toString();
	}
	

}
