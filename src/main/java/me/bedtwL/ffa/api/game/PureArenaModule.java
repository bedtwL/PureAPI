package me.bedtwL.ffa.api.game;

import me.bedtwL.ffa.api.ArenaModuleManager;
import me.bedtwL.ffa.api.EffectAddon;
import me.bedtwL.ffa.api.language.PlayerLanguage;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public abstract class PureArenaModule {
    public EffectAddon addon;
    public PureArenaModule() {}
    /**
     * Registers this arrow shoot effect into the {@link ArenaModuleManager}.
     * Usually called during plugin {@code onEnable()}.
     */
    public final void registerGameModule(EffectAddon addon) {
        ArenaModuleManager.arenaModules.put(getName(), this.getClass());
        this.addon=addon;
    }

    /**
     * Unregisters this arrow shoot effect from the {@link ArenaModuleManager},
     * replacing it with {@link null}.
     * Usually called during plugin {@code onDisable()}.
     */
    public final void unregisterGameModule() {
        ArenaModuleManager.arenaModules.put(getName(), null);
    }

    /**
     * Returns the unique name identifier of this game module.
     *
     * @return the effect name string
     */
    public abstract String getName();

    /**
     * Returns the key used for item name and lore translation lookups.
     * This key is appended to translation path prefixes like "item.game.".
     *
     * @return the item name key string
     */
    public abstract String getItemNameKey();

    /**
     * Returns the base {@link ItemStack} that visually represents this game module,
     * such as the item displayed in menus or given to players.
     *
     * @return the base item stack
     */
    public abstract ItemStack getItemBase();

    /**
     * Returns the full translation key for the game's item name.
     * <p>
     * This method is final to ensure consistent translation key formatting.
     * The returned key follows the pattern: "item.game.{itemNameKey}.name"
     * </p>
     *
     * @return the full translation key for the game's item name
     */
    public final String getGameItemName() {
        return "item.game." + getItemNameKey() + ".name";
    }

    /**
     * Returns the full translation key for the game's item lore.
     * <p>
     * This method is final to ensure consistent translation key formatting.
     * The returned key follows the pattern: "item.game.{itemNameKey}.lore"
     * </p>
     *
     * @return the full translation key for the game's item lore
     */
    public final String getGameUiItemLore() {
        return "item.game." + getItemNameKey() + ".lore";
    }
    public void onLoad(PureArenaSettings settings) {}
    public boolean onPlayerRespawn(PureArenaSettings settings, Player victim) {return false;}
    public void onPlayerJoin(PureArenaSettings settings, Player p) {}
    public void onPlayerQuit(PureArenaSettings settings, Player p) {}
    public void onEntityDamageByEntity(PureArenaSettings settings, EntityDamageByEntityEvent e) {}
    public boolean onEntityDamageByEntityB(PureArenaSettings settings, EntityDamageByEntityEvent e) {return false;}
    public void onPlayerBlockPlace(PureArenaSettings settings, BlockPlaceEvent e) {}
    // dont cancel the event if return true
    public boolean onPlayerBlockPlaceB(PureArenaSettings settings, BlockPlaceEvent e) {return false;}
    public void onBlockBreak(PureArenaSettings settings, BlockBreakEvent e) {}
    // if end game then return true
    public boolean onBlockBreakA(PureArenaSettings settings, BlockBreakEvent e) {return false;}
    // dont cancel the event if return true
    public boolean onBlockBreakB(PureArenaSettings settings, BlockBreakEvent e) {return false;}
    public void onPlayerDeath(PureArenaSettings settings, PlayerDeathEvent e) {}
    public void onPlayerMove(PureArenaSettings settings, PlayerMoveEvent e) {}
    public void onPlayerDeath(PureArenaSettings settings, Player killer, Player victim, EntityDamageEvent.DamageCause cause) {}
    public boolean onPlayerDeathA(PureArenaSettings settings, PlayerDeathEvent e) {return false;}
    public boolean onPlayerDeathA(PureArenaSettings settings, Player killer, Player victim, EntityDamageEvent.DamageCause cause) {return false;}
    public ArrayList<String> getScoreboardLines(PureArenaSettings settings, Player p, PlayerLanguage language) {return new ArrayList<>();}
}
