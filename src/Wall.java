import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Wall implements Structure {
 private List blocks;
 
 

 	@Override
	public int count() {
	
		return (int)blocks.stream().count();
	}


	@Override
	public Optional findBlockByColor(String color) {
	
		Optional resultForComposite = blocks.stream()
				.filter(composite -> composite instanceof CompositeBlock)
				.filter(composite -> {
			for ( Object object : ((CompositeBlock) composite).getBlocks()) {
				if(object instanceof Block && ((Block) object).getColor().equals(color)) 
					return true;
			}
			return false;
		}).findAny();
				

		Optional resultForBlock =	blocks.stream()
		.filter(e -> e instanceof Block )
		.filter(e -> ((Block) e).getColor().equals(color)).findAny();
	
	
		if (resultForBlock.isPresent()) {
			return resultForBlock;
		}
		else if (resultForComposite.isPresent()) {
			return resultForComposite;
		}
		else {
			return Optional.empty();
		}
	}



	@Override
	public List findBlocksByMaterial(String material) {
		List resultForBlock =	(List) blocks.stream()
				.filter(e -> e instanceof Block )
				.filter(e -> ((Block) e).getMaterial().equals(material)).collect(Collectors.toList());
		
		List resultForComposite = (List) blocks.stream()
				.filter(composite -> composite instanceof CompositeBlock)
				.filter(composite -> {
			for ( Object object : ((CompositeBlock) composite).getBlocks()) {
				if(object instanceof Block && ((Block) object).getMaterial().equals(material)) 
					return true;
			}
			return false;
		}).collect(Collectors.toList());
		
		resultForBlock.addAll(resultForComposite);
		
		return resultForBlock;
	}


}
