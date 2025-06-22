package me.bedtwL.ffa.api;

import me.bedtwL.ffa.api.none.WoolBlockEffect;
import me.bedtwL.ffa.api.warpper.LegacyPureBlock;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

/**
 * @deprecated This interface is now deprecated and will be removed in future versions.
 * <p>
 * ➤ Replace `BlockEffect` with {@link me.bedtwL.ffa.api.effect.PureBlock}.
 * ➤ Update all implementations to `extend PureBlock` instead of `implement BlockEffect`.
 * <p>
 * Migration Example:
 * <p>
 * OLD:
 * public class WoolBlockEffect implements BlockEffect
 * <p>
 * NEW:
 * public class WoolBlockEffect extends PureBlock
 */
@Deprecated
public interface BlockEffect {
    void onBlockPlace(Block block);
    ItemStack getBlock();
    String getBlockKey();
    default Boolean useLang() {
        return false;
    }
    default String getItemNameKey() {
        return "";
    }
    default String getEffectItemName() {
        return "item.effect-block."+getItemNameKey()+".name";
    }
    default String getEffectItemLore() {
        return "item.effect-block."+getItemNameKey()+".lore";
    }
    default void registerBlockEffect() {
        EffectManager.playerBlockEffect.put(getBlockKey(),new LegacyPureBlock(this));
    }
    default void unregisterBlockEffect() {
        EffectManager.playerBlockEffect.put(getBlockKey(),new WoolBlockEffect());
    }
}
