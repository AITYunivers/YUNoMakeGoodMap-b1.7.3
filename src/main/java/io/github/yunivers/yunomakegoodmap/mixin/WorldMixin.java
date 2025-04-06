package io.github.yunivers.yunomakegoodmap.mixin;

import io.github.yunivers.yunomakegoodmap.config.Config;
import io.github.yunivers.yunomakegoodmap.generators.*;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(World.class)
public class WorldMixin
{
    @Inject(
        method = "initializeSpawnPoint",
        at = @At("HEAD")
    )
    protected void initializeSpawnPoint(CallbackInfo ci) {
        World world = (World)(Object)this;
        IPlatformGenerator platform = switch (Config.config.platformType) {
            case GRASS -> new SingleBlockPlatform(Block.GRASS_BLOCK);
            case TREE -> new TreePlatform();
            case SKYBLOCK21 -> new Skyblock21Platform();
        };
        platform.generate(world, 0, 64, 0);
    }
}
