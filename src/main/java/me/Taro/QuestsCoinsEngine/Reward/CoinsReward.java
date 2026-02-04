package me.Taro.QuestsCoinsEngine.Reward;

import org.bukkit.entity.Player;
import su.nightexpress.coinsengine.CoinsEnginePlugin; // NightExpress API
import su.nightexpress.coinsengine.api.CoinsEngineAPI;

public class CoinsReward {

    private final int amount;
    private final CoinsEngineHook hook;
    public CoinsReward(int amount, CoinsEngineHook hook) {
        this.amount = amount;
        this.hook = hook;
    }

    public void giveReward(Player player) {
        hook.giveCoins(player.getUniqueId(), "default_currency", amount);
    }

    @Override
    public String toString() {
        return "CoinsReward{" +
                "amount=" + amount +
                '}';
    }
}
