package me.bedtwL.ffa.api;

import org.bukkit.inventory.ItemStack;

/**
 * Base interface for all effect types.
 *
 * <p>
 * Provides common method signatures for effect identification and base item representation.
 * This interface is currently used by many effect implementations but is planned for deprecation
 * in favor of new abstract base classes with safer method contracts.
 * </p>
 *
 * <p><b>Note for developers:</b></p>
 * <ul>
 *   <li>It is recommended to migrate effect implementations away from this interface and instead
 *       extend the corresponding abstract classes like {@code PureBlock}, {@code PureKillEffect}, or {@code PureHitEffect}.</li>
 *   <li>When ready, remove the {@code implements effectBase} clause from your classes and
 *       update method signatures accordingly.</li>
 *   <li>The default methods {@link #getEffectItemName()} and {@link #getEffectItemLore()} are deprecated
 *       and should be avoided in new code.</li>
 * </ul>
 *
 * @deprecated This interface will be removed in future versions.
 */
@Deprecated
public interface effectBase {
    /**
     * Returns the unique name identifier of this effect.
     *
     * @return the effect name string
     */
    String getName();

    /**
     * Returns the key used for item name/lore translation lookups.
     * This key is appended to translation path prefixes like "item.effect.".
     *
     * @return the item name key
     */
    String getItemNameKey();

    /**
     * Returns the base {@link ItemStack} that visually represents this effect,
     * such as the item displayed in menus or given to players.
     *
     * @return the base item stack
     */
    ItemStack getItemBase();

    /**
     * @deprecated Use explicit language handling or utility classes instead.
     * Returns the translation key for the effect's item name.
     * Typical format: "item.effect.{itemNameKey}.name"
     *
     * @return the translation key for the effect item name
     */
    @Deprecated
    default String getEffectItemName() {
        return "item.effect." + getItemNameKey() + ".name";
    }

    /**
     * @deprecated Use explicit language handling or utility classes instead.
     * Returns the translation key for the effect's item lore.
     * Typical format: "item.effect.{itemNameKey}.lore"
     *
     * @return the translation key for the effect item lore
     */
    @Deprecated
    default String getEffectItemLore() {
        return "item.effect." + getItemNameKey() + ".lore";
    }
}
