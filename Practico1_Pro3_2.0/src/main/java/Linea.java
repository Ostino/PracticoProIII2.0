import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Linea implements  Comparable<Linea>{
    private static Logger logger = LogManager.getLogger(Linea.class);
    private int xf;
    private int yf;
    private int tamano;
    private int a;
    private int b;
    private PropertyChangeSupport observado;
    public   Linea[] arreglo = new Linea[200];

    public Linea(){
        this.xf=generador();
        this.yf=generador();
        logger.info("X:"+ this.xf+" Y :"+this.yf);
        a = Math.abs(xf-335);
        b = Math.abs(yf-335);
        logger.info("A :"+a);
        logger.info("B :"+b);
        tamano= (int) Math.sqrt((a*a)+(b*b));
        observado = new PropertyChangeSupport(this);
    }
    public void addObserver(PropertyChangeListener observador) {
        observado.addPropertyChangeListener(observador);
    }
    public static int generador() {
        Random random = new Random();
        return random.nextInt(50,600) + 1;
    }
    public Linea[] getArreglo() {
        return arreglo;
    }
    public  void Anadir_lineas () {
        Linea[] oldarreglo = this.arreglo;
        for (int i = 0; i < arreglo.length; i++) {
            Linea linea = new Linea();
            arreglo[i] = linea;
        }
        logger.info("Se han añadido las lineas");
        observado.firePropertyChange("Arreglo",oldarreglo, this.arreglo);
    }
    public void Formatear_arreglo() {
        Linea[] oldarreglo = this.arreglo;
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = null;
        }
        logger.info("Se han eliminado las lineas");
        observado.firePropertyChange("Arreglo",oldarreglo, this.arreglo);
    }
    public  void ordenar_arreglo (){
        Arrays.sort(arreglo);
        observado.firePropertyChange("Arreglo",true, false);
    }
    public boolean Check (){
        for (int i = 0; i < arreglo.length-1; i++) {
            if (arreglo[i].getTamano()<=arreglo[i+1].getTamano()){
            }else{
                return false;
            }
        }
        return true;
    }
    public int getXf() {
        return xf;
    }
    public int getYf() {
        return yf;
    }
    public int getTamano() {
        return tamano;
    }
    @Override
    public int compareTo(Linea o) {
        return Integer.compare(this.tamano,o.getTamano());
    }
}