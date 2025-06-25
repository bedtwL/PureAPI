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

/**
 * Base class for all custom Arena Game Modules used in FFA gameplay.
 * Extend this class to implement custom logic for player actions and events within the arena.
 */
public abstract class PureArenaModule {

    /** The addon this module belongs to (usually passed during registration). */
    public EffectAddon addon;

    /** Constructor for PureArenaModule. */
    public PureArenaModule() {}

    /**
     * Registers this game module to the {@link ArenaModuleManager}.
     * Typically called during plugin {@code onEnable()}.
     *
     * @param addon the {@link EffectAddon} this module belongs to
     */
    public final void registerGameModule(EffectAddon addon) {
        ArenaModuleManager.arenaModules.put(getName(), this.getClass());
        ArenaModuleManager.arenaModuleQuickLoad.put(getName(), this);
        this.addon = addon;
    }

    /**
     * Unregisters this game module from the {@link ArenaModuleManager}.
     * Typically called during plugin {@code onDisable()}.
     */
    public final void unregisterGameModule() {
        ArenaModuleManager.arenaModules.put(getName(), null);
        ArenaModuleManager.arenaModuleQuickLoad.put(getName(), null);
    }

    /**
     * Returns the unique name identifier of this game module.
     *
     * @return the module name
     */
    public abstract String getName();

    /**
     * Returns the item name key used for translation.
     * Used to build translation paths like "item.game.{key}.name" and "item.game.{key}.lore".
     *
     * @return the item translation key
     */
    public abstract String getItemNameKey();

    /**
     * Returns the base item stack that visually represents this module.
     *
     * @return the display item
     */
    public abstract ItemStack getItemBase();

    /**
     * Gets the full translation key for the module's item name.
     *
     * @return translation key string
     */
    public final String getGameItemName() {
        return "item.game." + getItemNameKey() + ".name";
    }

    /**
     * Gets the full translation key for the module's item lore.
     *
     * @return translation key string
     */
    public final String getGameUiItemLore() {
        return "item.game." + getItemNameKey() + ".lore";
    }

    /**
     * Called when the module is loaded.
     *
     * @param settings the arena settings
     */
    public void onLoad(PureArenaSettings settings) {}

    /**
     * Called when a player respawns.
     *
     * @param settings the arena settings
     * @param victim the player respawning
     * @return true if handled, false to continue with default logic
     */
    public boolean onPlayerRespawn(PureArenaSettings settings, Player victim) { return false; }

    /**
     * Called when a player joins the arena.
     *
     * @param settings the arena settings
     * @param p the joining player
     */
    public void onPlayerJoin(PureArenaSettings settings, Player p) {}

    /**
     * Called when a player quits the arena.
     *
     * @param settings the arena settings
     * @param p the quitting player
     */
    public void onPlayerQuit(PureArenaSettings settings, Player p) {}

    /**
     * Called when an entity is damaged by another entity.
     *
     * @param settings the arena settings
     * @param e the event
     */
    public void onEntityDamageByEntity(PureArenaSettings settings, EntityDamageByEntityEvent e) {}

    /**
     * Intercepts entity damage and optionally cancels further processing.
     *
     * @param settings the arena settings
     * @param e the event
     * @return true to cancel further event handling
     */
    public boolean onEntityDamageByEntityB(PureArenaSettings settings, EntityDamageByEntityEvent e) { return false; }

    /**
     * Called when a player places a block.
     *
     * @param settings the arena settings
     * @param e the event
     */
    public void onPlayerBlockPlace(PureArenaSettings settings, BlockPlaceEvent e) {}

    /**
     * Intercepts block place and optionally cancels further processing.
     *
     * @param settings the arena settings
     * @param e the event
     * @return true to cancel further event handling
     */
    public boolean onPlayerBlockPlaceB(PureArenaSettings settings, BlockPlaceEvent e) { return false; }

    /**
     * Called when a block is broken.
     *
     * @param settings the arena settings
     * @param e the event
     */
    public void onBlockBreak(PureArenaSettings settings, BlockBreakEvent e) {}

    /**
     * Determines if block break should end the game.
     *
     * @param settings the arena settings
     * @param e the event
     * @return true to end the game
     */
    public boolean onBlockBreakA(PureArenaSettings settings, BlockBreakEvent e) { return false; }

    /**
     * Intercepts block break and optionally cancels further processing.
     *
     * @param settings the arena settings
     * @param e the event
     * @return true to cancel further event handling
     */
    public boolean onBlockBreakB(PureArenaSettings settings, BlockBreakEvent e) { return false; }

    /**
     * Called when a player dies.
     *
     * @param settings the arena settings
     * @param e the event
     */
    public void onPlayerDeath(PureArenaSettings settings, PlayerDeathEvent e) {}

    /**
     * Called when a player moves.
     *
     * @param settings the arena settings
     * @param e the event
     */
    public void onPlayerMove(PureArenaSettings settings, PlayerMoveEvent e) {}

    /**
     * Determines if movement should end the game.
     *
     * @param settings the arena settings
     * @param e the event
     * @return true to end the game
     */
    public boolean onPlayerMoveA(PureArenaSettings settings, PlayerMoveEvent e) { return false; }

    /**
     * Called when a player kills another player.
     *
     * @param settings the arena settings
     * @param killer the killer
     * @param victim the player who died
     * @param cause the cause of death
     */
    public void onPlayerDeath(PureArenaSettings settings, Player killer, Player victim, EntityDamageEvent.DamageCause cause) {}

    /**
     * Determines if player death should end the game (event-based version).
     *
     * @param settings the arena settings
     * @param e the event
     * @return true to end the game
     */
    public boolean onPlayerDeathA(PureArenaSettings settings, PlayerDeathEvent e) { return false; }

    /**
     * Determines if player death should end the game (cause-based version).
     *
     * @param settings the arena settings
     * @param killer the killer
     * @param victim the victim
     * @param cause the cause of death
     * @return true to end the game
     */
    public boolean onPlayerDeathA(PureArenaSettings settings, Player killer, Player victim, EntityDamageEvent.DamageCause cause) { return false; }

    /**
     * Returns a list of lines to display on the scoreboard for the given player.
     *
     * @param settings the arena settings
     * @param p the player
     * @param language the player's language settings
     * @return list of scoreboard lines
     */
    public ArrayList<String> getScoreboardLines(PureArenaSettings settings, Player p, PlayerLanguage language) {
        return new ArrayList<>();
    }
}
