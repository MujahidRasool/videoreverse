package com.video.editor.makevideo.videoeditor.videotogif;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.arthenica.mobileffmpeg.Config;
import com.arthenica.mobileffmpeg.FFmpeg;

import static com.arthenica.mobileffmpeg.Config.RETURN_CODE_CANCEL;
import static com.arthenica.mobileffmpeg.Config.RETURN_CODE_SUCCESS;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TTAAGG";

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//        Intent intent = new Intent();
//        intent.setType("video/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent, "Select Video"), 123);





        int rc = FFmpeg.execute("-i /sdcard/Movies/aa.mp4 -vf reverse /sdcard/Movies/aa2.mp4");


        if (rc == RETURN_CODE_SUCCESS) {
            Log.i(Config.TAG, "Command execution completed successfully.");


        } else if (rc == RETURN_CODE_CANCEL) {
            Log.i(Config.TAG, "Command execution cancelled by user.");
        } else {
            Log.i(Config.TAG, String.format("Command execution failed with rc=%d and the output below.", rc));
            Config.printLastCommandOutput(Log.INFO);
        }

        // ffmpeg -version


//        int rc = FFmpeg.execute("-i /sdcard/Cardboard/a.mp4");

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(resultCode, 123, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 123) {
                Uri selectedImageUri = data.getData();
                String filemanagerstring = selectedImageUri.getPath();

                int rc = FFmpeg.execute("-ss 30 -t 3 -i "+filemanagerstring+" -vf \"fps=10,scale=320:-1:flags=lanczos,split[s0][s1];[s0]palettegen[p];[s1][p]paletteuse\" -loop 0 output.gif");

                if (rc == RETURN_CODE_SUCCESS) {
                    Log.i(Config.TAG, "Command execution completed successfully.");


                } else if (rc == RETURN_CODE_CANCEL) {
                    Log.i(Config.TAG, "Command execution cancelled by user.");
                } else {
                    Log.i(Config.TAG, String.format("Command execution failed with rc=%d and the output below.", rc));
                    Config.printLastCommandOutput(Log.INFO);
                }

            }
        }
    }
}
