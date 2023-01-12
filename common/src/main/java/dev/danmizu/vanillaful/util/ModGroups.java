package dev.danmizu.vanillaful.util;

import java.util.function.Supplier;
import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.Registries;

public class ModGroups {
    // create mod group
    public static final Supplier<Registries> REGISTRIES = registerModGroup(ModInfo.MOD_ID);

    // register mod group
    private static Supplier<Registries> registerModGroup(String modID) {
        return Suppliers.memoize(() -> Registries.get(modID));
    }
}
