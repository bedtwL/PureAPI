package me.bedtwL.ffa.api;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface PlayerHitEffect extends effectBase{
    void hitEffect(Location location, Player player);
    default void registerHitEffect() {
        EffectManager.playerHitEffects.put(getName(),this);
    }
    default void unregisterHitEffect() {
        EffectManager.playerHitEffects.put(getName(),new NoneEffect());
    }
}
