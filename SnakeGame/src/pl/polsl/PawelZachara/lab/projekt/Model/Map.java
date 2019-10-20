/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.PawelZachara.lab.projekt.Model;
import pl.polsl.PawelZachara.lab.projekt.FieldState;
import pl.polsl.PawelZachara.lab.projekt.View.FieldType;


public class Map 
{ 
    private final Point RANDOM_SPAWN_POSITION = new Point(10,10);
    private MapField[][] mapData;
    
    
    public void init(int windowSize, int snakeJointSize) 
    {
        int numberOfElemsinRowOrCol = windowSize / snakeJointSize;
      

        mapData = new MapField[numberOfElemsinRowOrCol][numberOfElemsinRowOrCol];
        for (int row = 0; row < numberOfElemsinRowOrCol; row++) 
        {
            for (int column = 0; column < numberOfElemsinRowOrCol; column++) {
                
                if (row == 0 || row == numberOfElemsinRowOrCol-1 || column == 0 || column == numberOfElemsinRowOrCol-1) 
                {
                    mapData[row][column] = new MapField(new Point(row,column),FieldState.EMPTY,FieldType.WALL);
                }
                else
                {
                    mapData[row][column] = new MapField(new Point(row,column),FieldState.EMPTY,FieldType.WALL);
                }
            }
        }
        
        
        mapData[(int)RANDOM_SPAWN_POSITION.getX()][(int)RANDOM_SPAWN_POSITION.getY()].setFieldState(FieldState.SNAKE);
        mapData[(int)RANDOM_SPAWN_POSITION.getX()][(int)RANDOM_SPAWN_POSITION.getY()].setFieldType(FieldType.SNAKE_JOINT);

    }
    
    public MapField[][] getMapData()
    {
        return mapData;
    }
    
}
