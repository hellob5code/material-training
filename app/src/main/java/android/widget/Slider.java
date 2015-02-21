package android.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Scroller;
import com.training.android.material.R;

public class Slider implements Runnable {

	private static final String TAG = Slider.class.getSimpleName();

	private static final boolean DEBUG = false;

	public static final int ANIMATION_REFRESH_INTERVAL = 16;

	private final Scroller scroller;

	private int lastY = 0;

	private View scrollingView;

	private View parent;

	public static final Interpolator OVERSHOOT_INTERPOLATOR = new OvershootInterpolator();
	public static final Interpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();

	public Slider(Context context, View scrollingView, View parent) {
		this(context, scrollingView, parent, DECELERATE_INTERPOLATOR);
	}

	public Slider(Context context, View scrollingView, View parent, Interpolator interpolator) {
		this.scrollingView = scrollingView;
		this.parent = parent;
		scroller = new Scroller(context, interpolator);
	}

	public synchronized void start(int initialY, int toY) {
		scroller.startScroll(0, initialY, 0, initialY - toY, 200);
		if (DEBUG) {
			Log.d(TAG, "Starting scroll " + scrollingView.toString() + " from " + initialY + " to " + toY);
		}

		lastY = initialY;
		scrollingView.postDelayed(this, ANIMATION_REFRESH_INTERVAL);
	}

	public void run() {
		if (scroller.isFinished()) {
			return;
		}

		boolean more = scroller.computeScrollOffset();
		int y = scroller.getCurrY();
		int offset = lastY - y;

		if (offset != 0) {
			scrollingView.offsetTopAndBottom(offset);
			lastY = y;
			parent.invalidate();
		}

		if (DEBUG) {
			Log.d(TAG, "Scrolling " + scrollingView.toString() + " of " + offset + "px");
		}

		if (more) {
			scrollingView.postDelayed(this, ANIMATION_REFRESH_INTERVAL);
		}
	}
}
