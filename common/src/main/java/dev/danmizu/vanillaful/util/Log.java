package dev.danmizu.vanillaful.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    public static final Logger LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);

    public static void info(String message) {
        LOGGER.info("🍦 | " + message);
    }
}
