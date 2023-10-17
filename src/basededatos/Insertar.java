package basededatos;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class Insertar {
    PreparedStatement ps;
    ResultSet rs;
    
    public void ingresar(){
        Scanner input = new Scanner (System.in);
        
        //Datos del alumno//
        int edad, resultado;
        String nombre, apellido;
        
        try{
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();
            //Ingreso de datos//
            System.out.println("Ingrese el nombre del alumno: ");
            nombre = input.nextLine();
            System.out.println("Ingrese el apellido del alumno: ");
            apellido = input.nextLine();
            System.out.println("Ingrese la edad del alumno: ");
            edad = input.nextInt();
            
            ps = conexion.prepareStatement("INSERT INTO usuarios(nombre, apellido, edad) VALUES(?,?,?)");
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, edad);
            
            resultado = ps.executeUpdate();
            
             if (resultado > 0) {
                System.out.println("Registro ingresado \n");
            } else {
                System.out.println("ERROR al ingresar el registro \n");
            }
            conexion.close();
        }catch(Exception ex){
            System.out.println("ERROR" + ex);
        }
    }
}