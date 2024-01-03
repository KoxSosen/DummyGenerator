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

            if (elements[0].equals("ban")) {
                punishmentAdder.addNumberOfBans(Integer.parseInt(elements[1]));
            } else if (elements[0].equals("mute")) {
                punishmentAdder.addNumberOfMutes(Integer.parseInt(elements[1]));
            } else if (elements[0].equals("kick")) {
                punishmentAdder.addNumberOfKicks(Integer.parseInt(elements[1]));
            } else if (elements[0].equals("warn")) {
                punishmentAdder.addNumberOfWarns(Integer.parseInt(elements[1]));
            }

        }

    }
}