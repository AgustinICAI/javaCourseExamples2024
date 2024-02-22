public enum OpcionAgenda {
    OTRA_OPCION("0. Otra opcion"),
    CREAR_PERSONA("1. Crear persona"),
    BUSCAR_PERSONA("2. Buscar persona"),
    ELIMINAR_PERSONA("3. Eliminar persona"),
    MODIFICAR_PERSONA("4. Modificar persona"),
    VACIAR_AGENDA("5. Vaciar agenda"),
    MOSTRAR_CONTENIDO("6. Mostrar lista"),
    SALIR("7. Salir");


    private final String descripcion;

    OpcionAgenda(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
