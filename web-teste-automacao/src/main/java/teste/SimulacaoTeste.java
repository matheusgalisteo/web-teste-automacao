package teste;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.BrowserFactory;
import page.HomePage;

public class SimulacaoTeste extends BrowserFactory{
	private HomePage simulacao = new HomePage();
	
	@Test
	public void simulacao(){
		simulacao.preencheDados("50000", "10000", "12");
		Boolean botao = simulacao.elementoExistente(By.xpath("//a[@class='btn btnAmarelo btnRefazer']"));
		Assert.assertTrue(botao);
	}
	
	@Test
	public void validaPrimeiroCampo() {
		simulacao.clicaBotaoSimular();
		assertEquals("Valor mínimo de 20.00", simulacao.getValue(By.id("valorAplicar-error")));
	}

	@Test
	public void validaSegundoCampo() {
		simulacao.clicaBotaoSimular();
		assertEquals("Valor mínimo de 20.00", simulacao.getValue(By.id("valorInvestir-error")));
	}

	@Test
	public void validaTerceiroCampo() {
		simulacao.clicaBotaoSimular();
		assertEquals("Obrigatório", simulacao.getValue(By.id("tempo-error")));
	}
	
	
}
