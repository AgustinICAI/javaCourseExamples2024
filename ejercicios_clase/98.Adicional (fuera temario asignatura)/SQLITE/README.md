# Utilización de librerías de terceros

## sqlite-jdbc-3.30.1 como librería para trabajar con sqlite

### Compilación
```java
//LINUX MAC
javac -cp ./lib/sqlite-jdbc-3.30.1.jar ./src/es/icai/sqliteExample/*.java -d "dist"
//WINDOWS
javac -cp .\lib\sqlite-jdbc-3.30.1.jar .\src\es\icai\sqliteExample\*.java -d "dist"
```

### Ejecución
```java
//LINUX MAC
java -cp ./lib/sqlite-jdbc-3.30.1.jar:./dist/ es.icai.sqliteExample.Main
//WINDOWS
Igual pero con las contrabarras y con punto y coma para separar en CP

```
