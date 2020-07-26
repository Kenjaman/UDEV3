package io.github.spoonless.occupation;

import java.util.ArrayList;
import java.util.List;

public class OccupationsSingleton {

    private static OccupationsSingleton instance = new OccupationsSingleton();

    private List<Occupation> occupations = new ArrayList<>();

    public static OccupationsSingleton getInstance() {
        return instance;
    }

    private OccupationsSingleton() {
        int i = 0;

        occupations.add(new Occupation(++i, "Bricolage", "quotidien", "Améliorez votre chez vous en lui donnant un touche personnelle."));
        occupations.add(new Occupation(++i, "Camping", "voyage", "Partez découvrir de nouveaux lieux en toute liberté."));
        occupations.add(new Occupation(++i, "Cinéma", "detente", "Profitez des salles de cinéma proches de chez vous ou ailleurs."));
        occupations.add(new Occupation(++i, "Cuisine", "quotidien", "Préparez vos plats favoris ou découvrez de nouvelles recettes."));
        occupations.add(new Occupation(++i, "Football", "social", "Partagez votre passion pour le ballon en équipe."));
        occupations.add(new Occupation(++i, "Gymnastique", "detente", "Pour se sentir bien dans son corps."));
        occupations.add(new Occupation(++i, "Jardinage", "quotidien", "Cultivez vos fruits et vos légumes préférés."));
        occupations.add(new Occupation(++i, "Jeux de société", "social", "Jouez entre amis lors d'une soirée par exemple."));
        occupations.add(new Occupation(++i, "Jeux vidéo", "detente", "Jouez en solo ou en ligne à vos jeux vidéo préférés."));
        occupations.add(new Occupation(++i, "Lecture", "detente", "Découvrez de nouveaux auteurs ou de nouvelles oeuvres de vos auteurs préférés."));
        occupations.add(new Occupation(++i, "Randonnée", "voyage", "Partez seul ou à plusieurs pour une découverte des paysages en pleine nature."));
        occupations.add(new Occupation(++i, "Trek", "voyage", "Gardez la forme tout en voyant du paysage."));
        occupations.add(new Occupation(++i, "Yoga", "detente", "Détendez-vous et restez à l'écoute de votre corps."));
    }

    public List<Occupation> getOccupations() {
        return occupations;
    }

    public Occupation getOccupation(int occupationId) {
        for (Occupation o : this.occupations) {
            if (o.getId() == occupationId) {
                return o;
            }
        }
        return null;
    }

    public List<Occupation> getOccupationsMemeCategorie(Occupation occupation) {
        List<Occupation> occupationsMemeCategorie = new ArrayList<>();
        for (Occupation o : this.occupations) {
            if (!o.equals(occupation) && o.getCategorie().equals(occupation.getCategorie())) {
                occupationsMemeCategorie.add(o);
            }
        }
        return occupationsMemeCategorie;
    }
}
