package com.example.randomnumbergenerator;

import java.util.Arrays;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RNG extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rng);
    }
    public void calculate(View v){
    	TextView answer=(TextView)findViewById(R.id.textView4);
    	EditText number1text = (EditText)findViewById (R.id.editText1);
    	EditText number2text = (EditText)findViewById (R.id.editText2);
    	EditText number3text = (EditText)findViewById (R.id.editText3);
    	
    	if((number1text.getText().toString().compareTo("") == 0	)||(number2text.getText().toString().compareTo("") == 0	)||(number3text.getText().toString().compareTo("") == 0	))
    		answer.setText("You have left 1 or more of the required fields blank");
    	else{	
    	Integer num1=Integer.parseInt(number1text.getText().toString()),num2=Integer.parseInt(number2text.getText().toString()), num3=Integer.parseInt(number3text.getText().toString());
    	if(num2<num1)
    		answer.setText("You have set the \"Highest Possible Number\" lower then the \"Lowest Possible \"Number");
    	else{
    	int rows= num2-num1+1;
    	
    	answer.setText("");
    	int[][] gen = new int[2][rows];
    	int[] nums = new int[num3];
    	answer.append("Number    Number of times Generated\n");
    	for(int i =0; i<rows;i++)
    	{
    		gen[0][i] = num1+i;
    	}
    	for(int i =0; i<num3;i++)
    	{
    		nums[i] = (int)((Math.random()*(rows))+num1);
    	}
    	for(int i=0;i<num3;i++)
    	{
    		for(int x=0;x<rows;x++)
    		{
    		if(nums[i]==gen[0][x])
    			gen[1][x]= gen[1][x]+1;
    		}
    	}
    	for(int i=0; i<rows;i++)
    	{
    		for(int p=0; p<2;p++)
    		{
    			if(gen[1][i]!=0)
    			answer.append("   "+gen[p][i]+"            ");	
    		}
    		if(gen[1][i]!=0)
    		answer.append("\n");
    	}
    	answer.append("Numbers Generated: ");
    	for(int i=0;i<num3;i++)
    	{
    		answer.append(""+nums[i]);
    		if(i!=(num3-1))
    		answer.append(" ,");
    	}
    	}
    	}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rng, menu);
        return true;
    }
    
}
