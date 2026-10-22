package com.ute.eventvalidation

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var tilName: TextInputLayout
    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilPhone: TextInputLayout
    private lateinit var tilMsv: TextInputLayout
    private lateinit var tilClass: TextInputLayout

    private lateinit var edtName: TextInputEditText
    private lateinit var edtEmail: TextInputEditText
    private lateinit var edtPhone: TextInputEditText
    private lateinit var edtMsv: TextInputEditText
    private lateinit var edtClass: TextInputEditText

    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ các thành phần giao diện
        tilName = findViewById(R.id.tilName)
        tilEmail = findViewById(R.id.tilEmail)
        tilPhone = findViewById(R.id.tilPhone)
        tilMsv = findViewById(R.id.tilMsv)
        tilClass = findViewById(R.id.tilClass)

        edtName = findViewById(R.id.edtName)
        edtEmail = findViewById(R.id.edtEmail)
        edtPhone = findViewById(R.id.edtPhone)
        edtMsv = findViewById(R.id.edtMsv)
        edtClass = findViewById(R.id.edtClass)

        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            if (validateInputs()) {
                // Nếu dữ liệu hợp lệ -> Chuyển sang DetailActivity và truyền dữ liệu
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("NAME", edtName.text.toString().trim())
                    putExtra("EMAIL", edtEmail.text.toString().trim())
                    putExtra("PHONE", edtPhone.text.toString().trim())
                    putExtra("MSV", edtMsv.text.toString().trim())
                    putExtra("CLASS", edtClass.text.toString().trim())
                }
                startActivity(intent)
            }
        }
    }

    private fun validateInputs(): Boolean {
        var isValid = true

        // 1. Kiểm tra Họ tên
        val name = edtName.text.toString().trim()
        if (name.isEmpty()) {
            tilName.error = "Họ tên không được để trống"
            isValid = false
        } else {
            tilName.error = null
        }

        // 2. Kiểm tra Email
        val email = edtEmail.text.toString().trim()
        if (email.isEmpty()) {
            tilEmail.error = "Email không được để trống"
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.error = "Email không đúng định dạng"
            isValid = false
        } else {
            tilEmail.error = null
        }

        // 3. Kiểm tra Số điện thoại
        val phone = edtPhone.text.toString().trim()
        if (phone.isEmpty()) {
            tilPhone.error = "Số điện thoại không được để trống"
            isValid = false
        } else if (!Patterns.PHONE.matcher(phone).matches() || phone.length < 10) {
            tilPhone.error = "Số điện thoại không hợp lệ"
            isValid = false
        } else {
            tilPhone.error = null
        }

        // 4. Kiểm tra MSV
        val msv = edtMsv.text.toString().trim()
        if (msv.isEmpty()) {
            tilMsv.error = "Mã sinh viên không được để trống"
            isValid = false
        } else {
            tilMsv.error = null
        }

        // 5. Kiểm tra Lớp
        val className = edtClass.text.toString().trim()
        if (className.isEmpty()) {
            tilClass.error = "Lớp không được để trống"
            isValid = false
        } else {
            tilClass.error = null
        }

        return isValid
    }
}