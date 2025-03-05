package com.example.convertirunite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainPrincipale extends AppCompatActivity {

    private Spinner unitTypeSpinner, fromSpinner, toSpinner;
    private EditText inputEditText;
    private TextView resultTextView;
    private FormuleConversion unitConverter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principale);

        //Pour retourner a l'ecran d'accueil
        ecouteActiviteMain();

        //Configuration de la bar de menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        unitConverter = new FormuleConversion();

        inputEditText = findViewById(R.id.editTextNumberDecimal);
        resultTextView = findViewById(R.id.affichesult);

        //Pour la selection du type d'unite a couvertir
        unitTypeSpinner = findViewById(R.id.spinner_unite);
        fromSpinner = findViewById(R.id.spinner_debut);
        toSpinner = findViewById(R.id.spinner_vers);

        //Definition des adaptateurs pour le spinner contenant les unités
        ArrayAdapter<CharSequence> unitTypeAdapter = ArrayAdapter.createFromResource(this,
                R.array.unite_a_convertir, android.R.layout.simple_spinner_item);
        unitTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitTypeSpinner.setAdapter(unitTypeAdapter);
        ImageView imageView = findViewById(R.id.imageMessure);


        unitTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectTypeUnite = parent.getItemAtPosition(position).toString();

                if (selectTypeUnite.equals("Poids")) {
                    organiseSpinner(R.array.item_poids);
                } else if (selectTypeUnite.equals("Longueur")) {
                    organiseSpinner(R.array.item_longueur);
                } else if (selectTypeUnite.equals("Température")) {
                    organiseSpinner(R.array.item_temperature);
                } else if (selectTypeUnite.equals("Devise")) {
                    organiseSpinner(R.array.item_devise);
                } else if (selectTypeUnite.equals("Temps")) {
                    organiseSpinner(R.array.item_temps);
                } else {
                    fromSpinner.setVisibility(View.GONE);
                    toSpinner.setVisibility(View.GONE);
                }

                //Pour afficher les images selon la selection
                if (selectTypeUnite.equals("Poids")) {
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(R.drawable.poids1);
                } else if (selectTypeUnite.equals("Température")) {
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(R.drawable.temperature);
                } else if (selectTypeUnite.equals("Temps")) {
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(R.drawable.tps);
                }  else if (selectTypeUnite.equals("Longueur")) {
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(R.drawable.lgr);
                } else if (selectTypeUnite.equals("Devise")) {
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(R.drawable.device);
                } else {
                    imageView.setVisibility(View.GONE);
                }
            }

            //Au cas ou rien n'est selectionné
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.btnConvert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertirUnite();
            }
        });

        findViewById(R.id.buttonReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    //Methode pour obtenir le resultat de la conversion
    private void convertirUnite(){
        String inputValue = inputEditText.getText().toString();
        if (!inputValue.isEmpty()){
            double valeur = Double.parseDouble(inputValue);
            String selectDe = fromSpinner.getSelectedItem().toString();
            String selectVers = toSpinner.getSelectedItem().toString();

            double resultat = 0;

            //Appel de la méthode de conversion appropriée
            if (selectDe.equals("Kilogramme") && selectVers.equals("Livre")){
                resultat = unitConverter.convertKgToLbs(valeur);
            }else if (selectDe.equals("Livre") && selectVers.equals("Kilogramme")){
                resultat = unitConverter.convertLivreToKg(valeur);
            }else if (selectDe.equals("Kilogramme") && selectVers.equals("Gramme")){
                resultat = unitConverter.convertKgToG(valeur);
            }else if (selectDe.equals("Gramme") && selectVers.equals("Kilogramme")){
                resultat = unitConverter.convertGToKg(valeur);
            }else if (selectDe.equals("Livre") && selectVers.equals("Gramme")){
                resultat = unitConverter.convertLivreToG(valeur);
            }else if (selectDe.equals("Gramme") && selectVers.equals("Livre")){
                resultat = unitConverter.convertGToLivre(valeur);
            }else if (selectDe.equals("Kilogramme") && selectVers.equals("Kilogramme")){
                resultat = unitConverter.convertKgToKg(valeur);
            } else if (selectDe.equals("Gramme") && selectVers.equals("Gramme")) {
                resultat = unitConverter.convertGToG(valeur);
            } else if (selectDe.equals("Livre") && selectVers.equals("Livre")) {
                resultat = unitConverter.convertLivreToLivre(valeur);
            }

            //Pour les longueurs
            else if (selectDe.equals("Millimètre") && selectVers.equals("Millimètre")) {
                resultat = unitConverter.convertMmToMm(valeur);
            }else if (selectDe.equals("Millimètre") && selectVers.equals("Centimètre")) {
                resultat = unitConverter.convertMmToCm(valeur);
            }else if (selectDe.equals("Millimètre") && selectVers.equals("Mètre")) {
                resultat = unitConverter.convertMmToM(valeur);
            }else if (selectDe.equals("Millimètre") && selectVers.equals("Kilomètre")) {
                resultat = unitConverter.convertMmToKm(valeur);
            }

            else if (selectDe.equals("Centimètre") && selectVers.equals("Centimètre")) {
                resultat = unitConverter.convertCmToCm(valeur);
            }else if (selectDe.equals("Centimètre") && selectVers.equals("Millimètre")) {
                resultat = unitConverter.convertCmToMm(valeur);
            } else if (selectDe.equals("Centimètre") && selectVers.equals("Mètre")) {
                resultat = unitConverter.convertCmToM(valeur);
            }else if (selectDe.equals("Centimètre") && selectVers.equals("Kilomètre")) {
                resultat = unitConverter.convertCmToKm(valeur);
            }

            else if (selectDe.equals("Mètre") && selectVers.equals("Mètre")) {
                resultat = unitConverter.convertMToM(valeur);
            }else if (selectDe.equals("Mètre") && selectVers.equals("Millimètre")) {
                resultat = unitConverter.convertMToMm(valeur);
            } else if (selectDe.equals("Mètre") && selectVers.equals("Centimètre")) {
                resultat = unitConverter.convertMToCm(valeur);
            }else if (selectDe.equals("Mètre") && selectVers.equals("Kilomètre")) {
                resultat = unitConverter.convertMToKm(valeur);
            }

            else if (selectDe.equals("Kilomètre") && selectVers.equals("Kilomètre")) {
                resultat = unitConverter.convertKmToKm(valeur);
            }else if (selectDe.equals("Kilomètre") && selectVers.equals("Millimètre")) {
                resultat = unitConverter.convertKmToMm(valeur);
            } else if (selectDe.equals("Kilomètre") && selectVers.equals("Centimètre")) {
                resultat = unitConverter.convertKmToCm(valeur);
            }else if (selectDe.equals("Kilomètre") && selectVers.equals("Mètre")) {
                resultat = unitConverter.convertKmToM(valeur);
            }//Fin pour les longueurs

            //Pour obtenir le resultat de la conversion pour la temperature
            else if (selectDe.equals("Celsius") && selectVers.equals("Celsius")) {
                resultat = unitConverter.ConvertCelsToCels(valeur);
            }else if (selectDe.equals("Celsius") && selectVers.equals("Kelvin")) {
                resultat = unitConverter.ConvertCelsToKel(valeur);
            }else if (selectDe.equals("Celsius") && selectVers.equals("Fahrenheit")) {
                resultat = unitConverter.ConvertCelsToFahr(valeur);
            }else if (selectDe.equals("Kelvin") && selectVers.equals("Kelvin")) {
                resultat = unitConverter.ConvertKelToKel(valeur);
            }else if (selectDe.equals("Kelvin") && selectVers.equals("Celsius")) {
                resultat = unitConverter.ConvertKelToCels(valeur);
            }else if (selectDe.equals("Kelvin") && selectVers.equals("Fahrenheit")) {
                resultat = unitConverter.ConvertKelToFahr(valeur);
            }else if (selectDe.equals("Fahrenheit") && selectVers.equals("Fahrenheit")) {
                resultat = unitConverter.ConvertFahrToFahr(valeur);
            }else if (selectDe.equals("Fahrenheit") && selectVers.equals("Celsius")) {
                resultat = unitConverter.ConvertFahrToCels(valeur);
            }else if (selectDe.equals("Fahrenheit") && selectVers.equals("Kelvin")) {
                resultat = unitConverter.ConvertFahrToKel(valeur);
            }//Fin pour les temperatures

            //Pour obtenir les resultats de devises
            else if (selectDe.equals("Euro") && selectVers.equals("Cfa")){
                resultat = unitConverter.ConvertEuroToCfa(valeur);
            } else if (selectDe.equals("Cfa") && selectVers.equals("Euro")) {
                resultat = unitConverter.ConvertCfaToEuro(valeur);
            } else if (selectDe.equals("Cfa") && selectVers.equals("Cfa")) {
                resultat = unitConverter.ConvertCfaToCfa(valeur);
            }else if (selectDe.equals("Euro") && selectVers.equals("Euro")){
                resultat = unitConverter.ConvertEuroToEuro(valeur);
            }else if (selectDe.equals("Dollar") && selectVers.equals("Dollar")){
                resultat = unitConverter.ConvertDollarToDollar(valeur);
            } else if (selectDe.equals("Dollar") && selectVers.equals("Cfa")) {
                resultat = unitConverter.ConvertDollarToCfa(valeur);
            } else if (selectDe.equals("Dollar")&& selectVers.equals("Euro")) {
                resultat = unitConverter.ConvertDollarToEuro(valeur);
            } else if (selectDe.equals("Cfa") && selectVers.equals("Dollar")) {
                resultat = unitConverter.ConvertCfaToEuro(valeur);
            } else if (selectDe.equals("Euro") && selectVers.equals("Dollar")) {
                resultat = unitConverter.ConvertEuroToDollar(valeur);
            }

            //Pour obtenir les resultats du temps
            else if (selectDe.equals("Seconde") && selectVers.equals("Seconde")) {
                resultat = unitConverter.ConvertesecondToSecond(valeur);
            }else if (selectDe.equals("Seconde") && selectVers.equals("Minute")) {
                resultat = unitConverter.ConvertsecondToMin(valeur);
            }else if (selectDe.equals("Seconde") && selectVers.equals("Heure")) {
                resultat = unitConverter.ConvertsecondToHour(valeur);
            }else if (selectDe.equals("Seconde") && selectVers.equals("Jour")) {
                resultat = unitConverter.ConvertsecondToDay(valeur);
            }
            else if (selectDe.equals("Minute") && selectVers.equals("Minute")) {
                resultat = unitConverter.ConvertMinToMin(valeur);
            }else if (selectDe.equals("Minute") && selectVers.equals("Seconde")) {
                resultat = unitConverter.ConvertMinToSec(valeur);
            }else if (selectDe.equals("Minute") && selectVers.equals("Heure")) {
                resultat = unitConverter.ConvertMinToHour(valeur);
            }else if (selectDe.equals("Minute") && selectVers.equals("Jour")) {
                resultat = unitConverter.ConvertMinToDay(valeur);
            }
            else if (selectDe.equals("Heure") && selectVers.equals("Heure")) {
                resultat = unitConverter.ConvertHourToHour(valeur);
            }else if (selectDe.equals("Heure") && selectVers.equals("Seconde")) {
                resultat = unitConverter.ConvertHourToSec(valeur);
            }else if (selectDe.equals("Heure") && selectVers.equals("Minute")) {
                resultat = unitConverter.ConvertHourToMin(valeur);
            }else if (selectDe.equals("Heure") && selectVers.equals("Jour")) {
                resultat = unitConverter.ConvertHourToDay(valeur);
            }
            else if (selectDe.equals("Jour") && selectVers.equals("Jour")) {
                resultat = unitConverter.ConvertDayToDay(valeur);
            }else if (selectDe.equals("Jour") && selectVers.equals("Seconde")) {
                resultat = unitConverter.ConvertDayToSec(valeur);
            }else if (selectDe.equals("Jour") && selectVers.equals("Minute")) {
                resultat = unitConverter.ConvertDayToMin( valeur);
            }else if (selectDe.equals("Jour") && selectVers.equals("Heure")) {
                resultat = unitConverter.ConvertDayToHour( valeur);
            }//Dollar


            resultTextView.setText(String.valueOf(resultat));
        }
    }

    private void reset(){
        inputEditText.setText("");
        resultTextView.setText("");
    }

    private void organiseSpinner(int arrResourceId) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainPrincipale.this,
                arrResourceId, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);

        fromSpinner.setVisibility(View.VISIBLE);
        toSpinner.setVisibility(View.VISIBLE);
    }

    //Pour retourner a l'ecran d'accueil
    private void ecouteActiviteMain() {
        ((Button) findViewById(R.id.btnAcceuil)).setOnClickListener(new Button.
                OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPrincipale.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Pour acceder l'a propos
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_about) {
            // Ouvrir la page "À propos" ici
            Intent intent = new Intent(MainPrincipale.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}