package drawingTool;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class TextFieldPanel extends JPanel{
	
	private HashMap<String, JTextField> textFields;
	private HashMap<String, JButton> buttons;
	private HashMap<String, JLabel> labels;
	private HashMap<String, JRadioButton> radioButtons;
	private HashMap<String, JSlider> sliders;
	
	public TextFieldPanel(DrawingTool drawingTool) {
		
		Dimension screenSize = getToolkit().getScreenSize();
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setPreferredSize(new Dimension(screenSize.width / 2, screenSize.height));
		textFields = new HashMap<String, JTextField>();
		buttons = new HashMap<String, JButton>();
		labels = new HashMap<String, JLabel>();
		radioButtons = new HashMap<String, JRadioButton>();
		sliders = new HashMap<String, JSlider>();

		JLabel name = new JLabel("What's your name?");
		labels.put("name", name);
		this.add(name);
		JTextField textField1 = new JTextField();
		textField1.setPreferredSize(
				new Dimension((this.getPreferredSize()).width / 2, textField1.getPreferredSize().height));
		textFields.put("textField1", textField1);
		this.add(textField1);
		JButton submit = new JButton("Submit");
		this.add(submit);
		submit.setVisible(true);
		JLabel welcome = new JLabel();
		labels.put("welcome", welcome);
		this.add(welcome);
		buttons.put("submit", submit);
		submit.addActionListener(drawingTool);
		drawingTool.getRootPane().setDefaultButton(submit);
		
		JButton create = new JButton("CREATE");
		create.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		buttons.put("create", create);
		create.setVisible(false);
		this.add(create);
		create.addActionListener(drawingTool);

		JLabel positionLabel = new JLabel(
				"Select your preferred positions for your ducks, either in sequential \"Traversal\" or random position \"Random\".",
				JLabel.CENTER);
		positionLabel.setPreferredSize(
				new Dimension((this.getPreferredSize()).width, positionLabel.getPreferredSize().height));
		positionLabel.setVisible(false);
		labels.put("positionLabel", positionLabel);
		this.add(positionLabel);

		JRadioButton traversal = new JRadioButton("Traversal");
		traversal.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		traversal.setToolTipText("refers to the movement or navigation in a sequence");
		JRadioButton random = new JRadioButton("Random");
		random.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		radioButtons.put("traversal", traversal);
		radioButtons.put("random", random);
		ButtonGroup buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(traversal);
		buttonGroup1.add(random);
		this.add(traversal);
		this.add(random);
		traversal.setVisible(false);
		random.setVisible(false);
		traversal.addActionListener(drawingTool);
		random.addActionListener(drawingTool);

		JLabel sizeLabel1 = new JLabel(
				"Now, select your preferred size of the ducks: manual input \"Set Size\" or random generation \"Generate Size\".",
				JLabel.CENTER);
		sizeLabel1.setPreferredSize(
				new Dimension((this.getPreferredSize()).width, sizeLabel1.getPreferredSize().height));
		sizeLabel1.setVisible(false);
		labels.put("sizeLabel1", sizeLabel1);
		this.add(sizeLabel1);

		JRadioButton setSize1 = new JRadioButton("Set Size");
		setSize1.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		JRadioButton generateSize1 = new JRadioButton("Generate Size");
		generateSize1.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		radioButtons.put("setSize1", setSize1);
		radioButtons.put("generateSize1", generateSize1);
		ButtonGroup buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(setSize1);
		buttonGroup2.add(generateSize1);
		this.add(setSize1);
		this.add(generateSize1);
		setSize1.setVisible(false);
		generateSize1.setVisible(false);
		setSize1.addActionListener(drawingTool);
		generateSize1.addActionListener(drawingTool);

		JSlider slider1 = new JSlider(10, 160, 20);
		slider1.setPaintTicks(true);
		slider1.setMajorTickSpacing(10);
		slider1.setSnapToTicks(true);
		slider1.setPaintLabels(true);
		slider1.setPreferredSize(new Dimension((int) ((this.getPreferredSize()).width * 0.9),
				slider1.getPreferredSize().height));
		slider1.addChangeListener(drawingTool);
		
		sliders.put("slider1", slider1);
		JLabel sliderLabel1 = new JLabel(
				"Slider is now set to " + slider1.getValue() + ". Click on Submit, after setting the slider.");
		labels.put("sliderLabel1", sliderLabel1);
		slider1.setVisible(false);
		sliderLabel1.setVisible(false);
		this.add(slider1);
		this.add(sliderLabel1);

		JButton submit2 = new JButton("Submit");
		submit2.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		buttons.put("submit2", submit2);
		submit2.setVisible(false);
		this.add(submit2);
		submit2.addActionListener(drawingTool);

		JLabel sizeLabel2 = new JLabel(
				"Now, select your preferred size of the ducks: manual input \"Set Size\" or random generation \"Generate Size\".",
				JLabel.CENTER);
		sizeLabel2.setPreferredSize(
				new Dimension((this.getPreferredSize()).width, sizeLabel2.getPreferredSize().height));
		sizeLabel2.setVisible(false);
		labels.put("sizeLabel2", sizeLabel2);
		this.add(sizeLabel2);

		JRadioButton setSize2 = new JRadioButton("Set Size");
		setSize2.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		JRadioButton generateSize2 = new JRadioButton("Generate Size");
		generateSize2.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		radioButtons.put("setSize2", setSize2);
		radioButtons.put("generateSize2", generateSize2);
		ButtonGroup buttonGroup3 = new ButtonGroup();
		buttonGroup3.add(setSize2);
		buttonGroup3.add(generateSize2);
		this.add(setSize2);
		this.add(generateSize2);
		setSize2.setVisible(false);
		generateSize2.setVisible(false);
		setSize2.addActionListener(drawingTool);
		generateSize2.addActionListener(drawingTool);

		JSlider slider2 = new JSlider(10, 160, 20);
		slider2.setPaintTicks(true);
		slider2.setMajorTickSpacing(10);
		slider2.setSnapToTicks(true);
		slider2.setPaintLabels(true);
		slider2.setPreferredSize(new Dimension((int) ((this.getPreferredSize()).width * 0.9),
				slider2.getPreferredSize().height));
		slider2.addChangeListener(drawingTool);
		sliders.put("slider2", slider2);
		JLabel sliderLabel2 = new JLabel(
				"Slider is now set to " + slider2.getValue() + ". Click on \"Submit\", after setting the slider.");
		labels.put("sliderLabel2", sliderLabel2);
		slider2.setVisible(false);
		sliderLabel2.setVisible(false);
		this.add(slider2);
		this.add(sliderLabel2);

		JButton submit3 = new JButton("Submit");
		submit3.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		buttons.put("submit3", submit3);
		submit3.setVisible(false);
		this.add(submit3);
		submit3.addActionListener(drawingTool);

		JLabel colorLabel1 = new JLabel("Now, select \"Black\", \"Red\", \"Yellow\", or \"Generate Color\" to change the color of the ducks",
				JLabel.CENTER);
		colorLabel1.setPreferredSize(
				new Dimension((this.getPreferredSize()).width, colorLabel1.getPreferredSize().height));
		colorLabel1.setVisible(false);
		labels.put("colorLabel1", colorLabel1);
		this.add(colorLabel1);
		
		JButton black = new JButton("Black");
		black.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		buttons.put("black", black);
		black.setVisible(false);
		this.add(black);
		black.addActionListener(drawingTool);
		
		JButton red = new JButton("Red");
		red.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		buttons.put("red", red);
		red.setVisible(false);
		this.add(red);
		red.addActionListener(drawingTool);
		
		JButton yellow = new JButton("Yellow");
		yellow.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		buttons.put("yellow", yellow);
		yellow.setVisible(false);
		this.add(yellow);
		yellow.addActionListener(drawingTool);
		
		JButton newColor = new JButton("Generate Color");
		newColor.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		buttons.put("newColor", newColor);
		newColor.setVisible(false);
		this.add(newColor);
		newColor.addActionListener(drawingTool);
		
		JLabel setState = new JLabel("Oh you changed your mind! Choose one of these states.",
				JLabel.CENTER);
		setState.setPreferredSize(
				new Dimension((this.getPreferredSize()).width, setState.getPreferredSize().height));
		setState.setVisible(false);
		labels.put("setState", setState);
		this.add(setState);
		
		JButton organize = new JButton("Organize");
		organize.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		buttons.put("organize", organize);
		organize.setVisible(false);
		this.add(organize);
		organize.addActionListener(drawingTool);
		
		JButton randomState = new JButton("Random");
		randomState.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		buttons.put("randomState", randomState);
		randomState.setVisible(false);
		this.add(randomState);
		randomState.addActionListener(drawingTool);
		
		JButton remove = new JButton("Remove");
		remove.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		buttons.put("remove", remove);
		remove.setVisible(false);
		this.add(remove);
		remove.addActionListener(drawingTool);
		
		JLabel lastLabel = new JLabel("Thank you for creating your scene. Now select on \"End\" to close the application.",
				JLabel.CENTER);
		lastLabel.setPreferredSize(
				new Dimension((this.getPreferredSize()).width, lastLabel.getPreferredSize().height));
		lastLabel.setVisible(false);
		labels.put("lastLabel", lastLabel);
		this.add(lastLabel);
		
		JButton end = new JButton("End");
		end.setPreferredSize(
				new Dimension(submit.getPreferredSize().width * 2, submit.getPreferredSize().height * 2));
		buttons.put("end", end);
		end.setVisible(false);
		this.add(end);
		end.addActionListener(drawingTool);
	}
	
	public HashMap<String, JTextField> getTextFields() {
		return textFields;
	}
	
	public HashMap<String, JButton> getButtons() {
		return buttons;
	}
	
	public HashMap<String, JLabel> getLabels() {
		return labels;
	}
	
	public HashMap<String, JRadioButton> getRadioButtons() {
		return radioButtons;
	}
	
	public HashMap<String, JSlider> getSliders() {
		return sliders;
	}
}
