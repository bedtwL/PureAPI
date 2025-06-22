package me.bedtwL.ffa.api.effect;

import me.bedtwL.ffa.api.EffectAddon;
import me.bedtwL.ffa.api.EffectManager;
import me.bedtwL.ffa.api.none.NoneArrowShootEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Abstract base class for player arrow shoot effects.
 *
 * <p>Extend this class to create custom arrow shoot effects.</p>
 *
 * <p>Override {@link #arrowShootEffect(Location, Player)} to define your custom effect behavior.</p>
 *
 * <p>Manage registration lifecycle with {@link #registerArrowShootEffect()} and {@link #unregisterArrowShootEffect()}.</p>
 */
public abstract class PureArrowShootEffect {
    /**
     * Called when a player shoots an arrow.
     *
     * @param location the location where the arrow was shot
     * @param player the player who shot the arrow
     */
    public abstract void arrowShootEffect(Location location, Player player);

    /**
     * Registers this arrow shoot effect into the {@link EffectManager}.
     * Usually called during plugin {@code onEnable()}.
     */
    public final void registerArrowShootEffect() {
        EffectManager.playerArrowShootEffects.put(getName(), this);
    }

    /**
     * Unregisters this arrow shoot effect from the {@link EffectManager},
     * replacing it with {@link NoneArrowShootEffect}.
     * Usually called during plugin {@code onDisable()}.
     */
    public final void unregisterArrowShootEffect() {
        EffectManager.playerArrowShootEffects.put(getName(), new NoneArrowShootEffect());
    }

    /**
     * Returns the unique name identifier of this effect.
     *
     * @return the effect name string
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
