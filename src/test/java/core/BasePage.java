package core;

import static com.everis.EFA.cv_driver;
import static com.everis.EFA.executeAction;
import static com.everis.GlobalData.getData;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.everis.Action;

import utils.Constants;

public abstract class BasePage {
	
	protected WebDriverWait wait = new WebDriverWait(cv_driver, 10);
	
	public abstract boolean isAt() throws Exception;
	
	public void irPara(String url) throws Exception {
		executeAction(Action.Navigate, getData(Constants.TXT_VURL));
	}
	
}
