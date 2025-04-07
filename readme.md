# Esta es el entorno necesario para poder hacer correr la aplicacion de cines Hidalgo

## El entorno está separado en 3 zonas, el API, el Docker y el proyecto maven m3Proyecto

1. primero debemos entrar en la carpeta docker y ejecutar en terminal docker compose up, en este docker se encuentra nuestra base de datos, para no competir con el puerto 3306 nuestro docker hace un port fowarding de esta manera usar el puerto *3300* lleva al 3306 del docker

2. Una vez el docker corra debemos levantar el API, por ello desde netbeans abriremos el proyecto y lo ejecutaremos,con darle al play deberia funcionar.
si todo ha salido bien podremos pasar al siguiente punto.

3. Abrimos m3Proyecto con netbeans y ejecutamos, nos llevará a la interfaz gráfica del cine.
- si Gson da problemas deberá descargarse el .jar desde "https://repo1.maven.org/maven2/com/google/code/gson/gson/2.8.8/" y colocarlo en lib/copyLib: actualmente el proyecto funciona con  la v2.8.8 
actualmente solo se tiene desarrollado el uso del API para las peliculas.
Para poder trabajar con ello debemos ir a 'Admin'.
Nos llevará a una vista donde:
    - si clicamos sobre 'Añadir pelicula' se nos abrirá un formulario donde colocar sus datos.
    - si clicamos sobre 'Ver peliculas' nos mostrara las peliculas subidas.

