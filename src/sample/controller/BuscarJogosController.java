package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.model.Jogo;
import sample.model.Time;
import sample.persistence.JogoDao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class BuscarJogosController implements IBuscarJogosController {
    public BuscarJogosController(DatePicker dpDataRodada, TableView<?> tblJogosNaRodada, TableColumn<Time, String> colTimeA, TableColumn<Time, String> colTimeB, TableColumn<Time, Integer> colGolsA, TableColumn<Time, Integer> colGolsB, TableColumn<Time, Date> colData) {
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
    private TableView<?> tblJogosNaRodada;

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
        for(Jogo j: jogos) {
            System.out.println(j.getGolsTimeA());
            System.out.println(j.getTimeA().getNomeTime());
            System.out.println(j.getTimeB().getNomeTime());
            System.out.println(j.getGolsTimeb());
            System.out.println(j.getData());
        }
    }
}
