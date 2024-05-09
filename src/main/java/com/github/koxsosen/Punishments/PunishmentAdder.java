package com.github.koxsosen.Punishments;

import com.github.koxsosen.Generator.PropertiesGenerator;
import com.github.koxsosen.Provider.LibertyBansStandaloneProvider;
import space.arim.libertybans.api.*;
import space.arim.libertybans.api.punish.DraftPunishment;
import space.arim.libertybans.api.punish.PunishmentDrafter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

public class PunishmentAdder {

    public void addNumberOfPunishments(String type, int numberOfElements, String punishmentCreatorType) {
        for (int i = 0; i < numberOfElements; i++) {
            addPunishment(type, punishmentCreatorType);
        }
    }

    // Add the humber of bans specified to the LibertyBans database using the API.
    public void addPunishment(String type, String punishmentCreatorType) {
        PropertiesGenerator generator = new PropertiesGenerator();
        LibertyBans api = LibertyBansStandaloneProvider.getApi();

        PunishmentDrafter drafter = api.getDrafter();

        String reason = generator.getRandomReason();
        String name = generator.getRandomName();
        UUID uuidToBan = generator.getRandomOfflineModeUUID(name);
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName(InetAddress.getByName(generator.getRandomIP()).getHostAddress());
        } catch (UnknownHostException ignored) { }

        PunishmentType punishmentType;

        switch (type) {
            case "ban" -> punishmentType = PunishmentType.BAN;
            case "kick" -> punishmentType = PunishmentType.KICK;
            case "mute" -> punishmentType = PunishmentType.MUTE;
            case "warn" -> punishmentType = PunishmentType.WARN;
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }

        Victim victim;
        // LibertyBans supports UUID, IP, and Composite (UUID, IP) based punishments.
        switch (punishmentCreatorType) {
            case "address" -> victim = AddressVictim.of(inetAddress);
            case "player" -> victim = PlayerVictim.of(uuidToBan);
            case "composite" -> victim = CompositeVictim.of(uuidToBan, inetAddress);
            default -> throw new IllegalStateException("Unexpected value: " + punishmentCreatorType);
        }


        DraftPunishment draftBan = drafter.draftBuilder()
                .duration(generator.getRandomDuration())
                .type(punishmentType)
                .victim(victim)
                .reason(reason)
                .build();

        draftBan.enactPunishment().thenAcceptAsync((punishment) -> {
            if (punishment.isEmpty()) {
                LibertyBansStandaloneProvider.getLogger().info("UUID {} is already banned", uuidToBan);
                return;
            }
            LibertyBansStandaloneProvider.getLogger().info("ID of the enacted punishment is {}", punishment.get().getIdentifier());
        });
    }

}
