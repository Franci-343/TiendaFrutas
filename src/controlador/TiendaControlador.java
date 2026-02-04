package controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modelo.Fruta;

public class TiendaControlador implements Initializable {
	@FXML
    private VBox chosenFruitCard;

    @FXML
    private ImageView fruitImg;

    @FXML
    private Label fruitNameLabel;

    @FXML
    private Label fruitPriceLabel;

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;
    
    private List<Fruta> frutas = new ArrayList<>();
    
    private List<Fruta> getData() {
		List<Fruta> frutas = new ArrayList<>();
		Fruta fruta;
		for(int i=0; i<20; i++) {
			fruta = new Fruta();
			fruta.setNombre("Kiwi");
			fruta.setPrecio(2.99);
			fruta.setImgSrc("/img/frutas/kiwi.png");
			fruta.setColor("6A7324");
			frutas.add(fruta);
		}
		return frutas;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		frutas.addAll(getData());
		int columnas = 8, filas = 8;
		try {
			for (int i = 0; i < frutas.size(); i++) {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("/vista/item.fxml"));
				
				AnchorPane anchorPane = fxmlLoader.load();
				
				ItemControlador itemControlador = fxmlLoader.getController();
				itemControlador.setData(frutas.get(i));
				if (columnas == 3) {
					columnas = 0;
					filas++;
				}
				grid.add(anchorPane, columnas++,filas);
				GridPane.setMargin(anchorPane, new Insets(10) );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
