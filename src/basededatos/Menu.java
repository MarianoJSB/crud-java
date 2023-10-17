package basededatos;
import java.util.Scanner;
public class Menu {
    public int opcion;
    public int seleccionar(){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("-----CRUD-----");
        System.out.println("1 - Mostrar registros");
        System.out.println("2 - Ingresar registros");
        System.out.println("3 - Actualizar registros");
        System.out.println("4 - Eliminar registros");
        System.out.println("5 - Salir");
        System.out.println("Eliga una opcion: ");
        opcion = input.nextInt();
        
        return opcion;
}
}