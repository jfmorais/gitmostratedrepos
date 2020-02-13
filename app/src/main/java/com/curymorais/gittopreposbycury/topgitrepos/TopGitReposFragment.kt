package com.curymorais.gittopreposbycury.topgitrepos

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.curymorais.gittopreposbycury.R
import kotlinx.android.synthetic.main.list_top_git_repos.*

class TopGitReposFragment : Fragment(){

    val TAG = TopGitReposFragment::class.java.simpleName
    lateinit var adapter: TopGitReposFragmentAdapter

    private lateinit var viewModel: TopGitReposViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_top_git_repos, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponents()
    }

    @SuppressLint("FragmentLiveDataObserve")
    fun initComponents() {
        adapter =
            TopGitReposFragmentAdapter()
        recycler_item_list.adapter = adapter
        val llm = LinearLayoutManager(activity)
        recycler_item_list.layoutManager = llm

        viewModel =  ViewModelProvider(this).get(TopGitReposViewModel::class.java)
        showFirstTodo()
    }

//    private fun addItem() {
//        val builder = AlertDialog.Builder(context!!,R.style.CustomAlertDialog)
//        val view = layoutInflater.inflate(R.layout.dialog_add_wanted_item, null)
//        val itemName = view.findViewById(R.id.edit_text_item_name) as EditText
//        val itemPrice = view.findViewById(R.id.edit_text_item_price) as EditText
//
//        builder.setPositiveButton(R.string.button_ok) { dialog, id ->
//            viewModel.addItem(itemName.text.toString(),itemPrice.text.toString())
//        }
//        builder.setNegativeButton(R.string.button_cancel) { dialog, id -> dialog.cancel()}
//
//        builder.create().window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        builder.setView(view).show()
//
//    }

//    private fun updateTotal() {
//        val locale: Locale = Locale.getDefault()
//        val fmt: NumberFormat = NumberFormat.getCurrencyInstance(locale)
//        val currencyText: String = fmt.format(viewModel.returnTotal())
//        text_total_value.text = currencyText
//    }

    private fun showFirstTodo() {

        //scroll infinito
        //https://api.github.com/search/repositories?q=language:kotlin&sort=stars&page=1
        //nome repo, qtd star,qtd fork, foto,nome autor
        viewModel.firstTodo.observe(viewLifecycleOwner, Observer { itens ->
            // Update the cached copy of the words in the adapter.
            itens?.let {
                for(i in it.items) {
                    Log.i("Cury", i.full_name)
                }
                adapter.updateList(it.items)
            }
        })
    }
}

