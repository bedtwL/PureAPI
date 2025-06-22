package me.bedtwL.ffa.api;

import me.bedtwL.ffa.api.none.NoneArrowShootEffect;
import me.bedtwL.ffa.api.warpper.LegacyPureArrowShootEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * @deprecated This interface is deprecated and will be removed in future versions.
 *             Please migrate to using the {@link me.bedtwL.ffa.api.effect.PureArrowShootEffect}
 *             abstract class instead, which offers better structure and future-proofing.
 *
 * <p>Migration instructions:</p>
 * <ul>
 *   <li>Implement your effect by extending {@code PureArrowShootEffect}.</li>
 *   <li>Override {@link me.bedtwL.ffa.api.effect.PureArrowShootEffect#arrowShootEffect(Location, Player)}.</li>
 *   <li>Implement {@link me.bedtwL.ffa.api.effect.PureArrowShootEffect#getName()}, {@link me.bedtwL.ffa.api.effect.PureArrowShootEffect#getItemNameKey()}, and {@link me.bedtwL.ffa.api.effect.PureArrowShootEffect#getItemBase()}.</li>
 *   <li>Manage registration with {@link me.bedtwL.ffa.api.effect.PureArrowShootEffect#registerArrowShootEffect()} and {@link me.bedtwL.ffa.api.effect.PureArrowShootEffect#unregisterArrowShootEffect()}.</li>
 * </ul>
 *
 * <p>If you want to keep your existing implementation, wrap it using
 * {@link me.bedtwL.ffa.api.warpper.LegacyPureArrowShootEffect} for compatibility.</p>
 */
@Deprecated
public interface PlayerArrowShootEffect extends effectBase {

    /**
     * Called when a player shoots an arrow.
     *
     * @param location the location where the arrow was shot
     * @param player the player who shot the arrow
     */
    void ArrowShootEffect(Location location, Player player);

    /**
     * Registers this arrow shoot effect in the {@link EffectManager}.
     * Usually called in plugin {@code onEnable()}.
     */
    default void registerArrowShootEffect() {
        EffectManager.playerArrowShootEffects.put(getName(), new LegacyPureArrowShootEffect(this));
    }

    /**
     * Unregisters this arrow shoot effect from the {@link EffectManager},
     * replacing it with {@link me.bedtwL.ffa.api.none.NoneArrowShootEffect}.
     * Usually called in plugin {@code onDisable()}.
     */
    default void unregisterArrowShootEffect() {
        EffectManager.playerArrowShootEffects.put(getName(), new NoneArrowShootEffect());
    }
}
