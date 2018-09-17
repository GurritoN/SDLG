package lab.gurriton.sdlg

import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.telephony.TelephonyManager
import android.Manifest
import android.widget.TextView

class IMEI : AppCompatActivity() {

    fun getIMEI() : String{
        val manager: TelephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED)
            return manager.deviceId
        return "You don't have enough permissions to see IMEI"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_imei)
        val imei: TextView = findViewById(R.id.imei)
        imei.text = getIMEI()

        val version: TextView = findViewById(R.id.version)
        version.text = packageManager.getPackageInfo(packageName, 0).versionName
    }
}
