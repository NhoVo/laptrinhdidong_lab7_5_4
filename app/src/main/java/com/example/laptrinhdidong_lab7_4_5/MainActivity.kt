package com.example.laptrinhdidong_lab7_4_5

import android.R
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.laptrinhdidong_lab7_4_5.R.layout.activity_main)
        val db = DatabaseHandler(this)

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..")
        db.addContact(Contact("Ravi", "9100000000"))
        db.addContact(Contact("Srinivas", "9199999999"))
        db.addContact(Contact("Tommy", "9522222222"))
        db.addContact(Contact("Karthik", "9533333333"))

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..")
        val contacts = db.allContacts
        for (cn in contacts) {
            val log = "Id: " + cn.id + " ,Name: " + cn.name + " ,Phone: " +
                    cn.phoneNumber
            // Writing Contacts to log
            Log.d("Name: ", log)
        }
    }
}