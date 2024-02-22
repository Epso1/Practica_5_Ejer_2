# Descargador de URLs

## Descripción

Esta aplicación de consola en Java permite al usuario introducir URLs de manera indefinida. Cada URL introducida se añade a un listado y se inicia su descarga en segundo plano. La aplicación utiliza el patrón Observer para notificar a la clase `Downloader` cada vez que se añade una nueva URL al listado.

En la primera versión del programa (Ejercicio 1), cada vez que se añade una nueva URL al listado, se muestra por pantalla el texto: "Se ha iniciado la descarga del archivo URL", donde la URL es la introducida por el usuario.

En la segunda versión del programa (Ejercicio 2), en lugar de mostrar el texto anterior, la aplicación descarga la página web correspondiente a la URL y, una vez descargada completamente, la guarda en un archivo .html en la carpeta raíz del proyecto. Este proceso se realiza utilizando futuros, lo que permite esperar a que la descarga esté completa antes de guardar el archivo, evitando así la creación de archivos corruptos por descargas interrumpidas. En esta versión, el programa no muestra ningún texto ni mensaje, simplemente va pidiendo URLs por pantalla y en segundo plano se van descargando y guardando en el disco duro.
## Requisitos del sistema

- Java 19
- Maven
- IntelliJ IDEA

## Instalación

Para instalar la aplicación en IntelliJ IDEA, siga estos pasos:

1. Clone el repositorio en su máquina local usando `git clone`.
2. Abra IntelliJ IDEA.
3. En la pantalla de inicio de IntelliJ IDEA, haga clic en `Open`.
4. Navegue hasta el directorio del proyecto y haga clic en `OK`.
5. IntelliJ IDEA abrirá y cargará el proyecto.

## Uso

Para ejecutar la aplicación en IntelliJ IDEA, siga estos pasos:

1. En el panel de `Project`, navegue hasta la clase `Main` (`src/main/java/com/example/practica_5_ejer_1/Main.java`).
2. Haga clic con el botón derecho en el archivo `Main.java` y seleccione `Run 'Main.main()'`.
3. Una vez que la aplicación esté en ejecución, aparecen los mensajes: "***** Recolector de URLs *****" y "Introduce '0' para salir del programa.".
4. A continuación se le pedirá que introduzca una URL. Cada vez que se introduzca una URL, la aplicación iniciará su descarga en segundo plano y la guardará en un archivo .html en la carpeta raíz del proyecto una vez que la descarga esté completa.
5. Para salir de la aplicación, simplemente introduzca '0'.

