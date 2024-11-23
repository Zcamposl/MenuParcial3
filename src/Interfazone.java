import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfazone extends JFrame {
    private JTextField Nombre;
    private JTextField Nacion;
    private JTextField Pasapor;
    private JButton SIGUIENTEButton;
    private JButton SALIRButton;
    private JTextField Id;
    private JPanel PanelDeRegistro;
    ConectBaseDatos conectBaseDatos = new ConectBaseDatos();


    public Interfazone() {
        setTitle("Interfaz de registro");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setContentPane(PanelDeRegistro);


        SIGUIENTEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conectBaseDatos.DatosPasajero(Integer.parseInt(Id.getText()), Nombre.getText(), Nacion.getText(), Pasapor.getText());
                JOptionPane.showMessageDialog(null, "Registro Actualizado Correctamente");

                Aeropuertos aeropuertos = new Aeropuertos();
                aeropuertos.setVisible(true);
                dispose();
            }
        });


        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Interfazone frame = new Interfazone();
                frame.setVisible(true);
            }
        });

    }
}

