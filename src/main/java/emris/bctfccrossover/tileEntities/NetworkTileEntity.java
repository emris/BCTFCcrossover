package emris.bctfccrossover.tileEntities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emris.bctfccrossover.BCTFCcrossover;
import emris.bctfccrossover.core.network.AbstractPacket;
import emris.bctfccrossover.core.network.DataBlockPacket;

public abstract class NetworkTileEntity extends TileEntity
{
	public boolean shouldSendInitData = true;
	public EntityPlayer entityplayer;
	protected int broadcastRange = 256;
	public abstract void handleInitPacket(NBTTagCompound nbt);
	public void handleDataPacket(NBTTagCompound nbt){}
	public void createDataNBT(NBTTagCompound nbt){}
	public abstract void createInitNBT(NBTTagCompound nbt);

	public DataBlockPacket createDataPacket()
	{
		return this.createDataPacket(createDataNBT());
	}

	public DataBlockPacket createDataPacket(NBTTagCompound nbt)
	{
		return new DataBlockPacket(this.xCoord, this.yCoord, this.zCoord, nbt);
	}

	private NBTTagCompound createDataNBT()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		createDataNBT(nbt);
		return nbt;
	}

	private NBTTagCompound createInitNBT()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		createInitNBT(nbt);
		return nbt;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared()
	{
		return 1024.0D;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord +1, yCoord + 1, zCoord + 1);
		return bb;
	}

	@Override
	public Packet getDescriptionPacket()
	{
		if(shouldSendInitData())
			return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, createInitNBT());
		return null;
	}

	protected boolean shouldSendInitData()
	{
		return shouldSendInitData;
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		handleInitPacket(pkt.func_148857_g());
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	public void broadcastPacketInRange()
	{
		int dim = worldObj.provider.dimensionId;
		if(worldObj.isRemote)
			BCTFCcrossover.packetPipeline.sendToServer(this.createDataPacket());
		else
			BCTFCcrossover.packetPipeline.sendToAllAround(this.createDataPacket(), new TargetPoint(dim, xCoord,yCoord,zCoord,broadcastRange));
	}

	public void broadcastPacketInRange(AbstractPacket packet)
	{
		if(worldObj.isRemote)
			BCTFCcrossover.packetPipeline.sendToServer(packet);
		else
			BCTFCcrossover.packetPipeline.sendToAllAround(packet, new TargetPoint(worldObj.provider.dimensionId,xCoord,yCoord,zCoord,broadcastRange));
	}
}