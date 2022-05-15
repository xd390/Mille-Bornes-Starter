package nc.unc.gl.borne;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.page.Viewport;
import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.modele.Joueur;
import nc.unc.gl.borne.services.CarteService;
import nc.unc.gl.borne.services.JoueurService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MilleBornesApplication {

    public static void main(String[] args) {SpringApplication.run(MilleBornesApplication.class, args);

    }
}
