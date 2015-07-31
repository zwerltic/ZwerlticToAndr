package com.toreo.torero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class AvisoPrivacidad extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aviso_privacidad);
        final Intent receivingIntent = getIntent();
        final Button send = (Button) this.findViewById(R.id.ButtonAceptarAviso);
        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent sendingIntent = new Intent(AvisoPrivacidad.this, Pagar.class);
                sendingIntent.putExtra("name", receivingIntent.getExtras().getString("name"));
                sendingIntent.putExtra("last", receivingIntent.getExtras().getString("last"));
                sendingIntent.putExtra("street", receivingIntent.getExtras().getString("street"));
                sendingIntent.putExtra("number", receivingIntent.getExtras().getString("number"));
                sendingIntent.putExtra("colonia", receivingIntent.getExtras().getString("colonia"));
                sendingIntent.putExtra("delegacion", receivingIntent.getExtras().getString("delegacion"));
                sendingIntent.putExtra("juzgado", receivingIntent.getExtras().getString("juzgado"));
                startActivity(sendingIntent);


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_aviso_privacidad, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}