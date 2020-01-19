import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuPrincipal {

    private int opcion = 0;

    public MenuPrincipal(int opcion) {
        this.opcion = opcion;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }




    public static void showMenu(){
        System.out.println("Bienvenido a Taller Infantil Miramar");
        int opcion = 0;


        do {
            System.out.println("Opciones:" +
                    "\n 1- Ingresar niño" +
                    "\n 2- Ver lista de niños" +
                    "\n 3- Editar niño" +
                    "\n 4- Salir" +
                    "\n\n Ingrese la opcion: \n"
                            );

            //obtiene el dato del teclado
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();


            switch (opcion){
                case 1 :
                    //ingresarNiño();
                    ConectionMySQL conectionMySQL = new ConectionMySQL();
                    try(Connection cnx = conectionMySQL.get_connection()){

                    }catch (SQLException e) {
                        System.out.println(e);
                    } {

                }
                    break;
                case 2 :
                    //listaNiños();
                    break;
                case 3 :
                    //editarNiño();
                    break;
                case 4:
                    System.out.println("Desea salir? s/n");
                    Respuesta respuesta = new Respuesta();
                   if (!respuesta.decidir_continuar(sc.next().charAt(0))) opcion = 5;

                    break;
            }

        }while (opcion != 4);
    }

}
