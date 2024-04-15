# Teste de Regressão Automatizado usando Java e Selenium

Este projeto é um exemplo de um teste de regressão automatizado usando Java e Selenium WebDriver. Ele inclui uma estrutura básica para organizar os testes, logs e a lógica dos testes (Page Objects).

## Estrutura do Projeto

O projeto é estruturado da seguinte forma:

### Base

Nesta pasta, estão localizadas as classes que fornecem a base para os testes:

- **Actions:** Classes que definem as ações comuns realizadas durante os testes, como clicar em elementos, inserir texto em campos de entrada, etc.
- **Log:** Aqui ficam os registros dos testes. Pode incluir logs de sucesso, falhas, exceções e informações relevantes durante a execução dos testes.
- **Configuração do Navegador:** Classes para configurar o navegador que será usado para executar os testes, como Chrome, Firefox e Edge.

### Test Execution

Nesta pasta, estão localizadas as classes de teste:

- **Classes de Teste:** Classes que contêm os casos de teste individuais. Estes casos de teste usam as ações definidas na pasta Base para interagir com os elementos da página.

![image](https://github.com/jhonatavenancio/regressao_webdriver/assets/163940459/df686660-6b40-43e1-84e1-93705f252fd4)

![image](https://github.com/jhonatavenancio/regressao_webdriver/assets/163940459/4f0b3b76-5af4-4854-9ab4-bd2cb9b84b64)

  
### Utils

Nesta pasta, estão localizadas as classes utilitárias:

- **Lógica dos Testes (Page Object):** Classes que representam as páginas do aplicativo sob teste. Cada página é representada por uma classe que contém métodos para interagir com os elementos da página e métodos para executar ações específicas naquela página.

### Objetivo dos Testes:
Os testes automatizados desenvolvidos neste projeto visam garantir que a plataforma simulada da SauceDemo funcione corretamente em diversos cenários, incluindo navegação pelos produtos, adição ao carrinho, checkout e funcionalidades da conta do usuário.

Cada 'user' possui um tipo de acesso diferente para simular vários cenários.

## Pré-requisitos

Para executar os testes, é necessário ter o seguinte configurado:

- JDK (Java Development Kit) instalado na máquina.
- Configuração do ambiente Selenium WebDriver.
- Dependências do Maven configuradas corretamente.

