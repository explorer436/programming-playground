import React, { useState, useEffect } from 'react';
import './DynamicForm.css'; // Optional: for basic styling

// Helper function to generate simple unique IDs (replace with UUID in production)
const generateId = () => `cat_${Date.now()}_${Math.random().toString(36).substring(2, 7)}`;

function DynamicCategoryForm() {
    // --- State ---
    const [formData, setFormData] = useState({
        itemName: '',
        description: '',
        categoryId: '', // Store the ID of the selected category
    });

    const [categories, setCategories] = useState([
        // Initial categories (could be fetched from an API)
        { id: 'cat_1', name: 'Electronics' },
        { id: 'cat_2', name: 'Books' },
        { id: 'cat_3', name: 'Clothing' },
    ]);

    const [newCategoryName, setNewCategoryName] = useState('');
    const [isAddingCategory, setIsAddingCategory] = useState(false); // Optional loading state
    const [addCategoryError, setAddCategoryError] = useState(null);

    // --- Effects ---
    // Optional: Fetch initial categories from an API on component mount
    // useEffect(() => {
    //   fetch('/api/categories')
    //     .then(res => res.json())
    //     .then(data => setCategories(data))
    //     .catch(err => console.error("Failed to fetch categories:", err));
    // }, []);

    // --- Handlers ---

    // Handles changes in the main form fields (item name, description, category select)
    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: value,
        }));
    };

    // Handles changes in the "new category" input field
    const handleNewCategoryChange = (event) => {
        setNewCategoryName(event.target.value);
        if (addCategoryError) setAddCategoryError(null); // Clear error on typing
    };

    // Handles adding a new category
    const handleAddCategory = async () => { // Make async if calling an API
        const trimmedName = newCategoryName.trim();

        // Basic Validation
        if (!trimmedName) {
            setAddCategoryError('Category name cannot be empty.');
            return;
        }
        const exists = categories.some(
            (cat) => cat.name.toLowerCase() === trimmedName.toLowerCase()
        );
        if (exists) {
            setAddCategoryError('Category already exists.');
            return;
        }

        setIsAddingCategory(true);
        setAddCategoryError(null);

        // --- Simulate API Call (Replace with actual API call) ---
        try {
            // In a real app, you'd POST the new category to your backend:
            // const response = await fetch('/api/categories', {
            //   method: 'POST',
            //   headers: { 'Content-Type': 'application/json' },
            //   body: JSON.stringify({ name: trimmedName }),
            // });
            // if (!response.ok) throw new Error('Failed to save category');
            // const savedCategory = await response.json(); // Assuming API returns the saved category with ID

            // --- If API call is successful ---
            // For simulation, we generate ID locally:
            const newCategory = {
                id: generateId(), // Use savedCategory.id from API response in real app
                name: trimmedName,
            };

            // Update categories state
            setCategories((prevCategories) => [...prevCategories, newCategory]);

            // Automatically select the newly added category
            setFormData((prevData) => ({
                ...prevData,
                categoryId: newCategory.id, // Use newCategory.id
            }));

            // Clear the input field
            setNewCategoryName('');

        } catch (error) {
            console.error("Error adding category:", error);
            setAddCategoryError(error.message || 'Could not add category. Please try again.');
        } finally {
            setIsAddingCategory(false);
        }
        // --- End Simulation ---
    };

    // Handles the main form submission
    const handleSubmit = (event) => {
        event.preventDefault();
        console.log('Form Submitted:', formData);
        // Find the full category object if needed
        const selectedCategory = categories.find(cat => cat.id === formData.categoryId);
        console.log('Selected Category Object:', selectedCategory);
        // Add logic to send formData (and potentially selectedCategory) to your backend API
        alert(`Submitting item: ${formData.itemName} in category: ${selectedCategory?.name || 'None'}`);
        // Reset form or navigate away etc.
    };

    // --- Rendering ---
    return (
        <form onSubmit={handleSubmit} className="dynamic-form">
            <h2>Create New Item</h2>

            {/* Item Name Input */}
            <div className="form-group">
                <label htmlFor="itemName">Item Name:</label>
                <input
                    type="text"
                    id="itemName"
                    name="itemName"
                    value={formData.itemName}
                    onChange={handleInputChange}
                    required
                />
            </div>

            {/* Description Input */}
            <div className="form-group">
                <label htmlFor="description">Description:</label>
                <textarea
                    id="description"
                    name="description"
                    value={formData.description}
                    onChange={handleInputChange}
                />
            </div>

            {/* Category Selection */}
            <div className="form-group">
                <label htmlFor="categoryId">Category:</label>
                <select
                    id="categoryId"
                    name="categoryId"
                    value={formData.categoryId}
                    onChange={handleInputChange}
                    required
                >
                    <option value="" disabled>-- Select a Category --</option>
                    {categories.map((category) => (
                        <option key={category.id} value={category.id}>
                            {category.name}
                        </option>
                    ))}
                </select>
            </div>

            {/* Add New Category Section */}
            <div className="add-category-section form-group">
                <label htmlFor="newCategoryName">Or Add New Category:</label>
                <div className="add-category-controls">
                    <input
                        type="text"
                        id="newCategoryName"
                        placeholder="Enter new category name"
                        value={newCategoryName}
                        onChange={handleNewCategoryChange}
                        disabled={isAddingCategory}
                    />
                    <button
                        type="button" // Important: prevent default form submission
                        onClick={handleAddCategory}
                        disabled={isAddingCategory || !newCategoryName.trim()} // Disable if adding or input empty
                    >
                        {isAddingCategory ? 'Adding...' : 'Add Category'}
                    </button>
                </div>
                {addCategoryError && <p className="error-message">{addCategoryError}</p>}
            </div>

            {/* Submit Button */}
            <button type="submit" className="submit-button" disabled={isAddingCategory}>
                Submit Item
            </button>
        </form>
    );
}

export default DynamicCategoryForm;