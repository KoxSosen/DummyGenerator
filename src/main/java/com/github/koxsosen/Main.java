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

        LibertyBansStandaloneProvider.getLogger().info("The syntax is the following: punishment-type:number-of-punishments");
        LibertyBansStandaloneProvider.getLogger().info("Example: ban:20");
        LibertyBansStandaloneProvider.getLogger().info("Type 'exit' to stop the program.");

        while (true) {
            String line = scanner.nextLine();

            if ("exit".equalsIgnoreCase(line)) {
                LibertyBansStandaloneProvider.getInstance().shutdown(LibertyBansStandaloneProvider.getFoundation());
                break;
            }

            String[] elements = line.split(":");

            if (elements.length < 2) {
                LibertyBansStandaloneProvider.getLogger().info("Invalid syntax, please try again.");
                continue;
            }

            switch (elements[0]) {
                case "ban" -> punishmentAdder.addNumberOfBans(Integer.parseInt(elements[1]));
                case "mute" -> punishmentAdder.addNumberOfMutes(Integer.parseInt(elements[1]));
                case "kick" -> punishmentAdder.addNumberOfKicks(Integer.parseInt(elements[1]));
                case "warn" -> punishmentAdder.addNumberOfWarns(Integer.parseInt(elements[1]));
            }

        }

    }
}