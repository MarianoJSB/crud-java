package basededatos;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Eliminar {
    PreparedStatement ps;
    ResultSet rs;
    
    public void eliminar(){
        Scanner input = new Scanner(System.in);
        
        //Id del alumno a eliminar//
        int id, resultado;
        
        try{
            Conexion con=new Conexion();
            Connection conexion=con.getConnection();
            
            System.out.print("Ingrese el id del alumno a eliminar: ");
            id = input.nextInt();
            ps = conexion.prepareStatement("SELECT * FROM usuarios WHERE id="+id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                ps = conexion.prepareStatement("DELETE FROM usuarios WHERE id="+id);
                resultado = ps.executeUpdate();
            }else{
                System.out.println("No hay ningun registro con ese id");
            }
            conexion.close();
        }catch(Exception ex){
            System.out.println("ERROR" + ex);
        }
    }
}