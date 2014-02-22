/**
 * Nyan Cat character
 * 
 * @author Lars Harmsen
 * Copyright (c) <2014> <Lars Harmsen - Quchen>
 * 
 * Nyan Cat was drawn by Christopher Torres and momo momo remixed the music by daniwell
 */

package com.paul0.nyamcat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.paul0.nyamcat.R;

public class NyanCat extends PlayableCharacter {
	
	/** Static bitmap to reduce memory usage */
	public static Bitmap globalBitmap;
	
	/** The rainbow tail behind the cat */
	private Rainbow rainbow;
	
	public NyanCat(GameView view, Game game) {
		super(view, game);
		if(globalBitmap == null){
			globalBitmap = createBitmap(game.getResources().getDrawable(R.drawable.nyan_cat));
		}
		this.bitmap = globalBitmap;
		this.width = this.bitmap.getWidth();
		this.height = this.bitmap.getHeight()/2;
		this.y = game.getResources().getDisplayMetrics().heightPixels / 2;
		
		this.rainbow = new Rainbow(view, game);
	}
	
	/**
	 * Moves itself via super.move
	 * and moves the rainbow and manages its frames
	 */
	@Override
	public void move(){
		super.move();
		
		if(rainbow != null){
			
			// move rainbow
			rainbow.y = this.y;
			rainbow.x = this.x - rainbow.width;
			rainbow.move();
			
			// manage frames of the rainbow
			if(speedY > getTabSpeed() / 3 && speedY < getMaxSpeed() * 1/3){
				rainbow.row = 0;
			}else if(speedY > 0){
				rainbow.row = 1;
			}else{
				rainbow.row = 2;
			}
		}
	}

	/**
	 * Draws itself via super.draw
	 * and the rainbow.
	 */
	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		if(rainbow != null){
			rainbow.draw(canvas);
		}
	}

	/**
	 * Calls super.dead,
	 * removes the rainbow tail
	 * and set the bitmapframe to a dead cat -.-
	 */
	@Override
	public void dead() {
		super.dead();
		rainbow = null;
		this.row = 1;
		
		// Maybe an explosion
	}

}
