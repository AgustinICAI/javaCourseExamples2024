public class HiloBoton extends Thread{
    private  int id;
    private JFrameHilos jfh;

    int num;

    HiloBoton(int id , JFrameHilos jfh){
        super();
        this.jfh = jfh;
        this.id = id;
    }

    @Override
    public void run(){
        while (true) {
            jfh.append("hilo " + id + ": Hola, num " + num);
            num += 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }   }

}
