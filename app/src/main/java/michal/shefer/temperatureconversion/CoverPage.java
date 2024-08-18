package michal.shefer.temperatureconversion;

import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CoverPage extends AppCompatActivity {
    private Context context;
    TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cover_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initialize();
        tvTitle.animate().rotation(360f).setDuration(4000);
        saySomething("Welcome to the Temperature Conversion App!");
    }
    //Method to speak text, gets text and sends it to service
    public void saySomething(String text){

        Intent intent = new Intent(context, TextToSpeechService.class);
        intent.putExtra("text", text);
        startService(intent);
    }
    //init all elements
    public void initialize(){
        context = this;
        tvTitle = findViewById(R.id.tvTitle);

    }
}