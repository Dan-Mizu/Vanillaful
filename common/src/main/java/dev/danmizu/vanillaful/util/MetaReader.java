package dev.danmizu.vanillaful.util;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class MetaReader {

	private static MetaData metaData;

	public static MetaData getData() {
		Gson gson = new Gson();
		try (
			Reader reader = new InputStreamReader(
				MetaReader.class.getResourceAsStream("/vanillaful.json")
			)
		) {
			MetaData metaData = gson.fromJson(reader, MetaData.class);
			return metaData;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getVersion() {
		metaData = getData();
		return metaData.getVersion();
	}
}
