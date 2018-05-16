package br.com.rsinet.rkoyanagui.correios.steps.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import io.openbdt.api.ViewElement;
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
	String urlPaginaInicial;
	
	@Autowired
	private WebBrowserScreenElement viewElement; // OBJETO QUE CONTÉM MÉTODOS PRÓPRIOS DO FRAMEWORK

	public void openHome(String url) {
		urlPaginaInicial = url;
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
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement menu = wait.until(ExpectedConditions.visibilityOf(page.getMenuDropDownProdutoOuServico()));
		//menu.click();
		viewElement.waitForElementIsPresent(10, page.getMenuDropDownProdutoOuServico());
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
		viewElement.waitForElementIsPresent(10, page.getCepOrigem());
		viewElement.sendText(page.getCepOrigem(), cepOrigem);
	}
	
	public void preencherCepEncontradoOrigem()
	{
		this.preencherCepOrigem(cep);
	}
	
	public void preencherCepDestino(String cepDestino) {
		viewElement.waitForElementIsPresent(10, page.getCepDestino());
		viewElement.sendText(page.getCepDestino(), cepDestino);
	}
	
	public void preencherCepEncontradoDestino()
	{
		this.preencherCepDestino(cep);
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
		try {
			viewElement.wait(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	
	public void mudarContextoParaFrame(String src) {
		//viewElement.waitForElementIsPresent(10, page.getFrame(ancestorId));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement frame = wait.until(ExpectedConditions.visibilityOf(page.getFrameBySrc(src)));
		try {
		page.switchToFrame(frame);
		} catch (NoSuchFrameException | StaleElementReferenceException ex) {
			Log.info(ex.getMessage());
		}
	}
	
	public void validarTitulo(String titulo) {
		//viewElement.waitForElementIsPresent(10, page.getHeader(titulo));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement header = wait.until(ExpectedConditions.visibilityOf(page.getHeader(titulo)));
		LOG.info(">> " + header.getText());
		Assert.assertEquals(titulo, header.getText());
	}
	
	public void preencherValor(String nomeFormulario, String nomeCampo, String valor) {
		//viewElement.waitForElementIsPresent(10, page.getInput(nomeFormulario, nomeCampo));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement input = wait.until(ExpectedConditions.elementToBeClickable(page.getInput(nomeFormulario, nomeCampo)));
		viewElement.sendText(input, valor);
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
			String logradouro, String cidadeUF, String numero, boolean flagDoisLados)
			throws NumberFormatException
	{
		List<WebElement> listaLinhas = this.encontrarNaTabelaTodasLinhasContendo(logradouro);
		List<String> listaIntervaloNumero = new ArrayList<String>();
		List<String> listaGrandesClientes = new ArrayList<String>();
		int numeroProcurado = Integer.parseInt(numero);
		if (numeroProcurado <= 0) {
			throw new NumberFormatException(
					"\"Erro: o método 'void StepBusiness.encontrarCepNaTabelaPorNumero(String logradouro, String cidadeUF, String numero, boolean flagDoisLados)'"
					+ " aceita somente um número inteiro maior que zero.");
		}
		
		//Regex para logradouro seguido de vírgula e um e somente um número
		//de endereço (grandes clientes dos Correios, tendo um CEP só deles).
		Pattern patternGrandesClientes = Pattern.compile(
				"(" + logradouro + ", )(?<numeroAvaliado>\\d+)(\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t" + cidadeUF + " )(?<cep>\\d\\d\\d\\d\\d-\\d\\d\\d)", Pattern.UNICODE_CHARACTER_CLASS);
		
		//Regex para um intervalo de número "até N" do lado ímpar.
		Pattern patternNumeroAteLadoImpar = Pattern.compile(
				"(" + logradouro + " - )(até )(?<numeroAvaliado>\\d+)( - lado ímpar)(\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t" + cidadeUF + " )(?<cep>\\d\\d\\d\\d\\d-\\d\\d\\d)", Pattern.UNICODE_CHARACTER_CLASS);
		
		//Regex para um intervalo de número "até N" do lado par.
		Pattern patternNumeroAteLadoPar = Pattern.compile(
				"(" + logradouro + " - )(até )(?<numeroAvaliado>\\d+)( - lado par)(\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t" + cidadeUF + " )(?<cep>\\d\\d\\d\\d\\d-\\d\\d\\d)", Pattern.UNICODE_CHARACTER_CLASS);
		
		//Regex para um intervalo de número "até N1/N2" de ambos os lados par e ímpar.
		Pattern patternNumeroAteDoisLados = Pattern.compile(
				"(" + logradouro + " - )(até )(?<numeroAvaliado1>\\d+)(/)(?<numeroAvaliado2>\\d+)(\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t" + cidadeUF + " )(?<cep>\\d\\d\\d\\d\\d-\\d\\d\\d)", Pattern.UNICODE_CHARACTER_CLASS);
		
		//Regex para um intervalo de número "de N a M" do lado ímpar.
		Pattern patternNumeroDeLadoImpar = Pattern.compile(
				"(" + logradouro + " - )(de )(?<numeroAvaliadoDe>\\d+)( a )(?<numeroAvaliadoA>\\d+)( - lado ímpar)(\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t" + cidadeUF + " )(?<cep>\\d\\d\\d\\d\\d-\\d\\d\\d)", Pattern.UNICODE_CHARACTER_CLASS);
		
		//Regex para um intervalo de número "de N a M" do lado par.
		Pattern patternNumeroDeLadoPar = Pattern.compile(
				"(" + logradouro + " - )(de )(?<numeroAvaliadoDe>\\d+)( a )(?<numeroAvaliadoA>\\d+)( - lado par)(\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t" + cidadeUF + " )(?<cep>\\d\\d\\d\\d\\d-\\d\\d\\d)", Pattern.UNICODE_CHARACTER_CLASS);
		
		//Regex para um intervalo de número "de N1/N2 a M1/M2" de ambos os lados par e ímpar.
		Pattern patternNumeroDeDoisLados = Pattern.compile(
				"(" + logradouro + " - )(de )(?<numeroAvaliadoDe1>\\d+)(/)(?<numeroAvaliadoDe2>\\d+)( a )(?<numeroAvaliadoA1>\\d+)(/)(?<numeroAvaliadoA2>\\d+)(\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t" + cidadeUF + " )(?<cep>\\d\\d\\d\\d\\d-\\d\\d\\d)", Pattern.UNICODE_CHARACTER_CLASS);
		
		//Regex para um intervalo de número "de N ao fim" do lado ímpar.
		Pattern patternNumeroDeAoFimLadoImpar = Pattern.compile(
				"(" + logradouro + " - )(de )(?<numeroAvaliado>\\d+)( ao fim)( - lado ímpar)(\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t" + cidadeUF + " )(?<cep>\\d\\d\\d\\d\\d-\\d\\d\\d)", Pattern.UNICODE_CHARACTER_CLASS);
		
		//Regex para um intervalo de número "de N ao fim" do lado par.
		Pattern patternNumeroDeAoFimLadoPar = Pattern.compile(
				"(" + logradouro + " - )(de )(?<numeroAvaliado>\\d+)( ao fim)( - lado par)(\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t" + cidadeUF + " )(?<cep>\\d\\d\\d\\d\\d-\\d\\d\\d)", Pattern.UNICODE_CHARACTER_CLASS);
		
		//Regex para um intervalo de número "de N1/N2 ao fim" de ambos os lados par e ímpar.
		Pattern patternNumeroDeAoFimDoisLados = Pattern.compile(
				"(" + logradouro + " - )(de )(?<numeroAvaliado1>\\d+)(/)(?<numeroAvaliado2>\\d+)( ao fim)(\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t" + cidadeUF + " )(?<cep>\\d\\d\\d\\d\\d-\\d\\d\\d)", Pattern.UNICODE_CHARACTER_CLASS);
		
		//Regex para um intervalo sem número, isto é, o CEP pertence ao logradouro inteiro, exceto os Grandes Clientes.
		Pattern patternSemNumero = Pattern.compile(
				"(" + logradouro + ")(\\t[\\w[ \\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]]+\\t" + cidadeUF + " )(?<cep>\\d\\d\\d\\d\\d-\\d\\d\\d)", Pattern.UNICODE_CHARACTER_CLASS);
		
		//Loop para adicionar o texto das linhas em listas de String,
		//separando entre Grandes Clientes e o resto,
		//e adicionando somente as linhas que contêm cidadeUF.
		for (WebElement linha : listaLinhas)
		{
			String textoDaLinha = linha.getText();
			if (textoDaLinha.contains(cidadeUF))
			{
				textoDaLinha = textoDaLinha.replaceAll("\\s", " ");
				textoDaLinha = textoDaLinha.replaceAll("  ", "\t");
				if (textoDaLinha.contains(logradouro + ", "))
				{
					listaGrandesClientes.add(textoDaLinha);
				} else
				{
					listaIntervaloNumero.add(textoDaLinha);
				}
			}
		}
		
		int numeroAvaliado = 0;
		int numeroAvaliado1 = 0;
		int numeroAvaliado2 = 0;
		int numeroAvaliadoDe = 0;
		int numeroAvaliadoA = 0;
		int numeroAvaliadoDe1 = 0;
		int numeroAvaliadoDe2 = 0;
		int numeroAvaliadoA1 = 0;
		int numeroAvaliadoA2 = 0;
		cep = "";
		boolean numeroEncontrado = false;
		
		//Loop para encontrar o número em um dos CEPs individuais
		//de Grandes Clientes "N == M".
		Iterator<String> it = listaGrandesClientes.iterator();
		while (it.hasNext() && !numeroEncontrado)
		{
			String linhaInteira = it.next();
			Log.info(linhaInteira);
			Matcher matcher = patternGrandesClientes.matcher(linhaInteira);
			if (matcher.matches())
			{
				numeroAvaliado = Integer.parseInt(matcher.group("numeroAvaliado"));
				cep = matcher.group("cep");
				//Log.info("MATCHGrandesClientes: " + numeroAvaliado + "\tCEP: " + cep);
				if (numeroProcurado == numeroAvaliado) { numeroEncontrado = true; }
			}
		}
		
		//Loop para encontrar o número em um dos CEPs listados por
		//intervalo numérico "L1 >= N >= L2".
		it = listaIntervaloNumero.iterator();
		while (it.hasNext() && !numeroEncontrado)
		{
			String linhaInteira = it.next();
			Log.info(linhaInteira);
			//NumeroAteLadoImpar
			Matcher matcher = patternNumeroAteLadoImpar.matcher(linhaInteira);
			if (numeroProcurado % 2 == 1 && matcher.matches())
			{
				numeroAvaliado = Integer.parseInt(matcher.group("numeroAvaliado"));
				cep = matcher.group("cep");
				Log.info("MATCHNumeroAteLadoImpar: até " + numeroAvaliado + "\tCEP: " + cep);
				if (1 <= numeroProcurado && numeroProcurado <= numeroAvaliado)
				{
					numeroEncontrado = true;
				}
			} else
			{
				//NumeroAteLadoPar
				matcher = patternNumeroAteLadoPar.matcher(linhaInteira);
				if (numeroProcurado % 2 == 0 && matcher.matches())
				{
					numeroAvaliado = Integer.parseInt(matcher.group("numeroAvaliado"));
					cep = matcher.group("cep");
					Log.info("MATCHNumeroAteLadoPar: até " + numeroAvaliado + "\tCEP: " + cep);
					if (2 <= numeroProcurado && numeroProcurado <= numeroAvaliado)
					{
						numeroEncontrado = true;
					}
				} else
				{
					//NumeroAteDoisLados
					matcher = patternNumeroAteDoisLados.matcher(linhaInteira);
					if (matcher.matches() && flagDoisLados)
					{
						numeroAvaliado1 = Integer.parseInt(matcher.group("numeroAvaliado1"));
						numeroAvaliado2 = Integer.parseInt(matcher.group("numeroAvaliado2"));
						numeroAvaliado = numeroAvaliado2;
						if (numeroAvaliado1 > numeroAvaliado2) { numeroAvaliado = numeroAvaliado1; }
						cep = matcher.group("cep");
						Log.info("MATCHNumeroAteDoisLados: até " + numeroAvaliado + "\tCEP: " + cep);
						if (1 <= numeroProcurado && numeroProcurado <= numeroAvaliado)
						{
							numeroEncontrado = true;
						}
					} else
					{
						//NumeroDeLadoImpar
						matcher = patternNumeroDeLadoImpar.matcher(linhaInteira);
						if (numeroProcurado % 2 == 1 && matcher.matches())
						{
							numeroAvaliadoDe = Integer.parseInt(matcher.group("numeroAvaliadoDe"));
							numeroAvaliadoA = Integer.parseInt(matcher.group("numeroAvaliadoA"));
							cep = matcher.group("cep");
							Log.info("MATCHNumeroDeLadoImpar: de " + numeroAvaliadoDe
									+ " a " + numeroAvaliadoA + "\tCEP: " + cep);
							if (numeroAvaliadoDe <= numeroProcurado && numeroProcurado <= numeroAvaliadoA)
							{
								numeroEncontrado = true;
							}
						} else
						{
							//NumeroDeLadoPar
							matcher = patternNumeroDeLadoPar.matcher(linhaInteira);
							if (numeroProcurado % 2 == 0 && matcher.matches())
							{
								numeroAvaliadoDe = Integer.parseInt(matcher.group("numeroAvaliadoDe"));
								numeroAvaliadoA = Integer.parseInt(matcher.group("numeroAvaliadoA"));
								cep = matcher.group("cep");
								Log.info("MATCHNumeroDeLadoPar: de " + numeroAvaliadoDe
										+ " a " + numeroAvaliadoA + "\tCEP: " + cep);
								if (numeroAvaliadoDe <= numeroProcurado && numeroProcurado <= numeroAvaliadoA)
								{
									numeroEncontrado = true;
								}
							} else
							{
								//NumeroDeDoisLados
								matcher = patternNumeroDeDoisLados.matcher(linhaInteira);
								if (matcher.matches() && flagDoisLados)
								{
									numeroAvaliadoDe1 = Integer.parseInt(matcher.group("numeroAvaliadoDe1"));
									numeroAvaliadoDe2 = Integer.parseInt(matcher.group("numeroAvaliadoDe2"));
									numeroAvaliadoDe = numeroAvaliadoDe1;
									if (numeroAvaliadoDe2 < numeroAvaliadoDe1) { numeroAvaliadoDe = numeroAvaliadoDe2; }
									numeroAvaliadoA1 = Integer.parseInt(matcher.group("numeroAvaliadoA1"));
									numeroAvaliadoA2 = Integer.parseInt(matcher.group("numeroAvaliadoA2"));
									numeroAvaliadoA = numeroAvaliadoA2;
									if (numeroAvaliadoA1 > numeroAvaliadoA2) { numeroAvaliadoA = numeroAvaliadoA1; }
									cep = matcher.group("cep");
									Log.info("MATCHNumeroDeDoisLados: de " + numeroAvaliadoDe
											+ " a " + numeroAvaliadoA + "\tCEP: " + cep);
									if (numeroAvaliadoDe <= numeroProcurado && numeroProcurado <= numeroAvaliadoA)
									{
										numeroEncontrado = true;
									}
								} else
								{
									//NumeroDeAoFimLadoImpar
									matcher = patternNumeroDeAoFimLadoImpar.matcher(linhaInteira);
									if (numeroProcurado % 2 == 1 && matcher.matches())
									{
										numeroAvaliado = Integer.parseInt(matcher.group("numeroAvaliado"));
										cep = matcher.group("cep");
										Log.info("MATCHNumeroDeAoFimLadoImpar: de " + numeroAvaliado
												+ " ao fim\tCEP: " + cep);
										if (numeroAvaliado <= numeroProcurado)
										{
											numeroEncontrado = true;
										}
									} else
									{
										//NumeroDeAoFimLadoPar
										matcher = patternNumeroDeAoFimLadoPar.matcher(linhaInteira);
										if (numeroProcurado % 2 == 0 && matcher.matches())
										{
											numeroAvaliado = Integer.parseInt(matcher.group("numeroAvaliado"));
											cep = matcher.group("cep");
											Log.info("MATCHNumeroDeAoFimLadoPar: de " + numeroAvaliado
													+ " ao fim\tCEP: " + cep);
											if (numeroAvaliado <= numeroProcurado)
											{
												numeroEncontrado = true;
											}
										} else
										{
											//NumeroDeAoFimDoisLados
											matcher = patternNumeroDeAoFimDoisLados.matcher(linhaInteira);
											if (matcher.matches() && flagDoisLados)
											{
												numeroAvaliado1 = Integer.parseInt(matcher.group("numeroAvaliado1"));
												numeroAvaliado2 = Integer.parseInt(matcher.group("numeroAvaliado2"));
												numeroAvaliado = numeroAvaliado1;
												if (numeroAvaliado2 < numeroAvaliado1) { numeroAvaliado = numeroAvaliado2; }
												cep = matcher.group("cep");
												Log.info("MATCHNumeroDeAoFimDoisLados: de " + numeroAvaliado
														+ " ao fim\tCEP: " + cep);
												if (numeroAvaliado <= numeroProcurado)
												{
													numeroEncontrado = true;
												}
											} else
											{
												//SemNumero
												matcher = patternSemNumero.matcher(linhaInteira);
												if (matcher.matches())
												{
													cep = matcher.group("cep");
													Log.info("MATCHSemNumero(LogradouroInteiro)"
															+ "\tCEP: " + cep);
													if (numeroAvaliado <= numeroProcurado)
													{
														numeroEncontrado = true;
													}
												}
											} //FIM Else NumeroDeAoFimDoisLados
										} //FIM Else NumeroDeAoFimLadoPar
									} //FIM Else NumeroDeAoFimLadoImpar
								} //FIM Else NumeroDeDoisLados
							} //FIM Else NumeroDeLadoPar
						} //FIM Else NumeroDeLadoImpar
					} //FIM Else NumeroAteDoisLados
				} //FIM Else NumeroAteLadoPar
			} //FIM Else NumeroAteLadoImpar
		} //FIM do while
		
		if (!numeroEncontrado)
		{
			Log.info("O número " + numero + " não foi encontrado.");
			cep = "";
			Assert.assertTrue(false);
		} else
		{
			Log.info("NÚMERO ENCONTRADO!!!: " + numero + "\tCEP encontrado: " + cep);
			Assert.assertTrue(true);
		}
		
	}

	public void retornarTelaPrincipal() {
		viewElement.getDriver().switchTo().defaultContent();
		viewElement.click(page.getBotaoFecharFrame());
	}
}
