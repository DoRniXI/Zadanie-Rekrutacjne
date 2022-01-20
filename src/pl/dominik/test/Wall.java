package pl.dominik.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Wall implements Structure {

    private final List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }
    

    @Override
    public int count() {
        if(blocks == null)
            return 0;
        int size = 0;
        for(Block block: blocks) {
            if(block instanceof CompositeBlock && ((CompositeBlock)block).getBlocks() != null) {
                size += ((CompositeBlock)block).getBlocks().size();
            } else {
                if(block != null) {
                    size++;
                }
            }
        }
        return size;
    }

    @Override
    public Optional<Block> findBlockByColor(Colors color) {
    	if(color == null || blocks == null)
    		return Optional.empty();
      Optional<Block> result = blocks.stream().filter(e -> {
    	  if(e == null)
    		  return false;
    	  
    	  if (color.equals(e.getColor())) 
			return true;
		
    	  if (e instanceof CompositeBlock && ((CompositeBlock)e).getBlocks() != null) {
			for (Block block : ((CompositeBlock) e).getBlocks()) {
				if (color.equals(block.getColor())) 
					return true;
				
			}
		}
		return false;
      }).findAny();
      
      return result;
    }

    @Override
    public List<Block> findBlocksByMaterial(Materials material) {
        if(material == null)
            return new ArrayList<>();
        
        List<Block> result = blocks.stream()
                .filter(e -> {
                	if(e == null) 
                		return false;
                	
                	if(material.equals(e.getMaterial()))
                		return true;
                	
                	if (e instanceof CompositeBlock && ((CompositeBlock)e).getBlocks() != null) {
              			for (Block block : ((CompositeBlock) e).getBlocks()) {
              				if (material.equals(block.getMaterial())) 
              					return true;
              			}}
              			return false;
              			}).collect(Collectors.toList());

      
       

        return result;
    }
}