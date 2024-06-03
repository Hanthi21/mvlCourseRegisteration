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
		public enum EHeader{
			eID("아이디"),
			eName("이름");
			
			private final String title;
			private EHeader(String title) {
				this.title = title;
			}
			public String getTitle() {
				return this.title;
			}
			
			
		}
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
