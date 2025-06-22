package me.bedtwL.ffa.api.warpper;

import me.bedtwL.ffa.api.BlockEffect;
import me.bedtwL.ffa.api.effect.PureBlock;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

/**
 * @deprecated This interface is being replaced by the abstract class {@link BlockEffect}.
 * Please extend BlockEffect instead for safer and future-proof implementation.
 */
public class LegacyPureBlock extends PureBlock {
    private final BlockEffect legacy;

    public LegacyPureBlock(BlockEffect legacy) {
        this.legacy = legacy;
    }

    @Override
    public void onBlockPlace(Block block) {
        legacy.onBlockPlace(block);
    }

    @Override
    public ItemStack getBlock() {
        return legacy.getBlock();
    }

    @Override
    public String getBlockKey() {
        return legacy.getBlockKey();
    }

    @Override
    public boolean useLang() {
        return legacy.useLang();
    }

    @Override
    public String getItemNameKey() {
        return legacy.getItemNameKey();
    }
}
