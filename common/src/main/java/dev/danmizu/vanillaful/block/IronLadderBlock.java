package dev.danmizu.vanillaful.block;

// import net.minecraft.core.BlockPos;
// import net.minecraft.core.Direction;
// import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.SoundType;
// import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class IronLadderBlock extends LadderBlock {
    public IronLadderBlock() {
        super(Properties.of(Material.METAL).sound(SoundType.METAL).strength(0.4f, 6).noOcclusion());
    }

    // Allow placement in non-traditional ladder ways
    // private boolean canAttachTo(BlockGetter world, BlockPos pos, Direction side) {
    //     return true;
    // }
}
