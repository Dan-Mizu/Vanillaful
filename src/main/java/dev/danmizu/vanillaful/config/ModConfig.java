package dev.danmizu.vanillaful.config;

// import me.shedaniel.autoconfig.AutoConfig;
// import me.shedaniel.autoconfig.ConfigData;
// import me.shedaniel.autoconfig.annotation.Config;
// import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
// import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
// import dev.danmizu.vanillaful.util.ModInfo;

// @Config(name = ModInfo.MOD_ID)
// public class ModConfig implements ConfigData {

//     @Comment("Speed For Climbing Up Iron Ladders [default = 0.4]")
//     public double ironLadderClimbUpSpeed = 0.4;

//     @Comment("Speed For Climbing Down Iron Ladders [default = 0.4]")
//     public double ironLadderClimbDownSpeed = 0.4;

//     public static void init() {
//         AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
//     }

//     public static ModConfig get() {
//         return AutoConfig.getConfigHolder(ModConfig.class).getConfig();
//     }
// }