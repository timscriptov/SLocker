/*
 * Copyright (C) 2018 Тимашков Иван
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.vkontakte;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ProgressBar;

//##################################################################
/**
 * @since 21.09.2018
 * @author Тимашков Иван
 * @author https://github.com/TimScriptov
 */
public class CustomProgressBar extends ProgressBar
//##################################################################
	{

		Paint mPaint;
		String text;
//===================================================================
		public CustomProgressBar ( Context context )
//===================================================================
			{
				super ( context );
				initText ( );
			}//CustomProgressBar
//===================================================================
		public CustomProgressBar ( Context context, AttributeSet attributeSet )
//===================================================================
			{
				super ( context, attributeSet );
				initText ( );
			}//CustomProgressBar
//===================================================================
		public CustomProgressBar ( Context context, AttributeSet attributeSet, int i )
//===================================================================
			{
				super ( context, attributeSet, i );
				initText ( );
			}//CustomProgressBar
//===================================================================
		public static int getScreenHeight ( Activity activity )
//===================================================================
			{
				DisplayMetrics displayMetrics = new DisplayMetrics ( );
				activity.getWindowManager ( ).getDefaultDisplay ( ).getMetrics ( displayMetrics );
				return displayMetrics.heightPixels;
			}//getScreenHeight
//===================================================================
		public static int getScreenWidth ( Activity activity )
//===================================================================
			{
				DisplayMetrics displayMetrics = new DisplayMetrics ( );
				activity.getWindowManager ( ).getDefaultDisplay ( ).getMetrics ( displayMetrics );
				return displayMetrics.widthPixels;
			}//getScreenWidth
//===================================================================
		private void initText ( )
//===================================================================
			{
				this.mPaint = new Paint ( );
				this.mPaint.setColor ( SupportMenu.CATEGORY_MASK );
				if ( getResources ( ).getDisplayMetrics ( ).widthPixels > 480 )
					{
						this.mPaint.setTextSize ( (float) 36 );
					}
				else
					{
						this.mPaint.setTextSize ( (float) 18 );
					}
			}//initText
//===================================================================
		private void setText ( int i )
//===================================================================
			{
				this.text =
					new StringBuffer ( ).append ( String.valueOf ( ( i * 100 ) / getMax ( ) ) ).append ( "%" ).toString ( );
			}//setText
//===================================================================
		@Override protected void onDraw ( Canvas canvas )
//===================================================================
			{
				synchronized ( this )
					{
						super.onDraw ( canvas );
						Rect rect = new Rect ( );
						this.mPaint.getTextBounds ( this.text, 0, this.text.length ( ), rect );
						canvas.drawText ( this.text, (float) ( ( getWidth ( ) / 2 ) - rect.centerX ( ) ),
										 (float) ( ( getHeight ( ) / 2 ) - rect.centerY ( ) ), this.mPaint );
					}
			}//onDraw
//===================================================================
		@Override public void setProgress ( int i )
//===================================================================
			{
				synchronized ( this )
					{
						setText ( i );
						super.setProgress ( i );
					}
			}//setProgress
//===================================================================
	}//CustomProgressBar
//##################################################################
