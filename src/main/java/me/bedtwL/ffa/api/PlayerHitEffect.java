package me.bedtwL.ffa.api;

import me.bedtwL.ffa.api.none.NoneHitEffect;
import me.bedtwL.ffa.api.warpper.LegacyPureHitEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * @deprecated This interface is replaced by {@link PureHitEffect}.
 *
 * Please migrate your implementations from
 * {@code implements PlayerHitEffect} to {@code extends PureHitEffect}.
 */
@Deprecated
public interface PlayerHitEffect extends effectBase {

    /**
     * Called when a player is hit. Override to create hit effects.
     *
     * @param location the location where the hit occurred
     * @param player the player who got hit
     */
    void hitEffect(Location location, Player player);

    /**
     * Registers this hit effect in the EffectManager.
     */
    default void registerHitEffect() {
        EffectManager.playerHitEffects.put(getName(), new LegacyPureHitEffect(this));
    }

    /**
     * Unregisters this hit effect, resetting to NoneEffect.
     */
    default void unregisterHitEffect() {
        EffectManager.playerHitEffects.put(getName(), new NoneHitEffect());
    }
}
