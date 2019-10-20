
public class TriABulle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] table = {22,14,99,20,15,44,2,7,74,27,1}; // le tableau è trier en attribut
		for(int num:table)
			System.out.print(num+" ");
		triAbulle(table);
		System.out.println("\n");
		for(int num:table)
			System.out.print(num+" ");
	}

	private static void triAbulle(int[] table) {

		int n = table.length - 1;
		for (int i = n; i >= 1; i--) {
			System.out.println("i :"+i);
			for (int j = 1; j <= i; j++) {
				System.out.println("j :"+j);
				if (table[j - 1] > table[j]) {
					int temp = table[j - 1];
					table[j - 1] = table[j];
					table[j] = temp;
				}
			}
		}
	}

}