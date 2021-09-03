package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Grupo;
import sample.model.Jogo;
import sample.model.Time;
import sample.persistence.GrupoDao;
import sample.persistence.JogoDao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class MainController {

    @FXML
    private Button btnDividirTimes;

    @FXML
    private Label lblDividirTimes;

    @FXML
    private Button btnGerarRodadas;

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

    @FXML
    private Button btnBuscarGruposFormados;

    @FXML
    private Button btnBuscarJogos;

    @FXML
    private DatePicker dpDataRodada;

    @FXML
    private TableView<Jogo> tblJogosNaRodada;

    @FXML
    private TableColumn<Jogo, String> colTimeA;

    @FXML
    private TableColumn<Jogo, String> colTimeB;

    @FXML
    private TableColumn<Jogo, Integer> colGolsA;

    @FXML
    private TableColumn<Jogo, Integer> colGolsB;

    @FXML
    private TableColumn<Jogo, Date> colData;

    @FXML
    void buscarGruposFormados(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ExibirGruposController exibirGruposController = new ExibirGruposController(
                tblGrupoA,
                colIdA,
                colGrupoA,
                tblGrupoB,
                colIdB,
                colGrupoB,
                tblGrupoC,
                colIdC,
                colGrupoC,
                tblGrupoD,
                colIdD,
                colGrupoD
        );
        exibirGruposController.setarTabelaDosGrupos();
    }

    @FXML
    public void gerarRodadas(ActionEvent actionEvent) {
        // TODO finish implementing using procedure call
        try {
            GerarRodadasController grc = new GerarRodadasController();
            grc.gerarRodadasAleatoriamente();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Rodadas geradas com sucesso!");
            alert.show();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.show();
        }
    }

    @FXML
    public void dividirTimes(ActionEvent actionEvent) {
        try {
            DividirTimesController dtc = new DividirTimesController();
            dtc.dividirTimesAleatoriamente();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Times divididos com sucesso!");
            alert.show();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.show();
        }
    }

    @FXML
    public void buscarJogos(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        BuscarJogosController bjc = new BuscarJogosController(
                dpDataRodada,
                tblJogosNaRodada,
                colTimeA,
                colTimeB,
                colGolsA,
                colGolsB,
                colData
        );
        bjc.buscarJogosDaData();
    }

    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {

    }
}
