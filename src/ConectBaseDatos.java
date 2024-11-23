import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ConectBaseDatos {

    ArrayList Aeropuertos = new ArrayList();
    DefaultListModel  ModeloAeropuertos = new DefaultListModel();

    ArrayList Companias = new ArrayList();
    DefaultListModel  ModeloCompanias = new DefaultListModel();

    ArrayList Vuelo = new ArrayList();
    DefaultListModel  ModeloVuelo = new DefaultListModel();


    static String url = "jdbc:mysql://82.197.82.62:3306/u984447967_op2024b";
    static String user = "u984447967_unipaz";
    static String pass = "estudiantesPoo2024B.*";

    public static Connection conexion()
    {
        Connection Basedatos=null;
        try
        {
            Basedatos= DriverManager.getConnection(url,user,pass);
            System.out.println("Conexión exitosa");
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

        return Basedatos;

    }

    public boolean DatosPasajero( int idPasajero, String nombrepasajero, String pasaportePa, String nacionalidad){
        String Registro = "INSERT INTO  u984447967_op2024b.pasajeros (idPasajero, nombre, pasaporte, nacionalidad) VALUES (?,?,?,?)";
        try {
            Connection Basedatos= conexion();
            PreparedStatement ps = Basedatos.prepareStatement(Registro);
            ps.setInt(1, idPasajero);
            ps.setString(2, nombrepasajero);
            ps.setString(3, pasaportePa);
            ps.setString(4, nacionalidad);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario registrado");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario " + e.getMessage());
            e.printStackTrace();
            return false;
        }


    }

    public Aeropuertos MostrarAeropuertos(){
        String Aero = "SELECT * FROM u984447967_op2024b.aeropuertos LIMIT 8";
        try {
            Connection Basedatos= conexion();
            PreparedStatement ps = Basedatos.prepareStatement(Aero);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idAeropuerto");
                String nombre = rs.getString("nombre");
                String ciudad = rs.getString("ciudad");
                String pais = rs.getString("pais");
                int privado = rs.getInt("privado");
                int publico = rs.getInt("publico");
                int subvencion = rs.getInt("subvencion");
                if(privado == 1){
                    Aeropuertos.add("Aeropuerto Privado: " + "ID" + id + " " + nombre +  "Ubicado en: " + pais + " / " +
                            ciudad + " " );
                }else if (publico == 1){
                    Aeropuertos.add("Aeropuerto Publico: " + "ID" + id + " " + nombre +" " +"Ubicado en: " + pais + " / " +
                            ciudad + " " + subvencion );
                }

            }

            for (int i = 0; i < Aeropuertos.size() ; i++) {
                ModeloAeropuertos.addElement(Aeropuertos.get(i));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar Aeropuertos " + e.getMessage());
            e.printStackTrace();

        }
        return null;
    }

    public Aeropuertos MostrarCompanias(){
        String MostrarCompania = "SELECT * FROM u984447967_op2024b.companias LIMIT 4";
        try {
            Connection Basedatos= conexion();
            PreparedStatement ps = Basedatos.prepareStatement(MostrarCompania);
            ModeloCompanias.removeAllElements();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idCompania");
                String nombre = rs.getString("nombre");
                Companias.add("ID: " +id +" Compañias: " + nombre);
            }
            for (int i = 0; i <Companias.size() ; i++) {
                ModeloCompanias.addElement(Companias.get(i));
            }

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar las Compañias " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public Aeropuertos MostrarVuelos(){
        String MostrarVuelos = "SELECT * FROM u984447967_op2024b.vuelos LIMIT 4";
        try {
            Connection Basedatos= conexion();
            PreparedStatement ps = Basedatos.prepareStatement(MostrarVuelos);
            ModeloVuelo.removeAllElements();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idVuelo");
                String identificador = rs.getString("identificador");
                String ciudadOrigen = rs.getString("ciudadOrigen");
                String ciudadDestino = rs.getString("ciudadDestino");
                String precio = rs.getString("precio");
                String numMaxPasajero = rs.getString("numMaxPasajeros");
                Vuelo.add("ID" + id + " Identificador: " + identificador + " " + " Ciudad Origen: " + ciudadOrigen +
                        " " + " Ciudad Destino: " + ciudadDestino + " " + " Precio : " + precio + " " +
                        " Numero Maximo de Pasajeros: " + numMaxPasajero);
            }
            for (int i = 0; i <Vuelo.size() ; i++) {
                ModeloVuelo.addElement(Vuelo.get(i));
            }

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar Vuelos " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
