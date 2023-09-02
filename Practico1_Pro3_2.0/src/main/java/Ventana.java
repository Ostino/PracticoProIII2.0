import javax.swing.*;
import java.awt.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ventana extends JFrame {
    private static Logger logger = LogManager.getLogger(Linea.class);
    private JButton reset = new JButton("Reset");
    private JButton play = new JButton("Play");
    private JButton stop = new JButton("Stop");
    private JButton check = new JButton("Check");
    private  Linea modelo = new Linea();

    Panel panel = new Panel(modelo);
    public Ventana() {
        setTitle("Test");
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        this.add(panel);
        panel.setLayout(null);
        panel.add(reset);
        reset.setBounds(150,600,70,24);
        panel.add(play);
        play.setBounds(250,600,70,24);
        panel.add(stop);
        stop.setBounds(350,600,70,24);
        panel.add(check);
        check.setBounds(450,600,70,24);
        panel.setBackground(Color.white);
        this.setVisible(true);
        initcomponent();
    }


    private void initcomponent() {
        reset.addActionListener(e -> {
            modelo.Formatear_arreglo();
            modelo.Anadir_lineas();
        });
        play.addActionListener(e -> {
            modelo.ordenar_arreglo();
            logger.info("Se ordeno el arreglo");

        });
        check.addActionListener(e -> {
            if (modelo.Check() == true){
                JOptionPane.showMessageDialog(null,"Esta ordenado");
            }else{
                JOptionPane.showMessageDialog(null,"Esta desordenado");
            }
        });
    }
    public static void main(String[] args) {
      Ventana test = new Ventana();

    }
}