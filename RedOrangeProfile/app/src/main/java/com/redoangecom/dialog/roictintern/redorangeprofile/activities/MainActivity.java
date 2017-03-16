package com.redoangecom.dialog.roictintern.redorangeprofile.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.redoangecom.dialog.roictintern.redorangeprofile.fragments.AboutUSFragment;
import com.redoangecom.dialog.roictintern.redorangeprofile.fragments.HomeFragment;
import com.redoangecom.dialog.roictintern.redorangeprofile.fragments.OurClientsFragment;
import com.redoangecom.dialog.roictintern.redorangeprofile.fragments.OurContactFragment;
import com.redoangecom.dialog.roictintern.redorangeprofile.fragments.OurService2Fragment;
import com.redoangecom.dialog.roictintern.redorangeprofile.fragments.PortfolioFragment;
import com.redoangecom.dialog.roictintern.redorangeprofile.fragments.TeamFragment;
import com.redoangecom.dialog.roictintern.redorangeprofile.utils.AlertMessage;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;
    private NavigationView navView;
    private View headerView;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;

    private RelativeLayout actionCall;
    private RelativeLayout actionMail;
    private RelativeLayout actionWeb;

    private int appExitFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navView = (NavigationView) findViewById(R.id.navigationView);
        navView.setNavigationItemSelectedListener(this);

        headerView = navView.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        actionCall = (RelativeLayout) headerView.findViewById(R.id.call);
        actionMail = (RelativeLayout) headerView.findViewById(R.id.mail);
        actionWeb = (RelativeLayout) headerView.findViewById(R.id.web);

        initActions();

        setTitle("");

        navView.setCheckedItem(R.id.home);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container , new HomeFragment()).commit();

    }

    private void initActions() {

        actionCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse(getResources().getString(R.string.redorangePhone)));

                if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    AlertMessage am = new AlertMessage("Phone Call Is Not Allowed Currently. Would You Like To Allow Phone Call ?" , "Permission Request" , -1 , MainActivity.this);
                    am.showPermissionSeekerDialog();
                    return;
                }

                if(isIntentSafe(callIntent)){
                    startActivity(callIntent);
                }else{
                    AlertMessage am = new AlertMessage("This Action Is Currently Not Supported By The Device" , "Action Alert" , -1 , MainActivity.this);
                    am.ShowAlertDialog();
                }
            }
        });

        actionWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertMessage am;
                if(!isNetworkAvailable()){
                    am = new AlertMessage("You Are Not Connected To Internet" , "Network Alert" , -1 , MainActivity.this);
                    am.ShowAlertDialog();
                    return;
                }

                Intent browserIntent = new Intent(Intent.ACTION_VIEW , Uri.parse(getResources().getString(R.string.redorangeWeb)));

                if(isIntentSafe(browserIntent)){
                    startActivity(browserIntent);
                }else{
                    am = new AlertMessage("This Action Is Currently Not Supported By The Device" , "Action Alert" , -1 , MainActivity.this);
                    am.ShowAlertDialog();
                }

            }
        });

        actionMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mailIntent = new Intent(Intent.ACTION_SENDTO , Uri.fromParts("mailto" ,getResources().getString(R.string.redorangeMail) , null ));

                if(isIntentSafe(mailIntent)){
                    mailIntent.putExtra(Intent.EXTRA_SUBJECT , getResources().getString(R.string.subject));
                    startActivity(Intent.createChooser(mailIntent , "Send Mail Using..."));
                }else{
                    AlertMessage am = new AlertMessage("This Action Is Currently Not Supported By The Device" , "Action Alert" , -1 , MainActivity.this);
                    am.ShowAlertDialog();
                }
            }
        });
    }

    private void myToast(String msg){
        Toast.makeText(this , msg , Toast.LENGTH_SHORT).show();
    }

    private boolean isIntentSafe(Intent intent){

        List activities = getPackageManager().queryIntentActivities(intent , PackageManager.MATCH_DEFAULT_ONLY);
        if(activities.size() > 0){

            return true;
        }else{

            return false;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id){

            case R.id.home    : setTitle(R.string.home); setHomeFragment();break;
            case R.id.about   : setTitle(R.string.about);setAboutUsFragment();break;
            case R.id.service : setTitle(R.string.service);setOurServicesFragment();break;
            case R.id.work    : setTitle(R.string.work);setOurWorkFrgment();break;
            case R.id.clients : setTitle(R.string.clients);setOurClientFragment();break;
            case R.id.team    : setTitle(R.string.team);setOurTeamFragment();break;
            case R.id.adress  : setTitle(R.string.adress);setOurAdressFragment();break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private boolean isNetworkAvailable(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cm.getActiveNetworkInfo();
        return nInfo != null && nInfo.isConnectedOrConnecting();
    }

    private void setHomeFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new HomeFragment()).commit();
    }

    private void setAboutUsFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new AboutUSFragment()).commit();
    }

    private void setOurServicesFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new OurService2Fragment()).commit();
    }

    private void setOurWorkFrgment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new PortfolioFragment()).commit();
    }

    private void setOurClientFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new OurClientsFragment()).commit();
    }

    private void setOurTeamFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new TeamFragment()).commit();
    }

    private void setOurAdressFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new OurContactFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        appExitFlag = appExitFlag + 1;

        if(appExitFlag == 2){
            super.onBackPressed();
        }else{
            myToast("Please Double Tap To Exit");
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                appExitFlag = 0;
            }
        };

        Handler handler = new Handler();
        handler.postDelayed(runnable , 1500);
    }
}
