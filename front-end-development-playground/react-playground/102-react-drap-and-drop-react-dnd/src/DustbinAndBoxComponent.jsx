import {DndProvider} from "react-dnd";
import {HTML5Backend} from "react-dnd-html5-backend";
import Dustbin from "./Dustbin.jsx";
import Box from "./Box.jsx";
import React from "react";

// This approach did not work. DndProvider has to be in App.jsx
function DustbinAndBoxComponent() {

    // Wrap the part of your app that needs D&D capabilities with DndProvider
    // It requires a 'backend' prop (HTML5Backend is standard for web)

    return <DndProvider backend={HTML5Backend}>
        <div className="App">
            <h1>React DnD Simple Example</h1>
            <div style={{overflow: "hidden", clear: "both", marginBottom: "1.5rem"}}>
                {/* Render the Dustbin (Drop Target) */}
                <Dustbin/>
            </div>
            <div style={{overflow: "hidden", clear: "both"}}>
                {/* Render some Draggable Boxes */}
                <Box name="Glass"/>
                <Box name="Banana"/>
                <Box name="Paper"/>
            </div>
        </div>
    </DndProvider>;
}