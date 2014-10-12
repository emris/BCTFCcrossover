package emris.bctfccrossover;

public class Reference
{
	public static final String ModID = "bctfccrossover";
	public static final String ModName = "BCTFCcrossover";

	public static final int VersionMajor = 0;
	public static final int VersionMinor = 10;
	public static final String VersionRevision = "B79";

	public static final String ModVersion = VersionMajor + "." + VersionMinor + "." + VersionRevision;

	public static final String ModDependencies = "required-after:Forge@[10.13.1.1217,);required-after:BuildCraft|Core;required-after:BuildCraft|Builders;required-after:BuildCraft|Energy;required-after:BuildCraft|Factory;required-after:BuildCraft|Silicon;required-after:BuildCraft|Transport;required-after:terrafirmacraft";
	public static final String SERVER_PROXY_CLASS = "emris." + ModID + ".CommonProxy";
	public static final String CLIENT_PROXY_CLASS = "emris." + ModID + ".ClientProxy";
}
