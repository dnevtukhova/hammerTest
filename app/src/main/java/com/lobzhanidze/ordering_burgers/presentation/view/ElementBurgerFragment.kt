package com.lobzhanidze.ordering_burgers.presentation.view

import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmsearch.data.entity.ElementItem
import com.lobzhanidze.ordering_burgers.App
import com.lobzhanidze.ordering_burgers.R
import com.lobzhanidze.ordering_burgers.presentation.view.recycler.ElementAdapter
import com.lobzhanidze.ordering_burgers.presentation.view.recyclerStock.StockAdapter
import com.lobzhanidze.ordering_burgers.presentation.view.recyclerStock.StockHolder
import com.lobzhanidze.ordering_burgers.presentation.viewModel.ElementListViewModel
import com.lobzhanidze.ordering_burgers.presentation.viewModel.ElementListViewModelFactory
import javax.inject.Inject

class ElementBurgerFragment : Fragment() {

    companion object {
        const val TAG = "ElementListFragment"
    }

    private var elementList = arrayListOf<ElementItem>()

    lateinit var layoutManager: LinearLayoutManager
    lateinit var stockLayoutManager: LinearLayoutManager
    lateinit var elementAdapter: ElementAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var stockAdapter: StockAdapter
    lateinit var stockRecyclerView: RecyclerView

    lateinit var fantasyButton: Button
    lateinit var dramaButton: Button
    lateinit var comedyButton: Button
    lateinit var melodramaButton: Button
    lateinit var actionButton: Button

    lateinit var elementListViewModel: ElementListViewModel

    @Inject
    lateinit var factory: ElementListViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_element_list, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        stockRecyclerView = view.findViewById(R.id.recyclerViewStock)
        fantasyButton = view.findViewById(R.id.fantasy)
        dramaButton = view.findViewById(R.id.drama)
        comedyButton = view.findViewById(R.id.comedy)
        melodramaButton = view.findViewById(R.id.melodrama)
        actionButton = view.findViewById(R.id.action)
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        App.instance.elementComponent.inject(this)
        elementListViewModel = ViewModelProvider(requireActivity(), factory).get(ElementListViewModel::class.java)

        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        stockLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        stockRecyclerView.layoutManager = stockLayoutManager
        elementAdapter = ElementAdapter(LayoutInflater.from(context))
        stockAdapter = StockAdapter(LayoutInflater.from(context))
        recyclerView.adapter = elementAdapter
        stockRecyclerView.adapter = stockAdapter
        recyclerView.addItemDecoration(ItemOffsetDecoration(20))


        initVM()
    }

    private fun initVM() {
        elementListViewModel.loadElementList(requireContext(), 1)

        lifecycleScope.launchWhenCreated {
            elementListViewModel.elementList.collect { elements ->
                elementList.clear()
                elementList.addAll(elements)
                elementAdapter.setItems(elementList)
                stockAdapter.setItems(elementList)
            }
        }
    }

    fun initClickCategory(){

    }

}