package com.example.ease

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ease.databinding.FragmentHomeBinding

class UserAdapter (private val users: List<User>, function: () -> Unit):
        RecyclerView.Adapter<UserAdapter.UserViewHolder>() {



  inner class UserViewHolder(val binding: FragmentHomeBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.name.text = user.name
            binding.description.text = user.description
            binding.userName.text = user.userName
            binding.address.text = "${user.address.street}, ${user.address.lGA}, ${user.address.country}"
            binding.website.text = user.website

            binding.icPhone.setOnClickListener {

                Toast.makeText(itemView.context, user.phoneNumber, Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FragmentHomeBinding.inflate(layoutInflater, parent, false)
        val userViewHolder = UserViewHolder(binding)

        return userViewHolder
    }


    override fun onBindViewHolder(
        holder: UserViewHolder,
        position: Int
    ) {
     holder.bind(users[position])
    }

    override fun getItemCount(): Int {
       return users.size
    }


    }


