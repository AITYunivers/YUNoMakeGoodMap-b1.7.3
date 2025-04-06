package io.github.yunivers.yunomakegoodmap.generators;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.dimension.OverworldDimension;

public class TreePlatform implements IPlatformGenerator
{
    @Override
    public void generate(World world, int x, int y, int z)
    {
        if (!(world.dimension instanceof OverworldDimension))
            return;

        world.setBlock(x, y, z, Block.GRASS_BLOCK.id);
        world.setBlock(x, y + 6, z, Block.LEAVES.id);
        for (int i = 1; i <= 5; i++)
            world.setBlock(x, y + i, z, Block.LOG.id);
        for (int k = 3; k <= 5; k++)
        {
            int width = (k == 5 ? 1 : 2);
            for (int i = -width; i <= width; i++)
            {
                for (int j = -width; j <= width; j++)
                {
                    if (i != 0 || j != 0)
                        world.setBlock(x + i, y + k, z + j, Block.LEAVES.id);
                }
            }
        }
    }
}
