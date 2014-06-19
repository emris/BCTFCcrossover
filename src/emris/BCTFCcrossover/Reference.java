package emris.BCTFCcrossover;

public class Reference
{
	public static final String ModID = "bctfccrossover";
	public static final String ModName = "BCTFCcrossover";

	public static final int VersionMajor = 0;
	public static final int VersionMinor = 9;
	public static final String VersionRevision = "B78";

	public static final String ModVersion = VersionMajor + "." + VersionMinor + "." + VersionRevision;

	public static final String ModDependencies = "required-after:Forge@[9.1.11.965,);required-after:FML@[6.4.49.965,);required-after:BuildCraft|Core;required-after:BuildCraft|Builders;required-after:BuildCraft|Energy;required-after:BuildCraft|Factory;required-after:BuildCraft|Silicon;required-after:BuildCraft|Transport;required-after:terrafirmacraft";
	public static final String SERVER_PROXY_CLASS = "emris." + ModName + ".CommonProxy";
	public static final String CLIENT_PROXY_CLASS = "emris." + ModName + ".ClientProxy";
}
