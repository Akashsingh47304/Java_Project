
export const getAllProducts=()=>{
    api.get("/products")
}

export const getProductByCategory=(id)=>{
    api.get(`/products/category/${id}`);
}