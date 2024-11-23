import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Aeropuertos extends JFrame {
    private JList AEROlist1;
    private JList Compañialist2;
    private JList Vuelolist3;
    private JButton CONTINUARButton;
    private JButton SALIRButton;
    private JPanel Aeropuerto;
    ConectBaseDatos conectBaseDatos = new ConectBaseDatos();
    public static Object aeroppuertoS;
    public static Object CompaniaS;
    public static Object VueloS;

    public Aeropuertos() {
        setTitle("Interfaz de registro");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setContentPane(Aeropuerto);


        conectBaseDatos.MostrarAeropuertos();
        AEROlist1.setModel(conectBaseDatos.ModeloAeropuertos);
        AEROlist1.setVisible(true);


        AEROlist1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount() == 2) {
                    aeroppuertoS = AEROlist1.getSelectedValue();
                    JOptionPane.showMessageDialog(Aeropuerto,
                            "Aeropuerto Seleccionado",
                            "Registro Exitoso",
                            JOptionPane.INFORMATION_MESSAGE);
                    conectBaseDatos.MostrarCompanias();
                    Compañialist2.setModel(conectBaseDatos.ModeloCompanias);
                    Compañialist2.setVisible(true);
                }
            }
        });
        Compañialist2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount() == 2) {
                    CompaniaS = Compañialist2.getSelectedValue();
                    JOptionPane.showMessageDialog(Aeropuerto,
                            "Compañia Seleccionada",
                            "Registro Exitoso",
                            JOptionPane.INFORMATION_MESSAGE);
                            conectBaseDatos.MostrarVuelos();
                    Vuelolist3.setModel(conectBaseDatos.ModeloVuelo);
                    Vuelolist3.setVisible(true);
                }
            }
        });

        Vuelolist3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount() == 2) {
                    VueloS = Vuelolist3.getSelectedValue();
                    JOptionPane.showMessageDialog(Aeropuerto,
                            "Vuelo Seleccionado",
                            "Registro Exitoso",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        CONTINUARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(aeroppuertoS != null) {

                if(CompaniaS != null) {

                    if(VueloS != null) {
                        AEROlist1.setSelectedValue(aeroppuertoS, true);
                        Compañialist2.setSelectedValue(CompaniaS, true);
                        Vuelolist3.setSelectedValue(VueloS, true);
                        Final fin = new Final();
                        fin.setVisible(true);
                        dispose();

                    }else {
                        JOptionPane.showMessageDialog(Aeropuerto,
                                "No has seleccionado un vuelo (doble click para seleccionar)",
                                "Advertencia",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }else {
                    JOptionPane.showMessageDialog(Aeropuerto,
                            "No has seleccionado una Compañia  (doble click para seleccionar)",
                            "Advertencia",
                            JOptionPane.WARNING_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(Aeropuerto,
                        "No has seleccionado un Aeropuerto (doble click para seleccionar)",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        });
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Interfazone interfazone = new Interfazone();
                interfazone.setVisible(true);
                dispose();

            }
        });
    }

}
