# language: pt
@padrão
Funcionalidade: Validar o contrato ao realizar um cadastro dem sucedido de reciclagem
  Como usuário da API
  Quero cadastrar uma nova reciclagem bem sucedida
  Para que o registro possa ser validado conforme o esperado

  Cenário: Cadastro bem-sucedido de reciclagem
    Dado que eu tenha os seguintes dados da reciclagem:
      | campo      | valor                  |
      | usuario    | 1                      |
      | local      | Centro de reciclagem 1 |
      | data       | 2025-04-26             |
      | peso       | 10                     |
    Quando eu enviar a requisição para o endpoint "/api/reciclagem" de cadastro de reciclagem
    Então o status code da resposta deve ser 201
    E que o arquivo de contrato esperado é o "Cadastro bem-sucedido de reciclagem"
    Então a resposta da requisição deve estar em conformidade com o contrato selecionado