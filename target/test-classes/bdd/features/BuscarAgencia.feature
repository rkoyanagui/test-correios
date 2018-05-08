Feature: Buscar Agencia

@buscarAgencia
Scenario Outline: Buscar Agencia
  Given estou na pagina inicial do site "<url>"
  When clico no botao 'Buscar Agencia'
  And sistema apresenta tela de busca de agencias
  And seleciono buscar agencia por "<por>"
  And preencho 'Estado' "<estado>"
  And preencho 'Municipio' "<municipio>"
  Then sistema apresenta resultado busca agencia "<validacao>"
  
Examples:
   | url                                  | por | estado         | municipio | validacao                                                       |
   | http://www.correios.com.br/para-voce | L   | SÃO PAULO      | BARUERI   | ACC CAMPOS SALES               - AG. CORREIOS COMER. TERCEIRIZ. |
#   | http://www.correios.com.br/para-voce | Calculador de Preços e Prazos Internacionais | DADOS NAO ENCONTRADOS          |
#   | http://www.correios.com.br/para-voce | Serviços internacionais                      | DADOS ENCONTRADOS COM SUCESSO. |
#   | http://www.correios.com.br/para-voce | Consulta a áreas com restrição de entrega    | DADOS NAO ENCONTRADOS          |
#   | http://www.correios.com.br/para-voce | Serviços nacionais                           | DADOS NAO ENCONTRADOS          |
