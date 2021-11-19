package co.ucentral.vinni.jdbcprime;

import co.ucentral.vinni.jdbcprime.dao.ManejadorConexiones;
import co.ucentral.vinni.jdbcprime.dao.OperacionesFamilia;
import co.ucentral.vinni.jdbcprime.modelo.Familia;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Date;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
public class IndexBean {
    public String conectarse(){
        OperacionesFamilia oper = new OperacionesFamilia();
        Familia fam = new Familia();
        fam.setDescripcion("Descrip");
        fam.setNombre("nombre"+new Date());
        if(oper.guardar(fam)){
            System.out.println("Inserto ");
        }else {
            System.out.println("No Inserto ");
        }


        return "";
    }

}
