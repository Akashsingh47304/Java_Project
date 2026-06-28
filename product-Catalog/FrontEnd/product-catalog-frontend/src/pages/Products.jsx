import { useEffect, useState } from "react";
import { getAllProducts,getProductByCategory } from "../services/productService";
import ProductCard from "../components/ProductCard";

function Products() {

    const [products, setProducts] = useState([]);

 const [categories, setCategories] = useState([]);

        useEffect(() => {

            api.get("/categories")
                .then(res => setCategories(res.data));

        }, []);

    useEffect(() => {
        getAllProducts()
        .then(res=>setProducts(res.data));
        

    }, []);
    const handleCategory = (categoryId) => {

        getProductByCategory(categoryId)
            .then(res => setProducts(res.data))
            .catch(err => console.log(err));

    };




    return (

        <>
         <h2>Categories</h2>

            <button onClick={() => {
                getAllProducts()
                    .then(res => setProducts(res.data));
            }}>
                All
            </button>

            {categories.map(category => (

                <button
                    key={category.id}
                    onClick={() => handleCategory(category.id)}
                >
                    {category.name}
                </button>

            ))}

            <hr />
            
            {products.map(product => (
                <ProductCard
                    key={product.id}
                    product={product}
                />
            ))}
        </>

    );

}

export default Products;