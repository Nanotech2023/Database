package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao {
    public ArrayList<Table> toHtml() {String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:55165;database=ConstructShop;integratedSecurity=true";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String names[] = {"Goods", "Batch", "BuyOperation", "Cheque", "ChequeDetails", "Customer", "Employment", "InternalOperation", "Personnel", "Producer", "Room", "Storage", "Supply"};
            ArrayList<Table> tables = new ArrayList<Table>();
            for (String j : names) {
                ResultSet resultSet = statement.executeQuery("SELECT * from " + j);
                ArrayList<String> data = new ArrayList<String>();
                int count1 = resultSet.getMetaData().getColumnCount();
                int count2 = 0;
                for (int i = 1; i <= count1; i++)
                    data.add(resultSet.getMetaData().getColumnName(i));
                while (resultSet.next()) {
                    count2 += 1;
                    for (int i = 1; i <= count1; i++)
                        data.add(resultSet.getString(i));
                }
                tables.add(new Table(j, count1, count2, data));
                resultSet.close();
            }
            statement.close();
            connection.close();
            return tables;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
