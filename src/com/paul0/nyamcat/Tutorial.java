/**
 * The tutorial that says you should tap
 * 
 * @author Lars Harmsen
 * Copyright (c) <2014> <Lars Harmsen - Quchen>
 */

package com.paul0.nyamcat;

import android.graphics.Bitmap;
import com.paul0.nyamcat.R;

public class Tutorial extends Sprite {
	public static Bitmap globalBitmap;

	public Tutorial(GameView view, Game game) {
		super(view, game);
		if(globalBitmap == null){
			globalBitmap = createBitmap(game.getResources().getDrawable(R.drawable.tutorial));
		}
		this.bitmap = globalBitmap;
		this.width = this.bitmap.getWidth();
		this.height = this.bitmap.getHeight();
	}

	/**
	 * Sets the position to the center of the view.
	 */
	@Override
	public void move() {
		this.x = view.getWidth() / 2 - this.width / 2;
		this.y = view.getHeight() / 2 - this.height / 2;
	}

}
