package me.bedtwL.ffa.api;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface PlayerArrowHitEffect extends effectBase{
    void ArrowHitEffect(Location location, Player player);
    default void registerArrowHitEffect() {
        EffectManager.playerArrowHitEffects.put(getName(),this);
    }
    default void unregisterArrowHitEffect() {
        EffectManager.playerArrowHitEffects.put(getName(),new NoneEffect());
    }
}
