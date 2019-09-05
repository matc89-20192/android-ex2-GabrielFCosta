package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView texto;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (TextView)findViewById(R.id.textView);
    }

    public void botaoClicado(View v) {
        Intent outra = new Intent(this, OutraActivity.class);

        outra.putExtra("text",nome);
        startActivityForResult(outra,0);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == RESULT_OK) {
            nome = data.getStringExtra("nome");
            texto.setText("Oi, " + nome + "!");

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("cumprimento",texto.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        texto.setText(savedInstanceState.getString("cumprimento"));
    }

}
