package de.mulaschnick.hallo;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: iluvatar
 * Date: 02.11.12
 * Time: 01:01
 * To change this template use File | Settings | File Templates.
 */
public class ListDialog extends DialogFragment
{
    private static final String TAG = DialogFragment.class.getSimpleName();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.listDialog)
        .setItems(R.array.listDialogOptions, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Log.i(TAG, "Habe ich geklickt " + which);
            }
        });

        Log.i(TAG, "Toller Dialog");
        return builder.create();
    }
}
