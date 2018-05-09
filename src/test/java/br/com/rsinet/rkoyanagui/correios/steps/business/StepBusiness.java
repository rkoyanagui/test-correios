package br.com.rsinet.rkoyanagui.correios.steps.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import io.openbdt.element.WebBrowserScreenElement;
import br.com.rsinet.rkoyanagui.correios.pages.PageObjectClass;
import jxl.common.Logger;
import net.serenitybdd.core.annotations.findby.By;

@ContextConfiguration("/context.xml")
public class StepBusiness {

	PageObjectClass page;
	
	Logger LOG = Logger.getLogger(StepBusiness.class);
	
	@Autowired
	private WebBrowserScreenElement viewElement; // OBJETO QUE CONTÉM MÉTODOS PRÓPRIOS DO FRAMEWORK

	public void openHome(String url) {
		viewElement.open(url);
		
		viewElement.getDriver().manage().window().maximize();
	}

	public void validarTelaDeBuscaCepEndereco() {
		viewElement.waitForElementIsPresent(20, page.getTituloCaixaBuscaCepEndereco());
		LOG.info(">> " + page.getTituloCaixaBuscaCepEndereco().getText());
		Assert.assertEquals("Busca CEP ou Endereço", page.getTituloCaixaBuscaCepEndereco().getText());
	}

	public void preencherCepOuEndereco(String cep_ou_endereco) {
		viewElement.sendText(page.getCampoConsultaCepEndereco(), cep_ou_endereco);
	}

	public void clicarBotaoConsultar() {
		viewElement.clickAndWait(page.getBotaoConsultaCepEndereco(),20);
	}

	public void validarTelaResultado(String arg1) {
		WebDriver driver = page.getDriver();
		List<String> abas = new ArrayList<String>();
		abas.addAll(driver.getWindowHandles());
		driver.switchTo().window(abas.get(1));
		viewElement.waitForElementIsPresent(20, page.getTituloBuscaResultado());
		LOG.info(">> " + page.getTituloBuscaResultado().getText());
		Assert.assertEquals(arg1, page.getTituloBuscaResultado().getText());
	}

	public void validarTelaDePrecosEPrazos() {
		viewElement.waitForElementIsPresent(20, page.getTituloPrecosEPrazos());
		LOG.info(">> " + page.getTituloPrecosEPrazos().getText());
		Assert.assertEquals("Preços e Prazos", page.getTituloPrecosEPrazos().getText());
	}
	
	public void abrirMenuDropDownProdutoOuServico() {
		viewElement.mouseOver(page.getMenuDropDownProdutoOuServico());
	}
	
	public void clicarItemMenuProdutoOuServico(String item) {
		viewElement.clickAndWait(page.getItemMenuProdutoOuServico(item), 20);
	}
	
	public void validarTelaCalculoPrecosPrazos() {
		viewElement.waitForElementIsPresent(20, page.getTituloTelaCalculoPrecosPrazos());
		LOG.info(">> " + page.getTituloTelaCalculoPrecosPrazos().getText());
		Assert.assertEquals("Cálculo de preços e prazos de entrega", page.getTituloTelaCalculoPrecosPrazos().getText());
	}
	
	public void preencherCepOrigem(String cepOrigem) {
		viewElement.sendText(page.getCepOrigem(), cepOrigem);
	}
	
	public void preencherCepDestino(String cepDestino) {
		viewElement.sendText(page.getCepDestino(), cepDestino);
	}
	
	public void selecionarTipoServico(String tipoServico) {
		viewElement.selectByVisibleText(page.getTipoServico(), tipoServico);
	}
	
	public void clicarBotaoEnviar() {
		viewElement.clickAndWait(page.getBtnEnviar(), 20);
	}
	
	public void validarTelaResultadoCalculoPrecosPrazos(String arg1) {
		WebDriver driver = page.getDriver();
		List<String> abas = new ArrayList<String>();
		abas.addAll(driver.getWindowHandles());
		driver.switchTo().window(abas.get(1));
		viewElement.waitForElementIsPresent(20, page.getTituloResultadoPrecosPrazos());
		LOG.info(">> " + page.getTituloResultadoPrecosPrazos().getText());
		Assert.assertEquals(arg1, page.getTituloResultadoPrecosPrazos().getText());
	}
	
	public void clicarBotaoBuscarAgencia() {
		viewElement.clickAndWait(page.getBtnBuscarAgencia(), 20);
	}
	
	public void validarTelaBuscaAgencia() {
		viewElement.waitForElementIsPresent(20, page.getTituloTelaBuscaAgencia());
		LOG.info(">> " + page.getTituloTelaBuscaAgencia().getText());
		Assert.assertEquals("Agências", page.getTituloTelaBuscaAgencia().getText());
	}
	
	public void selecionarBuscarAgenciaPor(String por) {
		//viewElement.clickAndWait(page.getBuscarAgenciaPor(por), 5);
		viewElement.clickAndWait(page.getBuscarAgenciaPor(por), 5);
	}
	
	public void preencherEstado(String estado) {
		viewElement.selectByVisibleText(page.getEstado(), estado);
	}
	
	public void preencherMunicipio(String municipio) throws InterruptedException {
		viewElement.wait(10);
		viewElement.selectByVisibleText(page.getMunicipio(), municipio);
	}
	
	public void validarTelaResultadoBuscaAgencia(String arg1) {
		viewElement.waitForElementIsPresent(20, page.getResultadoBuscaAgencia());
		LOG.info(">> " + page.getResultadoBuscaAgencia().getText());
		Assert.assertEquals(arg1, page.getResultadoBuscaAgencia().getText());
	}
}
