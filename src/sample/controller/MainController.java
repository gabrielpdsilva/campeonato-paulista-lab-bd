package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class MainController {

    @FXML
    private TableView<?> tblDividirTimesGrupos;

    @FXML
    private Button btnDividirTimes;

    @FXML
    private Label lblDividirTimes;

    @FXML
    private Button btnGerarRodadas;

    @FXML
    private TableView<?> tblGerarRodadasJogos;

    @FXML
    private TableView<?> tblGruposFormados;

    @FXML
    private Button btnBuscarJogos;

    @FXML
    private DatePicker dpDataRodada;

    @FXML
    private TableView<?> tblJogosNaRodada;

    @FXML
    public void gerarRodadas(ActionEvent actionEvent) {
        // TODO implement
        String cmd = actionEvent.getSource().toString();
        System.out.println(cmd);
    }

    @FXML
    public void dividirTimes(ActionEvent actionEvent) {
        // TODO implement
        String cmd = actionEvent.getSource().toString();
        System.out.println(cmd);
    }

    @FXML
    public void buscarJogos(ActionEvent actionEvent) {
        // TODO implement
        String cmd = actionEvent.getSource().toString();
        System.out.println(cmd);
    }
}
