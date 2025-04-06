package io.github.yunivers.yunomakegoodmap.generators;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.OverworldDimension;

public class SingleBlockPlatform implements IPlatformGenerator
{
    private Block block;

    public SingleBlockPlatform(Block block)
    {
        this.block = block;
    }

    @Override
    public void generate(World world, int x, int y, int z)
    {
        if (!(world.dimension instanceof OverworldDimension))
            return;

        world.setBlock(x, y, z, block.id);
    }
}
