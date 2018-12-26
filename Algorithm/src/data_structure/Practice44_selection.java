package data_structure;


public class Practice44_selection {
	//선택정렬 연습
	int[] array = { 8, 5, 6, 2, 4 };
	int temp = 0;

	public static void main(String[] args) {

		Practice44_selection sel = new Practice44_selection();
		sel.print();
		sel.sort();
		sel.print();
	}


	public void print() {

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public void sort() {

		for (int i = 0; i < array.length-1; i++) {

			for (int j = i; j < array.length-1; j++) {

				if (array[i] > array[j+1]) {

					temp = array[j+1];
					array[j+1] = array[i];
					array[i] = temp;

				}
			}

		}

	}

}
