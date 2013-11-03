/**
 *  Copyright (C) 2013  emris
 *  https://github.com/emris/BCTFCcrossover
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package emris.BCTFCcrossover.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import buildcraft.energy.render.EntityDropParticleFX;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emris.BCTFCcrossover.Reference;

public class BlockFluid extends BlockFluidClassic {

	protected float particleRed;
	protected float particleGreen;
	protected float particleBlue;
	
	@SideOnly(Side.CLIENT)
	protected Icon[] theIcon;
	
	public BlockFluid(int id, Fluid fluid, Material material) {
		super(id, fluid, material);
	}

	@Override
	public Icon getIcon(int side, int meta) {
		return side != 0 && side != 1 ? this.theIcon[1] : this.theIcon[0];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.theIcon = new Icon[] { iconRegister.registerIcon(Reference.ModID + ":" + fluidName + "_still"), iconRegister.registerIcon(Reference.ModID + ":" + fluidName + "_flow") };
	}

	public BlockFluid setParticleColor(float particleRed, float particleGreen, float particleBlue) {
		this.particleRed = particleRed;
		this.particleGreen = particleGreen;
		this.particleBlue = particleBlue;
		return this;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		super.randomDisplayTick(world, x, y, z, rand);

		if (rand.nextInt(10) == 0 && world.doesBlockHaveSolidTopSurface(x, y - 1, z) && !world.getBlockMaterial(x, y - 2, z).blocksMovement()) {
			double px = (double) ((float) x + rand.nextFloat());
			double py = (double) y - 1.05D;
			double pz = (double) ((float) z + rand.nextFloat());

			EntityFX fx = new EntityDropParticleFX(world, px, py, pz, particleRed, particleGreen, particleBlue);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(fx);
		}
	}
}
