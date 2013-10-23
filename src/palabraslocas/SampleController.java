/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palabraslocas;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javax.swing.JOptionPane;


/**
 *
 * @author usuario
 */
public class SampleController implements Initializable, Runnable {
    
    @FXML
    public Text labelgame;
    public TextField txtRespuesta;
    public Button Reiniciar;
    public AnchorPane Anchorpane;
    public Text Duracion;
    public String colores[]={"AZUL","VERDE","AMARILLO","NEGRO","BLANCO","ROJO","NARANJA","GRIS","ROSADO","MARRON"};
    public Color color[]={Color.BLUE,Color.GREEN,Color.YELLOW,Color.BLACK,Color.WHITE,Color.RED,Color.ORANGE,Color.GRAY,Color.PINK,Color.BROWN};
    public int vidas=3;
    public Label nivel;
    public Label puntaje;
    public int puntuacion;
    public int level=1;
    public int tiempo=2000;
    public int c;
    public Text vida;
    public int puntos;
    int seleccionada=1,seleccionada1=0;
    Thread t;
    int y=0;
    int x=0;
    int i=0;
    int ms=0;
    int medios=0;
    int mediomedios=0;
    private AnimationTimer timer=new AnimationTimer() {

        @Override
        public void handle(long l) {
                    i++;
                    medios++;
                    mediomedios++;
                if(vidas<=0){
                        try {
                            vida.setText("0");
                            JOptionPane.showMessageDialog(null, "PERDISTE EL JUEGO SALDRA EN 3 SEGS!");
                            System.out.println("PERDISTE");
                            Thread.sleep(3000);
                            System.exit(0);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SampleController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                String cero = null;
                String mins;
                
                if(mediomedios==15 && tiempo==250){
                    if(seleccionada1==seleccionada && tiempo==0.25*1000 && c==0){
                        vidas=vidas-1;
                        vida.setText(""+vidas);
                }else{
                        if(seleccionada1==seleccionada && tiempo==0.25*1000 && c==1){
                            c=0;
                        }
                    }
                    mediomedios=0;
                }
                if(mediomedios>=15)
                    mediomedios=0;
                if(medios==30 && tiempo==500){
                    if(seleccionada1==seleccionada && tiempo==0.5*1000 && c==0){
                        vidas=vidas-1;
                        vida.setText(""+vidas);
                }else{
                        if(seleccionada1==seleccionada && tiempo==0.5*1000 && c==0){
                            c=1;
                        }
                    }
                    medios=0;
                }
                if(medios>=30)
                    medios=0;
                if(i==60){
                    i=0;
                   x++; 
                   ms++;
                    
                    if(seleccionada1==seleccionada && tiempo==ms*1000 && c==0){           
                          System.out.println("entre primero seg");
                        vidas=vidas-1;
                        vida.setText(""+vidas);
                   }
                    else{
                        if(seleccionada1==seleccionada && tiempo==ms*1000 && c==1){
                            c=0;
                        }      
                    }
                    
                   if(ms>=tiempo/1000)
                   { ms=0; 
                 
                   }            
                   Tiempo();
                    
                    }                
                   if(x==60){
                      x=0;
                      y++;
                   }  
        }
    };
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("VistaJuego.fxml"));       
        Scene scene = new Scene(root);              
        PalabrasLocas.stage.setScene(scene); 
        PalabrasLocas.stage.centerOnScreen();
       
    }
    
    @FXML
    private void handleSalirAction(ActionEvent event){
       
        System.exit(0);
    }
    @FXML
    private void handleEmpezarAction(ActionEvent event){
        //txtRespuesta.setText("ASDSADAS"); 
        t=new Thread(this);
        t.start();
        metTiempo(5);
        //temp.scheduleAtFixedRate(timerTask, 0, tiempo);
    }
    private void Tiempo(){
        
                   String cero="";
                   String mins;
                   
                    if(x<10){
                        if(y==0)
                        {   cero="0"+x;
                            Duracion.setText("00:"+cero);
                        }
                        
                        if(y>0 && y<10){
                        mins="0"+y;
                            cero="0"+x;
             
                        Duracion.setText(mins+":"+cero);
                        }
                        }
                    if(x>=10 && y<10){
                     mins="0"+y;
                     Duracion.setText(mins+":"+x);    
                    }
                    if(y>=10 && x<10){
                     cero="0"+x;
                     Duracion.setText(y+":"+cero);
                    }
                    if(x<10 && y<10){
                      cero="0"+x;
                      mins="0"+y;
                      Duracion.setText(mins+":"+cero);
                    }
                        
                        if(y>=10 && x>=10)
                            Duracion.setText(y+":"+x);        
    }
    //public void palabras(int tiempo){
    
        TimerTask timerTask = new TimerTask() 
     { 
         public void run()  
         {   
             seleccionada= (int)(Math.random()*5);
             seleccionada1= (int)(Math.random()*5);
             labelgame.setText(colores[seleccionada]); 
             labelgame.setFill(color[seleccionada1]); 
            // System.out.println("EL TIEMPO ES=>"+tiempo);
             // System.out.println("PUNTUACION");
             
              if(tiempo==1000){
                 // System.out.println("PASE");
                    temp.cancel();
                    temp.purge();
                    this.cancel();
                    temp1.scheduleAtFixedRate(timerTask1,  0, tiempo);
                }     
         } 
     }; 
        TimerTask timerTask1 =new TimerTask(){
          @Override
          public void run()  
         {  
             seleccionada= (int)(Math.random()*7);
             seleccionada1= (int)(Math.random()*7);
             labelgame.setText(colores[seleccionada]); 
             labelgame.setFill(color[seleccionada1]); 
             //System.out.println("EL TIEMPO ES=>"+tiempo);
             if(tiempo==500){
                    //System.out.println("PASE2");
                    temp1.cancel();
                    temp1.purge();
                    this.cancel();
                    temp2.scheduleAtFixedRate(timerTask2, 0, tiempo);
                }
          
         
         }
        };
                TimerTask timerTask2 =new TimerTask(){
          @Override
          public void run()  
         {   
             seleccionada= (int)(Math.random()*8);
             seleccionada1= (int)(Math.random()*8);
             labelgame.setText(colores[seleccionada]); 
             labelgame.setFill(color[seleccionada1]);
             
             if(tiempo==250){
                    //System.out.println("PASE3");
                    temp2.cancel();
                    temp2.purge();
                    this.cancel();
                    temp3.scheduleAtFixedRate(timerTask3, 0, tiempo);
                }
            
         
       
         }
        };
         TimerTask timerTask3 =new TimerTask(){
          @Override
          public void run()  
         {   
             seleccionada= (int)(Math.random()*10);
             seleccionada1= (int)(Math.random()*10);
             labelgame.setText(colores[seleccionada]); 
             labelgame.setFill(color[seleccionada1]); 
             //System.out.println("EL TIEMPO ES=>"+tiempo);
         }   
             
        };


      // Aquí se pone en marcha el timer cada segundo. 
     Timer temp = new Timer();
     Timer temp1=new Timer();
     Timer temp2=new Timer();
     Timer temp3=new Timer();
     Timer temp4=new Timer();
    @FXML
    public void adf(ActionEvent event){    
    Reiniciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("You clicked me!");
                puntuacion=0;
                
            }
        });
    }
    @FXML
    public void AnchorPane(){
        System.out.println("WATDAFAAAQ");
    }
    @FXML
    public void HazClick(MouseEvent e){
        c=0;
        if(e.getClickCount()==1){
            if(seleccionada==seleccionada1){
                c++;
                System.out.println("----------->¡BIEN!<------------");
                if(tiempo==2000){
                metTiempo(5);
                }
                if(tiempo==1000){
                metTiempo(7);    
                }
                if(tiempo==500){
                metTiempo(8);    
                }
                if(tiempo==250){
                metTiempo(10);    
                }
                puntos=puntos+10;
                if(puntos==50){
                    vidas=vidas+1;
                    puntos=0;
                }
                puntuacion=puntuacion+10;
                puntaje.setText("Puntuacion= "+puntuacion);
                if(puntuacion==50){
                    nivel.setText("Nivel 2");
                    vida.setText(""+vidas);
                    tiempo=1000;
                    System.out.println("TIEMPO ES=>"+tiempo);
                }
                if(puntuacion==100){
                    nivel.setText("Nivel 3");
                    vida.setText(""+vidas);
                    tiempo=500;
                }
                if(puntuacion==150){
                    nivel.setText("Nivel 4<=GOD ");
                    vida.setText(""+vidas);
                    tiempo=250;
                }
                
            }
            else{
                System.out.println("------------->MAL!<-------------");
                if(tiempo==2000){
                metTiempo(5);
                }
                if(tiempo==1000){
                metTiempo(7);    
                }
                if(tiempo==500){
                metTiempo(8);    
                }
                if(tiempo==250){
                metTiempo(10);    
                }
                vidas=vidas-1;
                    vida.setText(""+vidas);
                if(vidas<=0){
                    System.out.println("VIDAS=>"+vidas);
                    vida.setText(""+vidas);
                    vida.setText(""+0);
                    JOptionPane.showMessageDialog(null, "PERDISTE! EL JUEGO SE SALDRA EN 3 SEGS!");
                    vidas=3;
                    nivel.setText("Nivel 1");
                    tiempo=2000;
                    puntaje.setText("Puntaje");
                    nivel.setText("Nivel 1");
                    timer.stop();
                    labelgame.setFill(Color.BLACK);
                    labelgame.setText("Colores Locos");  
                    try {
                        Thread.sleep(3000);
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SampleController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Duracion.setText("00:00"); 
                    
                }
            }
        }
        else {
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("pal los panas que es lo tuyo");
    }    

    @Override
    public void run() {
            
        timer.start();
        //System.out.println("WATDAFOWE");
    }
    boolean saber=false;
    boolean saber1=false;
    boolean saber2=false;
    boolean saber3=false;
    boolean saber4=false;
    public void metTiempo(final int tamaño){
            temp.purge();
              //      temp=new Timer();
                    timerTask=new TimerTask() {
                        @Override
                        public void run() {
             seleccionada= (int)(Math.random()*tamaño);
             seleccionada1= (int)(Math.random()*tamaño);
             labelgame.setText(colores[seleccionada]); 
             labelgame.setFill(color[seleccionada1]);  
              if(tiempo==1000 && saber==false){
                  //System.out.println("TIEMPO2=>"+tiempo);
                    saber=true;
                    temp.scheduleAtFixedRate(timerTask, 0, tiempo); 
                    metTiempo(7);
                         } 
              if(tiempo==500 && saber1==false){
                  //System.out.println("TIEMPO3=>"+tiempo);
                    saber1=true;
                    temp.scheduleAtFixedRate(timerTask, 0, tiempo); 
                    metTiempo(8);
                         }
              if(tiempo==250 && saber4==false){
                  //System.out.println("TIEMPO4=>"+tiempo);
                    saber4=true;
                    temp.scheduleAtFixedRate(timerTask, 0, tiempo); 
                    metTiempo(10);
              }                                       
                        
                        }
                    };
             System.out.println("TIEMPO PA LOS PANAS=>"+tiempo);  
                  if(tiempo==2000 && saber3==false){
                  System.out.println("TIEMPO1=>"+tiempo);
                  temp.scheduleAtFixedRate(timerTask, 0, tiempo);
                  saber3=true;
                  metTiempo(5);
              }
  
               
    }
}
