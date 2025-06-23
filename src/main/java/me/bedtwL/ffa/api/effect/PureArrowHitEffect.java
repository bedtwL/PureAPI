package me.bedtwL.ffa.api.effect;

import me.bedtwL.ffa.api.EffectAddon;
import me.bedtwL.ffa.api.EffectManager;
import me.bedtwL.ffa.api.PureAPI;
import me.bedtwL.ffa.api.none.NoneArrowHitEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Abstract base class for player arrow hit effects.
 *
 * <p>Extend this class to create custom arrow hit effects.</p>
 *
 * <p>Override {@link #arrowHitEffect(Location, Player)} to define your custom effect behavior.</p>
 *
 * <p>Manage registration lifecycle with {@link #registerArrowHitEffect()} and {@link #unregisterArrowHitEffect()}.</p>
 */
public abstract class PureArrowHitEffect {
    public EffectAddon addon;
    /**
     * Called when a player is hit by an arrow.
     *
     * @param location the location where the hit occurred
     * @param player the player who was hit by the arrow
     */
    public abstract void arrowHitEffect(Location location, Player player);

    /**
     * @deprecated
     * Use {@link #registerArrowHitEffect(EffectAddon)} instead to ensure proper addon tracking.
     * <p>
     * Registers this arrow hit effect into the {@link EffectManager}.
     * Usually called during plugin {@code onEnable()}.
     */
    @Deprecated
    public final void registerArrowHitEffect() {
        EffectManager.playerArrowHitEffects.put(getName(), this);
        PureAPI.getPlugin().getLogger().warning("Effect "+getName()+" is still using LEGACY API!");
    }

    /**
     * Registers this arrow hit effect into the {@link EffectManager}.
     * Usually called during plugin {@code onEnable()}.
     */
    public final void registerArrowHitEffect(EffectAddon addon) {
        EffectManager.playerArrowHitEffects.put(getName(), this);
        this.addon=addon;
    }

    /**
     * Unregisters this arrow hit effect from the {@link EffectManager},
     * replacing it with {@link me.bedtwL.ffa.api.none.NoneArrowHitEffect}.
     * Usually called during plugin {@code onDisable()}.
     */
    public final void unregisterArrowHitEffect() {
        EffectManager.playerArrowHitEffects.put(getName(), new NoneArrowHitEffect());
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
