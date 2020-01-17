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
        char respuesta;

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
                    break;
                case 2 :
                    //listaNiños();
                    break;
                case 3 :
                    //editarNiño();
                    break;
                case 4:
                    System.out.println("Desea salir? s/n");

                    do {
                        respuesta = sc.next().charAt(0);
                        if (respuesta == 'n') {
                            opcion = 0;
                        } else if (respuesta != 's') {
                            System.out.println("Ingrese la opcion correcta s/n");
                        }
                    }while (respuesta != 's' && respuesta != 'n');

                    break;
            }

        }while (opcion != 4);
    }

}
