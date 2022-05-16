**Module Name** : amitaro

**Usage** : for vanilla sounds replacement

**Principle** :

When Minecraft loads sounds from resourcepacks (in `net.minecraft.client.sound.SoundManager::prepare`), it reads `<namespace>:sounds.json` from all namespaces and parse them.

For example, if there is a sounds.json in `assets/<modid>/sounds.json`:

```json
{
  "entity.player.burp": {
    "sounds": [
      "<modid>:<sound_file_name>"
    ]
  }
}
```

Then Minecraft will register the "sounds" for SoundEvent `"<modid>:entity.player.burp"`.

so the sounds.json must be put into namespace "minecraft" for vanilla sounds replacement.

**Thanks** :

[あみたろ　さん](https://amitaro.net/about/profile/) for her beautiful voice.