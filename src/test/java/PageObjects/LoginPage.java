package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	@FindBy(how = How.ID, using = "idContText")
	public WebElement textoLogin;

	@FindBy(how = How.XPATH, using = "//input[@class='input inputContainerEmail sfdc_usernameinput input']")
	public WebElement campoEmail;

	@FindBy(how = How.XPATH, using = "//input[@class='input inputContainerSenha sfdc_passwordinput input']")
	public WebElement campoSenha;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Log in' )]")
	public WebElement botaoLogin;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Oi' )]")
	public WebElement mensagemBoasVindas;
	
	public String emailBase = "yieedqeu@sharklasers.com";
	
	public String senhaBase = "shark@01";
	

}
