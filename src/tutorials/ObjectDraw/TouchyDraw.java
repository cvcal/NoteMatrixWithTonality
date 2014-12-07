package tutorials.ObjectDraw;

import objectdraw.*;


/**
 * A first Java/objectdraw example.
 * From Bruce, Danyluk, Murtagh, 2007, Chapter 1.
 *
 * $Id: objectdraw.tex 1502 2011-01-24 20:58:17Z terescoj $
 */
public class TouchyDraw extends WindowController {
	/* 
	 * This method will execute when someone clicks on the window.
	 * It will result in a message being displayed.
	 */
	public void onMousePress(Location point) {
		new Text("I’m touched", 40, 50, canvas);
	}
	
	/* This method will execute when the mouse button is released.
	 * It will remove everything drawn in the window, which in this
	 * case can only be the text message displayed by the above.
	 */
	public void onMouseRelease(Location point) {
		canvas.clear();
	}
}
