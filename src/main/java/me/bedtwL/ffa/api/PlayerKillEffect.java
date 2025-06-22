package me.bedtwL.ffa.api;

import me.bedtwL.ffa.api.none.NoneKillEffect;
import me.bedtwL.ffa.api.warpper.LegacyKillEffectWrapper;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * @deprecated This interface is now deprecated and replaced by {@link me.bedtwL.ffa.api.effect.PureKillEffect}.
 *
 * ➤ Replace `implements PlayerKillEffect` with `extends PureKillEffect` in your implementation classes.
 *
 * Migration Example:
 *
 * OLD:
 * public class FireKillEffect implements PlayerKillEffect
 *
 * NEW:
 * public class FireKillEffect extends PureKillEffect
 */
@Deprecated
public interface PlayerKillEffect extends effectBase {

    /**
     * Called when a player dies. Override for victim-only effects.
     *
     * @param location the location of the death
     * @param player the player who died
     */
    default void killEffect(Location location, Player player) {
    }

    /**
     * Called when a player is killed by another player.
     *
     * @param location the location of the death
     * @param victim the victim
     * @param killer the killer
     */
    default void killEffect(Location location, Player victim, Player killer) {
    }

    /**
     * Registers this kill effect into the {@link EffectManager}.
     */
    default void registerKillEffect() {
        EffectManager.playerKillEffects.put(getName(), new LegacyKillEffectWrapper(this));
    }

    /**
     * Unregisters this kill effect and resets it to {@link me.bedtwL.ffa.api.none.NoneKillEffect}.
     */
    default void unregisterKillEffect() {
        EffectManager.playerKillEffects.put(getName(), new NoneKillEffect());
    }
}
