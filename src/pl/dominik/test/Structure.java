package pl.dominik.test;

import java.util.List;
import java.util.Optional;

public interface Structure {
	
	Optional<Block> findBlockByColor(Colors color);
	
	List<Block> findBlocksByMaterial(Materials material);
	
	int count();
}
