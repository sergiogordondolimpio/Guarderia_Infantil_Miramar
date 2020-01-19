import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionMySQL {

    public Connection get_connection(){
        Connection conection = null;
        /**
         Le agrego excepcion al url para que no aparezca error por TimeZone
         jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
         conectado con MySql Workbrench
         */
        try{
            conection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/taller_infantil_miramar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root","Franc3sca");
            if(conection != null){
                System.out.println("Conexion exitosa");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return conection;
    }

}
