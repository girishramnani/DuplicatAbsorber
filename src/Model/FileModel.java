package Model;

import FileFind.FileEvent;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
    private int index=1;
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
            return filecolumn.get(row).getFile().toString();

        }
        else{
            return selection.get(row);
        }
    }
}
