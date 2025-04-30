# language: pt
@padrão
Funcionalidade: Cadastro de nova reciclagem
  Como usuário da API
  Quero cadastrar uma nova reciclagem
  Para que o registro seja salvo corretamente no sistema

  Cenário: Cadastro bem-sucedido de reciclagem
    Dado que eu tenha os seguintes dados da reciclagem:
      | campo      | valor                  |
      | usuario    | 1                      |
      | local      | Centro de reciclagem 1 |
      | data       | 2025-04-26             |
      | peso       | 10                     |
    Quando eu enviar a requisição para o endpoint "/api/reciclagem" de cadastro de reciclagem
    Então o status code da resposta deve ser 201

  Cenário: Cadastro de reciclagem sem sucesso ao passar o campo peso com valor negativo
    Dado que eu tenha os seguintes dados da reciclagem:
      | campo      | valor                  |
      | usuario    | 1                      |
      | local      | Centro de reciclagem 1 |
      | data       | 2025-04-26             |
      | peso       | -10                    |
    Quando eu enviar a requisição para o endpoint "/api/reciclagem" de cadastro de reciclagem
    Então o status code da resposta deve ser 400
    E o corpo de resposta de erro da api deve retornar a mensagem "deve ser maior que 0" ou "must be greater than 0"