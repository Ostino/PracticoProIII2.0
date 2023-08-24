import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.*;
public class Panel extends JPanel implements PropertyChangeListener {
    private Linea modelo;
    public Panel(Linea l) {
        this.modelo = l;
        this.modelo.addObserver(this);
        modelo.Anadir_lineas();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        IDibujador dibujo = new DibujoLinea(modelo);
        dibujo.dibujar(g);

        IDibujador dibujos = new DibujoLineaOrd(modelo);
        dibujos.dibujar(g);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }

}
