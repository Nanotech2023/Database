package Service;

import DAO.Dao;
import DAO.Table;

import java.util.ArrayList;

public class Service {
    private Dao dao;
    public Service() {
        dao = new Dao();
    }
    public ArrayList<Table> toHtml() {
        return dao.toHtml();
    }
}
