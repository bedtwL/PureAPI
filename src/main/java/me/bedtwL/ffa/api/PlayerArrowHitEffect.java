package me.bedtwL.ffa.api;

import me.bedtwL.ffa.api.none.NoneArrowHitEffect;
import me.bedtwL.ffa.api.warpper.LegacyPureArrowHitEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * @deprecated This interface is deprecated and will be removed in future versions.
 *             Please migrate to using the {@link me.bedtwL.ffa.api.PureArrowHitEffect}
 *             abstract class instead, which provides better control and future compatibility.
 *
 * <p>To migrate, convert your implementation of this interface into a subclass of
 * {@code PureArrowHitEffect} and implement the abstract methods:
 * <ul>
 *   <li>{@link PureArrowHitEffect#arrowHitEffect(Location, Player)}</li>
 *   <li>{@link PureArrowHitEffect#getName()}</li>
 *   <li>{@link PureArrowHitEffect#getItemNameKey()}</li>
 *   <li>{@link PureArrowHitEffect#getItemBase()}</li>
 * </ul>
 * Also use {@link PureArrowHitEffect#registerArrowHitEffect()} and
 * {@link PureArrowHitEffect#unregisterArrowHitEffect()} for registration lifecycle management.
 * </p>
 *
 * <p>If you want to keep your old implementation, you can wrap it using
 * {@link me.bedtwL.ffa.api.warpper.LegacyPureArrowHitEffect} to adapt it to the new system.</p>
 */
@Deprecated
public interface PlayerArrowHitEffect extends effectBase {

    /**
     * Called when a player is hit by an arrow.
     *
     * @param location the location where the hit occurred
     * @param player the player who was hit
     */
    void ArrowHitEffect(Location location, Player player);

    /**
     * Registers this arrow hit effect into the {@link EffectManager}.
     * Usually called during plugin {@code onEnable()}.
     */
    default void registerArrowHitEffect() {
        EffectManager.playerArrowHitEffects.put(getName(), new LegacyPureArrowHitEffect(this));
    }

    /**
     * Unregisters this arrow hit effect from the {@link EffectManager},
     * replacing it with {@link me.bedtwL.ffa.api.none.NoneArrowHitEffect}.
     * Usually called during plugin {@code onDisable()}.
     */
    default void unregisterArrowHitEffect() {
        EffectManager.playerArrowHitEffects.put(getName(), new NoneArrowHitEffect());
    }
}
