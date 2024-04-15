package TestExecution;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import Base.Log;
import Base.NavegadorUtilizado;
import Utils.CarrinhoCompras;
import Utils.TelaLogin;

public class TesteCarrinho {

	private static WebDriver driver;
	
	// Informações de login
    public static String login = "standard_user";
    public static String senha = "secret_sauce";
    public static String url = "https://www.saucedemo.com/v1/index.html";


	@BeforeAll
    public static void preparacaoAmbiente() {
        Log.criarArquivoLog("Log.teste_Carrinho");
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
    public void adicionarItemPelaTelaHome() {
    	Log.line();
    	Log.registrar("ADICIONAR ITENS NO CARRINHO");
    	CarrinhoCompras.adicionarItensTelaHome(driver, 0, 1, 6);
    }
    
    @Test
    public void removendoItemPelaTelaHome() {
    	Log.line();
    	Log.registrar("REMOVENDO ITENS DO CARRINHO");
    	CarrinhoCompras.removendoItensTelaHome(driver, 1, 6);
    }
    
    @Test
    public void adicionarItemPelaDescricao() {
    	Log.line();
    	Log.registrar("ADICIONAR ITENS PELA DESCRIÇÃO");
    	CarrinhoCompras.adicionarItensNosDetalhes(driver, 0, 0, 5);
    }
    
    @Test
    public void removendoItemPelaDescricao() {
    	Log.line();
    	Log.registrar("ADICIONAR ITENS PELA DESCRIÇÃO");
    	CarrinhoCompras.removendoItensNosDetalhes(driver, 0, 5);
    }
    
    @Test
    public void continuarComprandoTelaHome() {
    	Log.line();
    	Log.registrar("CONTINUAR COMPANDO TELA HOME");
    	CarrinhoCompras.continuarComprandoTelaHome(driver);
    }
    
    @Test
    public void continuarComprandoDescricao() {
    	Log.line();
    	Log.registrar("CONTINUAR COMPANDO DESCRIÇÃO");
    	CarrinhoCompras.continuarComprandoDetalhes(driver);
    }
    
    @Test
    public void removendoCarrinho() {
    	Log.line();
    	Log.registrar("CONTINUAR COMPANDO");
    	CarrinhoCompras.removendoPeloCarrinho(driver, 3, 8);
    }
}
	