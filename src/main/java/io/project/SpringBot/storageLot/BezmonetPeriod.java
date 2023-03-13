package io.project.SpringBot.storageLot;

import java.util.ArrayList;

public class BezmonetPeriod {
    public final String grivDESCR1 = "С двумя литыми знаками, изготовлена в так называемом \"Курском Поселье\" (Курская область) в первой половине XIV века.";
    public final String grivDESCR2 = "Поздняя литовская полтина, приблизительно XIV-XV вв, отлита в один раз.";
    public final String grivDESCR3 = "Имела хождение в качестве платежного средства в т.н. «безмонетный период» в Южной Руси.";
    public final String grivDESCR4 = "Ранняя гривна, более удлиненная. На конце присутствуют насечки.";
    public final String grivDESCR5 = "Имеет одну насечку посередине.";
    public final String grivDESCR6 = "Редко встречается с таким весом.";

    ArrayList<String> products = new ArrayList<>();

    public BezmonetPeriod() {
        products.add("Гривна Новгородская XIII-XIV век. " + "\n"
                + grivDESCR1 + "\n"
                + "Состояние: AU." + "\n"
                + "Вес: 201 гр.");
        products.add("Полтина Литовская трехгранная XIV век. " + "\n"
                + grivDESCR2 + "\n"
                + "Состояние: AU." + "\n"
                + "Вес: 91 гр.");
        products.add("Гривна киевского типа XII век. " + "\n"
                + grivDESCR3 + "\n"
                + "Состояние: AU." + "\n"
                + "Вес: 162 гр.");
        products.add("Гривна Новгородская XIII век. " + "\n"
                + grivDESCR4 + "\n"
                + "Состояние: AU." + "\n"
                + "Вес: 199 гр.");
        products.add("Гривна литовская \"Изрой\". Вторая половина XIII. " + "\n"
                + grivDESCR5 + "\n"
                + "Состояние: AU." + "\n"
                + "Вес: 100 гр.");
        products.add("Гривна булгарская XIII. " + "\n"
                + grivDESCR6 + "\n"
                + "Состояние: XF." + "\n"
                + "Вес: 196 гр.");
    }

    public ArrayList<String> getProducts() {
        return products;
    }
}