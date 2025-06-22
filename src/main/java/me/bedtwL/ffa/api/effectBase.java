package me.bedtwL.ffa.api;

import org.bukkit.inventory.ItemStack;

public interface effectBase {
    String getName();
    /// items.effect.(blablabla).(lore/name)
    String getItemNameKey();
    ItemStack getItemBase();
    default String getEffectItemName() {
        return "item.effect."+getItemNameKey()+".name";
    }
    default String getEffectItemLore() {
        return "item.effect."+getItemNameKey()+".lore";
    }
}
