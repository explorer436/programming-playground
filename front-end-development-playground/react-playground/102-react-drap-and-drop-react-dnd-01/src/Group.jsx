// Drop Target Component

import React from 'react';
import { useDrop } from 'react-dnd';
import { ItemTypes } from './ItemTypes';
import Fruit from './Fruit'; // We'll render fruits inside the group

const style = {
    minHeight: '8rem', // Ensure groups have some height even when empty
    minWidth: '10rem', // Ensure groups have some width
    margin: '1rem',
    padding: '1rem',
    border: '1px solid black',
    float: 'left', // Basic layout
};

function Group({ id, title, items = [], onDropItem }) {
    const [{ canDrop, isOver }, drop] = useDrop(() => ({
        accept: ItemTypes.FRUIT,
        // The 'drop' function now receives the item (with name and sourceGroupKey)
        // and calls the onDropItem callback passed from the parent (App).
        drop: (item, monitor) => {
            if (item.sourceGroupKey !== id) { // Prevent dropping into the same group
                onDropItem(item.name, item.sourceGroupKey, id); // Pass name, source, and target
            }
            // Optionally return data about the drop target
            // return { targetGroupId: id };
        },
        collect: (monitor) => ({
            isOver: monitor.isOver(),
            canDrop: monitor.canDrop(),
        }),
    }));

    const isActive = canDrop && isOver;
    let backgroundColor = '#f0f0f0'; // Default background
    if (isActive) {
        backgroundColor = 'lightblue'; // Highlight when item is hovering over
    } else if (canDrop) {
        backgroundColor = '#e0e0e0'; // Highlight when a draggable item is available
    }

    return (
        <div ref={drop} style={{ ...style, backgroundColor }} data-testid={`group-${id}`}>
            <h3>{title}</h3>
            <div style={{ minHeight: '5rem' }}> {/* Inner div to contain fruits */}
                {items.map((fruitName) => (
                    // Render the fruits currently in this group
                    // Pass the group's 'id' as the 'currentGroupKey' for these fruits
                    <Fruit key={fruitName} name={fruitName} currentGroupKey={id} />
                ))}
            </div>
        </div>
    );
}

export default Group;