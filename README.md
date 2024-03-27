# Ponto Inteligente (Teste)

## Minhas observações

- O projeto não possui testes unitários, pois o foco foi apenas mostrar a implementação da funcionalidade.
- Ja deixei um banco de dados populado dentro do projeto para facilitar os testes.
- As tabelas estavam todas em Português, então mantive o padrão e deixei as classes e metodos em Português.

## Arquitetura do Projeto
- Existe o caso de estranhar a estrutura do projeto, pois o mesmo foi desenvolvido utilizando uma ideia de arquitetura hexagonal, onde a aplicação é dividida em camadas, sendo elas: domínio e infraestrutura.
- O projeto foi desenvolvido utilizando a ideia de arquitetura hexagonal mas sem levar ao pé da letra, onde a aplicação é dividida em camadas, sendo elas: domínio e infraestrutura.
- A camada de domínio é responsável por conter as regras de negócio da aplicação visando ao maximo a independência de frameworks e bibliotecas.
- A camada de infraestrutura é responsável por conter as implementações das interfaces definidas na camada de domínio, como por exemplo, a implementação de um repositório. Também é responsável por conter os controllers da aplicação.

## Descrição do Projeto

O projeto tem a finalidade de mostrar um relatorio de horas trabalhadas por um funcionário.

## Funcionalidades

Existe apenas uma funcionalidade que é a de mostrar o relatório de horas trabalhadas.

## Como rodar o projeto

1. Clone o projeto
2. Abra o projeto no Intellij ou em qualquer IDE que suporte Java
3. Execute o docker-compose para subir o banco de dados
4. Execute o projeto com o comando `mvn spring-boot:run`
5. Na consulta de teste pode ser feita a requisição GET para `localhost:8080/relatorio/relatorioPonto?dataInicio=01/03/2019&dataFim=10/03/2019&cpfColaborador=00187832013` para obter o relatório de horas trabalhadas.

