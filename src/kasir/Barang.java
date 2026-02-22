
package kasir;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class Barang extends JFrame{

JTextField nama=new JTextField();
JTextField harga=new JTextField();
JTextField stok=new JTextField();

JButton simpan=new JButton("Tambah");

DefaultTableModel model=new DefaultTableModel();
JTable tabel=new JTable(model);

public Barang(){

setTitle("Data Barang");
setSize(500,400);
setLayout(null);

add(new JLabel("Nama")).setBounds(20,20,80,25);
add(nama).setBounds(100,20,120,25);

add(new JLabel("Harga")).setBounds(20,60,80,25);
add(harga).setBounds(100,60,120,25);

add(new JLabel("Stok")).setBounds(20,100,80,25);
add(stok).setBounds(100,100,120,25);

add(simpan).setBounds(100,140,100,30);

model.addColumn("ID");
model.addColumn("Nama");
model.addColumn("Harga");
model.addColumn("Stok");

JScrollPane sp=new JScrollPane(tabel);
sp.setBounds(20,200,440,150);

add(sp);

simpan.addActionListener(e->simpan());

load();

}

void load(){

try{

Connection c=Koneksi.conn();

ResultSet r=c.createStatement().executeQuery(
"select * from barang");

while(r.next()){

model.addRow(new Object[]{
r.getString("id"),
r.getString("nama"),
r.getString("harga"),
r.getString("stok")
});

}

}catch(Exception e){}

}

void simpan(){

try{

Connection c=Koneksi.conn();

PreparedStatement p=c.prepareStatement(
"insert barang(nama,harga,stok) values(?,?,?)");

p.setString(1,nama.getText());
p.setString(2,harga.getText());
p.setString(3,stok.getText());

p.executeUpdate();

JOptionPane.showMessageDialog(null,"Tersimpan");

}catch(Exception e){}

}

}
