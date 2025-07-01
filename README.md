# PureAPI - An API for bedtwL Server PureFFA addons!

To start working with this, you must add to the following things to your pom.xml

```xml
<repository>
            <id>bedtwl-repo</id>
            <url>https://mvn.bedtwl.com/maven-repo/</url>
        </repository>
```

```xml
<dependency>
            <groupId>me.bedtwL</groupId>
            <artifactId>PureAPI</artifactId>
            <version>1.0-RELEASE</version>
            <scope>provided</scope>
        </dependency>
```

# Guide
### Wrote by ItsGlobally. Any grammer error, dm me on discord.
Today, we will make an effect addon.

At the first, we do the things above.
As what I said, add the lines to your pom.xml.

After we've done that, we will create a main class, `AddonMainClass`.

```java

package me.itsglobally.addon.ffa;

public class AddonMainClass implements EffectAddon {
  @Override
    public Integer getAPIVer() {return 1;} // This tells server you're using the right api version.
    // This is your addon name.
    @Override
    public String getName() {
        return "MyEffect";
    }
    // This is your name. If someone else helped you with your work, you can add his/her name. Like "ItsGlobally bedtwL Gayson"
    @Override
    public String getAuthor() {
        return "ItsGlobally";
    }
    // This is your uuid. You must provide the vaild uuid.
    @Override
    public UUID authorUUID() {
        return UUID.fromString("748c3863-c04d-493b-bce3-05a1765a5b56");
    }
    // Here goes your code when the addon enables.
    @Override
    public void onEnable() {
        new MyHitEffect().registerHitEffect(this);
    }
    // Here goes your code when the addon disables.
    @Override
    public void onDisable() {
        new MyHitEffect().unregisterHitEffect();
    }
}
```

Don't forget to hit `Ctrl` + `S` to save your work!

Now, we create a class `MyHitEffect`.

```java
package me.itsglobally.addon.ffa;

import me.bedtwL.ffa.api.effect.PureHitEffect;

public class MyHitEffect extends PureHitEffect {
    // Like an event, server will call this when the player gets a hit.
    @Override
    public void hitEffect(Location location, Player player) {
        playEffect(location);
    }
    // Effect name.
    @Override
    public String getName() {
        return "redstone";
    }
    // The name that displays in the menu.
    @Override
    public String getItemNameKey() {
        return "redstone";
    }
    // The item that displays in the menu.
    @Override
    public ItemStack getItemBase() {
        return new ItemStack(Material.REDSTONE);
    }
    // This is called from hitEffect.
    public static void playEffect(Location location) {
        // This code lets players see the redstone block break effect and gives you step sound.
        for (int i = 0; i < 1; i++) {
            location.getWorld().playEffect(location, Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
        }

    }
}
// (I DID NOT STEAL FROM BED'S BLOOD EFFECT!!!!)
```

Again, don't forget to hit `Ctrl` + `S` to save!

Now we've done all. We can upload all your code to github!
