package sample.persistence;

import sample.model.Grupo;
import java.sql.SQLException;

public interface IGrupoDao {
    Grupo buscarGrupo(Grupo grupo) throws SQLException;
    String gerarGruposAleatoriamente() throws SQLException;
}
