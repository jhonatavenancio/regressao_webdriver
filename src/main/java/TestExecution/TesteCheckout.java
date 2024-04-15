package TestExecution;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.Actions;
import Base.Log;
import Base.NavegadorUtilizado;
import Utils.CarrinhoCompras;
import Utils.Checkout;
import Utils.TelaLogin;

public class TesteCheckout {

	private static WebDriver driver;
	
	// Informações de login
    public static String login = "standard_user";
    public static String senha = "secret_sauce";
    public static String url = "https://www.saucedemo.com/v1/index.html";
    
    public static String nome = "Tony";
    public static String ultimoNome = "Stark";
    public static String cep = "40028922";


	@BeforeAll
    public static void preparacaoAmbiente() {
        Log.criarArquivoLog("Log.teste_Checkout");
    }

    @BeforeEach
    public void inicialização() {
        driver = NavegadorUtilizado.setaNavegadorUtilizado("FIREFOX");
        driver.get(url);
        NavegadorUtilizado.maxmize();
        TelaLogin.fazerlogin(driver, login, senha);
    }

    @AfterAll
    public static void encerrarTudo() {
        Log.line();
        Log.encerrarLog();
    }

    @AfterEach
    public void encerrarDriver() {
        driver.quit();
    }
    
    @Test
    public void finalizarPedido() {
    	Log.line();
    	Log.registrar("Finalizando um pedido");
    	
		CarrinhoCompras.adicionarItensTelaHome(driver, 0, 1, 6);
		CarrinhoCompras.validarAdicionados(driver, 6);
		
		Checkout.checkout(driver, nome, ultimoNome, cep);
		Checkout.confirmarPedido(driver);

    	Actions.esperarSegundos(1000);
    	
	    WebElement valorAtual = driver.findElement(By.cssSelector(".complete-header"));
	    Checkout.validarTexto(driver, "THANK YOU FOR YOUR ORDER", valorAtual);
	    
    }
    
    @Test
    public void preencherApenasNome() {
    	Log.line();
    	Log.registrar("PREENCHER APENAS NOME");
    	
		CarrinhoCompras.adicionarItensTelaHome(driver, 0, 1, 6);
		CarrinhoCompras.validarAdicionados(driver, 6);
		
		Checkout.checkout(driver, nome, "", "");

    	Actions.esperarSegundos(1000);
    	
	    WebElement valorAtual = driver.findElement(By.cssSelector("*[data-test=\"error\"]"));
	    Checkout.validarTexto(driver, "Error: Last Name is required", valorAtual);
    }
    
    @Test
    public void preencherApenasSobrenome() {
    	Log.line();
    	Log.registrar("PREENCHER APENAS ULTIMO NOME");
    	
		CarrinhoCompras.adicionarItensTelaHome(driver, 0, 1, 6);
		CarrinhoCompras.validarAdicionados(driver, 6);
		
		Checkout.checkout(driver, "", ultimoNome, "");

    	Actions.esperarSegundos(1000);
    	
	    WebElement valorAtual = driver.findElement(By.cssSelector("*[data-test=\"error\"]"));
	    Checkout.validarTexto(driver, "Error: First Name is required", valorAtual);
    }
    
    @Test
    public void preencherApenasCep() {
    	Log.line();
    	Log.registrar("PREENCHER APENAS ULTIMO NOME");
    	
		CarrinhoCompras.adicionarItensTelaHome(driver, 0, 1, 6);
		CarrinhoCompras.validarAdicionados(driver, 6);
		
		Checkout.checkout(driver, "", "", cep);

    	Actions.esperarSegundos(1000);
    	
	    WebElement valorAtual = driver.findElement(By.cssSelector("*[data-test=\"error\"]"));
	    Checkout.validarTexto(driver, "Error: First Name is required", valorAtual);
    }
}