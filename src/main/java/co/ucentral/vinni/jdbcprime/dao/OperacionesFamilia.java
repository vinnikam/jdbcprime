package co.ucentral.vinni.jdbcprime.dao;

import co.ucentral.vinni.jdbcprime.modelo.Familia;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Log4j2
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
               log.error("No se puede guardar la familia ", e);
            } finally {
                mc.desconexion(conexActiva);
            }
        }
        return false;

    }
}
