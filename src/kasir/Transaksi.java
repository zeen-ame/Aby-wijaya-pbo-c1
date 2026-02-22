
package kasir;
import javax.swing.*;
import java.sql.*;

public class Transaksi extends JFrame{

JTextField id=new JTextField();
JTextField jumlah=new JTextField();

JButton proses=new JButton("Proses");

public Transaksi(){

setTitle("Transaksi");
setSize(300,250);
setLayout(null);

add(new JLabel("ID Barang")).setBounds(20,20,100,25);
add(id).setBounds(120,20,120,25);

add(new JLabel("Jumlah")).setBounds(20,60,100,25);
add(jumlah).setBounds(120,60,120,25);

add(proses).setBounds(100,120,100,30);

proses.addActionListener(e->jalan());

}

void jalan(){

try{

Connection c=Koneksi.conn();

PreparedStatement p=c.prepareStatement(
"select harga from barang where id=?");

p.setString(1,id.getText());

ResultSet r=p.executeQuery();

if(r.next()){

int total=r.getInt("harga")*
Integer.parseInt(jumlah.getText());

PreparedStatement s=c.prepareStatement(
"insert transaksi(total) values(?)");

s.setInt(1,total);
s.executeUpdate();

JOptionPane.showMessageDialog(null,
"Total = "+total);

}

}catch(Exception e){}

}

}
