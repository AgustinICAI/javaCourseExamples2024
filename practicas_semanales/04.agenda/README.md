## Práctica 04. Java Básico. Interfaz del objeto: equals(), toString().
### Crear una agenda que gestione personas.

#### Funcionalidad

Desarrollar un programa Java de consola (no gráfico) que muestre un menú al usuario proporcionando un conjunto de opciones. La opción introducida por el usuario se leerá por teclado gracias a la clase que se proporciona: Leer (copiar al directorio de la práctica).
Es muy importante utilizar una *clase Gestora*. En la clase App sólo tiene que existir lógica propia de la interacción del usuario con la consola. En clase gestora no puede existir nunca lógica de la interacción con el usuario.

- Es obligatorio para las opciones del menú la utilización de *enums*

Las opciones que se mostrarán al usuario para trabajar con la agenda, serán:

1. Crear ocurrencias de la clase Persona introduciendo la información por teclado. Posteriormente, se insertarán dichas ocurrencias en un array. Tendrá que existir un control de que que no se llega al máximo tamaño del array.
2. Buscar personas en dicho array, devolviendo la posición que ocupa. Para ello se pedirá la información necesaria para utilizar el método *public boolean equals(Object o)* declarado en Object. En este caso, dos persona serán iguales cuando coincida su DNI. Se deberá delegar en la clase Persona y que ella decida cuando dos objetos son iguales.
3. Eliminar una persona. Para esta acción, se reutilizará el código codificado en el punto anterior para localizar a los objetos. Una vez borrada, será necesario compactar la agenda.
4. Modificar una persona concreta. Las forma de modificar una persona será modificando los valores de sus atributos, no reemplazando el objeto por otro.
5. Vaciar la Agenda.
6. Mostrar el contenido del array implementando el método *toString* de la Agenda.

![alt text](https://raw.githubusercontent.com/AgustinICAI/javaCourseExamples2022/master/06p4.Agenda/diagramaCasosUso.jpg)

Diagrama de Casos de Uso

![alt text](https://raw.githubusercontent.com/AgustinICAI/javaCourseExamples2022/master/06p4.Agenda/diagramaSecuencia.jpg)

Diagrama de Secuencia
