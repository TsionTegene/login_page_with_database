
import java.beans.Statement;
import java.io.File;
import java.net.URL;
import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.PreparableStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
    
    public class Controller  {
    
        @FXML
        private TextField EmailTextfield;
        @FXML
        private AnchorPane pane_login;
    
        @FXML
        private TextField FnameTextfield;
    
        @FXML
        private TextField LnameTextfield;
    
        @FXML
        private PasswordField passwordfield;
    
        @FXML
        private Button SignupBtn;

        @FXML
        private ImageView handsimage;

        @FXML
        private AnchorPane pane_welcome;

        @FXML
        private AnchorPane pane_lockimage;

        @FXML
        private Label welcometext;
    
        @FXML
        private TextField UsernameTextField;
    
        
        @FXML
        private Label labelusername;

        @FXML
        private TextField textfieldusername;

        @FXML
        private PasswordField enterPasswordField;
    
        @FXML
        private Button loginButton;

        @FXML
        private PasswordField confirmpasswordfield;
    
        @FXML
        private Button signupButton;

        @FXML
        private AnchorPane pane_signup;

        @FXML
        private AnchorPane pane_signupinterface;

        Connection conn = null;
         ResultSet rs = null;
         PreparedStatement pst = null;

        public void LoginPaneShow() {
             pane_login.setVisible(true);
             pane_signup.setVisible(true);

        }

        public void SignuppaneShow() {
            pane_login.setVisible(false);
            pane_signup.setVisible(false);
            pane_signupinterface.setVisible(true);
        }

        public void welcomepaneshow() {
            pane_login.setVisible(false);
            pane_signup.setVisible(false);
            pane_signupinterface.setVisible(false);
            pane_welcome.setVisible(true);
            pane_lockimage.setVisible(false);
        }

        @FXML
        private void Login (ActionEvent event) throws Exception {
            conn = DatabaseConnection.ConnectDb();
            String sql = "Select * from user_account where username = ? and password = ?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1,UsernameTextField.getText());
                pst.setString(2,enterPasswordField.getText());
                rs = pst.executeQuery();
                 
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Username And Password is Correct");
                    welcomepaneshow();
                }else
                    JOptionPane.showMessageDialog(null, "Invalid username Or Password");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
        @FXML
        private void Signup(ActionEvent e) throws Exception {
            conn = DatabaseConnection.ConnectDb();
            int n;
            String sql = "INSERT INTO user_account (firstname, lastname, username, password,email) VALUES (?, ?, ? ,? ,?);";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1,FnameTextfield.getText());
                pst.setString(2,LnameTextfield.getText());
                pst.setString(3,textfieldusername.getText());
                pst.setString(4,passwordfield.getText());
                pst.setString(5,EmailTextfield.getText());

                n = pst.executeUpdate();
                // if(rs.next()){
                //     JOptionPane.showMessageDialog(null, "Username And Password is Correct");
                    LoginPaneShow();
                    pane_signupinterface.setVisible(false);
                // }else
                //     JOptionPane.showMessageDialog(null, "Invalid username Or Password");
                
            } catch (Exception ev) {
                JOptionPane.showMessageDialog(null, ev);
            }
        }
       }
       
    
      

