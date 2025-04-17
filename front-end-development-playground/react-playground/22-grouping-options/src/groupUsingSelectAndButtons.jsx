import {useState} from "react";

function GroupUsingSelectAndButtons() {

    const initialItems = [
        {'id': '1', name: 'Apple'},
        {'id': '2', name: 'Banana'},
        {'id': '3', name: 'Orange'},
        {'id': '4', name: 'Grapes'},
    ]

    const [groupedItems, setGroupedItems] = useState({
        Ungrouped: initialItems.map((item) => item.id),
        GroupA: [],
        GroupB: [],
    })

    const handleGroupChange = (itemId, newGroup) => {

        // Find the item in the current groups and remove it
        let oldGroup = null;
        let itemIdToRemove = null;
        for (const group in groupedItems) {
            if (groupedItems[group].includes(itemId)) {
                oldGroup = group;
                itemIdToRemove = itemId;
                break;
            }
        }

        const newGroupedItems = {...groupedItems};

        if (oldGroup) {
            newGroupedItems[oldGroup] = groupedItems[oldGroup].filter((id) => id !== itemIdToRemove);
        }

        // Add the item to the new group
        newGroupedItems[newGroup] = [...newGroupedItems[newGroup], itemId];
        setGroupedItems(newGroupedItems);
    }

    const getItemById = (id) => {
        return initialItems.find(item => item.id === id);
    }

    return (
        <div>
            {initialItems.map((item) => (
                <div key={item.id}>
                    {item.name}
                    <select
                        value={Object.keys(groupedItems).find(group => groupedItems[group].includes(item.id)) || 'Ungrouped'}
                        onChange={(e) => handleGroupChange(item.id, e.target.value)}
                    >
                        <option value="Ungrouped">Ungrouped</option>
                        <option value="GroupA">GroupA</option>
                        <option value="GroupB">GroupB</option>
                    </select>
                </div>
            ))}

            <h2>Grouped Items</h2>
            {Object.keys(groupedItems).map((groupName) => (
                <div key={groupName}>
                    <h3>{groupName}</h3>
                    <ul>
                        {groupedItems[groupName].map(itemId => {
                                const item = getItemById(itemId);
                                return (
                                    item && <li key={itemId}>{item.name}</li>
                                );
                        })}
                    </ul>
                </div>
            ))}
        </div>
    )
}

export default GroupUsingSelectAndButtons;