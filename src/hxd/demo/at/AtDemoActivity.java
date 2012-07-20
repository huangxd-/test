package hxd.demo.at;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AtDemoActivity extends Activity {
    /** Called when the activity is first created. */
	
    String[] city = {"shanghai","beijing","tianjing","wuhan","sichuan"};
    String[] food = {"noodle","dunpling","milk","mike","dijn"};
    
    ArrayAdapter<String> adapter,adapter1,adapter2;
    AutoCompleteTextView autoview;
    EditText text;
    Button btn1;
    Button btn2;
    Button send;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        intialView();
    }
    public void intialView(){
    	text=(EditText) findViewById(R.id.edittext);
    	text.setWidth(320);
    	text.setHeight(100);
    	
    	adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, city);
    	adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, food);
    	adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, city);
    	
    	btn1 = (Button)findViewById(R.id.button_sina);
        btn1.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v) 
			{
				adapter=adapter1;
				autoview = (AutoCompleteTextView) findViewById(R.id.autocomplete);
		    	autoview.setWidth(320);
		    	autoview.setCompletionHint("city");
		   
		    	autoview.setAdapter(adapter);
		    	
		    	autoview.setThreshold(1);// 输1个字符自动提示
		    	autoview.setVisibility(0);
		    	
		    	InputMethodManager imm = (InputMethodManager)autoview.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		    	imm.toggleSoftInput(0, InputMethodManager.RESULT_HIDDEN);
		    	
		    	text.setVisibility(8);
		    	btn1.setVisibility(8);
		    	btn2.setVisibility(8);
		    	send.setVisibility(8);
		    	
		    	autoview.setOnItemClickListener(new OnItemClickListener() //当选择一个item之后返回之前的界面
		    	{
					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3) 
					{
						// TODO Auto-generated method stub
						autoview.setVisibility(8);
						text.setVisibility(0);
						btn1.setVisibility(0);
						btn2.setVisibility(0);
						send.setVisibility(0);
						text.setText(text.getText()+" s@"+autoview.getText()+" ");
						text.setSelection(text.length());
						autoview.setText("");
					}
				});
			}
        });
        btn2 = (Button)findViewById(R.id.button_tencent);
        btn2.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v) 
			{
				adapter=adapter2;
				autoview = (AutoCompleteTextView) findViewById(R.id.autocomplete);
		    	autoview.setWidth(320);
		    	autoview.setCompletionHint("city");
		   
		    	autoview.setAdapter(adapter);
		    	
		    	autoview.setThreshold(1);// 输1个字符自动提示
		    	autoview.setVisibility(0);
		    	
		    	InputMethodManager imm = (InputMethodManager)autoview.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		    	imm.toggleSoftInput(0, InputMethodManager.RESULT_HIDDEN);
		    	
		    	text.setVisibility(8);
		    	btn1.setVisibility(8);
		    	btn2.setVisibility(8);
		    	send.setVisibility(8);
		    	
		    	autoview.setOnItemClickListener(new OnItemClickListener() //当选择一个item之后返回之前的界面
		    	{
					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3) 
					{
						// TODO Auto-generated method stub
						autoview.setVisibility(8);
						text.setVisibility(0);
						btn1.setVisibility(0);
						btn2.setVisibility(0);
						send.setVisibility(0);
						text.setText(text.getText()+" t@"+autoview.getText()+" ");
						text.setSelection(text.length());
						autoview.setText("");
					}
				});
			}
        });
        send = (Button)findViewById(R.id.button_send);
        send.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v) 
			{
				String tt=text.getText().toString();
				String[] st=tt.split(" ");
				String to = "";
				
				for(int i=0;i<st.length;i++)
				{
					String aa=st[i].trim();
					if(aa.equals(""))
					{
						
					}
					else
					{
						if(aa.length()==1)
						{
							to+=st[i];
						}
						else
						{
							if(aa.charAt(0)=='t'&&aa.charAt(1)=='@')
							{
								String tem=aa.substring(1);
								to+=tem;
								to+=" ";
							}
							else
							{
								if(aa.charAt(0)!='s'&&aa.charAt(1)!='@')
								{
									to+=st[i];
								}
							}
						}
						
					}
				}
				
				Toast.makeText(getApplicationContext(),to,Toast.LENGTH_SHORT).show();
			}
        });
    }
}