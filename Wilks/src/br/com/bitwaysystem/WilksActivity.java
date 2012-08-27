package br.com.bitwaysystem;

import br.com.bitwaysystem.bean.Man;
import br.com.bitwaysystem.bean.Supine;
import br.com.bitwaysystem.bean.Woman;
import br.com.bitwaysystem.wilks.Wilks;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class WilksActivity extends Activity implements OnClickListener {

	private static final String[] SEXO = new String[] { "Masculino", "Feminino" };
	private Spinner m_spinnerSexo = null;
	private boolean validate;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wilks);

		Spinner combo = (Spinner) findViewById(R.id.sexos);
		ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, SEXO);
		adp.setDropDownViewResource(android.R.layout.simple_spinner_item);
		combo.setAdapter(adp);

		Button ok = (Button) findViewById(R.id.btn_clcWilks);
		ok.setOnClickListener(this);

	}

	public void onClick(View v) {

		validate = true;
		
		m_spinnerSexo = (Spinner) findViewById(R.id.sexos);
		TextView pesoPessoa = (TextView) findViewById(R.id.txtPesoValue);
		TextView pesoSupino = (TextView) findViewById(R.id.txtPesoSupino);
		TextView resultWilks = (TextView) findViewById(R.id.txtWilksResult);

		if (pesoSupino.getText().toString().equals("")) {
			this.camposObrigatorios("Informe o peso do supino");
			validate = false;
		}
		
		if (pesoPessoa.getText().toString().equals("")) {
			this.camposObrigatorios("Informe seu peso");
			validate = false;
		}
		
		

		if (validate) {
			if (m_spinnerSexo.getSelectedItem().toString().equals("Feminino")) {

				Woman woman = new Woman();

				woman.setWeight(Double.parseDouble(pesoPessoa.getText()
						.toString()));
				Supine supineWoman = new Supine(Double.parseDouble(pesoSupino
						.getText().toString()));
				woman.setSupine(supineWoman);

				Wilks wilksWoman = new Wilks(woman);
				wilksWoman.showCoeff();

				resultWilks.setText(wilksWoman.formulaTotalWoman().toString());
			} else {

				Man man = new Man();

				man.setWeight(Double.parseDouble(pesoPessoa.getText()
						.toString()));
				Supine supineMan = new Supine(Double.parseDouble(pesoSupino
						.getText().toString()));
				man.setSupine(supineMan);

				Wilks wilksMan = new Wilks(man);
				wilksMan.showCoeff();
				resultWilks.setText(wilksMan.formulaTotalMan().toString());
			}

		}

	}

	public void camposObrigatorios(String mensagem) {
		AlertDialog.Builder m = new AlertDialog.Builder(this);
		m.setTitle("Aviso");
		m.setMessage(mensagem);
		m.setPositiveButton("OK", null);
		m.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_wilks, menu);
		return true;
	}
}
