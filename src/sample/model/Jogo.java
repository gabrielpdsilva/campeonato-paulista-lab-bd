package sample.model;

import java.sql.Date;

public class Jogo {

    public Jogo() {
        super();
    }

    private Time timeA;
    private Time timeB;
    private int golsTimeA;
    private int golsTimeb;
    private Date data;

    public Time getTimeA() {
        return timeA;
    }

    public void setTimeA(Time timeA) {
        this.timeA = timeA;
    }

    public Time getTimeB() {
        return timeB;
    }

    public void setTimeB(Time timeB) {
        this.timeB = timeB;
    }

    public int getGolsTimeA() {
        return golsTimeA;
    }

    public void setGolsTimeA(int golsTimeA) {
        this.golsTimeA = golsTimeA;
    }

    public int getGolsTimeb() {
        return golsTimeb;
    }

    public void setGolsTimeb(int golsTimeb) {
        this.golsTimeb = golsTimeb;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
