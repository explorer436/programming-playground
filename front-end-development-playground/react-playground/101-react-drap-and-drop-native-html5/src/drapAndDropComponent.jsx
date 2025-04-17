import React, { useState } from 'react';
import './App.css'; // We'll add some basic styling

function DrapAndDropComponent() {

    // Initial items in each list
    const [availableItems, setAvailableItems] = useState([
        { id: 'item-1', text: 'Item 1' },
        { id: 'item-2', text: 'Item 2' },
        { id: 'item-3', text: 'Item 3' },
    ]);

    const [droppedItems, setDroppedItems] = useState([
        { id: 'item-4', text: 'Item 4 (already dropped)' },
    ]);

    // --- Drag and Drop Handlers ---

    const handleDragStart = (e, itemId) => {
        console.log('Drag Start:', itemId);
        // Store the ID of the item being dragged
        e.dataTransfer.setData('text/plain', itemId);
        // Optional: Add a visual effect (like opacity) to the dragged item
        e.currentTarget.style.opacity = '0.5';
    };

    const handleDragEnd = (e) => {
        // Optional: Reset visual effect when drag ends (whether dropped successfully or not)
        e.currentTarget.style.opacity = '1';
    };

    const handleDragOver = (e) => {
        // Prevent default behavior to allow dropping
        e.preventDefault();
        // Optional: Add visual feedback to the drop zone
        e.currentTarget.classList.add('drag-over');
        console.log('Drag Over Drop Zone');
    };

    const handleDragLeave = (e) => {
        // Optional: Remove visual feedback when dragging leaves the drop zone
        e.currentTarget.classList.remove('drag-over');
    };

    const handleDrop = (e, targetListName) => {
        e.preventDefault(); // Prevent default browser handling (like opening link)
        e.currentTarget.classList.remove('drag-over'); // Remove visual feedback

        const itemId = e.dataTransfer.getData('text/plain');
        console.log(`Dropped Item ID: ${itemId} onto ${targetListName}`);

        // Find the dragged item's data and its original list
        let draggedItem = null;
        let sourceListName = null;

        if (availableItems.find(item => item.id === itemId)) {
            draggedItem = availableItems.find(item => item.id === itemId);
            sourceListName = 'available';
        } else if (droppedItems.find(item => item.id === itemId)) {
            draggedItem = droppedItems.find(item => item.id === itemId);
            sourceListName = 'dropped';
        }

        // If the item was found and it's not being dropped onto its current list
        if (draggedItem && sourceListName !== targetListName) {
            // Remove from source list
            if (sourceListName === 'available') {
                setAvailableItems(prev => prev.filter(item => item.id !== itemId));
            } else {
                setDroppedItems(prev => prev.filter(item => item.id !== itemId));
            }

            // Add to target list
            if (targetListName === 'available') {
                setAvailableItems(prev => [...prev, draggedItem]);
            } else {
                setDroppedItems(prev => [...prev, draggedItem]);
            }
        } else {
            console.log("Drop cancelled - item not found or dropped in the same list.");
        }
    };


    // --- Render ---

    return (
        <div className="app-container">
            <h1>Simple React Drag and Drop</h1>

            <div className="lists-container">
                {/* Available Items List (Drop Zone 1) */}
                <div
                    className="drop-zone"
                    onDragOver={handleDragOver}
                    onDragLeave={handleDragLeave}
                    onDrop={(e) => handleDrop(e, 'available')} // Pass target list name
                >
                    <h2>Available Items</h2>
                    {availableItems.length === 0 && <p className="empty-message">Drop items here</p>}
                    {availableItems.map((item) => (
                        <div
                            key={item.id}
                            id={item.id}
                            className="draggable-item"
                            draggable="true" // Make this element draggable
                            onDragStart={(e) => handleDragStart(e, item.id)}
                            onDragEnd={handleDragEnd} // Reset opacity on drag end
                        >
                            {item.text}
                        </div>
                    ))}
                </div>

                {/* Dropped Items List (Drop Zone 2) */}
                <div
                    className="drop-zone"
                    onDragOver={handleDragOver}
                    onDragLeave={handleDragLeave}
                    onDrop={(e) => handleDrop(e, 'dropped')} // Pass target list name
                >
                    <h2>Dropped Items</h2>
                    {droppedItems.length === 0 && <p className="empty-message">Drop items here</p>}
                    {droppedItems.map((item) => (
                        <div
                            key={item.id}
                            id={item.id}
                            className="draggable-item"
                            draggable="true" // Make this element draggable
                            onDragStart={(e) => handleDragStart(e, item.id)}
                            onDragEnd={handleDragEnd} // Reset opacity on drag end
                        >
                            {item.text}
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}

export default DrapAndDropComponent;