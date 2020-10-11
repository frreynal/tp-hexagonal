package produits;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public abstract class AProduit {

    protected String name;
    protected int prixUnitaireAchat;
    protected int prixUnitaireVente;
}
