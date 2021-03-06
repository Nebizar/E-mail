/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.mail;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author apasi
 */
public class EMail extends Application {
    
    public static ObservableList<Mail> recievedList = FXCollections.observableArrayList();
    public static ObservableList<Mail> sendList = FXCollections.observableArrayList();
    public static ObservableList<Contact> contactList = FXCollections.observableArrayList();
    public static Socket clientSocket;
    public static String loggedUser;
    
    @Override
    public void start(Stage stage) throws IOException {
        /*Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();*/
        Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("E(pic)-mail");
        stage.show();
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        try {
            clientSocket = new Socket("192.168.64.1", 8080);
            System.out.println("Polaczono z gniazdem");
        } catch (IOException ex) {
            //AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Error!", "Błąd przy połączeniu z serwerem - Sprawdz Polaczenie !");
            Logger.getLogger(EMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        recievedList.add(new Mail("yolo@wtf.com","topic1","TEST123"));
        sendList.add(new Mail("swag@wtf.com","topic1","TEST321"));
        contactList.add(new Contact("Frajer","pylylyly@wtf.com"));
        launch(args);
        try{
            OutputStream os = clientSocket.getOutputStream();
            String msg = "W/" + loggedUser + "/" ;
            System.out.println(msg);
            os.write(msg.getBytes());
        } catch (IOException ex) {
                Logger.getLogger(EmailFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        clientSocket.close();
    }
    
}
