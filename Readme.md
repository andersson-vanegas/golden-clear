**COMO EJECUTAR ESTE PROYECTO**


LINKS:
SWAGGER: http://localhost:8084/doc/swagger-ui/index.html
EUREKA: http://localhost:8761/


DESCRIPCION DEL PROYECTO:

crud de productos con una arquitectura  de carpetas hexagonal permitiendo
visualizar las diferentes logicas para manejar un servicio mas flexible
uso de herramientas como :
-swagger
-eureka
-map struct con fines de conectar los campos entre entidades y modelos

PASOS: 

1) CREACION DE LA BASE DE DATOS DE POSTGRES

lo realice con una base de datos postgres para agregarle un poco de dificultad 
a la prueba, por favor crea una base de datos poostgres en PgAdmin con estos datos

NAME_DATABASE: db_products
USERNAME: postgres
PASSWORD: postgrest
URL : jdbc:postgresql://localhost:5432/db_products

2) EJECUTAR MICROSERVICIO DE PRODUCTOS

el tener el servicio de Eureka inicializado y la base de datos creada,
ejecuta el servicio de productos y este se encargara de crear la tabla necesaria 
para funcionar correctamente

3) FUNCIONAMIENTO DE PETICIONES

he dejado un archivo llamado "Products.postman_collection.json" que contiene
las rutas y los request para hacer las peticiones desde postman o si prefiere
se puede comprobar el funcionamiento de este desde postman