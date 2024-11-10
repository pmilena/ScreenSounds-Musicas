# Screen Sound Músicas 🎶

Este projeto foi desenvolvido como um desafio para consolidar conhecimentos sobre persistência de dados, mapeamento de entidades e relacionamento entre tabelas em Java. Inspirado no conceito do aplicativo "Alura Musics", o Screen Sound Músicas permite gerenciar um banco de dados de artistas e suas músicas, com funcionalidades de cadastro, listagem e busca.

## 🎯 Objetivo

O objetivo do desafio é criar uma aplicação que simule um sistema de gerenciamento musical, permitindo o cadastro e a pesquisa de músicas e artistas. Além disso, a aplicação é integrada à API do ChatGPT, permitindo realizar pesquisas adicionais sobre artistas antes de cadastrá-los no sistema.

## 📋 Funcionalidades

A aplicação Screen Sound Músicas possui o seguinte menu de funcionalidades:

1. **Cadastrar Artistas** - Permite registrar um novo artista no banco de dados, especificando o nome e o tipo (solo, dupla, banda).
2. **Cadastrar Músicas** - Adiciona uma nova música associada a um artista já cadastrado.
3. **Listar Músicas** - Exibe todas as músicas cadastradas.
4. **Buscar Músicas por Artista** - Pesquisa músicas associadas a um artista específico.
5. **Pesquisar Dados sobre um Artista** - Utiliza a API do ChatGPT para buscar informações sobre um artista antes de seu cadastro.

9. **Sair** - Encerra a aplicação.

## 🗂 Estrutura do Projeto

A estrutura do projeto inclui as seguintes classes e entidades:

- **Artista**: Classe responsável por representar os artistas. Possui atributos como nome e tipo de artista (solo, dupla, banda), utilizando um enum para definir o tipo.
- **Música**: Classe que representa as músicas, vinculando cada uma a um artista.
- **Relacionamento Artista-Música**: Mapeamento de um artista para múltiplas músicas, utilizando anotações para definir a relação de cardinalidade.
- **API do ChatGPT**: Integração para realizar consultas sobre artistas, oferecendo informações adicionais antes de seu cadastro.

## 🚀 Funcionalidades e Usabilidade

A aplicação oferece um menu interativo, onde a pessoa usuária pode:

- **Cadastrar Artistas e Músicas**: A aplicação solicita o nome do artista e o tipo (solo, dupla, banda) e permite o cadastro de músicas associadas ao artista. 
- **Listar**: As músicas podem ser listadas.
- **Pesquisa Integrada**: Usando a API do ChatGPT, é possível consultar dados sobre um artista, como sua biografia e carreira, antes de cadastrá-lo.

## 🛠 Tecnologias Utilizadas

- **Java**: Linguagem principal para desenvolvimento do projeto.
- **PostgreSQL**: Banco de dados utilizado para armazenar dados dos artistas e músicas.
- **JPQL (Java Persistence Query Language)**: Utilizado para consultas no banco de dados relacional, facilitando o mapeamento entre objetos Java e tabelas.
- **Integração com API ChatGPT**: Para consultas sobre artistas.

## 📚 Conceitos Aplicados

- **Relacionamento entre Tabelas**: Implementação de chaves primárias e estrangeiras para vincular artistas e músicas.
- **Persistência de Dados**: Manipulação de dados com operações CRUD (Create, Read, Update, Delete).
- **Mapeamento de Classes**: Uso de anotações para definir o relacionamento entre entidades Artista e Música.
- **Enums**: Utilizado para definir o tipo de artista, facilitando a categorização.
