package basededatos;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Leer{
    PreparedStatement ps;
    ResultSet rs;
    public void leerTabla(){
        try{
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();
            ps = conexion.prepareStatement("SELECT * FROM usuarios");
            rs = ps.executeQuery();
            int band = 0;
           
            while(rs.next()){
                band = 1;
                System.out.println("------------------------------------" +
                       "\n Id: " + rs.getInt("id") + 
                       "\n Nombre: " + rs.getString("nombre") +
                       "\n Apellido: " + rs.getString("apellido") +
                       "\n Edad: " + rs.getInt("edad"));
            }
            if(band == 0){
                System.out.println("No hay registros \n");
            }
            conexion.close();
        }catch(Exception ex){
            System.out.println("ERROR" + ex);
        }
  }
}