public class RowMajorAddress {

    public static int calculateAddress(
            int baseAddress,
            int row,
            int column,
            int numberOfColumns,
            int elementSize) {

        return baseAddress
                + ((row * numberOfColumns) + column) * elementSize;
    }

    public static void main(String[] args) {

        int baseAddress = 1000;
        int row = 2;
        int column = 3;
        int numberOfColumns = 5;
        int elementSize = 4;

        int address = calculateAddress(
                baseAddress,
                row,
                column,
                numberOfColumns,
                elementSize
        );

        System.out.println("Address = " + address);
    }
}