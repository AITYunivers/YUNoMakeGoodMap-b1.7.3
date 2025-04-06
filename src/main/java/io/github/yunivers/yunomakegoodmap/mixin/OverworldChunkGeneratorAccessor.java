package io.github.yunivers.yunomakegoodmap.mixin;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.OverworldChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Random;

@Mixin(OverworldChunkGenerator.class)
public interface OverworldChunkGeneratorAccessor
{
    @Accessor("random")
    Random getRandom();

    @Accessor("world")
    World getWorld();

    @Accessor("biomes")
    Biome[] getBiomes();

    @Accessor("biomes")
    void setBiomes(Biome[] biomes);
}
