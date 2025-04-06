package io.github.yunivers.yunomakegoodmap.mixin;

import net.minecraft.block.Block;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.chunk.OverworldChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(OverworldChunkGenerator.class)
public abstract class OverworldChunkGeneratorMixin implements OverworldChunkGeneratorAccessor
{
    /**
     * @author YUNoMakeGoodMap
     * @reason Removes chunk generation
     */
    @Overwrite
    public Chunk getChunk(int chunkX, int chunkZ)
    {
        getRandom().setSeed((long)chunkX * 341873128712L + (long)chunkZ * 132897987541L);
        byte[] var3 = new byte[16*16*128];
        Chunk var4 = new Chunk(getWorld(), var3, chunkX, chunkZ);
        setBiomes(getWorld().method_1781().getBiomesInArea(getBiomes(), chunkX * 16, chunkZ * 16, 16, 16));
        var4.populateHeightMap();
        return var4;
    }
}
