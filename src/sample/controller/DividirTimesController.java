package sample.controller;
import sample.persistence.TimeDao;

import java.sql.SQLException;

public class DividirTimesController implements IDividirTimesController {
    @Override
    public void dividirTimesAleatoriamente() throws SQLException, ClassNotFoundException {
        TimeDao timeDao = new TimeDao();
        timeDao.dividirTimesAleatoriamente();
    }
}
