/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palabraslocas;

/**
 *
 * @author usuario
 */
    import javafx.animation.AnimationTimer;
    import javafx.animation.Timeline;
import javafx.scene.text.Text;
    
public final class Timer extends AnimationTimer implements Runnable {
    static Timeline timeline;
    int i=0;
    int x=0;
    int y=0;
    static boolean aux=false;
    public Text Duracion;
    String min="0";
    public Timer(){
        
    }
           /*    AnimationTimer   timer = new AnimationTimer() {         
            @Override
            public void handle(long l) {
             
            }
        };*/
             public  int getSeconds(){
            System.out.println("X ES =>"+x);
            return x;
            }
                  public int getMins(){
        System.out.println("Y ES =>"+y);
            return y;
    }
    @Override
    public void run() {        
        System.out.println("HOLA");
  
}
    public void Empieza(){
        System.out.println("PASE BROTHER");
        this.start();
        
    }
    
    public boolean Empezo(){
        System.out.println("EL AUX TA=>"+aux);
        return aux;
    }

    @Override
    public void handle(long l) {
    
    }
}
