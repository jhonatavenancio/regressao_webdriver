package Utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.Actions;
import Base.Log;

public class Checkout {

	
	public static void checkout(WebDriver driver, String primeiroNome, String ultimoNome, String cartaoPostal) {
		Actions.clicarBotaoPegandoPeloCss(driver, "path");
		Log.registrar("Ir para o carrinho");
		
		Actions.clicarBotaoPegandoPeloTexto(driver, "CHECKOUT");
		Log.registrar("Acessar CHECK-OUT");
		
		Actions.escreverPegandoPeloCss(driver, "*[data-test=\"firstName\"]", primeiroNome);
		Log.registrar("Preencher primeiro nome");
		
		Actions.escreverPegandoPeloCss(driver, "*[data-test=\"lastName\"]", ultimoNome);
		Log.registrar("Preencher ultimo nome");
		
		Actions.escreverPegandoPeloCss(driver, "*[data-test=\"postalCode\"]", cartaoPostal);
		Log.registrar("Preencher cartão postal");
		
		Actions.clicarBotaoPegandoPeloCss(driver, ".btn_primary");
		Log.registrar("Concluir");
		

	}
	
	public static void confirmarPedido(WebDriver driver) {
		
	    WebElement valorAtual = driver.findElement(By.cssSelector(".summary_value_label:nth-child(2)"));
		validarTexto(driver, "SauceCard #31337", valorAtual);
		
		Actions.clicarBotaoPegandoPeloTexto(driver, "FINISH");
		
	}
	
	public static void validarTexto(WebDriver driver, String valorEsperado, WebElement valorAtual) {
	    String textoEsperado = valorAtual.getText();

	    if (textoEsperado.equals(valorEsperado)) {
	        Log.registrar("Valor do pagamento conforme o esperado: " + textoEsperado);
	    } else {
	        String falha = "Problema com valor do pagamento - " + textoEsperado;
	        Log.registrar(falha);
	        Assert.fail(falha);
	    }
	}

    }
	


