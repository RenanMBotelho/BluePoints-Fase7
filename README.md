# BluePoints

É um aplicativo de pontos de coleta seletiva. Seu objetivo é ajudar cidadãos a gerenciar e separar corretamente o lixo, indicando o ponto de coleta seletiva mais próximo e fornecendo informações sobre os dias e horários de coleta de resíduos.

## Índice

- Descrição
- Funcionalidades
- Pré-requisitos
- Instalação
- Uso
- Docker
- Testes

## Descrição

O aplicativo BluePoints, através de seu objetivo de fortalecer uma cidade mais sustentável, permite que o usuário encontre locais apropriados de coleta de materiais, faz o controle dessas reciclagens e ainda oferece pontos ao usuário para que ele possa trocar por benefícios oferecidos pelo aplicativo, fornecidos por empresas parceiras.
Este fonte realiza testes via api das funcionalidades de CRUD do aplicativo.

## Funcionalidades

- Fazer cadastro no aplicativo.
- Fazer login para recebimento do token para teste de api.
- Cadastro de reciclagem também através de api.
- Consulta de reciclagem.
- Alteração de reciclagem.
- Exclusão de reciclagem.

## Pré-requisitos

- IDE Intellij para clonar o código.
- Docker instalado para execução em contêiner.
- Caso desejado, programa Postman ou Insomnia para testes de api com os arquivos.
- Liberação da porta 8080 para o programa rodar.

## Instalação 

Siga o passo abaixo para configurar o ambiente de desenvolvimento:

1. Clone este repositório no ambiente de desenvolvimento (indicado o programa Intellij): https://github.com/RenanMBotelho/BluePoints-Fase7.git

## Uso

1. Crie e rode a imagem com o Docker através o terminal da IDE.
2. Ou rode o programa pelo main app e se certifique que não tenha apresentado erro no terminal.
2. É possível usar o programa através do navegador, para testes de api, utilizando a extenção Swagger no link: http://localhost:8080/swagger-ui/index.html#/
3. É possível também utilizar através do programa Postman ou similar com o json de api já importado, encontrando no diretório do projeto.

## Docker

A aplicação deve ser executada em um contêiner Docker, facilitando a implantação em diferentes ambientes.

### Construindo a imagem Docker

```bash
docker build -t bluepoints-app .
```

### Executando a aplicação via Docker

```bash
docker run -p 8080:8080 --name bluepoints-container bluepoints-app
```

## Executando os testes

Com o programa rodando, seja diretamente na IDE ou via docker, os testes devem ser executados:

1. Teste dos cenários 1 e 2, arquivo CadastroReciclagem.feature, diretório src/test/resources/feature
2. Teste dos cenários 3 e 4, arquivo AlteracaoReciclagem.feature, diretório src/test/resources/feature
3. Teste do cenário de Contexto, arquivo ExclusaoReciclagemContexto.feature, diretório src/test/resources/feature
4. Teste do cenário de Contrato, arquivo ReciclagemContrato.feature, diretório src/test/resources/feature
5. Teste com TestRunner, arquivo TestRunner, diretório src/test/java/runner