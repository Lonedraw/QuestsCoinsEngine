package me.Taro.QuestsCoinsEngine.Reward;

import org.bukkit.entity.Player;
import su.nightexpress.coinsengine.CoinsEngine; // NightExpress API
import su.nightexpress.coinsengine.api.CurrencyManager;

public class CoinsReward {

    private final int amount;

    public CoinsReward(int amount) {
        this.amount = amount;
    }

    public void giveReward(Player player) {
        // NightExpress CoinsEngine API call
        CoinsManager manager = CoinsEngine.getInstance().getManager();
        manager.addCoins(player.getUniqueId(), amount);
    }

    @Override
    public String toString() {
        return "CoinsReward{" +
                "amount=" + amount +
                '}';
    }
}
