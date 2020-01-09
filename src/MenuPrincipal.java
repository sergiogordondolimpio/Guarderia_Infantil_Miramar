import java.util.Scanner;

public class MenuPrincipal {

    public static void showMenu(){
        System.out.println("Bienvenido a Taller");
        int opcion = 0;
        char respuesta;

        do {
            System.out.println("Opciones:" +
                    "\n 1- Ingresar niño" +
                    "\n 2- Ver lista de niños" +
                    "\n 3- Salir");
            //obtiene el dato del teclado
            Scanner sc = new Scanner(System.in);
            opcion = Integer.valueOf(sc.nextLine());

            switch (opcion){
                case 1 :
                    //ingresarNiño();
                    break;
                case 2 :
                    //listaNiños();
                    break;
                case 3:
                    System.out.println("Desea salir? s/n");


                    do {
                        respuesta = sc.next().charAt(0);
                        if (respuesta == 'n') {
                            opcion = 0;
                        } else if (respuesta != 's') {
                            System.out.println("Ingrese la opcion correcta s/n");
                        }
                    }while (respuesta != 's' && respuesta != 'n');

            }

        }while (opcion != 3);
    }

}
