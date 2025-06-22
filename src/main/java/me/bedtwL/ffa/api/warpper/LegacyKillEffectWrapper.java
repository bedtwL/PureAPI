package me.bedtwL.ffa.api.warpper;

import me.bedtwL.ffa.api.PlayerKillEffect;
import me.bedtwL.ffa.api.effect.PureKillEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * @deprecated
 * Wraps a legacy {@link me.bedtwL.ffa.api.PlayerKillEffect} implementation into the new {@link PureKillEffect} system.
 *
 * <p>Use this to temporarily support old effects without refactoring them immediately.</p>
 *
 * Example:
 * <pre>{@code
 * PlayerKillEffect old = new OldFireEffect();
 * PureKillEffect wrapped = new LegacyKillEffectWrapper(old);
 * wrapped.registerKillEffect();
 * }</pre>
 */
public class LegacyKillEffectWrapper extends PureKillEffect {

    private final PlayerKillEffect legacy;

    public LegacyKillEffectWrapper(PlayerKillEffect legacy) {
        this.legacy = legacy;
    }

    @Override
    public void killEffect(Location location, Player player) {
        legacy.killEffect(location, player);
    }

    @Override
    public void killEffect(Location location, Player victim, Player killer) {
        legacy.killEffect(location, victim, killer);
    }

    @Override
    public String getName() {
        return legacy.getName();
    }

    @Override
    public String getItemNameKey() {
        return legacy.getItemNameKey();
    }

    @Override
    public ItemStack getItemBase() {
        return legacy.getItemBase();
    }
}
