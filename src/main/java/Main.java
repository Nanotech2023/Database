import DAO.Table;
import Service.Service;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws IOException {
        Service service = new Service();
        ArrayList<Table> tables = service.toHtml();
        Table tableGoods = tables.get(0);
        ArrayList<String> tableGoodsData = tableGoods.getData();
        ArrayList<String> forDiagram = new ArrayList<String>();
        for (int i = 7; i < tableGoodsData.size(); i++) {
            if (i % 5 == 2)
                forDiagram.add(tableGoodsData.get(i));
        }
        CreateChart CC = new CreateChart("Pie Chart Test","Material", forDiagram);
        CC.pack();
        CC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CC.setVisible(true);
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Fwerfad\\IdeaProjects\\bd\\bd\\src\\main\\resources\\solution.html"));
        String partOne =    "<html>\n" +
                            "<head>\n" +
                            "    <title>Создание таблиц в HTML, примеры</title>\n" +
                            "</head>\n" +
                            "<body>\n + " +
                            "<img src=\"C:\\Users\\Fwerfad\\IdeaProjects\\bd\\bd\\src\\main\\resources\\example.png\" alt=\"Помогите\">";
        String partTwo = "";
        String partThree =  "</table>\n" +
                            "</body>\n" +
                            "</html>";
        for (Table table : tables) {
            partTwo += table.toHtmlTable();
        }
        writer.write(partOne + partTwo + partThree);
        writer.flush();
        writer.close();
    }

}
