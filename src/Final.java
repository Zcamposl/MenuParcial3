import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Final extends JFrame {
    private JList DatosR;
    private JButton CONFIRMARCOMPRAButton;
    private JButton CANCELARCOMPRAButton;
    private JPanel Final;
    DefaultListModel registros = new DefaultListModel();
    Aeropuertos aero = new Aeropuertos();
    public Final() {

        setTitle("Interfaz de registro");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setContentPane(Final);

        registros.clear();

        registros.addElement("Registro de Vuelo");
        registros.addElement("");
        registros.addElement("Aeropuerto: ");
        registros.addElement(aero.aeroppuertoS.toString());
        registros.addElement("Compañia: ");
        registros.addElement(aero.CompaniaS.toString());
        registros.addElement("Vuelo: ");
        registros.addElement(aero.VueloS.toString());
        registros.addElement(" ");

        DatosR.setModel(registros);

        CONFIRMARCOMPRAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Compra realizada");
                Interfazone interfazone = new Interfazone();
                interfazone.setVisible(true);
                dispose();
            }
        });
        CANCELARCOMPRAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
