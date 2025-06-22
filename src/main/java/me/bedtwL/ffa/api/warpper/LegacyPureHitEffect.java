package me.bedtwL.ffa.api.warpper;

import me.bedtwL.ffa.api.PlayerHitEffect;
import me.bedtwL.ffa.api.effect.PureHitEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * @deprecated
 * Adapter to wrap a legacy {@link PlayerHitEffect} implementation and adapt it to {@link PureHitEffect}.
 *
 * <p>Allows legacy hit effects to work without immediate migration.</p>
 */
public class LegacyPureHitEffect extends PureHitEffect {

    private final PlayerHitEffect legacy;

    /**
     * Constructs the adapter wrapping the legacy hit effect.
     *
     * @param legacy the old PlayerHitEffect instance
     */
    public LegacyPureHitEffect(PlayerHitEffect legacy) {
        this.legacy = legacy;
    }

    @Override
    public void hitEffect(Location location, Player player) {
        legacy.hitEffect(location, player);
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
