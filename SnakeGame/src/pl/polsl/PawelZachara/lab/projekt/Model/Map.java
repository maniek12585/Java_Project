/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.PawelZachara.lab.projekt.Model;
import pl.polsl.PawelZachara.lab.projekt.FieldState;
import static java.lang.Math.pow;
import java.util.ArrayList;
import pl.polsl.PawelZachara.lab.projekt.View.FieldType;

/**
 *
 * @author Admin
 */


public class Map 
{ 
    private final int SNAKE_JOINT_SIZE = 20;
    private final int RANDOM_SPAWN_POSITION = 30;
    private int FIELDS_AMOUNT ;
    private ArrayList<MapField> mapData;
    
    
    public void Init(int windowSize) 
    {
        FIELDS_AMOUNT = (int) pow((windowSize / SNAKE_JOINT_SIZE),2);
        mapData = new ArrayList<>();
        for (int i = 0; i < this.FIELDS_AMOUNT; i++) 
        {
            InitMapDataField(mapData.get(i));
        }
    }
    
    
    
    
    private void InitMapDataField(MapField field)
    {
        field.Init(new Point(0,0),FieldState.EMPTY,FieldType.GROUND);
    }
    
    private void LoadResources()
    {
        
    }
}
