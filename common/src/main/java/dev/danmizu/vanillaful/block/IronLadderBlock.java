package dev.danmizu.vanillaful.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class IronLadderBlock extends LadderBlock {
    public IronLadderBlock() {
        super(Properties.of(Material.METAL).sound(SoundType.METAL).strength(0.4f, 6).noOcclusion());
    }

    public boolean canAttachTo(BlockGetter blockReader, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return true;
    }
}
