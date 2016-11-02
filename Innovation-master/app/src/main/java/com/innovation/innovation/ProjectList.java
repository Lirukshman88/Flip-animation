package com.innovation.innovation;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProjectList extends Activity{
    String[] mTestArray;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_project_list);

            mTestArray = getResources().getStringArray(R.array.Projects);


            ListView listView = (ListView) findViewById(R.id.list);

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mTestArray);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Goes to the project activity with the position number of the list
                    Intent intent = new Intent(ProjectList.this, FlipListContent.class);
                    intent.putExtra("key", (position));
                    startActivity(intent);
                }
            });

}
}