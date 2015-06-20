package flaxbeard.steamcraft.integration;

import flaxbeard.steamcraft.*;
import flaxbeard.steamcraft.api.CrucibleLiquid;
import flaxbeard.steamcraft.api.SteamcraftRegistry;
import flaxbeard.steamcraft.api.exosuit.ExosuitPlate;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class MiscIntegration {

		public static void postInit() {
				if (FluidRegistry.isFluidRegistered("steam") && Config.enableFluidSteamConverter) {
            SteamcraftBlocks.fluidSteamConverter.setCreativeTab(Steamcraft.tab);
        }

				if (OreDictionary.getOres("ingotLead").size() > 0) {
            CrucibleLiquid liquidLead = new CrucibleLiquid("lead",
							OreDictionary.getOres("ingotLead").get(0), new ItemStack(SteamcraftItems.steamcraftPlate,
							1, 9), OreDictionary.getOres("nuggetLead").size() > 0 ?
							OreDictionary.getOres("nuggetLead").get(0) : null, null, 118, 128, 157);
            SteamcraftRegistry.liquids.add(liquidLead);

            SteamcraftRegistry.registerSmeltThingOredict("ingotLead", liquidLead, 9);
            SteamcraftRegistry.registerSmeltThingOredict("nuggetLead", liquidLead, 1);
            SteamcraftRegistry.registerSmeltThingOredict("plateSteamcraftLead", liquidLead, 6);
            SteamcraftRegistry.addExosuitPlate(new ExosuitPlate("Lead",
							new ItemStack(SteamcraftItems.exosuitPlate, 1, 11), "Lead", "Lead", "steamcraft.plate.lead"));
            SteamcraftRecipes.addExosuitPlateRecipes("exoLead", "plateSteamcraftLead",
							new ItemStack(SteamcraftItems.exosuitPlate, 1, 11), liquidLead);
        }
		}
}
