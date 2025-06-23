package me.bedtwL.ffa.api.effect;

import me.bedtwL.ffa.api.EffectAddon;
import me.bedtwL.ffa.api.EffectManager;
import me.bedtwL.ffa.api.none.NoneHitEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Abstract base class for player hit effects.
 *
 * <p>Extend this class instead of implementing {@link me.bedtwL.ffa.api.PlayerHitEffect} for better control
 * and future compatibility.</p>
 *
 * <p>Override {@link #hitEffect(Location, Player)} to implement custom hit effect behavior.</p>
 *
 * <p>Use {@link #registerHitEffect(EffectAddon)} and {@link #unregisterHitEffect()} to manage the lifecycle of the effect.</p>
 */
public abstract class PureHitEffect {
    public EffectAddon addon;
    /**
     * Called when a player is hit.
     * Override this method to define the behavior of the hit effect.
     *
     * @param location the location where the hit occurred
     * @param player the player who was hit
     */
    public abstract void hitEffect(Location location, Player player);


    /**
     * Registers this hit effect into the {@link EffectManager}, and associates it with the given {@link EffectAddon}.
     * This should typically be called in your plugin's {@code onEnable()} method.
     *
     * @param addon the addon this hit effect belongs to
     */
    public final void registerHitEffect(EffectAddon addon) {
        EffectManager.playerHitEffects.put(getName(), this);
        this.addon = addon;
    }


    /**
     * Unregisters this hit effect from the {@link EffectManager},
     * replacing it with {@link me.bedtwL.ffa.api.none.NoneHitEffect}.
     * Typically called in your plugin's {@code onDisable()} method.
     */
    public final void unregisterHitEffect() {
        EffectManager.playerHitEffects.put(getName(), new NoneHitEffect());
    }

    /**
     * Returns the unique name identifier of this effect.
     *
     * @return the effect's name string
     */
    public abstract String getName();

    /**
     * Returns the key used for item name and lore translation lookups.
     * This key is appended to translation path prefixes like "item.effect-block.".
     *
     * @return the item name key string
     */
    public abstract String getItemNameKey();

    /**
     * Returns the base {@link ItemStack} that visually represents this effect,
     * such as the item displayed in menus or given to players.
     *
     * @return the base item stack
     */
    public abstract ItemStack getItemBase();

    /**
     * Returns the full translation key for the effect's item name.
     * <p>
     * This method is final to ensure consistent translation key formatting.
     * The returned key follows the pattern: "item.effect.{itemNameKey}.name"
     * </p>
     *
     * @return the full translation key for the effect's item name
     */
    public final String getEffectItemName() {
        return "item.effect." + getItemNameKey() + ".name";
    }

    /**
     * Returns the full translation key for the effect's item lore.
     * <p>
     * This method is final to ensure consistent translation key formatting.
     * The returned key follows the pattern: "item.effect.{itemNameKey}.lore"
     * </p>
     *
     * @return the full translation key for the effect's item lore
     */
    public final String getEffectItemLore() {
        return "item.effect." + getItemNameKey() + ".lore";
    }
}