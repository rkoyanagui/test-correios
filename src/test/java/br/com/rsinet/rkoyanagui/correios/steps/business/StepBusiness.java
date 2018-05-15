package br.com.rsinet.rkoyanagui.correios.steps.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import io.openbdt.element.WebBrowserScreenElement;
import jline.internal.Log;
import br.com.rsinet.rkoyanagui.correios.pages.PageObjectClass;
import jxl.common.Logger;
import net.serenitybdd.core.annotations.findby.By;

@ContextConfiguration("/context.xml")
public class StepBusiness {

	PageObjectClass page;
	
	Logger LOG = Logger.getLogger(StepBusiness.class);
	
	WebDriver driver;
	List<String> abas = new ArrayList<String>();
	String cep;
	
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
		viewElement.clickAndWait(page.getBuscarAgenciaPor(por), 5);
	}
	
	public void preencherEstado(String estado) {
		viewElement.selectByVisibleText(page.getEstado(), estado);
	}
	
	public void preencherMunicipio(String municipio) throws InterruptedException {
		Thread.sleep(10000);
		//viewElement.waitForElementIsPresent(10, page.getMunicipio(municipio));
		//viewElement.clickAndWait(page.getMunicipio(municipio), 5);
		viewElement.selectByVisibleText(page.getMunicipio(), municipio);
	}
	
	public void validarTelaResultadoBuscaAgencia(String nomeAgencia) {
		viewElement.waitForElementIsPresent(20, page.getResultadoBuscaAgencia(nomeAgencia));
		LOG.info(">> " + page.getResultadoBuscaAgencia().getText());
		//Assert.assertEquals("(([^\"]*)(" + nomeAgencia + ")([^\"]*))",
		//		page.getResultadoBuscaAgencia(nomeAgencia).getText());
		Assert.assertTrue(Pattern.matches(
				"(([^\"]*)(" + nomeAgencia + ")([^\"]*))",
				page.getResultadoBuscaAgencia(nomeAgencia).getText()));
	}
	
	public void clicarBotao(String botao) {
		viewElement.click(page.getBotao(botao));
	}
	
	public void salvarContextoWindow() {
		driver = page.getDriver();
		abas.addAll(driver.getWindowHandles());
	}
	
	public void mudarContextoParaFrame(String ancestorId) {
		viewElement.waitForElementIsPresent(10, page.getFrame(ancestorId));
		page.switchToFrame(page.getFrame(ancestorId));
	}
	
	public void validarTitulo(String titulo) {
		viewElement.waitForElementIsPresent(10, page.getHeader(titulo));
		LOG.info(">> " + page.getHeader(titulo).getText());
		Assert.assertEquals(titulo, page.getHeader(titulo).getText());
	}
	
	public void preencherValor(String nomeFormulario, String nomeCampo, String valor) {
		viewElement.waitForElementIsPresent(10, page.getInput(nomeFormulario, nomeCampo));
		viewElement.sendText(page.getInput(nomeFormulario, nomeCampo), valor);
	}
	
	public void clicarInput(String id_de_busca) {
		viewElement.click(page.getInputSubmit(id_de_busca));
	}
	
	public void validarTexto(String texto) {
		viewElement.waitForElementIsPresent(10, page.getText(texto));
		Assert.assertEquals(texto, page.getText(texto).getText());
	}
	
	private List<WebElement> encontrarNaTabelaTodasLinhasContendo(String text)
	{
		return viewElement.findElements(By.xpath(
				"//table/tbody//*[contains(text(), \"" + text + "\")]/ancestor::tr"));
	}
	
	public void encontrarCepNaTabelaPorBairro(
			String logradouro, String cidadeUF, String bairro)
	{
		List<WebElement> listaLinhas = this.encontrarNaTabelaTodasLinhasContendo(logradouro);
		List<String> listaOriginal = new ArrayList<String>();
		
		Log.info("BAIRRO: " + bairro);
		
		//Regex para buscar por bairro.
		Pattern patternBairro = Pattern.compile(
						"(" + logradouro + "\\t)(" + bairro + ")(\\t" + cidadeUF + " )(\\d\\d\\d\\d\\d-\\d\\d\\d)", Pattern.UNICODE_CHARACTER_CLASS);
		
		//Loop para adicionar o texto das linhas (WebElement) em listaTextoOriginal,
		//passando somente as linhas que contêm cidadeUF.
		for (WebElement linha : listaLinhas)
		{
			String textoDaLinha = linha.getText();
			if (textoDaLinha.contains(cidadeUF))
			{
				textoDaLinha = textoDaLinha.replaceAll("\\s", " ");
				textoDaLinha = textoDaLinha.replaceAll("  ", "\t");
				listaOriginal.add(textoDaLinha);
			}
		}
		
		if (bairro != "")
		{
			Log.info("-----------------matcherBairro-----------------");
			Iterator<String> it = listaOriginal.iterator();
			String bairroAvaliado = "";
			cep = "";
			while (it.hasNext() && !bairro.equals(bairroAvaliado))
			{
				String linhaInteira = it.next();
				Log.info(linhaInteira);
				Matcher matcher = patternBairro.matcher(linhaInteira);
				if (matcher.matches())
				{
					bairroAvaliado = matcher.group(2);
					cep = matcher.group(4);
					Log.info("BAIRROOOOOOOOOOO: " + bairroAvaliado + "\t" + cep);
				}
				matcher.reset();
			}
			if (!bairro.equals(bairroAvaliado))
			{
				Log.info("O bairro " + bairro + " não foi encontrado.");
				Assert.assertTrue(false);
			} else
			{
				Log.info("Bairro procurado: " + bairro + "\tCEP encontrado: " + cep);
				Assert.assertTrue(true);
			}
		} else
		{
			Log.info("O parâmetro de busca por 'bairro' não pode ser vazio. Preencha-o "
					+ "ou use o parâmetro de busca por 'número do endereço'.");
			Assert.assertTrue(false);
		}
	}
	
	public void encontrarCepNaTabelaPorNumero(
			String logradouro, String cidadeUF, String numero)
	{
		List<WebElement> listaLinhas = this.encontrarNaTabelaTodasLinhasContendo(logradouro);
		List<String> listaOriginal = new ArrayList<String>();
		Integer numeroInteiroProcurado = Integer.parseInt(numero);
		
		//Regex para logradouro seguido de vírgula e um e somente um número
		//de endereço (grandes clientes dos Correios, tendo um CEP só deles).
		Pattern patternGrandesClientes = Pattern.compile(
						"(" + logradouro + ", )(\\d+)(\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t" + cidadeUF + " )(\\d\\d\\d\\d\\d-\\d\\d\\d)", Pattern.UNICODE_CHARACTER_CLASS);
		
		//Regex para um intervalo de número "até N" do lado ímpar.
		Pattern patternIntervaloNumericoAteLadoImpar = Pattern.compile(
						"(" + logradouro + " - )(até )(\\d+)( - lado ímpar)(\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t" + cidadeUF + " )(\\d\\d\\d\\d\\d-\\d\\d\\d)", Pattern.UNICODE_CHARACTER_CLASS);
		
		//Regex para um intervalo de número "até N" do lado par.
		Pattern patternIntervaloNumericoAteLadoPar = Pattern.compile(
				"(" + logradouro + " - )(até )(\\d+)( - lado par)(\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t" + cidadeUF + " )(\\d\\d\\d\\d\\d-\\d\\d\\d)", Pattern.UNICODE_CHARACTER_CLASS);
		
		//Loop para adicionar o texto das linhas (WebElement) em listaTextoOriginal,
		//passando somente as linhas que contêm cidadeUF.
		for (WebElement linha : listaLinhas)
		{
			String textoDaLinha = linha.getText();
			if (textoDaLinha.contains(cidadeUF))
			{
				textoDaLinha = textoDaLinha.replaceAll("\\s", " ");
				textoDaLinha = textoDaLinha.replaceAll("  ", "\t");
				listaOriginal.add(textoDaLinha);
			}
		}
		
		Log.info("-----------------matcherCompleto-----------------");
		Iterator<String> it = listaOriginal.iterator();
		String numeroAvaliado = "";
		cep = "";
		boolean numeroEncontrado = false;
		while (it.hasNext() && !numeroEncontrado)
		{
			String linhaInteira = it.next();
			Log.info(linhaInteira);
			//GrandesClientes
			Matcher matcher = patternGrandesClientes.matcher(linhaInteira);
			if (matcher.matches())
			{
				numeroAvaliado = matcher.group(2);
				cep = matcher.group(4);
				Log.info("MATCHGrandesClientes: " + numeroAvaliado + "\tCEP: " + cep);
				matcher.reset();
				if (numero.equals(numeroAvaliado)) { numeroEncontrado = true; }
			} else 
			{
				//NumeroAteLadoImpar
				matcher = patternIntervaloNumericoAteLadoImpar.matcher(linhaInteira);
				if (matcher.matches())
				{
					numeroAvaliado = matcher.group(3);
					cep = matcher.group(6);
					Log.info("MATCHAteNumeroImpar: até " + numeroAvaliado + "\tCEP: " + cep);
					matcher.reset();
					if (1 <= numeroInteiroProcurado &&
							numeroInteiroProcurado <= Integer.parseInt(numeroAvaliado))
					{
						numeroEncontrado = true;
					}
				} else
				{
					//NumeroAteLadoPar
					matcher = patternIntervaloNumericoAteLadoPar.matcher(linhaInteira);
					if (matcher.matches())
					{
						numeroAvaliado = matcher.group(3);
						cep = matcher.group(6);
						Log.info("MATCHAteNumeroImpar: até " + numeroAvaliado + "\tCEP: " + cep);
						matcher.reset();
						if (1 <= numeroInteiroProcurado &&
								numeroInteiroProcurado <= Integer.parseInt(numeroAvaliado))
						{
							numeroEncontrado = true;
						}
					}
				}
			}
		} //Fim do while
		
		if (!numeroEncontrado)
		{
			Log.info("O número " + numero + " não foi encontrado.");
			Assert.assertTrue(false);
		} else
		{
			Log.info("Número procurado: " + numero + "\tCEP encontrado: " + cep);
			Assert.assertTrue(true);
		}
		
	}

	public void retornarTelaPrincipal() {
		driver.switchTo().defaultContent();
	}
}
