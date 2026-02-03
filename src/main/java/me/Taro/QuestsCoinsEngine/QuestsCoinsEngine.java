package me.taro.questscoinsengine;

import me.blackvein.quests.Quests;
import me.blackvein.quests.api.QuestsAPI;
import me.blackvein.quests.api.reward.RewardType;
import me.yourname.questscoinsengine.reward.CoinsReward;
import org.bukkit.plugin.java.JavaPlugin;

public class QuestsCoinsEngine extends JavaPlugin {

    @Override
    public void onEnable() {
        if (!getServer().getPluginManager().isPluginEnabled("CoinsEngine")) {
            getLogger().warning("CoinsEngine not found — Coins reward disabled.");
            return;
        }

        Quests quests = (Quests) getServer()
                .getPluginManager()
                .getPlugin("Quests");

        if (quests == null) {
            getLogger().severe("Quests not found — disabling.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        QuestsAPI api = quests.getQuestsAPI();
        RewardType reward = new CoinsReward(new CoinsEngineHook(this));
        api.getRewardTypeRegistry().register(reward);

        getLogger().info("CoinsEngine reward registered successfully.");
    }
}
