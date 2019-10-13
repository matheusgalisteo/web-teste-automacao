package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BrowserFactory;

/**
 * 
 * @author matheus.galisteo
 *
 */

public class HomePage extends BrowserFactory {

	private void esperaPorElemento(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void click(By by) throws NoSuchElementException {
		try {
			esperaPorElemento(by);
			driver.findElement(by).click();
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado: " + e.getMessage());
		}
	}

	public void escreve(By by, String text) {
		try {
			esperaPorElemento(by);
			driver.findElement(by).sendKeys(text);
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado: " + e.getMessage());
		}
	}

	public String getValue(By by) throws NoSuchElementException {
		try {
			esperaPorElemento(by);
			return driver.findElement(by).getText();
		} catch (Exception e) {
			throw new NoSuchElementException("Element not found: " + e.getMessage());
		}
	}
	public boolean elementoExistente(By by) throws NoSuchElementException {
		try {
			esperaPorElemento(by);
			List<WebElement> elementos = driver.findElements(by);
			return elementos.size() > 0;
		} catch (Exception e) {
			throw new NoSuchElementException("Element not found: " + e.getMessage());
		}
	}

	public void sairFrame() {
		driver.switchTo().defaultContent();
	}

	public void switchTo(int value) {
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[value]);
	}

	public void preencheDados(String aplicar, String investir, String tempo) {
		switchTo(0);
		escreve(By.id("valorAplicar"), aplicar);
		escreve(By.id("valorInvestir"), investir);
		escreve(By.id("tempo"), tempo);
		click(By.xpath("//button[@class='btn btnAmarelo btnSimular']"));
	}
	public void clicaBotaoSimular() {
		click(By.xpath("//button[@class='btn btnAmarelo btnSimular']"));
	}
	
}
