package sample.controller;

import sample.persistence.GrupoDao;

import java.sql.SQLException;

public class GerarRodadasController implements IGerarRodadasController {

    @Override
    public void gerarRodadasAleatoriamente() throws SQLException, ClassNotFoundException {
        GrupoDao grupoDao = new GrupoDao();
        grupoDao.gerarGruposAleatoriamente();
    }
}
