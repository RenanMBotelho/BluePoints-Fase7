# BluePoints

É um aplicativo de pontos de coleta seletiva. Seu objetivo é ajudar cidadãos a gerenciar e separar corretamente o lixo, indicando o ponto de coleta seletiva mais próximo e fornecendo informações sobre os dias e horários de coleta de resíduos.

## Índice

- Descrição
- Funcionalidades
- Pré-requisitos
- Instalação
- Uso
- Docker
- CI/CD com GitHub Actions
- Testes

## Descrição

O aplicativo BluePoints, através de seu objetivo de fortalecer uma cidade mais sustentável, permite que o usuário encontre locais apropriados de coleta de materiais, faz o controle dessas reciclagens e ainda oferece pontos ao usuário para que ele possa trocar por benefícios oferecidos pelo aplicativo, fornecidos por empresas parceiras.
Este fonte realiza testes via api das funcionalidades de CRUD do aplicativo.

## Funcionalidades

- Fazer cadastro no aplicativo.
- Fazer login para recebimento do token para teste de api.
- Cadastro de reciclagem também através de api.
- Consulta de registros.
- Alteração de registros.
- Exclusão de registros.

## Pré-requisitos

- IDE para clonar o código.
- Arquivos de teste de api para o aplicativo.
- Programa Postman ou Insomnia para testes de api com os arquivos.
- Liberação da porta 8080 para o programa rodar via Docker.
- Docker instalado para execução em contêiner.

## Instalação

Siga os passos abaixo para configurar o ambiente de desenvolvimento:

1. Clone este repositório no ambiente de desenvolvimento (indicado o programa Intellij ou Visual Studio Code): https://github.com/RenanMBotelho/BluePoints-Fase6-01.git
2. Caso deseje, instale o programa Postman ou Insomnia.

## Uso

1. Rode o programa e se certifique que não tenha apresentado erro no terminal.
2. É possível usar o programa através do navegador, utilizando a extenção Swagger no link: http://localhost:8080/swagger-ui/index.html#/
3. É possível também utilizar através do programa Postman ou similar com o json de api já importado, encontrando no diretório do projeto.

## Docker

A aplicação pode ser executada em um contêiner Docker, facilitando a implantação em diferentes ambientes.

### Construindo a imagem Docker

```bash
docker build -t bluepoints:latest .
```

### Executando a aplicação via Docker

```bash
docker run -p 8080:8080 bluepoints:latest
```

### Utilizando Docker Compose

Para iniciar a aplicação com todas as configurações necessárias:

```bash
docker compose up
```

## CI/CD com GitHub Actions

Este projeto utiliza GitHub Actions para automação de integração contínua. O pipeline executa as seguintes etapas:

1. Compila o código Java
2. Executa testes unitários
3. Constrói a imagem Docker
4. Verifica se a imagem Docker pode ser executada
5. Valida a configuração do Docker Compose

Para ver o status das execuções, acesse a aba "Actions" no repositório GitHub.

## Testes

1. Primeiro teste: fazendo login com o usuário predefinido no json, no endpoint "login usuário", para recebimento do token. É possível, caso desejado, fazer o cadastro de um usuário.
2. Segundo teste: com o token recebido, o mesmo deverá ser aplicado em todos os demais testes de CRUD, na opção "Auth", como Bearer Token.
3. Terceiro teste: na opção "incluir reciclagem", com o token já aplicado, pode ser usado o conteúdo do body como exemplo para registro de reciclagem no aplicativo.
4. Quarto teste: na opção "listar reciclagens", é possível obter um get com todos os registros de reciclagem do banco de dados.
5. Quinto teste: na opção de "atualizar reciclagem", é passado o ID que se deseja alterar e as alterações a serem feitas.
6. Sexto teste: por fim, para concluir o CRUD, é possível exluir um registro passando o ID que se deseja deletar no endereço do endpoint.
