package dan.danmizu.vanillaful;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vanillaful implements ModInitializer {
	public static final String MOD_ID = "vanillaful";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final String LOG_PREFIX = "\uD83C\uDF66 | Vanillaful: ";

	@Override
	public void onInitialize() {
		LOGGER.info(LOG_PREFIX + "Initialized...");
	}
}