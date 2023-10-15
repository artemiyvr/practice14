
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.practice14.R

class MainActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var editButton: Button
    private lateinit var resultTextView: TextView

    private val SECOND_ACTIVITY_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEditText = findViewById(R.id.emailEditText)
        nameEditText = findViewById(R.id.nameEditText)
        ageEditText = findViewById(R.id.ageEditText)
        editButton = findViewById(R.id.editButton)
        resultTextView = findViewById(R.id.resultTextView)

        editButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val editedEmail = data?.getStringExtra("editedEmail")
            val editedName = data?.getStringExtra("editedName")
            val editedAge = data?.getStringExtra("editedAge")

            val emailText = if (editedEmail != null && editedEmail != emailEditText.text.toString()) {
                "* $editedEmail"
            } else {
                emailEditText.text.toString()
            }

            val nameText = if (editedName != null && editedName != nameEditText.text.toString()) {
                "* $editedName"
            } else {
                nameEditText.text.toString()
            }

            val ageText = if (editedAge != null && editedAge != ageEditText.text.toString()) {
                "* $editedAge"
            } else {
                ageEditText.text.toString()
            }

            resultTextView.text = "Email: $emailText\nName: $nameText\nAge: $ageText"
        }
    }
}
