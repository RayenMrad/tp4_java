public class Main {
    public static void main(String[] args) {
        Dictionnaire dico = new Dictionnaire("MonDico", 5);

        Mot_dict mot1 = new Mot_dict("fer7an", "tayer bil far7a");
        Mot_dict mot2 = new Mot_dict("te3eb", "mayet bil t3ab");
        Mot_dict mot3 = new Mot_dict("rayen", "Rayen Mrad.");
        Mot_dict mot4 = new Mot_dict("ena", "houwa");
        Mot_dict mot5 = new Mot_dict("enti", "entouma");

        dico.Ajouter_Mot(mot1);
        dico.Ajouter_Mot(mot2);
        dico.Ajouter_Mot(mot3);
        dico.Ajouter_Mot(mot4);
        dico.Ajouter_Mot(mot5);

        System.out.println("Dictionnaire après ajout de mots :");
        dico.Lister_dictionnaire();

        System.out.println("\nRecherche du mot 'fer7an' :");
        String definition = dico.Recherche_dicho("fer7an");
        System.out.println("Définition de 'fer7an' : " + definition);

        System.out.println("\nNombre de synonymes pour 'te3eb' :");
        int nb_synonymes = dico.Nombre_synonyme(mot2); 
        System.out.println("Nombre de synonymes de 'te3eb' : " + nb_synonymes);

        System.out.println("\nSuppression du mot 'rayen' :");
        dico.Supprimer_Mot(mot3);  

        System.out.println("\nDictionnaire après suppression de 'rayen' :");
        dico.Lister_dictionnaire();

        System.out.println("\nRecherche du mot 'ena' (après suppression) :");
        String resultNonTrouve = dico.Recherche_dicho("ena");
        System.out.println(resultNonTrouve);
    }
}
