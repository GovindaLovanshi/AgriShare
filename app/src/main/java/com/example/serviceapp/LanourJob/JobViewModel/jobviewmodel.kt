package com.example.serviceapp.LanourJob.JobViewModel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.serviceapp.LanourJob.Model.jobdetailsmodel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.launch
import java.util.UUID


class jobviewmodel : ViewModel() {

        private val db = FirebaseFirestore.getInstance()
        private val storage = FirebaseStorage.getInstance()

        private val userCollection = db.collection("users")

        // Add or Update user data
        fun addOrUpdateUser(userData:jobdetailsmodel) {
            viewModelScope.launch {
                val userId = UUID.randomUUID().toString() // Or use an existing ID for update
                userCollection.document(userId).set(userData)
            }
        }

    // Fetch user data
    fun fetchUserData(onSuccess: (List<jobdetailsmodel>) -> Unit, onFailure: (Exception) -> Unit) {
        userCollection.get()
            .addOnSuccessListener { result ->
                val users = result.documents.map { doc ->
                    jobdetailsmodel(
                        title = doc.getString("title") ?: "",
                        call = doc.getString("call") ?: "",
                        address = doc.getString("address") ?: "",
                        description = doc.getString("description") ?: "",
                        imageUrl = doc.getString("imageUrl") ?: "",
                        date = doc.getString("date") ?: "",
                    )
                }
                onSuccess(users)
            }
            .addOnFailureListener { exception ->
                onFailure(exception)
            }
    }

    // Upload image to Firebase Storage
    fun uploadImage(imageUri: Uri, onSuccess: (String) -> Unit, onFailure: (Exception) -> Unit) {
        val storageRef: StorageReference = storage.reference.child("images/${UUID.randomUUID()}")
        val uploadTask = storageRef.putFile(imageUri)

        uploadTask.addOnSuccessListener {
            storageRef.downloadUrl.addOnSuccessListener { uri ->
                onSuccess(uri.toString())
            }
        }.addOnFailureListener { exception ->
            onFailure(exception)
        }
    }

    // Function to upload form data to Firebase Firestore
    fun uploadFormData(jobdata: jobdetailsmodel, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        db.collection("forms")
            .add(jobdata)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener { exception ->
                onFailure(exception)
            }
    }
}