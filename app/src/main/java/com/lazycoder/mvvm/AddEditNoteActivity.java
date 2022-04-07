package com.lazycoder.mvvm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddEditNoteActivity extends AppCompatActivity {
    public static final String EXTRA_ID =
            "com.lazycoder.mvvm.EXTRA_ID";
    public static final String EXTRA_NAME =
            "com.lazycoder.mvvm.EXTRA_NAME";
    public static final String EXTRA_COMPANY =
            "com.lazycoder.mvvm.EXTRA_COMPANY";
    public static final String EXTRA_SCREEN =
            "com.lazycoder.mvvm.EXTRA_SCREEN";
    public static final String EXTRA_RAM =
            "com.lazycoder.mvvm.EXTRA_RAM";
    public static final String EXTRA_PRICE =
            "com.lazycoder.mvvm.EXTRA_PRICE";

    private EditText editTextName;
    private EditText editTextCompany;
    private EditText editTextScreen;
    private EditText editTextRam;
    private EditText editTextPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextName = findViewById(R.id.input_name);
        editTextCompany = findViewById(R.id.input_company);
        editTextScreen = findViewById(R.id.input_screen);
        editTextRam = findViewById(R.id.input_ram);
        editTextPrice = findViewById(R.id.input_price);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Note");
            editTextName.setText(intent.getStringExtra(EXTRA_NAME));
            editTextCompany.setText(intent.getStringExtra(EXTRA_COMPANY));
            editTextScreen.setText(intent.getStringExtra(EXTRA_SCREEN));
            editTextRam.setText(intent.getStringExtra(EXTRA_RAM));
            editTextPrice.setText(intent.getStringExtra(EXTRA_PRICE));
        } else {
            setTitle("Add Note");
        }
    }

    private void saveNote() {
        String name = editTextName.getText().toString();
        String company = editTextCompany.getText().toString();
        String screen = editTextScreen.getText().toString();
        String ram = editTextRam.getText().toString();
        String price = editTextPrice.getText().toString();

        if (name.trim().isEmpty() || company.trim().isEmpty() || screen.trim().isEmpty() || ram.trim().isEmpty() || price.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_NAME, name);
        data.putExtra(EXTRA_COMPANY, company);
        data.putExtra(EXTRA_SCREEN, screen);
        data.putExtra(EXTRA_RAM, ram);
        data.putExtra(EXTRA_PRICE, price);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}