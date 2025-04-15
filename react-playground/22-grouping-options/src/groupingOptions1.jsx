import React from "react";

const startDatePurchaseBehavior = [
    {
        text: "1 week",
        value: 7,
        optgroup: "Group 1"
    },
    {
        text: "2 weeks",
        value: 14,
        optgroup: "Group 1"
    },
    {
        text: "1 Month",
        value: 30,
        optgroup: "Group 1"
    },
    {
        text: "2 Months",
        value: 60,
        optgroup: "Group 1"
    },
    {
        text: "3 Months",
        value: 90,
        optgroup: "Group 1"
    },
    {
        text: "4 Months",
        value: 120
    },
    {
        text: "5 Months",
        value: 150
    },
    {
        text: "6 Months",
        value: 180
    },
    {
        text: "7 Months",
        value: 210
    },
    {
        text: "8 Months",
        value: 240
    },
    {
        text: "9 Months",
        value: 270
    },
    {
        text: "10 Months",
        value: 300
    },
    {
        text: "11 Months",
        value: 330
    },
    {
        text: "12 Months",
        value: 360
    }
];

const groupedOptions = {};
startDatePurchaseBehavior.forEach(option => {
    if (!groupedOptions[option.optgroup]) groupedOptions[option.optgroup] = [];
    groupedOptions[option.optgroup].push({
        value: option.value,
        text: option.text
    });
});

const renderOptions = options => {
    return options.map(option => {
        return (
            <option id="cars" key={option.value} value={option.value}>
                {option.text}
            </option>
        );
    });
};

function GroupingOptions1() {
    return (
        <div>
            Create a Grouping in drop-down list
            <select name="cars" id="cars">
                {Object.keys(groupedOptions).map((group, index) => {
                    return (
                        <optgroup key={index} label={group}>
                            {renderOptions(groupedOptions[group])}
                        </optgroup>
                    );
                })}
            </select>{" "}
        </div>
    );
}

export default GroupingOptions1;