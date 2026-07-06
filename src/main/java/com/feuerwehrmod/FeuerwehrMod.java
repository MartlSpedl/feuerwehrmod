package com.feuerwehrmod;

import com.feuerwehrmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Haupt-Einstiegspunkt der Feuerwehr-Mod.
 * Wird von Fabric Loader über den "main"-Entrypoint in fabric.mod.json geladen.
 */
public class FeuerwehrMod implements ModInitializer {

	// Eindeutige Mod-ID, wird überall als Namespace für Registrierungen verwendet
	public static final String MOD_ID = "feuerwehrmod";

	// Zentraler Logger für die gesamte Mod
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Feuerwehr Mod wird initialisiert...");

		// Registrierungen der einzelnen Module.
		// Wird Schritt für Schritt erweitert, sobald die jeweiligen Systeme existieren.
		ModItems.register();

		LOGGER.info("Feuerwehr Mod erfolgreich initialisiert.");
	}
}
