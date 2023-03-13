package io.project.SpringBot.storageLot;

import java.util.ArrayList;

public class Faleristika {
    public final String falerDESCR1 = "ЛЮБИМЦЕВ Андрей Агеевич — 70 пех. Ряжский полк, ефрейтор.\n" +
            "За то, что в бою 14.07.1915, под действительным ружейным и пулеметным огнем противника, вынес своего раненого ротного командира\n" +
            "и принес его на перевязочный пункт.";

    public final String falerDESCR2 = "Дорош Михаил Федорович- 246 гв. сп 82 гв. сд. За то что 26 апреля 1945 при наступлении в районе аэропорта г.Берлин, " + "\n"
            + "ворвавшись в дом с группой наших автоматчиков, лично уничтожил 2-х гитлеровцев и одного захватил в плен.";

    ArrayList<String> products = new ArrayList<>();

    public Faleristika() {
        products.add("Георгиевский крест IV степени №16067. " + "\n"
                + falerDESCR1 + "\n"
                + "Состояние: AU.");
        products.add("Медаль «За отвагу» № 3179513. " + "\n"
                + falerDESCR2 + "\n"
                + "Состояние: копиЯ.");
    }

    public ArrayList<String> getFalerProducts() {
        return products;
    }
}