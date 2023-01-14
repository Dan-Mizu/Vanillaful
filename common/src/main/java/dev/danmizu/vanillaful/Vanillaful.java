package dev.danmizu.vanillaful;

import dev.danmizu.vanillaful.registry.*;
import dev.danmizu.vanillaful.util.Log;

public class Vanillaful {
    public static void init() {
        ModBlocks.init();
        ModItems.init();
        ModSoundEvents.init();
        ModEntityTypes.init();
        ModBlockEntityTypes.init();

        // log
        Log.info("Vanillaful v" + getVersion() + " has loaded!");
    }

    public static String getVersion() {
        // Gson gson = new Gson();
        // // JsonObject person = (JsonObject) gson.parse(new FileReader("c:\\exer4-courses.json"));
        return null;
    }
}