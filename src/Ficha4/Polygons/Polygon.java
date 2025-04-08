package Ficha4.Polygons;

import Ficha3.Points.Point2D;
import java.util.ArrayList;

public class Polygon {
    private final ArrayList<Point2D> vertices = new ArrayList<>();

    public int getNumberOfVertices() {
        return vertices.size();
    }

    public void addVertex(Point2D vertex) {
        vertices.add(vertex);
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < vertices.size(); i++) {
            s += "\nV" + i + "-> " + vertices.get(i);
        }
        return s + "\n";
    }
}
