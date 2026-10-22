package com.ute.eventvalidation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Nhận dữ liệu truyền qua Intent từ màn hình đăng ký
        val name = intent.getStringExtra("NAME")
        val email = intent.getStringExtra("EMAIL")
        val phone = intent.getStringExtra("PHONE")
        val msv = intent.getStringExtra("MSV")
        val className = intent.getStringExtra("CLASS")

        // Hiển thị thông tin lên màn hình chi tiết
        tvResult.text = """
            Họ và tên: $name
            Email: $email
            Số điện thoại: $phone
            Mã sinh viên: $msv
            Lớp: $className
        """.trimIndent()
    }
}