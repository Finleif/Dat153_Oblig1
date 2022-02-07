package no.hvl.dat153.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

import no.hvl.dat153.dao.PersonDao;
import no.hvl.dat153.model.Person;
import no.hvl.dat153.R;

public class AddNewPersonActivity extends AppCompatActivity {

    private PersonDao personDao = new PersonDao();
    private List<Person> personList = personDao.getAllPersons();

    static final int IMAGE_REQUEST_CODE = 1;
    private ImageView iv;
    private Uri photoUri;

    private EditText newName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_person);

        Button btnChoose = findViewById(R.id.choosePictureButton);
        Button btnAdd = findViewById(R.id.add_new_person);
        iv = findViewById(R.id.imagePreview);
        newName = findViewById(R.id.editTextName);

        //Select image
        btnChoose.setOnClickListener((View v) -> {
            selectImage();
        });

        //Select name
        btnAdd.setOnClickListener((View v) -> {
            String name = newName.getText().toString();
            Person p = new Person(name, photoUri);
            personList.add(p);
        });
    }

    public void selectImage() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, IMAGE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            photoUri = data.getData();
            iv.setImageURI(photoUri);

            getContentResolver().takePersistableUriPermission(photoUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }
    }
}