import javax.faces.context.FacesContext;

public class Main {

	public static void main(String[] args) {
		String version = FacesContext.class.getPackage().getImplementationVersion();
		System.out.println(version);
	}

}
