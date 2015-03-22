package emris.bctfccrossover.core;

public class TreeData
{
	public String name;
	public int index = -1;
	public float minRain;
	public float maxRain;
	public float minTemp;
	public float maxTemp;
	public float minEVT;
	public float maxEVT;
	public boolean isEvergreen;

	public TreeData(String n, int i, float minR, float maxR, float minT, float maxT, float minEVT, float maxEVT, boolean eg)
	{
		this.name = n;
		this.index = i;
		this.minRain = minR;
		this.maxRain = maxR;
		this.minTemp = minT;
		this.maxTemp = maxT;
		this.minEVT = minEVT;
		this.maxEVT = maxEVT;
		this.isEvergreen = eg;
	}
}
