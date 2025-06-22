package me.bedtwL.ffa.api.none;

import me.bedtwL.ffa.api.effect.PureKillEffect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class NoneKillEffect extends PureKillEffect {
    @Override
    public String getName() {
        return "none";
    }

    @Override
    public String getItemNameKey() {
        return "none";
    }

    @Override
    public ItemStack getItemBase() {
        return new ItemStack(Material.BARRIER);
    }
}
