package me.bedtwL.ffa.api.none;

import me.bedtwL.ffa.api.PureArrowHitEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class NoneArrowHitEffect extends PureArrowHitEffect {
    @Override
    public void arrowHitEffect(Location location, Player player) {
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
