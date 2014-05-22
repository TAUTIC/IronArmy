package tv.tautic.IronArmy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;
//import net.minecraft.src.ModLoader;

public class G33z3rsCane extends ItemSword {

	public G33z3rsCane(int itemID, EnumToolMaterial material) {
		super(itemID, material);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("g33z3rsCane");
		setTextureName("IronArmy:g33z3rsCane");
		// TODO Auto-generated constructor stub
		
	}

}
