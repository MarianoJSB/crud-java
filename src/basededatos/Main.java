package basededatos;
public class Main {
    public static void main(String[] args) {
        //CRUD//
        Leer read = new Leer();
        Insertar ingresar = new Insertar();
        Actualizar modificar = new Actualizar();
        Eliminar delete = new Eliminar();
        //Menu//
        Menu menu = new Menu();
        int opcion = 0;
        
        while(opcion != 5){
            opcion = menu.seleccionar();
            switch(opcion){
                case 1 : {
                    read.leerTabla();
                    break;
                }
                case 2 : {
                    ingresar.ingresar();
                    read.leerTabla();
                    break;
                }
                case 3 : {
                    modificar.modificar();
                    read.leerTabla();
                    break;
                }
                case 4 : {
                    delete.eliminar();
                    read.leerTabla();
                    break;
                }
                case 5 : {
                    break;
                }
                default : {
                    System.out.println("Opcion incorrecta");
                }
           }

        }
        
    }
}