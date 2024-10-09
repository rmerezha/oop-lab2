package rmerezha.editor;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import rmerezha.shape.EllipseShape;
import rmerezha.shape.LineShape;
import rmerezha.shape.Shape;
import rmerezha.util.Point;
import rmerezha.util.WrappedArray;

import java.util.List;

public class EllipseEditor extends ShapeEditor{

    public EllipseEditor(GraphicsContext gc, WrappedArray<Shape> shapes) {
        super(gc, shapes);
        shape = new EllipseShape();
    }

    @Override
    public void onMouseMove(MouseEvent event) {
        onPaint();
        Point currentPoint = new Point(event.getX(), event.getY());

        double minX2 = Point.minX(shape.getP1(), currentPoint);
        double minY2 = Point.minY(shape.getP1(), currentPoint);
        double w2 = Point.w(shape.getP1(), currentPoint);
        double h2 = Point.h(shape.getP1(), currentPoint);

        gc.setStroke(Color.RED);
        gc.strokeOval(minX2, minY2, w2, h2);
        gc.setStroke(Color.BLACK);
    }
}
