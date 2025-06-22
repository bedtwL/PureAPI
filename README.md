# PureAPI - An API for bedtwL Server PureFFA addons!

BlockEffect.java
```java
package me.bedtwL.ffa.api;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
// 創一個class 實現這個interface
public interface BlockEffect {
    void onBlockPlace(Block block);
    ItemStack getBlock();
    String getBlockKey();
    // 要不要用語言系統
    default Boolean useLang() {
        return false;
    }
    // 你的effect的名字 如果useLang是true 就一定要填這個
    default String getItemNameKey() {
        return "";
    }
    // 不要動 最終選單出現的名字
    default String getEffectItemName() {
        return "item.effect-block."+getItemNameKey()+".name";
    }
    // 不要動 名字下面的字
    default String getEffectItemLore() {
        return "item.effect-block."+getItemNameKey()+".lore";
    }
    // 註冊這個effect
    default void registerBlockEffect() {
        EffectManager.playerBlockEffect.put(getBlockKey(),this);
    }
    // 取消註冊effect
    default void unregisterBlockEffect() {
        EffectManager.playerBlockEffect.put(getBlockKey(),new WoolBlockEffect());
    }
}
```

EffectAddon.java
```java
package me.bedtwL.ffa.api;
// 一樣創class實現這個
public interface EffectAddon {
    // addon名字
    String getName();
    // 你的名字
    String getAuthor();
    // PureFFA插件enable的時候做的事 通常是reguster effects
    void onEnable();
    // PureFFA插件第一次載入你的addon的時候做的事
    default void onFirstLoad() {
    }
    // PureFFA插件disable的時候做的事 通常是unregister effects
    void onDisable();
}
```
EffectManager.java
```java
package me.bedtwL.ffa.api;

import java.util.HashMap;
// 管理addons的
public class EffectManager {
    public static HashMap<String,PlayerHitEffect> playerHitEffects = new HashMap<>();
    public static HashMap<String,PlayerKillEffect> playerKillEffects = new HashMap<>();
    public static HashMap<String,PlayerArrowHitEffect> playerArrowHitEffects = new HashMap<>();
    public static HashMap<String,PlayerArrowShootEffect> playerArrowShootEffects = new HashMap<>();
    public static HashMap<String,BlockEffect> playerBlockEffect = new HashMap<>();
}
```
NoneEffect.java
```java
package me.bedtwL.ffa.api;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
// 這個class實現打擊 擊殺 箭矢射出及擊中的特效
public class NoneEffect implements PlayerHitEffect, PlayerKillEffect,PlayerArrowHitEffect,PlayerArrowShootEffect {
    
    // addon名字
    @Override
    public String getName() {
        return "none";
    }
   
    // effect名字
    @Override
    public String getItemNameKey() {
        return "none";
    }

    // effect圖示
    @Override
    public ItemStack getItemBase() {
        return new ItemStack(Material.BARRIER);
    }

    // 打擊特效 location, player都是受到打擊的人
    @Override
    public void hitEffect(Location location, Player player) {
    }

    // 擊殺特效 跟上面的arg一樣
    @Override
    public void killEffect(Location location, Player player) {
    }

    // 箭矢擊中特效 還是跟上面arg一樣
    @Override
    public void ArrowHitEffect(Location location, Player player) {
    }

    // 箭矢射出特效 箭矢飛過去的粒子 arg還是一樣
    @Override
    public void ArrowShootEffect(Location location, Player player) {
    }
}
```
PlayerArrowHitEffect.java
```java
package me.bedtwL.ffa.api;

import org.bukkit.Location;
import org.bukkit.entity.Player;
// 還是一樣創class實現
public interface PlayerArrowHitEffect extends effectBase{
    // location, player都是箭矢射到的人
    void ArrowHitEffect(Location location, Player player);
    // 不用動 註冊effect
    default void registerArrowHitEffect() {
        EffectManager.playerArrowHitEffects.put(getName(),this);
    }
    // 不用動 取消註冊effect
    default void unregisterArrowHitEffect() {
        EffectManager.playerArrowHitEffects.put(getName(),new NoneEffect());
    }
}
```
PlayerArrowShotEffect.java
```java
package me.bedtwL.ffa.api;

import org.bukkit.Location;
import org.bukkit.entity.Player;
// 還是創class實現
public interface PlayerArrowShootEffect extends effectBase{
    // 箭矢飛過去的例子
    void ArrowShootEffect(Location location, Player player);
    // 不用動 註冊effect
    default void registerArrowShootEffect() {
        EffectManager.playerArrowShootEffects.put(getName(),this);
    }
    // 不用動 取消註冊effect
    default void unregisterArrowShootEffect() {
        EffectManager.playerArrowShootEffects.put(getName(),new NoneEffect());
    }
}
```
PlayerHitEffect.java
```java
package me.bedtwL.ffa.api;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface PlayerHitEffect extends effectBase{
    // 打擊特效 arg一樣
    void hitEffect(Location location, Player player);
    default void registerHitEffect() {
        EffectManager.playerHitEffects.put(getName(),this);
    }
    default void unregisterHitEffect() {
        EffectManager.playerHitEffects.put(getName(),new NoneEffect());
    }
}
```
PlayerKillEffect.java
```java
package me.bedtwL.ffa.api;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface PlayerKillEffect extends effectBase{
    // 擊殺特效 arg一樣
    default void killEffect(Location location, Player player) {

    }
    default void killEffect(Location location, Player victim,Player killer) {

    }
    default void registerKillEffect() {
        EffectManager.playerKillEffects.put(getName(),this);
    }
    default void unregisterKillEffect() {
        EffectManager.playerHitEffects.put(getName(),new NoneEffect());
    }
}
```
PureFFA.java
```java
package me.bedtwL.ffa.api;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class PureAPI {
    // 插件instance
    @Getter
    private static JavaPlugin plugin;
    // 設定插件instance
    public static void setInstance(JavaPlugin instance) {
        if (plugin==null)
            plugin=instance;
    }
}
```
WoolBlockEffect.java
```java
package me.bedtwL.ffa.api;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class WoolBlockEffect implements BlockEffect{

    // 羊毛 後面一定要64(一組
    public static ItemStack cacheWool=new ItemStack(Material.WOOL,64);

    // 放置方塊要做的事
    @Override
    public void onBlockPlace(Block block) {
    }

    // 獲取方塊
    @Override
    public ItemStack getBlock() {
        return cacheWool;
    }
    
    // effect名稱
    @Override
    public String getBlockKey() {
        return "wool";
    }
}
```
effectBase.java
```java
package me.bedtwL.ffa.api;

import org.bukkit.inventory.ItemStack;
// effect最核心
public interface effectBase {
    // 取得名稱
    String getName();
    /// items.effect.(blablabla).(lore/name)
    // effect的名稱
    String getItemNameKey();
    // effect圖示
    ItemStack getItemBase();
    // effect圖示的物品名稱
    default String getEffectItemName() {
        return "item.effect."+getItemNameKey()+".name";
    }
    // 圖示的物品名稱下面的字
    default String getEffectItemLore() {
        return "item.effect."+getItemNameKey()+".lore";
    }
}
```
