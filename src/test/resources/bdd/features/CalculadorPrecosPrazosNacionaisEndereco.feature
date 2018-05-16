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
  And preencho no formulario "<nomeFormulario1>" o campo "<nomeCampo1>" com o valor "<origem_logradouro>"
  And clico o botao 'Buscar'
  And sistema apresenta a tela de resultado da busca "<resultado_busca>"
  And procuro os resultados contendo "<origem_logradouro>" e "<origem_cidade_UF>" e "<origem_numero>" e "<origem_bairro>"
  And retorno para a tela principal
  And preencho o CEP encontrado no campo 'CEP de origem'
  And clico o botao "<botao1>" 
  And sistema apresenta o frame "<tituloTela1>"
  And preencho no formulario "<nomeFormulario1>" o campo "<nomeCampo1>" com o valor "<destino_logradouro>"
  And clico o botao 'Buscar'
  And sistema apresenta a tela de resultado da busca "<resultado_busca>"
  And procuro os resultados contendo "<destino_logradouro>" e "<destino_cidade_UF>" e "<destino_numero>" e "<destino_bairro>"
  And retorno para a tela principal
  And preencho o CEP encontrado no campo 'CEP de destino'
  And seleciono 'Tipo do servico' "<tipo_servico>"
  And clico no botao 'Enviar'
  Then sistema apresenta tela de resultado do calculo de precos e prazos "<validacao>"
#  Then procuro os resultados contendo "<logradouro>" e "<cidade_UF>" e "<numero>"
#  And preencho 'CEP de origem' "<cep_origem>"
#  And preencho 'CEP de destino' "<cep_destino>"
#  And seleciono 'Tipo do servico' "<tipo_servico>"
#  And clico no botao 'Enviar'
#  Then sistema apresenta tela de resultado do calculo de precos e prazos "<validacao>"
  
Examples:
   | url                                            | produto_ou_servico                           | tipo_servico  | validacao            | botao1        | tituloTela1          | nomeFormulario1 | nomeCampo1 | origem_logradouro        | resultado_busca                | origem_cidade_UF         | origem_numero | origem_bairro | destino_logradouro | destino_cidade_UF | destino_numero | destino_bairro |
   | http://www.correios.com.br/?set_language=pt-br | Calculador de Preços e Prazos Nacionais      | Carta Simples | Resultado do Cálculo | Não sei o CEP | Busca CEP - Endereço | Geral           | relaxation | Avenida dos Autonomistas | DADOS ENCONTRADOS COM SUCESSO. | Osasco/SP                | 197           |               | Alameda Tocantins  | Barueri/SP        | 75             |                |
   