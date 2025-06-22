# PureAPI - An API for bedtwL Server PureFDA addons!

BlockEffect.java
```java
package me.bedtwL.ffa.api;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
// 創一個class 實現這個interface
public interface BlockEffect {
   
    void onBlockPlace(Block block);
    ItemStack getBlock();
    String getBlockKey();
    // 要不要用語言系統
    default Boolean useLang() {
        return false;
    }
    // 你的effect的名字
    default String getItemNameKey() {
        return "";
    }
    // 最終選單出現的名字
    default String getEffectItemName() {
        return "item.effect-block."+getItemNameKey()+".name";
    }
    // 名字下面的字
    default String getEffectItemLore() {
        return "item.effect-block."+getItemNameKey()+".lore";
    }
    // 註冊這個effect
    default void registerBlockEffect() {
        EffectManager.playerBlockEffect.put(getBlockKey(),this);
    }
    // 取消註冊effect
    default void unregisterBlockEffect() {
        EffectManager.playerBlockEffect.put(getBlockKey(),new WoolBlockEffect());
    }
}```