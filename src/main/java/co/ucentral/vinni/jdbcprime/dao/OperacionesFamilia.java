package co.ucentral.vinni.jdbcprime.dao;

import co.ucentral.vinni.jdbcprime.modelo.Familia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperacionesFamilia implements Operacion<Familia>{

    private final String sqlCrear= "INSERT INTO familia2(descripcion, nombre) VALUES (?, ?)";

    @Override
    public boolean guardar(Familia dato) {

        ManejadorConexiones mc = new ManejadorConexiones();
        Connection conexActiva = mc.conectarse();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlCrear);

                ps.setString(1, dato.getDescripcion());
                ps.setString(2, dato.getNombre());

                int modificados = ps.executeUpdate();
                if (modificados >0 ){
                    return true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                mc.desconexion(conexActiva);
            }
        }
        return false;

    }
}
