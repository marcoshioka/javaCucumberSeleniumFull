package PageObjects;

import Commons.Drivers;
import Commons.Sorting;
import Steps.Hooks;
import com.cucumber.listener.Reporter;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;

public class DadosUnificadosPage extends Drivers {

    Hooks hooks = new Hooks();
    Sorting sorting = new Sorting();
    private Faker faker = new Faker(new Locale("pt-BR"));

    protected static By campoNome = By.xpath("//label[contains(text(), 'Como quer ser chamado')]//..//input");
    protected static By campoEmail = By.xpath("//label[contains(text(), 'Qual seu e-mail')]//..//input");
    protected static By campoConfirmeEmail = By.xpath("//label[contains(text(), 'Confirme o seu e-mail')]//..//input");
    protected static By campoSenha = By.xpath("//label[contains(text(), 'Senha')]//..//input");
    protected static By campoConfirmeSenha = By.xpath("//label[contains(text(), 'Confirmar senha')]//..//input");
    protected static By botaoSeguir = By.xpath("//button[contains(text(), 'Seguir')]");

    public String urlCadastro = "https://uat-invistacompi.cs17.force.com/s/login/SelfRegister";

    public String nome = faker.name().firstName();

    public void irParaCadastro() throws Throwable {
        Reporter.addStepLog("Acessando a página de dados unificados");
        Drivers.irParaURL(urlCadastro);
        Drivers.waitForElementToBeClickable(campoNome);
        Reporter.addStepLog("Direcionamento realizado com sucesso para a página de dados unificados");
    }

    public void inserirNome() throws Throwable {
        Reporter.addStepLog("Inserindo nome: " + nome );
        Drivers.waitForElementToBeClickable(campoNome);
        Drivers.sendKeys(campoNome, nome);
        Reporter.addStepLog("Nome " + nome + " inserido com sucesso.");
    }


    public void inserirEmail() throws Throwable {
        Reporter.addStepLog("Inserindo e-mail: " + hooks.coletaDados());
        Drivers.waitForElementToBeClickable(campoEmail);
        Drivers.sendKeys(campoEmail, hooks.coletaDados());
        Drivers.sendKeys(campoEmail, Keys.TAB.toString());
        Reporter.addStepLog("E-mail " + hooks.coletaDados() + " inserido com sucesso.");
    }

    public void confirmarEmail() throws Throwable {
        Reporter.addStepLog("Confirmando e-mail: " + hooks.coletaDados());
        Drivers.waitForElementToBeClickable(campoConfirmeEmail);
        Drivers.sendKeys(campoConfirmeEmail, hooks.coletaDados());
        Drivers.sendKeys(campoConfirmeEmail, Keys.TAB.toString());
        Reporter.addStepLog("E-mail " + hooks.coletaDados() + " confirmado com sucesso.");
    }

    public void enviarDadosSenha() throws Throwable {
        Reporter.addStepLog("Confirmando dados de senha");
        sorting.sort("./files/listaSenhas.txt");
        RandomAccessFile random = new RandomAccessFile("./files/listaSenhas.txt", "r");
        String senhaRandom = random.readLine();
        random.close();
        Drivers.sendKeys(campoSenha, senhaRandom);
        hooks.salvaDados(senhaRandom);
        String senhaSalva = hooks.coletaDados();
        Drivers.sendKeys(campoConfirmeSenha, senhaSalva);
        Reporter.addStepLog("Senha " + senhaSalva + " inserida corretamente");
    }

    public void clicaSeguir() throws IOException {
        Reporter.addStepLog("Acionando botão Seguir");
        Drivers.waitForElementToBeVisible(botaoSeguir);
        Drivers.jsClick(botaoSeguir);
        Reporter.addStepLog("Botão Seguir acionado com sucesso.");
    }


}
