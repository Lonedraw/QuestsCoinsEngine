package me.Taro.QuestsCoinsEngine;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import su.nightexpress.coinsengine.api.CoinsEngineAPI;
import su.nightexpress.coinsengine.api.currency.Currency;

import java.util.UUID;

public class CoinsEngineHook {

    private final Plugin plugin;

    public CoinsEngineHook(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Give coins to a player by UUID using the default currency.
     */
    public void giveCoins(UUID uuid, double amount) {
        // Fetch the default currency
        Currency currency = CoinsEngineAPI.getDefaultCurrency();

        if (currency == null) {
            plugin.getLogger().warning("No default currency found in CoinsEngine!");
            return;
        }

        // Add the amount directly via the API
        CoinsEngineAPI.addBalance(uuid, currency, amount);
    }

    /**
     * Overload for Bukkit Player
     */
    public void giveCoins(Player player, double amount) {
        giveCoins(player.getUniqueId(), amount);
    }
}
