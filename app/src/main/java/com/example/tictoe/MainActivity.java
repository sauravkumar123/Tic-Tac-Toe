package com.example.tictoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activeplayer=0;
    boolean check=true;
    int ar[]={2,2,2,2,2,2,2,2,2};
    int tag;
    int winning[][]={{0,1,2},{0,3,6},{3,4,5},{1,4,7},{2,5,8},{6,7,8},{0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropin(View view)
    {
        ImageView counter=(ImageView) view;
        tag=Integer.parseInt(counter.getTag().toString());
        if(ar[tag]==2) {
            counter.setTranslationY(-1000f);
            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.green_heart);
                ar[tag] = 0;
                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activeplayer = 0;
                ar[tag] = 1;
            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);
            for (int winning[] : winning) {
                if (ar[winning[0]] == ar[winning[1]] && ar[winning[1]] == ar[winning[2]] && ar[winning[0]] != 2) {
                    check=false;
                    String winnerss = "CROSS";
                    if (ar[winning[0]] == 0) {
                        winnerss = "HEART";
                    }
                    TextView textView = (TextView) findViewById(R.id.textView2);
                    textView.setText(winnerss + " HAS WON!");
                    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
                    linearLayout.setVisibility(view.VISIBLE);

                } else {
                    boolean over=true;
                    for(int count:ar) {
                        if (count == 2)
                            over = false;


                        }
                        if(over)
                        {
                            TextView textView = (TextView) findViewById(R.id.textView2);
                            textView.setText("KOI NHI JEETA!");
                            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
                            linearLayout.setVisibility(view.VISIBLE);
                        }

                }
            }

        }

    }
    public  void again(View view)
    {
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.linearlayout);

        linearLayout.setVisibility(view.INVISIBLE);
        activeplayer=0;
        for(int i=0; i<ar.length;i++)
        {
            ar[i]=2;
        }
        GridLayout gridLayout=(GridLayout)findViewById(R.id.grid);
        for(int i=0;i<gridLayout.getChildCount();i++)
        {
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);


        }
    }
}
