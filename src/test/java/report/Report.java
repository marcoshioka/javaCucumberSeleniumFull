package report;

import org.openqa.selenium.WebElement;

//import com.hp.lft.report.ReportException;
import com.itextpdf.text.BaseColor;

import exceptions.EvidenciaException;

/**
 * 
 * Propósito: Interface com o objetivo de encapsular as funcionalidades de criação das evidências
 * 
 * @author Leonardo Costa
 * @since 26/04/2018
 */
public interface Report {

	/**
	 * Captura a tela atual e empilha a imagem ao Report sem precisar incluir o texto.
	 * @throws EvidenciaException
	 */
	public void addStep() throws EvidenciaException;
	
	/**
	 * Captura a tela atual e empilha a imagem ao Report junto a descricao
	 * recebida por parametro.
	 * 
	 * @param description
	 *            Texto que sera adicionado ao report junto a imagem
	 * @throws EvidenciaException
	 */
	public void addStep(String description) throws EvidenciaException;

	/**
	 * Captura a tela atual e empilha a imagem ao Report junto a descricao
	 * recebida por parametro. Permite também desativar temporariamente a utilizacao do texto padrao.
	 * 
	 * @param description
	 * 			Texto que sera adicionado ao report junto a imagem	
	 * @param discartStandardText
	 * 			Se o valor for True, nao adiciona o texto padrao que foi incluido no metodo EvidenceManager.addTextReport.
	 * @throws EvidenciaException
	 */
	public void addStep(String description, boolean discartStandardText) throws EvidenciaException;;

	/**
	 * Recebe os elementos da tela que devem ser destacados, captura a tela e
	 * empilha a imagem ao Report. Apos
	 * a captura da tela os highlights devem ser removidos.
	 * 
	 * @param WebElement[]
	 *            Lista de WebElements que devem ser destacados.
	 * @throws EvidenciaException 
	 */
	public void addStep(WebElement... webElement) throws EvidenciaException;;
	
	/**
	 * Recebe os elementos da tela que devem ser destacados, captura a tela e
	 * empilha a imagem ao Report junto a descricao recebida por parametro. Apas
	 * a captura da tela os highlights devem ser removidos.
	 * 
	 * @param description
	 *            Texto que sera adicionado ao report junto a imagem
	 * @param WebElement[]
	 *            Lista de WebElements que devem ser destacados.
	 * @throws EvidenciaException
	 */
	public void addStep(String description, WebElement... webElement) throws EvidenciaException;;

	/**
	 * Recebe os elementos da tela que devem ser destacados, captura a tela e
	 * empilha a imagem ao Report junto a descricao recebida por parametro. Apas
	 * a captura da tela os highlights devem ser removidos. 
	 * Permite tambam desativar temporariamente a utilizaaao do texto padrao.
	 * 
	 * @param description
	 * 			Texto que sera adicionado ao report junto a imagem
	 * @param discartStandardText
	 * 			Se o valor for True, nao adiciona o texto padrao que foi incluido no metodo EvidenceManager.addTextReport.
	 * @param webElement
	 *  		Lista de WebElements que devem ser destacados.
	 *  @throws EvidenciaException
	 */
	public void addStep(String description, boolean discartStandardText, WebElement... webElement) throws EvidenciaException;;

	/**
	 * Define qual o local o Report deve ser salvo.
	 * 
	 * Caso nao seja definido, usara como default o diretorio de execução.
	 * 
	 * @param path Path indicando qual diretario o Report deve ser salvo.
	 * @throws EvidenciaException
	 */
	public void setPath(String path);

	/**
	 * Define o nome do teste e o objetivo dele na capa do Report. Caso nao seja
	 * definido nenhum valor e capa sera adicionada em branco.
	 * 
	 * @param testName
	 * @param objective
	 * @throws EvidenciaException
	 */
	public void setCover(String testName, String objective) throws EvidenciaException;;

	/**
	 * Salva a evidencia em caminho previamente especificado. Caso nao tenha
	 * sido especificado um caminho, entao salvara no diretorio de execucao
	 * @throws ReportException 
	 * @throws Exception 
	 */
	public void save() throws EvidenciaException, Exception;;

	/**
	 * Salva a evidencia em caminho previamente especificado. Caso nao tenha
	 * sido especificado um caminho, entao salvara no diretorio de execução
	 * @throws ReportException 
	 */
//	public void save(String path) throws ReportException;;
	public void save(String path) throws Exception;

	/**
	 * Adicionar um texto a Pagina
	 * 
	 * @param description Texto que sera adicionado ao report junto a imagem
	 * @throws EvidenciaException 
	 */
	public void addText(String description) throws EvidenciaException;
	
	/**
	 * Adicionar uma linha em branco na Pagina
	 * 
	 * @throws EvidenciaException 
	 */
	public void addEmptyLine() throws EvidenciaException;


	/**
	 * Desabilita o texto standard.
	 * @throws EvidenciaException
	 */
	public void disableStandardText() throws EvidenciaException;;
	
	/**
	 * 
	 * @param isPassed
	 * @throws ReportException 
	 */
//	public void save (boolean isPassed) throws ReportException;;
	public void save (boolean isPassed) throws Exception;
	
	/**
	 * Adicionar um texto a mesma pagina
	 * 
	 * @param description
	 *            Texto que sera adicionado ao report junto a imagem
	 * @param fontName
	 *            Define o nome da fonte
	 * @param size
	 *            Define tamanho da fonte
	 * @param style
	 *            Define o estilo da fonte ex:(Italic, bold)
	 * @BaseColor 
	 *            Define a cor da fonte
	 * Exemplo de uso: report.addFreeText("EXAMPLE", FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.GREEN);
	 * @throws EvidenciaException 
	 * 
	 */
	public void addFreeText(String description, String fontName, float size, int style, BaseColor color) throws EvidenciaException;;
	
	
	/**
	 * Salva o arquivo de evidência 
	 * @param file Arquivo a ser adicionado
	 * @param testName Nome da chave que guarda a lista de arquivos a ser adcionado
	 * @throws ReportException 
	 */
//	public void saveFileName(String file, String testName, boolean status) throws ReportException;
	public void saveFileName(String file, String testName, boolean status) throws Exception;
}
