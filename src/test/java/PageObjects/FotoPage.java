package PageObjects;

import Commons.Drivers;
import com.cucumber.listener.Reporter;
import org.openqa.selenium.By;

import java.io.IOException;

public class FotoPage extends Drivers {

    protected static By titulo = By.xpath("//h2[@class='titulo-desktop'][contains(text(), 'Precisamos de uma foto')]");
    protected static By botaoPular = By.xpath("//div[contains(text(), 'Pular')]");


    public void verificarPaginaFoto() throws Throwable {
        Reporter.addStepLog("Verificando página de envio da Foto");
        Drivers.waitForElementToBeVisible(titulo);
        Drivers.marcarElemento(titulo);
        Reporter.addStepLog("Página de envio da Foto verificada com sucesso.");
    }

    public void clicarPular() throws IOException {
        Reporter.addStepLog("Acionando botão Pular");
        Drivers.waitForElementToBeVisible(botaoPular);
        Drivers.jsClick(botaoPular);
        Reporter.addStepLog("Botão Vamos Lá acionado com sucesso.");
    }
}
