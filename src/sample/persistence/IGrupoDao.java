package sample.persistence;

import sample.model.Grupo;
import java.sql.SQLException;

public interface IGrupoDao {
    Grupo buscarGrupo(Grupo grupo) throws SQLException;
    // TODO change name and return type
    void buscarTudo() throws SQLException;
}
