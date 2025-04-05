package com.example.serviceapp.Equipment.Viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.serviceapp.Equipment.Model.EquipmentModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.launch
import java.util.UUID


class EquipmentViewModel : ViewModel() {

        private val db = FirebaseFirestore.getInstance()
        private val storage = FirebaseStorage.getInstance()

        private val userCollection = db.collection("item")

        // Add or Update user data
        fun addOrUpdateUser(userData:EquipmentModel) {
            viewModelScope.launch {
                val userId = UUID.randomUUID().toString() // Or use an existing ID for update
                userCollection.document(userId).set(userData)
            }
        }

    // Fetch user data
    fun fetchUserData(onSuccess: (List<EquipmentModel>) -> Unit, onFailure: (Exception) -> Unit) {
        userCollection.get()
            .addOnSuccessListener { result ->
                val item = result.documents.map { doc ->
                    EquipmentModel(
                        title = doc.getString("title") ?: "",
                        description = doc.getString("description") ?: "",
                        price = doc.getString("price") ?: "",
                        address = doc.getString("address") ?: "",
                        imageurl = doc.getString("imageUrl") ?: "",
                        numberIn = doc.getString("numberIn") ?: "",
                        ownerName = doc.getString("ownerName") ?: "",
                        quantity = doc.getString("quantity") ?: "",
                    )
                }
                onSuccess(item)
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
    fun uploadFormData(equipment: EquipmentModel, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        db.collection("forms")
            .add(equipment)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener { exception ->
                onFailure(exception)
            }
    }
}