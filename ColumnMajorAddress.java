public class ColumnMajorAddress {

    public static int calculateAddress(
            int baseAddress,
            int row,
            int column,
            int numberOfRows,
            int elementSize) {

        return baseAddress
                + ((column * numberOfRows) + row) * elementSize;
    }

    public static void main(String[] args) {

        int baseAddress = 1000;
        int row = 2;
        int column = 3;
        int numberOfRows = 4;
        int elementSize = 4;

        int address = calculateAddress(
                baseAddress,
                row,
                column,
                numberOfRows,
                elementSize
        );

        System.out.println("Address = " + address);
    }
}