import './App.css'

import React from 'react';
import {DndProvider} from 'react-dnd';
import {HTML5Backend} from 'react-dnd-html5-backend';
import Box from './Box';
import Dustbin from './Dustbin';
import './App.css';

function App() {

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

export default App;


