package me.bedtwL.ffa.api.warpper;

import me.bedtwL.ffa.api.PlayerArrowHitEffect;
import me.bedtwL.ffa.api.PureAPI;
import me.bedtwL.ffa.api.effect.PureArrowHitEffect;

/**
 * @deprecated
 * Wrapper adapter to allow legacy {@link PlayerArrowHitEffect} implementations
 * to be used as {@link PureArrowHitEffect}.
 */
@Deprecated
public class LegacyPureArrowHitEffect extends PureArrowHitEffect {

    private final PlayerArrowHitEffect legacy;

    /**
     * Wraps a legacy PlayerArrowHitEffect implementation.
     *
     * @param legacy the legacy PlayerArrowHitEffect instance
     */
    public LegacyPureArrowHitEffect(PlayerArrowHitEffect legacy) {
        this.legacy = legacy;
        PureAPI.getPlugin().getLogger().warning("Effect "+legacy.getName()+" is still using LEGACY api!");
    }

    @Override
    public void arrowHitEffect(org.bukkit.Location location, org.bukkit.entity.Player player) {
        legacy.ArrowHitEffect(location, player);
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
    public org.bukkit.inventory.ItemStack getItemBase() {
        return legacy.getItemBase();
    }
}
