package me.Taro.questscoinsengine;

import me.blackvein.quests.Quests;
import me.blackvein.quests.api.QuestsAPI;
import me.blackvein.quests.api.reward.RewardType;
import me.yourname.questscoinsengine.reward.CoinsReward;
import org.bukkit.plugin.java.JavaPlugin;

public class QuestsCoinsEngine extends JavaPlugin {

    private static CoinsEngineHook coinsHook;

    @Override
    public void onEnable() {
        if (!getServer().getPluginManager().isPluginEnabled("CoinsEngine")) {
            getLogger().warning("CoinsEngine not found. Reward will be disabled.");
            return;
        }

        coinsHook = new CoinsEngineHook(this);

        Quests quests = (Quests) getServer().getPluginManager().getPlugin("Quests");
        QuestsAPI api = quests.getQuestsAPI();

        RewardType rewardType = new CoinsReward(coinsHook);
        api.getRewardTypeRegistry().register(rewardType);

        getLogger().info("CoinsEngine reward registered with Quests.");
    }

    public static CoinsEngineHook getCoinsHook() {
        return coinsHook;
    }
}
