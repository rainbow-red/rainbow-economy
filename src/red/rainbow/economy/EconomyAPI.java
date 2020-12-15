package red.rainbow.economy;

import de.remadisson.rainbowcore.api.UserDataAPI;

import java.util.UUID;

public class EconomyAPI {

    private final UUID playerUUID;
    private final UserDataAPI userData = new UserDataAPI();
    private double cash;
    private double coins;


    public EconomyAPI(UUID uuid) {
        this.playerUUID = uuid;
        if (!userData.isLoaded(playerUUID)) {
            userData.loadUser(playerUUID);
        }
    }

    public static void initPlayerEco() {
        //TODO
    }

    public double getCash() {
        return this.cash;
    }

    public double getCoins() {
        return this.coins;
    }
}
