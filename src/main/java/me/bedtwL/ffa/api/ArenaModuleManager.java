package me.bedtwL.ffa.api;

import me.bedtwL.ffa.api.game.PureArenaModule;

import java.util.HashMap;
import java.util.Map;

public class ArenaModuleManager {
    public static Map<String, Class<? extends PureArenaModule>> arenaModules = new HashMap<>();

}
