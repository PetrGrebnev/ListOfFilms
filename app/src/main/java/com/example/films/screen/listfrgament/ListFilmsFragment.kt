package com.example.films.screen.listfrgament

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.films.App
import com.example.films.R
import com.example.films.databinding.FragmentListFilmsBinding
import com.example.films.screen.adapter.FilmsRecyclerViewAdapter
import com.example.films.utils.CheckInternetConnection
import com.example.films.utils.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListFilmsFragment : Fragment(R.layout.fragment_list_films) {

    @Inject
    lateinit var viewModelProvider: ListFilmsViewModelProvider

    private lateinit var viewModel: ListFilmsViewModel
    private lateinit var adapter: FilmsRecyclerViewAdapter

    private var bindingFragment: FragmentListFilmsBinding? = null
    private val binding
        get() = bindingFragment

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelProvider)[ListFilmsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        bindingFragment = FragmentListFilmsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterCreate()
    }

    private fun adapterCreate() {
        adapter = FilmsRecyclerViewAdapter { title ->
            findNavController().navigate(
                ListFilmsFragmentDirections.actionListFilmsFragmentToDialogFragment(
                    title
                )
            )
        }
        binding?.apply {
            recyclerViewFilms.layoutManager = LinearLayoutManager(requireContext())
            recyclerViewFilms.adapter = adapter
        }
        observeFilms()
    }

    private fun observeFilms() {
        isConnectionInternet()
        viewModel.films.observe(viewLifecycleOwner) {
            when (it) {
                is ResultState.Loading -> {
                    lifecycleScope.launch(Dispatchers.Main) {
                        binding?.apply {
                            splash.visibility = View.VISIBLE
                            recyclerViewFilms.visibility = View.GONE
                            textError.visibility = View.GONE
                        }
                    }
                }
                is ResultState.Success -> {
                    lifecycleScope.launch(Dispatchers.Main) {
                        binding?.apply {
                            splash.visibility = View.GONE
                            recyclerViewFilms.visibility = View.VISIBLE
                            textError.visibility = View.GONE
                        }
                        adapter.setList(it.data)
                    }
                }
                is ResultState.Error -> {
                    lifecycleScope.launch(Dispatchers.Main) {
                        binding?.apply {
                            splash.visibility = View.GONE
                            recyclerViewFilms.visibility = View.GONE
                            textError.visibility = View.VISIBLE
                            textError.text = it.throwable.message
                        }
                    }
                }
            }
        }
    }

    private fun isConnectionInternet(){
        if(!CheckInternetConnection.isInternetAvailable(requireContext())){
            Toast.makeText(
                requireContext(),
                "Нет подключения к интернету",
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }
}