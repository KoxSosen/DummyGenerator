package com.github.koxsosen.Punishments;

import com.github.koxsosen.Generator.PropertiesGenerator;
import com.github.koxsosen.Provider.LibertyBansStandaloneProvider;
import space.arim.libertybans.api.LibertyBans;
import space.arim.libertybans.api.PlayerVictim;
import space.arim.libertybans.api.PunishmentType;
import space.arim.libertybans.api.punish.DraftPunishment;
import space.arim.libertybans.api.punish.PunishmentDrafter;

import java.time.Duration;
import java.util.UUID;

public class PunishmentAdder {

    public void addNumberOfBans(int numberOfElements) {
        for (int i = 0; i < numberOfElements; i++) {
            addBan();
        }
    }

    public void addNumberOfMutes(int numberOfElements) {
        for (int i = 0; i < numberOfElements; i++) {
            addMute();
        }
    }

    public void addNumberOfKicks(int numberOfElements) {
        for (int i = 0; i < numberOfElements; i++) {
            addKick();
        }
    }

    public void addNumberOfWarns(int numberOfElements) {
        for (int i = 0; i < numberOfElements; i++) {
            addWarn();
        }
    }

    // Add the humber of bans specified to the LibertyBans database using the API.
    public void addBan() {
        PropertiesGenerator generator = new PropertiesGenerator();
        LibertyBans api = LibertyBansStandaloneProvider.getApi();

        PunishmentDrafter drafter = api.getDrafter();

        String reason = generator.getRandomReason();
        UUID uuidToBan = generator.getRandomdUUID();

        DraftPunishment draftBan = drafter
                .draftBuilder()
                .duration(generator.getRandomDuration())
                .type(PunishmentType.BAN)
                .victim(PlayerVictim.of(uuidToBan))
                .reason(reason)
                .build();

        draftBan.enactPunishment().thenAcceptSync((punishment) -> {
            if (punishment.isEmpty()) {
                LibertyBansStandaloneProvider.getLogger().info("UUID {} is already banned", uuidToBan);
                return;
            }
            LibertyBansStandaloneProvider.getLogger().info("ID of the enacted punishment is {}", punishment.get().getIdentifier());
        });
    }

    public void addMute() {
        PropertiesGenerator generator = new PropertiesGenerator();
        LibertyBans api = LibertyBansStandaloneProvider.getApi();

        PunishmentDrafter drafter = api.getDrafter();

        String reason = generator.getRandomReason();
        UUID uuidToBan = generator.getRandomdUUID();

        DraftPunishment draftBan = drafter
                .draftBuilder()
                .duration(generator.getRandomDuration())
                .type(PunishmentType.MUTE)
                .victim(PlayerVictim.of(uuidToBan))
                .reason(reason)
                .build();

        draftBan.enactPunishment().thenAcceptSync((punishment) -> {
            if (punishment.isEmpty()) {
                LibertyBansStandaloneProvider.getLogger().info("UUID {} is already muted", uuidToBan);
                return;
            }
            LibertyBansStandaloneProvider.getLogger().info("ID of the enacted punishment is {}", punishment.get().getIdentifier());
        });
    }

    public void addKick() {
        PropertiesGenerator generator = new PropertiesGenerator();
        LibertyBans api = LibertyBansStandaloneProvider.getApi();

        PunishmentDrafter drafter = api.getDrafter();

        String reason = generator.getRandomReason();
        UUID uuidToBan = generator.getRandomdUUID();

        DraftPunishment draftBan = drafter
                .draftBuilder()
                .type(PunishmentType.KICK)
                .victim(PlayerVictim.of(uuidToBan))
                .reason(reason)
                .build();

        draftBan.enactPunishment().thenAcceptSync((punishment) -> {
            if (punishment.isEmpty()) {
                LibertyBansStandaloneProvider.getLogger().info("UUID {} is already kicked", uuidToBan);
                return;
            }
            LibertyBansStandaloneProvider.getLogger().info("ID of the enacted punishment is {}", punishment.get().getIdentifier());
        });
    }

    public void addWarn() {
        PropertiesGenerator generator = new PropertiesGenerator();
        LibertyBans api = LibertyBansStandaloneProvider.getApi();

        PunishmentDrafter drafter = api.getDrafter();

        String reason = generator.getRandomReason();
        UUID uuidToBan = generator.getRandomdUUID();

        DraftPunishment draftBan = drafter
                .draftBuilder()
                .type(PunishmentType.WARN)
                .victim(PlayerVictim.of(uuidToBan))
                .reason(reason)
                .build();

        draftBan.enactPunishment().thenAcceptSync((punishment) -> {
            if (punishment.isEmpty()) {
                LibertyBansStandaloneProvider.getLogger().info("UUID {} is already warned", uuidToBan);
                return;
            }
            LibertyBansStandaloneProvider.getLogger().info("ID of the enacted punishment is {}", punishment.get().getIdentifier());
        });
    }

}
