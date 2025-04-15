import React, { useState } from "react";
import Picture from "./picture";
import {DndProvider, useDrop} from "react-dnd";
import "./App.css";
import { HTML5Backend } from "react-dnd-html5-backend";

const PictureList = [
    {
        id: 1,
        url:
            "https://www.course-api.com/images/people/person-1.jpeg",
    },
    {
        id: 2,
        url:
            "https://www.course-api.com/images/people/person-2.jpeg",
    },
    {
        id: 3,
        url:
            "https://www.course-api.com/images/people/person-3.jpeg",
    },
];

function DragDrop() {

    const [board, setBoard] = useState([]);

    const [{ isOver }, drop] = useDrop(() => ({
        accept: "image",
        drop: (item) => addImageToBoard(item.id),
        collect: (monitor) => ({
            isOver: !!monitor.isOver(),
        }),
    }));

    const addImageToBoard = (id) => {
        const pictureList = PictureList.filter((picture) => id === picture.id);
        setBoard((board) => [...board, pictureList[0]]);
    };

    return (

            <DndProvider backend={HTML5Backend}>
            
            <div className="Pictures">
                {PictureList.map((picture) => {
                    return <Picture url={picture.url} id={picture.id} />;
                })}
            </div>
            <div className="Board" ref={drop}>
                {board.map((picture) => {
                    return <Picture url={picture.url} id={picture.id} />;
                })}
            </div>
    </DndProvider>

    );
}

export default DragDrop;