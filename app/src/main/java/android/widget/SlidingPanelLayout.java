package android.widget;

import static android.widget.Slider.DECELERATE_INTERPOLATOR;
import static android.widget.Slider.OVERSHOOT_INTERPOLATOR;

import android.util.Log;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;


public class SlidingPanelLayout extends FrameLayout {

	private static final String TAG = SlidingPanelState.class.getSimpleName();

	public static final double INTERMEDIATE_PANEL_HEIGHT_RATIO = 0.75;

	/**
	 * The min distance to consider a movement as a swipe (in pixels).
	 */
	public static final double SWIPE_MIN_DISTANCE = 10;

	public static interface OnPanelStateChangedListener {
		void onSlidingPanelStateChanged(SlidingPanelState state);
	}

	public static enum SlidingPanelState {
		CLOSED, SMALL, INTERMEDIATE, FULL
	}

	private static enum SwipeState {
		NONE, SWIPE_UP, SWIPE_DOWN
	}

	private OnPanelStateChangedListener onPanelStateChangedListener;

	private SlidingPanelState state = SlidingPanelState.CLOSED;

	private SwipeState currentSwipeState = SwipeState.NONE;

	private float yOnLastTouch;

	private float yOnFirstTouch;

	View panel;

	View panelHeader;

	public SlidingPanelLayout(Context context) {
		super(context);
	}

	public SlidingPanelLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SlidingPanelLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void setPanelView(View panelView) {
		panel = panelView;
		panel.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return onTouchPanel(event);
			}
		});
	}

	public void setPanelHeaderView(View panelHeaderView) {
		panelHeader = panelHeaderView;
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
		Log.d(TAG, "onLayout(changed=" + changed + "l=" + l + "t=" + t + "r=" + r + "b=" + b + ")");

		movePanelVerticaly(getPanelTopPosition() - panel.getTop());
	}

	public SlidingPanelState getState() {
		return state;
	}

	private int getFullPanelTopPosition() {
		return 0;
	}

	public int getIntermediatePanelTopPosition() {
		return (int) (getClosePanelTopPosition() * (1 - INTERMEDIATE_PANEL_HEIGHT_RATIO));
	}

	private int getSmallPanelTopPosition() {
		return getClosePanelTopPosition() - panelHeader.getHeight();
	}

	private int getClosePanelTopPosition() {
		return getHeight();
	}

	private int getPanelTopPosition() {
		switch (this.state) {
		case CLOSED:
			return getClosePanelTopPosition();
		case SMALL:
			return getSmallPanelTopPosition();
		case INTERMEDIATE:
			return getIntermediatePanelTopPosition();
		case FULL:
			return getFullPanelTopPosition();
		}

		return 0;
	}

	private int getNavigationLayoutTopPosition() {
		switch (this.state) {
		case CLOSED:
			return getCloseNavigationLayoutTopPosition();
		case SMALL:
			return getSmallNavigationLayoutTopPosition();
		case INTERMEDIATE:
			return getFullNavigationLayoutTopPosition();
		case FULL:
			return getFullNavigationLayoutTopPosition();
		}

		return 0;
	}

	private int getOpenNavigationLayoutTopPosition() {
		return 0;
	}

	private int getFullNavigationLayoutTopPosition() {
		return 0;
	}

	private int getSmallNavigationLayoutTopPosition() {
		return getSmallPanelTopPosition() - getIntermediatePanelTopPosition();
	}

	private int getCloseNavigationLayoutTopPosition() {
		return getClosePanelTopPosition() - getIntermediatePanelTopPosition();
	}

	private void movePanelVerticaly(final int offset) {
		panel.offsetTopAndBottom(offset);
	}

	private boolean onTouchPanel(MotionEvent event) {
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			onActionDown(event);
			break;
		case MotionEvent.ACTION_MOVE:
			onActionMove(event);
			invalidate();
			break;
		case MotionEvent.ACTION_UP:
			onActionUp();
			break;
		}

		return true;
	}

	private void onActionDown(MotionEvent event) {
		yOnFirstTouch = event.getRawY();
		yOnLastTouch = yOnFirstTouch;
	}

	private void onActionMove(MotionEvent event) {
		float currentYTouch = event.getRawY();
		int offsetSinceLastTouch = (int) (currentYTouch - yOnLastTouch);

		Log.d(TAG, "onActionMove(lastYTouch=" + yOnLastTouch + ", currentYTouch=" + currentYTouch + ")");

		final int panelTopPositionAfterMoving = panel.getTop() + offsetSinceLastTouch;
		// Test if the panel will not be above the screen after moving
		if (panelTopPositionAfterMoving >= getFullPanelTopPosition()) {
			movePanelVerticaly(offsetSinceLastTouch);
		}

		computeSwipeState(yOnLastTouch, currentYTouch);

		yOnLastTouch = currentYTouch;
	}

	private void computeSwipeState(float lastYTouch, float currentYTouch) {
		if (Math.abs(lastYTouch - currentYTouch) < SWIPE_MIN_DISTANCE) {
			// The movement shouldn't be considered as a swipe, the distance between the two points is too small
			return;
		}

		if (currentYTouch < lastYTouch) {
			setSwipeState(SwipeState.SWIPE_UP);
			return;
		}

		if (currentYTouch > lastYTouch) {
			setSwipeState(SwipeState.SWIPE_DOWN);
			return;
		}
	}

	private void setSwipeState(SwipeState state) {
		if (currentSwipeState != state) {
			this.currentSwipeState = state;
			Log.d(TAG, "New SwipeState=" + currentSwipeState.toString());
		}
	}

	private void onActionUp() {
		if (Math.abs(yOnFirstTouch - yOnLastTouch) < SWIPE_MIN_DISTANCE) {
			// On Click
			onPanelClick();
		} else if (currentSwipeState == SwipeState.SWIPE_UP) {
			// On swipe up
			onPanelSwipeUp();
		} else if (currentSwipeState == SwipeState.SWIPE_DOWN) {
			// On swipe down
			onPanelSwipeDown();
		} else if (currentSwipeState == SwipeState.NONE) {
			if (yOnLastTouch < yOnFirstTouch) {
				onPanelSwipeUp();
			} else {
				onPanelSwipeDown();
			}
		}

		setSwipeState(SwipeState.NONE);
	}

	private void onPanelClick() {
		if (state == SlidingPanelState.SMALL) {
			changeSlidingPanelState(SlidingPanelState.INTERMEDIATE);
		} else {
			changeSlidingPanelState(SlidingPanelState.SMALL);
		}
	}

	private void onPanelSwipeUp() {
		if (panel.getTop() >= getSmallPanelTopPosition()) {
			// The panel is below the small panel position
			changeSlidingPanelState(SlidingPanelState.SMALL);
		} else if (panel.getTop() >= getIntermediatePanelTopPosition()) {
			// The panel is below the intermediate panel position
			changeSlidingPanelState(SlidingPanelState.INTERMEDIATE);
		} else {
			// The panel is above the intermediate panel position
			changeSlidingPanelState(SlidingPanelState.FULL);
		}
	}

	private void onPanelSwipeDown() {
		if (panel.getTop() <= getIntermediatePanelTopPosition()) {
			// The panel is above the intermediate panel position
			changeSlidingPanelState(SlidingPanelState.INTERMEDIATE);
		} else if (panel.getTop() <= getSmallPanelTopPosition()) {
			// The panel is above the small panel position
			changeSlidingPanelState(SlidingPanelState.SMALL);
		} else {
			changeSlidingPanelState(SlidingPanelState.CLOSED);
		}
	}

	public void changeSlidingPanelState(SlidingPanelState state) {
		switch (state) {
		case SMALL:
			openSmallPanel();
			break;
		case INTERMEDIATE:
			openIntermediatePanel();
			break;
		case FULL:
			openFullPanel();
			break;
		default:
			closePanel();
			break;
		}

		dispatchPanelStateChanged(state);
	}

	private void openFullPanel() {
		int toY = getFullPanelTopPosition();
		Log.d(TAG, "Openning Full Panel [from=" + panel.getTop() + " toY=" + toY + "]");

		slidePanel(toY, DECELERATE_INTERPOLATOR);
	}

	private void openIntermediatePanel() {
		int toY = getIntermediatePanelTopPosition();
		Log.d(TAG, "Openning Intermediate Panel [from=" + panel.getTop() + " toY=" + toY + "]");

		slidePanel(toY, DECELERATE_INTERPOLATOR);
	}

	private void openSmallPanel() {
		int toY = getSmallPanelTopPosition();
		Log.d(TAG, "Openning Bottom Panel [from=" + panel.getTop() + " toY=" + toY + "]");
		
		Interpolator interpolator;
		if (panel.getTop() > toY)
			interpolator = OVERSHOOT_INTERPOLATOR;
		else
			interpolator = DECELERATE_INTERPOLATOR;

		slidePanel(toY, interpolator);
	}

	private void closePanel() {
		int toY = getClosePanelTopPosition();
		Log.d(TAG, "Closing Panel [from=" + panel.getTop() + " toY=" + toY + "]");

		slidePanel(toY, DECELERATE_INTERPOLATOR);
	}

	private void slidePanel(int toY, Interpolator interpolator) {
		Slider slider = new Slider(getContext(), panel, this, interpolator);
		slider.start(panel.getTop(), toY);
	}

	private void dispatchPanelStateChanged(final SlidingPanelState newState) {
		// Wait until the slider animation is finished
		postDelayed(new Runnable() {

			@Override
			public void run() {
				if (state == newState)
					return;

				state = newState;
				if (onPanelStateChangedListener != null) {
					onPanelStateChangedListener.onSlidingPanelStateChanged(newState);
				}
			}
		}, 200);
	}

	public void setOnPanelStateChangedListener(OnPanelStateChangedListener listener) {
		this.onPanelStateChangedListener = listener;
	}
}