class Mot_dict {
    private String mot;
    private String definition;

    
    public Mot_dict(String mot, String definition) {
        this.mot = mot;
        this.definition = definition;
    }

    String getMot() {
        return mot;
    }

    String getDefinition() {
        return definition;
    }

    void setDefinition(String df) {
        this.definition = df;
    }

    void setMot(String M) {
        this.mot = M;
    }

    Boolean synonyme(String ch) {
        return this.mot.compareTo(ch) == 0;
    }

    Boolean synonyme(Mot_dict m) {
        return this.mot.equals(m.mot);
    }
}

class Dictionnaire {
    private int nb_mots;
    private Mot_dict[] dict;
    private String nom;

    public Dictionnaire(String nom, int taille) {
        this.nom = nom;
        dict = new Mot_dict[taille];
        this.nb_mots = 0;
    }

    void Ajouter_Mot(Mot_dict d) {
        if (nb_mots < dict.length) {
            dict[nb_mots] = d;
            nb_mots++;
            Trier();
        } else {
            System.out.println("Dictionnaire est plein!");
        }
    }

    void Trier() {
        for (int i = 1; i < nb_mots; i++) {
            Mot_dict x = dict[i];
            int j = i - 1;
            while (j >= 0 && dict[j].getMot().compareTo(x.getMot()) > 0) {
                dict[j + 1] = dict[j];
                j = j - 1;
            }
            dict[j + 1] = x;
        }
    }

    void Supprimer_Mot(Mot_dict m) {
        int index = -1;
        for (int i = 0; i < this.nb_mots; i++) {
            if (dict[i].getMot().equals(m.getMot())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < nb_mots - 1; i++) {
                dict[i] = dict[i + 1];
            }
            dict[nb_mots - 1] = null;
            nb_mots--;
        } else {
            System.out.println("Mot non trouvé!");
        }
    }

    String Recherche_dicho(String mot) {
        int debut = 0;
        int fin = nb_mots - 1;

        while (debut <= fin) {
            int milieu = (debut + fin) / 2;
            String motM = dict[milieu].getMot();

            if (motM.equals(mot)) {
                return dict[milieu].getDefinition();
            } else if (motM.compareTo(mot) < 0) {
                debut = milieu + 1;
            } else {
                fin = milieu - 1;
            }
        }
        return "Mot non trouvé";
    }

    void Lister_dictionnaire() {
        for (int i = 0; i < this.nb_mots; i++) {
            System.out.println("Mot : " + dict[i].getMot() + " | Définition : " + dict[i].getDefinition());
        }
    }

    public int Nombre_synonyme(Mot_dict m) {
        int x = 0;
        for (int i = 0; i < this.nb_mots; i++) {
            if (m.synonyme(dict[i])) {
                x++;
            }
        }
        return x;
    }
}

