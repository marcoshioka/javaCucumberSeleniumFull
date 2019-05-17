package PageObjects;

import java.io.IOException;
import java.util.Locale;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;
import com.github.javafaker.Faker;

import Commons.Drivers;
import Commons.GeraCpfCnpj;
import Commons.GeradorDeData;
import Steps.Hooks;

public class CpfPage extends Drivers{

	Hooks hooks = new Hooks();

	Faker faker = new Faker(new Locale("pt-BR"));
	
	GeradorDeData dataNascimento = new GeradorDeData();
	
	private GeraCpfCnpj geradorCpf = new GeraCpfCnpj();
	

	protected static By campoCPF = By.xpath("//input[@placeholder='CPF']");
	protected static By titulo = By.xpath("//span[contains(text(),'Precisamos de mais alguns dados')]");
	protected static By campoNome = By.xpath("//label[contains(text(), 'Nome completo')]//ancestor::lightning-input");
	protected static By campoDataNascimento = By.xpath("//label[contains(text(), 'Data de nascimento')]//ancestor::lightning-input");
	protected static By campoSexo = By.xpath("//select[@name='sexo']");
	protected static By sexoMasculino = By.xpath("//select[@name='sexo']//option[contains(text(), 'Masculino')]");
	protected static By campoEstadoCivil = By.xpath("//select[@name='estadoCivil']");
	protected static By estadoCivilSolteiro = By.xpath("//select[@name='estadoCivil']//option[contains(text(), 'Solteiro(a)')]");
	protected static By botaoSeguir = By.xpath("//button[contains(text(), 'Seguir')]");

	public String cpfUrl = "https://uat-invistacompi.cs17.force.com/s/cadastroprincipal/";
	public String cpfQuando1 = "E insiro CPF";
	public String cpfQuando2 = "E as informacoes Nome Completo, Data de nascimento, Sexo, Estado civil";

	public void irParaTelaCPF() throws Throwable {
		Reporter.addStepLog("Acessando a página de cadastro do CPF");
		Drivers.irParaURL(cpfUrl);
		Drivers.waitForElementToBeVisible(titulo);
		Reporter.addStepLog("Direcionamento realizado com sucesso para a página de CPF");
	}

	public void insereCPF () throws IOException{
		Reporter.addStepLog("Inserindo CPF");
		Drivers.waitForElementToBeVisible(titulo);
		String cpf = geradorCpf.cpf();
		hooks.salvaDados(cpf);
		String cpfGerado = hooks.coletaDados();
		Drivers.sendKeys(campoCPF, cpfGerado);
		Reporter.addStepLog("CPF " + cpfGerado + " inserido com sucesso.");
	}
	
	public void insereNomeCompleto () throws IOException{
		Reporter.addStepLog("Inserindo Nome Completo");
		Drivers.waitForElementToBeVisible(campoNome);
		String nome = faker.name().fullName();
		Drivers.sendKeys(campoNome, nome);
		Reporter.addStepLog("Nome " + nome + " inserido com sucesso.");
	}
	
	public void insereDataNascimento () throws IOException{
		Reporter.addStepLog("Inserindo Data de Nascimento");
		Drivers.waitForElementToBeVisible(campoDataNascimento);
		String data = GeradorDeData.randomDOB();
		Drivers.sendKeys(campoDataNascimento, data);
		Reporter.addStepLog("Data " + data + " inserida com sucesso.");
	}
	
	public void selecionaSexoMasculino() throws IOException{
		Reporter.addStepLog("Selecionando Sexo Masculino");
		Drivers.waitForElementToBeVisible(campoSexo);
		Drivers.click(sexoMasculino);
		Drivers.marcarElemento(campoSexo);
		Reporter.addStepLog("Sexo Masculino selecionado com sucesso.");
	}
	
	public void selecionaEstadoCivilSolteiro() throws IOException{
		Reporter.addStepLog("Selecionando Estado Civil Solteiro");
		Drivers.waitForElementToBeVisible(campoEstadoCivil);
		Drivers.click(estadoCivilSolteiro);
		Drivers.marcarElemento(campoEstadoCivil);
		Reporter.addStepLog("Estado Civil Solteiro selecionado com sucesso.");
	}
	
	public void clicaSeguir() throws IOException{
		Reporter.addStepLog("Acionando botão Seguir");
		Drivers.waitForElementToBeVisible(botaoSeguir);
		Drivers.click(botaoSeguir);
		Reporter.addStepLog("Botão Seguir acionado com sucesso.");
	}

	
	
}