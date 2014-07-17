package flaxbeard.steamcraft.misc;

import net.minecraft.potion.Potion;

public class SteamcraftPotion extends Potion {

	public SteamcraftPotion(int p_i1573_1_, boolean p_i1573_2_,
			int p_i1573_3_) {
		super(p_i1573_1_, p_i1573_2_, p_i1573_3_);
	}
	
	public Potion setIconIndex(int par1, int par2) {
		super.setIconIndex(par1, par2);
		return this;
	}

}
