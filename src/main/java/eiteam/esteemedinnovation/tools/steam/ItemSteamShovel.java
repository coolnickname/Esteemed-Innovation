package eiteam.esteemedinnovation.tools.steam;

import com.google.common.collect.Sets;
import eiteam.esteemedinnovation.api.tool.ItemSteamTool;
import eiteam.esteemedinnovation.api.tool.SteamToolSlot;
import eiteam.esteemedinnovation.api.tool.UtilSteamTool;
import eiteam.esteemedinnovation.commons.Config;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nonnull;
import java.util.Set;

import static eiteam.esteemedinnovation.tools.ToolsModule.STEAMSHOVEL_MAT;

public class ItemSteamShovel extends ItemSteamTool {
    // Taken from ItemSpade.
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(
      Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND,
      Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND, Blocks.GRASS_PATH);

    public ItemSteamShovel() {
        super(1.5F, -3.0F, STEAMSHOVEL_MAT, EFFECTIVE_ON);
    }

    @Override
    public int steamPerDurability() {
        return Config.steamToolConsumptionShovel;
    }

    @Override
    public void drawBackground(GuiContainer guiEngineeringTable, int i, int j, int k) {
        guiEngineeringTable.mc.getTextureManager().bindTexture(LARGE_ICONS);
        guiEngineeringTable.drawTexturedModalRect(j + 26, k + 3, 128, 128, 64, 64);
    }

    @Override
    public String toolClass() {
        return "shovel";
    }

    @Override
    public int getToolInteger() {
        return SteamToolSlot.SHOVEL_CORE.tool;
    }

    @Override
    @Nonnull
    public SteamToolSlot getRedSlot() {
        return SteamToolSlot.SHOVEL_HEAD;
    }

    @Override
    public float getStrVsBlock(ItemStack stack, IBlockState state) {
        NBTTagCompound nbt = UtilSteamTool.checkNBT(stack);
        int speed = nbt.getInteger("Speed");
        return Items.DIAMOND_SHOVEL.getStrVsBlock(stack, state) != 1F && speed > 0 ? getSpeed(speed) : 0F;
    }
}
