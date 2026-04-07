package pl.korki;

public record Produkt(
        String nazwa,
        double koszt,
        int ilosc
) {
    @Override
    public String toString() {
        return "Produkt{" +
                "nazwa='" + nazwa + '\'' +
                ", koszt=" + koszt +
                ", ilosc=" + ilosc +
                '}';
    }
}
