# language: pt
@padrão
Funcionalidade: Exclusão de reciclagem
  Como usuário da API
  Quero excluir uma reciclagem
  Para que o registro seja apagado corretamente no sistema

  Contexto: Cadastro bem-sucedido de reciclagem
    Dado que eu tenha os seguintes dados da reciclagem:
      | campo      | valor                  |
      | usuario    | 1                      |
      | local      | Centro de reciclagem 1 |
      | data       | 2025-04-26             |
      | peso       | 50                     |
    Quando eu enviar a requisição para o endpoint "/api/reciclagem" de cadastro de reciclagem
    Então o status code da resposta deve ser 201

  Cenário: Deve ser possível excluir uma reciclagem
    Dado que eu recupere o ID da reciclagem criada no contexto
    Quando eu enviar a requisição com o ID para o endpoint "/api/reciclagem" de deleção de reciclagem
    Então o status code da resposta deve ser 204