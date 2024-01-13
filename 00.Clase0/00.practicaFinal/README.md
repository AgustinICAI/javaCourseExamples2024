## Práctica Final. Programación Orientada a Objetos. 
### Desarrollo de un software pseudo-comercial con interfaz gráfica 
El alumno podrá elegir entre desarrollar una aplicación Swing que gestione un tipo cualquiera de objeto (A) o desarrollar un JPaint. Ambas aplicaciones tendrán persitencia en disco. 

#### Fecha de entrega:

<span style="color:red;font-weight:bold">Fecha del último examen que tengáis -  ~*15 de mayo*</span>


#### Entregable:

Un fichero ZIP que contenga:
- Proyecto.pdf: Un PDF de una página con los pantallazos más representativos de vuestra aplicación.
- Sources.zip: Un ZIP con los .JAVA (en la estructura de paquetes que se tenga).
- Bin.zip: Un JAR del fichero de ejecución del proyecto con los ficheros y directorios complementarios necesarios.
- Javadoc.zip: Un ZIP con la documentación de JAVADOC. Documentar 10 elementos (clase, atributos o métodos).
- README.txt: Un fichero de texto llamado README.txt con los usuarios, contraseñas o palabras clave a utilizar en el programa. 

Gracias!

#### Descripción de la práctica A:

Desarrollar una aplicación gráfica desarrollada en Swing que gestione un tipo cualquiera de objeto (a elegir por el alumno) con persitencia en disco.

La aplicación a desarrollar debe cumplir con los siguientes requisitos funcionales:

- Altas/Bajas/Modificaciones de objetos.
- Generación de listados en función de dos criterios de filtrado introducidos por el usuario. (P.e: mostrar todas las personas, sólo las que vivan en XXXX o las que vivan XXXX y estén casadas)
- Importación/Exportación de la información del programa a un fichero TXT, XML, JSON o YAML
Es obligatorio emplear nuevos componentes gráficos (JTable, JComboBox, JTabbedPane, etc.) o otras librerías o funcionalidades no vistas en clase.

##### Evaluación de la práctica: Todos los alumnos parten de un 9.0. Nota mínima: 0. Nota máxima: 10.5.

- Funcionalidad: ¿Realiza toda la funcionalidad solicitada? - SI/NO. 
```
    Si (funcionalidadCompleta == NO) nota = 0;
```    
- Funcionalidad: ¿Cubre una necesidad real? ¿Podría llegar a vender/regalar este desarrollo a alguien? - SI/NO. 
```
    Si (necesidadReal == NO) nota -= 3 ptos;
```    
- Funcionalidad: ¿Se utilizan componentes nuevos no impartidos en clase? - SI/NO ¿Cuál es el grado de dificultad que presentan? - (0 -bajo-, 0,75 -medio- ó 1,5 -alto-). 
```
    Si (componentesNuevos == NO) nota = 0; Else nota += gradoDificultad;
```    
bajo: ImageIcon, JComboBox, JTabbedPane, etc.
medio: JList, JCheckBox, JRadioButton, etc.
alto: JTable, JTree, etc.
- Funcionalidad: ¿Presenta algún error de ejecución? 
```
    Si (errores == SI) nota -= 1.5ptos;
```    
- Usabilidad: ¿Se ejecuta/inicia de una forma sencilla para el usuario? 
```
    Si (inicioSencillo == NO) nota -= 1pto
```    
- Usabilidad: ¿Posee una interfaz fácil de utilizar y amigable como las aplicaciones de escritorio que estamos acostumbrados a utilizar (2 -no-, 1 -más o menos- ó 0 -si-)? 
```
    nota -= factorDeUsuabilidad;
```    
- Diseño: ¿El diseño de la práctica sigue con los patrones (MVC, DAO, Experto, etc.) y estrategias (DRY, KISS, etc.) de diseño explicadas en clase? 
```
    Si (diseño == MALO) nota -= 1.5ptos; Else Si (diseño == REGULAR) nota -= 0.75ptos;
```
 

#### Descripción de la práctica B:

Desarrollar una aplicación similar a un JPaint, es decir, una aplicación que pinte distintos tipos de figuras. Además de las figuras Cuadrado y Círculo, se deberá pintar polígonos o figuras libres, es decir, una sucesión de puntos unidos por líneas. el programa deberá poder crear figuras y eliminarlas. También permitirá crear grupos y ocultar figuras/grupos. Por último, deberá guardar en disco los dibujos realizados. 

Se puede entender que por la parte de interfaz gráfico se parecerá a un JPaint, pero por la parte de manipulación de objetos a un Power Point (tratamiento vectorial de elementos).

Deberá realizar de forma obligada las siguientes funciones:
- Selección amigable del color.
- Creación de figuras con el ratón (con la complejidad que cada uno desee).
- Selección de figuras (como cada uno considere).
- Modificación del color de las figuras.

Deberá implementarse al menos, una de las siguientes funciones:
- Selección de figuras con el ratón.
- Movimiento de figuras con el ratón.


#### Descripción de la práctica C:

Práctica que no cumple con los requisitos de las dos anteriores y que ha sido aprobada por el profesor. Por ejemplo, un juego.
