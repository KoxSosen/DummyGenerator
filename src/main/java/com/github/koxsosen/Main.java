package com.github.koxsosen;

import com.github.koxsosen.Provider.LibertyBansStandaloneProvider;
import com.github.koxsosen.Punishments.PunishmentAdder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibertyBansStandaloneProvider.getLogger().info("Starting DummyGenerator.");
        LibertyBansStandaloneProvider.getInstance().create();
        LibertyBansStandaloneProvider.getInstance().startup(LibertyBansStandaloneProvider.getFoundation());

        PunishmentAdder punishmentAdder = new PunishmentAdder();

        LibertyBansStandaloneProvider.getLogger().info("Enabled and ready to take punishments.");
        Scanner scanner = new Scanner(System.in);

        LibertyBansStandaloneProvider.getLogger().info("The syntax is the following: punishment-type:number-of-punishments:punishment-creator-type");
        LibertyBansStandaloneProvider.getLogger().info("Examples: ban:20:player, kick:5:composite, mute:10:address");
        LibertyBansStandaloneProvider.getLogger().info("LibertyBans supports player, IP, and composite punishments.");
        LibertyBansStandaloneProvider.getLogger().info("So the options are player, address, composite.");
        LibertyBansStandaloneProvider.getLogger().info("Type 'exit' to stop the program.");

        while (true) {
            String line = scanner.nextLine();

            if ("exit".equalsIgnoreCase(line)) {
                LibertyBansStandaloneProvider.getInstance().shutdown(LibertyBansStandaloneProvider.getFoundation());
                break;
            }

            String[] elements = line.split(":");

            if (elements.length < 3) {
                LibertyBansStandaloneProvider.getLogger().info("Invalid syntax, please try again.");
                continue;
            }

            punishmentAdder.addNumberOfPunishments(elements[0], Integer.parseInt(elements[1]), elements[2]);

        }

    }
}