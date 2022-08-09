// Vartan Artyunyan
// Martikelnummer 5120007
import java.util.ArrayList;
import java.util.Collections;

public class FloyWa {

	Graph g;
	int[][] edges;
	int n;
	int[][] distMatrix;
	int[][] pathMatrix;
	int[] LargestDistKoordinates;

	public FloyWa(String datei) {
		g = new Graph(datei);
		edges = g.getMatrix();
		n = g.getSize();
		floywa();
	}

	public void floywa() {

		int[][] dist = new int[n][n];
		int[][] path = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (edges[i][j] != 0) {
					dist[i][j] = edges[i][j];
				} else if (i == j) {
					dist[i][j] = 0;
				} else {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					if ((i != j) && (dist[i][k] < Integer.MAX_VALUE) && (dist[k][j] < Integer.MAX_VALUE)) {

						if (dist[i][k] + dist[k][j] < dist[i][j]) {
							dist[i][j] = dist[i][k] + dist[k][j];
							path[i][j] = k;
						}

					}

				}
			}
		}
		distMatrix = dist;
		pathMatrix = path;

	}

	public int[] getLargestDistKoordinates() {
		if (LargestDistKoordinates != null)
			return LargestDistKoordinates;
		int[] koordinaten = new int[2];
		koordinaten[0] = 0;
		koordinaten[1] = 0;
		int value = distMatrix[0][0];

		for (int i = 0; i < distMatrix.length; i++) {
			for (int j = 0; j < distMatrix[i].length; j++) {
				if (distMatrix[i][j] > value) {
					value = distMatrix[i][j];
					koordinaten[0] = i;
					koordinaten[1] = j;
				}
			}
		}
		LargestDistKoordinates = koordinaten;
		return LargestDistKoordinates;
	}

	public int getLargestDist() {
		int[] koordinaten = getLargestDistKoordinates();
		return distMatrix[koordinaten[0]][koordinaten[1]];
	}

	public void printDist() {
		Graph.printGraph(distMatrix);
		System.out.println();
	}

	public ArrayList<Integer> getPath(int k, int k2) {
		int start = k;
		int ziel = k2;
		ArrayList<Integer> pfad = new ArrayList<>();
		int current = pathMatrix[start][ziel];
		pfad.add(ziel);
		if (current == 0)
			pfad.add(start);
		while (current != 0) {
			pfad.add(pathMatrix[start][ziel]);
			current = pathMatrix[start][ziel];
			ziel = current;
		}
		Collections.reverse(pfad);
		return pfad;
	}

	public void printPath() {
		Graph.printGraph(pathMatrix);
		System.out.println();
	}
}
