package sample.controller;

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
            TableColumn<Time, String> colTimeA,
            TableColumn<Time, String> colTimeB,
            TableColumn<Time, Integer> colGolsA,
            TableColumn<Time, Integer> colGolsB,
            TableColumn<Time, Date> colData
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
    private TableColumn<Time, String> colTimeA;

    @FXML
    private TableColumn<Time, String> colTimeB;

    @FXML
    private TableColumn<Time, Integer> colGolsA;

    @FXML
    private TableColumn<Time, Integer> colGolsB;

    @FXML
    private TableColumn<Time, Date> colData;

    @Override
    public void buscarJogosDaData() throws SQLException, ClassNotFoundException {
        LocalDate data = dpDataRodada.getValue();
        Date dataFormatada = java.sql.Date.valueOf(data);
        JogoDao jogoDao = new JogoDao();
        ArrayList<Jogo> jogos = jogoDao.buscarJogosDaData(dataFormatada);
        // TODO names are not working yet
        // Testing date: 20/01/2010
        colTimeA.setCellValueFactory(
                new PropertyValueFactory<Time, String>("timeA")
        );
        colTimeB.setCellValueFactory(
                new PropertyValueFactory<Time, String>("timeB")
        );
        colGolsA.setCellValueFactory(
                new PropertyValueFactory<Time, Integer>("golsTimeA")
        );
        colGolsB.setCellValueFactory(
                new PropertyValueFactory<Time, Integer>("golsTimeB")
        );
        colData.setCellValueFactory(
                new PropertyValueFactory<Time, Date>("data")
        );
        ObservableList<Jogo> jogosFormatados = FXCollections.observableArrayList(
                jogos
        );
        tblJogosNaRodada.setItems(jogosFormatados);
    }
}
