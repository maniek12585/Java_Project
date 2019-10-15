/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.PawelZachara.lab.projekt.Model;

import pl.polsl.PawelZachara.lab.projekt.FieldState;
import pl.polsl.PawelZachara.lab.projekt.View.FieldType;

/**
 *
 * class that indicates one field on map , its coordinates , state and type
 */
public class MapField
{
    private Point coordinates;
    private FieldState fieldState;
    private FieldType fieldType;

    /**
     * @return the coordinates
     */
    public Point getCoordinates() {
        return coordinates;
    }

    /**
     * @param coordinates the coordinates to set
     */
    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * @return the fieldState
     */
    public FieldState getFieldState() {
        return fieldState;
    }

    /**
     * @param fieldState the fieldState to set
     */
    public void setFieldState(FieldState fieldState) {
        this.fieldState = fieldState;
    }

    /**
     * @return the fieldType
     */
    public FieldType getFieldTexture() {
        return fieldType;
    }

    /**
     * @param fieldTexture the fieldType to set
     */
    public void setFieldTexture(FieldType fieldTexture) {
        this.fieldType = fieldTexture;
    }
    
    public void Init(Point coords,FieldState fieldState,FieldType fieldType)
    {
        this.coordinates = coords;
        this.fieldState = fieldState;
        this.fieldType = fieldType;
    }
        
}
