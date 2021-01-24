package red.rainbow.economy;

import de.remadisson.rainbowcore.api.UserDataAPI;

import java.util.UUID;

public class EconomyAPI {

    private final UUID playerUUID;
    private final UserDataAPI userData = new UserDataAPI();
    private int cash;
    private int coins;


    public EconomyAPI(UUID uuid) {
        this.playerUUID = uuid;
        if (!userData.isLoaded(playerUUID)) {
            userData.loadUser(playerUUID);
        }
        initPlayerEco();
    }

    private void initPlayerEco() {
        if (hasEcoStats()) loadPlayerEcoStats();
        else createPlayerEcoStats();
    }

    private void createPlayerEcoStats() {
        //TODO
    }

    private void loadPlayerEcoStats() {
        //TODO
    }

    private boolean hasEcoStats() {
        //TODO
        return false;
    }


//------------------------- API methods start -------------------------------

    public void depositCash(int amount) {
        this.cash = this.cash + amount;
    }

    public void depositCoins(int amount) {
        this.coins = this.coins +amount;
    }

    public boolean withdrawCash(int amount) {
        if (hasCash(amount)) {
            this.cash = this.cash - amount;
            return true;
        }
        else {
            return false;
        }
    }

    public int withdrawCash(int amount, boolean forceTransaction) {
        if (hasCash(amount)) {
            this.cash = this.cash - amount;
            return 0;
        }
        else if (forceTransaction) {
            this.cash = this.cash - amount;
            return 1;
        }
        else {
            return 2;
        }
    }

    public boolean withdrawCoins(int amount) {
        if (hasCoins(amount)) {
            this.coins = this.coins - amount;
            return true;
        }
        else {
            return false;
        }
    }

    public int withdrawCoins(int amount, boolean forceTransaction) {
        if (hasCoins(amount)) {
            this.coins = this.coins - amount;
            return 0;
        }
        else if (forceTransaction) {
            this.coins = this.coins - amount;
            return 1;
        }
        else {
            return 2;
        }
    }

    public boolean hasCash(int amount) {
        return this.cash >= amount;
    }

    public boolean hasCoins(int amount) {
        return this.coins >= amount;
    }

    public int getCash() {
        return this.cash;
    }

    public int getCoins() {
        return this.coins;
    }

}
