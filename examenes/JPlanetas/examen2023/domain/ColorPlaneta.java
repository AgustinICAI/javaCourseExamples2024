package examen2023.domain;

import java.awt.Color;

public enum ColorPlaneta{
    rojo(java.awt.Color.RED),verde(java.awt.Color.GREEN),azul(java.awt.Color.BLUE);

    private Color colorPlaneta;
    ColorPlaneta(java.awt.Color color) {
        this.colorPlaneta = color;
    }
    public Color getColorPlaneta() {
        return colorPlaneta;
    }
}