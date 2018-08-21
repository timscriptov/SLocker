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

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//##################################################################
/**
 * @since 21.09.2018
 * @author Тимашков Иван
 * @author https://github.com/TimScriptov
 */
public class EncryptFragment extends Fragment
//##################################################################
	{
		
		private CustomProgressBar myProgress;
//===================================================================
		private Handler mHandler = new Handler ( new Callback ( )
//===================================================================
				{
					@Override public boolean handleMessage ( Message message )
						{
							myProgress.setProgress ( message.what );
							return false;
						}//handleMessage
				} );//mHandler
//===================================================================
		public EncryptFragment ( )
//===================================================================
			{
			}//EncryptFragment
//===================================================================
		private void addListener ( )
//===================================================================
			{
				new Thread ( new Runnable ( ) {
							@Override public void run ( )
								{
									for ( int i = 0; i <= 49; i++ )
										{
											mHandler.sendEmptyMessage ( i * 2 );
											try
												{
													Thread.sleep ( (long) 3000 );
												}
											catch (InterruptedException e)
												{
													e.printStackTrace ( );
												}
										}
								}
						} ).start ( );
			}//addListener
//===================================================================
		@Override
		public View onCreateView ( LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle )
//===================================================================
			{
				View view = layoutInflater.inflate ( R.layout.main1, viewGroup, false );
				myProgress = view.findViewById ( R.id.pgsBar );

				addListener ( );

				return view;
			}//onCreateView
//===================================================================
	}//EncryptFragment
//##################################################################
