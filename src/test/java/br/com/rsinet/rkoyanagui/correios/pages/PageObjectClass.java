package br.com.rsinet.rkoyanagui.correios.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageObjectClass extends PageObject{
	//WebDriver driver = new ChromeDriver();

	@FindBy(xpath = "//*[@id=\"content-servicos\"]/ul/li[2]/form/div[1]/label/strong")
	private WebElement tituloCaixaBuscaCepEndereco;
	
	@FindBy(xpath = "//*[@id=\"content-servicos\"]/ul/li[2]/form/div[2]/input[2]")
	private WebElement botaoConsultaCepEndereco;
	
	@FindBy(id = "acesso-busca")
	private WebElement campoConsultaCepEndereco;

	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/p")
	private WebElement tituloBuscaResultado;
	
	@FindBy(xpath = "//*[@id=\"precos-prazos\"]/form/div[1]/label/strong")
	private WebElement tituloPrecosEPrazos;
	
	@FindBy(id = "content-precos-prazos")
	private WebElement menuDropDownProdutoOuServico;
	
	private WebElement itemMenuProdutoOuServico;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/h3")
	private WebElement tituloTelaCalculoPrecosPrazos;
	
	@FindBy(name = "cepOrigem")
	private WebElement cepOrigem;
	
	@FindBy(name = "cepDestino")
	private WebElement cepDestino;
	
	@FindBy(name = "servico")
	private WebElement tipoServico;
	
	@FindBy(name = "Calcular")
	private WebElement btnEnviar;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/h3")
	private WebElement tituloResultadoPrecosPrazos;
	
	@FindBy(xpath = "//*[@id=\"content-servicos\"]/ul/li[5]/div[2]/a")
	private WebElement btnBuscarAgencia;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/h3")
	private WebElement tituloTelaBuscaAgencia;
	
	@FindBy(id = "tipoBusca")
	private WebElement buscarAgenciaPor;
	
	@FindBy(id = "estadoAgencia")
	private WebElement estado;
	
	@FindBy(id = "municipioAgencia")
	private WebElement municipio;
	
	@FindBy(xpath = "//*[@id=\"tableNomeAgencia\"]/tbody/tr/td[1]/a")
	private WebElement resultadoBuscaAgencia;
	
	public WebElement getHeader(String query) {
		return this.find(By.xpath(".//*[self::h1 or self::h2 or self::h3 or self::h4 or self::h5 or self::h6][.[contains(text(),\"Busca CEP - Endereço\")][1]]"));
	}
	
	public WebElement getBotao(String query) {
		return this.find(By.xpath(".//*[button[contains(text(),\"" + query + "\")][1]]"));
	}

	public WebElement getItemMenuProdutoOuServico() {
		return itemMenuProdutoOuServico;
	}

	public WebElement getBtnBuscarAgencia() {
		return btnBuscarAgencia;
	}

	public WebElement getTituloTelaBuscaAgencia() {
		return tituloTelaBuscaAgencia;
	}

	public WebElement getBuscarAgenciaPor(String value) {
		buscarAgenciaPor = this.find(By
			.xpath("//input[contains(@name, \"tipoBusca\") and contains(@value, \""
			+ value + "\")]"));
		return buscarAgenciaPor;
	}

	public WebElement getEstado() {
		return estado;
	}

	public WebElement getMunicipio() {
		return municipio;
	}
	
	public WebElement getMunicipio(String query) {
		municipio = this.find(By.xpath(".//*[.[contains(.,\""
				+ query + "\")]]"));
		return municipio;
	}

	public WebElement getResultadoBuscaAgencia() {
		return resultadoBuscaAgencia;
	}
	
	public WebElement getResultadoBuscaAgencia(String query) {
		resultadoBuscaAgencia = this.find(By.xpath(
				".//*[@id='tableNomeAgencia']/*[contains(.,\""
				+ query + "\")]"));
		return resultadoBuscaAgencia;
	}

	public WebElement getTituloCaixaBuscaCepEndereco() {
		return tituloCaixaBuscaCepEndereco;
	}

	public WebElement getBotaoConsultaCepEndereco() {
		return botaoConsultaCepEndereco;
	}

	public WebElement getCampoConsultaCepEndereco() {
		return campoConsultaCepEndereco;
	}

	public WebElement getTituloBuscaResultado() {
		return tituloBuscaResultado;
	}
	
	public WebElement getTituloPrecosEPrazos() {
		return tituloPrecosEPrazos;
	}
	
	public WebElement getMenuDropDownProdutoOuServico() {
		return menuDropDownProdutoOuServico;
	}
	
	public WebElement getItemMenuProdutoOuServico(String linkText) {
		itemMenuProdutoOuServico = this.find(By.linkText(linkText));
		return itemMenuProdutoOuServico;
	}
	
	public WebElement getTituloTelaCalculoPrecosPrazos() {
		return tituloTelaCalculoPrecosPrazos;
	}
	
	public WebElement getCepOrigem() {
		return cepOrigem;
	}
	
	public WebElement getCepDestino() {
		return cepDestino;
	}
	
	public WebElement getTipoServico() {
		return tipoServico;
	}
	
	public WebElement getBtnEnviar() {
		return btnEnviar;
	}
	
	public WebElement getTituloResultadoPrecosPrazos() {
		return tituloResultadoPrecosPrazos;
	}
}
