package Alemzhan;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;
    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Items?useUnicode=true&serverTimezone=UTC","root","");
            System.out.println("CONNECTED");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Items> getallItems(){
        ArrayList<Items>items = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Items");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                items.add(new Items(id,name,price));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return items;
    }
    public void additem(Items item){
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO items(id,name,price) values(null,?,?)");
            ps.setString(1,item.getName());
            ps.setDouble(2,item.getPrice());
            ps.executeUpdate();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteitem(Long id){
        try{
            PreparedStatement ps = connection.prepareStatement("DELETE FROM items where id = ?");
            ps.setLong(1,id);
            ps.executeUpdate();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
