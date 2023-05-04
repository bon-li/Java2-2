package java2assign2;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.collections.*;
import javafx.event.*;
import java.util.*;
import javafx.geometry.Insets;

public class ContactList extends Application{
    String name, number, email;
    int index = 0;
    Label nameLbl, numLbl, emailLbl;
    TextField nameTxt, numTxt, emailTxt;
    Button saveBtn, updateBtn, deleteBtn, nextBtn, prvBtn;
    
    ArrayList<Contact> contactList = new ArrayList<Contact>();
    
    public void start (Stage primaryStage){
        try {
            BorderPane pane = new BorderPane();
            GridPane fields = new GridPane();
            HBox buttonH = new HBox();
            VBox buttonV = new VBox();
            pane.setPadding(new Insets(10,10,10,10));
            
            nameLbl = new Label("Name ");
            numLbl = new Label("Number ");
            emailLbl = new Label("email ");
            
            nameTxt = new TextField();
            numTxt = new TextField();
            emailTxt = new TextField();
            
            saveBtn = new Button("Save");
            updateBtn = new Button("Update");
            deleteBtn = new Button("Delete");
            nextBtn = new Button("Next");
            prvBtn = new Button("Previous");
            
            fields.add(nameLbl, 0,0);
            fields.add(numLbl,0,1);
            fields.add(emailLbl,0,2);
            fields.add(nameTxt, 1,0);
            fields.add(numTxt,1,1);
            fields.add(emailTxt,1,2);
            
            buttonH.getChildren().addAll(saveBtn, updateBtn, deleteBtn);
            buttonV.getChildren().addAll(nextBtn, prvBtn);
            
            saveBtn.setOnAction(e -> save());
            updateBtn.setOnAction(e -> update());
            deleteBtn.setOnAction(e -> delete());
            nextBtn.setOnAction(e -> next());
            prvBtn.setOnAction(e -> previous());
            
            pane.setCenter(fields);
            pane.setRight(buttonV);
            pane.setBottom(buttonH);
            
            Scene scene = new Scene(pane,320,130);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Error occurred.");
        }
    }//start method end
    
    public void addContact(Contact contact){
        try {
            contactList.add(contact);
            index = contactList.size()-1;
        } catch (Exception e) {
            System.out.println("Unable to add contact.");
        }
    }//addContact end
    
    public void printContact(){
        try {
            Contact contact = contactList.get(index);
            nameTxt.setText(contact.getName());
            numTxt.setText(contact.getNumber());
            emailTxt.setText(contact.getEmail());
        } catch (Exception e) {
            System.out.println("Unable to display contact information.");
        }
    }//printContact end
    
    public void next(){
        try {
            if (index < (contactList.size()-1)) {
                index++;
                printContact();

            }
        } catch (Exception e) {
            System.out.println("First contact reached.");
        }
    }//next method end
    
    public void previous(){
        try {
            if (index > 0) {
                index--;
                printContact();

            }
        } catch (Exception e) {
            System.out.println("Last contact reached.");
        }
    }//previous method end
    
    public void save(){
        try {
            name = nameTxt.getText();
            number = numTxt.getText();
            email = emailTxt.getText();
            Contact contact = new Contact(name, number, email);
            addContact(contact);

            System.out.println("Contact has been saved.");
        } catch (Exception e) {
            System.out.println("Contact unable to save.");
        }
    }//save method end
    
    public void update(){
        try {
            Contact contact = contactList.get(index);
            name = nameTxt.getText();
            number = numTxt.getText();
            email = emailTxt.getText();
            contact = new Contact(name, number, email);
            contactList.set(index, contact);

            System.out.println("Contact has been updated.");
        } catch (Exception e) {
            System.out.println("Contact unable to update.");
        }
    }//update method end
    
    public void delete(){
        try {
            contactList.remove(index);

            System.out.println("Contact has been deleted.");
        } catch (Exception e) {
            System.out.println("Contact unable to delete.");
        }
    }//delete method end
    
    public static void main(String[]args){
        launch(args);
    }//main method end 
}//class end
