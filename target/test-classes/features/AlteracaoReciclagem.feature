# language: pt
@padrão
Funcionalidade: Alteração de reciclagem
  Como usuário da API
  Quero alterar uma reciclagem já existente
  Para que o registro seja alterado corretamente no sistema

  Cenário: Alteração de reciclagem bem-sucedida, após passar ID de registro
    Dado que eu tenha os seguintes dados da reciclagem para alteração:
      | campo      | valor                  |
      | id         | 3                      |
      | usuario    | 1                      |
      | local      | Centro de reciclagem 3 |
      | data       | 2025-04-29             |
      | peso       | 10                     |
    Quando eu enviar a requisição para o endpoint "/api/reciclagem" de alteração de reciclagem
    Então o status code da resposta de alteração deve ser 200

  Cenário: Alteração de reciclagem sem sucesso ao passar um ID inexistente
    Dado que eu tenha os seguintes dados da reciclagem para alteração:
      | campo      | valor                  |
      | id         | 5                      |
      | usuario    | 1                      |
      | local      | Centro de reciclagem 5 |
      | data       | 2024-10-24             |
      | peso       | 10                     |
    Quando eu enviar a requisição para o endpoint "/api/reciclagem" de alteração de reciclagem
    Então o status code da resposta de alteração deve ser 404
    E o corpo de resposta de erro da api de alteração deve retornar a mensagem "Reciclagem não encontrada para atualizar!"