package me.bedtwL.ffa.api;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface PlayerArrowShootEffect extends effectBase{
    void ArrowShootEffect(Location location, Player player);
    default void registerArrowShootEffect() {
        EffectManager.playerArrowShootEffects.put(getName(),this);
    }
    default void unregisterArrowShootEffect() {
        EffectManager.playerArrowShootEffects.put(getName(),new NoneEffect());
    }
}
