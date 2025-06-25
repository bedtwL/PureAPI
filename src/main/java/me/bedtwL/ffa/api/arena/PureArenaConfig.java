package me.bedtwL.ffa.api.arena;

import lombok.Data;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.UUID;

@Data
public abstract class PureArenaConfig {
    private Location spawnPoint;
    private Integer heightLimit;
    private Integer voidHeight;
    private String kitName;
    private ArenaType arenaType;
    private String baseWorldName;
    private String arenaName;
    private World.Environment worldEnv;
    private Integer inGameY;
    private File configFile;
    private UUID arenaBuildMgr;
    private FileConfiguration configuration;
    private String arenaGameType;
}
