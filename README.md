# App FitAcademy - Backend

<p align="center">
  <img src="https://ik.imagekit.io/iibl43pgxp/ChatGPT%20Image%2031%20de%20jul.%20de%202026,%2013_21_11(1).png" width="400"/>
</p>



[![Top Language](https://img.shields.io/github/languages/top/Grupo-05-Turma-Java-85/academia_fithub-backend?style=flat-square)](https://github.com/Grupo-05-Turma-Java-85/academia_fithub-backend) [![Repo Size](https://img.shields.io/github/repo-size/Grupo-05-Turma-Java-85/academia_fithub-backend?style=flat-square)](https://github.com/Grupo-05-Turma-Java-85/academia_fithub-backend) [![Last Commit](https://img.shields.io/github/last-commit/Grupo-05-Turma-Java-85/academia_fithub-backend?style=flat-square)](https://github.com/Grupo-05-Turma-Java-85/academia_fithub-backend) [![Java](https://img.shields.io/badge/Java-17-red?style=flat-square&logo=openjdk)](https://openjdk.org/) [![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=flat-square&logo=springboot)](https://spring.io/projects/spring-boot) 

[![MySQL](https://camo.githubusercontent.com/c49132f37ac3f2f1b7c9a8fa2352e3f5874c6393039371b6fa4c9f405a7d8c94/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4d7953514c2d3434373941313f7374796c653d666c61742d737175617265266c6f676f3d6d7973716c266c6f676f436f6c6f723d7768697465)](https://www.mysql.com/)[![Maven](https://camo.githubusercontent.com/83d21418c6ad8853ff0ebf48616a5134a5b73fdd5623fb444c3ef88a7015c08a/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4d6176656e2d4337314133363f7374796c653d666c61742d737175617265266c6f676f3d6170616368656d6176656e)](https://maven.apache.org/)[![JPA](https://camo.githubusercontent.com/8a94a2fb5664e922e31e946fe8c049bcc99737b20c13bcc1795b54a3391fadc7/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a50412d48696265726e6174652d3539363636433f7374796c653d666c61742d737175617265)](https://hibernate.org/)[![License](https://camo.githubusercontent.com/7d217ebb91a61cb4d98e70dee31eb08e0a5f71bc518ebd4151a73c6fb1191d00/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4c6963656e73652d4d49542d626c75653f7374796c653d666c61742d737175617265)](https://github.com/Grupo-05-Turma-Java-85/delivery_alimentos-backend/blob/main/LICENSE)



## 1. Descrição

O **FitAcademy** é uma API REST desenvolvida para o gerenciamento de exercícios físicos, permitindo o cadastro, consulta, atualização e exclusão de categorias e exercícios. A plataforma foi projetada para organizar treinos de forma prática e intuitiva, facilitando a navegação por categorias e a visualização dos exercícios disponíveis. 

Além do gerenciamento de exercícios, a aplicação conta com um módulo de usuários, responsável pelo acesso à plataforma e pela visualização dos conteúdos cadastrados. 



## 2. Sobre esta API

O projeto foi desenvolvido utilizando **Java**, **Spring Boot**, **Spring Data JPA**, **Hibernate** e **MySQL**, seguindo a arquitetura **REST** e as boas práticas de desenvolvimento Back-end, garantindo uma aplicação organizada, escalável e de fácil manutenção.

🌐 **Link do Deploy:** 



### 2.1. Principais funcionalidades da API:

1. Cadastro, consulta, atualização e login de usuários no sistema.
2. Armazenamento de informações pessoais dos usuários, como nome, foto, peso e altura.
3. Cálculo do Índice de Massa Corporal (IMC) dos usuários com base nos dados informados.
4. Cadastro, consulta, atualização e exclusão de exercícios.
5. Organização dos exercícios por categorias.
6. Consulta de exercícios cadastrados no sistema.
7. Gerenciamento das categorias de exercícios.
8. Validação dos dados enviados para garantir a integridade das informações.
9. Integração com banco de dados para persistência dos dados da aplicação.



## 3. Diagrama de Classes

<p align="center">
  <img src="https://ik.imagekit.io/iibl43pgxp/CLASSES-APPFIT.png" alt="Descrição da imagem" width="700"/>
</p>



## 4. Diagrama Entidade-Relacionamento (DER)

<p align="center">
  <img src="https://ik.imagekit.io/iibl43pgxp/DER-APPFIT.png" alt="Descrição da imagem" width="700"/>
</p>



## 5. Tecnologias utilizadas

| Item                          | Descrição       |
| ----------------------------- | --------------- |
| **Servidor**                  | Tomcat          |
| **Linguagem de programação**  | Java            |
| **Framework**                 | Spring Boot     |
| **ORM**                       | JPA + Hibernate |
| **Banco de dados Relacional** | MySQL           |
| **Segurança**                 | Spring Security |
| **Autenticação**              | JWT             |
| **Testes automatizados**      | JUnit           |
| **Documentação**              | SpringDoc       |



## 6. Modelo de Dados

A aplicação possui as seguintes entidades principais:

### 🏋️‍♀️ Exercícios

Representa os exercícios disponíveis na plataforma.

Principais atributos:

- ID
- Nome
- Equipamento
- Foto
- Categoria_id



### 🗂️ Categorias

Representa a classificação dos exercícios cadastrados.

Exemplos:

- Tórax
- Ombros e Tríceps
- Costas e Bíceps
- Membros Inferiores



### 👤Usuários

Representa os usuários cadastrados na plataforma. 

Os dados cadastrados incluem:

- ID
- Nome
- Foto
- Usuário (e-mail)
- Senha
- Peso
- Altura

\> A entidade Usuário não possui relacionamento direto com Exercícios ou Categorias.



## 7. Requisitos

Para executar os códigos localmente, você precisará:

- [Java JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Banco de dados [MySQL](https://dev.mysql.com/downloads/)
- [STS](https://spring.io/tools)
- [Insomnia](https://insomnia.rest/download) ou [Postman](https://www.postman.com/)



## 8. Como Executar o projeto no STS

### 8.1. Importando o Projeto

1. Clone o repositório do Projeto [FitAcademy](https://github.com/Grupo-05-Turma-Java-85/academia_fithub-backend.git) dentro da pasta do *Workspace* do STS

```
git clone https://github.com/Grupo-05-Turma-Java-85/academia_fithub-backend.git
```

2. Abra o **Spring Tools Suite (STS)**

3. Acesse:

```
File → Import
```

4. Selecione:

```
General → Existing Projects into Workspace
```

5. Escolha a pasta onde o projeto foi clonado

6. Clique em **Finish**



### 8.2. Executando a aplicação

1. Abra a aba **Boot Dashboard**
2. Localize o projeto **FitAcademy**
3. Clique em:

```
Start or Restart
```

4. Aguarde a inicialização no console do STS



Caso a aplicação seja iniciada corretamente, a API estará disponível em:

```
http://localhost:8080
```



## 9. Testando os recursos

A API pode ser testada utilizando ferramentas como:

- *Insomnia*
- *Postman*



### 🏋️‍♀️ Recursos de Exercícios

| Método | Recurso                   | Descrição                                              |
| ------ | ------------------------- | ------------------------------------------------------ |
| GET    | `/exercicios`             | Lista todas os exercícios.                             |
| GET    | `/exercicios/{id}`        | Busca exercício específico por ID.                     |
| GET    | `/exercicios/nome/{nome}` | Busca exercício cujo nome contenha o termo pesquisado. |
| POST   | `/exercicios`             | Cadastra um novo exercício.                            |
| PUT    | `/exercicios`             | Atualiza os dados de um exercício existente.           |
| DELETE | `/exercicios/{id}`        | Remove um exercício.                                   |

Exemplos de requisições:

1. Buscar todos os exercícios

   http GET http://localhost:8080/exercicios



### 🗂️ Recursos de Categorias

| Método | Recurso                   | Descrição                                              |
| ------ | ------------------------- | ------------------------------------------------------ |
| GET    | `/categorias`             | Lista todas as categorias.                             |
| GET    | `/categorias/{id}`        | Busca categoria específica por ID.                     |
| GET    | `/categorias/nome/{nome}` | Busca categoria cujo nome contenha o termo pesquisado. |
| POST   | `/categorias`             | Cadastra uma nova categoria.                           |
| PUT    | `/categorias`             | Atualiza os dados de uma categoria existente.          |
| DELETE | `/categorias/{id}`        | Remove uma categoria.                                  |

Exemplos de requisições:

1. Buscar categoria por ID

   http GET http://localhost:8080/categorias/2



### 👤 Recursos de Usuários

| Método | Recurso                       | Descrição                                             |
| ------ | ----------------------------- | ----------------------------------------------------- |
| GET    | `/usuarios/all`               | Lista todos os usuários.                              |
| GET    | `/usuarios/{id}`              | Busca usuário específico por ID.                      |
| GET    | `/usuarios/usuario/{usuario}` | Busca usuário específico por Usuário (e-mail).        |
| GET    | `/usuarios/imc/{id}`          | Retorna o IMC do usuário específico por ID.           |
| POST   | `/usuarios/cadastrar`         | Cadastra um novo usuário.                             |
| POST   | `/usuarios/logar`             | Autentica um usuário pelo usuário (e-mail) e a senha. |
| PUT    | `/usuarios/atualizar`         | Atualiza os dados de um usuário existente.            |

Exemplos de requisições:

1. Logar usuário

   http POST http://localhost:8080/usuarios/logar



## 9. Contribuição

Este repositório é parte de um projeto educacional, mas contribuições são sempre bem-vindas! Caso tenha sugestões, correções ou melhorias, fique à vontade para:

- Criar uma **issue**
- Enviar um **pull request**
- Compartilhar com colegas que estejam aprendendo Java!



## 10. Contato

Desenvolvido por [**Grupo 05 - Turma Java 85**](https://github.com/Grupo-05-Turma-Java-85)

Para dúvidas, sugestões ou colaborações, entre em contato via GitHub ou abra uma issue!

🏃‍♀️ Obrigada por visitar o projeto!