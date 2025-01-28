package com.example.hilt_dependency_injection_example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hilt_dependency_injection_example.R
import com.example.hilt_dependency_injection_example.models.Product

// Adapter class for displaying products in a RecyclerView
class ProductAdapter(private val mProductList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    // ViewHolder class that holds the views for each product item
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // ImageView and TextView are initialized to represent product image and title
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.tv_title)
    }

    // Called when RecyclerView needs a new ViewHolder to display a new item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        // Inflating the layout for each product item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        // Returning a new ViewHolder that contains the itemView
        return ProductViewHolder(view)
    }

    // Returns the total number of items in the product list
    override fun getItemCount(): Int {
        return mProductList.size
    }

    // Called to bind the data (product) to each ViewHolder
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        // Get the product for the current position
        val mProduct = mProductList[position]

        // Use Glide to load the product image into the ImageView
        Glide.with(holder.imageView.context)
            .load(mProduct.image)
            .into(holder.imageView)

        // Set the title of the product into the TextView
        holder.textView.text = mProduct.title
    }
}