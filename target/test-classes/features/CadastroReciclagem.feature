# language: pt
Funcionalidade: Cadastro de nova reciclagem
  Como usuário da API
  Quero cadastrar uma nova reciclagem
  Para que o registro seja salvo corretamente no sistema
  Cenário: Cadastro bem-sucedido de reciclagem
    Dado que eu tenha os seguintes dados da reciclagem:
      | campo      | valor                    |
      | usuario    | 1                        |
      | local      | "Centro de reciclagem 1" |
      | data       | "2025-04-26"             |
      | peso       | 15                       |
    Quando eu enviar a requisição para o endpoint "/api/reciclagem" de cadastro de reciclagens
    Então o status code da resposta deve ser 201