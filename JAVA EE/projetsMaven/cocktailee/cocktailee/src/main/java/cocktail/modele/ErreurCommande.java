package cocktail.modele;

public class ErreurCommande {

		private String erreurCocktail;
		private String erreurTable;
		
		public boolean isPresent() {
			return erreurCocktail != null || erreurTable != null ;
		}

		public String getErreurCocktail() {
			return erreurCocktail;
		}

		public void setErreurCocktail(String erreurCocktail) {
			this.erreurCocktail = erreurCocktail;
		}

		public String getErreurTable() {
			return erreurTable;
		}

		public void setErreurTable(String erreurTable) {
			this.erreurTable = erreurTable;
		}


}
