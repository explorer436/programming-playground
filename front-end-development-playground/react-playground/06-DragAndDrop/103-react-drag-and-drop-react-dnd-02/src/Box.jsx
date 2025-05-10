// Draggable Item Component

import React from 'react';
import { useDrag } from 'react-dnd';
import { ItemTypes } from './ItemTypes';

const style = {
    border: '1px dashed gray',
    backgroundColor: 'white',
    padding: '0.5rem 1rem',
    marginRight: '1.5rem',
    marginBottom: '1.5rem',
    cursor: 'move',
    float: 'left', // To make them appear side-by-side initially
};

function Box({ name }) {
    // useDrag hook exposes properties for the draggable component
    const [{ isDragging }, drag] = useDrag(() => ({
        // type: Specifies the type of item being dragged. Must match the 'accept' type in useDrop.
        type: ItemTypes.BOX,
        // item: A function or object describing the data being dragged.
        // This data is available to the drop target via the monitor.getItem() method.
        item: { name }, // We pass the name of the box as the dragged item data
        // end: Optional. Called when dragging stops.
        // (item, monitor) => { ... }
        // collect: A function that collects props from the monitor.
        // The collected props are merged into the component's props.
        collect: (monitor) => ({
            isDragging: monitor.isDragging(), // isDragging is true if this specific item is being dragged
            // didDrop: monitor.didDrop(), // Useful if you need to know if a drop occurred on *any* compatible target
        }),
    }));

    // Apply dynamic style based on dragging state
    const opacity = isDragging ? 0.4 : 1;

    // Attach the drag ref to the DOM element you want to make draggable
    return (
        <div ref={drag} style={{ ...style, opacity }} data-testid={`box-${name}`}>
            {name}
        </div>
    );
}

export default Box;