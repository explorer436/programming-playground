import React from 'react';
import { useDrag } from 'react-dnd';

const Box = () => {
    const [{ isDragging }, drag] = useDrag({
        type: 'BOX',
        item: { name: 'box' },
        collect: (monitor) => ({
            isDragging: monitor.isDragging(),
        }),
    });

    return (
        <div
            ref={drag}
            style={{
                opacity: isDragging ? 0.5 : 1,
                border: '1px dashed gray',
                backgroundColor: 'white',
                padding: '0.5rem 1rem',
                margin: '0.5rem',
                cursor: 'move',
            }}
        >
            Drag me!
        </div>
    );
};

export default Box;