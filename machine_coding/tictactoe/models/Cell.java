package machine_coding.tictactoe.models;

public class Cell {
    private int row;
    private int col;
    private CellStatus cellStatus;
    private Player player;



    public Cell(int row, int col, CellStatus cellStatus) {
        this.row = row;
        this.col = col;
        this.cellStatus = cellStatus;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player){
        this.player = player;
        this.cellStatus = CellStatus.OCCUPIED;
    }

    public boolean isUnoccupied(){
        return this.player == null && cellStatus.equals(CellStatus.UNOCCUPIED);
    }

    public void printCell(){
        if(cellStatus.equals(CellStatus.UNOCCUPIED)){
            System.out.print(" _ ");
        } else {
            System.out.print(" " +this.player.getSymbol().getSymbol()+" ");
        }
    }
}
