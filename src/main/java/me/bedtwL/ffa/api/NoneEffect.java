package me.bedtwL.ffa.api;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class NoneEffect implements PlayerHitEffect, PlayerKillEffect,PlayerArrowHitEffect,PlayerArrowShootEffect {

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

    @Override
    public void hitEffect(Location location, Player player) {
    }

    @Override
    public void killEffect(Location location, Player player) {
    }

    @Override
    public void ArrowHitEffect(Location location, Player player) {
    }

    @Override
    public void ArrowShootEffect(Location location, Player player) {
    }
}
