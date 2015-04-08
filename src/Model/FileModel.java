package Model;

import FileFind.FileEvent;
import Gui.Interactor;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Girish on 18-03-2015.
 */
public class FileModel extends AbstractTableModel {
    private List<FileEvent> filecolumn;
    private List<Boolean> selection;
    private HashSet<FileEvent> deleteList;  // only need add contain and delete, all work in constant time
    private String[] headers ={"id","File","Selected"};
    private Interactor buttonInteractor;
    private Class[] classes = {int.class,String.class,Boolean.class};

    public FileModel(){
        super();
        filecolumn=new ArrayList<>();
        selection= new ArrayList<>();
        deleteList = new HashSet<>();
    }


    public void setInteractor(Interactor interactor){
        this.buttonInteractor = interactor;
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public int getRowCount() {
        return filecolumn.size();
    }


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public Object getValueAt(int row, int column) {
        if(column ==0){

            return row;
        }
        else if(column ==1){
            return filecolumn.get(row).getFile().getAbsolutePath().toString();

        }
        else{
            return selection.get(row);
        }
    }

    @Override
    public void fireTableCellUpdated(int row, int column) {
        System.out.println(String.format("%d %d changed",row,column));
        if(column ==2){
            FileEvent selected = filecolumn.get(row);
            if(selection.get(row)){
                deleteList.add(selected);
            }
            else{
                if(deleteList.contains(selected)){
                    deleteList.remove(selected);
                }
            }
        }
        System.out.println(deleteList);
        buttonInteractor.interact(String.valueOf(deleteList.size()));
        super.fireTableCellUpdated(row, column);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
        if (columnIndex==2){
            selection.set(rowIndex,!selection.get(rowIndex));
            fireTableCellUpdated(rowIndex,columnIndex);
        }
    }



    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex ==2){
            return true;

        }
        return false;
    }


    public void addData(FileEvent fileEvent){
        filecolumn.add(fileEvent);
        selection.add(Boolean.FALSE);
        fireTableRowsInserted(filecolumn.size()-1,filecolumn.size());
    }


}
