import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private View view;
    private Logic logic;

    private Canvas canvas;
    //private BufferedImage bufferedImage;
    private Graphics graphics;

    public Controller() {

        this.view = getView();
        logic = new Logic();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int maxArraySize;
        if (view.getTxtArraySize().getText().isBlank()) {
            maxArraySize = 100;
        } else {
            maxArraySize = Integer.parseInt(view.getTxtArraySize().getText());
        }
        this.logic = new Logic();
        int[][] coordinates;

        // This is for the graphics
        this.canvas = this.getView().getCanvas();
        this.graphics = canvas.getGraphics();

        if (e.getSource() == view.getBtnGraphicate()) {

            clearGraphic(graphics);

            coordinates = logic.generateQuickSortCoordinates(maxArraySize);
            drawGraphic(graphics, coordinates[0], coordinates[1], maxArraySize, Color.BLUE);

            coordinates = logic.generateCoordinatesLogBaseTwo(maxArraySize);
            drawGraphic(graphics, coordinates[0], coordinates[1], maxArraySize, Color.RED);

            view.setLblResFormula((int)(44 - 23 * 50 + 13 * 50 * Math.log(50) / Math.log(2)));
            int[] array = logic.generateArray(50);
            logic.quickSort(0, 50 -1, array);
            view.setLblResCounter(logic.getQuickSortEO());
            logic.setQuickSortEO(0);




//            coordinates = logic.generateMergeSortCoordinates(maxArraySize);
//            drawGraphic(graphics, coordinates[0], coordinates[1], maxArraySize, Color.ORANGE);


            /*coordinates = logic.generateCoordinates(maxArraySize);
            drawGraphic(graphics, coordinates[0], coordinates[1], maxArraySize, Color.BLACK);

            //coordinates = logic.generateCoordinatesLogBaseTwo(maxArraySize);
            //drawGraphic(graphics, coordinates[0], coordinates[1], maxArraySize, Color.BLUE);

            coordinates = logic.generateCoordinatesByFormula(maxArraySize);
            drawGraphic(graphics, coordinates[0], coordinates[1], maxArraySize, Color.RED);

            int[] array = logic.generateArray(maxArraySize);
            int pos = (int) (Math.random() * maxArraySize);
            int num = array[pos];
            logic.setCount(0);
            logic.binarySearch(array, 0, maxArraySize - 1, num);
            view.setLblResCounter(logic.getCount());

            view.setLblResFormula((int) (7 + 10 * (Math.log(maxArraySize)) / Math.log(2)));*/

        }

    }

    public View getView() {
        if (view == null) {
            view = new View(this);
        }
        return view;
    }

    public void drawGraphic(Graphics g, int[] xPoints, int[] yPoints, int n, Color color) {

        //g.setColor(Color.WHITE);
        //g.fillRect(0, 0, 500, 500);
        g.setColor(color);
        g.drawPolyline(xPoints, yPoints, n);

    }

    public void clearGraphic(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 500);

    }

}
