package junit;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class Watcher extends TestWatcher {

//	static final Logger logger = Logger.getLogger(Watcher.class);
	
//	private ALM alm;

	public Watcher() {
	}

	protected void starting(Description description) {
		Thread.currentThread().setName(description.getMethodName());
	}

	/**
	 * Metodo utilizado pelo JUnit para informar a falha na execução do caso de
	 * teste e executar a rotina de criação do pptx e upload para o alm. Para o
	 * correto funcionamento deve-se incluir na sua classe de Test do JUnit a
	 * seguinte sintaxe nas declaração de variaveis globais '@Rule public
	 * Evidence evidencia = new Evidence()'
	 * 
	 * @author Leonardo Costa.
	 */
	@Override
	protected void failed(Throwable t, Description description) {
//		logger.info("Finalizado " + description.getMethodName() + " com status failed ");
		try {
			exportStackTrace(t, description.getMethodName());
//			alm = new ALM(description.getMethodName());
//			alm.upload(false);
		} catch (Exception e) {
//			logger.fatal(e.getMessage(), e);
			throw new IllegalAccessError(e.getMessage());
		}
	}

	/**
	 * @param t
	 * @param nameCaseTest
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void exportStackTrace(Throwable t, String nameCaseTest) throws FileNotFoundException, IOException {
//		String path = Paths.get("").toAbsolutePath().toString() + "//Evidences//" + nameCaseTest
//				+ DateUtils.formatDate("yyyyMMddhhmmss", new Date()) + ".txt";
//		FileOutputStream file = new FileOutputStream(path);
//		PrintStream s = new PrintStream(file, true);
//		t.printStackTrace(s);
//		file.close();
//		EvidenceManager.addEvidence(Paths.get(path));
	}

	/**
	 * Metodo utilizado pelo JUnit para informar a correta execução do caso de
	 * teste e executar a rotina de criação do pptx e upload para o alm. Para o
	 * correto funcionamento deve-se incluir na sua classe de Test do JUnit a
	 * seguinte sintaxe nas declaração de variaveis globais '@Rule public
	 * Evidence evidencia = new Evidence()'
	 * 
	 * @author Leonardo Costa.
	 */
	@Override
	protected void succeeded(Description description) {
//		logger.info("Finalizado " + description.getMethodName() + " com status succeeded");
		try {
//			alm = new ALM(description.getMethodName());
//			alm.upload(true);
		} catch (Exception e) {
//			logger.fatal(e.getMessage(), e);
			throw new IllegalAccessError(e.getMessage());
		}
	}

	@Override
	protected void finished(Description description) {
//		logger.info("Finished - " + description.getMethodName());
	}
}
