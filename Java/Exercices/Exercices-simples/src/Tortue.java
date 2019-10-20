
public class Tortue {
	public enum Direction {
		Nord, Sud, Est, Ouest
	};
	
	private int _posX, _posY;
	private Direction _direction;

	public Tortue() {
		this._direction = Direction.Nord;
		this._posX = 0;
		this._posY = 0;
	}

	public Tortue(int posX, int posY, Direction direction) {
		this._posY = posY;
		this._posX = posX;
		this._direction = direction;
	}
	
	public int get_posX() {
		return _posX;
	}

	public void set_posX(int _posX) {
		this._posX = _posX;
	}

	public int get_posY() {
		return _posY;
	}

	public void set_posY(int _posY) {
		this._posY = _posY;
	}

	public Direction get_direction() {
		return _direction;
	}

	public void set_direction(Direction _direction) {
		this._direction = _direction;
	}

	public void ouEstTu() {
		System.out.println("Je suis en X=" + this._posX + ",Y=" + this._posY + " tourné vers le " + this._direction);
	}

	public void tourneAGauche() {
		switch (this._direction) {
		case Nord:
			this._direction = Direction.Ouest;
			break;
		case Sud:
			this._direction = Direction.Est;
			break;
		case Est:
			this._direction = Direction.Nord;
			break;
		case Ouest:
			this._direction = Direction.Sud;
			break;
		}
	}

	public void tourneADroite() {
		switch (this._direction) {
		case Nord:
			this._direction = Direction.Est;
			break;
		case Sud:
			this._direction = Direction.Ouest;
			break;
		case Est:
			this._direction = Direction.Sud;
			break;
		case Ouest:
			this._direction = Direction.Nord;
			break;
		}
	}

	public void avance() {
		switch (this._direction) {
		case Nord:
			this._posY += 1;
			break;
		case Sud:
			this._posY -= 1;
			break;
		case Est:
			this._posX += 1;
			break;
		case Ouest:
			this._posX -= 1;
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tortue franklin = new Tortue();
		Tortue bob = new Tortue(5, 2, Direction.Est);
		bob.ouEstTu();
		franklin.ouEstTu();
		franklin.avance();
		franklin.ouEstTu();

	}

}
