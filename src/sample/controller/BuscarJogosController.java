package sample.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Jogo;
import sample.model.Time;
import sample.persistence.JogoDao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class BuscarJogosController implements IBuscarJogosController {
    public BuscarJogosController(
            DatePicker dpDataRodada,
            TableView<Jogo> tblJogosNaRodada,
            TableColumn<Jogo, String> colTimeA,
            TableColumn<Jogo, String> colTimeB,
            TableColumn<Jogo, Integer> colGolsA,
            TableColumn<Jogo, Integer> colGolsB,
            TableColumn<Jogo, Date> colData
    ) {
        this.dpDataRodada = dpDataRodada;
        this.tblJogosNaRodada = tblJogosNaRodada;
        this.colTimeA = colTimeA;
        this.colTimeB = colTimeB;
        this.colGolsA = colGolsA;
        this.colGolsB = colGolsB;
        this.colData = colData;
    }

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

    @Override
    public void buscarJogosDaData() throws SQLException, ClassNotFoundException {
        LocalDate data = dpDataRodada.getValue();
        Date dataFormatada = java.sql.Date.valueOf(data);
        JogoDao jogoDao = new JogoDao();
        ArrayList<Jogo> jogos = jogoDao.buscarJogosDaData(dataFormatada);
        colTimeA.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getTimeA().getNomeTime()));
        colTimeB.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getTimeB().getNomeTime()));
        colGolsA.setCellValueFactory(cellData -> new SimpleObjectProperty<Integer>(cellData.getValue().getGolsTimeA()));
        colGolsB.setCellValueFactory(cellData -> new SimpleObjectProperty<Integer>(cellData.getValue().getGolsTimeB()));
        colData.setCellValueFactory(cellData -> new SimpleObjectProperty<Date>(cellData.getValue().getData()));
        ObservableList<Jogo> jogosFormatados = FXCollections.observableArrayList(jogos);
        tblJogosNaRodada.setItems(jogosFormatados);
    }
}
