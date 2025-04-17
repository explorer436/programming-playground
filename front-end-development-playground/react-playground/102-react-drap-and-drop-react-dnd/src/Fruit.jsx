// Draggable Item Component

import React from 'react';
import { useDrag } from 'react-dnd';
import { ItemTypes } from './ItemTypes';

const style = {
    border: '1px dashed gray',
    backgroundColor: 'white',
    padding: '0.5rem 1rem',
    margin: '0.5rem',
    cursor: 'move',
    display: 'inline-block', // Keep fruits somewhat inline
};

function Fruit({ name, currentGroupKey }) {
    const [{ isDragging }, drag] = useDrag(() => ({
        type: ItemTypes.FRUIT,
        // 'item' now includes the fruit's name AND its current location (groupKey)
        // This is crucial for the drop handler to know where the fruit came from.
        item: { name, sourceGroupKey: currentGroupKey },
        collect: (monitor) => ({
            isDragging: monitor.isDragging(),
        }),
        // Optional: end(item, monitor) can be useful if the drop fails
        // end: (item, monitor) => {
        //   if (!monitor.didDrop()) {
        //     console.log(`Fruit ${item.name} drag ended outside a target`);
        //   }
        // }
    }));

    const opacity = isDragging ? 0.4 : 1;

    return (
        <div ref={drag} style={{ ...style, opacity }} data-testid={`fruit-${name}`}>
            {name}
        </div>
    );
}

export default Fruit;