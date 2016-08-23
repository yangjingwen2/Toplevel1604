package com.androidxx.yangjw.day37_okhttp_upload;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "androidxx";
    private Button mUploadButton;
    private Button mChooseImageBtn;
    private ImageView mShowImageView;

    private OkHttpClient okHttpClient = new OkHttpClient();
    private byte[] imageBytes;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUploadButton = (Button) findViewById(R.id.upload_submit_btn);
        mChooseImageBtn = (Button) findViewById(R.id.upload_choose_image_btn);
        mShowImageView = (ImageView) findViewById(R.id.upload_imageview);
        mUploadButton.setOnClickListener(this);
        mChooseImageBtn.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("客官请骚等~");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.upload_choose_image_btn:
                openGallary();
                break;
            case R.id.upload_submit_btn:
                upload();
                break;
        }
    }

    /**
     * 进行图片上传
     */
    private void upload() {
        progressDialog.show();
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        //执行传递的方式
        multipartBuilder.setType(MultipartBody.FORM);
        /**
         * 参数1：上传的key。key：value
         * 参数2：上传到服务器上的文件的名称
         * 参数3：通过RequestBody对文件流字节数组进行封装
         */
        MediaType type = MediaType.parse("image/*");
        Log.i(TAG, "upload: " + imageBytes.length);
        RequestBody requestBody = RequestBody.create(type, imageBytes);
        multipartBuilder.addFormDataPart("upload","abc.jpg",requestBody);
        MultipartBody multipartBody = multipartBuilder.build();

        Request request = new Request.Builder()
                .url("http://192.168.59.173:8080/WebServer/upload.do")
                .post(multipartBody) //传值
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG, "onResponse: " + response.body().string());
                progressDialog.dismiss();
                response.close();
            }
        });
    }

    /**
     * 打开相册
     */
    private void openGallary() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "onActivityResult: " + data.getData());
        Uri uri = data.getData();
        try {
            InputStream inputStream = getContentResolver().openInputStream(uri);

            int len = 0;
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer,0,len);
            }
            baos.flush();
            imageBytes = baos.toByteArray();
            Log.i(TAG, "onActivityResult: " + imageBytes.length);

            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.length);
            mShowImageView.setImageBitmap(bitmap);
            inputStream.close();
            baos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
        }
    }
}
