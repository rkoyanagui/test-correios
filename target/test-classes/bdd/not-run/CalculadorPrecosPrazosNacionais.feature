Feature: Calculador de Preços e Prazos Nacionais

@CalcPrecosPrazosNacionais
Scenario Outline: Calculador de Preços e Prazos Nacionais
  Given estou na pagina inicial do site "<url>"
  When sistema apresenta tela de precos e prazos
  And abro menu drop down 'Produto ou Servico'
  And clico em um item do menu 'Produto ou Servico' "<produto_ou_servico>"
  And sistema apresenta tela de calculo de precos e prazos
  And preencho 'CEP de origem' "<cep_origem>"
  And preencho 'CEP de destino' "<cep_destino>"
  And seleciono 'Tipo do servico' "<tipo_servico>"
  And clico no botao 'Enviar'
  Then sistema apresenta tela de resultado do calculo de precos e prazos "<validacao>"
  
Examples:
   | url                                  | produto_ou_servico                           | cep_origem | cep_destino | tipo_servico    | validacao            |
   | http://www.correios.com.br/para-voce | Calculador de Preços e Prazos Nacionais      | 06455020   | 06020000    | Aerograma       | Resultado do Cálculo |
#   | http://www.correios.com.br/para-voce | Calculador de Preços e Prazos Internacionais | DADOS NAO ENCONTRADOS          |
#   | http://www.correios.com.br/para-voce | Serviços internacionais                      | DADOS ENCONTRADOS COM SUCESSO. |
#   | http://www.correios.com.br/para-voce | Consulta a áreas com restrição de entrega    | DADOS NAO ENCONTRADOS          |
#   | http://www.correios.com.br/para-voce | Serviços nacionais                           | DADOS NAO ENCONTRADOS          |

