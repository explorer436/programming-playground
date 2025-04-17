import React from 'react';
import { useDrop } from 'react-dnd';

const Target = () => {
    const [{ isOver }, drop] = useDrop({
        accept: 'BOX',
        drop: () => console.log('Dropped!'),
        collect: (monitor) => ({
            isOver: monitor.isOver(),
        }),
    });

    return (
        <div
            ref={drop}
            style={{
                backgroundColor: isOver ? 'lightgreen' : 'white',
                padding: '0.5rem 1rem',
                margin: '0.5rem',
                width: '200px',
                height: '100px',
                border: '1px solid black',
            }}
        >
            {isOver ? 'Release to Drop' : 'Drag here'}
        </div>
    );
};

export default Target;