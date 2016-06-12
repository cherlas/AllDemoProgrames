package 编程之美;

public class CPU占用率 {

	public static void main(String[] args) {

		String osName=System.getProperty("os.name");
		if (osName.toLowerCase().startsWith("window")) {
			
		}

	}
static class MonitorInfoBean{
	private double cpuRatio;

	public double getCpuRatio() {
		return cpuRatio;
	}

	public void setCpuRatio(double cpuRatio) {
		this.cpuRatio = cpuRatio;
	}
}
}
