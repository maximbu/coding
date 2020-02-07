package CodingInterviews2018.P16;

import java.util.HashSet;

public class LangtonsAntBoard {
    private HashSet<Cell> whites;
    private HashSet<Cell> blacks;
    private int maxX = 0;
    private int minX = 0;
    private int maxY = 0;
    private int minY = 0;

    public LangtonsAntBoard() {
        whites = new HashSet<>();
        blacks = new HashSet<>();
        whites.add(new Cell(0,0));
    }

    public Location makeMove(Location location) {
        Orientation newOrientation;
        Cell newCell;
        if(whites.contains(location.getCell())){
            whites.remove(location.getCell());
            blacks.add(location.getCell());
            newOrientation = location.getOrientation().rotate(false);
        }
        else {
            blacks.remove(location.getCell());
            whites.add(location.getCell());
            newOrientation = location.getOrientation().rotate(true);
        }
        switch (newOrientation){
            case Top:
                newCell=new Cell(location.getCell().getX(),location.getCell().getY()+1);
                break;
            case Right:
                newCell=new Cell(location.getCell().getX()+1,location.getCell().getY());
                break;
            case Bottom:
                newCell=new Cell(location.getCell().getX(),location.getCell().getY()-1);
                break;
            case Left:
                newCell=new Cell(location.getCell().getX()-1,location.getCell().getY());
                break;
            default:
                throw new IllegalStateException();
        }
        // it's a new cell
        if (!whites.contains(newCell) && !blacks.contains(newCell)) {
            if (isNewCellWhite(newCell)) {
                whites.add(newCell);
            } else {
                blacks.add(newCell);
            }
            adjustBoarders(newCell);
        }
        return new Location(newCell, newOrientation);
    }

    private boolean isNewCellWhite(Cell newCell) {
        //return (newCell.getX() + newCell.getY()) % 2 == 0;
        return true;
    }

    private void adjustBoarders(Cell newCell) {
        maxX = Math.max(maxX,newCell.getX());
        maxY = Math.max(maxY,newCell.getY());
        minX = Math.min(minX,newCell.getX());
        minY = Math.min(minY,newCell.getY());
    }

    public void print() {
        System.out.println();
        for (int i = maxY; i >= minY; i--) {
            for (int j = minX; j <= maxX ; j++) {
                Cell c = new Cell(j,i);
                if(whites.contains(c)){
                    System.out.print('W');
                    continue;
                }
                if(blacks.contains(c)){
                    System.out.print('B');
                    continue;
                }
                System.out.print(isNewCellWhite(c) ? 'W' : 'B');
            }
            System.out.println();
        }
    }
}
