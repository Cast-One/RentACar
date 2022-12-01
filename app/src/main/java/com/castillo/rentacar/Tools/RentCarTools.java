package com.castillo.rentacar.Tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.aidev.generictoast.GenericToast;
import com.castillo.rentacar.R;

import java.util.Date;
import java.util.Locale;

public class RentCarTools {
    private final Context context;
    public RentCarTools(Context context) {
        this.context = context;
    }

    public void nextActivity(Class nextActivity){
        try {
            Activity activity = (Activity)context;
            Intent intent = new Intent(context, nextActivity);
            activity.startActivity(intent);
        }catch(Exception e){
            System.out.println("ERRROR------");
            e.getLocalizedMessage();
        }
    }

    public void nextActivityFinish(Class nextActivity){
        try {
            Activity activity = (Activity) context;
            Intent intent = new Intent(context, nextActivity);
            activity.startActivity(intent);
            activity.finish();
        }catch(Exception ignored){}
    }

    public boolean emptyField(EditText editText){
        if (editText.getText().toString().isEmpty()){
            InputMethodManager inputMethodManager = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInputFromWindow(editText.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
            editText.requestFocus();
            return true;
        }

        return false;
    }

    public void openFragment(Integer id_frame, Fragment fragment, FragmentTransaction transaction) {
        transaction.setCustomAnimations(R.anim.fadein, R.anim.fadein, R.anim.fadeout, R.anim.fadeout);
        transaction.replace(id_frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void showToas(String message, String styleGeneric){
        GenericToast.
                showToast(context,          //activity
                        message,    //message
                        GenericToast.LENGTH_SHORT,   //duration
                        styleGeneric, 	      //type
                        GenericToast.DARK, 	      //mode
                        GenericToast.DEFAULT_FONT,      //title font
                        GenericToast.DEFAULT_FONT); //message font
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public static String dateToString(Date date) {
        final String SDF_FORMAT = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(SDF_FORMAT, Locale.getDefault());
        return sdf.format(date);
    }
}
