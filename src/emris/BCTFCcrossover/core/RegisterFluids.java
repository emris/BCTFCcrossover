package emris.BCTFCcrossover.core;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import TFC.TFCItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emris.BCTFCcrossover.Items;

public class RegisterFluids {

	private static Fluid bctfcLatexFluid;
	public static Fluid fluidLatex;
	
	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void textureHook(TextureStitchEvent.Post event) {
		if (event.map.textureType == 0) {
			bctfcLatexFluid.setIcons(Items.Latex.getIconFromDamage(0));
		}
	}

	public static void register() {
		MinecraftForge.EVENT_BUS.register(new RegisterFluids());

		bctfcLatexFluid = new Fluid("latex").setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(bctfcLatexFluid);
		fluidLatex = FluidRegistry.getFluid("latex");
		
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("latex", FluidContainerRegistry.BUCKET_VOLUME / 4), new ItemStack(Items.LatexBowl), new ItemStack(Item.bowlEmpty));
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("latex", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(Items.Buckets, 1, 0), new ItemStack(TFCItems.WoodenBucketEmpty));
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("water", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(Items.Buckets, 1, 2), new ItemStack(Items.Buckets, 1, 1));
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("oil", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(Items.Buckets, 1, 4), new ItemStack(Items.Buckets, 1, 3));
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("fuel", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(Items.Buckets, 1, 5), new ItemStack(Items.Buckets, 1, 3));
	}

}
