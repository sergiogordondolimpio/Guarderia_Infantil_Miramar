package dataBase;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChildrenDAO {

    //function that insert a child in the database, the values come from the class dataBase.DataChildren
    //with interface in dataBase.ChildrenService
    public static void childrenInsertDB(DataChildren dataChildren){
        ConnectionMySQL connectionMySQL = new ConnectionMySQL();
        try (Connection connection = connectionMySQL.get_connection()) {
            PreparedStatement preparedStatement= null;
            try{
                String query="INSERT INTO taller_infantil_miramar.children " +
                        "(dniChildren, nameChildren, surnameChildren, birthday, dateIn, sex, regular) " +
                        "VALUES (?,?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, dataChildren.getDniChildren());
                preparedStatement.setString(2, dataChildren.getNameChildren());
                preparedStatement.setString(3, dataChildren.getSurnameChildren());
                preparedStatement.setString(4,dataChildren.getBirthday());
                preparedStatement.setString(5, dataChildren.getDateIn());
                preparedStatement.setString(6, dataChildren.getSex());
                preparedStatement.setString(7, dataChildren.getRegular());
                preparedStatement.execute();

                //Joption to show the child was insert in the data base
                JOptionPane.showMessageDialog(null, dataChildren.getNameChildren()
                                + " fue ingresado a la base de datos",
                        "Ingresar niño",JOptionPane.PLAIN_MESSAGE);

            }catch (SQLException e){
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static List<DataChildren> queryChildren(){
        DataChildren dataChildren;
        List<DataChildren> dataChildrenList = new ArrayList<>();
        ConnectionMySQL connectionMySQL = new ConnectionMySQL();
        //connection
        try (Connection connection = connectionMySQL.get_connection()) {
            //query
            try{
                String query = "SELECT * FROM taller_infantil_miramar.children";
                Statement s = connection.createStatement();
                ResultSet rs = s.executeQuery (query);
                int i = 0;
                while (rs.next()) {
                    dataChildren = new DataChildren(
                            rs.getInt("dniChildren"),
                            rs.getString("nameChildren"),
                            rs.getString("surnameChildren"),
                            rs.getString("birthday"),
                            rs.getString("dateIn"),
                            rs.getString("sex"),
                            rs.getString("regular"));
                    dataChildrenList.add(dataChildren);
                    System.out.println (dataChildrenList.get(i));
                    i++;
                }
            }catch (SQLException e){
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return dataChildrenList;
    }

}
