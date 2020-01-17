import java.util.Scanner;

public class Respuesta {

    private char respuesta;
    Scanner sc = new Scanner(System.in);

    public char getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(char respuesta) {
        this.respuesta = respuesta;
    }

    public boolean decidir_continuar(char respuesta){
        boolean continuar = false;
        do {

            if (respuesta == 'n') {
               continuar =  false ;
            } else if (respuesta == 's') {
                continuar = true;
            }else{
                System.out.println("Ingrese la opcion correcta s/n");
                respuesta = sc.next().charAt(0);
            }
        }while (respuesta != 's' && respuesta != 'n');

        return continuar;
    }


}
