package section1_recipe11;

import java.util.stream.StreamSupport;

import section1_recipe11.Item;
import section1_recipe11.MySpliterator;

public class Main {
	public static void main(String[] args) {
		
		Item[][] items;
		
		items= new Item[10][10];
		
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				items[i][j]=new Item();
				items[i][j].setRow(i);
				items[i][j].setColumn(j);
				items[i][j].setName("Item "+i+" "+j);
			}
		}
		
		MySpliterator mySpliterator=new MySpliterator(items, 0, items.length);
		
		StreamSupport.stream(mySpliterator, true).forEach( item -> {
			System.out.printf("%s: %s\n",Thread.currentThread().getName(),item.getName());
		});		
	}

}
