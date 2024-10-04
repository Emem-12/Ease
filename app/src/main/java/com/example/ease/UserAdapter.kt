package com.example.ease

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ease.databinding.UserViewItemBinding

class UserAdapter(private val users: List<User>, private val context: Context) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(private val binding: UserViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.apply {
                name.text = user.name
                userName.text = user.username
                website.text = user.website

                address.text = "Lives in ${user.address.street}, ${user.address.city}"
                company.text = "Works at ${user.company.name}"

                icPhone.setOnClickListener {
                    Toast.makeText(context, user.phone, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UserViewItemBinding.inflate(layoutInflater, parent, false)
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


