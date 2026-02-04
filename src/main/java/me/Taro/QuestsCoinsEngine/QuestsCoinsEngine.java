package me.taro.questscoinsengine;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import me.taro.questscoinsengine.Reward.CoinsReward;

public final class QuestsCoinsEngine extends JavaPlugin {

    private CoinsEngineHook coinsHook;

    @Override
    public void onEnable() {
        // Initialize NightCore hook
        if (!getServer().getPluginManager().isPluginEnabled("NightCore")) {
            getLogger().warning("NightCore not found — Coins rewards disabled.");
            return;
        }

        this.coinsHook = new CoinsEngineHook(this);

        getLogger().info("QuestsCoinsEngine enabled with NightCore Coins integration!");
    }

    @Override
    public void onDisable() {
        getLogger().info("QuestsCoinsEngine disabled.");
    }

    // Example method to give a player coins
    public void givePlayerCoins(Player player, double amount) {
        if (coinsHook != null) {
            coinsHook.giveCoins(player, amount);
            getLogger().info("Gave " + amount + " coins to " + player.getName());
        }
    }
