package com.prey.activities.browser.javascript;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.prey.PreyConfig;
import com.prey.accounts.UserEmail;
import com.prey.activities.browser.LoginBrowserActivity;
import com.prey.activities.browser.NewUserBrowserActivity;
import com.prey.activities.browser.PanelBrowserActivity;
import com.prey.activities.browser.javascript.action.LoginScriptInterface;
import com.prey.activities.browser.javascript.action.NewUserScriptInterface;
import com.prey.activities.browser.javascript.action.UnLockScriptInterface;

public class PreyJavaScriptInterface {

	private int wrongPasswordIntents = 0;

	private Context ctx;
	private String deviceType;

	public PreyJavaScriptInterface(Context ctx, String deviceType) {
		this.ctx = ctx;
		this.deviceType = deviceType;
	}

	public void showToast(String toast) {
		Toast.makeText(ctx, toast, Toast.LENGTH_SHORT).show();
	}

	public void login(String email, String password) {
		
		
		LoginScriptInterface login = new LoginScriptInterface(ctx);
		login.execute(email, password,deviceType, wrongPasswordIntents);
	}
	
	public void userRegistered(String password) {
		LoginScriptInterface login = new LoginScriptInterface(ctx);
		String email = PreyConfig.getPreyConfig(ctx).getEmail();
		login.execute(email, password,deviceType, wrongPasswordIntents);
	}
	

	public void newuser(String name, String email, String password, String repassword) {
		NewUserScriptInterface newUser = new NewUserScriptInterface(ctx);
		newUser.execute(name, email, password, repassword, deviceType);
	}

	public void goNewUser() {
		Intent intent = new Intent(ctx, NewUserBrowserActivity.class);
		ctx.startActivity(intent);
	}

	public void goPanel() {
		Intent intent = new Intent(ctx, PanelBrowserActivity.class);
		ctx.startActivity(intent);
	}

	public void goLogin() {
		Intent intent = new Intent(ctx, LoginBrowserActivity.class);
		ctx.startActivity(intent);
	}
	
	public void configureSimHtml(String str) {
		Toast.makeText(ctx, "Configure Sim:" + str, Toast.LENGTH_SHORT).show();

	}

	public void onUnlockPass(boolean unlockPass) {
		UnLockScriptInterface unlockInterface = new UnLockScriptInterface(ctx);
		unlockInterface.execute(unlockPass);
	}
	
	public String loginMail(){
		String email = UserEmail.getEmail(ctx);
		return email;
	}

	//Next Method Delete 
	
	public void activeCamouflageHtml(String str) {
		Toast.makeText(ctx, "Active Camouflage:" + str, Toast.LENGTH_SHORT).show();

	}

	public void uninstallLockHtml(String str) {
		Toast.makeText(ctx, "Uninstall Lock:" + str, Toast.LENGTH_SHORT).show();
	}
	
	

}