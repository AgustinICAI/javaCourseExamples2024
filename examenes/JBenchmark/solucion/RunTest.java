public class RunTest{
  private int iteraciones;
  
  public RunTest(Test test, int iteraciones, int size){
  
    this.iteraciones = iteraciones;
    
    
    long inicioNano = System.nanoTime();
    for(int i=0;i<iteraciones;i++){
      test.run(Util.getRandom(size));
    }
    long finNano = System.nanoTime();  
    long nanoTiempo = finNano - inicioNano;
    long tiempo1 = nanoTiempo / iteraciones;                              // Calcula el tiempo medio empleado en una agregación
    System.out.printf("ADD: %.4f\n", tiempo1/1000.);     // Imprime el valor medio en microsegundos (nano/1000.) con 4 decimales (%.4f)
       
  }

}
