## Práctica 03. POO intermedio. Herencia y polimorifismo. 
### Desarrollo de un programa que trabaje con el concepto de herencia, clases abstractas y polimorfismo.

A partir únicamente de la lógica del objeto Cuadrado de la práctica anterior (no hay que tener en cuenta las clases que desarrollan la parte gráfica), realizar un programa que trabaje también con Círculos y los almacene en un array. Los círculos también poseerán unas coordenadas x e y, además del radio.

En esta práctica, cada objeto ya tendrá su propia información de color y relleno, es decir, ya no será común a todos los objetos.

Esta práctica no tendrá interfaz gráfico de usuario (GUI), simplemente se deberán programar las clases que definan la lógica de objetos y una App para mostrar por consola los atributos de los objetos creados.

Se investigará en la API del JDK la forma de trabajar con otros colores (https://docs.oracle.com/javase/9/docs/api/java/awt/Color.html).

Para trabajar con la clase Color se deberá realizar un import en la primera línea de la clase:
```
import java.awt.Color;
```

##### Salida del programa

* AppDibujo01: Crear un array que almacene objetos de tipo Cuadrado y Círculo, invocar el método toString() que devuelva la información de los objetos y mostrarla por consola.
* AppDibujo02: Lo mismo, pero la información aparecerá en pantalla con intervalos de 1 segundo.



