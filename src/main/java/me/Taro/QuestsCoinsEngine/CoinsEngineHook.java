package me.Taro.QuestsCoinsEngine;

import su.nightexpress.coinsengine.api.CoinsEngineAPI;
import su.nightexpress.coinsengine.api.currency.Currency;
import su.nightexpress.coinsengine.user.UserManager;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class CoinsEngineHook {

    private final Plugin plugin;

    public CoinsEngineHook(Plugin plugin) {
        this.plugin = plugin;
    }

    public void giveCoins(UUID uuid, String currencyId, double amount) {
        Currency currency = CoinsEngineAPI.getCurrencyManager().getCurrencies();

        if (currency == null) {
            plugin.getLogger().warning(
                    "Currency '" + currencyId + "' does not exist."
            );
            return;
        }

        
    }
}
