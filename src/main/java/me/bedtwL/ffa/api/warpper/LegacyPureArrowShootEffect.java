package me.bedtwL.ffa.api.warpper;

import me.bedtwL.ffa.api.PlayerArrowShootEffect;
import me.bedtwL.ffa.api.PureAPI;
import me.bedtwL.ffa.api.effect.PureArrowShootEffect;

/**
 * @deprecated
 * Wrapper adapter to allow legacy {@link PlayerArrowShootEffect} implementations
 * to be used as {@link PureArrowShootEffect}.
 */
@Deprecated
public class LegacyPureArrowShootEffect extends PureArrowShootEffect {

    private final PlayerArrowShootEffect legacy;

    /**
     * Wraps a legacy PlayerArrowShootEffect implementation.
     *
     * @param legacy the legacy PlayerArrowShootEffect instance
     */
    public LegacyPureArrowShootEffect(PlayerArrowShootEffect legacy) {
        this.legacy = legacy;
        PureAPI.getPlugin().getLogger().warning("Effect "+legacy.getName()+" is still using LEGACY API!");
    }

    @Override
    public void arrowShootEffect(org.bukkit.Location location, org.bukkit.entity.Player player) {
        legacy.ArrowShootEffect(location, player);
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
