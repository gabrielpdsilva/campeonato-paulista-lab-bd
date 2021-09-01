package sample.persistence;

import sample.model.Grupo;

import java.sql.SQLException;

public interface IGrupoDao {
    public Grupo buscarGrupo(Grupo grupo) throws SQLException;;
}
