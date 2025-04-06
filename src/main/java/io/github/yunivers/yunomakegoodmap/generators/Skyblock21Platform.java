package io.github.yunivers.yunomakegoodmap.generators;

import net.minecraft.block.Block;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.dimension.OverworldDimension;

public class Skyblock21Platform implements IPlatformGenerator
{
    @Override
    public void generate(World world, int x, int y, int z)
    {
        if (!(world.dimension instanceof OverworldDimension))
            return;

        world.instantBlockUpdateEnabled = true;
        //Main platform:
        for (int i = -1; i < 5; i++)
        {
            for(int j = -1; j < 5; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    if (!(i > 1 && j > 1))
                    {
                        world.setBlock(x + i, y + k, z + j, (k == 2 ? Block.GRASS_BLOCK.id : Block.DIRT.id));
                    }
                }
            }
        }
        world.setBlock(x, y, z, Block.BEDROCK.id);

        //Main platform chest:
        world.setBlock(x + 4, y + 3, z, Block.CHEST.id);
        world.setBlockMeta(x + 4,  y + 3, z, 4);
        ChestBlockEntity chest = (ChestBlockEntity)world.getBlockEntity(x + 4, y + 3, z);
        chest.setStack(0, new ItemStack(Item.LAVA_BUCKET));
        chest.setStack(1, new ItemStack(Block.ICE));

        //Main Tree:
        for (int i = -2; i < 3; i++)
        {
            for (int j = -2; j < 3; j++)
            {
                for (int k = 0; k < 4; k++)
                {
                    if ((k < 2) ||
                            (k < 3 && Math.abs(i) < 2 && Math.abs(j) < 2) ||
                            (i == 0 && Math.abs(j) < 2) ||
                            (j == 0 && Math.abs(i) < 2))
                        world.setBlock(x - 1 + i, y + 6 + k, z + 4 + j, Block.LEAVES.id);
                }
            }
        }
        for (int i = 0; i < 6; i++)
            world.setBlock(x - 1, y + 3 + i, z + 4, Block.LOG.id);
        world.setBlock(x + 1, y + 6, z + 2, 0);
        world.setBlock(x + 1, y + 7, z + 2, 0);
        world.setBlock(x + 1, y + 7, z + 6, 0);
        world.setBlock(x - 3, y + 6, z + 6, 0);
        world.setBlock(x - 3, y + 7, z + 6, 0);
        world.setBlock(x - 3, y + 7, z + 2, 0);

        // Sand Island:
        world.setBlock(x - 67, y + 3, z + 3, Block.CHEST.id);
        world.setBlockMeta(x - 67, y + 4, z + 3, 5); // For some reason this doesn't rotate the chest u.u
        world.setBlock(x - 68, y + 3, z + 4, Block.CACTUS.id);

        chest = (ChestBlockEntity)world.getBlockEntity(x - 67, y + 3, z + 3);
        chest.setStack(0, new ItemStack(Block.OBSIDIAN, 10));
        chest.setStack(1, new ItemStack(Item.SEEDS));

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    world.setBlock(x - 66 - i, y + 0 + j, z + 2 + k, Block.SAND.id, 0);

        world.instantBlockUpdateEnabled = false;
    }
}
