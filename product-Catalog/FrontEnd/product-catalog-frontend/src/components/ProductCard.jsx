import React from 'react'

function ProductCard({product}) {
  return (
   <div>

            <img src={product.imageUrl} />

            <h2>{product.name}</h2>

            <p>{product.price}</p>
            
            <p>{product.description}</p>

        </div>

  )
}

export default ProductCard