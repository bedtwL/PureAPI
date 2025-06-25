package me.bedtwL.ffa.api.game;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public abstract class PureArenaModule {
    public void onLoad(PureArenaSettings settings) {}
    public void onPlayerJoin(PureArenaSettings settings, Player p) {}
    public void onPlayerQuit(PureArenaSettings settings, Player p) {}
    public void onEntityDamageByEntity(PureArenaSettings settings, EntityDamageByEntityEvent e) {}
    public void onPlayerDeath(PureArenaSettings settings, PlayerDeathEvent e) {}
    public void onPlayerDeath(PureArenaSettings settings, Player killer, Player victim, EntityDamageEvent.DamageCause cause) {}
    public boolean onPlayerDeathA(PureArenaSettings settings, PlayerDeathEvent e) {return false;}
    public boolean onPlayerDeathA(PureArenaSettings settings, Player killer, Player victim, EntityDamageEvent.DamageCause cause) {return false;}
}
