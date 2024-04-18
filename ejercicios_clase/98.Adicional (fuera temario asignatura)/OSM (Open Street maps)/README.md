# Utilización de librerías de terceros

## jxmapviewer2 como librería para trabajar con mapas de OpenStreetMaps(OSM) y commons-csv para leer un fichero CSV

### Compilación
```java
//LINUX MAC
javac -cp ./lib/commons-csv-1.8.jar:./lib/commons-logging-1.1.3.jar:./lib/jxmapviewer2-2.5.jar ./src/es/icai/coronaSample/*.java -d "dist"
//WINDOWS
javac -cp .\lib\commons-csv-1.8.jar;.\lib\commons-logging-1.1.3.jar;.\lib\jxmapviewer2-2.5.jar .\src\es\icai\coronaSample\*.java -d "dist"
```

#### Copia recursos
```
::LINUX
cp ./src/es/icai/coronaSample/resources/* ./dist/es/icai/coronaSample/*
::WINDOWS
cp .\src\es\icai\coronaSample\resources\* .\dist\es\icai\coronaSample\*
```

### Ejecución
```java
//LINUX MAC
java -cp ./lib/commons-csv-1.8.jar:./lib/commons-logging-1.1.3.jar:./lib/jxmapviewer2-2.5.jar:./dist/ es.icai.coronaSample.JCoronaWindow coronacases_20200330.csv 
//WINDOWS
java -cp .\lib\commons-csv-1.8.jar:.\lib\commons-logging-1.1.3.jar:.\lib\jxmapviewer2-2.5.jar:.\dist\ es.icai.coronaSample.JCoronaWindow coronacases_20200330.csv 

```
