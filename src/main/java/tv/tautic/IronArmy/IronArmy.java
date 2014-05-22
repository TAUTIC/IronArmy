package tv.tautic.IronArmy;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
//import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod; 
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.Property;

@Mod(modid="IronArmy", name="IronArmy Mod", version="IA_VER")
@NetworkMod(clientSideRequired=true) // not used in 1.7
public class IronArmy {
	
	public static Item g33z3rsCane;
	
        // The instance of your mod that Forge uses.
        @Instance(value = "IronArmy")
        public static IronArmy instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="tv.tautic.IronArmy.client.ClientProxy", serverSide="tv.tautic.IronArmy.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler // used in 1.6.2
        //@PreInit    // used in 1.5.2
        public void preInit(FMLPreInitializationEvent event) {
        	//Handle config file
        	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        	config.load();
          	  
        	int g33z3rsCaneID = config.getItem("G33z3rsCane", 3297).getInt();  
        	
        	config.save();
        	
        	//Add new tool material
       	 	EnumToolMaterial CANE = new EnumHelper().addToolMaterial("CANE", 0, 250, 4.0F, 5.0F, 22);
        	 
        	//Init items        	
        	g33z3rsCane = new G33z3rsCane(g33z3rsCaneID, CANE);
        	GameRegistry.registerItem(g33z3rsCane, g33z3rsCane.getUnlocalizedName());
        }
        
        @EventHandler // used in 1.6.2
        //@Init       // used in 1.5.2
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                
                //Add recipe for g33z3r_hd's cane
             //   ModLoader.addRecipe(new ItemStack(g33z3rsCane, 1), new Object[] { " Es", " s ", " s ", 's', Item.stick, 'E', Item.emerald});
        }
        
        @EventHandler // used in 1.6.2
        //@PostInit   // used in 1.5.2
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}