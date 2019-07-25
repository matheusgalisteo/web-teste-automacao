package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author matheus.galisteo
 *
 */

public class BrowserFactory {
	protected static WebDriver driver;
	private static final String url = "https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/";
	
	@BeforeMethod
	public void Browser(String browser) {
			browser.equalsIgnoreCase("chrome");
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		try {
			driver.get(url);
		} catch (TimeoutException e) {
			System.out.println("Falha ao carregar a p�gina!");
			e.printStackTrace();
		}
	}

	@AfterMethod
	public static void fechaNavegador() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
