package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class NavegadorUtilizado {

	private static WebDriver driver;
	private static ChromeOptions optionsChrome;
	private static EdgeOptions optionsEdge;
	private static FirefoxOptions optionsFirefox;
	private static FirefoxProfile profileFirefox;

	
	// Define em qual navegador deve ser utilizado nos testes
	// caso não tenha definido, será executado o Chorme
	
	
	public static WebDriver setaNavegadorUtilizado(String navegadorDesejado) {
		if (navegadorDesejado.equalsIgnoreCase("FIREFOX")) {
			profileFirefox = new FirefoxProfile();
			profileFirefox.setPreference("layout.css.devPixelsPerPx", "1.35");

			optionsFirefox = new FirefoxOptions();
			optionsFirefox.setProfile(profileFirefox);

			driver = new FirefoxDriver(optionsFirefox);

		} else if (navegadorDesejado.equalsIgnoreCase("EDGE")) {
			optionsEdge = new EdgeOptions();
			optionsEdge.addArguments("force-device-scale-factor=1.35");

			driver = new EdgeDriver(optionsEdge);
		} else {
			optionsChrome = new ChromeOptions();
			optionsChrome.addArguments("force-device-scale-factor=1.35");

			driver = new ChromeDriver(optionsChrome);
		}

		return driver;
	}
	
	public static void maxmize(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}

	public static void minimize(){
        driver.manage().window().minimize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}

}
