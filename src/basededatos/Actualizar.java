package basededatos;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Actualizar {
    PreparedStatement ps;
    ResultSet rs;
    
    public void modificar(){
        Scanner input = new Scanner(System.in);
        
        //Datos del alumno//
        int edad, resultado, id;
        String nombre, apellido;
        
        try{
            Conexion con=new Conexion();
            Connection conexion=con.getConnection();
            
            System.out.print("Ingrese el id del alumno a modificar: ");
            id = input.nextInt();
            ps= conexion.prepareStatement("SELECT * FROM usuarios WHERE id="+id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                System.out.println("------------------------------------" +
                       "\n Id: " + rs.getInt("id") + 
                       "\n Nombre: " + rs.getString("nombre") +
                       "\n Apellido: " + rs.getString("apellido") +
                       "\n Edad: " + rs.getInt("edad"));
                
                input.nextLine();
                System.out.println("Ingrese el nuevo nombre: ");
                nombre=input.nextLine();
                System.out.println("Ingrese el nuevo apellido: ");
                apellido=input.nextLine();
                System.out.println("Ingrese la nueva edad: ");
                edad=input.nextInt();
                
                ps= conexion.prepareStatement("UPDATE usuarios SET nombre=?, apellido=?, edad=? WHERE id="+id);
                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setInt(3, edad);
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