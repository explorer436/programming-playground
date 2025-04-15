const data = {
    field1: 'value1',
    field2: 'value2',
    field3: 'value3',
    field4: 'value4',
};

const fieldsToJoin = ['field1', 'field2', 'field3'];
const connector = 'and'; // or 'or'

const renderJoinedFields = (fields, conn) => {
    if (!fields || fields.length === 0) {
        return null;
    }

    return fields.map((field, index) => {
        if (index === fields.length - 1) {
            return <span key={field}>{data[field]}</span>;
        } else if (index === fields.length - 2) {
            return (
                <span key={field}>
	  {data[field]} {conn}{' '}
	</span>
            );
        } else {
            return (
                <span key={field}>
	  {data[field]},
	</span>
            );
        }
    });
};

const joinedFields = renderJoinedFields(fieldsToJoin, connector);

function RenderJoinedFields() {
    return <div>Joined fields: {joinedFields}</div>;
}

export default RenderJoinedFields;