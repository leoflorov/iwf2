package ru.leodevelopments.iwf;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import leodevelopments.iwf.R;

public class BuyTicketsActivity extends Activity {

    private TextView downloadStatus;
    private DatabaseHelper mDataBaseHelper;
    private SQLiteDatabase mSQLiteDatabase;
    Button btnAdd;
    EditText etCategory, etName, etIngredients, etInstruction, etPhoto;
    DatabaseHelper dbHelper;


    @Override
    public void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.buytickets_layout);
//        downloadStatus = (TextView) findViewById(R.id.download_status);
//        Button btnDownload = (Button) findViewById(R.id.btn_download);
//        btnDownload.setOnClickListener(onDownloadListener());

//        btnAdd = (Button) findViewById(R.id.saveRecipeButton);
//        btnAdd.setOnClickListener(this);
//
//        etCategory = (EditText) findViewById(R.id.category_input_txt);
//        etName = (EditText) findViewById(R.id.recipe_name);
//        etIngredients = (EditText) findViewById(R.id.add_ingredients_txt);
//        etInstruction = (EditText) findViewById(R.id.add_instructions_txt);
//
//        dbHelper = new DatabaseHelper(this);

        WebView ticketsWebView = (WebView) findViewById(R.id.buy_tickets_webview);
        ticketsWebView.loadUrl("http://wrestlingfederation14-03.ticketforevent.com/ru");
        ticketsWebView.getSettings().setSupportZoom(true);
        ticketsWebView.getSettings().setBuiltInZoomControls(true);

    }
}

//    private View.OnClickListener onDownloadListener() {
//        return new View.OnClickListener() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(BuyTicketsActivity.this, DownloadService.class);
//                intent.putExtra(DownloadService.FILENAME, "logo.jpg");
//                intent.putExtra(DownloadService.URL, "http://www.wrestlingfederation.ru/images/logo.jpg");
//                startService(intent);
//                downloadStatus.setText("Загрузка...");
//            }
//        };
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        registerReceiver(receiver, new IntentFilter(DownloadService.NOTIFICATION));
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        unregisterReceiver(receiver);
//    }
//
//    private BroadcastReceiver receiver = new BroadcastReceiver() {
//        @SuppressLint("SetTextI18n")
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            Bundle bundle = intent.getExtras();
//            if (bundle != null) {
//                int resultCode = bundle.getInt(DownloadService.RESULT);
//                if (resultCode == RESULT_OK) {
//                    Toast.makeText(BuyTicketsActivity.this, "Файл загружен!", Toast.LENGTH_LONG).show();
//                    downloadStatus.setText("Загрузка завершена");
//                } else {
//                    Toast.makeText(BuyTicketsActivity.this, "Ошибка загрузки", Toast.LENGTH_LONG).show();
//                    downloadStatus.setText("Загрузка не удалась");
//                }
//            }
//        }
//    };

//        mDataBaseHelper = new DatabaseHelper(this, "myrecipes.db", null, 1);
//
//        mSQLiteDatabase = mDataBaseHelper.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        //задание значения для каждого столбца
//        values.put(DatabaseHelper.RECIPE_NAME_COLUMN, "Оивье");
//        values.put(DatabaseHelper.PHOTO_COLUMN, "@drawable/salad.jpg");
//        values.put(DatabaseHelper.INGREDIENTS_COLUMN, "Колбаса, майонез, яйца и т.д.");
//        values.put(DatabaseHelper.INSTRUCTION_COLUMN, "ПРиготовить салат");

//        String[] categoriesAutoComplete = {"Салаты", "Супы", "Вторые блюда", "Напитки", "Десерты", "Курица", "Рыба", "Мясо", "Праздники"};
//
//        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.category_input_txt);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, categoriesAutoComplete);
//        textView.setAdapter(adapter);


//            // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
//            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoriesSpinner);
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//            Spinner spinner = (Spinner) findViewById(R.id.spinner);
//            spinner.setAdapter(adapter);
//        spinner.setPrompt("Категории рецептов");
//        spinner.setSelection(2);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getBaseContext(), "Position =" + position, Toast.LENGTH_SHORT).show();
//            }

//    @Override
//    public void onClick(View v) {
//
//        String category = etCategory.getText().toString();
//        String name = etName.getText().toString();
//        String ingredients = etIngredients.getText().toString();
//        String instruction = etInstruction.getText().toString();
//
//
//        SQLiteDatabase database = dbHelper.getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//
//
//        switch (v.getId()) {
//
//            case R.id.saveRecipeButton:
//                contentValues.put(DatabaseHelper.CATEGORY_NAME_COLUMN, category);
//                contentValues.put(DatabaseHelper.RECIPE_NAME_COLUMN, name);
//                contentValues.put(DatabaseHelper.INGREDIENTS_COLUMN, ingredients);
//                contentValues.put(DatabaseHelper.INSTRUCTION_COLUMN, instruction);
//
//                database.insert(DatabaseHelper.DATABASE_TABLE, null, contentValues);
//                break;
//
//            case R.id.btnRead:
//                Cursor cursor = database.query(DatabaseHelper.DATABASE_TABLE, null, null, null, null, null, null);
//
//                if (cursor.moveToFirst()) {
//                    int idIndex = cursor.getColumnIndex(DatabaseHelper._ID);
//                    int categoryIndex = cursor.getColumnIndex(DatabaseHelper.CATEGORY_NAME_COLUMN);
//                    int nameIndex = cursor.getColumnIndex(DatabaseHelper.RECIPE_NAME_COLUMN);
//                    int ingredientsIndex = cursor.getColumnIndex(DatabaseHelper.INGREDIENTS_COLUMN);
//                    int instructionIndex = cursor.getColumnIndex(DatabaseHelper.INSTRUCTION_COLUMN);
//                    do {
//                        Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
//                                ", category = " + cursor.getString(categoryIndex) +
//                                ", name = " + cursor.getString(nameIndex) +
//                                ", ingredients = " + cursor.getString(ingredientsIndex) +
//                                ", instruction = " + cursor.getString(instructionIndex));
//                    } while (cursor.moveToNext());
//                } else
//                    Log.d("mLog", "0 rows");
//
//                cursor.close();
//                break;
//
//            case R.id.btnClear:
//                database.delete(DatabaseHelper.DATABASE_TABLE, null, null);
//                break;
//        }
//        dbHelper.close();
//    }
//    public void onClick(View v) {
//        mDataBaseHelper = new DatabaseHelper(this, "myrecioes,db", null, 1);
//        SQLiteDatabase sdb;
//        sdb = mDataBaseHelper.getReadableDatabase();


