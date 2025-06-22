package me.bedtwL.ffa.api;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface PlayerKillEffect extends effectBase{
    default void killEffect(Location location, Player player) {

    }
    default void killEffect(Location location, Player victim,Player killer) {

    }
    default void registerKillEffect() {
        EffectManager.playerKillEffects.put(getName(),this);
    }
    default void unregisterKillEffect() {
        EffectManager.playerHitEffects.put(getName(),new NoneEffect());
    }
}
