package com.example.serviceapp.LanourJob.JobViewModel

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.serviceapp.LanourJob.Model.jobdetailsmodel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

class JobViewModel: ViewModel (){




    private val db = FirebaseFirestore.getInstance()
    private val storage = FirebaseStorage.getInstance()

    var jobList by mutableStateOf<List<jobdetailsmodel>>(emptyList())
        private set

    var loading by mutableStateOf(false)
        private set

    fun addJob(donor: jobdetailsmodel, imageUri: Uri?, onSuccess: () -> Unit, onError: (String) -> Unit) {
        loading = true

        if (imageUri != null) {
            val fileName = java.util.UUID.randomUUID().toString()
            val imageRef = storage.reference.child("jobs/$fileName")

            imageRef.putFile(imageUri)
                .continueWithTask { task ->
                    if (!task.isSuccessful) {
                        task.exception?.let { throw it }
                    }
                    imageRef.downloadUrl
                }
                .addOnSuccessListener { uri ->
                    val doctorWithImage = donor.copy(imageUrl = uri.toString())

                    db.collection("jobs")
                        .add(doctorWithImage)
                        .addOnSuccessListener {
                            loading = false
                            onSuccess()
                        }
                        .addOnFailureListener {
                            loading = false
                            onError(it.message ?: "Failed to add donor")
                        }
                }
                .addOnFailureListener {
                    loading = false
                    onError(it.message ?: "Image upload failed")
                }
        } else {
            db.collection("jobs")
                .add(donor)
                .addOnSuccessListener {
                    loading = false
                    onSuccess()
                }
                .addOnFailureListener {
                    loading = false
                    onError(it.message ?: "Failed to add donor")
                }
        }
    }

    fun fetchJobs() {
        loading = true
        db.collection("jobs")
            .get()
            .addOnSuccessListener { result ->
                jobList = result.documents.map { doc ->
                    doc.toObject(jobdetailsmodel::class.java)?.copy(id = doc.id) ?: jobdetailsmodel()
                }
                loading = false
            }
            .addOnFailureListener {
                loading = false
            }
    }
}