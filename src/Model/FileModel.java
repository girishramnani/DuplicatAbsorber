package Model;

import FileFind.FileEvent;

import javax.swing.table.AbstractTableModel;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Girish on 18-03-2015.
 */
public class FileModel extends AbstractTableModel {
    private List<FileEvent> filecolumn;
    private List<Boolean> selection;
    private String[] headers ={"id","File","Selected"};
    private Class[] classes = {int.class,String.class,Boolean.class};
    public FileModel(){
        super();
        filecolumn=new ArrayList<>();
        selection= new ArrayList<>();
        filecolumn.add(new FileEvent(Paths.get(".")));
        selection.add(Boolean.FALSE);
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
