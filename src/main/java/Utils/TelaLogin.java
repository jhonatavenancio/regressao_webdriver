package Utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import Base.Actions;
import Base.Log;


public class TelaLogin {
	

	public static void fazerlogin(WebDriver driver, String login, String senha ) {
		Actions.escreverPegandoPeloId(driver, "user-name", login);
		Log.registrar("Adicionando usuário");
		
		Actions.escreverPegandoPeloId(driver, "password", senha);
		Log.registrar("Adicionando senha");
		
		Actions.clicarBotaoPegandoPeloId(driver, "login-button");
		Log.registrar("Acessando");
	}

	public static void loginSemSenha(WebDriver driver, String login) {
		Actions.escreverPegandoPeloId(driver, "user-name", login);
		Log.registrar("Adicionando usuário");
		Actions.clicarBotaoPegandoPeloId(driver, "login-button");
		Log.registrar("Acessando sem senha");
	}

	public static void loginSemUser(WebDriver driver, String senha) {
		Actions.escreverPegandoPeloId(driver, "password", senha);
		Log.registrar("Adicionando senha");
		Actions.clicarBotaoPegandoPeloId(driver, "login-button");
		Log.registrar("Acessando sem usuário");
	}
	
	public static void logout(WebDriver driver) {
		Actions.esperarSegundos(3000);
		Log.registrar("Aguardando");
		
		Actions.clicarBotaoPegandoPeloCss(driver, ".bm-burger-button > button");
		Log.registrar("Selecionando botão 'Mais opções' ");
		
		Actions.clicarBotaoPegandoPeloId(driver, "logout_sidebar_link");
		Log.registrar("Realizando Logout");
	}
	
	
	public static void validarLogin(WebDriver driver, String urlEsperada) {
	    try {
	        if (!driver.getCurrentUrl().equals(urlEsperada)) {
	        	Log.registrar("Login efetuado conforme o esperado - OK");
	           
	            if (Actions.pegarElementoPeloCss(driver, "*[data-test=\"error\"]").isDisplayed()) {
	                Log.registrar("O login não foi efetuado. Mensagem de erro está sendo exibida. - OK");
	                
	            } else {
	                Assert.fail("O login não foi efetuado e a mensagem de erro não está sendo exibida.");
	                Log.registrar("O login não foi efetuado e a mensagem de erro não está sendo exibida.");
	            }
	        }
	    } catch (Exception e) {
	        Log.registrar("Erro ao validar o login: " + e.getMessage());
	        Assert.fail("Erro ao validar o login");
	    }
	}

	
	public static void validarLogout(WebDriver driver, String url) {
	    try {
	        boolean logoutRealizado = driver.getCurrentUrl().equals(url);
	        if (logoutRealizado) {
	            Log.registrar("Logou realizado conforme o esperado - OK");
	        } else {
	            Log.registrar("Problema ao realizar o logout");
	        }
	    } catch (Exception e) {
	        Log.registrar("Erro ao validar logout: " + e.getMessage());
	    
	    }
	}	
}
