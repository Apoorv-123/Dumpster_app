package com.example.dumpsternew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.text.DecimalFormat;

public class Splash extends AppCompatActivity {
    private TextView mValueView_1;
    private TextView mValueView_2;
    private TextView mValueView_3;
    private TextView mValueView_4;
    private TextView mValueView_5;
    private TextView mValueView_6;
    private Firebase mRef_1;
    private Firebase mref_2;
    private Firebase mRef_3;
    private Firebase mRef_4;
    private Firebase mref_5;
    private Firebase mref_6;
    private ImageButton mButton_1;
    private ImageButton mButton_2;
    private Button mReset_1;
    private Button mReset_2;
    float count_1=0;
    float count_2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_splash );
        mValueView_1 = (TextView) findViewById ( R.id.TextView4 );
        mValueView_2 = (TextView) findViewById ( R.id.TextView8 );
        mValueView_3 = (TextView) findViewById ( R.id.TextView6 );
        mValueView_4 = (TextView) findViewById ( R.id.TextView10 );
        mValueView_5 = (TextView) findViewById ( R.id.textView9 );
        mValueView_6 = (TextView) findViewById ( R.id.textView10 );
        mReset_1=(Button) findViewById ( R.id.button1 ) ;
        mReset_2=(Button) findViewById ( R.id.button2 ) ;
        mRef_1 = new Firebase ( "https://dumpster-4b922.firebaseio.com/Dustbin_1" );
        mref_2 = new Firebase ( "https://dumpster-4b922.firebaseio.com/Dustbin_2" );
        mref_5=new Firebase ( "https://dumpster-4b922.firebaseio.com/ir1" );
        mref_6=new Firebase ( "https://dumpster-4b922.firebaseio.com/ir2" );
        mRef_3 = new Firebase ( "https://dumpster-4b922.firebaseio.com/" );
        mRef_4 = new Firebase ( "https://dumpster-4b922.firebaseio.com/" );
        mButton_1 = (ImageButton) findViewById ( R.id.imageButton1 );
        mButton_1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                openActivity_1 ();
            }
        } );
        mButton_2 = (ImageButton) findViewById ( R.id.imageButton2 );
        mButton_2.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                openActivity_2 ();
            }
        } );

        mRef_1.addValueEventListener ( new ValueEventListener () {



            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {

                String value_1 = dataSnapshot.getValue ( String.class );
                Float Distance_1 = Float.valueOf ( value_1 );
                float percent_1 = ((Distance_1) / 35) * 100;
                if (percent_1>98&&percent_1<104) {
                    getValue_1 ();
                } else {
                    DecimalFormat num = new DecimalFormat ( "#.0" );
                    mValueView_1.setText ( "" + num.format ( percent_1 ) );
                }
                mReset_1.setOnClickListener ( new View.OnClickListener () {

                    @Override
                    public void onClick(View v) {
                        count_1 =0;
                        Firebase mRefChild = mRef_3.child ( "count_1" );
                        mRefChild.setValue ( "" + count_1 );
                        mValueView_3.setText ( "" + count_1 );
                    }
                } );
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        } );
        mref_2.addValueEventListener ( new ValueEventListener () {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value_2 = dataSnapshot.getValue ( String.class );
                Float Distance_2 = Float.valueOf ( value_2 );
                float percent_2 = ((Distance_2) / 35) * 100;
                if (percent_2 >98&&percent_2<104) {
                    getValue_2 ();
                }else
                {
                    DecimalFormat num_2 = new DecimalFormat ( "#.0" );
                    mValueView_2.setText ( "" + num_2.format ( percent_2 ) );
                }
                mReset_2.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        count_2=0;
                        Firebase mRefChild = mRef_4.child ( "count_2" );
                        mRefChild.setValue ( "" + count_2 );
                        mValueView_4.setText ( "" + count_2 );
                    }
                } );
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        } );
    }
public void getValue_1(){
        mref_5.addValueEventListener ( new ValueEventListener () {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String ir_1 = dataSnapshot.getValue ( String.class );
                Float irDist_1 = Float.valueOf ( ir_1 );
                if(irDist_1==1.0)
                {
                    count_1++;
                    if(count_1==10)
                    {
                        mValueView_5.setText ( "Reminder" );
                    }
                    mValueView_1.setText ( "100" );
                    Firebase mRefChild = mRef_3.child ( "count_1" );
                    mRefChild.setValue ( "" + count_1 );
                    mValueView_3.setText ( "" + count_1 );
                    //System.out.println("count_1: "+count_1);



                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        } );
}
    public void getValue_2() {
        mref_6.addValueEventListener ( new ValueEventListener () {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String ir_2 = dataSnapshot.getValue ( String.class );
                Float irDist_2 = Float.valueOf ( ir_2 );
                if (irDist_2 == 1.0) {
                    count_2++;
                    if(count_2==10)
                    {
                        mValueView_6.setText ( "Reminder" );
                    }
                    mValueView_1.setText ( "100" );
                    Firebase mRefChild = mRef_4.child ( "count_2" );
                    mRefChild.setValue ( "" + count_2 );
                    mValueView_4.setText ( "" + count_2 );
                    //System.out.println("count_1: "+count_1);


                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        } );
    }

    public void openActivity_1() {
        Intent intent_1 = new Intent ( this, Activity_1.class );
        startActivity ( intent_1 );
    }

    public void openActivity_2() {
        Intent intent_2 = new Intent ( this, Activity_2.class );
        startActivity ( intent_2 );
    }
    }

