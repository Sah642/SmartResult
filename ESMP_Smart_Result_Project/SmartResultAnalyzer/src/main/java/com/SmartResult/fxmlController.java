package com.SmartResult;
import com.SmartResult.Converter;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;
//import org.apache.poi.ss.usermodel.CellStyle;

public class fxmlController {
    File filepdf;

    @FXML
    private Button selectfilebutton;

    @FXML
    private Button convertbutton;

    @FXML
    private RadioButton TE;

    @FXML
    private RadioButton BE;

    @FXML
    private RadioButton SE;

    @FXML
    private RadioButton BOTHSEM;

    @FXML
    private RadioButton SEM1;
    @FXML
    private Label labelfile;
 @FXML
    private Label labelcomp;
    @FXML
    void convert(ActionEvent event) throws IOException {
        Converter A=new Converter();
        ///expection exit
        int flag=0;
        try{
        if(SE.isSelected() && !TE.isSelected() && !BE.isSelected())
        {
            if(SEM1.isSelected() && !BOTHSEM.isSelected())
            {
                A.primarycontroller(filepdf, 2, 0);
            }
            else if(!SEM1.isSelected() && BOTHSEM.isSelected())
            {
                A.primarycontroller(filepdf, 2, 1); 
            }
            else{
                flag=1;
            }
           
        }
        else if(!SE.isSelected() && TE.isSelected() && !BE.isSelected())
        {
            if(SEM1.isSelected() && !BOTHSEM.isSelected())
            {
                A.primarycontroller(filepdf, 3, 0);
            }
            else if(!SEM1.isSelected() && BOTHSEM.isSelected())
            {
                A.primarycontroller(filepdf, 3, 1); 
            }
            else{
                flag=1;
            }
        }
        else if(!SE.isSelected() && !TE.isSelected() && BE.isSelected())
        {
             if(SEM1.isSelected() && !BOTHSEM.isSelected())
            {
                A.primarycontroller(filepdf, 4, 0);
            }
            else if(!SEM1.isSelected() && BOTHSEM.isSelected())
            {
                A.primarycontroller(filepdf, 4, 1);  
            }
            else{
                flag=1;
            }
             
        }
        else{
             flag=1;
        }
         if(flag==1){
               labelcomp.setText("Failed Plz Close and Run App Again!!");
         }
         else{
             labelcomp.setText("File Converted Sucessfully");
         }
        System.out.println("task completed");
        }
        catch(Exception e){
            labelcomp.setText("Failed  Close and Run App Again!!");
        }

    }

    @FXML
    void selectfile(ActionEvent event) {
        
        FileChooser fc=new FileChooser();
         fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files","*.pdf"));
         filepdf =fc.showOpenDialog(null); 
              if(fc!=null){
                labelfile.setText(filepdf.getAbsolutePath());
            }
    }

}
