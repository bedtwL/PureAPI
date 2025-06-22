package me.bedtwL.ffa.api;

import me.bedtwL.ffa.api.effect.PureArrowShootEffect;
import me.bedtwL.ffa.api.effect.PureBlock;
import me.bedtwL.ffa.api.effect.PureHitEffect;
import me.bedtwL.ffa.api.effect.PureKillEffect;

import java.util.HashMap;

public class EffectManager {
    public static HashMap<String, PureHitEffect> playerHitEffects = new HashMap<>();
    public static HashMap<String, PureKillEffect> playerKillEffects = new HashMap<>();
    public static HashMap<String, me.bedtwL.ffa.api.PureArrowHitEffect> playerArrowHitEffects = new HashMap<>();
    public static HashMap<String, PureArrowShootEffect> playerArrowShootEffects = new HashMap<>();
    public static HashMap<String, PureBlock> playerBlockEffect = new HashMap<>();
}
