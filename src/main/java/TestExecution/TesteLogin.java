package TestExecution;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import Base.Log;
import Base.NavegadorUtilizado;
import Utils.TelaLogin;

public class TesteLogin {
    private static WebDriver driver;

    // Informações de login
    public static String login = "standard_user";
    public static String loginBlock = "locked_out_user";
    public static String senha = "secret_sauce";
    public static String url = "https://www.saucedemo.com/v1/index.html";
    public static String urlEsperada = "https://www.saucedemo.com/v1/inventory.html";

    @BeforeAll
    public static void preparacaoAmbiente() {
        Log.criarArquivoLog("Log.teste_Login");
    }

    @BeforeEach
    public void inicialização() {
        driver = NavegadorUtilizado.setaNavegadorUtilizado("FIREFOX");
        NavegadorUtilizado.maxmize();
        driver.get(url);
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
    public void fazerLogin() {
    	Log.nomeTeste("LOGIN");
    	
        TelaLogin.fazerlogin(driver, login, senha);
        TelaLogin.validarLogin(driver, urlEsperada);
        
    }

    @Test
    public void fazerLoginBloqueado() {
    	Log.nomeTeste("LOGIN COM BLOQUEIO");
    	
        TelaLogin.fazerlogin(driver, loginBlock, senha);
        TelaLogin.validarLogin(driver, urlEsperada);
   
    }

    @Test
    public void fazerLoginSemUser() {
    	Log.nomeTeste("LOGIN SEM USUÁRIO");
    	
        TelaLogin.loginSemUser(driver, senha);
        TelaLogin.validarLogin(driver, urlEsperada);
      
    }

    @Test
    public void fazerLoginSemSenha() {
    	Log.nomeTeste("LOGIN SEM SENHA");
    	
        TelaLogin.loginSemSenha(driver, login);
        TelaLogin.validarLogin(driver, urlEsperada);
       
    }

    @Test
    public void fazerLogout() {
    	Log.nomeTeste("LOGOUT");

    	TelaLogin.fazerlogin(driver, login, senha);
    	TelaLogin.logout(driver);
    	TelaLogin.validarLogout(driver, url);
    	
    	
    }

    
}
