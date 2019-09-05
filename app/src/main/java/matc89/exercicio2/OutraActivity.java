package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OutraActivity extends AppCompatActivity {

    private String nome;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nome = extras.getString("text");
        }

        edit = (EditText)findViewById(R.id.editText);
        edit.setText(nome);
    }

    public void confirmar(View v) {
        Intent data = new Intent();
        data.putExtra("nome", edit.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }
    public void cancelar(View v) {
        finish();
    }

}
