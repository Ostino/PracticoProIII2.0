import java.awt.*;

public class DibujoLinea implements IDibujador {


    private Linea modelo;

    public DibujoLinea(Linea c) {
        modelo = c;
    }
    public void dibujar(Graphics g) {
        for (int i = 0; i < modelo.getArreglo().length; i++) {
            g.setColor(Color.red);
            g.drawLine(335, 335, modelo.getArreglo()[i].getXf(), modelo.getArreglo()[i].getYf());
        }
    }
}