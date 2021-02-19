package philatelist;

public class PostStamp {
	private String name;
	private double nominalPrice;
	private double marketPrice;

	public PostStamp(String name, double nominalPrice, double marketPrice) {
		this.name = name;
		this.nominalPrice = nominalPrice;
		this.marketPrice = marketPrice;
	}

	public String getName() {
		return this.name;
	}

	public double getNominalPrice() {
		return this.nominalPrice;
	}

	public double getMarketPrice() {
		return this.marketPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(marketPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(nominalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostStamp other = (PostStamp) obj;
		if (Double.doubleToLongBits(marketPrice) != Double.doubleToLongBits(other.marketPrice))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(nominalPrice) != Double.doubleToLongBits(other.nominalPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PostStamp [name=" + name + ", nominalPrice=" + nominalPrice + ", marketPrice=" + marketPrice + "]";
	}

}
