package me.bedtwL.ffa.api;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class WoolBlockEffect implements BlockEffect{
    public static ItemStack cacheWool=new ItemStack(Material.WOOL,64);
    @Override
    public void onBlockPlace(Block block) {
    }

    @Override
    public ItemStack getBlock() {
        return cacheWool;
    }

    @Override
    public String getBlockKey() {
        return "wool";
    }
}
