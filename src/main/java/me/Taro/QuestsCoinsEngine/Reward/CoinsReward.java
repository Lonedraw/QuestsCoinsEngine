package me.Taro.QuestsCoinsEngine.Reward;

import org.bukkit.entity.Player;
import su.nightexpress.coinsengine.CoinsEnginePlugin; // NightExpress API
import su.nightexpress.coinsengine.api.CoinsEngineAPI;

public class CoinsReward {

    private final int amount;

    public CoinsReward(int amount) {
        this.amount = amount;
    }

    public void giveReward(Player player) {
        // NightExpress CoinsEngine API call
        CoinsReward manager = CoinsEngineAPI.getInstance().getManager();
        manager.addCoins(player.getUniqueId(), amount);
    }

    @Override
    public String toString() {
        return "CoinsReward{" +
                "amount=" + amount +
                '}';
    }
}
