package pl.korki;

import java.util.ArrayList;
import java.util.Map;

public class Zamowienie {

    private String imie;
    private String nazwisko;
    private double koszt;
    private Map<Produkt, Integer> listaProduktow;
    private Status status;


    public Zamowienie(String imie, String nazwisko, double koszt, Map<Produkt, Integer> listaProduktow, Status status) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.koszt = koszt;
        this.listaProduktow = listaProduktow;
        this.status = status;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Map<Produkt, Integer> getListaProduktow() {
        return listaProduktow;
    }

    public void setListaProduktow(Map<Produkt, Integer> listaProduktow) {
        this.listaProduktow = listaProduktow;
    }

    public double getKoszt() {
        return koszt;
    }

    public void setKoszt(double koszt) {
        this.koszt = koszt;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
