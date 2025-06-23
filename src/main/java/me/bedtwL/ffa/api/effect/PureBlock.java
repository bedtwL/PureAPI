package me.bedtwL.ffa.api.effect;

import me.bedtwL.ffa.api.EffectAddon;
import me.bedtwL.ffa.api.EffectManager;
import me.bedtwL.ffa.api.PureAPI;
import me.bedtwL.ffa.api.none.WoolBlockEffect;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
/**
 * Represents a customizable block effect in the BedtwL FFA system.
 *
 * <p>
 * This abstract class replaces the deprecated {@code BlockEffect} interface.
 * All custom block effects should now extend {@code PureBlock}.
 * </p>
 *
 * <h3>Usage:</h3>
 * <ul>
 *   <li>Call {@link #registerBlockEffect()} in your plugin's {@code onEnable()} method to register the effect.</li>
 *   <li>Call {@link #unregisterBlockEffect()} in {@code onDisable()} to safely unregister the effect.</li>
 *   <li>Override {@link #onBlockPlace(Block)} to define what happens when a player places a block.</li>
 *   <li>Override {@link #getBlock()} to return the visual item given to players (e.g. wool, glass).</li>
 *   <li>Override {@link #getBlockKey()} to provide a unique string identifier for this effect.</li>
 *   <li>If using per-player language support, override {@link #useLang()} to return {@code true} and implement {@link #getItemNameKey()}.</li>
 * </ul>
 *
 * @see me.bedtwL.ffa.api.EffectManager#playerBlockEffect
 */
public abstract class PureBlock {
    public EffectAddon addon;
    /**
     * Called when the player places a block using this effect.
     *
     * @param block the block that was placed
     */
    public void onBlockPlace(Block block) {
        // Optionally override to handle block placement behavior
    }

    /**
     * Returns the {@link ItemStack} used to represent this block effect
     * (e.g. in menus, or when given to players).
     *
     * @return the item representing this block effect
     */
    public abstract ItemStack getBlock();

    /**
     * Returns a unique string key that identifies this block effect.
     * <p>⚠️ Do not return a duplicate key shared by another effect.</p>
     *
     * @return the unique key used to register this effect in {@link EffectManager}
     */
    public abstract String getBlockKey();

    /**
     * Whether this effect should use language translation keys.
     * <p>If {@code true}, {@link #getItemNameKey()} must return a valid key.</p>
     *
     * @return true to enable lang support, false to use raw names
     */
    public boolean useLang() {
        return false;
    }

    /**
     * Returns the internal item name key used for language file lookup.
     * <p>Only required if {@link #useLang()} returns true.</p>
     *
     * @return the language key used in translation files
     */
    public String getItemNameKey() {
        return "";
    }

    /**
     * Returns the full translation key used for item name display.
     * <p>Example result: {@code item.effect-block.wool.name}</p>
     *
     * @return the full item name translation key
     */
    public final String getEffectItemName() {
        return "item.effect-block." + getItemNameKey() + ".name";
    }

    /**
     * Returns the full translation key used for item lore display.
     * <p>Example result: {@code item.effect-block.wool.lore}</p>
     *
     * @return the full item lore translation key
     */
    public final String getEffectItemLore() {
        return "item.effect-block." + getItemNameKey() + ".lore";
    }

    /**
     * @deprecated
     * Use {@link #registerBlockEffect(EffectAddon)} instead to ensure proper addon tracking.
     * <p>
     * Registers this block effect into the {@link EffectManager}.
     * <p>Typically called in {@code onEnable()}.</p>
     */
    @Deprecated
    public final void registerBlockEffect() {
        EffectManager.playerBlockEffect.put(getBlockKey(), this);
        PureAPI.getPlugin().getLogger().warning("Effect "+getBlock().getType()+"/"+getBlockKey()+" is still using LEGACY API!");
    }
    /**
     * Registers this block effect into the {@link EffectManager}.
     * <p>Typically called in {@code onEnable()}.</p>
     */
    public final void registerBlockEffect(EffectAddon addon) {
        EffectManager.playerBlockEffect.put(getBlockKey(), this);
        this.addon=addon;
    }

    /**
     * Unregisters this block effect from the {@link EffectManager}.
     * <p>Typically called in {@code onDisable()}.</p>
     * <p>Replaces it with a fallback {@link WoolBlockEffect}.</p>
     */
    public final void unregisterBlockEffect() {
        EffectManager.playerBlockEffect.put(getBlockKey(), new WoolBlockEffect());
    }
}
