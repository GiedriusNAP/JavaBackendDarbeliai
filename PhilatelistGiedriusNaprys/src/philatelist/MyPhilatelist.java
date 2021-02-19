package philatelist;

import java.util.ArrayList;

public class MyPhilatelist implements Philatelist {
	ArrayList<PostStamp> kolekcija = new ArrayList<>();
	Exception IllegalArgumentException = null;

	@Override
	public void addToCollection(PostStamp postStamp) {
		// TODO Auto-generated method stub
		if (!(kolekcija == null) || !(postStamp == null)) {
			if (!kolekcija.contains(postStamp)) {
				kolekcija.add(postStamp);
			} else {
				
			}
		} else {
			// throw IllegalArgumentException;
		}
	}

	@Override
	public double getAveragePostStampPrice() {
		// TODO Auto-generated method stub
		double suma = 0;
		for (PostStamp postStamp : kolekcija) {
			suma = suma + postStamp.getMarketPrice();
		}
		suma = suma / kolekcija.size();
		return suma;
	}

	@Override
	public int getNumberOfPostStampsInCollection() {
		// TODO Auto-generated method stub
		return kolekcija.size();
	}

	@Override
	public PostStamp getTheMostExpensivePostStamByMarketValue() {
		// TODO Auto-generated method stub
		double max = 0;
		PostStamp stampas = null;
		for (PostStamp postStamp : kolekcija) {
			if (max < postStamp.getMarketPrice()) {
				stampas = new PostStamp(postStamp.getName(), postStamp.getNominalPrice(), postStamp.getMarketPrice());
				max = postStamp.getMarketPrice();
			}

		}
		return stampas;
	}

}
