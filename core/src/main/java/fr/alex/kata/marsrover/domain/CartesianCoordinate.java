package fr.alex.kata.marsrover.domain;

public class CartesianCoordinate {

	public int x;
	public int y;

	public CartesianCoordinate(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CartesianCoordinate that = (CartesianCoordinate) o;

    if (x != that.x) return false;
    return y == that.y;
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    return result;
  }

  public CartesianCoordinate copyOf() {
		return new CartesianCoordinate(this.x, this.y);
	}

	public String getPosition() {
		return  "Position X : " + x + " Position Y : " + y;
	}


}
