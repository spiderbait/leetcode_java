package test;

public class Rotation {

    class Coordinate {
        float x;
        float y;

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj instanceof Coordinate) {
                Coordinate coordinate = (Coordinate) obj;
                if (coordinate.getX() == this.x && coordinate.getY() == this.y) {
                    return true;
                }
            }
            return false;
        }
    }

    public char[][] rotate(char[][] map) {
        char[][] result = new char[map.length][map[0].length];
        return result;
    }

    public Coordinate getCenterCoordinate(char[][] map) {

    }

    public Coordinate getClockwiseRotateCoordinate(Coordinate coordinate) {

        return coordinate;
    }

    public void printMap(char[][] map) {
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[i].length; j ++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] inputMap = {{1, 1, 1, 0, 1}, {1, 1, 0, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 0, 1}}; // cortex (2, 1)
        char[][] rotatedMap = {{1, 1, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 1, 1, 1, 1}};  // cortex (1, 2)
        // cortex (2, 3)
        // cortex (3, 2)

        Rotation rotation =  new Rotation();
        rotation.printMap(inputMap);
        System.out.println();
        rotation.printMap(rotatedMap);
    }
}
