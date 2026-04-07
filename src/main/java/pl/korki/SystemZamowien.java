package pl.korki;

import java.util.*;

public class SystemZamowien {

    Scanner s = new Scanner(System.in);
    List<Produkt> menu = stworzListeProduktow();
    List<Zamowienie> zamowienia = new ArrayList<>();

    public List<Produkt> stworzListeProduktow() {

        List<Produkt> listaProduktow = List.of(
                new Produkt("salatka", 50, 1),
                new Produkt("kotlet z ziemniakami", 70, 1)
        );

        return listaProduktow;
    }

    public Map<Produkt, Integer> listaProduktowDoZamowienia(List<String> idProduktu, List<Integer> iloscProduktu) {
        Map<Produkt, Integer> listaProduktow = new HashMap<>();

        if (idProduktu.size() == iloscProduktu.size()) {
            for (int i = 0; i < idProduktu.size(); i++) {
                listaProduktow.put(menu.get(Integer.parseInt(idProduktu.get(i))), iloscProduktu.get(i));
            }
        }

//        for (int i = 0; i < listaId.size(); i++) {
//            if (Integer.parseInt(listaId.get(i)) > (menu.size() -1) || Integer.parseInt(listaId.get(i)) < 0){
//                continue;
//            }
//
//            listaProduktow.put(menu.get(Integer.parseInt(listaId.get(i))));
//
//        }



        return listaProduktow;
    }

    public void tworzenieZamowienia(String imie, String nazwisko, Map<Produkt, Integer> listaProduktow) {
        if (listaProduktow.isEmpty()) {
            System.out.println("nie mozna stworzyc zamowienia - nie podano produktow");

        } else {
            double sumaCenZamowienia = 0;

            for (Map.Entry<Produkt, Integer> produktEntry : listaProduktow.entrySet()) {
                if (produktEntry.getValue() > 0) {
                    for (int i = 0; i < produktEntry.getValue(); i++) {
                        sumaCenZamowienia += produktEntry.getKey().koszt();
                    }
                }
            }

            zamowienia.add(new Zamowienie(imie, nazwisko, sumaCenZamowienia, listaProduktow, Status.NEW));
        }
    }


    // moim zdaniem mozna to zrobic w jednej metodzie ale wolałem na bezpiecznie w 2 jak co to sie zmieni
    public void dodawanieProduktowDoZamowienia(Map<Produkt, Integer> listaProduktowDoDodania, Zamowienie zamowienie) {
        if (zamowienie.getStatus() == Status.CLOSED || zamowienie.getStatus() == Status.CANCELLED) {
            System.out.println("przepraszamy ale brak dostepu do tego zamowienia, poniewaz zostalo anulowane lub zrealizowane");
        } else {
            zamowienie.getListaProduktow().putAll(listaProduktowDoDodania);
        }
    }

    public void usuwanieProduktowZZamowienia(Map<Produkt, Integer> listaProduktowDoUsunienia, Zamowienie zamowienie) {
        if (zamowienie.getStatus() == Status.CLOSED || zamowienie.getStatus() == Status.CANCELLED) {
            System.out.println("przepraszamy ale brak dostepu do tego zamowienia, poniewaz zostalo anulowane lub zrealizowane");
        } else {
            zamowienie.getListaProduktow().putAll(listaProduktowDoUsunienia);
        }
    }

    public void anulowanieZamowienia(Zamowienie zamowienie) {
        zamowienie.setStatus(Status.CANCELLED);
    }

    public void zamykanieZamowienia(Zamowienie zamowienie) {
        zamowienie.setStatus(Status.CLOSED);
    }


    public ArrayList<Produkt> listaProduktowDoZamowienia2() {
        ArrayList<Produkt> listaProduktow = new ArrayList<>();

        System.out.println("wybierz potrawe poprzez wpisanie id w przeciwnym wypadku wpisz do konsoli stop: ");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println("id: " + i + "- nazwa potrawy: " + menu.get(i).nazwa() + "\t koszt potrawy: " + menu.get(i).koszt());
        }
        while (true) {
            String wybor = s.nextLine();
            if (wybor.equals("stop")) {
                break;
            } else if (Integer.parseInt(wybor) > menu.size() || Integer.parseInt(wybor) < 0) {
                System.out.println("blednie podane informacje sproboj ponownie!!!");
            } else {
                listaProduktow.add(menu.get(Integer.parseInt(wybor)));
            }
        }

        return listaProduktow;
    }


//    public Zamowienie tworzenieZamowienia(){
//        System.out.println("podaj imie i nazwisko miedzy nimi klikajac enter: ");
//        String imie = s.nextLine();
//        String nazwisko = s.nextLine();
//
//
//
//
//
//    }


}
