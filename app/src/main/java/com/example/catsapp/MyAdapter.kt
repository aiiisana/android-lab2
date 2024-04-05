import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.catsapp.Cat
import com.example.catsapp.CatDiffUtil
import com.example.catsapp.R
import com.example.catsapp.databinding.ItemLayoutBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class MyAdapter : RecyclerView.Adapter<MyAdapter.CatViewHolder>() {

    private val catsList: ArrayList<Cat> = arrayListOf()

    fun setItems(cats: List<Cat>) {
        val diffUtil = CatDiffUtil(catsList, cats)
        val diffResult = DiffUtil.calculateDiff(diffUtil)

        catsList.clear()
        catsList.addAll(cats    )
        diffResult.dispatchUpdatesTo(this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return catsList.size
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(catsList[position])
    }

    inner class CatViewHolder(private val binding: ItemLayoutBinding) :        RecyclerView.ViewHolder(binding.root) {
        fun bind(cat: Cat) {
            with(binding) {
                CatName.text = cat.name
                CatLength.text = "Length: ${cat.length}"
                CatOrigin.text = "Origin: ${cat.origin}"
                CatFamilyFriendly.text = "Family Friendly: ${cat.familyFriendly}"
                CatPlayfulness.text = "Playfulness: ${cat.playfulness}"
                CatIntelligence.text = "Intelligence: ${cat.intelligence}"
                Picasso.get()
                    .load(cat.imageLink)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.ic_launcher_background)
                    .into(img, object : Callback {
                        override fun onSuccess() {}
                        override fun onError(e: Exception?) {}                    })
            }        }
    }}