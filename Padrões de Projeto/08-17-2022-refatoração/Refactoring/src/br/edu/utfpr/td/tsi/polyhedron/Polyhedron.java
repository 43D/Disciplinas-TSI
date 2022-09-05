package br.edu.utfpr.td.tsi.polyhedron;

public class Polyhedron {

	private static int vertice;
	private static int edge;
	private static int face;
	private static final int[] vertices = { 4, 6, 8, 12, 20 };
	private static final int[] edges = { 6, 12, 30 };
	private static final int[][] combinations = { 
			{ 0, 0 },
			{ 1, 1 },
			{ 2, 1 },
			{ 3, 2 },
			{ 4, 2 },
	};
	private static final String[][] combinationsNames = { 
			{ "Tetraedro", "Trïangulo" },
			{ "Octaedro", "Trïangulo" },
			{ "Hexaedro:", "Quadrado" },
			{ "Icosaedro", "Trïangulo" },
			{ "Dodecaedro", "Pentagono" },
	};

	public static boolean isContainsVertice(int vertice) {
		return isContains(vertices, vertice);
	}

	public static boolean isContainsEdge(int edge) {
		return isContains(edges, edge);
	}

	private static boolean isContains(int[] array, int search) {
		for (int index = 0; index < array.length; index++) {
			if (search == array[index]) {
				return true;
			}
		}
		return false;
	}

	private static int getIndexCombinations() {
		for (int index = 0; index < combinations.length; index++) {
			if (vertice == vertices[combinations[index][0]]) {
				if (edge == edges[combinations[index][1]]) {
					return index;
				}
			}
		}
		return -1;
	}

	private static String[] getPolydronInfomartion() {
		String[] result = { "false", "", "", "", "", "" };
		int index = getIndexCombinations();
		if (index >= 0) {
			result[0] = "true";
			result[1] = combinationsNames[index][0];
			result[2] = combinationsNames[index][1];
			result[3] = String.valueOf(vertice);
			result[4] = String.valueOf(edge);
			result[5] = String.valueOf(face);
		}

		return result;
	}

	public static String[] getPolydronInfomartion(int vertice, int edge) {
		Polyhedron.edge = edge;
		Polyhedron.vertice = vertice;
		setFace();

		return getPolydronInfomartion();
	}

	protected static void setFace() {
		face = 2 + edge - vertice;
	}
}
