package sample.persistence;

import java.sql.Connection;
import java.sql.SQLException;

public class TimeDao implements ITimeDao {
    private Connection c;
    public TimeDao() throws ClassNotFoundException, SQLException {
        GenericDao gDao = new GenericDao();
        c = gDao.getConnection();
    }

    @Override
    public String dividirTimesAleatoriamente() throws SQLException {
        // TODO implement
        System.out.println("Times divididos com sucesso.");
        return null;
    }
}
