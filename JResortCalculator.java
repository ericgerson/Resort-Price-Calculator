//filename: JResortCalculator.java
//author: Eric 
//Date: 2/15/19

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JResortCalculator extends JFrame implements ItemListener
{
	//Variables and constants
	final int BASE_PRICE = 200;
	final int WEEKEND_PREMIUM = 100;
	final int BREAKFAST_PREMIUM = 20;
	final int GOLF_PREMIUM = 75;
	int totalPrice = BASE_PRICE;
	
	//Create 3 JCheckBox objects 
	JCheckBox weekendBox = new JCheckBox("Weekend premium $" + WEEKEND_PREMIUM, false);
	JCheckBox breakfastBox = new JCheckBox("Breakfast $" + BREAKFAST_PREMIUM, false);
	JCheckBox golfBox = new JCheckBox("Golf $" + GOLF_PREMIUM, false);
	
	//Create 4 JLabels and 1 JTextField object
	JLabel resortLabel = new JLabel("Resort Price Calculator");
	JLabel priceLabel = new JLabel("The price for your stay is");
	JLabel optionExplainLabel = new JLabel("Base price for a room is  $"+ BASE_PRICE + ".");
	JLabel optionExplainLabel2 = new JLabel("Check the options you want.");
	JTextField total = new JTextField(4);
	
	public JResortCalculator()
	{
		super("Resort Price Estimator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(300, 200);
		setVisible(true);
		add(resortLabel);
		add(optionExplainLabel);
		add(optionExplainLabel2);
		add(weekendBox);
		add(breakfastBox);
		add(golfBox);
		add(priceLabel);
		add(total);
		
		total.setText("$"+ totalPrice);
		weekendBox.addItemListener(this);
		breakfastBox.addItemListener(this);
		golfBox.addItemListener(this);
	}
	
	@Override
	public void itemStateChanged(ItemEvent event)
	{
		Object source = event.getSource();
		int select = event.getStateChange();
		
		if(source == weekendBox)
		{
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += WEEKEND_PREMIUM;
			}
			else
			{
				totalPrice -= WEEKEND_PREMIUM; 
			}
		}
		else
		{
			if(source == breakfastBox)
			{
				if(select == ItemEvent.SELECTED)
				{
					totalPrice +=BREAKFAST_PREMIUM;
				}
				
				else
				{
					totalPrice -= BREAKFAST_PREMIUM; 
				}
			}
			else //it must be a (source == golfBox) by defaut
			{
				if(select == ItemEvent.SELECTED)
				{
					totalPrice +=GOLF_PREMIUM;
				}
				
				else
				{
					totalPrice -= GOLF_PREMIUM; 
				}
				
			}
		}
		
		//After all the decision-making, keep pushing the total price to the JTextField we created
		total.setText("$"+ totalPrice);
	}
	
	public static void main(String[] args)
	{
		JResortCalculator aFrame = new JResortCalculator();
	}
}