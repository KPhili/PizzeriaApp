package com.example.pizzeriaapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pizzeriaapp.R
import com.example.pizzeriaapp.databinding.RvProductItemBinding
import com.example.pizzeriaapp.domain.models.Product
import com.example.pizzeriaapp.presentation.utils.IImageLoader

class ProductsAdapter(
    productComparator: ProductComparator,
    private val imageLoader: IImageLoader
) :
    PagingDataAdapter<Product, ProductsAdapter.ProductViewHolder>(productComparator) {

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductViewHolder(
        RvProductItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    inner class ProductViewHolder(private val binding: RvProductItemBinding) :
        ViewHolder(binding.root) {
        fun bind(product: Product?) = with(binding) {
            product?.let {
                nameView.text = product.name
                descriptionView.text = product.description
                product.price?.let {
                    val priceText = root.context.getString(R.string.price, it)
                    buyView.text = priceText
                }
                product.imageUrl?.let {
                    imageLoader.loadRoundedImage(it, imageView)
                }
            }
        }
    }

    class ProductComparator : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Product, newItem: Product) =
            oldItem.id == newItem.id
    }
}