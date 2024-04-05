package com.example.catsapp
import MyAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catsapp.databinding.FragmentCatBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class CatFragment : Fragment() {
    private var _binding: FragmentCatBinding? = null
    private val binding get() = _binding!!
    private val adapter = MyAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.searchBar.setOnEditorActionListener{ it, actionId, _ ->
            if(actionId == android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH){
            ApiClient.instance.getCat(it.text.toString()).enqueue(object : Callback<List<Cat>>{
                override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                if (response.isSuccessful) {
                    response.body()?.let { it1 -> adapter.setItems(it1) }
                }
                else {
                    Log.e("Network", response.errorBody().toString())                        }
            }
                override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                    Log.e("Network", t.message.toString())
                }
            })
                true
        }else false
        }
    }
}