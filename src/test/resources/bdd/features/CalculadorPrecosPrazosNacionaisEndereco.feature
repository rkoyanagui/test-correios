Feature: Calculador de Preços e Prazos Nacionais por Endereco

@CalcPrecosPrazosNacionaisEndereco
Scenario Outline: Calculador de Preços e Prazos Nacionais por Endereco
  Given estou na pagina inicial do site "<url>"
  When sistema apresenta tela de precos e prazos
  And abro menu drop down 'Produto ou Servico'
  And clico em um item do menu 'Produto ou Servico' "<produto_ou_servico>"
  And sistema apresenta tela de calculo de precos e prazos
  And clico no botao "<botao1>"
  Then sistema apresenta a tela "<tituloTela1>"
#  And preencho 'CEP de origem' "<cep_origem>"
#  And preencho 'CEP de destino' "<cep_destino>"
#  And seleciono 'Tipo do servico' "<tipo_servico>"
#  And clico no botao 'Enviar'
#  Then sistema apresenta tela de resultado do calculo de precos e prazos "<validacao>"
  
Examples:
   | url                                  | produto_ou_servico                           | botao1        | tituloTela1          |
   | http://www.correios.com.br/para-voce | Calculador de Preços e Prazos Nacionais      | Não sei o CEP | Busca CEP - Endereço |
   