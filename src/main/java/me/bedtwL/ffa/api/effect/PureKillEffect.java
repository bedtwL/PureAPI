package me.bedtwL.ffa.api.effect;

import me.bedtwL.ffa.api.EffectManager;
import me.bedtwL.ffa.api.effectBase;
import me.bedtwL.ffa.api.none.NoneKillEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Represents a customizable player kill effect in the BedtwL FFA system.
 *
 * <p>
 * This abstract class replaces the deprecated {@link me.bedtwL.ffa.api.PlayerKillEffect} interface.
 * All future kill effect implementations should extend {@code PureKillEffect}.
 * </p>
 *
 * <h3>Usage:</h3>
 * <ul>
 *   <li>Call {@link #registerKillEffect()} in your plugin's {@code onEnable()} method to register this effect.</li>
 *   <li>Call {@link #unregisterKillEffect()} in {@code onDisable()} to safely unregister it.</li>
 *   <li>Override {@link #killEffect(Location, Player)} to implement victim-only effects (e.g., particles or sounds).</li>
 *   <li>Override {@link #killEffect(Location, Player, Player)} to implement effects involving both killer and victim.</li>
 *   <li>Override {@link #getName()}, {@link #getItemNameKey()}, and {@link #getItemBase()} from {@link effectBase} to provide effect identity and representation.</li>
 * </ul>
 *
 * @see me.bedtwL.ffa.api.EffectManager#playerKillEffects
 */
public abstract class PureKillEffect {

    /**
     * Called when a player dies. Override this to play effects for the victim only.
     *
     * @param location the location where the death occurred
     * @param player the victim player
     */
    public void killEffect(Location location, Player player) {
        // Optional override
    }

    /**
     * Called when a player is killed by another player.
     *
     * @param location the location where the death occurred
     * @param victim the player who died
     * @param killer the player who killed
     */
    public void killEffect(Location location, Player victim, Player killer) {
        // Optional override
    }

    /**
     * Registers this kill effect into the {@link EffectManager}.
     * Typically called in your plugin's {@code onEnable()}.
     */
    public final void registerKillEffect() {
        EffectManager.playerKillEffects.put(getName(), this);
    }

    /**
     * Unregisters this kill effect from the {@link EffectManager}.
     * Typically called in your plugin's {@code onDisable()}.
     */
    public final void unregisterKillEffect() {
        EffectManager.playerKillEffects.put(getName(), new NoneKillEffect());
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
     * The returned key follows the pattern: "item.effect-block.{itemNameKey}.name"
     * </p>
     *
     * @return the full translation key for the effect's item name
     */
    public final String getEffectItemName() {
        return "item.effect-block." + getItemNameKey() + ".name";
    }

    /**
     * Returns the full translation key for the effect's item lore.
     * <p>
     * This method is final to ensure consistent translation key formatting.
     * The returned key follows the pattern: "item.effect-block.{itemNameKey}.lore"
     * </p>
     *
     * @return the full translation key for the effect's item lore
     */
    public final String getEffectItemLore() {
        return "item.effect-block." + getItemNameKey() + ".lore";
    }
}
