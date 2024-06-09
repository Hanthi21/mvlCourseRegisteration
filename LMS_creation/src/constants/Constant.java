package constants;

public class Constant {
	public class MainFrame{
		final public static long VersionID = 1L;
		final public static int X = 200;
		final public static int Y =100;
		final public static int Width=600;
		final public static int Height=400;
		
		
	}
	public static class indexTable{
	
		//Add column names for campus, college and department
		public enum EColumnTitle{
			eCampus("Campus"),
			eCollege("College"),
			eDepartment("Department");
			
			private String title;
			
			private EColumnTitle(String title) {
				this.title = title;
			}
			
			public String getTitle() {
				return this.title;
			}
		}
	}
}
