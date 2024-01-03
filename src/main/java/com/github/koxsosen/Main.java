package com.github.koxsosen;

import com.github.koxsosen.Provider.LibertyBansStandaloneProvider;
import com.github.koxsosen.Punishments.BanAdder;

public class Main {

    private static final int amountOfPunishments = 40;
    private static final int lengthOfReasons = 10;

    public static void main(String[] args) {
        LibertyBansStandaloneProvider.getInstance().create();
        LibertyBansStandaloneProvider.getInstance().startup(LibertyBansStandaloneProvider.getFoundation());

        BanAdder banAdder = new BanAdder();

        for (int i = 0; i < amountOfPunishments; i++) {
            banAdder.addBans(lengthOfReasons);
        }

        LibertyBansStandaloneProvider.getInstance().shutdown(LibertyBansStandaloneProvider.getFoundation());

    }
}