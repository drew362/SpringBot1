package io.project.SpringBot.storageLot;

import java.util.ArrayList;

public class AntikWeapon {
    public final String falerDESCR1 = "Парные номера.";
    public final String falerDESCR2 = "Клеймо тульского завода, ранний выпуск с хомутом.";

    ArrayList<String> products = new ArrayList<>();

    public AntikWeapon() {
        products.add("Штык к винтовке сист. Маузера 1884/98 гг. " + "\n"
                + falerDESCR1 + "\n"
                + "Состояние: mint.");
        products.add("Штык русский образца 1891 года к винтовке Мосина. " + "\n"
                + falerDESCR2 + "\n"
                + "Состояние: mint.");
    }

    public ArrayList<String> getAntikWeaponProducts() {
        return products;
    }
}