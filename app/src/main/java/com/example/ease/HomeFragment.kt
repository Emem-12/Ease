package com.example.ease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ease.databinding.CustomAlertDialogBinding
import com.example.ease.databinding.FragmentHomeBinding
import com.example.ease.repo.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var userAdapter: UserAdapter
    private lateinit var users: MutableList<User>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        users = mutableListOf()
        userAdapter = UserAdapter(users, requireContext())

        getListOfUsers()

        binding.recyclerView.apply {
            adapter = userAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun getListOfUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = UserRepository().getUsers()

            when (response) {
                is Response.Success -> {
                    withContext(Dispatchers.Main) {
                        val listOfUsers = response.data as List<User>
                        users.addAll(listOfUsers)
                        userAdapter.notifyItemRangeInserted(0, listOfUsers.size)
                    }
                }

                is Response.Failure -> {
//                    Snackbar.make(binding.root, response.message, Snackbar.LENGTH_INDEFINITE).show()
                    withContext(Dispatchers.Main) {
//                        showErrorDialog(message = response.message)
                        showCustomViewErrorDialog(message = response.message)
                    }
                }
            }

            withContext(Dispatchers.Main) {
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun showErrorDialog(message: String) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setMessage(message)

        //Test features.
        alertDialog.setTitle("hello user")
        alertDialog.setIcon(R.drawable.icon_phone_call)
        alertDialog.setCancelable(false)

        alertDialog.setPositiveButton("Retry") { _, _ ->
            //
        }
        alertDialog.setNegativeButton(
            "Okay"
        ) { _, _ ->
            //
        }
        alertDialog.setNeutralButton(
            "Hmm!"
        ) { _, _ ->
            //
        }
        alertDialog.show()
    }

    private fun showCustomViewErrorDialog(message: String) {
        val alertDialogBuilder = AlertDialog.Builder(requireContext())

        var alertDialog: AlertDialog? = null

        val layoutInflater = LayoutInflater.from(requireContext())
        val customAlertDialogBinding = CustomAlertDialogBinding.inflate(layoutInflater)
        alertDialogBuilder.setView(customAlertDialogBinding.root)

        alertDialogBuilder.setIcon(R.drawable.icon_phone_call)
        alertDialogBuilder.setCancelable(false)

        customAlertDialogBinding.apply {
            title.text = "hello user"

            this.message.text = message

            negativeButton.text = "Okay"
            negativeButton.setOnClickListener {
                alertDialog?.dismiss()
            }

            positiveButton.text = "Retry"
            positiveButton.setOnClickListener {
                binding.progressBar.visibility = View.VISIBLE
                getListOfUsers()
                alertDialog?.dismiss()
            }
        }

        alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}