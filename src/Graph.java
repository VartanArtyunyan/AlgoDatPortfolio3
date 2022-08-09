// Vartan Artyunyan
// Martikelnummer 5120007

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
//Vartan Artyunyan
//Martikelnummer 5120007
public class Graph {

	int knotenAnzahl;
	int[][] matrix;

	public Graph(String datei) {

		knotenAnzahl = countKnoten(datei);
		matrix = new int[knotenAnzahl][knotenAnzahl];
		loadFile(datei);

	}

	private int countKnoten(String datei) {
		int reihe = 0;
		try (FileReader fr = new FileReader(datei); BufferedReader br = new BufferedReader(fr);) {

			String line;

			while ((line = br.readLine()) != null) {

				reihe++;

			}

		} catch (Exception e) {

		}
		return reihe;
	}

	private void loadFile(String datei) {
		try (FileReader fr = new FileReader(datei); BufferedReader br = new BufferedReader(fr);) {

			String line;
			int reihe = 0;

			while ((line = br.readLine()) != null) {

				String[] werte = line.split(",");

				for (int i = 0; i < werte.length; i++) {

					matrix[reihe][i] = Integer.parseInt(werte[i]);

				}

				reihe++;

			}

		} catch (Exception e) {

		}

	}

	public int getSize() {
		return knotenAnzahl;
	}

	public int getDistance(int k1, int k2) {
		if (matrix[k1][k2] != 0)
			return matrix[k1][k2];
		else
			return Integer.MAX_VALUE;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public ArrayList<Integer> getNachbar(int k) {
		ArrayList<Integer> liste = new ArrayList<>();
		for (int i = 0; i < matrix[k].length; i++) {
			if (matrix[k][i] != 0)
				liste.add(i);
		}
		return liste;

	}

	public void printGraph() {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
	}

	public static void printGraph(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
	}

}
