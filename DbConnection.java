import java.sql.*;

public class DbConnection {
    public static void main(String[] args){
        try{
            String url = "jdbc:mysql://localhost:3306/products";
            String user = "root";
            String pass = "SL$12";
            Connection con = DriverManager.getConnection(url,user, pass);
            if(con != null)   System.out.println("Connection Successful");
            Statement st = con.createStatement();
            
            String Shampoos = "Create table Shampoos(Sno integer PRIMARY KEY, brands varchar(60), prices varchar(20), stockAvail integer)";
            st.execute(Shampoos);

            int[] sno = {1,2,3,4,5};
            String[] brands = {"Head & Shoulders",
                            "Dove Moisturizing",
                            "Pantene Pro-V Sheer",
                            "Mysore Sandal Soap",
                            "Mama Eart Soap"};
         
         String[] prices = {"\n   $399",
                            "\n   $299",
                            "\n   $349",
                            "\n   $120",
                            "\n   $257"};
            int[] stockAvail={3,14,4,12,1};
            PreparedStatement ps = con.prepareStatement("INSERT INTO Shampoos(sno,brands,prices,stockAvail) VALUES(?,?,?,?)");

        for(int i=0;i<sno.length;i++){
                ps.setInt(1,sno[i]);
                ps.setString(2,brands[i]);
                ps.setString(3,prices[i]);
                ps.setInt(4,stockAvail[i]);
                ps.executeUpdate();
            }


        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

}
