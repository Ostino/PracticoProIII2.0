import java.awt.*;

public class DibujoLineaOrd implements  IDibujador {

    private Linea modelo;
    private int x=50;

    public DibujoLineaOrd(Linea linea) {
        modelo = linea;
    }

    @Override
    public void dibujar(Graphics g) {
        for (int i = 0; i < modelo.arreglo.length; i++) {
            g.setColor(Color.green);
            g.drawLine(x, 0, x, modelo.getArreglo()[i].getTamano());
            x = x + 3;
        }
    }
}
