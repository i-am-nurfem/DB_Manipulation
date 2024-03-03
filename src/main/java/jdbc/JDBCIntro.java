package jdbc;

import jdbc.world.Country;
import jdbc.world.DBHelper;
import java.sql.*;
import java.util.ArrayList;


public class JDBCIntro {

    public static void main(String [] args) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        DBHelper dbHelper = new DBHelper();

        try{
            connection = dbHelper.getConnection();
            System.out.println("Bağlantı sağlandı");
            String sql = "delete from city where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4080);
            statement.executeUpdate();
            System.out.println("Kayıt silindi");
        }catch (SQLException sqlException){
            dbHelper.showErrorMessage(sqlException);
        }finally {
            statement.close();
            connection.close();
        }
    }

    public void updateDemo() throws SQLException{
        Connection connection = null;
        PreparedStatement statement = null;

        DBHelper dbHelper = new DBHelper();

        try{
            connection = dbHelper.getConnection();
            System.out.println("Bağlantı sağlandı");
            String sql = "update city set name = 'Duzce', district = 'Turkey' where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4080);
            statement.executeUpdate();
            System.out.println("Kayıt güncellendi");
        }catch (SQLException sqlException){
            dbHelper.showErrorMessage(sqlException);
        }finally {
            statement.close();
            connection.close();
        }
    }
    public void insertDemo() throws SQLException{
        Connection connection = null;
        PreparedStatement statement = null;

        DBHelper dbHelper = new DBHelper();

        try{
            connection = dbHelper.getConnection();
            System.out.println("Bağlantı sağlandı");
            statement = connection.prepareStatement("insert into city (Name, CountryCode, District, Population) values('Düzce','TUR', 'Düzce', 50000)");
            statement.executeUpdate();
            System.out.println("Kayıt eklendi");
        }catch (SQLException sqlException){
            dbHelper.showErrorMessage(sqlException);
        }finally {
            statement.close();
            connection.close();
        }
    }

    public void selectDemo() throws SQLException{
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        DBHelper dbHelper = new DBHelper();

        try{
            connection = dbHelper.getConnection();
            System.out.println("Bağlantı sağlandı");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select Code, Name, Continent, Region from country;");
            ArrayList<Country> countries = new ArrayList<>();
            while(resultSet.next()){
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }
        }catch (SQLException sqlException){
            dbHelper.showErrorMessage(sqlException);
        }finally {
            connection.close();
        }
    }
}
