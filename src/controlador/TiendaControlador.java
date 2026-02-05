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
		
		// Cereza
		fruta = new Fruta();
		fruta.setNombre("Cereza");
		fruta.setPrecio(3.49);
		fruta.setImgSrc("/img/frutas/cereza.png");
		fruta.setColor("C72C41");
		frutas.add(fruta);
		
		// Durazno
		fruta = new Fruta();
		fruta.setNombre("Durazno");
		fruta.setPrecio(2.79);
		fruta.setImgSrc("/img/frutas/Durazno.png");
		fruta.setColor("F5A962");
		frutas.add(fruta);
		
		// Frutilla
		fruta = new Fruta();
		fruta.setNombre("Frutilla");
		fruta.setPrecio(4.99);
		fruta.setImgSrc("/img/frutas/Frutilla.png");
		fruta.setColor("E8374E");
		frutas.add(fruta);
		
		// Kiwi
		fruta = new Fruta();
		fruta.setNombre("Kiwi");
		fruta.setPrecio(2.99);
		fruta.setImgSrc("/img/frutas/kiwi.png");
		fruta.setColor("6A7324");
		frutas.add(fruta);
		
		// Manzana
		fruta = new Fruta();
		fruta.setNombre("Manzana");
		fruta.setPrecio(1.99);
		fruta.setImgSrc("/img/frutas/Manzana.png");
		fruta.setColor("E74C3C");
		frutas.add(fruta);
		
		// Papaya
		fruta = new Fruta();
		fruta.setNombre("Papaya");
		fruta.setPrecio(3.29);
		fruta.setImgSrc("/img/frutas/Papaya.png");
		fruta.setColor("F39C12");
		frutas.add(fruta);
		
		// Pera
		fruta = new Fruta();
		fruta.setNombre("Pera");
		fruta.setPrecio(2.49);
		fruta.setImgSrc("/img/frutas/Pera.png");
		fruta.setColor("A8C256");
		frutas.add(fruta);
		
		// Plátano
		fruta = new Fruta();
		fruta.setNombre("Plátano");
		fruta.setPrecio(1.49);
		fruta.setImgSrc("/img/frutas/Platano.png");
		fruta.setColor("F4D03F");
		frutas.add(fruta);
		
		// Sandía
		fruta = new Fruta();
		fruta.setNombre("Sandía");
		fruta.setPrecio(5.99);
		fruta.setImgSrc("/img/frutas/Sandia.png");
		fruta.setColor("27AE60");
		frutas.add(fruta);
		
		return frutas;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		frutas.addAll(getData());
		int columnas = 0, filas = 0;
		try {
			for (int i = 0; i < frutas.size(); i++) {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("/vista/item.fxml"));
				
				AnchorPane anchorPane = fxmlLoader.load();
				
				ItemControlador itemControlador = fxmlLoader.getController();
				itemControlador.setData(frutas.get(i));
				
				grid.add(anchorPane, columnas, filas);
				GridPane.setMargin(anchorPane, new Insets(10));
				
				columnas++;
				if (columnas == 3) {
					columnas = 0;
					filas++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
