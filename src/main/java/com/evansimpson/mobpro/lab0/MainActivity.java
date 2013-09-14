package com.evansimpson.mobpro.lab0;

import android.content.Intent;
    import android.os.Bundle;
    import android.app.Activity;
    import android.view.Menu;
    import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

        ArrayList<String> taskList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            final EditText editText = (EditText) findViewById(R.id.editText);
            taskList = new ArrayList<String>();
            ListView lv = (ListView) findViewById(R.id.listView);

            final ArrayAdapter<String> arrayAdapter =
                    new ArrayAdapter<String> (this,R.layout.list_view, taskList){
                        @Override
                        public View getView(final int position, View convertView, ViewGroup parent) {
                            View view = View.inflate(MainActivity.this, R.layout.list_view, null);
                            final TextView textView = (TextView) view.findViewById(R.id.textrow);
                            final Button deleteButton = (Button) view.findViewById(R.id.delete);
                            textView.setText(getItem(position));
                            deleteButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    remove(getItem(position));
                                }
                            });
                            return view;
                        }
                    };
            lv.setAdapter(arrayAdapter);
            Button b = (Button) findViewById(R.id.button); // creates a button b and attaching it to the UI element called button1 on the view
            b.setOnClickListener(new View.OnClickListener() { // creates and sets an onClickListener for the button b
                @Override
                public void onClick(View view) { // creates the onClick method for the listener, which controls what is done when the button is clicked
                    String taskText = editText.getText().toString();
                    arrayAdapter.add(taskText);
                    editText.setText("");
                }
            });
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

    }
