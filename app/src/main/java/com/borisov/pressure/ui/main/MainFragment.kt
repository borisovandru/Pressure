package com.borisov.pressure.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.borisov.pressure.data.Record
import com.borisov.pressure.databinding.FragmentMainBinding
import com.borisov.pressure.domain.RecordsRepositoryFirestore
import com.borisov.pressure.ui.BaseFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * @author Borisov Andrey on 12.07.2022
 **/
class MainFragment : BaseFragment<FragmentMainBinding>() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(
            this, MainViewModelFactory(
                RecordsRepositoryFirestore() // RecordsRepositoryStub()
            )
        )[MainViewModel::class.java]
    }
    private var adapter: MainRecyclerAdapter? = null
    private var fabListener: FabListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = MainRecyclerAdapter()
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(context)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel
                .stateFlow
                .collectLatest {
                    adapter?.populate(it)
                }
        }

        fabListener = context as? FabListener
        binding.fab.setOnClickListener { fabListener?.fabClicked() }
    }

    fun saveRecord(record: Record) {
        viewModel.saveRecord(record)
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMainBinding.inflate(inflater, container, false)
}