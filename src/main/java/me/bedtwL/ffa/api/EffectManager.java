package me.bedtwL.ffa.api;

import java.util.HashMap;

public class EffectManager {
    public static HashMap<String,PlayerHitEffect> playerHitEffects = new HashMap<>();
    public static HashMap<String,PlayerKillEffect> playerKillEffects = new HashMap<>();
    public static HashMap<String,PlayerArrowHitEffect> playerArrowHitEffects = new HashMap<>();
    public static HashMap<String,PlayerArrowShootEffect> playerArrowShootEffects = new HashMap<>();
    public static HashMap<String,BlockEffect> playerBlockEffect = new HashMap<>();
}
