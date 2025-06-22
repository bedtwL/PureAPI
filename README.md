# PureAPI - An API for bedtwL Server PureFDA addons!

BlockEffect.java
```java
package me.bedtwL.ffa.api;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

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
        EffectManager.playerBlockEffect.put(getBlockKey(),this);
    }
    default void unregisterBlockEffect() {
        EffectManager.playerBlockEffect.put(getBlockKey(),new WoolBlockEffect());
    }
}```