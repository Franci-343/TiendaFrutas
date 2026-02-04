package controlador;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Fruta;
import principal.Main;

public class ItemControlador {
	@FXML
    private ImageView img;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;
    
    private Fruta fruta;
    
    
    public void setData(Fruta fruta) {
        if (fruta == null) return;
        this.fruta = fruta;
        nameLabel.setText(fruta.getNombre());
        priceLabel.setText(Main.CURRENCY + fruta.getPrecio());
        try {
            String src = fruta.getImgSrc();
            if (src != null && !src.isEmpty()) {
                String resourcePath = src.startsWith("/") ? src : ("/" + src);
                java.io.InputStream is = getClass().getResourceAsStream(resourcePath);
                if (is != null) {
                    Image imagen = new Image(is);
                    img.setImage(imagen);
                } else {
                    img.setImage(null);
                }
            } else {
                img.setImage(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}