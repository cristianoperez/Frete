# Frete #
Serviço rest que retorna o caminho de entrega, valor e distancia percorrida de um determinado ponto ao outro.

# Rodando a aplicação

A porta padrão da aplicação é a 8080


IDE

Importe o projeto e rode a classe

br.com.cristiano.app.Application


MAVEN

mvn spring-boot:run


JAR

Utilizando o JAR que se encontra na raiz do projeto execute o comando

java -jar 'PATH'/Frete.jar


# Tecnologias utilizadas #

Java 1.8

Derby

Spring Boot

Maven

JaxRS (Jersey)

Hibernate

Junit

Tomcat

#EndPoints

Path: "/malha"

Metodo: POST

Parametros (x-www-form-urlencoded): 
  "origem"
  "destino"
  "distancia"
  
Descrição: Salva a malha no banco de dados



-

Path: "/malha"

Metodo: GET

Descrição: Retorna toda a malha do banco

Exemplo: http:localhost:8080/malha

-

Path: "/malha"

Metodo: DELETE

Descrição: Apaga todos os registro da tabela malha

-

Path: "/calcular"

Metodo: GET

Parametros: 
  "mapa"
  "origem"
  "destino"
  "autonomia"
  "valorCombustivel"

Descrição: Retorna o Nome do mapa, origem, destino, traijeto a ser percorrido, distancia percorrida, valor gasta de combustivel no percurso

Exemplo: http://localhost:8080/calcular/SP/A/B/10/2

