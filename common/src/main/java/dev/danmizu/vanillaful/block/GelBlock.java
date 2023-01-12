package dev.danmizu.vanillaful.block;

import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.Blocks;

public class GelBlock extends SlimeBlock {
    public GelBlock() {
        super(Properties.copy(Blocks.SLIME_BLOCK).noOcclusion().jumpFactor(1.5f).friction(0.45f));
    }
}
