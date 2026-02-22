
package kasir;
import javax.swing.*;

public class Menu extends JFrame{

JButton barang=new JButton("Data Barang");
JButton transaksi=new JButton("Transaksi");

public Menu(){

setTitle("Menu Kasir");
setSize(400,300);
setLayout(null);

barang.setBounds(120,60,150,40);
transaksi.setBounds(120,140,150,40);

add(barang);
add(transaksi);

barang.addActionListener(e->new Barang().setVisible(true));
transaksi.addActionListener(e->new Transaksi().setVisible(true));

}

}
