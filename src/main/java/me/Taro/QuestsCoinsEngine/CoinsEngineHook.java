package me.taro.questscoinsengine;

import su.nightexpress.coinsengine.api.CoinsEngineAPI;
import su.nightexpress.coinsengine.api.currency.Currency;
import su.nightexpress.coinsengine.api.user.User;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class CoinsEngineHook {

    private final Plugin plugin;

    public CoinsEngineHook(Plugin plugin) {
        this.plugin = plugin;
    }

    public void giveCoins(UUID uuid, String currencyId, double amount) {
        Currency currency = CoinsEngineAPI.getCurrencyManager().getCurrency(currencyId);

        if (currency == null) {
            plugin.getLogger().warning(
                    "Currency '" + currencyId + "' does not exist."
            );
            return;
        }

        User user = CoinsEngineAPI.getUserManager().getOrCreateUser(uuid);
        user.addCoins(currency, amount);
    }
}
