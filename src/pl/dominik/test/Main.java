package pl.dominik.test;

import java.util.ArrayList;
import java.util.List;

public class Main {



	public static void main(String[] args) {
	Block block1 = new Block() {
			
			
			public Materials getMaterial() {
				return Materials.CLAY;
			}
			
			
			public Colors getColor() {
				return Colors.BROWN;
			}
		};
Block block2 = new Block() {
			
			
			public Materials getMaterial() {
				return Materials.CLAY;
			}
			
			
			public Colors getColor() {
				return Colors.RED;
			}
		};
Block block3 = new Block() {
			
			
			public Materials getMaterial() {
				return Materials.STEEL;
			}
			
			
			public Colors getColor() {
				return Colors.SILVER;
			}
		};
Block block4 = new Block() {
			
			
			public Materials getMaterial() {
				return Materials.IRON;
			}
			
			
			public Colors getColor() {
				return Colors.DARKSILVER;
			}
		};		
CompositeBlock compositeBlock = new CompositeBlock() {
	
	@Override
	public Materials getMaterial() {
		// TODO Auto-generated method stub
		return Materials.REINFORCEDSTEEL;
	}
	
	@Override
	public Colors getColor() {
		// TODO Auto-generated method stub
		return Colors.SILVER;
	}
	
	@Override
	public List<Block> getBlocks() {
		List<Block> inBlocks = new ArrayList<Block>();
		inBlocks.add(block1);
		inBlocks.add(block3);
		return  inBlocks;
	}
};
		List<Block> blocks = new ArrayList<Block>();
		blocks.add(block1);
		blocks.add(compositeBlock);
		blocks.add(null);
		blocks.add(block2);
		blocks.add(block3);
		blocks.add(block4);
		
		
		Wall wall = new Wall(blocks);
		
		System.out.println(wall.count()); 
		System.out.println(wall.findBlockByColor(Colors.SILVER)); 
		System.out.println(wall.findBlocksByMaterial(Materials.REINFORCEDSTEEL)); 
		
	}

}
