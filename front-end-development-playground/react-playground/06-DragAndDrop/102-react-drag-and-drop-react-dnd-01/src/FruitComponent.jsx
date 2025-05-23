import React, {useCallback, useState} from "react";
import {DndProvider} from "react-dnd";
import {HTML5Backend} from "react-dnd-html5-backend";
import Group from "./Group.jsx";

const initialGroups = {
    available: [...initialFruits], // Start with all fruits available
    group1: [], // Fruit Basket
    group2: [], // Smoothie Ingredients
};

const groupTitles = {
    available: "Available Fruits",
    group1: "Fruit Basket",
    group2: "Smoothie Ingredients"
};

// This approach did not work. DndProvider has to be in App.jsx
function FruitComponent() {

    // Wrap the part of your app that needs D&D capabilities with DndProvider
    // It requires a 'backend' prop (HTML5Backend is standard for web)

    const [groups, setGroups] = useState(initialGroups);

    // The core logic: move a fruit from source group to target group
    const handleDrop = useCallback((fruitName, sourceGroupKey, targetGroupKey) => {
        console.log(`Moving ${fruitName} from ${sourceGroupKey} to ${targetGroupKey}`);

        // Prevent dropping into the same list or if keys are invalid
        if (!fruitName || !sourceGroupKey || !targetGroupKey || sourceGroupKey === targetGroupKey) {
            console.warn("Invalid drop operation", { fruitName, sourceGroupKey, targetGroupKey });
            return;
        }

        setGroups((prevGroups) => {
            const sourceItems = prevGroups[sourceGroupKey];
            const targetItems = prevGroups[targetGroupKey];

            // Check if fruit exists in source (sanity check)
            if (!sourceItems || !sourceItems.includes(fruitName)) {
                console.error(`Fruit ${fruitName} not found in source group ${sourceGroupKey}`);
                return prevGroups; // Return previous state if error
            }
            // Check if target group exists (sanity check)
            if (!targetItems) {
                console.error(`Target group ${targetGroupKey} does not exist`);
                return prevGroups; // Return previous state if error
            }

            // Create new state immutably
            const newGroups = { ...prevGroups };

            // Remove from source
            newGroups[sourceGroupKey] = sourceItems.filter(item => item !== fruitName);

            // Add to target (prevent duplicates if somehow possible, though shouldn't be with this logic)
            if (!targetItems.includes(fruitName)) {
                newGroups[targetGroupKey] = [...targetItems, fruitName];
            } else {
                // If it already exists in target (shouldn't happen if moving), just keep it
                newGroups[targetGroupKey] = [...targetItems];
            }


            return newGroups;
        });
    }, []); // useCallback ensures this function reference is stable

    return (
        <DndProvider backend={HTML5Backend}>
            <div className="App">
                <h1>Group Items with Drag and Drop</h1>
                <div style={{ display: 'flex', flexWrap: 'wrap' }}> {/* Use flexbox for layout */}
                    {Object.keys(groups).map((groupKey) => (
                        <Group
                            key={groupKey}
                            id={groupKey} // Unique ID for the group ('available', 'group1', 'group2')
                            title={groupTitles[groupKey]} // Display title
                            items={groups[groupKey]} // Fruits currently in this group
                            onDropItem={handleDrop} // Pass the handler function down
                        />
                    ))}
                </div>
            </div>
        </DndProvider>
    );
}