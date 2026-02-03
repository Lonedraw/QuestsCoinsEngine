@Override
public Reward parse(ConfigurationSection section) {
    String currency = section.getString("currency");
    double amount = section.getDouble("amount");

    return (quester, quest) ->
            coinsHook.giveCoins(
                    quester.getUUID(),
                    currency,
                    amount
            );
}
