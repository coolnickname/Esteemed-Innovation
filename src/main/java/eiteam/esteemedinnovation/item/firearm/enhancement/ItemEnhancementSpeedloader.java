package eiteam.esteemedinnovation.item.firearm.enhancement;

import eiteam.esteemedinnovation.EsteemedInnovation;
import eiteam.esteemedinnovation.api.enhancement.IEnhancementFirearm;
import eiteam.esteemedinnovation.entity.projectile.EntityMusketBall;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import static eiteam.esteemedinnovation.init.items.firearms.FirearmItems.Items.MUSKET;
import static eiteam.esteemedinnovation.init.items.firearms.FirearmItems.Items.BLUNDERBUSS;

public class ItemEnhancementSpeedloader extends Item implements IEnhancementFirearm {
    @Override
    public boolean canApplyTo(ItemStack stack) {
        return stack.getItem() == MUSKET.getItem() || stack.getItem() == BLUNDERBUSS.getItem();
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EsteemedInnovation.upgrade;
    }

    @Override
    public String getID() {
        return "Speedloader";
    }

    @Override
    public ResourceLocation getIcon(Item item) {
        String weapon = item == MUSKET.getItem() ? "Musket" : "Blunderbuss";
        return new ResourceLocation(EsteemedInnovation.MOD_ID, "weapon" + weapon + "Speedloader");
    }

    @Override
    public String getName(Item item) {
        String weapon = item == MUSKET.getItem() ? "musket" : "blunderbuss";
        return "item.esteemedinnovation:" + weapon + "Speedloader";
    }

    @Override
    public float getAccuracyChange(Item weapon) {
        return 0;
    }

    @Override
    public float getKnockbackChange(Item weapon) {
        return 0;
    }

    @Override
    public float getDamageChange(Item weapon) {
        return 0;
    }

    @Override
    public int getReloadChange(Item weapon) {
        return -30;
    }

    @Override
    public int getClipSizeChange(Item weapon) {
        return 0;
    }

    @Override
    public EntityMusketBall changeBullet(EntityMusketBall bullet) {
        return bullet;
    }

}