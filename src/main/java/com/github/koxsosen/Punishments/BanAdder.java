package com.github.koxsosen.Punishments;

import com.github.koxsosen.Generator.PropertiesGenerator;
import com.github.koxsosen.Provider.LibertyBansStandaloneProvider;
import space.arim.libertybans.api.LibertyBans;
import space.arim.libertybans.api.PlayerVictim;
import space.arim.libertybans.api.PunishmentType;
import space.arim.libertybans.api.punish.DraftPunishment;
import space.arim.libertybans.api.punish.PunishmentDrafter;

import java.util.UUID;

public class BanAdder {

    // Add the humber of bans specified to the LibertyBans database using the API.
    public void addBans(int lengthOfReasons) {
        PropertiesGenerator generator = new PropertiesGenerator();
        LibertyBans api = LibertyBansStandaloneProvider.getApi();

        PunishmentDrafter drafter = api.getDrafter();

        String reason = generator.getRandomReason(lengthOfReasons);
        UUID uuidToBan = UUID.randomUUID();

        DraftPunishment draftBan = drafter
                .draftBuilder()
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

}
