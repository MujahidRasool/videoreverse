# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#
#
#
#
#       Intent intent = new Intent();
#        intent.setType("video/*");
#        intent.setAction(Intent.ACTION_GET_CONTENT);
#        startActivityForResult(Intent.createChooser(intent, "Select Video"), 123);
#
#        videoView = findViewById(R.id.videoView2);
#
#
#    }
#
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(resultCode, 123, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 123) {
                Uri selectedImageUri = data.getData();
                String filemanagerstring = selectedImageUri.getPath();


            }
        }