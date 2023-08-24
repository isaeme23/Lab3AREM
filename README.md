# AREMFlix
![](https://img.shields.io/badge/tested%20with-junit-green) ![](https://img.shields.io/badge/using-maven-lightblue
) ![](https://img.shields.io/badge/status-extensible-lightgreen
)

Esta es una API construida para conseguir informacion sobre peliculas almacenadas en [OMDBApi](https://www.omdbapi.com/).
Te mostrará informacion como el titulo, poster, director de la pelicula y mas!

### ¿Qué necesito para usar este proyecto?
Antes de poder descargar este proyecto, necesitas tener lo siguiente:

- Git
- Maven
- Java

### ¿Como puedo usar este proyecto?
Primero, debes descargar el contenido de este repositorio usando el siguiente comando en tu terminal local
``` 
git clone https://github.com/isaeme23/AREMflix.git
```
Despues para compilar el contenido, usaremos la siguiente linea para compilar
``` 
mvn package
``` 
Y por ultimo, para ver su funcionamiento usaremos
``` 
mvn exec:java
``` 
La funcionalidad del codigo la podremos ver a traves del puerto 35000. En nuestro navegador pordremos verlo escribiendo
**localhost:35000**. Nos encontraremos con la siguiente informacion:

![](/img/img1.png)

En el espacio en donde se nos permite escribir un nombre de una pelicula, podremos colocar cualquier ejemplo para poder
ver que informacion tenemos disponible sobre la pelicula:

![](/img/img2.png)

## Documentación
Para generar la documentacion de este proyecto solo debes ejecutar la siguiente linea en la terminal
``` 
mvn javadoc:javadoc
```
Despues, en la ruta ```./target/site/apidocs``` podras encontrar la documentacion de este proyecto.

## Arquitectura
A continuacion encontramos la arquitectura sugerida para construir este proyecto:

![](/img/arquitectura.png)

Se divide en 3 partes importantes:

- **External REST API:** Esta es la API provista en [OMDBApi](https://www.omdbapi.com/) y de la que se establece la
conexion en la clase OMDBAPIClient.
- **Web Server with REST API Facade:** Construida de forma local mediante las clases almacenadas en las carpetas de
controller, service y persistence.
- **JS Web Client:** Establecida por la clase HttpServer en donde se construye la vista de la aplicacion que es en donde
el usuario interactua con la API.

## Diseño
- **Extensible:** Los componentes de la arquitectura estan divididos por lo que agregar nuevos componentes no debe
suponer cambiar lo que ya se habia desarrollado. Si se quiere agregar algun tipo de controlador o servicio se puede agregar
al proyecto sin mayores cambios.
- **Modularización:** Los componentes del proyecto estan divididos en carpetas que continen lo siguiente:
  1. Persistencia: Almacenamiento del proyecto que en este caso funciona como cache.
  2. Servicio: Es el puente de comunicacion entre controlador y persistencia.
  3. Controlador: Se comunica con la API externa.


## Autores
Isabella Manrique :basecampy: :computer:

## Licencia
*GNU General Public License*

## Agradecimientos
- Profesor Luis Daniel Benavides Navarro

~~Ojala no vuelva a temblar en clase~~

## Referencias

1. [Andy's Tech Tutorials]. (2023, March 6). OMDB (Open Movie Database) API Tutorial [Video]. YouTube. https://www.youtube.com/watch?v=UZtruL7svkc