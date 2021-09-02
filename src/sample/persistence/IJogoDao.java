package sample.persistence;

import sample.model.Jogo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public interface IJogoDao {
    ArrayList<Jogo> buscarJogosDaData(Date data) throws SQLException;
}
