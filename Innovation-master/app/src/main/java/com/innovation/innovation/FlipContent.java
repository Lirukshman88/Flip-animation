package com.innovation.innovation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import se.emilsjolander.flipview.FlipView;
import se.emilsjolander.flipview.OverFlipMode;

/**
 * Created by liruk on 2016-10-29.
 */

public class FlipContent extends AppCompatActivity implements FlipAdapter.Callback, FlipView.OnFlipListener, FlipView.OnOverFlipListener {

    private FlipView mFlipView;
    private FlipAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_flip);

        mFlipView = (FlipView) findViewById(R.id.flip_view);
        mAdapter = new FlipAdapter(this);
        mFlipView.setAdapter(mAdapter);
        mFlipView.setOnFlipListener(this);
        mFlipView.peakNext(false);
        mFlipView.setOverFlipMode(OverFlipMode.RUBBER_BAND);
        mFlipView.setEmptyView(findViewById(R.id.empty_view));
        mFlipView.setOnOverFlipListener(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }

    public void onPageRequested(int page) {
        mFlipView.smoothFlipTo(page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activities, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Intent intent = new Intent(this, ProjectList.class);
                    startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFlippedToPage(FlipView v, int position, long id) {
        Log.i("pageflip", "Page: "+position);

        if(position > mFlipView.getPageCount()-3 && mFlipView.getPageCount()<30){
            mAdapter.addItems(5);
        }
    }

    @Override
    public void onOverFlip(FlipView v, OverFlipMode mode,
                           boolean overFlippingPrevious, float overFlipDistance,
                           float flipDistancePerPage) {
        Log.i("overflip", "overFlipDistance = "+overFlipDistance);
    }
}