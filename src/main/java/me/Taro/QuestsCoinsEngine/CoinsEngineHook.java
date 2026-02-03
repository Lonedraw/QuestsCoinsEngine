package me.taro.questscoinsengine;

import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import su.nightexpress.nightcore.api.NightCoreAPI;
import su.nightexpress.nightcore.api.coins.CoinsManager;

import java.util.UUID;

public class CoinsEngineHook {

    private final Plugin plugin;
    private final CoinsManager coinsManager;

    public CoinsEngineHook(Plugin plugin) {
        this.plugin = plugin;
        this.coinsManager = NightCoreAPI.getInstance().getCoinsManager();
    }

    public void giveCoins(UUID uuid, double amount) {
        // NightCore CoinsManager automatically uses the default currency
        boolean success = coinsManager.addCoins(uuid, amount);
        if (!success) {
            plugin.getLogger().warning("Failed to add coins to player: " + uuid);
        }
    }

    public void giveCoins(Player player, double amount) {
        giveCoins(player.getUniqueId(), amount);
    }
}
