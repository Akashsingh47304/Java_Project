import { useEffect, useState } from "react";

function App() {
  const [products, setProducts] = useState([]);
  const [search ,setSearch]=useState("");

  useEffect(() => {
    fetch("http://localhost:8080/api/products")
      .then((response) => response.json())
      .then((data) => setProducts(data))
      .catch((error) => console.error(error));
  }, []);
  const filteredProducts = products.filter((product) =>
    product.name.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <div className="min-h-screen bg-olive-200 p-8">
      <h1 className="text-3xl font-bold text-center mb-8">
        Product Catalog
      </h1>
       <div className="flex justify-center mb-6">
        <input
          type="text"
          placeholder="Search products..."
          value={search}
          onChange={(e) => setSearch(e.target.value)}
          className="w-full max-w-md px-4 py-2 border rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
        />
      </div>

      {products.length > 0 ? (
        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
          {filteredProducts.map((product) => (
            <div
              key={product.id}
              className="bg-white rounded-xl shadow-md p-6 hover:shadow-xl transition duration-300"
            >
              <h2 className="text-xl font-semibold text-gray-800">
                {product.name}
              </h2>

              <p className="text-green-600 font-bold mt-2">
                ₹{product.price}
              </p>

              <p className="text-gray-600 mt-3">
                {product.description}
              </p>

              <button className="mt-5 w-full bg-blue-600 text-white py-2 rounded-lg hover:bg-blue-700 transition">
                View Details
              </button>
            </div>
          ))}
        </div>
      ) : (
        <div className="flex justify-center items-center h-64">
          <p className="text-xl text-gray-500">Loading products...</p>
        </div>
      )}
    </div>
  );
}

export default App;