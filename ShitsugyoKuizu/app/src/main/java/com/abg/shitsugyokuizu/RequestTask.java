package com.abg.shitsugyokuizu;

import android.os.AsyncTask;

import androidx.annotation.NonNull;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.output.ByteArrayOutputStream;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpStatus;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.StatusLine;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.ClientProtocolException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpGet;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class RequestTask extends AsyncTask<String, String, String> {

    public AsyncResponse delegate = null;
    String finalResult = "";

    public String getFinalResult() {
        return finalResult;
    }

    @Override
    protected String doInBackground(String... uri) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response;
        String responseString = null;
        try {
            response = httpclient.execute(new HttpGet(uri[0]));
            StatusLine statusLine = response.getStatusLine();
//            StringBuilder builder = new StringBuilder();
//            HttpEntity entity = response.getEntity();
//            InputStream content = entity.getContent();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(content, "UTF-8"));
//            String line = null;
//            while((line = reader.readLine()) != null) {
//                builder.append(line);
//            }
//
//            finalResult = builder.toString();

//            response = httpclient.execute(new HttpGet(uri[0]));
//            statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                responseString = out.toString();
                out.close();
            } else{
                //Closes the connection.
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return responseString;
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.processFinish(result);
    }
}
