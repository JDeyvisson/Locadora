
# 🚗 Sistema de Locadora de Carros em Java Web

Um sistema web desenvolvido em **Java** para gerenciamento de uma **locadora de veículos**, utilizando **JSP, Servlets, JPA** e **MySQL**.  
O projeto permite o cadastro e gerenciamento de **usuários**, **veículos** e **reservas**, com interface dinâmica e persistência de dados.

---

## 🧩 Tecnologias Utilizadas

- **Java 17+**
- **Jakarta EE / Servlets / JSP**
- **JPA / Hibernate**
- **MySQL**
- **Apache Tomcat 10**
- **HTML / CSS / JSTL**

---

## ⚙️ Funcionalidades Principais

- Cadastro, listagem, edição e exclusão de **usuários**
- Cadastro e controle de **veículos**
- Controle de **reservas** (incluindo status de veículo reservado)
- Persistência de dados com **JPA**
- Interface web dinâmica com **JSP** e **JSTL**
- Conexão com **banco de dados MySQL**
- Separação em **camadas DAO, Model e Controller**

---

## 🛠️ Configuração do Banco de Dados

1. Crie o banco de dados no MySQL:
   ```sql
   CREATE DATABASE locadora;
   ```

2. Configure o arquivo `persistence.xml` com as credenciais do seu banco:
   ```xml
   <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/locadora"/>
   <property name="jakarta.persistence.jdbc.user" value="root"/>
   <property name="jakarta.persistence.jdbc.password" value="senha"/>
   <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
   ```

---

## 🚀 Como Executar o Projeto

1. Importe o projeto no **Eclipse** ou **IntelliJ IDEA** como um **Dynamic Web Project**.
2. Configure o servidor **Apache Tomcat 10**.
3. Conecte o banco de dados MySQL.
4. Acesse no navegador:
   ```
   http://localhost:8080/locadora
   ```

---
