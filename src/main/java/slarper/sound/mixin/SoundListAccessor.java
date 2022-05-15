package slarper.sound.mixin;

import net.minecraft.client.sound.SoundEntry;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SoundManager.SoundList.class)
public interface SoundListAccessor {
    @Invoker("register")
    void invokeRegister(Identifier id, SoundEntry entry, ResourceManager resourceManager);
}
