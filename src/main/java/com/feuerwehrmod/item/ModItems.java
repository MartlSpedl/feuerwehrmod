package com.feuerwehrmod.item;

import com.feuerwehrmod.FeuerwehrMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * Zentrale Registrierungsstelle für alle Items der Mod.
 * Weitere Items (Ausrüstung, Ausbildungs-Requisiten, Einsatz-Werkzeuge)
 * kommen hier nach und nach dazu.
 */
public class ModItems {

	// Platzhalter-Item, nur um zu verifizieren, dass Registrierung funktioniert.
	public static final Item FEUERWEHR_AUSWEIS = registerItem(
					"feuerwehr_ausweis",
					new Item(new FabricItemSettings().maxCount(1))
	);

	private static Item registerItem(String name, Item item) {
		return Registry.register(
						Registries.ITEM,
						new Identifier(FeuerwehrMod.MOD_ID, name),
						item
		);
	}

	public static void register() {
		FeuerwehrMod.LOGGER.info("Registriere Items für {}", FeuerwehrMod.MOD_ID);

		// Fügt den Feuerwehr-Ausweis der "Werkzeuge & Nützliches"-Kreativgruppe hinzu.
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
			entries.add(FEUERWEHR_AUSWEIS);
		});
	}
}
