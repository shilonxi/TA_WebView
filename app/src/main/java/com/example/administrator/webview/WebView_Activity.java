package com.example.administrator.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WebView_Activity extends AppCompatActivity implements View.OnClickListener
{
    private EditText editText;
    private Button button;
    private WebView webView;
    //建立变量

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_layout);
        editText=(EditText)findViewById(R.id.wangzhi);
        button=(Button)findViewById(R.id.decide);
        webView=(WebView)findViewById(R.id.web_view);
        //获取实例
        button.setOnClickListener(this);
        //点击监听
        webView.getSettings().setJavaScriptEnabled(true);
        //让WebView支持JavaScript脚本
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.decide:
                String inputText=editText.getText().toString();
                //获取网址
                Toast.makeText(WebView_Activity.this,"这是你想要浏览的网页^-^",Toast.LENGTH_SHORT).show();
                //提示消息
                webView.setWebViewClient(new WebViewClient());
                //网页跳转时，仍在当前WebView中显示
                webView.loadUrl(inputText);
                //传入网址，展示网页
                break;
            default:
                break;
        }
    }
    //点击响应

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event)
    {
        if((keyCode==KeyEvent.KEYCODE_BACK)&&webView.canGoBack())
        {
            webView.goBack();
            //返回上一页面
            return true;
        }
        return false;
    }
    //设置回退

}
