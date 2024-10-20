To-Do List Application

Este proyecto es una aplicación de lista de tareas pendientes (to-do list) desarrollada en Java utilizando Spring Boot y PostgreSQL como base de datos. Sigue una arquitectura hexagonal (puertos y adaptadores), lo que facilita la separación de las capas de dominio, infraestructura y aplicación.

Funcionalidades:

Crear tareas pendientes.

Ver todas las tareas.

Actualizar tareas.

Eliminar tareas.

Buscar tareas por titulo.

Tecnologías utilizadas:

Java 21.

Spring Boot.

PostgreSQL.

Configuración de la base de datos:

1-Crea una base de datos en PostgreSQL:CREATE DATABASE toDo;

2-Configura el archivo application.properties en src/main/resources para establecer la conexión con tu base de datos: spring.datasource.url=jdbc:postgresql://localhost:5432/toDo spring.datasource.username=tu_usuario spring.datasource.password=tu_contraseña spring.jpa.hibernate.ddl-auto=update spring.jpa.show-sql=true

Ejecución del proyecto:

1-Clona el repositorio

2-Construye y ejecuta la aplicación usando Maven La aplicación estará disponible en http://localhost:8080.

Postman:

Created:

curl --location 'http://127.0.0.1:8080/tasks'
--header 'Content-Type: application/json'
--data '{ "title": "Comprar facturas", "description": "ir al super a comprar facturas", "completed": false }'

Get:

curl --location 'http://localhost:8080/tasks'

Updated:

curl --location --request PUT 'http://127.0.0.1:8080/tasks/63bb269b-7746-4b09-8550-bf3ee6ffe01c'
--header 'Content-Type: application/json'
--data '{ "title": "Comprar facturas", "description": "ir al super a comprar facturas", "completed": true }'

Deleted:

curl --location --request DELETE 'http://localhost:8080/tasks/63bb269b-7746-4b09-8550-bf3ee6ffe01c'
--data ''

search tasks by title:

curl --location 'http://localhost:8080/tasks/search?title=Nueva%20Tarea'
--data ''

Estructura del Proyecto:

src

├── main

│ ├── java

│ │ └── com.todolist

│ │ ├── domain # Entidades y lógica de dominio

│ │ ├── application # Casos de uso y servicios

│ │ ├── infrastructure # Repositorios, controladores

│ │ └─starter #Apllication

│ └── resources

│ └── application.properties # Configuraciones de la base de datos

└── test

└── java/com.todolist  # Pruebas unitarias
