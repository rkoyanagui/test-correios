package br.com.rsinet.rkoyanagui.correios.pages;

import java.util.ArrayList;
import java.util.List;

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
	
	public void switchToWindow(String windowHandle) {
		WebDriver driver = this.getDriver();
		driver.switchTo().window(windowHandle);
	}
	
	public String getWindowHandle(int counter) throws IllegalArgumentException {
		if (counter < 0) {
			throw new IllegalArgumentException(
					"Erro: o método \'void PageObjectClass.getWindowHandle(int counter)\' "
					+ "aceita somente um número inteiro maior ou igual a zero.");
		}
		WebDriver driver = this.getDriver();
		List<String> abas = new ArrayList<String>();
		abas.addAll(driver.getWindowHandles());
		return abas.get(counter);
	}
	
	/**
	 * @return o primeiro elemento, de qualquer tag ou tipo, que
	 * contenha um dado texto.
	 * 
	 * @param text é o texto procurado no html.
	*/
	public WebElement getText(String text) {
		return this.find(By.xpath(
				"//*[contains(text(), \"" + text + "\")][1]" ));
	}
	
	/**
	 * @return o primeiro <b>input</b> (campo de entrada)
	 * encontrado com <b>@type="Submit"</b>, buscando pelo <b>@id</b>
	 * de algum de seus ancestrais.
	 * 
	 * @param ancestorId é o 'id' de um elemento que seja ancestral do input.
	*/
	public WebElement getInputSubmit(String ancestorId) {
		return this.find(By.xpath(
				"//*[@id=\"" + ancestorId + "\"]//input[@type=\"Submit\"][1]" ));
	}
	
	/**
	 * @return o primeiro elemento encontrado do tipo
	 * <b>input</b> (campo de entrada) com um dado nome.
	 * 
	 * @param formName é o 'name' do elemento que contém o input.
	 * @param inputName é o 'name' do input que será buscado no html.
	*/
	public WebElement getInput(String formName, String inputName) {
		return this.find(By.xpath(
				"//*[@name=\"" + formName +
				"\"][1]//input[@name=\"" + inputName + "\"][1]" ));
	}
	
	/**
	 * @return o primeiro elemento encontrado do tipo
	 * <b>form</b> (formulário) com um dado nome.
	 * 
	 * @param name é o parâmetro que será buscado no html.
	*/
	public WebElement getForm(String name) {
		return this.find(By.xpath(
				"//form[@name=\"" + name + "\"][1]" ));
	}
	
	/**
	 * Busca um elemento qualquer por <b>id</b>, então retorna uma
	 * referência para o primeiro <b>iframe</b> encontrado
	 * descentente desse elemento, independentemente do nível de descendência.
	 * 
	 * @return o primeiro <b>frame</b> encontrado tendo um ancestral
	 * com id igual ao parâmetro <b>ancestorId</b>
	 * 
	 * @param ancestorId é o id de algum dos ancestrais
	 * (de qualquer nível) do iframe buscado.
	*/
	public WebElement getFrame(String ancestorId) {
		return this.find(By.xpath(
				"//*[@id=\"" + ancestorId + "\"]//iframe[1]" ));
	}
	
	/**
	 * Transfere o contexto para um <b>iframe</b>.
	 * 
	 * @param frame é uma referência do tipo WebElement para um <b>iframe</b>.
	*/
	public void switchToFrame(WebElement frame) {
		this.getDriver().switchTo().frame(frame);
	}
	
	/**
	 * Busca um elemento qualquer por <b>id</b>, então transfere
	 * o contexto para o primeiro <b>iframe</b> encontrado
	 * descentente desse elemento, independentemente do nível de descendência.
	 * 
	 * @param ancestorId é o id de algum dos ancestrais
	 * (de qualquer nível) do iframe buscado.
	*/
	public void switchToFrame(String ancestorId) {
		WebElement selectedFrame = this.find(By.xpath(
				"//*[@id=\"" + ancestorId + "\"]//iframe[1]" ));
		this.getDriver().switchTo().frame(selectedFrame);
	}
	
	/**
	 * Transfere o contexto para uma iframe. Este método percorre a
	 * página e encontra todos os iframes. Por isso,
	 * é necessário especificar <b>counter</b>.
	 * 
	 * @param counter deve ser um inteiro maior que zero
	 * que indica para qual dos iframes pesquisados
	 * o contexto é transferido: se é para o primeiro encontrado (1), ou
	 * para o segundo (2), etc.
	*/
	public void switchToFrame(int counter) throws IllegalArgumentException {
		if (counter < 1) {
			throw new IllegalArgumentException(
					"Erro: o método \'void PageObjectClass.switchToFrame(int counter)\' "
					+ "aceita somente um número inteiro maior que zero.");
		}
		WebElement selectedFrame = this.find(By.xpath(
				"//iframe[" + counter + "]" ));
		this.getDriver().switchTo().frame(selectedFrame);
	}
	
	/**
	 * Encontra um header, de qualquer nível (de h1 até h6),
	 * que contenha um texto específico.
	 * 
	 * @return o primeiro header encontrado contendo <b>text</b>.
	 * 
	 * @param text é o texto contido no header.
	*/
	public WebElement getHeader(String text) {
		return this.find(By.xpath(
				"//*[self::h1 or "
				+ "self::h2 or "
				+ "self::h3 or "
				+ "self::h4 or "
				+ "self::h5 or "
				+ "self::h6][contains(text(), \"" + text + "\")][1]"));
	}
	
	/**
	 * Encontra um botão que contenha um texto específico.
	 * 
	 * @return o primeiro botão encontrado contendo <b>text</b>.
	 * 
	 * @param text é o texto contido no botão.
	*/
	public WebElement getBotao(String text) {
		return this.find(By.xpath(".//button[contains(text(),\"" + text + "\")][1]"));
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
