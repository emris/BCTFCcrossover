package emris.bctfccrossover.core.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import emris.bctfccrossover.utils.PlayerUtils;
import emris.bctfccrossover.worldGen.WorldGenHevea;

public class CommandGenHevea extends CommandBase
{
	@Override
	public String getCommandName()
	{
		return "genhevea";
	}

	@Override
	public String getCommandUsage(ICommandSender sender)
	{
		return "/" + getCommandName() + "[growth stage]";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] as)
	{
		if(sender instanceof EntityPlayerMP)
		{
			int gs = 5;
			if(as.length == 1)
				if(PlayerUtils.isNumber(as[0])) gs = Integer.parseInt(as[0], 10);

			EntityPlayerMP cp = (EntityPlayerMP) sender;
			World world = cp.worldObj;
			MovingObjectPosition mop = PlayerUtils.getTargetBlock(cp);
			if(mop != null)
			{
				int x = mop.blockX + 1;
				int z = mop.blockZ + 1;
				int y = mop.blockY;
				
				WorldGenHevea wg = new WorldGenHevea(gs);
				if(wg.forceGen(world, x, y, z))
					cp.addChatMessage(new ChatComponentText("Done"));
				else
					cp.addChatMessage(new ChatComponentText("Failed :("));
			}
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
	{
		if (sender instanceof EntityPlayerMP)
			return true;
		else
			return false;
	}

}
