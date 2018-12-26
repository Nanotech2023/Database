package DAO;

import java.util.ArrayList;

public class Table {
    String name;
    int sizeCollumn;
    int sizeRow;
    ArrayList<String> data;
    public Table (String name, int sizeCollumn, int sizeRow, ArrayList<String> data) {
        this.name = name;
        this.sizeCollumn = sizeCollumn;
        this.sizeRow = sizeRow;
        this.data = data;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public String toHtmlTable() {
        String template1 = "<table border=\"1\" cellspacing=\"0\"\n" +
                "       cellpadding=\"8\" style=\"background-color:#766CCC; color:#ffffff\">";
        String p = "<p>" + name + "</p>\n";
        String template3 = "\n" +
                "</table>";
        String template2 = "\n";
        int count = 0;
        for (String i : data) {
            if (count % sizeCollumn == 0)
                template2 += "<tr>\n";
            template2 += "<td>" + i + "</td>";
            if (count % sizeCollumn == sizeCollumn - 1)
                template2 += "</tr>\n";
            count += 1;
        }
        return p + template1 + template2 + template3;
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                ", sizeCollumn=" + sizeCollumn +
                ", sizeRow=" + sizeRow +
                ", data=" + data +
                '}';
    }
}
