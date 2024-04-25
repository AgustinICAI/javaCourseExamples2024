Compilar con paquetes y dejar output en otra ruta
```
javac ./examen2023/domain/* ./examen2023/ui/* ./examen2023/util/* -d "../dist"
```

Ejecutar clases que no están en el mismo directorio usando el flag de classpath "-cp"
```
java -cp "dist" examen2023.ui.JBloques
```

Ejecutar un jar
```
java -jar juego.jar
```

