package Commons;

import static com.everis.EFA.cv_driver;
import static com.everis.GlobalData.getData;

import org.apache.log4j.Logger;

import com.everis.ExecutionInfo;

import report.ReportPDF;
import utils.FileUtils;
import core.BasicActions;

import java.io.File;
import java.util.*;

//import report.ReportPDF;

/**
 * Classe utilitária para qualquer ação envolvendo os reports 
 * com itext, em pdf.
 * 
 * @since 03/05/2018
 * @author Leonardo Costa
 *
 */
public class ReportUtils {

	static final Logger logger = Logger.getLogger(ReportUtils.class);
	
	/**
	 * Cria o template da evidência.
	 * @param report Report PDF 
	 * @return report Report PDF com template instanciado.
	 * @throws Exception Exceção do report.
	 */
	public static ReportPDF criaTemplateEvidencia(ReportPDF report) throws Exception {
		
		if(report == null)
			report = new ReportPDF(cv_driver);
		report.setCover(getData("Cenarios"), getData("Numero do Teste")+"-"+getData("Descricao do Teste"));
		return report;
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public static void finalizarCriacaoEvidencia(ReportPDF report, boolean isPassed) throws Exception {
		String fileName = FileUtils.retornarArquivoSemData(getData("Numero do Teste")+" "+getData("Produto"), "");
		report.saveFileName(fileName, getData("Numero do Teste")+getData("Produto"), isPassed);
		logger.info("Evidencia criada com sucesso, nome ----> " + fileName);
		//copyEvidences(toPath, fileName);
	}
	
	public static void copyEvidences(String toPath) throws Exception {

        cleanDir(toPath); 

        String fileName = FileUtils.retornarArquivoSemData(getData("Numero do Teste") + getData("Produto"), "");
        String getPath = System.getProperty("user.dir") + "\\Evidences\\" + fileName + "\\*"; // Aqui deve ser o caminho onde é gerado a evidencia                         
        logger.info(getPath);
        String cmd = "xcopy " + getPath + " " + toPath;
        String zip = "C:\\Program Files\\7-Zip\\7z a -tzip";

       	String cmd2 = zip + " " + toPath + "\\Evidencias de Teste " + toPath + "\\*.pdf";

       	//String cmd2 = zip + " " + toPath + "\\pdf " + toPath + "\\*";

        Runtime.getRuntime().exec(cmd);
        Runtime.getRuntime().exec(cmd2);
}
	
	public static void cleanDir(String dirLoc) throws Exception {
        // if (!EFA.cv_onError.equals("")) {
        // }
        File dir = new File(dirLoc);
        for (File file : dir.listFiles()) {
                        if (!file.isDirectory()) {
                                        file.delete();
                        }

        }

}


}
