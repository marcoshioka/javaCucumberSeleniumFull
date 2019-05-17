package PageObjects;

import Commons.Drivers;
import Steps.Hooks;
import com.cucumber.listener.Reporter;
import org.openqa.selenium.By;

import java.io.IOException;


public class AvisoFotoPage extends Drivers {

    Hooks hooks = new Hooks();

    protected static By titulo = By.xpath("//div[contains(text(), 'Precisamos de uma foto')]");
    protected static By botaoVamosLa = By.xpath("//button[contains(text(), 'Vamos lá')]");


    public void verificarPaginaAvisoFoto() throws Throwable {
        Reporter.addStepLog("Verificando página de Aviso da Foto");
        Drivers.waitForElementToBeVisible(titulo);
        Drivers.marcarElemento(titulo);
        Reporter.addStepLog("Página de Aviso de Foto verificada com sucesso.");
    }

    public void clicarVamosLa() throws IOException {
        Reporter.addStepLog("Acionando botão Vamos Lá");
        Drivers.waitForElementToBeVisible(botaoVamosLa);
        Drivers.jsClick(botaoVamosLa);
        Reporter.addStepLog("Botão Vamos Lá acionado com sucesso.");
    }
}
