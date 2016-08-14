package com.xwray.passwordviewsample;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.xwray.passwordview.PasswordView;

import static android.support.v7.app.AppCompatDelegate.MODE_NIGHT_NO;
import static android.support.v7.app.AppCompatDelegate.MODE_NIGHT_YES;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PasswordView passwordView = (PasswordView) findViewById(R.id.password);
        TextInputLayout passwordViewTIL = (TextInputLayout) findViewById(R.id.password_til);

        PasswordView passwordViewWithStrikeThrough = (PasswordView) findViewById(R.id.password_strike);
        TextInputLayout passwordViewWithStrikeThroughTIL = (TextInputLayout) findViewById(R.id.password_strike_til);

        Typeface roboto = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        passwordView.setTypeface(roboto);
        passwordViewTIL.setTypeface(roboto);
        passwordViewWithStrikeThrough.setTypeface(roboto);
        passwordViewWithStrikeThroughTIL.setTypeface(roboto);
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = getTheme();
        theme.resolveAttribute(R.attr.colorControlNormal, typedValue, true);
        int color = ContextCompat.getColor(this, typedValue.resourceId);

        MenuItem themeItem = menu.findItem(R.id.theme);
        Drawable drawable = DrawableCompat.wrap(themeItem.getIcon());
        DrawableCompat.setTint(drawable, color);
        themeItem.setIcon(drawable);

        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.theme) {
            if (AppCompatDelegate.getDefaultNightMode() != MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO);
            }
            recreate();
        }
        return super.onOptionsItemSelected(item);
    }
}
