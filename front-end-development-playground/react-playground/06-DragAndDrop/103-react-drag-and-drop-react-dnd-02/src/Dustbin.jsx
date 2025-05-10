// Drop Target Component

import React, { useState } from 'react';
import { useDrop } from 'react-dnd';
import { ItemTypes } from './ItemTypes';

const style = {
    height: '12rem',
    width: '12rem',
    marginRight: '1.5rem',
    marginBottom: '1.5rem',
    color: 'white',
    padding: '1rem',
    textAlign: 'center',
    fontSize: '1rem',
    lineHeight: 'normal',
    float: 'left', // To keep layout consistent with Boxes
};

function Dustbin() {
    const [lastDroppedItem, setLastDroppedItem] = useState(null);

    // useDrop hook exposes properties for the drop target component
    const [{ canDrop, isOver }, drop] = useDrop(() => ({
        // accept: Specifies the type(s) of items this drop target can accept.
        // Must match the 'type' in useDrag.
        accept: ItemTypes.BOX,
        // drop: Called when a compatible item is dropped onto the target.
        // (item, monitor) => { ... }
        // 'item' is the object defined in the 'item' property of useDrag.
        drop: (item, monitor) => {
            console.log('Dropped item:', item);
            setLastDroppedItem(item); // Update state with the dropped item's data
            // You can return an object here to make it available via monitor.getDropResult() in useDrag's 'end' function
            return { name: 'Dustbin' };
        },
        // collect: Collects props from the monitor.
        collect: (monitor) => ({
            isOver: monitor.isOver(), // isOver is true if a compatible item is hovering over this target
            canDrop: monitor.canDrop(), // canDrop is true if an item is being dragged and is compatible
        }),
    }));

    // Determine background color based on drop state
    const isActive = canDrop && isOver;
    let backgroundColor = '#222';
    if (isActive) {
        backgroundColor = 'darkgreen';
    } else if (canDrop) {
        backgroundColor = 'darkkhaki';
    }

    // Attach the drop ref to the DOM element you want to make a drop target
    return (
        <div ref={drop} style={{ ...style, backgroundColor }} data-testid="dustbin">
            {isActive ? 'Release to drop' : 'Drag a box here'}

            {lastDroppedItem && (
                <p style={{ marginTop: '1rem', color: 'yellow' }}>
                    Last dropped: {lastDroppedItem.name}
                </p>
            )}
        </div>
    );
}

export default Dustbin;