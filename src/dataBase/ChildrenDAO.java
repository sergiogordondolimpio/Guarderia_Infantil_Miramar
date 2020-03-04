package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChildrenDAO {

    //function that insert a child in the database, the values come from the class dataBase.DataChildren
    //with interface in dataBase.ChildrenService
    public static void childrenInsertDB(DataChildren dataChildren){
        ConnectionMySQL connectionMySQL = new ConnectionMySQL();
        try (Connection connection = connectionMySQL.get_connection()) {
            PreparedStatement preparedStatement= null;
            try{
                String query="INSERT INTO taller_infantil_miramar.children (dniChildren, nameChildren, surnameChildren, birthday, dateIn, sex, regular) VALUES (?,?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, dataChildren.getDniChildren());
                preparedStatement.setString(2, dataChildren.getNameChildren());
                preparedStatement.setString(3, dataChildren.getSurnameChildren());
                preparedStatement.setString(4,dataChildren.getBirthday());
                preparedStatement.setString(5, dataChildren.getDateIn());
                preparedStatement.setString(6, dataChildren.getSex());
                preparedStatement.setString(7, dataChildren.getRegular());
                preparedStatement.execute();
                System.out.println("El niño fue ingresado correctamente");
            }catch (SQLException e){
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
