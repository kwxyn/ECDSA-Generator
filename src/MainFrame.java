import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.spec.ECPoint;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultCaret;

import org.apache.commons.codec.digest.DigestUtils;

public class MainFrame {

	static ArrayList<String> texts = new ArrayList<String>();
	static String outputParametersPath="";
	static String outputPath="";
	

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("ECDSA Generator");
		mainFrame.setSize(1200, 800);
		mainFrame.setLayout(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);

		ImageIcon image = new ImageIcon("logo.png"); // Create an image icon
		mainFrame.setIconImage(image.getImage()); // Set icon for the application
		mainFrame.getContentPane().setBackground(new Color(0x123456)); // Change color of background

		// Panels
		JPanel TopLeftPanel = new JPanel();
		TopLeftPanel.setBounds(10, 15, 130, 190);
		TopLeftPanel.setBackground(new Color(0x123456));
		TopLeftPanel.setLayout(new GridLayout(8, 1, 5, 5));

		JPanel TopRightPanel = new JPanel();
		TopRightPanel.setBounds(150, 15, 1025, 190);
		TopRightPanel.setBackground(new Color(0x123456));
		TopRightPanel.setLayout(new GridLayout(8, 1, 5, 5));

		JPanel MiddleUpperPanel = new JPanel();
		MiddleUpperPanel.setBounds(10, 214, 1165, 25);
		MiddleUpperPanel.setBackground(new Color(0x123456));
		MiddleUpperPanel.setLayout(new GridLayout(1, 2, 200, 10));

		JPanel MiddleLowerPanel = new JPanel();
		MiddleLowerPanel.setBounds(10, 250, 1165, 455);
		MiddleLowerPanel.setBackground(new Color(0x123456));
		MiddleLowerPanel.setLayout(new GridLayout(1, 2, 10, 10));

		JPanel BottomPanel = new JPanel();
		BottomPanel.setBounds(10, 720, 1165, 30);
		BottomPanel.setBackground(new Color(0x123456));
		BottomPanel.setLayout(new GridLayout(1, 2, 900, 10));

		// Labels
		JLabel label1 = new JLabel("Name of elliptic curve :");
		JLabel label2 = new JLabel("Prime p :");
		JLabel label3 = new JLabel("Curve Coefficient a :");
		JLabel label4 = new JLabel("Curve Coefficient b :");
		JLabel label5 = new JLabel("Generator Point x :");
		JLabel label6 = new JLabel("Generator Point y :");
		JLabel label7 = new JLabel("Subgroup order n :");
		JLabel label8 = new JLabel("Private key :");

		JLabel credits = new JLabel("DEVELOPED BY KWAN");
		credits.setBackground((new Color(0x123456)));
		credits.setForeground(Color.white);

		label1.setForeground(new Color(255, 255, 255));
		label2.setForeground(new Color(255, 255, 255));
		label3.setForeground(new Color(255, 255, 255));
		label4.setForeground(new Color(255, 255, 255));
		label5.setForeground(new Color(255, 255, 255));
		label6.setForeground(new Color(255, 255, 255));
		label7.setForeground(new Color(255, 255, 255));
		label8.setForeground(new Color(255, 255, 255));

		TopLeftPanel.add(label1);
		TopLeftPanel.add(label2);
		TopLeftPanel.add(label3);
		TopLeftPanel.add(label4);
		TopLeftPanel.add(label5);
		TopLeftPanel.add(label6);
		TopLeftPanel.add(label7);
		TopLeftPanel.add(label8);

		// TextField Areas
		JTextField nameText = new JTextField();
		JTextField primeText = new JTextField();
		JTextField AText = new JTextField();
		JTextField BText = new JTextField();
		JTextField GXText = new JTextField();
		JTextField GYText = new JTextField();
		JTextField NText = new JTextField();
		JTextField PKText = new JTextField();

		nameText.setBackground(Color.black);
		nameText.setForeground(Color.green);
		nameText.setBorder(new LineBorder(Color.black));
		primeText.setBackground(Color.black);
		primeText.setForeground(Color.green);
		primeText.setBorder(new LineBorder(Color.black));
		AText.setBackground(Color.black);
		AText.setForeground(Color.green);
		AText.setBorder(new LineBorder(Color.black));
		BText.setBackground(Color.black);
		BText.setForeground(Color.green);
		BText.setBorder(new LineBorder(Color.black));
		GXText.setBackground(Color.black);
		GXText.setForeground(Color.green);
		GXText.setBorder(new LineBorder(Color.black));
		GYText.setBackground(Color.black);
		GYText.setForeground(Color.green);
		GYText.setBorder(new LineBorder(Color.black));
		NText.setBackground(Color.black);
		NText.setForeground(Color.green);
		NText.setBorder(new LineBorder(Color.black));
		PKText.setBackground(Color.black);
		PKText.setForeground(Color.green);
		PKText.setBorder(new LineBorder(Color.black));

		TopRightPanel.add(nameText);
		TopRightPanel.add(primeText);
		TopRightPanel.add(AText);
		TopRightPanel.add(BText);
		TopRightPanel.add(GXText);
		TopRightPanel.add(GYText);
		TopRightPanel.add(NText);
		TopRightPanel.add(PKText);

		// Buttons
		JButton input = new JButton("Input JSON file");
		JButton output = new JButton("Output JSON file");
		JButton outputParameters = new JButton("Output Parameters JSON file");
		JButton exe = new JButton("Execute");

		MiddleUpperPanel.add(input);
		MiddleUpperPanel.add(outputParameters);
		MiddleUpperPanel.add(output);

		// Text areas
		JTextArea inputText = new JTextArea();
		JTextArea outputText = new JTextArea();
		
		inputText.setBackground(Color.black);
		inputText.setForeground(Color.GREEN);
		outputText.setBackground(Color.black);
		outputText.setForeground(Color.GREEN);
		inputText.setEditable(false);
		outputText.setEditable(false);

		MiddleLowerPanel.add(inputText);
		MiddleLowerPanel.add(outputText);
		
		// Scroll bars
		JScrollPane Leftscroll = new JScrollPane(inputText,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JScrollPane Rightscroll = new JScrollPane(outputText,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		MiddleLowerPanel.add(Leftscroll);
		MiddleLowerPanel.add(Rightscroll);
		BottomPanel.add(credits);
		BottomPanel.add(exe);

		mainFrame.add(TopLeftPanel);
		mainFrame.add(TopRightPanel);
		mainFrame.add(MiddleUpperPanel);
		mainFrame.add(MiddleLowerPanel);
		mainFrame.add(BottomPanel);
		
		Leftscroll.setEnabled(true);
		Rightscroll.setEnabled(true);
		DefaultCaret caret = (DefaultCaret)inputText.getCaret(); 
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        DefaultCaret caret1 = (DefaultCaret)outputText.getCaret(); 
        caret1.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		mainFrame.setVisible(true);

		// Input button result
		input.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					// UPLOAD JSON FILE AND PRINT ON TEXTAREA
					inputText.setText("");
					JButton open = new JButton("Click me");
					JFileChooser fc = new JFileChooser();
					fc.setCurrentDirectory(new java.io.File("C://Desktop"));
					fc.setDialogTitle("Directory");
					fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fc.setFileFilter(new FileNameExtensionFilter("JSON FILES", "json"));
					if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
					}
					
					texts = JSONReader.JsonReadForText(fc.getSelectedFile().getAbsolutePath());
					inputText.append("Input from "+fc.getSelectedFile().getAbsolutePath()+"\n\n");
					for (int i = 0; i < texts.size(); i++) {
						String s = texts.get(i);
						inputText.append(s + "\n");
					}
				} catch (Exception event) {
					inputText.setText("ERROR, Please try again");
				}

			}
		});
		
		outputParameters.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					outputText.setText("");
					JButton open = new JButton("Click me");
					JFileChooser fc = new JFileChooser();
					fc.setCurrentDirectory(new java.io.File("C://Desktop"));
					fc.setDialogTitle("Directory");
					fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fc.setFileFilter(new FileNameExtensionFilter("JSON FILES", "json"));
					if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
					}
					outputParametersPath = fc.getSelectedFile().getAbsolutePath(); 
					outputText.setText("Output to "+ outputParametersPath + "\n");
					
				}
				catch (Exception event)
				{
					outputText.setText("ERROR, Please try again");
				}
				
			}
			
		});
		
		output.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					outputText.setText("");
					JButton open = new JButton("Click me");
					JFileChooser fc = new JFileChooser();
					fc.setCurrentDirectory(new java.io.File("C://Desktop"));
					fc.setDialogTitle("Directory");
					fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fc.setFileFilter(new FileNameExtensionFilter("JSON FILES", "json"));
					if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
					}
					outputPath =fc.getSelectedFile().getAbsolutePath(); 
					outputText.setText("Output to "+ outputPath + "\n");
					
				}
				catch (Exception event)
				{
					outputText.setText("ERROR, Please try again");
				}
				
			}
			
		});

		// Execute button result
		exe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					outputText.setText("");
					outputText.setText("Output results to "+ outputPath + "\n\n");		
					
					ArrayList<Signature> Signatures = new ArrayList<Signature>();
					CurveParameters cp = new CurveParameters(nameText.getText(), new BigInteger(primeText.getText()),
							new BigInteger(AText.getText()), new BigInteger(BText.getText()),
							new BigInteger(GXText.getText()), new BigInteger(GYText.getText()),
							new BigInteger(NText.getText()), new BigInteger(PKText.getText()));

					ECPoint gen_point = new ECPoint(cp.getX(), cp.getY());
					for (int i = 0; i < texts.size(); i++) // Loop all the texts
					{
						System.out.println();
						Random rand = new Random(); // source of randomness
						BigInteger k = new BigInteger(cp.getN().bitLength(), rand); // Generate a pesudorandom integer k

						ECPoint pk_point = pointMultipy(gen_point, k, cp); 
						BigInteger r = BigInteger.valueOf(0);
						while (r.equals(BigInteger.valueOf(0))) // if r=0 then recompute for r
						{
							r = pk_point.getAffineX().mod(cp.getN()); // r = X mod N
						}

						BigInteger kInv = k.modInverse(cp.getN()); // Compute for the K inverse
						BigInteger hashedText = encode(hash(texts.get(i))); // get 160-bit hash value
						BigInteger s = BigInteger.valueOf(0);
						while (s.equals(BigInteger.valueOf(0))) // if s=0 then recompute for s
						{
							// s = kInv( integer of hashed digest + private key(r)) mod N
							s = kInv.multiply(hashedText.add(cp.getPK().multiply(r))).mod(cp.getN());
						}
						Signatures.add(new Signature(texts.get(i), r, s));
					}
					
					//Write results to JSON File
					JSONWriter.JsonWriteData(outputPath,Signatures);
					
					//Compute for public key
					cp.setPublic_key(pointMultipy(gen_point,cp.getPK(),cp));
					
					//Print on the outputText console
					for (int i = 0; i < Signatures.size(); i++) {
						outputText.append(Signatures.get(i).getText() + " : Signed!\nr :" + Signatures.get(i).getR() + "\ns :"
								+ Signatures.get(i).getS() + "\n");
						outputText.append("\n");
					}
					
					outputText.append("Output curve parameters to "+ outputParametersPath + "\n\n");
					outputText.append("ECDSA signed under " + cp.getName() +"\n\nprime :"+cp.getP()
					+ "\n\na :"+cp.getA() + "\n\nb :"+cp.getB()+ "\n\nGenerator point :\nX :"+cp.getX()
					+"\nY :"+cp.getY()+ "\n\nSubgroup order :" +cp.getN()+ "\n\nPrivate Key :"+cp.getPK()
					+ "\n\nPublic key :\nx :" + cp.getPublic_key().getAffineX() + "\ny :" + cp.getPublic_key().getAffineY());
					
					// Write Parameters to JSON File
					JSONWriter.JsonWriteParameterData(outputParametersPath,cp);

				} catch (Exception event) {
					event.printStackTrace();
					outputText.setText("ERROR, Please try again");
				}

			}
		});

	}

	// EC Point addition operation
	public static ECPoint pointAddition(ECPoint p, ECPoint q, CurveParameters fp) {
		// Formula can be found in
		// https://en.m.wikipedia.org/wiki/Elliptic_curve_point_multiplication
		// Modulo the prime number n so that the ECPoint wont not go beyond the curve
		BigInteger numerator = q.getAffineY().subtract(p.getAffineY()); // Yq - Yp
		numerator = modArithmetic(numerator, fp); // result modulo with prime

		BigInteger denominator = q.getAffineX().subtract(p.getAffineX()); // Xq - Xp
		denominator = modArithmetic(denominator, fp); // result modulo with prime

		BigInteger lambda = numerator.multiply(denominator.modInverse(fp.getP())); // (Yq - Yp)*((Xq - Xp)^-1 modulo
																					// prime)
		lambda = modArithmetic(lambda, fp); // result modulo with prime

		BigInteger x = lambda.pow(2).subtract(p.getAffineX()).subtract(q.getAffineX()); // lambda^2 - Xp - Xq
		x = modArithmetic(x, fp); // result module with prime

		BigInteger y = (lambda.multiply(p.getAffineX().subtract(x))).subtract(p.getAffineY()); // lambda(Xp - X) - Yp
		y = modArithmetic(y, fp); // result module with prime

		return new ECPoint(x, y);
	}

	// EC Point double operation
	public static ECPoint pointDouble(ECPoint p, CurveParameters fp) {
		// Formula can be found in
		// https://crypto.stackexchange.com/questions/64456/problem-on-elliptic-curve-point-doubling
		// Modulo the prime number n so that the ECPoint wont not go beyond the curve
		BigInteger numerator = p.getAffineX().pow(2).multiply(BigInteger.valueOf(3)).add(fp.getA()); // 3Xp^2 + a
		numerator = modArithmetic(numerator, fp); // result modulo with prime

		BigInteger denominator = p.getAffineY().multiply(BigInteger.valueOf(2)); // 2Yp
		denominator = modArithmetic(denominator, fp); // result modulo with prime

		BigInteger lambda = numerator.multiply(denominator.modInverse(fp.getP())); // (3Xp^2 + a)*((2YP)^-1 modulo
																					// prime)
		lambda = modArithmetic(lambda, fp); // result modulo with prime

		BigInteger x = lambda.pow(2).subtract(p.getAffineX().multiply(BigInteger.valueOf(2))); // lambda^2 - 2Xp
		x = modArithmetic(x, fp); // result module with prime

		BigInteger y = (lambda.multiply(p.getAffineX().subtract(x))).subtract(p.getAffineY()); // lambda(Xp - X) - Yp
		y = modArithmetic(y, fp); // result module with prime

		return new ECPoint(x, y);
	}

	// EC Point Multiplication operation
	public static ECPoint pointMultipy(ECPoint p, BigInteger x, CurveParameters fp) {
		// Formula can be found in
		// https://en.m.wikipedia.org/wiki/Elliptic_curve_point_multiplication
		ECPoint n = new ECPoint(p.getAffineX(), p.getAffineY());

		String binaryX = x.toString(2); // convert BigInteger into Binary representation
		n = p;

		// From left to right bits of binary representation
		for (int i = 1; i < binaryX.length(); i++) // Get each bit value
		{
			if (Integer.parseInt(binaryX.substring(i, i + 1)) == 1)// if bit = 1
			{
				n = pointDouble(n, fp); // EC point double operation
				n = pointAddition(n, p, fp); // EC point addition operation
			} else // if bit = 0
			{
				n = pointDouble(n, fp);// EC point double operation
			}
		}
		return n;
	}

	public static BigInteger modArithmetic(BigInteger x, CurveParameters fp) // Result mod Prime p
	{
		return x.mod(fp.getP());
	}

	public static String hash(final String text) {
		return DigestUtils.sha256Hex(text);
	}

	public static BigInteger encode(final String text) {
		return new BigInteger(text.getBytes(StandardCharsets.UTF_8));
	}
}
