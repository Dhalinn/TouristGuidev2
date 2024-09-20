package TouristGuidev2.repository;

import TouristGuidev2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class TouristRepository {



    private final List<TouristAttraction> attractions = new ArrayList<>(List.of(
            new TouristAttraction("The little Mermeid", "A piece of danish history and story telling", "København", List.of("Eventyr", "Kunst")),
            new TouristAttraction("Nyhavn", "Denmarks colorfull Harbour", "København", List.of("Fotos", "Boat")),
            new TouristAttraction("Dyrehaven", "Naturpark", "Kongens Lyngby", List.of("Nature", "Free")),
            new TouristAttraction("Tivoli", "Forlystelsespark i København centrum", "København", List.of("fotos", "Børnevenlig"))
    ));


    public void addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
    }


    public List<TouristAttraction> getAllAttractions() {
        return attractions;
    }


    public TouristAttraction getAttractionByName(String name) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        return null;
    }


    public void updateAttraction(String name, String newDescription) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                attraction.setDescription(newDescription);
                break;
            }
        }
    }


    public void deleteAttraction(String name) {
        attractions.removeIf(attraction -> attraction.getName().equalsIgnoreCase(name));
    }
}