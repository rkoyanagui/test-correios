Feature: Calculador de Preços e Prazos Nacionais por Endereco

@CalcPrecosPrazosNacionaisEndereco
Scenario Outline: Calculador de Preços e Prazos Nacionais por Endereco
  Given estou na pagina inicial do site "<url>"
  When sistema apresenta tela de precos e prazos
  And abro menu drop down 'Produto ou Servico'
  And clico em um item do menu 'Produto ou Servico' "<produto_ou_servico>"
  And sistema apresenta tela de calculo de precos e prazos
  And clico o botao "<botao1>"
  And sistema apresenta o frame "<tituloTela1>"
  And preencho no formulario "<nomeFormulario1>" o campo "<nomeCampo1>" com o valor "<valorCampo1>"
  And clico o botao 'Buscar'
  And sistema apresenta o resultado da busca "<resultado_busca>"
  Then procuro os resultados contendo 
#  And preencho 'CEP de origem' "<cep_origem>"
#  And preencho 'CEP de destino' "<cep_destino>"
#  And seleciono 'Tipo do servico' "<tipo_servico>"
#  And clico no botao 'Enviar'
#  Then sistema apresenta tela de resultado do calculo de precos e prazos "<validacao>"
  
Examples:
   | url                                  | produto_ou_servico                           | botao1        | tituloTela1          | nomeFormulario1 | nomeCampo1 | valorCampo1              | resultado_busca                |
   | http://www.correios.com.br/para-voce | Calculador de Preços e Prazos Nacionais      | Não sei o CEP | Busca CEP - Endereço | Geral           | relaxation | Avenida dos Autonomistas | DADOS ENCONTRADOS COM SUCESSO. |
   