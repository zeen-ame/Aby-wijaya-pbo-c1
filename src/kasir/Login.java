
package kasir;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame{

JTextField user=new JTextField();
JPasswordField pass=new JPasswordField();
JButton login=new JButton("Login");

public Login(){

setTitle("Login Kasir");
setSize(300,200);
setLayout(null);

add(new JLabel("Username")).setBounds(20,20,100,25);
add(user).setBounds(120,20,120,25);

add(new JLabel("Password")).setBounds(20,60,100,25);
add(pass).setBounds(120,60,120,25);

add(login).setBounds(100,110,100,30);

login.addActionListener(e->cek());

setDefaultCloseOperation(EXIT_ON_CLOSE);

}

void cek(){

try{

Connection c=Koneksi.conn();

PreparedStatement p=c.prepareStatement(
"select * from user where username=? and password=?");

p.setString(1,user.getText());
p.setString(2,pass.getText());

ResultSet r=p.executeQuery();

if(r.next()){

new Menu().setVisible(true);
dispose();

}else{

JOptionPane.showMessageDialog(null,"Login gagal");

}

}catch(Exception e){

JOptionPane.showMessageDialog(null,"Error koneksi");

}

}

public static void main(String args[]){

new Login().setVisible(true);

}

}
