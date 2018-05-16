package br.com.rsinet.rkoyanagui.correios.steps.definition;

import java.util.UUID;

import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jline.internal.Log;
import br.com.rsinet.rkoyanagui.correios.steps.business.StepBusiness;
import net.thucydides.core.annotations.Steps;

@ContextConfiguration("/context.xml")
public class StepDefinition {

	@Steps
	StepBusiness stepB;
	
	@Given("^estou na pagina inicial do site \"([^\"]*)\"$")
	public void estou_na_pagina_inicial_do_site(String url) throws Throwable {
	    stepB.openHome(url);
	}

	@When("^sistema apresenta tela de busca$")
	public void sistema_apresenta_tela_de_busca() throws Throwable {
	    stepB.validarTelaDeBuscaCepEndereco();
	}

	@When("^preencho 'CEP ou Endereco' \"([^\"]*)\"$")
	public void preencho_cep_ou_endereco(String cep_ou_endereco) throws Throwable {
	    stepB.preencherCepOuEndereco(cep_ou_endereco);
	}

	@When("^clico no botao 'Consultar'$")
	public void clico_no_botao_consultar() throws Throwable {
	    stepB.clicarBotaoConsultar();
	}

	@Then("^sistema apresenta tela de resultado \"([^\"]*)\"$")
	public void sistema_apresenta_tela_de_resultado(String arg1) throws Throwable {
	    stepB.validarTelaResultado(arg1);
	}
	
	@When("^sistema apresenta tela de precos e prazos$")
	public void sistema_apresenta_tela_de_precos_e_prazos() throws Throwable {
	    stepB.validarTelaDePrecosEPrazos();
	}
	
	@When("^abro menu drop down 'Produto ou Servico'$")
	public void abro_menu_drop_down_produto_ou_servico() throws Throwable {
	    stepB.abrirMenuDropDownProdutoOuServico();
	}
	
	@When("^clico em um item do menu 'Produto ou Servico' \"([^\"]*)\"$")
	public void clicar_em_um_item_menu_produto_ou_servico(String item) throws Throwable {
	    stepB.clicarItemMenuProdutoOuServico(item);
	}
	
	@When("^sistema apresenta tela de calculo de precos e prazos$")
	public void sistema_apresenta_tela_de_calculo_de_precos_e_prazos() throws Throwable {
	    stepB.validarTelaCalculoPrecosPrazos();
	}
	
	@When("^preencho 'CEP de origem' \"([^\"]*)\"$")
	public void preencho_cep_de_origem(String cepOrigem) throws Throwable {
	    stepB.preencherCepOrigem(cepOrigem);
	}
	
	@When("^preencho 'CEP de destino' \"([^\"]*)\"$")
	public void preencho_cep_de_destino(String cepDestino) throws Throwable {
	    stepB.preencherCepDestino(cepDestino);
	}
	
	@When("^seleciono 'Tipo do servico' \"([^\"]*)\"$")
	public void seleciono_tipo_do_servico(String tipoServico) throws Throwable {
	    stepB.selecionarTipoServico(tipoServico);
	}
	
	@When("^clico no botao 'Enviar'$")
	public void clico_no_botao_enviar() throws Throwable {
	    stepB.clicarBotaoEnviar();
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("^sistema apresenta tela de resultado do calculo de precos e prazos \"([^\"]*)\"$")
	public void sistema_apresenta_tela_de_resultado_do_calculo_de_precos_e_prazos(String arg1) throws Throwable {
	    stepB.validarTelaResultadoCalculoPrecosPrazos(arg1);
	}
	
	@When("^clico no botao 'Buscar Agencia'$")
	public void clico_botao_buscar_agencia() throws Throwable {
	    stepB.clicarBotaoBuscarAgencia();
	}
	
	@When("^sistema apresenta tela de busca de agencias$")
	public void sistema_apresenta_tela_de_busca_de_agencias() throws Throwable {
	    stepB.validarTelaBuscaAgencia();
	}
	
	@When("^seleciono buscar agencia por \"([^\"]*)\"$")
	public void seleciono_buscar_agencia_por(String por) throws Throwable {
	    stepB.selecionarBuscarAgenciaPor(por);
	}
	
	@When("^preencho 'Estado' \"([^\"]*)\"$")
	public void preencho_estado(String estado) throws Throwable {
	    stepB.preencherEstado(estado);
	}
	
	@When("^preencho 'Municipio' \"([^\"]*)\"$")
	public void preencho_municipio(String municipio) throws Throwable {
	    stepB.preencherMunicipio(municipio);
	}
	
	@Then("^sistema apresenta resultado busca agencia \"([^\"]*)\"$")
	public void sistema_apresenta_resultado_busca_agencia(String resultado) throws Throwable {
	    stepB.validarTelaResultadoBuscaAgencia(resultado);
	}
	
	@When("^clico o botao \"([^\"]*)\"$")
	public void clico_o_botao(String botao) throws Throwable {
	    stepB.salvarContextoWindow();
	    stepB.clicarBotao(botao);
	}
	
	@When("^sistema apresenta o frame \"([^\"]*)\"$")
	public void sistema_apresenta_o_frame(String tituloTela) throws Throwable {
		stepB.mudarContextoParaFrame("http://www.buscacep.correios.com.br");
	    //stepB.validarTitulo(tituloTela);
	}
	
	@When("^preencho no formulario \"([^\"]*)\" o campo \"([^\"]*)\" com o valor \"([^\"]*)\"$")
	public void preencho_o_campo_X1_com_o_valor_X2(
			String nomeFormulario, String nomeCampo, String valor) throws Throwable {
	    stepB.preencherValor(nomeFormulario, nomeCampo, valor);
	}
	
	@When("^clico o botao 'Buscar'$")
	public void clico_o_botao_buscar() throws Throwable {
	    stepB.clicarInput("Geral");
	}
	
	@When("^sistema apresenta a tela de resultado da busca \"([^\"]*)\"$")
	public void sistema_apresenta_a_tela_de_resultado_da_busca(String texto) throws Throwable {
	    stepB.validarTexto(texto);
	}
	
	@When("^procuro os resultados contendo \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\"$")
	public void procuro_os_resultados_contendo(
			String logradouro, String cidadeUF, String numero, String bairro) throws Throwable
	{
	    //stepB.encontrarCepNaTabelaPorBairro(logradouro, cidadeUF, bairro);
		try {
		stepB.encontrarCepNaTabelaPorNumero(logradouro, cidadeUF, numero, false);
		} catch (NumberFormatException ex)
		{
			Log.info(ex.getMessage());
		}
	}
	
	@When("^retorno para a tela principal$")
	public void retorno_para_a_tela_principal()
	{
		stepB.retornarTelaPrincipal();
	}
	
	@When("^preencho o CEP encontrado no campo 'CEP de origem'$")
	public void preencho_o_CEP_encontrado_no_campo_CEP_de_origem()
	{
		stepB.preencherCepEncontradoOrigem();
	}
	
	@When("^preencho o CEP encontrado no campo 'CEP de destino'$")
	public void preencho_o_CEP_encontrado_no_campo_CEP_de_destino()
	{
		stepB.preencherCepEncontradoDestino();
	}
}
