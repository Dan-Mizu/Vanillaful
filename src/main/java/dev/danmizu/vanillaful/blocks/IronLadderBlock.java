package dev.danmizu.vanillaful.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.LadderBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class IronLadderBlock extends LadderBlock {

    public IronLadderBlock(Settings settings) {
        super(settings);
    }

    // Allow placement in non-traditional ladder ways
    private boolean canPlaceOn(BlockView world, BlockPos pos, Direction side) {
        return true;
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = state.get(FACING);
        return this.canPlaceOn(world, pos.offset(direction.getOpposite()), direction);
    }
}