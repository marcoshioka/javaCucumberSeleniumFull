package core;

import static com.everis.EFA.cf_getTestEvidenceWithStep;
import static com.everis.EFA.cv_onError;
import static com.everis.EFA.evidenceEnabled;
import static com.everis.EFA.executeAction;
import static com.everis.EFA.finishExecution;
import static com.everis.GlobalData.load;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.everis.Action;
import com.everis.EFA;
import com.everis.ExecutionInfo;
import com.everis.Manager;
import com.everis.data.DataDictionary;
import com.everis.data.DataLoad;

import report.ReportPDF;

public class BaseTest {
	
	protected String result;
	protected ReportPDF evidenciaPdf;
	final static Logger logger = Logger.getLogger(BaseTest.class);
	
	@Rule
	public TestName testName = new TestName();
	
	public BaseTest(String executionName, DataDictionary data) {
		ExecutionInfo.setExecutionName(executionName);
		ExecutionInfo.setTestPlanName("XXXXXX");		
		load(data); // Fill Global Dictionary
	}
	
	@Before
	public void before() throws Exception {
		logger.info("Início do teste: " + new Date());
		DesiredCapabilities capabilities;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-agent=Chrome/56.0.0.0 Mobile | E3C6CC9273EE75C2563D7CD94825033E37AB3FA3A28157AC75673ACF9FC4362A" );
		capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		EFA.setCapabilities(capabilities);
		EFA.loadExecutionInfo();
	}
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		logger.info("Início do teste: " + new Date());
		EFA.evidenceEnabled = true;
		Manager.loadDriver();
	}
	
	@After
	public void after() throws Exception {
		evidenceEnabled = true;
		
		if (! "".equals(cv_onError))
			cf_getTestEvidenceWithStep("Error", 1);
		
		ExecutionInfo.setResult(result);
		try {
			//EvidenceUtil.create(ExecutionInfo.getTestSuite(), ExecutionInfo.getTestName(), ExecutionInfo.getExecutionName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		executeAction(Action.ClearSession, null);
		
		finishExecution();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		Manager.finishDriver();
	}
	
	protected static List<Object> loadData() throws Exception {
		String[] fullClassName = new Throwable().getStackTrace()[1].getClassName().toString().split("\\W");
		
		ExecutionInfo.setTestSuite(fullClassName[fullClassName.length - 2]);
		ExecutionInfo.setTestName(fullClassName[fullClassName.length - 1]);
		ExecutionInfo.setExecutionTimestamp(new SimpleDateFormat("yyyyMMdd-HHmmss-SSS").format(new Date()));
		
		return Arrays.asList(new DataLoad().load());
	}
	
}
