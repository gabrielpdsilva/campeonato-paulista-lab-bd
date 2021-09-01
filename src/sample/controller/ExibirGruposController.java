package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Grupo;
import sample.model.Time;
import sample.persistence.GrupoDao;

import java.sql.SQLException;

public class ExibirGruposController implements IExibirGruposController {
    @FXML
    private TableView<Time> tblGrupoA;

    @FXML
    private TableColumn<Time, Integer> colIdA;

    @FXML
    private TableColumn<Time, String> colGrupoA;

    @FXML
    private TableView<Time> tblGrupoB;

    @FXML
    private TableColumn<Time, Integer> colIdB;

    @FXML
    private TableColumn<Time, String> colGrupoB;

    @FXML
    private TableView<Time> tblGrupoC;

    @FXML
    private TableColumn<Time, Integer> colIdC;

    @FXML
    private TableColumn<Time, String> colGrupoC;

    @FXML
    private TableView<Time> tblGrupoD;

    @FXML
    private TableColumn<Time, Integer> colIdD;

    @FXML
    private TableColumn<Time, String> colGrupoD;

    public ExibirGruposController(
            TableView<Time> tblGrupoA,
            TableColumn<Time, Integer> colIdA,
            TableColumn<Time, String> colGrupoA,
            TableView<Time> tblGrupoB,
            TableColumn<Time, Integer> colIdB,
            TableColumn<Time, String> colGrupoB,
            TableView<Time> tblGrupoC,
            TableColumn<Time, Integer> colIdC,
            TableColumn<Time, String> colGrupoC,
            TableView<Time> tblGrupoD,
            TableColumn<Time, Integer> colIdD,
            TableColumn<Time, String> colGrupoD
    ) {
        this.tblGrupoA = tblGrupoA;
        this.colIdA = colIdA;
        this.colGrupoA = colGrupoA;
        this.tblGrupoB = tblGrupoB;
        this.colIdB = colIdB;
        this.colGrupoB = colGrupoB;
        this.tblGrupoC = tblGrupoC;
        this.colIdC = colIdC;
        this.colGrupoC = colGrupoC;
        this.tblGrupoD = tblGrupoD;
        this.colIdD = colIdD;
        this.colGrupoD = colGrupoD;
    }

    private void setarTabelaGrupoA() throws SQLException, ClassNotFoundException {
        GrupoDao grupoDao = new GrupoDao();
        Grupo grupoA = new Grupo();
        grupoA.setGrupo("A");
        grupoA = grupoDao.buscarGrupo(grupoA);
        colIdA.setCellValueFactory(
                new PropertyValueFactory<Time, Integer>("codigoTime")
        );
        colGrupoA.setCellValueFactory(
                new PropertyValueFactory<Time, String>("nomeTime")
        );
        ObservableList<Time> timesFormatados = FXCollections.observableArrayList(
                grupoA.getTimes()
        );
        tblGrupoA.setItems(timesFormatados);
    }

    private void setarTabelaGrupoB() throws SQLException, ClassNotFoundException {
        GrupoDao grupoDao = new GrupoDao();
        Grupo grupoB = new Grupo();
        grupoB.setGrupo("B");
        grupoB = grupoDao.buscarGrupo(grupoB);
        colIdB.setCellValueFactory(
                new PropertyValueFactory<Time, Integer>("codigoTime")
        );
        colGrupoB.setCellValueFactory(
                new PropertyValueFactory<Time, String>("nomeTime")
        );
        ObservableList<Time> timesFormatados = FXCollections.observableArrayList(
                grupoB.getTimes()
        );
        tblGrupoB.setItems(timesFormatados);
    }

    private void setarTabelaGrupoC() throws SQLException, ClassNotFoundException {
        GrupoDao grupoDao = new GrupoDao();
        Grupo grupoC = new Grupo();
        grupoC.setGrupo("C");
        grupoC = grupoDao.buscarGrupo(grupoC);
        colIdC.setCellValueFactory(
                new PropertyValueFactory<Time, Integer>("codigoTime")
        );
        colGrupoC.setCellValueFactory(
                new PropertyValueFactory<Time, String>("nomeTime")
        );
        ObservableList<Time> timesFormatados = FXCollections.observableArrayList(
                grupoC.getTimes()
        );
        tblGrupoC.setItems(timesFormatados);
    }

    private void setarTabelaGrupoD() throws SQLException, ClassNotFoundException {
        GrupoDao grupoDao = new GrupoDao();
        Grupo grupoD = new Grupo();
        grupoD.setGrupo("D");
        grupoD = grupoDao.buscarGrupo(grupoD);
        colIdD.setCellValueFactory(
                new PropertyValueFactory<Time, Integer>("codigoTime")
        );
        colGrupoD.setCellValueFactory(
                new PropertyValueFactory<Time, String>("nomeTime")
        );
        ObservableList<Time> timesFormatados = FXCollections.observableArrayList(
                grupoD.getTimes()
        );
        tblGrupoD.setItems(timesFormatados);
    }

    @Override
    public void setarTabelaDosGrupos() throws SQLException, ClassNotFoundException {
        setarTabelaGrupoA();
        setarTabelaGrupoB();
        setarTabelaGrupoC();
        setarTabelaGrupoD();
    }
}
