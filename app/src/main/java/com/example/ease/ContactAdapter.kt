package com.example.ease

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ease.databinding.FragmentHomeBinding

class ContactAdapter (private val contacts: List<Contact>):
        RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {



  inner class ContactViewHolder(val binding: FragmentHomeBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact, position: Int) {
            binding.name.text = contact.name
            binding.description.text = contact.description
            binding.userName.text = contact.userName
            binding.address.text = contact.address
            binding.website.text = contact.website

            binding.icPhone.setOnClickListener {
                Toast.makeText(itemView.context, contact.phoneNumber, Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FragmentHomeBinding.inflate(layoutInflater, parent, false)
        val contactViewHolder = ContactViewHolder(binding)

        return contactViewHolder
    }


    override fun onBindViewHolder(
        holder: ContactViewHolder,
        position: Int
    ) {
     holder.bind(contacts,position)
    }

    override fun getItemCount(): Int {
       return contacts.size
    }


    }


