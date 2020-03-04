package dataBase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import static dataBase.ChildrenDAO.childrenInsertDB;


public class ChildrenService {

    public static void childrenInsert() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");
        String str;
        DataChildren dataChildren = new DataChildren();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el DNI del niño");
        dataChildren.setDniChildren(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Ingrese nombre");
        dataChildren.setNameChildren(scanner.nextLine());
        System.out.println("Ingrese apellido");
        dataChildren.setSurnameChildren(scanner.nextLine());
        System.out.println("Ingrese fecha de nacimiento (aaaa-mm-dd)");
        dataChildren.setBirthday(scanner.nextLine());
        System.out.println("Ingrese fecha de ingreso (dd/mm/aaaa)");
        dataChildren.setDateIn(scanner.nextLine());
        System.out.println("Ingrese el sexo (femenino/masculino)");
        dataChildren.setSex(scanner.nextLine());
        System.out.println("Ingrese si es regular o no (si/no)");
        dataChildren.setRegular(scanner.nextLine());

        childrenInsertDB(dataChildren);

    }
}
