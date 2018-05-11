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
  And preencho no formulario "<nomeFormulario1>" o campo "<nomeCampo1>" com o valor "<logradouro>"
  And clico o botao 'Buscar'
  And sistema apresenta a tela de resultado da busca "<resultado_busca>"
  Then close
#  Then procuro os resultados contendo "<logradouro>" e "<cidade_UF>" e "<numero>"
#  And preencho 'CEP de origem' "<cep_origem>"
#  And preencho 'CEP de destino' "<cep_destino>"
#  And seleciono 'Tipo do servico' "<tipo_servico>"
#  And clico no botao 'Enviar'
#  Then sistema apresenta tela de resultado do calculo de precos e prazos "<validacao>"
  
Examples:
   | url                                  | produto_ou_servico                           | botao1        | tituloTela1          | nomeFormulario1 | nomeCampo1 | logradouro               | resultado_busca                | cidade_UF | numero |
   | http://www.correios.com.br/para-voce | Calculador de Preços e Prazos Nacionais      | Não sei o CEP | Busca CEP - Endereço | Geral           | relaxation | Avenida dos Autonomistas | DADOS ENCONTRADOS COM SUCESSO. | Osasco/SP | 197    |
   