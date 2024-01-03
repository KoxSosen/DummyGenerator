package com.github.koxsosen;

import com.github.koxsosen.Provider.LibertyBansStandaloneProvider;
import com.github.koxsosen.Punishments.BanAdder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibertyBansStandaloneProvider.getLogger().info("Starting DummyGenerator.");
        LibertyBansStandaloneProvider.getInstance().create();
        LibertyBansStandaloneProvider.getInstance().startup(LibertyBansStandaloneProvider.getFoundation());

        BanAdder banAdder = new BanAdder();

        LibertyBansStandaloneProvider.getLogger().info("Enabled and ready to take punishments.");
        Scanner scanner = new Scanner(System.in);

        LibertyBansStandaloneProvider.getLogger().info("Please enter how many punishments you would like added.");
        LibertyBansStandaloneProvider.getLogger().info("This applies to bans.");
        LibertyBansStandaloneProvider.getLogger().info("Type 'exit' to stop the program.");

        while (true) {
            String line = scanner.nextLine();
            if ("exit".equalsIgnoreCase(line)) {
                LibertyBansStandaloneProvider.getInstance().shutdown(LibertyBansStandaloneProvider.getFoundation());
                break;
            }
            banAdder.addNumberOfBans(Integer.parseInt(line));
        }

    }
}