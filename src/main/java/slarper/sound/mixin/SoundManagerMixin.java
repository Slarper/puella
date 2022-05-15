package slarper.sound.mixin;

import net.minecraft.client.sound.SoundEntry;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SoundManager.class)
public class SoundManagerMixin {
    @Redirect(
            method = "prepare(Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)Lnet/minecraft/client/sound/SoundManager$SoundList;",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/sound/SoundManager$SoundList;register(Lnet/minecraft/util/Identifier;Lnet/minecraft/client/sound/SoundEntry;Lnet/minecraft/resource/ResourceManager;)V"
            )
    )
    private void registerToSoundList(SoundManager.SoundList instance, Identifier id, SoundEntry entry, ResourceManager resourceManager){
        if (id.getPath().startsWith("minecraft.")){
            ((SoundListAccessor)instance).invokeRegister(new Identifier("minecraft",id.getPath().substring(10)), entry, resourceManager);
        } else {
            ((SoundListAccessor)instance).invokeRegister(id, entry, resourceManager);
        }
    }
}
