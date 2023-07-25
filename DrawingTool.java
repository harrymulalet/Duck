package drawingTool;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import java.util.HashMap;
import java.util.Stack;

@SuppressWarnings("serial")
public class DrawingTool extends JFrame implements ActionListener, ChangeListener {
	
	private DrawingArea drawing;
	private TextFieldPanel textFieldPanel;
	private boolean isFirstClick;

	public DrawingTool(String title) {
		super(title);
		isFirstClick = true;
		constructDrawingArea();
		constructTextFieldPanel();

		Dimension screenSize = getToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		ImageIcon icon = new ImageIcon("cute-duck-white_1308-41058.jpg");
		this.setIconImage(icon.getImage());

		System.out.println("Screen Width is " + screenSize.width + "\n" + "Screen Height is " + screenSize.height);
		this.setResizable(true);

		this.setLayout(new GridLayout(1, 2));

		textFieldPanel.setPreferredSize(new Dimension(screenSize.width / 2, screenSize.height));

		this.add(textFieldPanel, 0);
		add(drawing,1);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void constructDrawingArea() {
		drawing = new DrawingArea(true,0.0);
		this.drawing.getScene().removeDucks();
		drawing.setBackground(new Color(0xea4335));
		drawing.revalidate();
		drawing.repaint();
	}
	
	private void constructTextFieldPanel() {
		textFieldPanel = new TextFieldPanel(this);
		textFieldPanel.setBackground(new Color(0x4285f4));
		textFieldPanel.revalidate();
		textFieldPanel.repaint();
	}

	public static void main(String[] args) {
		new DrawingTool("Draw a Duck");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Scene scene = this.drawing.getScene();
		
		if (e.getSource() == textFieldPanel.getButtons().get("submit")) {
			textFieldPanel.getLabels().get("welcome").setText("Welcome " + textFieldPanel.getTextFields().get("textField1").getText() + ", let's create our scene.");
			textFieldPanel.getLabels().get("welcome").setHorizontalAlignment(JLabel.CENTER);
			textFieldPanel.getLabels().get("welcome").setPreferredSize(new Dimension((textFieldPanel.getPreferredSize()).width,
			textFieldPanel.getLabels().get("welcome").getPreferredSize().height));
			textFieldPanel.getLabels().get("welcome").setVisible(true);
			textFieldPanel.getButtons().get("create").setVisible(true);
			textFieldPanel.getButtons().get("submit").setEnabled(false);
		} else if (e.getSource() == textFieldPanel.getButtons().get("create")) {
			textFieldPanel.getLabels().get("positionLabel").setVisible(true);
			textFieldPanel.getRadioButtons().get("traversal").setVisible(true);
			textFieldPanel.getRadioButtons().get("random").setVisible(true);
			textFieldPanel.getButtons().get("create").setEnabled(false);
		} else if (e.getSource() == textFieldPanel.getRadioButtons().get("traversal")) {
			textFieldPanel.getRadioButtons().get("traversal").setEnabled(false);
			textFieldPanel.getRadioButtons().get("random").setEnabled(false);
			textFieldPanel.getLabels().get("sizeLabel1").setVisible(true);
			textFieldPanel.getRadioButtons().get("setSize1").setVisible(true);
			textFieldPanel.getRadioButtons().get("generateSize1").setVisible(true);
		} else if (e.getSource() == textFieldPanel.getRadioButtons().get("setSize1")) {
			
			textFieldPanel.getRadioButtons().get("setSize1").setEnabled(false);
			textFieldPanel.getRadioButtons().get("generateSize1").setEnabled(false);
			textFieldPanel.getSliders().get("slider1").setVisible(true);
			textFieldPanel.getLabels().get("sliderLabel1").setVisible(true);
			textFieldPanel.getButtons().get("submit2").setVisible(true);
		} else if (e.getSource() == textFieldPanel.getRadioButtons().get("generateSize1")) {

			textFieldPanel.getRadioButtons().get("setSize1").setEnabled(false);
			textFieldPanel.getRadioButtons().get("generateSize1").setEnabled(false);
			textFieldPanel.getButtons().get("submit2").setVisible(true);
		} else if (e.getSource() == textFieldPanel.getButtons().get("submit2")) {
			if (textFieldPanel.getRadioButtons().get("setSize1").isSelected()) {
				double scaleValue = (textFieldPanel.getSliders().get("slider1").getValue())/100.0; // This is the scale value from the user.
				textFieldPanel.getSliders().get("slider1").setEnabled(false);
				boolean isSSSelected = textFieldPanel.getRadioButtons().get("setSize1").isSelected();
				System.out.println("Scale Slider is selected: " + isSSSelected + ", and the scale is: " + scaleValue);
				drawing.setScene(new Scene(true,scaleValue));
			} else if (textFieldPanel.getRadioButtons().get("generateSize1").isSelected()) {
				// I think here is where the generateDucksTraversalDifSize() method comes in.
				boolean isRSelected = textFieldPanel.getRadioButtons().get("generateSize1").isSelected();
				System.out.println("Random is selected: " + isRSelected);
				drawing.setScene(new Scene(true,0.0));
			}
			textFieldPanel.getButtons().get("submit2").setEnabled(false);
			textFieldPanel.getLabels().get("colorLabel1").setVisible(true);
			textFieldPanel.getButtons().get("black").setVisible(true);
			textFieldPanel.getButtons().get("red").setVisible(true);
			textFieldPanel.getButtons().get("yellow").setVisible(true);
			textFieldPanel.getButtons().get("newColor").setVisible(true);
			drawing.repaint();
			drawing.revalidate();
			
		} else if (e.getSource() == textFieldPanel.getRadioButtons().get("random")) {
			textFieldPanel.getRadioButtons().get("random").setEnabled(false);
			textFieldPanel.getRadioButtons().get("traversal").setEnabled(false);
			textFieldPanel.getLabels().get("sizeLabel2").setVisible(true);
			textFieldPanel.getRadioButtons().get("setSize2").setVisible(true);
			textFieldPanel.getRadioButtons().get("generateSize2").setVisible(true);
		} else if (e.getSource() == textFieldPanel.getRadioButtons().get("setSize2")) {

			textFieldPanel.getRadioButtons().get("setSize2").setEnabled(false);
			textFieldPanel.getRadioButtons().get("generateSize2").setEnabled(false);
			textFieldPanel.getSliders().get("slider2").setVisible(true);
			textFieldPanel.getLabels().get("sliderLabel2").setVisible(true);
			textFieldPanel.getButtons().get("submit3").setVisible(true);
		} else if (e.getSource() == textFieldPanel.getRadioButtons().get("generateSize2")) {

			textFieldPanel.getRadioButtons().get("setSize2").setEnabled(false);
			textFieldPanel.getRadioButtons().get("generateSize2").setEnabled(false);
			textFieldPanel.getButtons().get("submit3").setVisible(true);
		}

		else if (e.getSource() == textFieldPanel.getButtons().get("submit3")) {
			if (textFieldPanel.getRadioButtons().get("setSize2").isSelected()) {
				double scaleValue = (textFieldPanel.getSliders().get("slider2").getValue())/100.0; // This is the scale value from the user.
				textFieldPanel.getSliders().get("slider2").setEnabled(false);
				boolean isSSSelected = textFieldPanel.getRadioButtons().get("setSize2").isSelected();
				System.out.println("Scale Slider is selected: " + isSSSelected + ", and the scale is: " + scaleValue);
				drawing.setScene(new Scene(false,scaleValue));
			} else if (textFieldPanel.getRadioButtons().get("generateSize2").isSelected()) {
				boolean isRSelected = textFieldPanel.getRadioButtons().get("generateSize2").isSelected();
				System.out.println("Random is selected: " + isRSelected);
				drawing.setScene(new Scene(false,0.0));
			}
			textFieldPanel.getButtons().get("submit3").setEnabled(false);
			textFieldPanel.getLabels().get("colorLabel1").setVisible(true);
			textFieldPanel.getButtons().get("black").setVisible(true);
			textFieldPanel.getButtons().get("red").setVisible(true);
			textFieldPanel.getButtons().get("yellow").setVisible(true);
			textFieldPanel.getButtons().get("newColor").setVisible(true);
			drawing.repaint();
			drawing.revalidate();
		}
		
		else if (e.getSource() == textFieldPanel.getButtons().get("black")) {
			drawing.getScene().setColDucks(Color.BLACK);
			textFieldPanel.getLabels().get("setState").setVisible(true);
			textFieldPanel.getButtons().get("organize").setVisible(true);
			textFieldPanel.getButtons().get("randomState").setVisible(true);
			textFieldPanel.getButtons().get("remove").setVisible(true);
			drawing.repaint();
			drawing.revalidate();
		}
		
		else if (e.getSource() == textFieldPanel.getButtons().get("red")) {
			drawing.getScene().setColDucks(Color.RED);
			textFieldPanel.getLabels().get("setState").setVisible(true);
			textFieldPanel.getButtons().get("organize").setVisible(true);
			textFieldPanel.getButtons().get("randomState").setVisible(true);
			textFieldPanel.getButtons().get("remove").setVisible(true);
			drawing.repaint();
			drawing.revalidate();
		}
		
		else if (e.getSource() == textFieldPanel.getButtons().get("yellow")) {
			drawing.getScene().setColDucks(Color.YELLOW);
			textFieldPanel.getLabels().get("setState").setVisible(true);
			textFieldPanel.getButtons().get("organize").setVisible(true);
			textFieldPanel.getButtons().get("randomState").setVisible(true);
			textFieldPanel.getButtons().get("remove").setVisible(true);
			drawing.repaint();
			drawing.revalidate();
		}
		
		else if (e.getSource() == textFieldPanel.getButtons().get("newColor")) {
			drawing.getScene().setColDucks(new Color((int) (Math.random() * 0x1000000)));
			textFieldPanel.getLabels().get("setState").setVisible(true);
			textFieldPanel.getButtons().get("organize").setVisible(true);
			textFieldPanel.getButtons().get("randomState").setVisible(true);
			textFieldPanel.getButtons().get("remove").setVisible(true);
			drawing.repaint();
			drawing.revalidate();
		}
		
		if (e.getSource() == textFieldPanel.getButtons().get("organize")) {
//			drawing.getScene().setOrganized();
			textFieldPanel.getButtons().get("black").setEnabled(false);
			textFieldPanel.getButtons().get("red").setEnabled(false);
			textFieldPanel.getButtons().get("yellow").setEnabled(false);
			textFieldPanel.getButtons().get("newColor").setEnabled(false);
			textFieldPanel.getLabels().get("lastLabel").setVisible(true);
			textFieldPanel.getButtons().get("end").setVisible(true);
			if (isFirstClick) {
				drawing.setScene(new Scene(drawing));
                isFirstClick = false;
            }
			drawing.getScene().setOrganized();
			drawing.repaint();
			drawing.revalidate();
		}
		
		else if (e.getSource() == textFieldPanel.getButtons().get("randomState")) {
			textFieldPanel.getButtons().get("black").setEnabled(false);
			textFieldPanel.getButtons().get("red").setEnabled(false);
			textFieldPanel.getButtons().get("yellow").setEnabled(false);
			textFieldPanel.getButtons().get("newColor").setEnabled(false);
			textFieldPanel.getLabels().get("lastLabel").setVisible(true);
			textFieldPanel.getButtons().get("end").setVisible(true);
			if (isFirstClick) {
				drawing.setScene(new Scene(drawing));
                isFirstClick = false;
            }
			drawing.getScene().setRandom();
			drawing.repaint();
			drawing.revalidate();
		}
		
		else if (e.getSource() == textFieldPanel.getButtons().get("remove")) {
			textFieldPanel.getButtons().get("black").setEnabled(false);
			textFieldPanel.getButtons().get("red").setEnabled(false);
			textFieldPanel.getButtons().get("yellow").setEnabled(false);
			textFieldPanel.getButtons().get("newColor").setEnabled(false);
			textFieldPanel.getLabels().get("lastLabel").setVisible(true);
			textFieldPanel.getButtons().get("end").setVisible(true);
			if (isFirstClick) {
				drawing.setScene(new Scene(drawing));
                isFirstClick = false;
            }
			drawing.getScene().setBlank();
			drawing.repaint();
			drawing.revalidate();
		}
		
		else if (e.getSource() == textFieldPanel.getButtons().get("end")) {
			System.exit(0);
		}

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		textFieldPanel.getLabels().get("sliderLabel1").setText("Slider is now set to " + textFieldPanel.getSliders().get("slider1").getValue()
				+ ". Click on Submit, after setting the slider.");
		textFieldPanel.getLabels().get("sliderLabel2").setText("Slider is now set to " + textFieldPanel.getSliders().get("slider2").getValue()
				+ ". Click on Submit, after setting the slider.");
	}
}