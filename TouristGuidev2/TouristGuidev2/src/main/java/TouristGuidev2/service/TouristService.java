package TouristGuidev2.service;

import TouristGuidev2.model.TouristAttraction;
import TouristGuidev2.repository.TouristRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TouristService {

    private final TouristRepository repository;


    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    // Create
    public void addAttraction(TouristAttraction attraction) {
        repository.addAttraction(attraction);
    }

    // Read
    public List<TouristAttraction> getAllAttractions() {
        return repository.getAllAttractions();
    }

    // Read
    public TouristAttraction getAttractionByName(String name) {
        return repository.getAttractionByName(name);
    }

    // Update
    public void updateAttraction(String name, String newDescription) {
        repository.updateAttraction(name, newDescription);
    }

    // Delete
    public void deleteAttraction(String name) {
        repository.deleteAttraction(name);
    }
}