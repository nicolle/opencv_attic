package org.opencv.samples.imagemanipulations;

import org.opencv.android.OpenCVLoader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class ImageManipulationsActivity extends Activity {
    private static final String TAG = "Sample::Activity";

    public static final int     VIEW_MODE_RGBA  = 0;
    public static final int     VIEW_MODE_HIST  = 1;
    public static final int     VIEW_MODE_CANNY = 2;
    public static final int     VIEW_MODE_SEPIA = 3;
    public static final int     VIEW_MODE_SOBEL = 4;
    public static final int     VIEW_MODE_ZOOM  = 5;
    public static final int     VIEW_MODE_PIXELIZE  = 6;
    public static final int     VIEW_MODE_POSTERIZE  = 7;

    private MenuItem            mItemPreviewRGBA;
    private MenuItem            mItemPreviewHist;
    private MenuItem            mItemPreviewCanny;
    private MenuItem            mItemPreviewSepia;
    private MenuItem            mItemPreviewSobel;
    private MenuItem            mItemPreviewZoom;
    private MenuItem            mItemPreviewPixelize;
    private MenuItem            mItemPreviewPosterize;

    public static int           viewMode = VIEW_MODE_RGBA;

    public ImageManipulationsActivity() {
        Log.i(TAG, "Instantiated new " + this.getClass());
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (OpenCVLoader.initStatic())
        {
        	setContentView(new ImageManipulationsView(this));
        }
        else
        {
			Log.e(TAG, "OpenCV loading failed!");
			finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(TAG, "onCreateOptionsMenu");
        mItemPreviewRGBA  = menu.add("Preview RGBA");
        mItemPreviewHist  = menu.add("Histograms");
        mItemPreviewCanny = menu.add("Canny");
        mItemPreviewSepia = menu.add("Sepia");
        mItemPreviewSobel = menu.add("Sobel");
        mItemPreviewZoom  = menu.add("Zoom");
        mItemPreviewPixelize  = menu.add("Pixelize");
        mItemPreviewPosterize = menu.add("Posterize");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(TAG, "Menu Item selected " + item);
        if (item == mItemPreviewRGBA)
            viewMode = VIEW_MODE_RGBA;
        if (item == mItemPreviewHist)
            viewMode = VIEW_MODE_HIST;
        else if (item == mItemPreviewCanny)
            viewMode = VIEW_MODE_CANNY;
        else if (item == mItemPreviewSepia)
            viewMode = VIEW_MODE_SEPIA;
        else if (item == mItemPreviewSobel)
            viewMode = VIEW_MODE_SOBEL;
        else if (item == mItemPreviewZoom)
            viewMode = VIEW_MODE_ZOOM;
        else if (item == mItemPreviewPixelize)
            viewMode = VIEW_MODE_PIXELIZE;
        else if (item == mItemPreviewPosterize)
            viewMode = VIEW_MODE_POSTERIZE;
        return true;
    }
}
