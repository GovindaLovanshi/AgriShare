package com.example.serviceapp.LanourJob.JobViewModel

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.serviceapp.LanourJob.Model.jobdetailsmodel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class jobViewModel : ViewModel() {
    private val storage = Firebase.storage
    private val firestore = FirebaseFirestore.getInstance()

    val formDataList = mutableStateListOf<jobdetailsmodel>()

    fun submitForm(formData: jobdetailsmodel) {
        if (formData.imageUrl != null) {
            // imageUrl here is a local URI path from picker
            val uri = Uri.parse(formData.imageUrl)
            val imageRef = storage.reference.child("images/${System.currentTimeMillis()}.jpg")

            imageRef.putFile(uri)
                .addOnSuccessListener {
                    imageRef.downloadUrl.addOnSuccessListener { downloadUrl ->
                        val finalData = formData.copy(imageUrl = downloadUrl.toString())
                        saveToFirestore(finalData)
                    }
                }
                .addOnFailureListener {
                    // Handle image upload failure
                }
        } else {
            saveToFirestore(formData)
        }
    }

    private fun saveToFirestore(data: jobdetailsmodel) {
        val formMap = hashMapOf(
            "title" to data.title,
            "call" to data.call,
            "address" to data.address,
            "age" to data.age,
            "salary" to data.Salary,
            "description" to data.description,
            "date" to data.date,
            "imageUrl" to (data.imageUrl ?: "")
        )

        firestore.collection("forms")
            .add(formMap)
            .addOnSuccessListener {
                getFormData() // refresh list
            }
            .addOnFailureListener {
                // Handle save failure
            }
    }

    fun getFormData() {
        firestore.collection("forms")
            .get()
            .addOnSuccessListener { querySnapshot ->
                formDataList.clear()
                for (doc in querySnapshot.documents) {
                    val data = jobdetailsmodel(
                        title = doc.getString("title") ?: "",
                        call = doc.getString("call") ?: "",
                        address = doc.getString("address") ?: "",
                        age = doc.getString("age") ?: "",
                        Salary = doc.getString("salary") ?: "",
                        description = doc.getString("description") ?: "",
                        imageUrl = doc.getString("imageUrl"),
                        date = doc.getString("date") ?: ""
                    )
                    formDataList.add(data)
                }
            }
            .addOnFailureListener {
                // Handle fetch failure
            }
    }
}

