package mainPackage;

import java.util.logging.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class Oyun {
	static int hamle = 0;
	static int maxHamle = 50;
	public static Oyuncu Oyuncu1;
	public static Oyuncu Oyuncu2;
	private static Logger logger = Logger.getLogger("tasKagitMakas");
	public static void main(String[] args) {
		init();
		// Nesneler için listler oluşturuluyor
		Nesne[] objects = { new Tas(), new Kagit(), new Makas() };
		initFrm1(objects);
	}

	static int tasSayac = 0, kagitSayac = 0, makasSayac = 0;

	public static void initFrm1(Nesne[] objects) {
		JFrame frm1 = new JFrame();
		// Arayüz için gerekli button ve labeller oluşturuluyor
		ImageIcon icon = new ImageIcon(
				"C:\\Users\\ASUS\\Desktop\\Prolab2\\tasKagitMakas\\images\\rock-paper-scissors.png");

		JLabel lblName= new JLabel();
		lblName.setSize(134, 36);
		lblName.setLocation(186, 420);
		lblName.setVisible(false);
		lblName.setText("Oyuncu ismini girin:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Calibri",Font.BOLD,15));

		JTextField nameTXT= new JTextField();
		nameTXT.setBorder(new LineBorder(Color.BLACK));
		nameTXT.setVisible(false);
		nameTXT.setFont(new Font("Calibri",Font.BOLD,18));
		nameTXT.setSize(150, 36);
		nameTXT.setLocation(325, 420);
		JButton btnMod1 = new JButton();
		JButton btnMod2 = new JButton();
		JButton btnStart = new JButton();
		JButton btnObj1 = new JButton();
		JButton btnObj2 = new JButton();
		JButton btnObj3 = new JButton();
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel(icon);
		JLabel label4 = new JLabel();
		JLabel label5 = new JLabel();

		// Oyun modu butonları tanımlanıyor
		btnMod1.setText("Kullanıcı-Bilgisayar");
		btnMod1.setBorder(new LineBorder(Color.BLACK));
		btnMod1.setBounds(186, 340, 164, 50);
		btnMod1.setForeground(Color.WHITE);
		btnMod1.setBackground(new Color(35,35,35));
		btnMod1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oyuncu1 = new Kullanici();
				Oyuncu2 = new Bilgisayar();
				lblName.setVisible(true);
				nameTXT.setVisible(true);
				btnMod1.setVisible(false);
				btnMod2.setVisible(false);
				label1.setVisible(false);
				label2.setVisible(false);
				label3.setVisible(false);

				btnObj1.setVisible(true);
				btnObj2.setVisible(true);
				btnObj3.setVisible(true);
				btnStart.setVisible(true);
				label4.setVisible(true);
			}
		});
		btnMod1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnMod1.setBackground(Color.GRAY);
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnMod1.setBackground(new Color(35,35,35));
			}
		});
		btnMod2.setText("Bilgisayar-Bilgisayar");
		btnMod2.setBorder(new LineBorder(Color.BLACK));
		btnMod2.setForeground(Color.WHITE);
		btnMod2.setBackground(new Color(35,35,35));
		btnMod2.setBounds(450, 340, 164, 50);
		btnMod2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm1.setVisible(false);
				try {
					initFrm3();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnMod2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnMod2.setBackground(Color.GRAY);
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnMod2.setBackground(new Color(35,35,35));
			}
		});
		// Obje butonlarının özellikleri tanımlanıyor
		btnObj1.setBorder(new LineBorder(Color.BLACK));
		btnObj1.setSize(150, 210);
		btnObj1.setFont(new Font("Calibri", Font.BOLD, 25));
		btnObj1.setLocation(100, 200);
		btnObj1.setText("Taş");
		btnObj1.setBackground(new Color(35,35,35));
		btnObj1.setForeground(Color.WHITE);
		btnObj1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tasSayac == 0) {
					Tas tas1 = new Tas();
					Oyuncu1.nesneList.add(tas1);
					tasSayac++;
				} else if (tasSayac == 1) {
					Tas tas2 = new Tas();
					Oyuncu1.nesneList.add(tas2);
					tasSayac++;
				} else if (tasSayac == 2) {
					Tas tas3 = new Tas();
					Oyuncu1.nesneList.add(tas3);
					tasSayac++;
				} else if (tasSayac == 3) {
					Tas tas4 = new Tas();
					Oyuncu1.nesneList.add(tas4);
					tasSayac++;
				} else if (tasSayac == 4) {
					Tas tas5 = new Tas();
					Oyuncu1.nesneList.add(tas5);
				}
				if (Oyuncu1.nesneList.size() == 5) {
					logger.info("Kullanıcının seçtiği nesneler: " + Oyuncu1.nesneList.get(0).getNesneIsım() + ", "
					+ Oyuncu1.nesneList.get(1).getNesneIsım() + ", " + Oyuncu1.nesneList.get(2).getNesneIsım()
					+ ", " + Oyuncu1.nesneList.get(3).getNesneIsım() + ", "
					+ Oyuncu1.nesneList.get(4).getNesneIsım());
					label5.setText("Seçilen nesneler: " + Oyuncu1.nesneList.get(0).getNesneIsım() + ", "
							+ Oyuncu1.nesneList.get(1).getNesneIsım() + ", " + Oyuncu1.nesneList.get(2).getNesneIsım()
							+ ", " + Oyuncu1.nesneList.get(3).getNesneIsım() + ", "
							+ Oyuncu1.nesneList.get(4).getNesneIsım());
					label4.setText("Oyunu Başlatın");
					btnObj1.setEnabled(false);
					btnObj2.setEnabled(false);
					btnObj3.setEnabled(false);
					btnStart.setEnabled(true);
					btnStart.setBackground(Color.RED);
					label5.setVisible(true);
				}
			}
		});

		btnObj1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				if (btnObj1.isEnabled()) {
					btnObj1.setBackground(Color.GRAY);
				}
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnObj1.setBackground(new Color(35,35,35));
			}
		});

		btnObj2.setBorder(new LineBorder(Color.BLACK));
		btnObj2.setLocation(325, 200);
		btnObj2.setSize(150, 210);
		btnObj2.setFont(new Font("Calibri", Font.BOLD, 25));
		btnObj2.setText("Kağıt");
		btnObj2.setBackground(new Color(35,35,35));
		btnObj2.setForeground(Color.WHITE);
		btnObj2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kagitSayac == 0) {
					Kagit kagit1 = new Kagit();
					Oyuncu1.nesneList.add(kagit1);
					tasSayac++;
				} else if (kagitSayac == 1) {
					Kagit kagit2 = new Kagit();
					Oyuncu1.nesneList.add(kagit2);
					tasSayac++;
				} else if (kagitSayac == 2) {
					Kagit kagit3 = new Kagit();
					Oyuncu1.nesneList.add(kagit3);
					tasSayac++;
				} else if (kagitSayac == 3) {
					Kagit kagit4 = new Kagit();
					Oyuncu1.nesneList.add(kagit4);
				} else if (kagitSayac == 4) {
					Kagit kagit5 = new Kagit();
					Oyuncu1.nesneList.add(kagit5);
				}
				if (Oyuncu1.nesneList.size() == 5) {
					logger.info("Kullanıcının seçtiği nesneler: " + Oyuncu1.nesneList.get(0).getNesneIsım() + ", "
					+ Oyuncu1.nesneList.get(1).getNesneIsım() + ", " + Oyuncu1.nesneList.get(2).getNesneIsım()
					+ ", " + Oyuncu1.nesneList.get(3).getNesneIsım() + ", "
					+ Oyuncu1.nesneList.get(4).getNesneIsım());
					label5.setText("Seçilen nesneler: " + Oyuncu1.nesneList.get(0).getNesneIsım() + ", "
							+ Oyuncu1.nesneList.get(1).getNesneIsım() + ", " + Oyuncu1.nesneList.get(2).getNesneIsım()
							+ ", " + Oyuncu1.nesneList.get(3).getNesneIsım() + ", "
							+ Oyuncu1.nesneList.get(4).getNesneIsım());
					label4.setText("Oyunu Başlatın");
					btnObj1.setEnabled(false);
					btnObj2.setEnabled(false);
					btnObj3.setEnabled(false);
					btnStart.setEnabled(true);
					btnStart.setBackground(Color.RED);
					label5.setVisible(true);
				}
			}
		});
		btnObj2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				if (btnObj1.isEnabled()) {
					btnObj2.setBackground(Color.GRAY);
				}
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnObj2.setBackground(new Color(35,35,35));
			}
		});

		btnObj3.setBorder(new LineBorder(Color.BLACK));
		btnObj3.setLocation(550, 200);
		btnObj3.setSize(150, 210);
		btnObj3.setFont(new Font("Calibri", Font.BOLD, 25));
		btnObj3.setText("Makas");
		btnObj3.setBackground(new Color(35,35,35));
		btnObj3.setForeground(Color.WHITE);
		btnObj3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (makasSayac == 0) {
					Makas makas1 = new Makas();
					Oyuncu1.nesneList.add(makas1);
					tasSayac++;
				} else if (makasSayac == 1) {
					Makas makas2 = new Makas();
					Oyuncu1.nesneList.add(makas2);
					tasSayac++;
				} else if (makasSayac == 2) {
					Makas makas3 = new Makas();
					Oyuncu1.nesneList.add(makas3);
					tasSayac++;
				} else if (makasSayac == 3) {
					Makas makas4 = new Makas();
					Oyuncu1.nesneList.add(makas4);
				} else if (makasSayac == 4) {
					Makas makas5 = new Makas();
					Oyuncu1.nesneList.add(makas5);
				}
				if (Oyuncu1.nesneList.size() == 5) {
					logger.info("Kullanıcının seçtiği nesneler: " + Oyuncu1.nesneList.get(0).getNesneIsım() + ", "
					+ Oyuncu1.nesneList.get(1).getNesneIsım() + ", " + Oyuncu1.nesneList.get(2).getNesneIsım()
					+ ", " + Oyuncu1.nesneList.get(3).getNesneIsım() + ", "
					+ Oyuncu1.nesneList.get(4).getNesneIsım());
					label5.setText("Seçilen nesneler: " + Oyuncu1.nesneList.get(0).getNesneIsım() + ", "
							+ Oyuncu1.nesneList.get(1).getNesneIsım() + ", " + Oyuncu1.nesneList.get(2).getNesneIsım()
							+ ", " + Oyuncu1.nesneList.get(3).getNesneIsım() + ", "
							+ Oyuncu1.nesneList.get(4).getNesneIsım());
					label4.setText("Oyunu Başlatın");
					btnObj1.setEnabled(false);
					btnObj2.setEnabled(false);
					btnObj3.setEnabled(false);
					btnStart.setEnabled(true);
					btnStart.setBackground(Color.RED);
					label5.setVisible(true);
				}
			}
		});
		btnObj3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				if (btnObj3.isEnabled()) {
					btnObj3.setBackground(Color.GRAY);
				}
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnObj3.setBackground(new Color(35,35,35));
			}
		});
		// label özellikleri tanımlanıyor
		label1.setText("Taş Kağıt Makas");
		label1.setLocation(316, 98);
		label1.setSize(188, 63);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Calibri", Font.BOLD, 25));
		label2.setText("Oyun Modunu Seçin");
		label2.setSize(250, 50);
		label2.setLocation(300, 280);
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("Calibri", Font.BOLD, 25));
		label3.setLocation(350, 170);
		label3.setSize(100, 100);
		label4.setText("5 Adet Nesne Seçin");
		label4.setForeground(Color.WHITE);
		label4.setFont(new Font("Calibri", Font.BOLD, 25));
		label4.setLocation(316, 79);
		label4.setSize(250, 100);
		label5.setSize(400, 63);
		label5.setLocation(245, 145);
		label5.setForeground(Color.WHITE);
		label5.setFont(new Font("Calibri", Font.BOLD, 15));

		// Oyun başlatma butonu özellikleri tanımlannıyor
		btnStart.setText("Oyunu Başlat");
		btnStart.setBorder(new LineBorder(Color.BLACK));
		btnStart.setLocation(325, 466);
		btnStart.setSize(150, 50);
		btnStart.setBackground(new Color(35,35,35));
		btnStart.setForeground(Color.WHITE);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm1.setVisible(false);
				initFrm2(objects, nameTXT.getText());
				logger.info("Oyun Başlatıldı");
			}
		});
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				if (btnStart.isEnabled()) {
					btnStart.setBackground(Color.BLACK);
				}
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				if(btnStart.isEnabled())
					btnStart.setBackground(Color.RED);
			}
		});
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Calibri", Font.BOLD, 25));
		frm1.setTitle("Taş Kağıt Makas");
		frm1.setSize(800, 600);
		frm1.setLocation(350, 100);
		frm1.setIconImage(icon.getImage());
		frm1.getContentPane().setLayout(null);
		frm1.getContentPane().add(lblName);
		frm1.getContentPane().add(nameTXT);
		frm1.getContentPane().add(label1);
		frm1.getContentPane().add(label2);
		frm1.getContentPane().add(label3);
		frm1.getContentPane().add(label4);
		frm1.getContentPane().add(label5);
		frm1.getContentPane().add(btnMod1);
		frm1.getContentPane().add(btnMod2);
		frm1.getContentPane().add(btnObj1);
		frm1.getContentPane().add(btnObj2);
		frm1.getContentPane().add(btnObj3);
		frm1.getContentPane().add(btnStart);

		btnObj1.setVisible(false);
		btnObj2.setVisible(false);
		btnObj3.setVisible(false);
		btnStart.setVisible(false);
		btnStart.setEnabled(false);
		label4.setVisible(false);
		label5.setVisible(false);

		frm1.getContentPane().setBackground(Color.DARK_GRAY);;
		frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm1.setResizable(false);
		frm1.setVisible(true);
	}

	static int enableSayac = 0, pcSayac = 0;

	public static void initFrm2(Nesne[] objects, String playerName) {
		ArrayList <JLabel> lblList = new ArrayList<>();
		JFrame frm2 = new JFrame();
		ImageIcon icon = new ImageIcon(
				"C:\\Users\\ASUS\\Desktop\\Prolab2\\tasKagitMakas\\images\\rock-paper-scissors.png");
		JLabel label1 = new JLabel();
		lblList.add(label1);
		JLabel label2 = new JLabel();
		lblList.add(label2);
		
		JLabel lblWon = new JLabel();
	    lblWon.setFont(new Font("Calibri",Font.BOLD,35));
		lblWon.setBounds(250, 260, 300, 80);
		lblWon.setForeground(Color.WHITE);
		lblWon.setVisible(false);

		JLabel lblSkor1 = new JLabel();
		lblSkor1.setBounds(250, 350, 200, 50);
	    lblSkor1.setForeground(Color.WHITE);
	    lblSkor1.setFont(new Font("Calibri",Font.BOLD,20));
		lblSkor1.setVisible(false);

		JLabel lblSkor2 = new JLabel();
		lblSkor2.setBounds(250, 410, 200, 50);
	    lblSkor2.setForeground(Color.WHITE);
	    lblSkor2.setFont(new Font("Calibri",Font.BOLD,20));
		lblSkor2.setVisible(false);

		JLabel lbl1 = new JLabel();
		lbl1.setForeground(Color.WHITE);
		lbl1.setFont(new Font("Calibri", Font.BOLD, 13));
		lbl1.setSize(153, 52);
	    lbl1.setLocation(35, 456);
		lbl1.setText("Dayanıklılık: " + Oyuncu1.nesneList.get(0).getDayaniklilik());
		lblList.add(lbl1);

		JLabel lbl2 = new JLabel();
		lbl2.setForeground(Color.WHITE);
		lbl2.setFont(new Font("Calibri", Font.BOLD, 13));
		lbl2.setSize(153, 52);
	    lbl2.setLocation(188, 456);
		lbl2.setText("Dayanıklılık: " + Oyuncu1.nesneList.get(1).getDayaniklilik());
		lblList.add(lbl2);

		JLabel lbl3 = new JLabel();
		lbl3.setFont(new Font("Calibri", Font.BOLD, 13));
		lbl3.setForeground(Color.WHITE);
		lbl3.setSize(153, 52);
	    lbl3.setLocation(341, 456);
		lbl3.setText("Dayanıklılık: " + Oyuncu1.nesneList.get(2).getDayaniklilik());
		lblList.add(lbl3);

		JLabel lbl4 = new JLabel();
		lbl4.setFont(new Font("Calibri", Font.BOLD, 13));
		lbl4.setForeground(Color.WHITE);
		lbl4.setSize(143, 52);
	    lbl4.setLocation(494, 456);
		lbl4.setText("Dayanıklılık: " + Oyuncu1.nesneList.get(3).getDayaniklilik());
		lblList.add(lbl4);

		JLabel lbl5 = new JLabel();
		lbl5.setFont(new Font("Calibri", Font.BOLD, 13));
		lbl5.setForeground(Color.WHITE);
		lbl5.setSize(120, 52);
	    lbl5.setLocation(647, 456);
		lbl5.setText("Dayanıklılık: " + Oyuncu1.nesneList.get(4).getDayaniklilik());
		lblList.add(lbl5);

		JLabel lbl6 = new JLabel();
		lbl6.setFont(new Font("Calibri", Font.BOLD, 13));
		lbl6.setForeground(Color.WHITE);
		lbl6.setSize(153, 68);
	    lbl6.setLocation(35, 501);
		lbl6.setText("Seviye Puanı: " + Oyuncu1.nesneList.get(0).getSeviyePuani());
		lblList.add(lbl6);

		JLabel lbl7 = new JLabel();
		lbl7.setFont(new Font("Calibri", Font.BOLD, 13));
		lbl7.setForeground(Color.WHITE);
		lbl7.setSize(153, 68);
	    lbl7.setLocation(188, 501);
		lbl7.setText("Seviye Puanı: " + Oyuncu1.nesneList.get(1).getSeviyePuani());
		lblList.add(lbl7);

		JLabel lbl8 = new JLabel();
		lbl8.setFont(new Font("Calibri", Font.BOLD, 13));
		lbl8.setForeground(Color.WHITE);
		lbl8.setSize(153, 68);
	    lbl8.setLocation(341, 501);
		lbl8.setText("Seviye Puanı: " + Oyuncu1.nesneList.get(2).getSeviyePuani());
		lblList.add(lbl8);

		JLabel lbl9 = new JLabel();
		lbl9.setFont(new Font("Calibri", Font.BOLD, 13));
		lbl9.setForeground(Color.WHITE);
		lbl9.setSize(143, 68);
	    lbl9.setLocation(494, 501);
		lbl9.setText("Seviye Puanı: " + Oyuncu1.nesneList.get(3).getSeviyePuani());
		lblList.add(lbl9);

		JLabel lbl10 = new JLabel();
		lbl10.setFont(new Font("Calibri", Font.BOLD, 13));
		lbl10.setForeground(Color.WHITE);
		lbl10.setSize(139, 68);
	    lbl10.setLocation(647, 501);
		lbl10.setText("Seviye Puanı: " + Oyuncu1.nesneList.get(4).getSeviyePuani());
		lblList.add(lbl10);

		JLabel lblVs= new JLabel();
		lblVs.setForeground(Color.WHITE);
		lblVs.setText("VS");
		lblVs.setFont(new Font("Calibri",Font.BOLD,25));
		lblVs.setBounds(380,150,40,52);
		lblList.add(lblVs);

		JLabel lblHamle= new JLabel();
		lblHamle.setSize(139, 60);
	    lblHamle.setLocation(647, 10);
		lblHamle.setForeground(Color.WHITE);
		lblHamle.setFont(new Font("Calibri",Font.BOLD,15));
		lblHamle.setText("Kalan Hamle: " + (maxHamle - hamle));
		lblList.add(lblHamle);

		JLabel lblvs1= new JLabel();
		lblvs1.setForeground(Color.WHITE);
		lblvs1.setFont(new Font("Calibri",Font.BOLD,20));
		lblvs1.setBounds(260,149,100,52);
		lblList.add(lblvs1);

		JLabel lblvs2= new JLabel();
		lblvs2.setForeground(Color.WHITE);;
		lblvs2.setFont(new Font("Calibri",Font.BOLD,20));
		lblvs2.setBounds(480,149,100,52);
		lblList.add(lblvs2);

		JLabel lblKalanPc = new JLabel();
		lblKalanPc.setForeground(Color.WHITE);
		lblKalanPc.setFont(new Font("Calibri",Font.BOLD,18));
		lblKalanPc.setBounds(29,10,139,60);
		lblKalanPc.setText("Kalan Nesne: 5");
		lblList.add(lblKalanPc);

		JButton btn1Oyuncu1 = new JButton();
		JButton btn2Oyuncu1 = new JButton();
		JButton btn3Oyuncu1 = new JButton();
		JButton btn4Oyuncu1 = new JButton();
		JButton btn5Oyuncu1 = new JButton();
		ArrayList<JButton> buttonList= new ArrayList<>(
			Arrays.asList(btn1Oyuncu1,btn2Oyuncu1,btn3Oyuncu1,btn4Oyuncu1,btn5Oyuncu1));
		ArrayList<JButton> btnList = new ArrayList<>(
			Arrays.asList(btn1Oyuncu1,btn2Oyuncu1,btn3Oyuncu1,btn4Oyuncu1,btn5Oyuncu1));
		btn1Oyuncu1.setBorder(new LineBorder(Color.BLACK));
		btn1Oyuncu1.setBackground(new Color(35,35,35));
		btn1Oyuncu1.setForeground(Color.WHITE);
		btn1Oyuncu1.setFont(new Font("Calibri", Font.BOLD, 20));
		btn1Oyuncu1.setSize(118, 160);
		btn1Oyuncu1.setLocation(35, 286);
		btn1Oyuncu1.setText(Oyuncu1.nesneList.get(0).getNesneIsım());
		btn1Oyuncu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1Oyuncu1.setEnabled(false);
				Nesne userNesne1= Oyuncu1.nesneSec(0);
				Nesne pcNesne1= Oyuncu2.nesneSec(pcSayac);
				lblvs1.setText(userNesne1.getNesneIsım());
				lblvs2.setText(pcNesne1.getNesneIsım());

				if (userNesne1.getClass().getSimpleName().equals(pcNesne1.getClass().getSimpleName())) {
					userNesne1.etkiHesapla(pcNesne1);
					pcNesne1.etkiHesapla(userNesne1);
					pcNesne1.durumGuncelle(userNesne1);
					userNesne1.durumGuncelle(pcNesne1);
					userNesne1.nesnePuaniGoster(lbl1, lbl6);
					logger.info("Karşılaşma berabere");
				} else if ((userNesne1.getClass().getSimpleName().equals("Tas")
						|| userNesne1.getClass().getSimpleName().equals("AgirTas"))
						&& (pcNesne1.getClass().getSimpleName().equals("Makas")
						|| pcNesne1.getClass().getSimpleName().equals("UstaMakas"))) {
					logger.info("Kullanıcı kazandı");
					userNesne1.setSeviyePuani(userNesne1.getSeviyePuani() + 20);
					if(userNesne1.getSeviyePuani()>=30 && userNesne1.getClass().getSimpleName().equals("Tas")){
						Oyuncu1.nesneList.remove(0);
						Oyuncu1.nesneList.add(0, new AgirTas());
						userNesne1= Oyuncu1.nesneList.get(0);
						btn1Oyuncu1.setText(userNesne1.getNesneIsım());
						logger.info("Kullanıcının Taş nesnesi terfi etti");
					}
					userNesne1.etkiHesapla(pcNesne1);
					pcNesne1.etkiHesapla(userNesne1);
					pcNesne1.durumGuncelle(userNesne1);
					userNesne1.durumGuncelle(pcNesne1);
					userNesne1.nesnePuaniGoster(lbl1, lbl6);

				} else if ((userNesne1.getClass().getSimpleName().equals("Tas")
						|| userNesne1.getClass().getSimpleName().equals("AgirTas"))
						&& (pcNesne1.getClass().getSimpleName().equals("Kagit")
						|| pcNesne1.getClass().getSimpleName().equals("OzelKagit"))) {
					logger.info("Bilgisayar kazandı");
					pcNesne1.setSeviyePuani(pcNesne1.getSeviyePuani() + 20);
					if(pcNesne1.getSeviyePuani()>=30 && pcNesne1.getClass().getSimpleName().equals("Kagit")){
						Oyuncu2.nesneList.remove(pcSayac);
						Oyuncu2.nesneList.add(pcSayac, new OzelKagit());
						pcNesne1= Oyuncu2.nesneList.get(pcSayac);
						logger.info("Bilgisayarın Kağıt nesnesi terfi etti");
					}
					userNesne1.etkiHesapla(pcNesne1);
					pcNesne1.etkiHesapla(userNesne1);
					pcNesne1.durumGuncelle(userNesne1);
					userNesne1.durumGuncelle(pcNesne1);
					userNesne1.nesnePuaniGoster(lbl1, lbl6);

				} else if ((userNesne1.getClass().getSimpleName().equals("Kagit"))
						|| userNesne1.getClass().getSimpleName().equals("OzelKagit")
						&& (pcNesne1.getClass().getSimpleName().equals("Tas")
						|| pcNesne1.getClass().getSimpleName().equals("AgirTas"))) {
					logger.info("Kullanıcı kazandı");
					userNesne1.setSeviyePuani(userNesne1.getSeviyePuani() + 20);
					if(userNesne1.getSeviyePuani()>=30 && userNesne1.getClass().getSimpleName().equals("Kagit")){
						Oyuncu1.nesneList.remove(0);
						Oyuncu1.nesneList.add(0, new OzelKagit());
						userNesne1= Oyuncu1.nesneList.get(0);
						btn1Oyuncu1.setText(userNesne1.getNesneIsım());
						logger.info("Kullanıcının Kağıt nesnesi terfi etti");
					}
					userNesne1.etkiHesapla(pcNesne1);
					pcNesne1.etkiHesapla(userNesne1);
					pcNesne1.durumGuncelle(userNesne1);
					userNesne1.durumGuncelle(pcNesne1);
					userNesne1.nesnePuaniGoster(lbl1, lbl6);

				} else if (userNesne1.getClass().getSimpleName().equals("Kagit")
						|| userNesne1.getClass().getSimpleName().equals("OzelKagit")
						&& (pcNesne1.getClass().getSimpleName().equals("Makas")
						|| pcNesne1.getClass().getSimpleName().equals("UstaMakas"))) {
					logger.info("Bilgisayar kazandı");
					pcNesne1.setSeviyePuani(pcNesne1.getSeviyePuani() + 20);
					if(pcNesne1.getSeviyePuani()>=30 && pcNesne1.getClass().getSimpleName().equals("Makas")){
						Oyuncu2.nesneList.remove(pcSayac);
						Oyuncu2.nesneList.add(pcSayac, new UstaMakas());
						pcNesne1= Oyuncu2.nesneList.get(pcSayac);
						logger.info("Bilgisayarın Makas nesnesi terfi etti");
					}
					userNesne1.etkiHesapla(pcNesne1);
					pcNesne1.etkiHesapla(userNesne1);
					pcNesne1.durumGuncelle(userNesne1);
					userNesne1.durumGuncelle(pcNesne1);
					userNesne1.nesnePuaniGoster(lbl1, lbl6);

				} else if ((userNesne1.getNesneIsım().equals("Makas")
						|| userNesne1.getClass().getSimpleName().equals("UstaMakas"))
						&& (pcNesne1.getClass().getSimpleName().equals("Kagit"))
						|| pcNesne1.getClass().getSimpleName().equals("OzelKagit")) {
					logger.info("Kullanıcı kazandı");
					userNesne1.setSeviyePuani(userNesne1.getSeviyePuani() + 20);
					if(userNesne1.getSeviyePuani()>=30 && userNesne1.getClass().getSimpleName().equals("Makas")){
						Oyuncu1.nesneList.remove(0);
						Oyuncu1.nesneList.add(0, new UstaMakas());
						userNesne1= Oyuncu1.nesneList.get(0);
						btn1Oyuncu1.setText(userNesne1.getNesneIsım());
						logger.info("Kullanıcının Makas nesnesi terfi etti");
					}
					userNesne1.etkiHesapla(pcNesne1);
					pcNesne1.etkiHesapla(userNesne1);
					pcNesne1.durumGuncelle(userNesne1);
					userNesne1.durumGuncelle(pcNesne1);
					userNesne1.nesnePuaniGoster(lbl1, lbl6);

				} else if ((userNesne1.getClass().getSimpleName().equals("Makas")
						|| userNesne1.getClass().getSimpleName().equals("UstaMakas"))
						&& (pcNesne1.getClass().getSimpleName().equals("Tas")
						|| pcNesne1.getClass().getSimpleName().equals("AgirTas"))) {
					logger.info("Bilgisayar kazandı");
					pcNesne1.setSeviyePuani(pcNesne1.getSeviyePuani() + 20);
					if(pcNesne1.getSeviyePuani()>=30 && pcNesne1.getClass().getSimpleName().equals("Tas")){
						Oyuncu2.nesneList.remove(pcSayac);
						Oyuncu2.nesneList.add(pcSayac, new AgirTas());
						pcNesne1= Oyuncu2.nesneList.get(pcSayac);
						logger.info("Bilgisayarın Taş nesnesi terfi etti");
					}
					userNesne1.etkiHesapla(pcNesne1);
					pcNesne1.etkiHesapla(userNesne1);
					pcNesne1.durumGuncelle(userNesne1);
					userNesne1.durumGuncelle(pcNesne1);
					userNesne1.nesnePuaniGoster(lbl1, lbl6);
				}
				if(userNesne1.getDayaniklilik()<=0){
					userNesne1.setDayaniklilik(0);
					userNesne1.nesnePuaniGoster(lbl1, lbl6);
					buttonList.remove(btn1Oyuncu1);
					logger.info("Kullanıcının " + userNesne1.getNesneIsım() + " nesnesi elendi");
				}
				if(pcNesne1.getDayaniklilik() <= 0){
					pcNesne1.setDayaniklilik(0);
					Oyuncu2.nesneList.remove(pcSayac);
					lblKalanPc.setText("Kalan Nesne: " + Oyuncu2.nesneList.size());
					logger.info("Bilgisayarın " + pcNesne1.getNesneIsım() + " nesnesi elendi");
				}else{
					pcSayac++;
				}
				if(buttonList.size() == 0 || Oyuncu2.nesneList.size() == 0){
					if(buttonList.size() == 0)
						logger.info("Kullanıcının elindeki nesneler tükendi");
					else
						logger.info("Bilgisayarın elindeki nesneler tükendi");
						for(int i=0; i<Oyuncu1.nesneList.size(); i++){
						Oyuncu1.setSkor(Oyuncu1.getSkor() + Oyuncu1.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<Oyuncu2.nesneList.size(); i++){
						Oyuncu2.setSkor(Oyuncu2.getSkor() + Oyuncu2.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<btnList.size(); i++){
						btnList.get(i).setVisible(false);
					}
					for(JLabel lbl : lblList){
						lbl.setVisible(false);
					}
					if(Oyuncu1.getSkor() > Oyuncu2.getSkor()){
						logger.info("Oyunu " + label1.getText() + " kazandı");
						lblWon.setText(label1.getText() + " Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else if(Oyuncu2.getSkor() > Oyuncu1.getSkor()){
						logger.info("Oyunu Bilgisayar kazandı");
						lblWon.setText("Bilgisayar Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else{
						logger.info("Oyun berabere bitti");
						lblWon.setText("Berabere");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}
				}
				if(pcSayac >= (Oyuncu2.nesneList.size()-1)){
					pcSayac = 0;
					Collections.shuffle(Oyuncu2.nesneList);
				}
				enableSayac++;
				if (enableSayac >= buttonList.size()) {
					enableSayac = 0;
					for(int i=0; i<buttonList.size(); i++){
						buttonList.get(i).setEnabled(true);
					}
				}
				hamle++;
				lblHamle.setText("Kalan Hamle: " + (maxHamle - hamle));
				if (hamle == maxHamle){
					for(int i=0; i<Oyuncu1.nesneList.size(); i++){
						Oyuncu1.setSkor(Oyuncu1.getSkor() + Oyuncu1.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<Oyuncu2.nesneList.size(); i++){
						Oyuncu2.setSkor(Oyuncu2.getSkor() + Oyuncu2.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<btnList.size(); i++){
						btnList.get(i).setVisible(false);
					}
					for(JLabel lbl : lblList){
						lbl.setVisible(false);
					}
					if(Oyuncu1.getSkor() > Oyuncu2.getSkor()){
						logger.info("Oyunu " + label1.getText() + " kazandı");
						lblWon.setText(label1.getText() + " Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else if(Oyuncu2.getSkor() > Oyuncu1.getSkor()){
						logger.info("Oyunu bilgisayar kazandı");
						lblWon.setText("Bilgisayar Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else{
						logger.info("Oyun berabere bitti");
						lblWon.setText("Berabere");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}
				}
			}
		});
		btn1Oyuncu1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				if (btn1Oyuncu1.isEnabled()) {
					btn1Oyuncu1.setBackground(Color.BLACK);
				}
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btn1Oyuncu1.setBackground(new Color(35,35,35));
			}
		});

		btn2Oyuncu1.setBorder(new LineBorder(Color.BLACK));
		btn2Oyuncu1.setBackground(new Color(35,35,35));
		btn2Oyuncu1.setForeground(Color.WHITE);
		btn2Oyuncu1.setSize(120, 160);
	    btn2Oyuncu1.setLocation(188, 286);
		btn2Oyuncu1.setFont(new Font("Calibri",Font.BOLD,20));
		btn2Oyuncu1.setText(Oyuncu1.nesneList.get(1).getNesneIsım());
		btn2Oyuncu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn2Oyuncu1.setEnabled(false);
				Nesne pcNesne2= Oyuncu2.nesneSec(pcSayac);
				Nesne userNesne2= Oyuncu1.nesneSec(1);
				lblvs1.setText(userNesne2.getNesneIsım());
				lblvs2.setText(pcNesne2.getNesneIsım());

				if (userNesne2.getClass().getSimpleName().equals(pcNesne2.getClass().getSimpleName())) {
						logger.info("Karşılaşma Berabere");
						userNesne2.etkiHesapla(pcNesne2);
						pcNesne2.etkiHesapla(userNesne2);
						pcNesne2.durumGuncelle(userNesne2);
						userNesne2.durumGuncelle(pcNesne2);
						userNesne2.nesnePuaniGoster(lbl2, lbl7);

				} else if ((userNesne2.getClass().getSimpleName().equals("Tas")
						|| userNesne2.getClass().getSimpleName().equals("AgirTas"))
						&& (pcNesne2.getClass().getSimpleName().equals("Makas")
						|| pcNesne2.getClass().getSimpleName().equals("UstaMakas"))) {
					logger.info("Kullanıcı kazandı");
					userNesne2.setSeviyePuani(userNesne2.getSeviyePuani() + 20);
					if(userNesne2.getSeviyePuani()>=30 && userNesne2.getClass().getSimpleName().equals("Tas")){
						Oyuncu1.nesneList.remove(1);
						Oyuncu1.nesneList.add(1, new AgirTas());
						userNesne2= Oyuncu1.nesneList.get(1);
						btn2Oyuncu1.setText(userNesne2.getNesneIsım());
						logger.info("Kullanıcının Taş nesnesi terfi etti");
					}
					userNesne2.etkiHesapla(pcNesne2);
					pcNesne2.etkiHesapla(userNesne2);
					pcNesne2.durumGuncelle(userNesne2);
					userNesne2.durumGuncelle(pcNesne2);
					userNesne2.nesnePuaniGoster(lbl2, lbl7);

				} else if ((userNesne2.getClass().getSimpleName().equals("Tas")
						|| userNesne2.getClass().getSimpleName().equals("AgirTas"))
						&& (pcNesne2.getClass().getSimpleName().equals("Kagit")
						|| pcNesne2.getClass().getSimpleName().equals("OzelKagit"))) {
					logger.info("Bilgisayar kazandı");
					pcNesne2.setSeviyePuani(pcNesne2.getSeviyePuani() + 20);
					if(pcNesne2.getSeviyePuani()>=30 && pcNesne2.getClass().getSimpleName().equals("Kagit")){
						Oyuncu2.nesneList.remove(pcSayac);
						Oyuncu2.nesneList.add(pcSayac, new OzelKagit());
						pcNesne2= Oyuncu2.nesneList.get(pcSayac);
						logger.info("Kullanıcının kağıt nesnesi terfi etti");
					}
					userNesne2.etkiHesapla(pcNesne2);
					pcNesne2.etkiHesapla(userNesne2);
					pcNesne2.durumGuncelle(userNesne2);
					userNesne2.durumGuncelle(pcNesne2);
					userNesne2.nesnePuaniGoster(lbl2, lbl7);

				} else if ((userNesne2.getClass().getSimpleName().equals("Kagit")
						|| userNesne2.getClass().getSimpleName().equals("OzelKagit"))
						&& (pcNesne2.getClass().getSimpleName().equals("Tas")
						|| pcNesne2.getClass().getSimpleName().equals("AgirTas"))) {
					logger.info("Kullanıcı kazandı");
					userNesne2.setSeviyePuani(userNesne2.getSeviyePuani() + 20);
					if(userNesne2.getSeviyePuani()>=30 && userNesne2.getClass().getSimpleName().equals("Kagit")){
						Oyuncu1.nesneList.remove(1);
						Oyuncu1.nesneList.add(1, new OzelKagit());
						userNesne2= Oyuncu1.nesneList.get(1);
						btn2Oyuncu1.setText(userNesne2.getNesneIsım());
						logger.info("Kullanıcının kağıt nesnesi terfi etti");
					}
					userNesne2.etkiHesapla(pcNesne2);
					pcNesne2.etkiHesapla(userNesne2);
					pcNesne2.durumGuncelle(userNesne2);
					userNesne2.durumGuncelle(pcNesne2);
					userNesne2.nesnePuaniGoster(lbl2, lbl7);

				} else if ((userNesne2.getClass().getSimpleName().equals("Kagit")
						|| userNesne2.getClass().getSimpleName().equals("OzelKagit"))
						&& (pcNesne2.getClass().getSimpleName().equals("Makas")
						|| pcNesne2.getClass().getSimpleName().equals("UstaMakas"))) {
					logger.info("Bilgisayar kazandı");
					pcNesne2.setSeviyePuani(pcNesne2.getSeviyePuani() + 20);
					if(pcNesne2.getSeviyePuani()>=30 && pcNesne2.getClass().getSimpleName().equals("Makas")){
						Oyuncu2.nesneList.remove(pcSayac);
						Oyuncu2.nesneList.add(pcSayac, new UstaMakas());
						pcNesne2= Oyuncu2.nesneList.get(pcSayac);
						logger.info("Bilgisayarın Makas nesnesi terfi etti");
					}
					userNesne2.etkiHesapla(pcNesne2);
					pcNesne2.etkiHesapla(userNesne2);
					pcNesne2.durumGuncelle(userNesne2);
					userNesne2.durumGuncelle(pcNesne2);
					userNesne2.nesnePuaniGoster(lbl2, lbl7);	

				} else if ((userNesne2.getClass().getSimpleName().equals("Makas")
						|| userNesne2.getClass().getSimpleName().equals("UstaMakas"))
						&& (pcNesne2.getClass().getSimpleName().equals("Kagit")
						|| pcNesne2.getClass().getSimpleName().equals("OzelKagit"))) {
					logger.info("Kullanıcı kazandı");
					userNesne2.setSeviyePuani(userNesne2.getSeviyePuani() + 20);
					if(userNesne2.getSeviyePuani()>=30 && userNesne2.getClass().getSimpleName().equals("Makas")){
						Oyuncu1.nesneList.remove(1);
						Oyuncu1.nesneList.add(1, new UstaMakas());
						userNesne2= Oyuncu1.nesneList.get(1);
						btn2Oyuncu1.setText(userNesne2.getNesneIsım());
						logger.info("Kullanıcının Makas nesnesi terfi etti");
					}
					userNesne2.etkiHesapla(pcNesne2);
					pcNesne2.etkiHesapla(userNesne2);
					pcNesne2.durumGuncelle(userNesne2);
					userNesne2.durumGuncelle(pcNesne2);
					userNesne2.nesnePuaniGoster(lbl2, lbl7);

				} else if ((userNesne2.getClass().getSimpleName().equals("Makas")
						|| userNesne2.getClass().getSimpleName().equals("UstaMakas"))
						&& (pcNesne2.getClass().getSimpleName().equals("Tas")
						|| pcNesne2.getClass().getSimpleName().equals("AgirTas"))) {
					logger.info("Bilgisayar kazandı");
					pcNesne2.setSeviyePuani(pcNesne2.getSeviyePuani() + 20);
					if(pcNesne2.getSeviyePuani()>=30 && pcNesne2.getClass().getSimpleName().equals("Tas")){
						Oyuncu2.nesneList.remove(pcSayac);
						Oyuncu2.nesneList.add(pcSayac, new AgirTas());
						pcNesne2= Oyuncu2.nesneList.get(pcSayac);
						logger.info("Bilgisayarın Taş nesnesi terfi etti");
					}
					userNesne2.etkiHesapla(pcNesne2);
					pcNesne2.etkiHesapla(userNesne2);
					pcNesne2.durumGuncelle(userNesne2);
					userNesne2.durumGuncelle(pcNesne2);
					userNesne2.nesnePuaniGoster(lbl2, lbl7);

				}
				if(userNesne2.getDayaniklilik()<=0){
					userNesne2.setDayaniklilik(0);
					userNesne2.nesnePuaniGoster(lbl2, lbl7);
					buttonList.remove(btn2Oyuncu1);
					logger.info("Kullanıcının " + userNesne2.getNesneIsım() + " nesnesi elendi");
				}
				if(pcNesne2.getDayaniklilik() <=0){
					pcNesne2.setDayaniklilik(0);
					Oyuncu2.nesneList.remove(pcSayac);
					lblKalanPc.setText("Kalan Nesne: " + Oyuncu2.nesneList.size());
					logger.info("Bilgisayarın " + pcNesne2.getNesneIsım() + " nesnesi elendi");
				}else{
					pcSayac++;
				}
				if(buttonList.size() == 0 || Oyuncu2.nesneList.size() == 0){
					if(buttonList.size() == 0)
						logger.info("Kullanıcının elindeki nesneler tükendi");
					else 
						logger.info("Bilgisayarın elindeki nesneler tükendi");
					for(int i=0; i<Oyuncu1.nesneList.size(); i++){
						Oyuncu1.setSkor(Oyuncu1.getSkor() + Oyuncu1.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<Oyuncu2.nesneList.size(); i++){
						Oyuncu2.setSkor(Oyuncu2.getSkor() + Oyuncu2.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<btnList.size(); i++){
						btnList.get(i).setVisible(false);
					}
					for(JLabel lbl : lblList){
						lbl.setVisible(false);
					}
					if(Oyuncu1.getSkor() > Oyuncu2.getSkor()){
						logger.info("Oyunu " + label1.getText() + " kazandı");
						lblWon.setText(label1.getText() + " Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else if(Oyuncu2.getSkor() > Oyuncu1.getSkor()){
						logger.info("Bilgisayar kazandı");
						lblWon.setText("Bilgisayar Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else{
						logger.info("Oyun berabere bitti");
						lblWon.setText("Berabere");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}
				}
				if(pcSayac >= (Oyuncu2.nesneList.size() - 1)){
					pcSayac = 0;
					Collections.shuffle(Oyuncu2.nesneList);
				}
				enableSayac++;
				if (enableSayac >= buttonList.size()) {
					enableSayac = 0;
					for(int i=0; i<buttonList.size(); i++){
						buttonList.get(i).setEnabled(true);
					}
				}
				hamle++;
				lblHamle.setText("Kalan Hamle: " + (maxHamle - hamle));
				if (hamle == maxHamle) {
					for(int i=0; i<Oyuncu1.nesneList.size(); i++){
						Oyuncu1.setSkor(Oyuncu1.getSkor() + Oyuncu1.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<Oyuncu2.nesneList.size(); i++){
						Oyuncu2.setSkor(Oyuncu2.getSkor() + Oyuncu2.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<btnList.size(); i++){
						btnList.get(i).setVisible(false);
					}
					for(JLabel lbl : lblList){
						lbl.setVisible(false);
					}
					if(Oyuncu1.getSkor() > Oyuncu2.getSkor()){
						logger.info("Oyunu " + label1.getText() + " kazandı");
						lblWon.setText(label1.getText() + " Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else if(Oyuncu2.getSkor() > Oyuncu1.getSkor()){
						logger.info("Oyunu bilgisayar kazandı");
						lblWon.setText("Bilgisayar Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else{
						logger.info("Oyun berabere bitti");
						lblWon.setText("Berabere");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}
				}
			}
		});
		btn2Oyuncu1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				if (btn2Oyuncu1.isEnabled()) {
					btn2Oyuncu1.setBackground(Color.BLACK);
				}
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btn2Oyuncu1.setBackground(new Color(35,35,35));
			}
		});

		btn3Oyuncu1.setBorder(new LineBorder(Color.BLACK));
		btn3Oyuncu1.setBackground(new Color(35,35,35));
		btn3Oyuncu1.setForeground(Color.WHITE);
		btn3Oyuncu1.setFont(new Font("Calibri", Font.BOLD, 20));
		btn3Oyuncu1.setSize(120, 160);
		btn3Oyuncu1.setLocation(341, 286);
		btn3Oyuncu1.setText(Oyuncu1.nesneList.get(2).getNesneIsım());
		btn3Oyuncu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn3Oyuncu1.setEnabled(false);
				Nesne pcNesne3= Oyuncu2.nesneSec(pcSayac);
				Nesne userNesne3= Oyuncu1.nesneSec(2);
				lblvs1.setText(userNesne3.getNesneIsım());
				lblvs2.setText(pcNesne3.getNesneIsım());

				if (userNesne3.getClass().getSimpleName().equals(pcNesne3.getClass().getSimpleName())) {
						logger.info("Karşılaşma Berabere");
						userNesne3.etkiHesapla(pcNesne3);
						pcNesne3.etkiHesapla(userNesne3);
						pcNesne3.durumGuncelle(userNesne3);
						userNesne3.durumGuncelle(pcNesne3);
						userNesne3.nesnePuaniGoster(lbl3, lbl8);

				} else if ((userNesne3.getClass().getSimpleName().equals("Tas")
						|| userNesne3.getClass().getSimpleName().equals("AgirTas"))
						&& (pcNesne3.getClass().getSimpleName().equals("Makas")
						|| pcNesne3.getClass().getSimpleName().equals("UstaMakas"))) {
					logger.info("Kullanıcı kazandı");
					userNesne3.setSeviyePuani(userNesne3.getSeviyePuani() + 20);
					if(userNesne3.getSeviyePuani()>=30 && userNesne3.getClass().getSimpleName().equals("Tas")){
						Oyuncu1.nesneList.remove(2);
						Oyuncu1.nesneList.add(2, new AgirTas());
						userNesne3= Oyuncu1.nesneList.get(2);
						btn3Oyuncu1.setText(userNesne3.getNesneIsım());
						logger.info("Kullanıcının taş nesnesi terfi etti");
					}
					userNesne3.etkiHesapla(pcNesne3);
					pcNesne3.etkiHesapla(userNesne3);
					pcNesne3.durumGuncelle(userNesne3);
					userNesne3.durumGuncelle(pcNesne3);
					userNesne3.nesnePuaniGoster(lbl3, lbl8);
				} else if ((userNesne3.getClass().getSimpleName().equals("Tas")
						|| userNesne3.getClass().getSimpleName().equals("AgirTas"))
						&& (pcNesne3.getClass().getSimpleName().equals("Kagit")
						|| pcNesne3.getClass().getSimpleName().equals("OzelKagit"))) {
					logger.info("Bilgisayar kazandı");
					pcNesne3.setSeviyePuani(pcNesne3.getSeviyePuani() + 20);
					if(pcNesne3.getSeviyePuani()>=30 && pcNesne3.getClass().getSimpleName().equals("Kagit")){
						Oyuncu2.nesneList.remove(pcSayac);
						Oyuncu2.nesneList.add(pcSayac, new OzelKagit());
						pcNesne3= Oyuncu2.nesneList.get(pcSayac);
						logger.info("Bilgisayarın Kağıt nesnesi terfi etti");
					}
					userNesne3.etkiHesapla(pcNesne3);
					pcNesne3.etkiHesapla(userNesne3);
					pcNesne3.durumGuncelle(userNesne3);
					userNesne3.durumGuncelle(pcNesne3);
					userNesne3.nesnePuaniGoster(lbl3, lbl8);
				} else if ((userNesne3.getClass().getSimpleName().equals("Kagit")
						|| userNesne3.getClass().getSimpleName().equals("OzelKagit"))
						&& (pcNesne3.getClass().getSimpleName().equals("Tas")
						|| pcNesne3.getClass().getSimpleName().equals("AgirTas"))) {
					logger.info("Kullanıcı kazandı");
					userNesne3.setSeviyePuani(userNesne3.getSeviyePuani() + 20);
					if(userNesne3.getSeviyePuani()>=30 && userNesne3.getClass().getSimpleName().equals("Kagit")){
						Oyuncu1.nesneList.remove(2);
						Oyuncu1.nesneList.add(2, new OzelKagit());
						userNesne3= Oyuncu1.nesneList.get(2);
						btn3Oyuncu1.setText(userNesne3.getNesneIsım());
						logger.info("Kullanıcının Kağıt nesnesi terfi etti");
					}
					userNesne3.etkiHesapla(pcNesne3);
					pcNesne3.etkiHesapla(userNesne3);
					pcNesne3.durumGuncelle(userNesne3);
					userNesne3.durumGuncelle(pcNesne3);
					userNesne3.nesnePuaniGoster(lbl3, lbl8);
				} else if ((userNesne3.getClass().getSimpleName().equals("Kagit")
						|| userNesne3.getClass().getSimpleName().equals("OzelKagit"))
						&& (pcNesne3.getClass().getSimpleName().equals("Makas")
						|| pcNesne3.getClass().getSimpleName().equals("UstaMakas"))) {
					logger.info("Bilgisayar kazandı");
					pcNesne3.setSeviyePuani(pcNesne3.getSeviyePuani() + 20);
					if(pcNesne3.getSeviyePuani()>=30 && pcNesne3.getClass().getSimpleName().equals("Makas")){
						Oyuncu2.nesneList.remove(pcSayac);
						Oyuncu2.nesneList.add(pcSayac, new UstaMakas());
						pcNesne3= Oyuncu2.nesneList.get(pcSayac);
						logger.info("Bilgisayarın Makas nesnesi terfi etti");
					}
					userNesne3.etkiHesapla(pcNesne3);
					pcNesne3.etkiHesapla(userNesne3);
					pcNesne3.durumGuncelle(userNesne3);
					userNesne3.durumGuncelle(pcNesne3);
					userNesne3.nesnePuaniGoster(lbl3, lbl8);
				} else if ((userNesne3.getClass().getSimpleName().equals("Makas")
						|| userNesne3.getClass().getSimpleName().equals("UstaMakas"))
						&& (pcNesne3.getClass().getSimpleName().equals("Kagit")
						|| pcNesne3.getClass().getSimpleName().equals("OzelKagit"))) {
					logger.info("Kullanıcı kazandı");
					userNesne3.setSeviyePuani(userNesne3.getSeviyePuani() + 20);
					if(userNesne3.getSeviyePuani()>=30 && userNesne3.getClass().getSimpleName().equals("Makas")){
						Oyuncu1.nesneList.remove(2);
						Oyuncu1.nesneList.add(2, new UstaMakas());
						userNesne3= Oyuncu1.nesneList.get(2);
						btn3Oyuncu1.setText(userNesne3.getNesneIsım());
						logger.info("Kullanıcının Makas nesnesi terfi etti");
					}
					userNesne3.etkiHesapla(pcNesne3);
					pcNesne3.etkiHesapla(userNesne3);
					pcNesne3.durumGuncelle(userNesne3);
					userNesne3.durumGuncelle(pcNesne3);
					userNesne3.nesnePuaniGoster(lbl3, lbl8);
				} else if ((userNesne3.getClass().getSimpleName().equals("Makas")
						|| userNesne3.getClass().getSimpleName().equals("UstaMakas"))
						&& (pcNesne3.getClass().getSimpleName().equals("Tas")
						|| pcNesne3.getClass().getSimpleName().equals("AgirTas"))) {
					logger.info("Bilgisayar kazandı");
					pcNesne3.setSeviyePuani(pcNesne3.getSeviyePuani() + 20);
					if(pcNesne3.getSeviyePuani()>=30 && pcNesne3.getClass().getSimpleName().equals("Tas")){
						Oyuncu2.nesneList.remove(pcSayac);
						Oyuncu2.nesneList.add(pcSayac, new AgirTas());
						pcNesne3= Oyuncu2.nesneList.get(pcSayac);
						logger.info("Bilgisayarın Taş nesnesi terfi etti");
					}
					userNesne3.etkiHesapla(pcNesne3);
					pcNesne3.etkiHesapla(userNesne3);
					pcNesne3.durumGuncelle(userNesne3);
					userNesne3.durumGuncelle(pcNesne3);
					userNesne3.nesnePuaniGoster(lbl3, lbl8);
				}
				if(userNesne3.getDayaniklilik()<=0){
					userNesne3.setDayaniklilik(0);
					userNesne3.nesnePuaniGoster(lbl3, lbl8);
					buttonList.remove(btn3Oyuncu1);
					logger.info("Kullanıcının" + btn3Oyuncu1.getText() + " nesnesi elendi");
				}
				if(pcNesne3.getDayaniklilik() <= 0){
					pcNesne3.setDayaniklilik(0);
					Oyuncu2.nesneList.remove(pcSayac);
					lblKalanPc.setText("Kalan Nesne: " + Oyuncu2.nesneList.size());
					logger.info("Bilgisayarın " + pcNesne3.getNesneIsım() + " nesnesi elendi");
				}
				else{
					pcSayac++;
				}
				if(buttonList.size() == 0 || Oyuncu2.nesneList.size() == 0){
					if(buttonList.size() == 0)
						logger.info("Kullanıcının nesneleri tükendi");
					else
						logger.info("Bilgisayarın nesneleri tükendi");
					for(int i=0; i<Oyuncu1.nesneList.size(); i++){
						Oyuncu1.setSkor(Oyuncu1.getSkor() + Oyuncu1.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<Oyuncu2.nesneList.size(); i++){
						Oyuncu2.setSkor(Oyuncu2.getSkor() + Oyuncu2.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<btnList.size(); i++){
						btnList.get(i).setVisible(false);
					}
					for(JLabel lbl : lblList){
						lbl.setVisible(false);
					}
					if(Oyuncu1.getSkor() > Oyuncu2.getSkor()){
						logger.info(label1.getText() + " kazandı");
						lblWon.setText(label1.getText() + " Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else if(Oyuncu2.getSkor() > Oyuncu1.getSkor()){
						logger.info("Bilgisayar kazandı");
						lblWon.setText("Bilgisayar Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else{
						logger.info("Oyun berabere bitti");
						lblWon.setText("Berabere");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}
				}
				if(pcSayac >= (Oyuncu2.nesneList.size() - 1)){
					pcSayac = 0;
					Collections.shuffle(Oyuncu2.nesneList);
				}
				enableSayac++;
				if (enableSayac >= buttonList.size()) {
					enableSayac = 0;
					for(int i=0; i<buttonList.size(); i++){
						buttonList.get(i).setEnabled(true);
					}
				}
				hamle++;
				lblHamle.setText("Kalan Hamle: " + (maxHamle - hamle));
				if (hamle == maxHamle) {
					for(int i=0; i<Oyuncu1.nesneList.size(); i++){
						Oyuncu1.setSkor(Oyuncu1.getSkor() + Oyuncu1.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<Oyuncu2.nesneList.size(); i++){
						Oyuncu2.setSkor(Oyuncu2.getSkor() + Oyuncu2.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<btnList.size(); i++){
						btnList.get(i).setVisible(false);
					}
					for(JLabel lbl : lblList){
						lbl.setVisible(false);
					}
					if(Oyuncu1.getSkor() > Oyuncu2.getSkor()){
						logger.info(label1.getText() + " kazandı");
						lblWon.setText(label1.getText() + " Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else if(Oyuncu2.getSkor() > Oyuncu1.getSkor()){
						logger.info("Bilgisayar kazandı");
						lblWon.setText("Bilgisayar Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else{
						logger.info("Oyun berabere bitti");
						lblWon.setText("Berabere");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}
				}
			}
		});
		btn3Oyuncu1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				if (btn3Oyuncu1.isEnabled()) {
					btn3Oyuncu1.setBackground(Color.BLACK);
				}
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btn3Oyuncu1.setBackground(new Color(35,35,35));
			}
		});

		btn4Oyuncu1.setBorder(new LineBorder(Color.BLACK));
		btn4Oyuncu1.setBackground(new Color(35,35,35));
		btn4Oyuncu1.setForeground(Color.WHITE);
		btn4Oyuncu1.setFont(new Font("Calibri", Font.BOLD, 20));
		btn4Oyuncu1.setSize(120, 160);
		btn4Oyuncu1.setLocation(494, 286);
		btn4Oyuncu1.setText(Oyuncu1.nesneList.get(3).getNesneIsım());
		btn4Oyuncu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn4Oyuncu1.setEnabled(false);
				Nesne userNesne4= Oyuncu1.nesneSec(3);
				Nesne pcNesne4= Oyuncu2.nesneSec(pcSayac);
				lblvs1.setText(userNesne4.getNesneIsım());
				lblvs2.setText(pcNesne4.getNesneIsım());

				if (userNesne4.getClass().getSimpleName().equals(pcNesne4.getClass().getSimpleName())) {
						userNesne4.etkiHesapla(pcNesne4);
						pcNesne4.etkiHesapla(userNesne4);
						pcNesne4.durumGuncelle(userNesne4);
						userNesne4.durumGuncelle(pcNesne4);
						userNesne4.nesnePuaniGoster(lbl4, lbl9);
						logger.info("Karşılaşma Berabere");
				} else if ((userNesne4.getClass().getSimpleName().equals("Tas")
						|| userNesne4.getClass().getSimpleName().equals("AgirTas"))
						&& (pcNesne4.getClass().getSimpleName().equals("Makas")
						|| pcNesne4.getClass().getSimpleName().equals("UstaMakas"))) {
					logger.info("Kullanıcı kazandı");
					userNesne4.setSeviyePuani(userNesne4.getSeviyePuani() + 20);
					if(userNesne4.getSeviyePuani()>=30 && userNesne4.getClass().getSimpleName().equals("Tas")){
						Oyuncu1.nesneList.remove(3);
						Oyuncu1.nesneList.add(3, new AgirTas());
						userNesne4= Oyuncu1.nesneList.get(3);
						btn4Oyuncu1.setText(userNesne4.getNesneIsım());
						logger.info("Kullanıcının Taş nesnesi terfi etti");
					}
					userNesne4.etkiHesapla(pcNesne4);
					pcNesne4.etkiHesapla(userNesne4);
					pcNesne4.durumGuncelle(userNesne4);
					userNesne4.durumGuncelle(pcNesne4);
					userNesne4.nesnePuaniGoster(lbl4, lbl9);
				} else if ((userNesne4.getClass().getSimpleName().equals("Tas")
						|| userNesne4.getClass().getSimpleName().equals("AgirTas"))
						&& (pcNesne4.getClass().getSimpleName().equals("Kagit")
						|| pcNesne4.getClass().getSimpleName().equals("OzelKagit"))) {
					logger.info("Bilgisayar kazandı");
					pcNesne4.setSeviyePuani(pcNesne4.getSeviyePuani() + 20);
					if(pcNesne4.getSeviyePuani()>=30 && pcNesne4.getClass().getSimpleName().equals("Kagit")){
						Oyuncu2.nesneList.remove(pcSayac);
						Oyuncu2.nesneList.add(pcSayac, new OzelKagit());
						pcNesne4= Oyuncu2.nesneList.get(pcSayac);
						logger.info("Bilgisayarın kağıt nesnesi terfi etti");
					}
					userNesne4.etkiHesapla(pcNesne4);
					pcNesne4.etkiHesapla(userNesne4);
					pcNesne4.durumGuncelle(userNesne4);
					userNesne4.durumGuncelle(pcNesne4);
					userNesne4.nesnePuaniGoster(lbl4, lbl9);
				} else if ((userNesne4.getClass().getSimpleName().equals("Kagit")
						|| userNesne4.getClass().getSimpleName().equals("OzelKagit"))
						&& (pcNesne4.getClass().getSimpleName().equals("Tas")
						|| pcNesne4.getClass().getSimpleName().equals("AgirTas"))) {
					logger.info("Kullanıcı kazandı");
					userNesne4.setSeviyePuani(userNesne4.getSeviyePuani() + 20);
					if(userNesne4.getSeviyePuani()>=30 && userNesne4.getClass().getSimpleName().equals("Kagit")){
						Oyuncu1.nesneList.remove(3);
						Oyuncu1.nesneList.add(3, new OzelKagit());
						userNesne4= Oyuncu1.nesneList.get(3);
						btn4Oyuncu1.setText(userNesne4.getNesneIsım());
						logger.info("Kullanıcının Kağıt nesnesi terfi etti");
					}
					userNesne4.etkiHesapla(pcNesne4);
					pcNesne4.etkiHesapla(userNesne4);
					pcNesne4.durumGuncelle(userNesne4);
					userNesne4.durumGuncelle(pcNesne4);
					userNesne4.nesnePuaniGoster(lbl4, lbl9);
				} else if ((userNesne4.getClass().getSimpleName().equals("Kagit")
						|| userNesne4.getClass().getSimpleName().equals("OzelKagit"))
						&& (pcNesne4.getClass().getSimpleName().equals("Makas")
						|| pcNesne4.getClass().getSimpleName().equals("UstaMakas"))) {
					logger.info("Bilgisayar kazandı");
					pcNesne4.setSeviyePuani(pcNesne4.getSeviyePuani() + 20);
					if(pcNesne4.getSeviyePuani()>=30 && pcNesne4.getClass().getSimpleName().equals("Makas")){
						Oyuncu2.nesneList.remove(pcSayac);
						Oyuncu2.nesneList.add(pcSayac, new UstaMakas());
						pcNesne4= Oyuncu2.nesneList.get(pcSayac);
						logger.info("Bilgisayarın Makas nesnesi terfi etti");
					}
					userNesne4.etkiHesapla(pcNesne4);
					pcNesne4.etkiHesapla(userNesne4);
					pcNesne4.durumGuncelle(userNesne4);
					userNesne4.durumGuncelle(pcNesne4);
					userNesne4.nesnePuaniGoster(lbl4, lbl9);
				} else if ((userNesne4.getClass().getSimpleName().equals("Makas")
						|| userNesne4.getClass().getSimpleName().equals("UstaMakas"))
						&& (pcNesne4.getClass().getSimpleName().equals("Kagit")
						|| pcNesne4.getClass().getSimpleName().equals("OzelKagit"))) {
					logger.info("Kullanıcı kazandı");
					userNesne4.setSeviyePuani(userNesne4.getSeviyePuani() + 20);
					if(userNesne4.getSeviyePuani()>=30 && userNesne4.getClass().getSimpleName().equals("Makas")){
						Oyuncu1.nesneList.remove(3);
						Oyuncu1.nesneList.add(3, new UstaMakas());
						userNesne4= Oyuncu1.nesneList.get(3);
						btn4Oyuncu1.setText(userNesne4.getNesneIsım());
						logger.info("Kullanıcının Makas nesnesi terfi etti");
					}
					userNesne4.etkiHesapla(pcNesne4);
					pcNesne4.etkiHesapla(userNesne4);
					pcNesne4.durumGuncelle(userNesne4);
					userNesne4.durumGuncelle(pcNesne4);
					userNesne4.nesnePuaniGoster(lbl4, lbl9);
				} else if ((userNesne4.getClass().getSimpleName().equals("Makas")
						|| userNesne4.getClass().getSimpleName().equals("UstaMakas"))
						&& (pcNesne4.getClass().getSimpleName().equals("Tas")
						|| pcNesne4.getClass().getSimpleName().equals("AgirTas"))) {
					logger.info("Bilgisayar kazandı");
					pcNesne4.setSeviyePuani(pcNesne4.getSeviyePuani() + 20);
					if(pcNesne4.getSeviyePuani()>=30 && pcNesne4.getClass().getSimpleName().equals("Tas")){
						Oyuncu2.nesneList.remove(pcSayac);
						Oyuncu2.nesneList.add(pcSayac, new AgirTas());
						pcNesne4= Oyuncu2.nesneList.get(pcSayac);
						logger.info("Bilgisayarın taş nesnesi terfi etti");
					}
					userNesne4.etkiHesapla(pcNesne4);
					pcNesne4.etkiHesapla(userNesne4);
					pcNesne4.durumGuncelle(userNesne4);
					userNesne4.durumGuncelle(pcNesne4);
					userNesne4.nesnePuaniGoster(lbl4, lbl9);
				}
				if(userNesne4.getDayaniklilik() <= 0){
					userNesne4.setDayaniklilik(0);
					userNesne4.nesnePuaniGoster(lbl4, lbl9);
					buttonList.remove(btn4Oyuncu1);
					logger.info("Kullanıcının " + userNesne4.getNesneIsım() + " nesnesi elendi");
				}
				if(pcNesne4.getDayaniklilik() <= 0){
					pcNesne4.setDayaniklilik(0);
					Oyuncu2.nesneList.remove(pcSayac);
					lblKalanPc.setText("Kalan Nesne: " + Oyuncu2.nesneList.size());
					logger.info("Bilgisayarın " + pcNesne4.getNesneIsım() + " nesnesi elendi");
				}else{
					pcSayac++;
				}
				if(buttonList.size() == 0 || Oyuncu2.nesneList.size() == 0){
					if(buttonList.size() == 0)
						logger.info("Kulllanıcının elindeki nesneler tükendi");
					else
						logger.info("Bilgisayarın elindeki nesneler tükendi");
					for(int i=0; i<Oyuncu1.nesneList.size(); i++){
						Oyuncu1.setSkor(Oyuncu1.getSkor() + Oyuncu1.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<Oyuncu2.nesneList.size(); i++){
						Oyuncu2.setSkor(Oyuncu2.getSkor() + Oyuncu2.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<btnList.size(); i++){
						btnList.get(i).setVisible(false);
					}
					for(JLabel lbl : lblList){
						lbl.setVisible(false);
					}
					if(Oyuncu1.getSkor() > Oyuncu2.getSkor()){
						logger.info(label1.getText() + " kazandı");
						lblWon.setText(label1.getText() + " Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else if(Oyuncu2.getSkor() > Oyuncu1.getSkor()){
						logger.info("Bilgisayar kazandı");
						lblWon.setText("Bilgisayar Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else{
						logger.info("Oyun berabere bitti");
						lblWon.setText("Berabere");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}
				}
				if(pcSayac >= (Oyuncu2.nesneList.size() - 1)){
					pcSayac = 0;
					Collections.shuffle(Oyuncu2.nesneList);
				}
				enableSayac++;
				if (enableSayac >= buttonList.size()) {
					enableSayac = 0;
					for(int i=0; i<buttonList.size(); i++){
						buttonList.get(i).setEnabled(true);
					}
				}
				hamle++;
				lblHamle.setText("Kalan Hamle: " + (maxHamle - hamle));
				if (hamle == maxHamle) {
					for(int i=0; i<Oyuncu1.nesneList.size(); i++){
						Oyuncu1.setSkor(Oyuncu1.getSkor() + Oyuncu1.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<Oyuncu2.nesneList.size(); i++){
						Oyuncu2.setSkor(Oyuncu2.getSkor() + Oyuncu2.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<btnList.size(); i++){
						btnList.get(i).setVisible(false);
					}
					for(JLabel lbl : lblList){
						lbl.setVisible(false);
					}
					if(Oyuncu1.getSkor() > Oyuncu2.getSkor()){
						logger.info(label1.getText() + " kazandı");
						lblWon.setText(label1.getText() + " Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else if(Oyuncu2.getSkor() > Oyuncu1.getSkor()){
						logger.info("Bilgisayar kazandı");
						lblWon.setText("Bilgisayar Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else{
						logger.info("Oyun berabere bitti");
						lblWon.setText("Berabere");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}
				}
			}
		});
		btn4Oyuncu1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				if (btn4Oyuncu1.isEnabled()) {
					btn4Oyuncu1.setBackground(Color.BLACK);
				}
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btn4Oyuncu1.setBackground(new Color(35,35,35));
			}
		});

		btn5Oyuncu1.setBorder(new LineBorder(Color.BLACK));
		btn5Oyuncu1.setBackground(new Color(35,35,35));
		btn5Oyuncu1.setForeground(Color.WHITE);
		btn5Oyuncu1.setFont(new Font("Calibri", Font.BOLD, 20));
		btn5Oyuncu1.setSize(120, 160);
		btn5Oyuncu1.setLocation(647, 286);
		btn5Oyuncu1.setText(Oyuncu1.nesneList.get(4).getNesneIsım());
		btn5Oyuncu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn5Oyuncu1.setEnabled(false);
				Nesne userNesne5= Oyuncu1.nesneSec(4);
				Nesne pcNesne5= Oyuncu2.nesneSec(pcSayac);
				lblvs1.setText(userNesne5.getNesneIsım());
				lblvs2.setText(pcNesne5.getNesneIsım());

				if (userNesne5.getClass().getSimpleName().equals(pcNesne5.getClass().getSimpleName())) {
						userNesne5.etkiHesapla(pcNesne5);
						pcNesne5.etkiHesapla(userNesne5);
						pcNesne5.durumGuncelle(userNesne5);
						userNesne5.durumGuncelle(pcNesne5);
						userNesne5.nesnePuaniGoster(lbl5, lbl10);
						logger.info("Karşılaşma Berabere");
				} else if ((userNesne5.getClass().getSimpleName().equals("Tas")
						|| userNesne5.getClass().getSimpleName().equals("AgirTas"))
						&& (pcNesne5.getClass().getSimpleName().equals("Makas")
						|| pcNesne5.getClass().getSimpleName().equals("UstaMakas"))) {
					logger.info("Kullanıcı kazandı");
					userNesne5.setSeviyePuani(userNesne5.getSeviyePuani() + 20);
					if(userNesne5.getSeviyePuani()>=30 && userNesne5.getClass().getSimpleName().equals("Tas")){
						Oyuncu1.nesneList.remove(4);
						Oyuncu1.nesneList.add(4, new AgirTas());
						userNesne5= Oyuncu1.nesneList.get(4);
						btn5Oyuncu1.setText(userNesne5.getNesneIsım());
						logger.info("Kullanıcının taş nesnesi terfi etti");
					}
					userNesne5.etkiHesapla(pcNesne5);
					pcNesne5.etkiHesapla(userNesne5);
					pcNesne5.durumGuncelle(userNesne5);
					userNesne5.durumGuncelle(pcNesne5);
					userNesne5.nesnePuaniGoster(lbl5, lbl10);
				} else if ((userNesne5.getClass().getSimpleName().equals("Tas")
						|| userNesne5.getClass().getSimpleName().equals("AgirTas"))
						&& (pcNesne5.getClass().getSimpleName().equals("Kagit")
						|| pcNesne5.getClass().getSimpleName().equals("OzelKagit"))) {
					logger.info("Bilgisayar kazandı");
					pcNesne5.setSeviyePuani(pcNesne5.getSeviyePuani() + 20);
					if(pcNesne5.getSeviyePuani()>=30 && pcNesne5.getClass().getSimpleName().equals("Kagit")){
						Oyuncu2.nesneList.remove(pcSayac);
						Oyuncu2.nesneList.add(pcSayac, new OzelKagit());
						pcNesne5= Oyuncu2.nesneList.get(pcSayac);
						logger.info("Bilgisayarın kağıt nesnesi terfi etti");
					}
					userNesne5.etkiHesapla(pcNesne5);
					pcNesne5.etkiHesapla(userNesne5);
					pcNesne5.durumGuncelle(userNesne5);
					userNesne5.durumGuncelle(pcNesne5);
					userNesne5.nesnePuaniGoster(lbl5, lbl10);
				} else if ((userNesne5.getClass().getSimpleName().equals("Kagit")
						|| userNesne5.getClass().getSimpleName().equals("OzelKagit"))
						&& (pcNesne5.getClass().getSimpleName().equals("Tas")
						|| pcNesne5.getClass().getSimpleName().equals("AgirTas"))) {
					logger.info("Kullanıcı kazandı");
					userNesne5.setSeviyePuani(userNesne5.getSeviyePuani() + 20);
					if(userNesne5.getSeviyePuani()>=30 && userNesne5.getClass().getSimpleName().equals("Kagit")){
						Oyuncu1.nesneList.remove(4);
						Oyuncu1.nesneList.add(4, new OzelKagit());
						userNesne5= Oyuncu1.nesneList.get(4);
						btn5Oyuncu1.setText(userNesne5.getNesneIsım());
						logger.info("Kullanıcının kağıt nesnesi terfi etti");
					}
					userNesne5.etkiHesapla(pcNesne5);
					pcNesne5.etkiHesapla(userNesne5);
					pcNesne5.durumGuncelle(userNesne5);
					userNesne5.durumGuncelle(pcNesne5);
					userNesne5.nesnePuaniGoster(lbl5, lbl10);
				} else if ((userNesne5.getClass().getSimpleName().equals("Kagit")
						|| userNesne5.getClass().getSimpleName().equals("OzelKagit"))
						&& (pcNesne5.getClass().getSimpleName().equals("Makas")
						|| pcNesne5.getClass().getSimpleName().equals("UstaMakas"))) {
					logger.info("Bilgisayar kazandı");
					pcNesne5.setSeviyePuani(pcNesne5.getSeviyePuani() + 20);
					if(pcNesne5.getSeviyePuani()>=30 && pcNesne5.getClass().getSimpleName().equals("Makas")){
						Oyuncu2.nesneList.remove(pcSayac);
						Oyuncu2.nesneList.add(pcSayac, new UstaMakas());
						pcNesne5= Oyuncu2.nesneList.get(pcSayac);
						logger.info("Bilgisayarın Makas nesnesi terfi etti");
					}
					userNesne5.etkiHesapla(pcNesne5);
					pcNesne5.etkiHesapla(userNesne5);
					pcNesne5.durumGuncelle(userNesne5);
					userNesne5.durumGuncelle(pcNesne5);
					userNesne5.nesnePuaniGoster(lbl5, lbl10);
				} else if ((userNesne5.getClass().getSimpleName().equals("Makas")
						|| userNesne5.getClass().getSimpleName().equals("UstaMakas"))
						&& (pcNesne5.getClass().getSimpleName().equals("Kagit")
						|| pcNesne5.getClass().getSimpleName().equals("OzelKagit"))) {
					logger.info("Kullanıcı kazandı");
					userNesne5.setSeviyePuani(userNesne5.getSeviyePuani() + 20);
					if(userNesne5.getSeviyePuani()>=30 && userNesne5.getClass().getSimpleName().equals("Makas")){
						Oyuncu1.nesneList.remove(4);
						Oyuncu1.nesneList.add(4, new UstaMakas());
						userNesne5= Oyuncu1.nesneList.get(4);
						btn5Oyuncu1.setText(userNesne5.getNesneIsım());
						logger.info("Kullanıcının Makas nesnesi terfi etti");
					}
					userNesne5.etkiHesapla(pcNesne5);
					pcNesne5.etkiHesapla(userNesne5);
					pcNesne5.durumGuncelle(userNesne5);
					userNesne5.durumGuncelle(pcNesne5);
					userNesne5.nesnePuaniGoster(lbl5, lbl10);
				} else if ((userNesne5.getClass().getSimpleName().equals("Makas")
						|| userNesne5.getClass().getSimpleName().equals("UstaMakas"))
						&& (pcNesne5.getClass().getSimpleName().equals("Tas")
						|| pcNesne5.getClass().getSimpleName().equals("AgirTas"))) {
					logger.info("Bilgisayar kazandı");
					pcNesne5.setSeviyePuani(pcNesne5.getSeviyePuani() + 20);
					if(pcNesne5.getSeviyePuani()>=30 && pcNesne5.getClass().getSimpleName().equals("Tas")){
						Oyuncu2.nesneList.remove(pcSayac);
						Oyuncu2.nesneList.add(pcSayac, new AgirTas());
						pcNesne5= Oyuncu2.nesneList.get(pcSayac);
						logger.info("Bilgisayarın taş nesnesi terfi etti");
					}
					userNesne5.etkiHesapla(pcNesne5);
					pcNesne5.etkiHesapla(userNesne5);
					pcNesne5.durumGuncelle(userNesne5);
					userNesne5.durumGuncelle(pcNesne5);
					userNesne5.nesnePuaniGoster(lbl5, lbl10);
				}
				if(userNesne5.getDayaniklilik() <= 0){
					userNesne5.setDayaniklilik(0);
					userNesne5.nesnePuaniGoster(lbl5, lbl10);
					buttonList.remove(btn5Oyuncu1);
					logger.info("Kullanıcının " + userNesne5.getNesneIsım() + " nesnesi elendi");
				}
				if(pcNesne5.getDayaniklilik() <= 0){
					pcNesne5.setDayaniklilik(0);
					Oyuncu2.nesneList.remove(pcSayac);
					lblKalanPc.setText("Kalan Nesne: " + Oyuncu2.nesneList.size());
					logger.info("Bilgisayarın " + pcNesne5.getNesneIsım() + " nesnesi elendi");
				} 
				else{
					pcSayac++;
				}
				if(buttonList.size() == 0 ||Oyuncu2.nesneList.size() == 0){
					if(buttonList.size() == 0)
						logger.info("Kullanıcının elindeki nesneler tükendi");
					else
						logger.info("Bilgisayarın elindeki nesneler tükendi");
					for(int i=0; i<Oyuncu1.nesneList.size(); i++){
						Oyuncu1.setSkor(Oyuncu1.getSkor() + Oyuncu1.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<Oyuncu2.nesneList.size(); i++){
						Oyuncu2.setSkor(Oyuncu2.getSkor() + Oyuncu2.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<btnList.size(); i++){
						btnList.get(i).setVisible(false);
					}
					for(JLabel lbl : lblList){
						lbl.setVisible(false);
					}
					if(Oyuncu1.getSkor() > Oyuncu2.getSkor()){
						logger.info(label1.getText() + " kazandı");
						lblWon.setText(label1.getText() + " Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else if(Oyuncu2.getSkor() > Oyuncu1.getSkor()){
						logger.info("Bilgisayar kazandı");
						lblWon.setText("Bilgisayar Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else{
						logger.info("Oyun berabere bitti");
						lblWon.setText("Berabere");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}
				}
				if(pcSayac >= (Oyuncu2.nesneList.size()-1)){
					pcSayac = 0;
					Collections.shuffle(Oyuncu2.nesneList);
				}
				enableSayac++;
				if (enableSayac >= buttonList.size()) {
					enableSayac = 0;
					for(int i=0; i<buttonList.size(); i++){
						buttonList.get(i).setEnabled(true);
					}
				}
				hamle++;
				lblHamle.setText("Kalan Hamle: " + (maxHamle - hamle));
				if (hamle == maxHamle) {
					for(int i=0; i<Oyuncu1.nesneList.size(); i++){
						Oyuncu1.setSkor(Oyuncu1.getSkor() + Oyuncu1.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<Oyuncu2.nesneList.size(); i++){
						Oyuncu2.setSkor(Oyuncu2.getSkor() + Oyuncu2.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i<btnList.size(); i++){
						btnList.get(i).setVisible(false);
					}
					for(JLabel lbl : lblList){
						lbl.setVisible(false);
					}
					if(Oyuncu1.getSkor() > Oyuncu2.getSkor()){
						logger.info(label1.getText() + " kazandı");
						lblWon.setText(label1.getText() + " Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else if(Oyuncu2.getSkor() > Oyuncu1.getSkor()){
						logger.info("Bilgisayar kazandı");
						lblWon.setText("Bilgisayar Kazandı");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}else{
						logger.info("Oyun berabere bitti");
						lblWon.setText("Berabere");
						lblWon.setVisible(true);
						lblSkor1.setText(label1.getText() + " Skor: " + Oyuncu1.getSkor());
						lblSkor1.setVisible(true);
						lblSkor2.setText(label2.getText() + " Skor: " + Oyuncu2.getSkor());
						lblSkor2.setVisible(true);
					}
				}
			}
		});
		btn5Oyuncu1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				if (btn5Oyuncu1.isEnabled()) {
					btn5Oyuncu1.setBackground(Color.BLACK);
				}
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btn5Oyuncu1.setBackground(new Color(35,35,35));
			}
		});

		if(playerName.length()==0){
			label1.setText("Kullanıcı");
		}else{
		label1.setText(playerName);
		}
		label1.setFont(new Font("Calibri",Font.BOLD,20));
		label1.setSize(97, 52);
	    label1.setLocation(90, 149);
		label1.setForeground(Color.WHITE);

		label2.setText("Bilgisayar");
		label2.setFont(new Font("Calibri",Font.BOLD,20));
		label2.setSize(97, 52);
	    label2.setLocation(613, 149);
		label2.setForeground(Color.WHITE);
		

		frm2.setTitle("Taş Kağıt Makas");
		frm2.setSize(800, 600);
		frm2.setLocation(350, 100);
		frm2.setIconImage(icon.getImage());
		frm2.getContentPane().setLayout(null);
		frm2.getContentPane().setBackground(Color.DARK_GRAY);

		frm2.getContentPane().add(btn1Oyuncu1);
		frm2.getContentPane().add(btn2Oyuncu1);
		frm2.getContentPane().add(btn3Oyuncu1);
		frm2.getContentPane().add(btn4Oyuncu1);
		frm2.getContentPane().add(btn5Oyuncu1);
		
		frm2.getContentPane().add(label1);
		frm2.getContentPane().add(label2);
		frm2.getContentPane().add(lbl1);
		frm2.getContentPane().add(lbl2);
		frm2.getContentPane().add(lbl3);
		frm2.getContentPane().add(lbl4);
		frm2.getContentPane().add(lbl5);
		frm2.getContentPane().add(lbl6);
		frm2.getContentPane().add(lbl7);
		frm2.getContentPane().add(lbl8);
		frm2.getContentPane().add(lbl9);
		frm2.getContentPane().add(lbl10);
		frm2.getContentPane().add(lblHamle);
		frm2.getContentPane().add(lblVs);
		frm2.getContentPane().add(lblvs1);
		frm2.getContentPane().add(lblvs2);
		frm2.getContentPane().add(lblWon);
		frm2.getContentPane().add(lblSkor1);
		frm2.getContentPane().add(lblSkor2);
		frm2.getContentPane().add(lblKalanPc);
		frm2.setResizable(false);
		frm2.setVisible(true);
		frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static int kalan1=5, kalan2=5;
	public static int sayac1=0,sayac2=0;
	public static void initFrm3() throws InterruptedException{
		ImageIcon icon = new ImageIcon(
				"C:\\Users\\ASUS\\Desktop\\Prolab2\\tasKagitMakas\\images\\rock-paper-scissors.png");
		Oyuncu1= new Bilgisayar();
		Oyuncu2= new Bilgisayar();
		JFrame frm3= new JFrame();
		JLabel lblpc1= new JLabel();
		JLabel lblpc2= new JLabel();
		JLabel lblHamle= new JLabel();
		JLabel lblVs= new JLabel();
		JLabel lblVs1= new JLabel();
		JLabel lblVs2= new JLabel();
		JLabel lblKalan1= new JLabel();
		JLabel lblKalan2= new JLabel();
		JLabel lblWon = new JLabel();
		JLabel lblSkor1 = new JLabel();
		JLabel lblSkor2 = new JLabel();
		JButton btnStart= new JButton();
		JButton btnNext= new JButton();

		lblWon.setVisible(false);
		lblWon.setFont(new Font("Calibri",Font.BOLD,35));
	    lblWon.setBounds(250, 260, 300, 80);
	    lblWon.setForeground(Color.WHITE);

		lblSkor1.setBounds(250, 350, 200, 50);
	    lblSkor1.setVisible(false);
	    lblSkor1.setForeground(Color.WHITE);
	    lblSkor1.setFont(new Font("Calibri",Font.BOLD,20));

		lblSkor2.setBounds(250, 410, 200, 50);
	    lblSkor2.setVisible(false);
	    lblSkor2.setForeground(Color.WHITE);
	    lblSkor2.setFont(new Font("Calibri",Font.BOLD,20));

	    lblpc1.setSize(139, 60);
		lblpc1.setLocation(350, 493);
		lblpc1.setForeground(Color.WHITE);
		lblpc1.setFont(new Font("Calibri",Font.BOLD,25));
		lblpc1.setText("Bilgisayar1");
		lblpc1.setVisible(false);

		lblpc2.setSize(139, 60);
	    lblpc2.setLocation(350, 10);
		lblpc2.setForeground(Color.WHITE);
		lblpc2.setFont(new Font("Calibri",Font.BOLD,25));
		lblpc2.setText("Bilgisayar2");
		lblpc2.setVisible(false);

		lblVs.setFont(new Font("Calibri",Font.BOLD,30));
		lblVs.setForeground(Color.WHITE);
		lblVs.setBounds(380, 270, 40, 60);
		lblVs.setText("VS");
		lblVs.setVisible(false);

		lblVs1.setFont(new Font("Calibri",Font.BOLD,25)); 
		lblVs1.setForeground(Color.WHITE);
		lblVs1.setBounds(350, 397, 140, 52);
		lblVs2.setVisible(false);

		lblVs2.setFont(new Font("Calibri",Font.BOLD,25));
		lblVs2.setForeground(Color.WHITE);
		lblVs2.setBounds(350, 155, 140, 52);
		lblVs2.setVisible(false);

		lblHamle.setText("Kalan Hamle: " + (maxHamle-hamle));
		lblHamle.setForeground(Color.WHITE);
		lblHamle.setFont(new Font("Calibri",Font.BOLD,18));
		lblHamle.setLocation(647,10);
		lblHamle.setSize(139,60);
		lblHamle.setVisible(false);

		lblKalan1.setForeground(Color.WHITE);
		lblKalan1.setFont(new Font("Calibri",Font.BOLD,18));
		lblKalan1.setVisible(false);
		lblKalan1.setBounds(29,10,139,60);

		lblKalan2.setForeground(Color.WHITE);
		lblKalan2.setFont(new Font("Calibri",Font.BOLD,18));
		lblKalan2.setVisible(false);
		lblKalan2.setBounds(29,493,139,60);

		btnStart.setText("Oyunu Başlat");
		btnStart.setBorder(new LineBorder(Color.BLACK));
		btnStart.setForeground(Color.WHITE);
		btnStart.setBackground(Color.RED);
		btnStart.setBounds(340,270,120,60);

		btnNext.setText("Sonraki Hamle");
		btnNext.setForeground(Color.WHITE);
		btnNext.setBorder(new LineBorder(Color.BLACK));
		btnNext.setBackground(new Color(35,35,35));
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Calibri",Font.BOLD,15));
		btnNext.setBounds(647, 431, 130, 52);
		btnNext.setVisible(false);

		btnStart.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("Bilgisayar_Bilgisayar oyunu başlatıldı");
				btnStart.setVisible(false);
				lblpc1.setVisible(true);
				lblpc2.setVisible(true);
				lblVs.setVisible(true);
				lblVs1.setVisible(true);
				lblVs2.setVisible(true);
				lblHamle.setVisible(true);
				lblKalan1.setVisible(true);
				lblKalan2.setVisible(true);
				btnNext.setVisible(true);
				lblKalan1.setText("Kalan Nesne: " + Oyuncu1.nesneList.size());
				lblKalan2.setText("Kalan Nesne: " + Oyuncu2.nesneList.size());
			}
		});
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnStart.setBackground(new Color(35,35,35));
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnStart.setBackground(Color.RED);
			}
		});
		lblKalan1.setText("Kalan Nesne: " + 5);
		lblKalan2.setText("Kalan Nesne: " + 5);
		Collections.shuffle(Oyuncu1.nesneList);
		Collections.shuffle(Oyuncu2.nesneList);
		btnNext.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Nesne pcNesne1= Oyuncu1.nesneSec(sayac1);
				Nesne pcNesne2= Oyuncu2.nesneSec(sayac2);
				lblVs1.setText(pcNesne1.getNesneIsım());
				lblVs2.setText(pcNesne2.getNesneIsım());
				if(pcNesne1.getClass().getSimpleName().equals(pcNesne2.getClass().getSimpleName())){
					pcNesne1.etkiHesapla(pcNesne2);
					pcNesne2.etkiHesapla(pcNesne1);
					pcNesne2.durumGuncelle(pcNesne2);
					pcNesne1.durumGuncelle(pcNesne1);
					logger.info("Berabere");
				}else if(pcNesne1.getClass().getSimpleName().equals("Tas")
						|| pcNesne1.getClass().getSimpleName().equals("AgirTas")){
					if(pcNesne2.getClass().getSimpleName().equals("Kagit")
					 	|| pcNesne2.getClass().getSimpleName().equals("OzelKagit")){
						logger.info("Bilgisayar2 kazandı");
						pcNesne1.etkiHesapla(pcNesne2);
						pcNesne2.etkiHesapla(pcNesne1);
						pcNesne2.durumGuncelle(pcNesne2);
						pcNesne1.durumGuncelle(pcNesne1);
						pcNesne2.setSeviyePuani(pcNesne2.getSeviyePuani() + 20);
						if(pcNesne2.getSeviyePuani() > 30 && pcNesne2.getClass().getSimpleName().equals("Kagit")){
							Oyuncu2.nesneList.remove(sayac2);
							Oyuncu2.nesneList.add(sayac2, new OzelKagit());
							pcNesne2 = Oyuncu2.nesneList.get(sayac2);
							logger.info("Bilgisayar2 Kağıt nesnesi terfi etti");
						}
					}else if(pcNesne2.getClass().getSimpleName().equals("Makas")
							|| pcNesne2.getClass().getSimpleName().equals("UstaMakas")
							){
						pcNesne1.etkiHesapla(pcNesne2);
						pcNesne2.etkiHesapla(pcNesne1);
						pcNesne2.durumGuncelle(pcNesne2);
						pcNesne1.durumGuncelle(pcNesne1);
						pcNesne1.setSeviyePuani(pcNesne1.getSeviyePuani() + 20);
						if(pcNesne1.getSeviyePuani() > 30 && pcNesne1.getClass().getSimpleName().equals("Tas")){
							Oyuncu1.nesneList.remove(sayac1);
							Oyuncu1.nesneList.add(sayac1,new AgirTas());
							logger.info("Bilgisayar1 Taş nesnesi terfi etti");
						}
						logger.info("Bilgisayar1 kazandı");
					}
				}else if(pcNesne1.getClass().getSimpleName().equals("Kagit")
						|| pcNesne1.getClass().getSimpleName().equals("OzelKagit")){
					if(pcNesne2.getClass().getSimpleName().equals("Makas")
						|| pcNesne2.getClass().getSimpleName().equals("UstaMakas")){
						pcNesne1.etkiHesapla(pcNesne2);
						pcNesne2.etkiHesapla(pcNesne1);
						pcNesne2.durumGuncelle(pcNesne2);
						pcNesne1.durumGuncelle(pcNesne1);
						logger.info("Bilgisayar2 kazandı");
						pcNesne2.setSeviyePuani(pcNesne2.getSeviyePuani() + 20);
						if(pcNesne2.getSeviyePuani() > 30 && pcNesne2.getClass().getSimpleName().equals("Makas")){
							Oyuncu2.nesneList.remove(sayac2);
							Oyuncu2.nesneList.add(sayac2, new UstaMakas());
							pcNesne2 = Oyuncu2.nesneList.get(sayac2);
							logger.info("Bilgisayar2 Makas nesnesi terfi etti");
						}
					}else if(pcNesne2.getClass().getSimpleName().equals("Tas")
						|| pcNesne2.getClass().getSimpleName().equals("AgirTas")){
						logger.info("Bilgisayar1 kazandı");
						pcNesne1.etkiHesapla(pcNesne2);
						pcNesne2.etkiHesapla(pcNesne1);
						pcNesne2.durumGuncelle(pcNesne2);
						pcNesne1.durumGuncelle(pcNesne1);
						pcNesne1.setSeviyePuani(pcNesne1.getSeviyePuani() + 20);
						if(pcNesne1.getSeviyePuani() > 30 && pcNesne1.getClass().getSimpleName().equals("Kagit")){
							Oyuncu1.nesneList.remove(sayac1);
							Oyuncu1.nesneList.add(sayac1, new OzelKagit());
							logger.info("Bilgisayar1 Kağıt nesnesi terfi etti");
						}
					}
				}else if(pcNesne1.getClass().getSimpleName().equals("Makas")
						|| pcNesne1.getClass().getSimpleName().equals("UstaMakas")){
					if(pcNesne2.getClass().getSimpleName().equals("Tas")
						|| pcNesne2.getClass().getSimpleName().equals("AgirTas")){
						logger.info("Bilgisayar2 kazandı");
						pcNesne1.etkiHesapla(pcNesne2);
						pcNesne2.etkiHesapla(pcNesne1);
						pcNesne2.durumGuncelle(pcNesne2);
						pcNesne1.durumGuncelle(pcNesne1);
						pcNesne2.setSeviyePuani(pcNesne2.getSeviyePuani() + 20);
						if(pcNesne2.getSeviyePuani() > 30 && pcNesne2.getClass().getSimpleName().equals("Tas")){
							Oyuncu2.nesneList.remove(sayac2);
							Oyuncu2.nesneList.add(sayac2, new AgirTas());
							pcNesne2 = Oyuncu2.nesneList.get(sayac2);
							logger.info(("Bilgisayar2 Taş nesnesi terfi etti"));
						}
					}else if(pcNesne2.getClass().getSimpleName().equals("Kagit")
							|| pcNesne2.getClass().getSimpleName().equals("OzelKagit")){
						logger.info("Bilgisayar1 kazandı");
						pcNesne1.etkiHesapla(pcNesne2);
						pcNesne2.etkiHesapla(pcNesne1);
						pcNesne2.durumGuncelle(pcNesne2);
						pcNesne1.durumGuncelle(pcNesne1);
						pcNesne1.setSeviyePuani(pcNesne1.getSeviyePuani() + 20);
						if(pcNesne1.getSeviyePuani() > 30 && pcNesne1.getClass().getSimpleName().equals("Makas")){
							Oyuncu1.nesneList.remove(sayac1);
							Oyuncu1.nesneList.add(sayac1, new UstaMakas());
							logger.info("Bilgisayar1 Makas nesnesi terfi etti");
						}
					}
				}

				if(pcNesne1.getDayaniklilik()<=0){
					Oyuncu1.nesneList.remove(sayac1);
					logger.info("Bilgisayar1 " + pcNesne1.getNesneIsım() + " nesnesi  elendi");
				}else{
					sayac1++;
				}

				if(pcNesne2.getDayaniklilik()<=0){
					Oyuncu2.nesneList.remove(sayac2);
					logger.info("Bilgisayar2 " + pcNesne2.getNesneIsım() + " nesnesi  elendi");
				}else{
					sayac2++;
				}
				
				if(hamle+1 == maxHamle || Oyuncu1.nesneList.size()==0 || Oyuncu2.nesneList.size()==0){
					for(int i=0; i < Oyuncu1.nesneList.size(); i++){
						Oyuncu1.setSkor(Oyuncu1.getSkor() + Oyuncu1.nesneList.get(i).getDayaniklilik());
					}
					for(int i=0; i < Oyuncu2.nesneList.size(); i++){
						Oyuncu2.setSkor(Oyuncu2.getSkor() + Oyuncu2.nesneList.get(i).getDayaniklilik());
					}
					btnNext.setVisible(false);
					lblHamle.setVisible(false);
					lblKalan1.setVisible(false);
					lblKalan2.setVisible(false);
					lblVs.setVisible(false);
					lblVs1.setVisible(false);
					lblVs2.setVisible(false);
					lblpc1.setVisible(false);
					lblpc2.setVisible(false);
					lblWon.setVisible(true);
					lblSkor1.setVisible(true);
					Oyuncu1.skorGoster(lblpc1, lblSkor1);
					lblSkor2.setVisible(true);
					Oyuncu2.skorGoster(lblpc2, lblSkor2);
					if(Oyuncu1.getSkor() > Oyuncu2.getSkor()){
						lblWon.setText("Bilgisayar1 Kazandı");
						logger.info("Oyunu bilgisayar1 kazandı");
					}else if(Oyuncu2.getSkor() > Oyuncu1.getSkor()){
						lblWon.setText("Bilgisayar2 Kazandı");
						logger.info("Oyunu bilgisayar2 kazandı");
					}else{
						lblWon.setText("Berabere");
						logger.info("Oyun berabere bitti");
					} 
				}

				if(sayac1 >= (Oyuncu1.nesneList.size()-1)){
					sayac1= 0;
					Collections.shuffle(Oyuncu1.nesneList);
				}

				if(sayac2 >= (Oyuncu2.nesneList.size() - 1)){
					sayac2= 0;
					Collections.shuffle(Oyuncu2.nesneList);
				}
				kalan1= Oyuncu1.nesneList.size();
				lblKalan1.setText("Kalan Nesne: " + kalan1);
				kalan2= Oyuncu2.nesneList.size();
				lblKalan2.setText("Kalan Nesne: " + kalan2);
				lblHamle.setText("Kalan Hamle: " + (maxHamle-hamle-1));
				hamle++;	
			}
		});
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				if(btnNext.isEnabled()){
					btnNext.setBackground(Color.RED);
			}
		}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnNext.setBackground(new Color(35,35,35));
			}
		});

		frm3.getContentPane().add(lblpc1);
		frm3.getContentPane().add(lblpc2);
		frm3.getContentPane().add(lblHamle);
		frm3.getContentPane().add(lblVs);
		frm3.getContentPane().add(lblVs1);
		frm3.getContentPane().add(lblVs2);
		frm3.getContentPane().add(lblKalan1);
		frm3.getContentPane().add(lblKalan2);
		frm3.getContentPane().add(btnStart);
		frm3.getContentPane().add(btnNext);
		frm3.getContentPane().add(lblWon);
		frm3.getContentPane().add(lblSkor1);
		frm3.getContentPane().add(lblSkor2);

		frm3.setTitle("Taş Kağıt Makas");
		frm3.setSize(800, 600);
		frm3.setLocation(350, 100);
		frm3.setIconImage(icon.getImage());
		frm3.getContentPane().setLayout(null);
		frm3.getContentPane().setBackground(Color.DARK_GRAY);;
		frm3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm3.setResizable(false);
		frm3.setVisible(true);
	}
	public static void init(){
		FileHandler fh;
		try{
			fh = new FileHandler("./tasKagitMakas.log");
			
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			logger.info("Logger Initialized");
		}catch(Exception e){
			logger.log(Level.WARNING,"Exception ::",e);
		}
	}
}