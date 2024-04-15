package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Actions {

	//================================ CSS ====================================//

	public static WebElement pegarElementoPeloCss(WebDriver driver, String css) {
		return driver.findElement(By.cssSelector(css));
	}

	public static void clicarBotaoPegandoPeloCss(WebDriver driver, String css) {
		driver.findElement(By.cssSelector(css)).click();
	}

	public static void escreverPegandoPeloCss(WebDriver driver, String css, String texto) {
		driver.findElement(By.cssSelector(css)).sendKeys(texto);
	}
	
	public static void lerTextoPegandoPeliCss(WebDriver driver, String css) {
		driver.findElement(By.cssSelector(css)).getText();
	}

	//================================ CLASSE ====================================//

	public static WebElement pegarElementoPelaClasse(WebDriver driver, String classe) {
		return driver.findElement(By.className(classe));
	}

	public static void clicarBotaoPegandoPelaClasse(WebDriver driver, String classe) {
		driver.findElement(By.className(classe)).click();
	}

	public static void escreverPegandoPelaClasse(WebDriver driver, String classe, String texto) {
		driver.findElement(By.className(classe)).sendKeys(texto);
	}

	//================================ ID ====================================//

	public static WebElement pegarElementoPeloId(WebDriver driver, String id) {
		return driver.findElement(By.id(id));
	}

	public static void clicarBotaoPegandoPeloId(WebDriver driver, String id) {
		driver.findElement(By.id(id)).click();
	}

	public static void escreverPegandoPeloId(WebDriver driver, String id, String texto) {
		driver.findElement(By.id(id)).sendKeys(texto);
	}

	//================================ XPATH ====================================//

	public static WebElement pegarElementoPeloXpath(WebDriver driver, String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public static void clicarBotaoPegandoPeloXpath(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void escreverPegandoPeloXpath(WebDriver driver, String xpath, String texto) {
		driver.findElement(By.xpath(xpath)).sendKeys(texto);
	}

	//================================ CSS ====================================//

	public static WebElement pegarElementoPeloNome(WebDriver driver, String nome) {
		return driver.findElement(By.name(nome));
	}

	public static void clicarBotaoPegandoPeloNome(WebDriver driver, String nome) {
		driver.findElement(By.name(nome)).click();
	}

	public static void escreverPegandoPeloNome(WebDriver driver, String nome, String texto) {
		driver.findElement(By.name(nome)).sendKeys(texto);
	}

	//================================ TEXTO ====================================//

	public static WebElement pegarElementoPeloTexto(WebDriver driver, String texto) {
		return driver.findElement(By.linkText(texto));
	}

	public static void clicarBotaoPegandoPeloTexto(WebDriver driver, String texto) {
		driver.findElement(By.linkText(texto)).click();
	}

	public static void escreverPegandoPeloTexto(WebDriver driver, String texto, String textoEscrito) {
		driver.findElement(By.linkText(texto)).sendKeys(textoEscrito);
	}
	
	/********************************************** OUTROS ************************************************/
	

	//================================ ESPERA ====================================//

	public static void esperarSegundos(int tempoEspera) {
		try {
			Thread.sleep(tempoEspera);
		} catch (InterruptedException e) {

		}
	}
	
	//================================ RECARREGAR PAGINA ====================================//
	
public static void recarregarPagina(WebDriver driver) {
	driver.navigate().refresh();
	}
}
