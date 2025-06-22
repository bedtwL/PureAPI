package me.bedtwL.ffa.api.none;

import me.bedtwL.ffa.api.effect.PureHitEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class NoneHitEffect extends PureHitEffect {
    @Override
    public void hitEffect(Location location, Player player) {

    }

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
