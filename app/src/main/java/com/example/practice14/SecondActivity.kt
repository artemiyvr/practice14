
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.practice14.R

class SecondActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var saveButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        emailEditText = findViewById(R.id.emailEditText)
        nameEditText = findViewById(R.id.nameEditText)
        ageEditText = findViewById(R.id.ageEditText)
        saveButton = findViewById(R.id.saveButton)

        val email = intent.getStringExtra("email")
        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")

        emailEditText.setText(email)
        nameEditText.setText(name)
        ageEditText.setText(age)

        saveButton.setOnClickListener {
            val editedEmail = emailEditText.text.toString()
            val editedName = nameEditText.text.toString()
            val editedAge = ageEditText.text.toString()

            val intent = Intent()
            intent.putExtra("editedEmail", editedEmail)
            intent.putExtra("editedName", editedName)
            intent.putExtra("editedAge", editedAge)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }


    }
