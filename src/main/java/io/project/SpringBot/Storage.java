package io.project.SpringBot;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Storage {

    public String getProducts() {
        ArrayList<String> products = new ArrayList<>();
        products.add("Гривна Новгородская 1000 рублей");
        products.add("Гривна Литовская 1000 рублей");
        products.add("Гривна Новгородская 1000 рублей");
        products.add("Гривна Литовская 1000 рублей");
        return products.stream().collect(Collectors.joining("\n"));
    }
}