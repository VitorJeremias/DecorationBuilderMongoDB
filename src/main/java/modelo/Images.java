package modelo;

public class Images {

	private String path = "C:\\Users\\Vitor\\eclipse-workspace\\DecorationBuilderMongoDB\\resources\\";
	private ImageManager im = new ImageManager();

	public boolean hasImage(String file) {
		return im.isOnScreen(path + file + ".png");
	};

}
